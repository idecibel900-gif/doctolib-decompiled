package com.facebook.imagepipeline.producers;

import com.amazon.a.a.o.b;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes3.dex */
public class EncodedMemoryCacheProducer implements Producer {
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer mInputProducer;
    private final MemoryCache mMemoryCache;

    public EncodedMemoryCacheProducer(MemoryCache memoryCache, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, "EncodedMemoryCacheProducer");
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference closeableReference = producerContext.getImageRequest().isCacheEnabled(4) ? this.mMemoryCache.get(encodedCacheKey) : null;
            try {
                if (closeableReference != null) {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    try {
                        producerListener.onProducerFinishWithSuccess(producerContext, "EncodedMemoryCacheProducer", producerListener.requiresExtraMap(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", b.af) : null);
                        producerListener.onUltimateProducerReached(producerContext, "EncodedMemoryCacheProducer", true);
                        producerContext.putOriginExtra("memory_encoded");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        EncodedImage.closeSafely(encodedImage);
                        CloseableReference.closeSafely(closeableReference);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        EncodedImage.closeSafely(encodedImage);
                        throw th;
                    }
                }
                if (producerContext.getLowestPermittedRequestLevel().getValue() < ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                    EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isCacheEnabled(8), producerContext.getImagePipelineConfig().getExperiments().isEncodedCacheEnabled());
                    producerListener.onProducerFinishWithSuccess(producerContext, "EncodedMemoryCacheProducer", producerListener.requiresExtraMap(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", b.ag) : null);
                    this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
                    CloseableReference.closeSafely(closeableReference);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                producerListener.onProducerFinishWithSuccess(producerContext, "EncodedMemoryCacheProducer", producerListener.requiresExtraMap(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", b.ag) : null);
                producerListener.onUltimateProducerReached(producerContext, "EncodedMemoryCacheProducer", false);
                producerContext.putOriginExtra("memory_encoded", "nil-result");
                consumer.onNewResult(null, 1);
                CloseableReference.closeSafely(closeableReference);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Throwable th2) {
                CloseableReference.closeSafely(closeableReference);
                throw th2;
            }
        } catch (Throwable th3) {
            if (!FrescoSystrace.isTracing()) {
                throw th3;
            }
            FrescoSystrace.endSection();
            throw th3;
        }
    }

    private static class EncodedMemoryCacheConsumer extends DelegatingConsumer {
        private final boolean mEncodedCacheEnabled;
        private final boolean mIsEncodedCacheEnabledForWrite;
        private final MemoryCache mMemoryCache;
        private final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer consumer, MemoryCache memoryCache, CacheKey cacheKey, boolean z, boolean z2) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsEncodedCacheEnabledForWrite = z;
            this.mEncodedCacheEnabled = z2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!BaseConsumer.isNotLast(i) && encodedImage != null && !BaseConsumer.statusHasAnyFlag(i, 10) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                    CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
                    if (byteBufferRef != null) {
                        try {
                            CloseableReference closeableReferenceCache = (this.mEncodedCacheEnabled && this.mIsEncodedCacheEnabledForWrite) ? this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef) : null;
                            CloseableReference.closeSafely(byteBufferRef);
                            if (closeableReferenceCache != null) {
                                try {
                                    EncodedImage encodedImage2 = new EncodedImage(closeableReferenceCache);
                                    encodedImage2.copyMetaDataFrom(encodedImage);
                                    CloseableReference.closeSafely(closeableReferenceCache);
                                    try {
                                        getConsumer().onProgressUpdate(1.0f);
                                        getConsumer().onNewResult(encodedImage2, i);
                                        EncodedImage.closeSafely(encodedImage2);
                                        if (FrescoSystrace.isTracing()) {
                                            FrescoSystrace.endSection();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        EncodedImage.closeSafely(encodedImage2);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    CloseableReference.closeSafely(closeableReferenceCache);
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            CloseableReference.closeSafely(byteBufferRef);
                            throw th3;
                        }
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                getConsumer().onNewResult(encodedImage, i);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Throwable th4) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                throw th4;
            }
        }
    }
}
