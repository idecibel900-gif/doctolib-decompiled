package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BufferedDiskCache {
    public static final Companion Companion = new Companion(null);
    private static final Class TAG = BufferedDiskCache.class;
    private final FileCache fileCache;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final PooledByteBufferFactory pooledByteBufferFactory;
    private final PooledByteStreams pooledByteStreams;
    private final Executor readExecutor;
    private final StagingArea stagingArea;
    private final Executor writeExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor readExecutor, Executor writeExecutor, ImageCacheStatsTracker imageCacheStatsTracker) {
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        Intrinsics.checkNotNullParameter(readExecutor, "readExecutor");
        Intrinsics.checkNotNullParameter(writeExecutor, "writeExecutor");
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        this.fileCache = fileCache;
        this.pooledByteBufferFactory = pooledByteBufferFactory;
        this.pooledByteStreams = pooledByteStreams;
        this.readExecutor = readExecutor;
        this.writeExecutor = writeExecutor;
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        StagingArea stagingArea = StagingArea.getInstance();
        Intrinsics.checkNotNullExpressionValue(stagingArea, "getInstance(...)");
        this.stagingArea = stagingArea;
    }

    public final Task get(CacheKey key, AtomicBoolean isCancelled) {
        Task async;
        Task taskFoundPinnedImage;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isCancelled, "isCancelled");
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("BufferedDiskCache#get");
            try {
                EncodedImage encodedImage = this.stagingArea.get(key);
                if (encodedImage == null || (async = foundPinnedImage(key, encodedImage)) == null) {
                    async = getAsync(key, isCancelled);
                }
                return async;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        EncodedImage encodedImage2 = this.stagingArea.get(key);
        return (encodedImage2 == null || (taskFoundPinnedImage = foundPinnedImage(key, encodedImage2)) == null) ? getAsync(key, isCancelled) : taskFoundPinnedImage;
    }

    public final void put(final CacheKey key, EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (!FrescoSystrace.isTracing()) {
            if (!EncodedImage.isValid(encodedImage)) {
                throw new IllegalStateException("Check failed.");
            }
            this.stagingArea.put(key, encodedImage);
            final EncodedImage encodedImageCloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork, this, key, encodedImageCloneOrNull);
                    }
                });
                return;
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", key.getUriString());
                this.stagingArea.remove(key, encodedImage);
                EncodedImage.closeSafely(encodedImageCloneOrNull);
                return;
            }
        }
        FrescoSystrace.beginSection("BufferedDiskCache#put");
        try {
            if (!EncodedImage.isValid(encodedImage)) {
                throw new IllegalStateException("Check failed.");
            }
            this.stagingArea.put(key, encodedImage);
            final EncodedImage encodedImageCloneOrNull2 = EncodedImage.cloneOrNull(encodedImage);
            try {
                final Object objOnBeforeSubmitWork2 = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork2, this, key, encodedImageCloneOrNull2);
                    }
                });
            } catch (Exception e2) {
                FLog.w(TAG, e2, "Failed to schedule disk-cache write for %s", key.getUriString());
                this.stagingArea.remove(key, encodedImage);
                EncodedImage.closeSafely(encodedImageCloneOrNull2);
            }
            Unit unit = Unit.INSTANCE;
            FrescoSystrace.endSection();
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public final boolean containsSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.stagingArea.containsKey(key) || this.fileCache.hasKeySync(key);
    }

    public final boolean diskCheckSync(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(key);
    }

    public final void addKeyForAsyncProbing(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.fileCache.probe(key);
    }

    private final boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.stagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            this.imageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
        this.imageCacheStatsTracker.onStagingAreaMiss(cacheKey);
        try {
            return this.fileCache.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private final Task getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            return Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.getAsync$lambda$4(objOnBeforeSubmitWork, atomicBoolean, this, cacheKey);
                }
            }, this.readExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EncodedImage getAsync$lambda$4(Object obj, AtomicBoolean isCancelled, BufferedDiskCache this$0, CacheKey key) {
        Intrinsics.checkNotNullParameter(isCancelled, "$isCancelled");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            if (isCancelled.get()) {
                throw new CancellationException();
            }
            EncodedImage encodedImage = this$0.stagingArea.get(key);
            if (encodedImage != null) {
                FLog.v(TAG, "Found image for %s in staging area", key.getUriString());
                this$0.imageCacheStatsTracker.onStagingAreaHit(key);
            } else {
                FLog.v(TAG, "Did not find image for %s in staging area", key.getUriString());
                this$0.imageCacheStatsTracker.onStagingAreaMiss(key);
                try {
                    PooledByteBuffer fromDiskCache = this$0.readFromDiskCache(key);
                    if (fromDiskCache == null) {
                        FrescoInstrumenter.onEndWork(objOnBeginWork);
                        return null;
                    }
                    CloseableReference closeableReferenceOf = CloseableReference.of(fromDiskCache);
                    Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
                    try {
                        EncodedImage encodedImage2 = new EncodedImage(closeableReferenceOf);
                        CloseableReference.closeSafely(closeableReferenceOf);
                        encodedImage = encodedImage2;
                    } catch (Throwable th) {
                        CloseableReference.closeSafely(closeableReferenceOf);
                        throw th;
                    }
                } catch (Exception unused) {
                    FrescoInstrumenter.onEndWork(objOnBeginWork);
                    return null;
                }
            }
            if (!Thread.interrupted()) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                return encodedImage;
            }
            FLog.v(TAG, "Host thread was interrupted, decreasing reference count");
            encodedImage.close();
            throw new InterruptedException();
        } catch (Throwable th2) {
            try {
                FrescoInstrumenter.markFailure(obj, th2);
                throw th2;
            } catch (Throwable th3) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void put$lambda$6$lambda$5(Object obj, BufferedDiskCache this$0, CacheKey key, EncodedImage encodedImage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.writeToDiskCache(key, encodedImage);
            StagingArea stagingArea = this$0.stagingArea;
            Intrinsics.checkNotNull(encodedImage);
            stagingArea.remove(key, encodedImage);
            EncodedImage.closeSafely(encodedImage);
            FrescoInstrumenter.onEndWork(objOnBeginWork);
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                StagingArea stagingArea2 = this$0.stagingArea;
                Intrinsics.checkNotNull(encodedImage);
                stagingArea2.remove(key, encodedImage);
                EncodedImage.closeSafely(encodedImage);
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final Task remove(final CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.stagingArea.remove(key);
        try {
            final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
            return Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.remove$lambda$7(objOnBeforeSubmitWork, this, key);
                }
            }, this.writeExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", key.getUriString());
            return Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void remove$lambda$7(Object obj, BufferedDiskCache this$0, CacheKey key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.stagingArea.remove(key);
            this$0.fileCache.remove(key);
            FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final Task clearAll() {
        this.stagingArea.clearAll();
        final Object objOnBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            return Task.call(new Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BufferedDiskCache.clearAll$lambda$8(objOnBeforeSubmitWork, this);
                }
            }, this.writeExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void clearAll$lambda$8(Object obj, BufferedDiskCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object objOnBeginWork = FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.stagingArea.clearAll();
            this$0.fileCache.clearAll();
            FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (Throwable th) {
            try {
                FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (Throwable th2) {
                FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    private final Task foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.imageCacheStatsTracker.onStagingAreaHit(cacheKey);
        Task taskForResult = Task.forResult(encodedImage);
        Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
        return taskForResult;
    }

    private final PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        try {
            Class cls = TAG;
            FLog.v(cls, "Disk cache read for %s", cacheKey.getUriString());
            BinaryResource resource = this.fileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.imageCacheStatsTracker.onDiskCacheMiss(cacheKey);
                return null;
            }
            FLog.v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.imageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream inputStreamOpenStream = resource.openStream();
            try {
                PooledByteBuffer pooledByteBufferNewByteBuffer = this.pooledByteBufferFactory.newByteBuffer(inputStreamOpenStream, (int) resource.size());
                inputStreamOpenStream.close();
                FLog.v(cls, "Successful read from disk cache for %s", cacheKey.getUriString());
                return pooledByteBufferNewByteBuffer;
            } catch (Throwable th) {
                inputStreamOpenStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.imageCacheStatsTracker.onDiskCacheGetFail(cacheKey);
            throw e;
        }
    }

    private final void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        Class cls = TAG;
        FLog.v(cls, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.fileCache.insert(cacheKey, new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda4
                @Override // com.facebook.cache.common.WriterCallback
                public final void write(OutputStream outputStream) {
                    BufferedDiskCache.writeToDiskCache$lambda$9(encodedImage, this, outputStream);
                }
            });
            this.imageCacheStatsTracker.onDiskCachePut(cacheKey);
            FLog.v(cls, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e) {
            FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeToDiskCache$lambda$9(EncodedImage encodedImage, BufferedDiskCache this$0, OutputStream os) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNull(encodedImage);
        InputStream inputStream = encodedImage.getInputStream();
        if (inputStream == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this$0.pooledByteStreams.copy(inputStream, os);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
