package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheReadProducer implements Producer {
    private final CacheKeyFactory mCacheKeyFactory;
    private final Supplier mDiskCachesStoreSupplier;
    private final Producer mInputProducer;

    public DiskCacheReadProducer(Supplier supplier, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!producerContext.getImageRequest().isCacheEnabled(16)) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, "DiskCacheProducer");
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        DiskCachesStore diskCachesStore = (DiskCachesStore) this.mDiskCachesStoreSupplier.get();
        BufferedDiskCache bufferedDiskCacheChooseDiskCacheForRequest = DiskCacheDecision.chooseDiskCacheForRequest(imageRequest, diskCachesStore.getSmallImageBufferedDiskCache(), diskCachesStore.getMainBufferedDiskCache(), diskCachesStore.getDynamicBufferedDiskCaches());
        if (bufferedDiskCacheChooseDiskCacheForRequest == null) {
            producerContext.getProducerListener().onProducerFinishWithFailure(producerContext, "DiskCacheProducer", new DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + Integer.valueOf(imageRequest.getCacheChoice().ordinal()).toString()), null);
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCacheChooseDiskCacheForRequest.get(encodedCacheKey, atomicBoolean).continueWith(onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    private Continuation onFinishDiskReads(final Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        return new Continuation() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            @Override // bolts.Continuation
            public Void then(Task task) {
                if (DiskCacheReadProducer.isTaskCancelled(task)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, "DiskCacheProducer", null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    producerListener.onProducerFinishWithFailure(producerContext, "DiskCacheProducer", task.getError(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    EncodedImage encodedImage = (EncodedImage) task.getResult();
                    if (encodedImage != null) {
                        ProducerListener2 producerListener2 = producerListener;
                        ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener2, producerContext2, true, encodedImage.getSize()));
                        producerListener.onUltimateProducerReached(producerContext, "DiskCacheProducer", true);
                        producerContext.putOriginExtra("disk");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        encodedImage.close();
                    } else {
                        ProducerListener2 producerListener3 = producerListener;
                        ProducerContext producerContext3 = producerContext;
                        producerListener3.onProducerFinishWithSuccess(producerContext3, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(producerListener3, producerContext3, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(Task task) {
        if (task.isCancelled()) {
            return true;
        }
        return task.isFaulted() && (task.getError() instanceof CancellationException);
    }

    private void maybeStartInputProducer(Consumer consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    static Map getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, "DiskCacheProducer")) {
            return null;
        }
        if (!z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }
}
