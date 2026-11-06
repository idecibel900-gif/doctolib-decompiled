package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LruCountingMemoryCache implements CountingMemoryCache, MemoryCache {
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap mCachedEntries;
    final CountingLruMap mExclusiveEntries;
    private final boolean mIgnoreSizeMismatch;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier mMemoryCacheParamsSupplier;
    private final boolean mStoreEntrySize;
    private final ValueDescriptor mValueDescriptor;
    final Map mOtherEntries = new WeakHashMap();
    private long mLastCacheParamsCheck = SystemClock.uptimeMillis();

    private static void maybeNotifyExclusiveEntryInsertion(CountingMemoryCache.Entry entry) {
    }

    private static void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry entry) {
    }

    public LruCountingMemoryCache(ValueDescriptor valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier supplier, CountingMemoryCache.EntryStateObserver entryStateObserver, boolean z, boolean z2) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull((MemoryCacheParams) supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mStoreEntrySize = z;
        this.mIgnoreSizeMismatch = z2;
    }

    private ValueDescriptor wrapValueDescriptor(final ValueDescriptor valueDescriptor) {
        return new ValueDescriptor() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(CountingMemoryCache.Entry entry) {
                if (LruCountingMemoryCache.this.mStoreEntrySize) {
                    return entry.size;
                }
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference cache(Object obj, CloseableReference closeableReference) {
        return cache(obj, closeableReference, null);
    }

    public CloseableReference cache(Object obj, CloseableReference closeableReference, CountingMemoryCache.EntryStateObserver entryStateObserver) {
        CountingMemoryCache.Entry entry;
        CloseableReference closeableReferenceNewClientReference;
        CloseableReference closeableReferenceReferenceToClose;
        CountingMemoryCache.Entry entryOf;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.mExclusiveEntries.remove(obj);
                CountingMemoryCache.Entry entry2 = (CountingMemoryCache.Entry) this.mCachedEntries.remove(obj);
                closeableReferenceNewClientReference = null;
                if (entry2 != null) {
                    makeOrphan(entry2);
                    closeableReferenceReferenceToClose = referenceToClose(entry2);
                } else {
                    closeableReferenceReferenceToClose = null;
                }
                int sizeInBytes = this.mValueDescriptor.getSizeInBytes(closeableReference.get());
                if (canCacheNewValueOfSize(sizeInBytes)) {
                    if (this.mStoreEntrySize) {
                        entryOf = CountingMemoryCache.Entry.of(obj, closeableReference, sizeInBytes, entryStateObserver);
                    } else {
                        entryOf = CountingMemoryCache.Entry.of(obj, closeableReference, entryStateObserver);
                    }
                    this.mCachedEntries.put(obj, entryOf);
                    closeableReferenceNewClientReference = newClientReference(entryOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        CloseableReference.closeSafely(closeableReferenceReferenceToClose);
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    private synchronized boolean canCacheNewValueOfSize(int i) {
        boolean z;
        if (i <= this.mMemoryCacheParams.maxCacheEntrySize) {
            z = getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1 && getInUseSizeInBytes() <= this.mMemoryCacheParams.maxCacheSize - i;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference get(Object obj) {
        CountingMemoryCache.Entry entry;
        CloseableReference closeableReferenceNewClientReference;
        Preconditions.checkNotNull(obj);
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.mExclusiveEntries.remove(obj);
                CountingMemoryCache.Entry entry2 = (CountingMemoryCache.Entry) this.mCachedEntries.get(obj);
                closeableReferenceNewClientReference = entry2 != null ? newClientReference(entry2) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(Object obj) {
        Preconditions.checkNotNull(obj);
        synchronized (this) {
            try {
                CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) this.mExclusiveEntries.remove(obj);
                if (entry != null) {
                    this.mExclusiveEntries.put(obj, entry);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized CloseableReference newClientReference(final CountingMemoryCache.Entry entry) {
        increaseClientCount(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Object obj) {
                LruCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(CountingMemoryCache.Entry entry) {
        boolean zMaybeAddToExclusives;
        CloseableReference closeableReferenceReferenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            zMaybeAddToExclusives = maybeAddToExclusives(entry);
            closeableReferenceReferenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely(closeableReferenceReferenceToClose);
        if (!zMaybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(CountingMemoryCache.Entry entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate predicate) {
        ArrayList arrayListRemoveAll;
        ArrayList arrayListRemoveAll2;
        synchronized (this) {
            arrayListRemoveAll = this.mExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(arrayListRemoveAll2);
        }
        maybeClose(arrayListRemoveAll2);
        maybeNotifyExclusiveEntryRemoval(arrayListRemoveAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayListRemoveAll2.size();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > SystemClock.uptimeMillis()) {
            return;
        }
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull((MemoryCacheParams) this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
    }

    public void maybeEvictEntries() {
        ArrayList arrayListTrimExclusivelyOwnedEntries;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int iMin = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(iMin, Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(arrayListTrimExclusivelyOwnedEntries);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(arrayListTrimExclusivelyOwnedEntries);
    }

    private synchronized ArrayList trimExclusivelyOwnedEntries(int i, int i2) {
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
                break;
            }
            Object firstKey = this.mExclusiveEntries.getFirstKey();
            if (firstKey == null) {
                if (this.mIgnoreSizeMismatch) {
                    this.mExclusiveEntries.resetSize();
                    break;
                }
                throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", Integer.valueOf(this.mExclusiveEntries.getCount()), Integer.valueOf(this.mExclusiveEntries.getSizeInBytes())));
            }
            this.mExclusiveEntries.remove(firstKey);
            arrayList.add((CountingMemoryCache.Entry) this.mCachedEntries.remove(firstKey));
        }
        return arrayList;
    }

    private void maybeClose(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely(referenceToClose((CountingMemoryCache.Entry) it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval((CountingMemoryCache.Entry) it.next());
            }
        }
    }

    private synchronized void makeOrphans(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan((CountingMemoryCache.Entry) it.next());
            }
        }
    }

    private synchronized void makeOrphan(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.isOrphan = true;
    }

    private synchronized void increaseClientCount(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
    }

    private synchronized void decreaseClientCount(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    private synchronized CloseableReference referenceToClose(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        return (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }
}
