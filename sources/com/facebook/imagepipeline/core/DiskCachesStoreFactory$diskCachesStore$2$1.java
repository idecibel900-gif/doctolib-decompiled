package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DiskCachesStoreFactory$diskCachesStore$2$1 implements DiskCachesStore {
    private final Lazy dynamicBufferedDiskCaches$delegate;
    private final Lazy dynamicFileCaches$delegate;
    private final Lazy mainBufferedDiskCache$delegate;
    private final Lazy mainFileCache$delegate;
    private final Lazy smallImageBufferedDiskCache$delegate;
    private final Lazy smallImageFileCache$delegate;

    DiskCachesStoreFactory$diskCachesStore$2$1(final DiskCachesStoreFactory diskCachesStoreFactory) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.mainFileCache$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.mainFileCache_delegate$lambda$0(diskCachesStoreFactory);
            }
        });
        this.mainBufferedDiskCache$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.mainBufferedDiskCache_delegate$lambda$1(this.f$0, diskCachesStoreFactory);
            }
        });
        this.smallImageFileCache$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.smallImageFileCache_delegate$lambda$2(diskCachesStoreFactory);
            }
        });
        this.smallImageBufferedDiskCache$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.smallImageBufferedDiskCache_delegate$lambda$3(this.f$0, diskCachesStoreFactory);
            }
        });
        this.dynamicFileCaches$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicFileCaches_delegate$lambda$7(diskCachesStoreFactory, this);
            }
        });
        this.dynamicBufferedDiskCaches$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$diskCachesStore$2$1$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory$diskCachesStore$2$1.dynamicBufferedDiskCaches_delegate$lambda$9(this.f$0, diskCachesStoreFactory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileCache mainFileCache_delegate$lambda$0(DiskCachesStoreFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.mainDiskCacheConfig);
    }

    public FileCache getMainFileCache() {
        return (FileCache) this.mainFileCache$delegate.getValue();
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getMainBufferedDiskCache() {
        return (BufferedDiskCache) this.mainBufferedDiskCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BufferedDiskCache mainBufferedDiskCache_delegate$lambda$1(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        FileCache mainFileCache = this$0.getMainFileCache();
        PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        Executor executorForLocalStorageRead = this$1.executorSupplier.forLocalStorageRead();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageRead, "forLocalStorageRead(...)");
        Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new BufferedDiskCache(mainFileCache, pooledByteBufferFactory, pooledByteStreams, executorForLocalStorageRead, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    public FileCache getSmallImageFileCache() {
        return (FileCache) this.smallImageFileCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileCache smallImageFileCache_delegate$lambda$2(DiskCachesStoreFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.fileCacheFactory.get(this$0.smallImageDiskCacheConfig);
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public BufferedDiskCache getSmallImageBufferedDiskCache() {
        return (BufferedDiskCache) this.smallImageBufferedDiskCache$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BufferedDiskCache smallImageBufferedDiskCache_delegate$lambda$3(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        FileCache smallImageFileCache = this$0.getSmallImageFileCache();
        PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
        Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
        PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
        Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
        Executor executorForLocalStorageRead = this$1.executorSupplier.forLocalStorageRead();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageRead, "forLocalStorageRead(...)");
        Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
        Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
        return new BufferedDiskCache(smallImageFileCache, pooledByteBufferFactory, pooledByteStreams, executorForLocalStorageRead, executorForLocalStorageWrite, this$1.imageCacheStatsTracker);
    }

    public Map getDynamicFileCaches() {
        return (Map) this.dynamicFileCaches$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map dynamicFileCaches_delegate$lambda$7(DiskCachesStoreFactory this$0, DiskCachesStoreFactory$diskCachesStore$2$1 this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Map map = this$0.dynamicDiskCacheConfigMap;
        if (map == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), this$0.fileCacheFactory.get((DiskCacheConfig) entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.imagepipeline.core.DiskCachesStore
    public ImmutableMap getDynamicBufferedDiskCaches() {
        Object value = this.dynamicBufferedDiskCaches$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImmutableMap) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImmutableMap dynamicBufferedDiskCaches_delegate$lambda$9(DiskCachesStoreFactory$diskCachesStore$2$1 this$0, DiskCachesStoreFactory this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Map dynamicFileCaches = this$0.getDynamicFileCaches();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(dynamicFileCaches.size()));
        for (Map.Entry entry : dynamicFileCaches.entrySet()) {
            Object key = entry.getKey();
            FileCache fileCache = (FileCache) entry.getValue();
            PooledByteBufferFactory pooledByteBufferFactory = this$1.poolFactory.getPooledByteBufferFactory(this$1.memoryChunkType);
            Intrinsics.checkNotNullExpressionValue(pooledByteBufferFactory, "getPooledByteBufferFactory(...)");
            PooledByteStreams pooledByteStreams = this$1.poolFactory.getPooledByteStreams();
            Intrinsics.checkNotNullExpressionValue(pooledByteStreams, "getPooledByteStreams(...)");
            Executor executorForLocalStorageRead = this$1.executorSupplier.forLocalStorageRead();
            Intrinsics.checkNotNullExpressionValue(executorForLocalStorageRead, "forLocalStorageRead(...)");
            Executor executorForLocalStorageWrite = this$1.executorSupplier.forLocalStorageWrite();
            Intrinsics.checkNotNullExpressionValue(executorForLocalStorageWrite, "forLocalStorageWrite(...)");
            linkedHashMap.put(key, new BufferedDiskCache(fileCache, pooledByteBufferFactory, pooledByteStreams, executorForLocalStorageRead, executorForLocalStorageWrite, this$1.imageCacheStatsTracker));
        }
        return ImmutableMap.copyOf((Map) linkedHashMap);
    }
}
