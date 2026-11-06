package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.adjust.sdk.Constants;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImagePipelineConfig implements ImagePipelineConfigInterface {
    public static final Companion Companion = new Companion(null);
    private static DefaultImageRequestConfig defaultImageRequestConfig = new DefaultImageRequestConfig();
    private final MemoryCache bitmapCacheOverride;
    private final Bitmap.Config bitmapConfig;
    private final BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
    private final Supplier bitmapMemoryCacheParamsSupplier;
    private final MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
    private final CacheKeyFactory cacheKeyFactory;
    private final CloseableReferenceLeakTracker closeableReferenceLeakTracker;
    private final Context context;
    private final Set customProducerSequenceFactories;
    private final Supplier diskCachesStoreSupplier;
    private final DownsampleMode downsampleMode;
    private final Map dynamicDiskCacheConfigMap;
    private final Supplier enableEncodedImageColorSpaceUsage;
    private final MemoryCache encodedMemoryCacheOverride;
    private final Supplier encodedMemoryCacheParamsSupplier;
    private final MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
    private final ExecutorSupplier executorSupplier;
    private final ImagePipelineExperiments experiments;
    private final int httpNetworkTimeout;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final ImageDecoder imageDecoder;
    private final ImageTranscoderFactory imageTranscoderFactory;
    private final Integer imageTranscoderType;
    private final boolean isDiskCacheEnabled;
    private final Supplier isPrefetchEnabledSupplier;
    private final boolean isResizeAndRotateEnabledForNetwork;
    private final DiskCacheConfig mainDiskCacheConfig;
    private final int memoryChunkType;
    private final MemoryTrimmableRegistry memoryTrimmableRegistry;
    private final NetworkFetcher networkFetcher;
    private final PlatformBitmapFactory platformBitmapFactory;
    private final PoolFactory poolFactory;
    private final ProgressiveJpegConfig progressiveJpegConfig;
    private final Set requestListener2s;
    private final Set requestListeners;
    private final DiskCacheConfig smallImageDiskCacheConfig;

    public /* synthetic */ ImagePipelineConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public static final DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return Companion.getDefaultImageRequestConfig();
    }

    public static final Builder newBuilder(Context context) {
        return Companion.newBuilder(context);
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CountingMemoryCache.EntryStateObserver getBitmapMemoryCacheEntryStateObserver() {
        return null;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CallerContextVerifier getCallerContextVerifier() {
        return null;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public SerialExecutorService getExecutorServiceForAnimatedImages() {
        return null;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageDecoderConfig getImageDecoderConfig() {
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
            DiskCacheConfig diskCacheConfigBuild;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
                try {
                    diskCacheConfigBuild = DiskCacheConfig.newBuilder(context).build();
                    FrescoSystrace.endSection();
                } catch (Throwable th) {
                    FrescoSystrace.endSection();
                    throw th;
                }
            } else {
                diskCacheConfigBuild = DiskCacheConfig.newBuilder(context).build();
            }
            Intrinsics.checkNotNullExpressionValue(diskCacheConfigBuild, "traceSection(...)");
            return diskCacheConfigBuild;
        }

        private Companion() {
        }

        public final DefaultImageRequestConfig getDefaultImageRequestConfig() {
            return ImagePipelineConfig.defaultImageRequestConfig;
        }

        public final Builder newBuilder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
            if (builder.getImageTranscoderFactory() == null || builder.getImageTranscoderType() == null) {
                return builder.getImageTranscoderFactory();
            }
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
            Integer memoryChunkType = builder.getMemoryChunkType();
            if (memoryChunkType != null) {
                return memoryChunkType.intValue();
            }
            if (imagePipelineExperiments.getMemoryType() == 2 && Build.VERSION.SDK_INT >= 27) {
                return 2;
            }
            if (imagePipelineExperiments.getMemoryType() == 1) {
                return 1;
            }
            imagePipelineExperiments.getMemoryType();
            return 0;
        }
    }

    private ImagePipelineConfig(Builder builder) {
        NetworkFetcher networkFetcher;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.experiments = builder.getExperimentsBuilder().build();
        Supplier bitmapMemoryCacheParamsSupplier = builder.getBitmapMemoryCacheParamsSupplier();
        if (bitmapMemoryCacheParamsSupplier == null) {
            Object systemService = builder.getContext().getSystemService("activity");
            if (systemService != null) {
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                bitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        this.bitmapMemoryCacheParamsSupplier = bitmapMemoryCacheParamsSupplier;
        MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy = builder.getBitmapMemoryCacheTrimStrategy();
        this.bitmapMemoryCacheTrimStrategy = bitmapMemoryCacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : bitmapMemoryCacheTrimStrategy;
        MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy = builder.getEncodedMemoryCacheTrimStrategy();
        this.encodedMemoryCacheTrimStrategy = encodedMemoryCacheTrimStrategy == null ? new NativeMemoryCacheTrimStrategy() : encodedMemoryCacheTrimStrategy;
        builder.getBitmapMemoryCacheEntryStateObserver();
        Bitmap.Config bitmapConfig = builder.getBitmapConfig();
        this.bitmapConfig = bitmapConfig == null ? Bitmap.Config.ARGB_8888 : bitmapConfig;
        CacheKeyFactory cacheKeyFactory = builder.getCacheKeyFactory();
        if (cacheKeyFactory == null) {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
            Intrinsics.checkNotNullExpressionValue(cacheKeyFactory, "getInstance(...)");
        }
        this.cacheKeyFactory = cacheKeyFactory;
        Context context = builder.getContext();
        if (context == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.context = context;
        this.downsampleMode = builder.getDownsampleMode();
        Supplier encodedMemoryCacheParamsSupplier = builder.getEncodedMemoryCacheParamsSupplier();
        this.encodedMemoryCacheParamsSupplier = encodedMemoryCacheParamsSupplier == null ? new DefaultEncodedMemoryCacheParamsSupplier() : encodedMemoryCacheParamsSupplier;
        ImageCacheStatsTracker imageCacheStatsTracker = builder.getImageCacheStatsTracker();
        if (imageCacheStatsTracker == null) {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
            Intrinsics.checkNotNullExpressionValue(imageCacheStatsTracker, "getInstance(...)");
        }
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.imageDecoder = builder.getImageDecoder();
        Supplier BOOLEAN_FALSE = builder.getEnableEncodedImageColorSpaceUsage();
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.enableEncodedImageColorSpaceUsage = BOOLEAN_FALSE;
        Companion companion = Companion;
        this.imageTranscoderFactory = companion.getImageTranscoderFactory(builder);
        this.imageTranscoderType = builder.getImageTranscoderType();
        Supplier BOOLEAN_TRUE = builder.isPrefetchEnabledSupplier();
        if (BOOLEAN_TRUE == null) {
            BOOLEAN_TRUE = Suppliers.BOOLEAN_TRUE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_TRUE, "BOOLEAN_TRUE");
        }
        this.isPrefetchEnabledSupplier = BOOLEAN_TRUE;
        DiskCacheConfig mainDiskCacheConfig = builder.getMainDiskCacheConfig();
        this.mainDiskCacheConfig = mainDiskCacheConfig == null ? companion.getDefaultMainDiskCacheConfig(builder.getContext()) : mainDiskCacheConfig;
        MemoryTrimmableRegistry memoryTrimmableRegistry = builder.getMemoryTrimmableRegistry();
        if (memoryTrimmableRegistry == null) {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
            Intrinsics.checkNotNullExpressionValue(memoryTrimmableRegistry, "getInstance(...)");
        }
        this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        this.memoryChunkType = companion.getMemoryChunkType(builder, getExperiments());
        int httpConnectionTimeout = builder.getHttpConnectionTimeout() < 0 ? Constants.CONNECTION_TIMEOUT_VERIFY : builder.getHttpConnectionTimeout();
        this.httpNetworkTimeout = httpConnectionTimeout;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
            try {
                networkFetcher = builder.getNetworkFetcher();
                networkFetcher = networkFetcher == null ? new HttpUrlConnectionNetworkFetcher(httpConnectionTimeout) : networkFetcher;
                FrescoSystrace.endSection();
            } catch (Throwable th) {
                FrescoSystrace.endSection();
                throw th;
            }
        } else {
            networkFetcher = builder.getNetworkFetcher();
            if (networkFetcher == null) {
                networkFetcher = new HttpUrlConnectionNetworkFetcher(httpConnectionTimeout);
            }
        }
        this.networkFetcher = networkFetcher;
        this.platformBitmapFactory = builder.getPlatformBitmapFactory();
        PoolFactory poolFactory = builder.getPoolFactory();
        this.poolFactory = poolFactory == null ? new PoolFactory(PoolConfig.newBuilder().build()) : poolFactory;
        ProgressiveJpegConfig progressiveJpegConfig = builder.getProgressiveJpegConfig();
        this.progressiveJpegConfig = progressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : progressiveJpegConfig;
        Set requestListeners = builder.getRequestListeners();
        this.requestListeners = requestListeners == null ? SetsKt.emptySet() : requestListeners;
        Set requestListener2s = builder.getRequestListener2s();
        this.requestListener2s = requestListener2s == null ? SetsKt.emptySet() : requestListener2s;
        Set customProducerSequenceFactories = builder.getCustomProducerSequenceFactories();
        this.customProducerSequenceFactories = customProducerSequenceFactories == null ? SetsKt.emptySet() : customProducerSequenceFactories;
        this.isResizeAndRotateEnabledForNetwork = builder.getResizeAndRotateEnabledForNetwork();
        DiskCacheConfig smallImageDiskCacheConfig = builder.getSmallImageDiskCacheConfig();
        this.smallImageDiskCacheConfig = smallImageDiskCacheConfig == null ? getMainDiskCacheConfig() : smallImageDiskCacheConfig;
        builder.getImageDecoderConfig();
        int flexByteArrayPoolMaxNumThreads = getPoolFactory().getFlexByteArrayPoolMaxNumThreads();
        ExecutorSupplier executorSupplier = builder.getExecutorSupplier();
        this.executorSupplier = executorSupplier == null ? new DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads) : executorSupplier;
        this.isDiskCacheEnabled = builder.getDiskCacheEnabled();
        builder.getCallerContextVerifier();
        this.closeableReferenceLeakTracker = builder.getCloseableReferenceLeakTracker();
        this.bitmapCacheOverride = builder.getBitmapMemoryCache();
        BitmapMemoryCacheFactory bitmapMemoryCacheFactory = builder.getBitmapMemoryCacheFactory();
        this.bitmapMemoryCacheFactory = bitmapMemoryCacheFactory == null ? new CountingLruBitmapMemoryCacheFactory() : bitmapMemoryCacheFactory;
        this.encodedMemoryCacheOverride = builder.getEncodedMemoryCache();
        builder.getSerialExecutorServiceForAnimatedImages();
        this.dynamicDiskCacheConfigMap = builder.getDynamicDiskCacheConfigMap();
        Supplier diskCachesStoreSupplier = builder.getDiskCachesStoreSupplier();
        if (diskCachesStoreSupplier == null) {
            FileCacheFactory fileCacheFactory = builder.getFileCacheFactory();
            diskCachesStoreSupplier = new DiskCachesStoreFactory(fileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : fileCacheFactory, this);
        }
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        getExperiments().getWebpBitmapFactory();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier getBitmapMemoryCacheParamsSupplier() {
        return this.bitmapMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.bitmapMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
        return this.encodedMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Context getContext() {
        return this.context;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DownsampleMode getDownsampleMode() {
        return this.downsampleMode;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier getDiskCachesStoreSupplier() {
        return this.diskCachesStoreSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier getEncodedMemoryCacheParamsSupplier() {
        return this.encodedMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.imageCacheStatsTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageDecoder getImageDecoder() {
        return this.imageDecoder;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.imageTranscoderFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Integer getImageTranscoderType() {
        return this.imageTranscoderType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier isPrefetchEnabledSupplier() {
        return this.isPrefetchEnabledSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mainDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.memoryTrimmableRegistry;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public int getMemoryChunkType() {
        return this.memoryChunkType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public NetworkFetcher getNetworkFetcher() {
        return this.networkFetcher;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public PoolFactory getPoolFactory() {
        return this.poolFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.progressiveJpegConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set getRequestListeners() {
        return this.requestListeners;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set getRequestListener2s() {
        return this.requestListener2s;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set getCustomProducerSequenceFactories() {
        return this.customProducerSequenceFactories;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.isResizeAndRotateEnabledForNetwork;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.smallImageDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImagePipelineExperiments getExperiments() {
        return this.experiments;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public boolean isDiskCacheEnabled() {
        return this.isDiskCacheEnabled;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.closeableReferenceLeakTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache getEncodedMemoryCacheOverride() {
        return this.encodedMemoryCacheOverride;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
        return this.bitmapMemoryCacheFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Map getDynamicDiskCacheConfigMap() {
        return this.dynamicDiskCacheConfigMap;
    }

    public static final class DefaultImageRequestConfig {
        private boolean isProgressiveRenderingEnabled;

        public final boolean isProgressiveRenderingEnabled() {
            return this.isProgressiveRenderingEnabled;
        }
    }

    public static final class Builder {
        private Bitmap.Config bitmapConfig;
        private MemoryCache bitmapMemoryCache;
        private BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
        private Supplier bitmapMemoryCacheParamsSupplier;
        private MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
        private CacheKeyFactory cacheKeyFactory;
        private CloseableReferenceLeakTracker closeableReferenceLeakTracker;
        private final Context context;
        private Set customProducerSequenceFactories;
        private boolean diskCacheEnabled;
        private Supplier diskCachesStoreSupplier;
        private DownsampleMode downsampleMode;
        private Map dynamicDiskCacheConfigMap;
        private Supplier enableEncodedImageColorSpaceUsage;
        private MemoryCache encodedMemoryCache;
        private Supplier encodedMemoryCacheParamsSupplier;
        private MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
        private ExecutorSupplier executorSupplier;
        private final ImagePipelineExperiments.Builder experimentsBuilder;
        private FileCacheFactory fileCacheFactory;
        private int httpConnectionTimeout;
        private ImageCacheStatsTracker imageCacheStatsTracker;
        private ImageDecoder imageDecoder;
        private ImageTranscoderFactory imageTranscoderFactory;
        private Integer imageTranscoderType;
        private Supplier isPrefetchEnabledSupplier;
        private DiskCacheConfig mainDiskCacheConfig;
        private Integer memoryChunkType;
        private MemoryTrimmableRegistry memoryTrimmableRegistry;
        private NetworkFetcher networkFetcher;
        private PlatformBitmapFactory platformBitmapFactory;
        private PoolFactory poolFactory;
        private ProgressiveJpegConfig progressiveJpegConfig;
        private Set requestListener2s;
        private Set requestListeners;
        private boolean resizeAndRotateEnabledForNetwork;
        private DiskCacheConfig smallImageDiskCacheConfig;

        public final CountingMemoryCache.EntryStateObserver getBitmapMemoryCacheEntryStateObserver() {
            return null;
        }

        public final CallerContextVerifier getCallerContextVerifier() {
            return null;
        }

        public final ImageDecoderConfig getImageDecoderConfig() {
            return null;
        }

        public final SerialExecutorService getSerialExecutorServiceForAnimatedImages() {
            return null;
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.downsampleMode = DownsampleMode.AUTO;
            this.resizeAndRotateEnabledForNetwork = true;
            this.httpConnectionTimeout = -1;
            this.experimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.diskCacheEnabled = true;
            this.closeableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            this.context = context;
        }

        public final Bitmap.Config getBitmapConfig() {
            return this.bitmapConfig;
        }

        public final Supplier getBitmapMemoryCacheParamsSupplier() {
            return this.bitmapMemoryCacheParamsSupplier;
        }

        public final MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
            return this.bitmapMemoryCacheTrimStrategy;
        }

        public final MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
            return this.encodedMemoryCacheTrimStrategy;
        }

        public final CacheKeyFactory getCacheKeyFactory() {
            return this.cacheKeyFactory;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DownsampleMode getDownsampleMode() {
            return this.downsampleMode;
        }

        public final Supplier getEncodedMemoryCacheParamsSupplier() {
            return this.encodedMemoryCacheParamsSupplier;
        }

        public final ExecutorSupplier getExecutorSupplier() {
            return this.executorSupplier;
        }

        public final ImageCacheStatsTracker getImageCacheStatsTracker() {
            return this.imageCacheStatsTracker;
        }

        public final ImageDecoder getImageDecoder() {
            return this.imageDecoder;
        }

        public final Supplier getEnableEncodedImageColorSpaceUsage() {
            return this.enableEncodedImageColorSpaceUsage;
        }

        public final ImageTranscoderFactory getImageTranscoderFactory() {
            return this.imageTranscoderFactory;
        }

        public final Integer getImageTranscoderType() {
            return this.imageTranscoderType;
        }

        public final Supplier isPrefetchEnabledSupplier() {
            return this.isPrefetchEnabledSupplier;
        }

        public final DiskCacheConfig getMainDiskCacheConfig() {
            return this.mainDiskCacheConfig;
        }

        public final MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
            return this.memoryTrimmableRegistry;
        }

        public final Integer getMemoryChunkType() {
            return this.memoryChunkType;
        }

        public final NetworkFetcher getNetworkFetcher() {
            return this.networkFetcher;
        }

        public final PlatformBitmapFactory getPlatformBitmapFactory() {
            return this.platformBitmapFactory;
        }

        public final PoolFactory getPoolFactory() {
            return this.poolFactory;
        }

        public final ProgressiveJpegConfig getProgressiveJpegConfig() {
            return this.progressiveJpegConfig;
        }

        public final Set getRequestListeners() {
            return this.requestListeners;
        }

        public final Set getRequestListener2s() {
            return this.requestListener2s;
        }

        public final Set getCustomProducerSequenceFactories() {
            return this.customProducerSequenceFactories;
        }

        public final boolean getResizeAndRotateEnabledForNetwork() {
            return this.resizeAndRotateEnabledForNetwork;
        }

        public final DiskCacheConfig getSmallImageDiskCacheConfig() {
            return this.smallImageDiskCacheConfig;
        }

        public final FileCacheFactory getFileCacheFactory() {
            return this.fileCacheFactory;
        }

        public final Supplier getDiskCachesStoreSupplier() {
            return this.diskCachesStoreSupplier;
        }

        public final int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        public final ImagePipelineExperiments.Builder getExperimentsBuilder() {
            return this.experimentsBuilder;
        }

        public final boolean getDiskCacheEnabled() {
            return this.diskCacheEnabled;
        }

        public final CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
            return this.closeableReferenceLeakTracker;
        }

        public final MemoryCache getBitmapMemoryCache() {
            return this.bitmapMemoryCache;
        }

        public final MemoryCache getEncodedMemoryCache() {
            return this.encodedMemoryCache;
        }

        public final BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
            return this.bitmapMemoryCacheFactory;
        }

        public final Map getDynamicDiskCacheConfigMap() {
            return this.dynamicDiskCacheConfigMap;
        }

        public final Builder setDownsampleMode(DownsampleMode downsampleMode) {
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            this.downsampleMode = downsampleMode;
            return this;
        }

        public final Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.networkFetcher = networkFetcher;
            return this;
        }

        public final Builder setRequestListeners(Set set) {
            this.requestListeners = set;
            return this;
        }

        public final ImagePipelineExperiments.Builder experiment() {
            return this.experimentsBuilder;
        }

        public final ImagePipelineConfig build() {
            return new ImagePipelineConfig(this, null);
        }
    }
}
