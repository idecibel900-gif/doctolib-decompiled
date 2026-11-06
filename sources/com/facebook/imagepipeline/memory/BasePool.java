package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool implements Pool {
    private final Class TAG;
    private boolean mAllowNewBuckets;
    final SparseArray mBuckets;
    final Counter mFree;
    private boolean mIgnoreHardCap;
    final Set mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    final Counter mUsed;

    protected abstract Object alloc(int i);

    protected abstract void free(Object obj);

    protected abstract int getBucketedSize(int i);

    protected abstract int getBucketedSizeForValue(Object obj);

    protected abstract int getSizeInBytes(int i);

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        PoolParams poolParams2 = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolParams = poolParams2;
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray();
        if (poolParams2.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(0));
        }
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.mIgnoreHardCap = z;
    }

    protected void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    protected synchronized Object getValue(Bucket bucket) {
        return bucket.get();
    }

    @Override // com.facebook.common.memory.Pool
    public Object get(int i) throws Throwable {
        Object objAlloc;
        Object value;
        ensurePoolSizeInvariant();
        int bucketedSize = getBucketedSize(i);
        synchronized (this) {
            try {
                Bucket bucket = getBucket(bucketedSize);
                if (bucket != null && (value = getValue(bucket)) != null) {
                    Preconditions.checkState(this.mInUseValues.add(value));
                    int bucketedSizeForValue = getBucketedSizeForValue(value);
                    int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
                    this.mUsed.increment(sizeInBytes);
                    this.mFree.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onValueReuse(sizeInBytes);
                    logStats();
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                    }
                    return value;
                }
                int sizeInBytes2 = getSizeInBytes(bucketedSize);
                if (!canAllocate(sizeInBytes2)) {
                    throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, sizeInBytes2);
                }
                this.mUsed.increment(sizeInBytes2);
                if (bucket != null) {
                    bucket.incrementInUseCount();
                }
                try {
                    objAlloc = alloc(bucketedSize);
                } catch (Throwable th) {
                    synchronized (this) {
                        try {
                            this.mUsed.decrement(sizeInBytes2);
                            Bucket bucket2 = getBucket(bucketedSize);
                            if (bucket2 != null) {
                                bucket2.decrementInUseCount();
                            }
                            Throwables.propagateIfPossible(th);
                            objAlloc = null;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                synchronized (this) {
                    try {
                        Preconditions.checkState(this.mInUseValues.add(objAlloc));
                        trimToSoftCap();
                        this.mPoolStatsTracker.onAlloc(sizeInBytes2);
                        logStats();
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(objAlloc)), Integer.valueOf(bucketedSize));
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return objAlloc;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Object obj) {
        Preconditions.checkNotNull(obj);
        int bucketedSizeForValue = getBucketedSizeForValue(obj);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            try {
                Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
                if (!this.mInUseValues.remove(obj)) {
                    FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(bucketedSizeForValue));
                    free(obj);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                } else if (bucketIfPresent == null || bucketIfPresent.isMaxLengthExceeded() || isMaxSizeSoftCapExceeded() || !isReusable(obj)) {
                    if (bucketIfPresent != null) {
                        bucketIfPresent.decrementInUseCount();
                    }
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(bucketedSizeForValue));
                    }
                    free(obj);
                    this.mUsed.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                } else {
                    bucketIfPresent.release(obj);
                    this.mFree.increment(sizeInBytes);
                    this.mUsed.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(bucketedSizeForValue));
                    }
                }
                logStats();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected boolean isReusable(Object obj) {
        Preconditions.checkNotNull(obj);
        return true;
    }

    private synchronized void ensurePoolSizeInvariant() {
        try {
            Preconditions.checkState(!isMaxSizeSoftCapExceeded() || this.mFree.mNumBytes == 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        try {
            Preconditions.checkNotNull(sparseIntArray);
            this.mBuckets.clear();
            SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int iKeyAt = sparseIntArray2.keyAt(i);
                    this.mBuckets.put(iKeyAt, new Bucket(getSizeInBytes(iKeyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(iKeyAt, 0), this.mPoolParams.fixBucketsReinitialization));
                }
                this.mAllowNewBuckets = false;
            } else {
                this.mAllowNewBuckets = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void initBuckets() {
        try {
            SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
            if (sparseIntArray != null) {
                fillBuckets(sparseIntArray);
                this.mAllowNewBuckets = false;
            } else {
                this.mAllowNewBuckets = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int iKeyAt = sparseIntArray.keyAt(i);
            this.mBuckets.put(iKeyAt, new Bucket(getSizeInBytes(iKeyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    synchronized void trimToSize(int i) {
        try {
            int i2 = this.mUsed.mNumBytes;
            int i3 = this.mFree.mNumBytes;
            int iMin = Math.min((i2 + i3) - i, i3);
            if (iMin <= 0) {
                return;
            }
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(iMin));
            }
            logStats();
            for (int i4 = 0; i4 < this.mBuckets.size() && iMin > 0; i4++) {
                Bucket bucket = (Bucket) Preconditions.checkNotNull((Bucket) this.mBuckets.valueAt(i4));
                while (iMin > 0) {
                    Object objPop = bucket.pop();
                    if (objPop == null) {
                        break;
                    }
                    free(objPop);
                    int i5 = bucket.mItemSize;
                    iMin -= i5;
                    this.mFree.decrement(i5);
                }
            }
            logStats();
            if (FLog.isLoggable(2)) {
                FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized Bucket getBucketIfPresent(int i) {
        return (Bucket) this.mBuckets.get(i);
    }

    synchronized Bucket getBucket(int i) {
        try {
            Bucket bucket = (Bucket) this.mBuckets.get(i);
            if (bucket == null && this.mAllowNewBuckets) {
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(i));
                }
                Bucket bucketNewBucket = newBucket(i);
                this.mBuckets.put(i, bucketNewBucket);
                return bucketNewBucket;
            }
            return bucket;
        } catch (Throwable th) {
            throw th;
        }
    }

    Bucket newBucket(int i) {
        return new Bucket(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    synchronized boolean canAllocate(int i) {
        if (this.mIgnoreHardCap) {
            return true;
        }
        PoolParams poolParams = this.mPoolParams;
        int i2 = poolParams.maxSizeHardCap;
        int i3 = this.mUsed.mNumBytes;
        if (i > i2 - i3) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i4 = poolParams.maxSizeSoftCap;
        if (i > i4 - (i3 + this.mFree.mNumBytes)) {
            trimToSize(i4 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    static class Counter {
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void decrement(int i) {
            int i2;
            int i3 = this.mNumBytes;
            if (i3 >= i && (i2 = this.mCount) > 0) {
                this.mCount = i2 - 1;
                this.mNumBytes = i3 - i;
            } else {
                FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
            }
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
