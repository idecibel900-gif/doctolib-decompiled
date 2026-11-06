package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DiskCachesStoreFactory implements Supplier {
    private final Lazy diskCachesStore$delegate;
    private final Map dynamicDiskCacheConfigMap;
    private final ExecutorSupplier executorSupplier;
    private final FileCacheFactory fileCacheFactory;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final DiskCacheConfig mainDiskCacheConfig;
    private final int memoryChunkType;
    private final PoolFactory poolFactory;
    private final DiskCacheConfig smallImageDiskCacheConfig;

    public DiskCachesStoreFactory(FileCacheFactory fileCacheFactory, PoolFactory poolFactory, ExecutorSupplier executorSupplier, ImageCacheStatsTracker imageCacheStatsTracker, int i, DiskCacheConfig mainDiskCacheConfig, DiskCacheConfig smallImageDiskCacheConfig, Map map) {
        Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        Intrinsics.checkNotNullParameter(mainDiskCacheConfig, "mainDiskCacheConfig");
        Intrinsics.checkNotNullParameter(smallImageDiskCacheConfig, "smallImageDiskCacheConfig");
        this.fileCacheFactory = fileCacheFactory;
        this.poolFactory = poolFactory;
        this.executorSupplier = executorSupplier;
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.memoryChunkType = i;
        this.mainDiskCacheConfig = mainDiskCacheConfig;
        this.smallImageDiskCacheConfig = smallImageDiskCacheConfig;
        this.dynamicDiskCacheConfigMap = map;
        this.diskCachesStore$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imagepipeline.core.DiskCachesStoreFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiskCachesStoreFactory.diskCachesStore_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskCachesStoreFactory(FileCacheFactory fileCacheFactory, ImagePipelineConfigInterface config) {
        this(fileCacheFactory, config.getPoolFactory(), config.getExecutorSupplier(), config.getImageCacheStatsTracker(), config.getMemoryChunkType(), config.getMainDiskCacheConfig(), config.getSmallImageDiskCacheConfig(), config.getDynamicDiskCacheConfigMap());
        Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    private final DiskCachesStore getDiskCachesStore() {
        return (DiskCachesStore) this.diskCachesStore$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiskCachesStoreFactory$diskCachesStore$2$1 diskCachesStore_delegate$lambda$0(DiskCachesStoreFactory this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new DiskCachesStoreFactory$diskCachesStore$2$1(this$0);
    }

    @Override // com.facebook.common.internal.Supplier
    public DiskCachesStore get() {
        return getDiskCachesStore();
    }
}
