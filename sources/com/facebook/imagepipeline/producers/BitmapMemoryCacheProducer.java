package com.facebook.imagepipeline.producers;

import com.amazon.a.a.o.b;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.HasImageMetadata;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheProducer implements Producer {
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer mInputProducer;
    private final MemoryCache mMemoryCache;

    public BitmapMemoryCacheProducer(MemoryCache memoryCache, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        boolean zIsTracing;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference closeableReference = producerContext.getImageRequest().isCacheEnabled(1) ? this.mMemoryCache.get(bitmapCacheKey) : null;
            if (closeableReference != null) {
                maybeSetExtrasFromCloseableImage((HasImageMetadata) closeableReference.get(), producerContext);
                boolean zIsOfFullQuality = ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality();
                if (zIsOfFullQuality) {
                    producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", b.af) : null);
                    producerListener.onUltimateProducerReached(producerContext, getProducerName(), true);
                    producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(zIsOfFullQuality));
                closeableReference.close();
                if (zIsOfFullQuality) {
                    if (zIsTracing) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", b.ag) : null);
                producerListener.onUltimateProducerReached(producerContext, getProducerName(), false);
                producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                consumer.onNewResult(null, 1);
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            Consumer consumerWrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isCacheEnabled(2));
            producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", b.ag) : null);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(consumerWrapConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    protected Consumer wrapConsumer(Consumer consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer(consumer) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(CloseableReference closeableReference, int i) {
                CloseableReference closeableReference2;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                    }
                    boolean zIsLast = BaseConsumer.isLast(i);
                    if (closeableReference == null) {
                        if (zIsLast) {
                            getConsumer().onNewResult(null, i);
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    if (!((CloseableImage) closeableReference.get()).isStateful() && !BaseConsumer.statusHasFlag(i, 8)) {
                        if (!zIsLast && (closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey)) != null) {
                            try {
                                QualityInfo qualityInfo = ((CloseableImage) closeableReference.get()).getQualityInfo();
                                QualityInfo qualityInfo2 = ((CloseableImage) closeableReference2.get()).getQualityInfo();
                                if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                    getConsumer().onNewResult(closeableReference2, i);
                                    CloseableReference.closeSafely(closeableReference2);
                                    if (FrescoSystrace.isTracing()) {
                                        FrescoSystrace.endSection();
                                        return;
                                    }
                                    return;
                                }
                                CloseableReference.closeSafely(closeableReference2);
                            } catch (Throwable th) {
                                CloseableReference.closeSafely(closeableReference2);
                                throw th;
                            }
                        }
                        CloseableReference closeableReferenceCache = z ? BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference) : null;
                        if (zIsLast) {
                            try {
                                getConsumer().onProgressUpdate(1.0f);
                            } catch (Throwable th2) {
                                CloseableReference.closeSafely(closeableReferenceCache);
                                throw th2;
                            }
                        }
                        Consumer consumer2 = getConsumer();
                        if (closeableReferenceCache != null) {
                            closeableReference = closeableReferenceCache;
                        }
                        consumer2.onNewResult(closeableReference, i);
                        CloseableReference.closeSafely(closeableReferenceCache);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th3) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th3;
                }
            }
        };
    }

    protected String getProducerName() {
        return "BitmapMemoryCacheProducer";
    }

    private static void maybeSetExtrasFromCloseableImage(HasImageMetadata hasImageMetadata, ProducerContext producerContext) {
        producerContext.putExtras(hasImageMetadata.getExtras());
    }

    protected String getOriginSubcategory() {
        return "pipe_bg";
    }
}
