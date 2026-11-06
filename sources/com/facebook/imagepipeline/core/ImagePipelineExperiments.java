package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImagePipelineExperiments {
    public static final Companion Companion = new Companion(null);
    private final boolean allowDelay;
    private final boolean allowProgressiveOnPrefetch;
    private final int animationRenderFpsLimit;
    private final int animationStrategyBufferLengthMilliseconds;
    private final boolean bitmapPrepareToDrawForPrefetch;
    private final int bitmapPrepareToDrawMaxSizeBytes;
    private final int bitmapPrepareToDrawMinSizeBytes;
    private final boolean cancelDecodeOnCacheMiss;
    private final boolean downsampleIfLargeBitmap;
    private final boolean downscaleFrameToDrawableDimensions;
    private final boolean handOffOnUiThreadOnly;
    private final boolean isBinaryXmlEnabled;
    private final boolean isDecodeCancellationEnabled;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedCacheEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;
    private final boolean isEnsureTranscoderLibraryLoaded;
    private final boolean isExperimentalThreadHandoffQueueEnabled;
    private final boolean isGingerbreadDecoderEnabled;
    private final Supplier isLazyDataSource;
    private final boolean isNativeCodeDisabled;
    private final boolean isPartialImageCachingEnabled;
    private final boolean isWebpSupportEnabled;
    private final boolean keepCancelledFetchAsLowPriority;
    private final int maxBitmapDimension;
    private final long memoryType;
    private final PlatformDecoderOptions platformDecoderOptions;
    private final boolean prefetchShortcutEnabled;
    private final ProducerFactoryMethod producerFactoryMethod;
    private final boolean shouldIgnoreCacheSizeMismatch;
    private final boolean shouldStoreCacheEntrySize;
    private final boolean shouldUseDecodingBufferHelper;
    private final Supplier suppressBitmapPrefetchingSupplier;
    private final int trackedKeysSize;
    private final boolean useBalancedAnimationStrategy;
    private final boolean useBitmapPrepareToDraw;
    private final boolean useDownsamplingRatioForResizing;

    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean z, boolean z2, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache memoryCache, MemoryCache memoryCache2, Supplier supplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z3, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z4, int i4);
    }

    public /* synthetic */ ImagePipelineExperiments(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final WebpBitmapFactory getWebpBitmapFactory() {
        return null;
    }

    private ImagePipelineExperiments(Builder builder) {
        this.isWebpSupportEnabled = builder.webpSupportEnabled;
        this.isDecodeCancellationEnabled = builder.decodeCancellationEnabled;
        this.useDownsamplingRatioForResizing = builder.useDownsamplingRatioForResizing;
        this.useBitmapPrepareToDraw = builder.useBitmapPrepareToDraw;
        this.useBalancedAnimationStrategy = builder.useBalancedAnimationStrategy;
        this.animationStrategyBufferLengthMilliseconds = builder.animationStrategyBufferLengthMilliseconds;
        this.bitmapPrepareToDrawMinSizeBytes = builder.bitmapPrepareToDrawMinSizeBytes;
        this.bitmapPrepareToDrawMaxSizeBytes = builder.bitmapPrepareToDrawMaxSizeBytes;
        this.bitmapPrepareToDrawForPrefetch = builder.bitmapPrepareToDrawForPrefetch;
        this.maxBitmapDimension = builder.maxBitmapDimension;
        this.isNativeCodeDisabled = builder.nativeCodeDisabled;
        this.isPartialImageCachingEnabled = builder.isPartialImageCachingEnabled;
        ProducerFactoryMethod producerFactoryMethod = builder.producerFactoryMethod;
        this.producerFactoryMethod = producerFactoryMethod == null ? new DefaultProducerFactoryMethod() : producerFactoryMethod;
        Supplier BOOLEAN_FALSE = builder.lazyDataSource;
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.isLazyDataSource = BOOLEAN_FALSE;
        this.isGingerbreadDecoderEnabled = builder.gingerbreadDecoderEnabled;
        this.downscaleFrameToDrawableDimensions = builder.downscaleFrameToDrawableDimensions;
        this.suppressBitmapPrefetchingSupplier = builder.suppressBitmapPrefetchingSupplier;
        this.isExperimentalThreadHandoffQueueEnabled = builder.experimentalThreadHandoffQueueEnabled;
        this.memoryType = builder.memoryType;
        this.keepCancelledFetchAsLowPriority = builder.keepCancelledFetchAsLowPriority;
        this.downsampleIfLargeBitmap = builder.downsampleIfLargeBitmap;
        this.isEncodedCacheEnabled = builder.encodedCacheEnabled;
        this.isEnsureTranscoderLibraryLoaded = builder.ensureTranscoderLibraryLoaded;
        this.isEncodedMemoryCacheProbingEnabled = builder.isEncodedMemoryCacheProbingEnabled;
        this.isDiskCacheProbingEnabled = builder.isDiskCacheProbingEnabled;
        this.trackedKeysSize = builder.trackedKeysSize;
        this.allowProgressiveOnPrefetch = builder.allowProgressiveOnPrefetch;
        this.animationRenderFpsLimit = builder.animationRenderFpsLimit;
        this.allowDelay = builder.allowDelay;
        this.handOffOnUiThreadOnly = builder.handOffOnUiThreadOnly;
        this.shouldStoreCacheEntrySize = builder.shouldStoreCacheEntrySize;
        this.shouldIgnoreCacheSizeMismatch = builder.shouldIgnoreCacheSizeMismatch;
        this.shouldUseDecodingBufferHelper = builder.shouldUseDecodingBufferHelper;
        this.cancelDecodeOnCacheMiss = builder.cancelDecodeOnCacheMiss;
        this.prefetchShortcutEnabled = builder.prefetchShortcutEnabled;
        this.platformDecoderOptions = builder.platformDecoderOptions;
        this.isBinaryXmlEnabled = builder.isBinaryXmlEnabled;
    }

    public final boolean isWebpSupportEnabled() {
        return this.isWebpSupportEnabled;
    }

    public final boolean isDecodeCancellationEnabled() {
        return this.isDecodeCancellationEnabled;
    }

    public final boolean getUseDownsamplingRatioForResizing() {
        return this.useDownsamplingRatioForResizing;
    }

    public final boolean getUseBitmapPrepareToDraw() {
        return this.useBitmapPrepareToDraw;
    }

    public final boolean getUseBalancedAnimationStrategy() {
        return this.useBalancedAnimationStrategy;
    }

    public final int getAnimationStrategyBufferLengthMilliseconds() {
        return this.animationStrategyBufferLengthMilliseconds;
    }

    public final int getBitmapPrepareToDrawMinSizeBytes() {
        return this.bitmapPrepareToDrawMinSizeBytes;
    }

    public final int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.bitmapPrepareToDrawMaxSizeBytes;
    }

    public final boolean getBitmapPrepareToDrawForPrefetch() {
        return this.bitmapPrepareToDrawForPrefetch;
    }

    public final int getMaxBitmapDimension() {
        return this.maxBitmapDimension;
    }

    public final boolean isNativeCodeDisabled() {
        return this.isNativeCodeDisabled;
    }

    public final boolean isPartialImageCachingEnabled() {
        return this.isPartialImageCachingEnabled;
    }

    public final ProducerFactoryMethod getProducerFactoryMethod() {
        return this.producerFactoryMethod;
    }

    public final Supplier isLazyDataSource() {
        return this.isLazyDataSource;
    }

    public final boolean isGingerbreadDecoderEnabled() {
        return this.isGingerbreadDecoderEnabled;
    }

    public final boolean getDownscaleFrameToDrawableDimensions() {
        return this.downscaleFrameToDrawableDimensions;
    }

    public final Supplier getSuppressBitmapPrefetchingSupplier() {
        return this.suppressBitmapPrefetchingSupplier;
    }

    public final boolean isExperimentalThreadHandoffQueueEnabled() {
        return this.isExperimentalThreadHandoffQueueEnabled;
    }

    public final long getMemoryType() {
        return this.memoryType;
    }

    public final boolean getKeepCancelledFetchAsLowPriority() {
        return this.keepCancelledFetchAsLowPriority;
    }

    public final boolean getDownsampleIfLargeBitmap() {
        return this.downsampleIfLargeBitmap;
    }

    public final boolean isEncodedCacheEnabled() {
        return this.isEncodedCacheEnabled;
    }

    public final boolean isEnsureTranscoderLibraryLoaded() {
        return this.isEnsureTranscoderLibraryLoaded;
    }

    public final boolean isEncodedMemoryCacheProbingEnabled() {
        return this.isEncodedMemoryCacheProbingEnabled;
    }

    public final boolean isDiskCacheProbingEnabled() {
        return this.isDiskCacheProbingEnabled;
    }

    public final int getTrackedKeysSize() {
        return this.trackedKeysSize;
    }

    public final boolean getAllowDelay() {
        return this.allowDelay;
    }

    public final boolean getHandOffOnUiThreadOnly() {
        return this.handOffOnUiThreadOnly;
    }

    public final boolean getShouldStoreCacheEntrySize() {
        return this.shouldStoreCacheEntrySize;
    }

    public final boolean getShouldIgnoreCacheSizeMismatch() {
        return this.shouldIgnoreCacheSizeMismatch;
    }

    public final boolean getShouldUseDecodingBufferHelper() {
        return this.shouldUseDecodingBufferHelper;
    }

    public final boolean getAllowProgressiveOnPrefetch() {
        return this.allowProgressiveOnPrefetch;
    }

    public final boolean getCancelDecodeOnCacheMiss() {
        return this.cancelDecodeOnCacheMiss;
    }

    public final int getAnimationRenderFpsLimit() {
        return this.animationRenderFpsLimit;
    }

    public final PlatformDecoderOptions getPlatformDecoderOptions() {
        return this.platformDecoderOptions;
    }

    public final boolean isBinaryXmlEnabled() {
        return this.isBinaryXmlEnabled;
    }

    public static final class Builder {
        public boolean allowDelay;
        public boolean allowProgressiveOnPrefetch;
        public int animationRenderFpsLimit;
        public int animationStrategyBufferLengthMilliseconds;
        public boolean bitmapPrepareToDrawForPrefetch;
        public int bitmapPrepareToDrawMaxSizeBytes;
        public int bitmapPrepareToDrawMinSizeBytes;
        public boolean cancelDecodeOnCacheMiss;
        private final ImagePipelineConfig.Builder configBuilder;
        public boolean decodeCancellationEnabled;
        public boolean downsampleIfLargeBitmap;
        public boolean downscaleFrameToDrawableDimensions;
        public boolean encodedCacheEnabled;
        public boolean ensureTranscoderLibraryLoaded;
        public boolean experimentalThreadHandoffQueueEnabled;
        public boolean gingerbreadDecoderEnabled;
        public boolean handOffOnUiThreadOnly;
        public boolean isBinaryXmlEnabled;
        public boolean isDiskCacheProbingEnabled;
        public boolean isEncodedMemoryCacheProbingEnabled;
        public boolean isPartialImageCachingEnabled;
        public boolean keepCancelledFetchAsLowPriority;
        public Supplier lazyDataSource;
        public int maxBitmapDimension;
        public long memoryType;
        public boolean nativeCodeDisabled;
        public PlatformDecoderOptions platformDecoderOptions;
        public boolean prefetchShortcutEnabled;
        public ProducerFactoryMethod producerFactoryMethod;
        public boolean shouldIgnoreCacheSizeMismatch;
        public boolean shouldStoreCacheEntrySize;
        public boolean shouldUseDecodingBufferHelper;
        public Supplier suppressBitmapPrefetchingSupplier;
        public int trackedKeysSize;
        public boolean useBalancedAnimationStrategy;
        public boolean useBitmapPrepareToDraw;
        public boolean useDownsamplingRatioForResizing;
        public boolean webpSupportEnabled;

        public Builder(ImagePipelineConfig.Builder configBuilder) {
            Intrinsics.checkNotNullParameter(configBuilder, "configBuilder");
            this.configBuilder = configBuilder;
            this.animationStrategyBufferLengthMilliseconds = 1000;
            this.maxBitmapDimension = 2048;
            Supplier supplierOf = Suppliers.of(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(supplierOf, "of(...)");
            this.suppressBitmapPrefetchingSupplier = supplierOf;
            this.encodedCacheEnabled = true;
            this.ensureTranscoderLibraryLoaded = true;
            this.trackedKeysSize = 20;
            this.animationRenderFpsLimit = 30;
            this.platformDecoderOptions = new PlatformDecoderOptions(false, false, 3, null);
        }

        private final Builder asBuilder(Function0 function0) {
            function0.invoke();
            return this;
        }

        public final Builder setBinaryXmlEnabled(final boolean z) {
            return asBuilder(new Function0() { // from class: com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImagePipelineExperiments.Builder.setBinaryXmlEnabled$lambda$35(this.f$0, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setBinaryXmlEnabled$lambda$35(Builder this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isBinaryXmlEnabled = z;
            return Unit.INSTANCE;
        }

        public final ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this, null);
        }
    }

    public static final class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        @Override // com.facebook.imagepipeline.core.ImagePipelineExperiments.ProducerFactoryMethod
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, DownsampleMode downsampleMode, boolean z, boolean z2, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, MemoryCache bitmapMemoryCache, MemoryCache encodedMemoryCache, Supplier diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z3, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z4, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
            Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
            Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
            Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
            Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
            Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
            Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
            Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
            Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
            Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
            Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
            return new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, downsampleMode, z, z2, executorSupplier, pooledByteBufferFactory, bitmapMemoryCache, encodedMemoryCache, diskCachesStoreSupplier, cacheKeyFactory, platformBitmapFactory, i, i2, z3, i3, closeableReferenceFactory, z4, i4);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
