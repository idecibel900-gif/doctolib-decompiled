package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RemoveImageTransformMetaDataProducer implements Producer {
    private final Producer inputProducer;

    public RemoveImageTransformMetaDataProducer(Producer inputProducer) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.inputProducer = inputProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        this.inputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(this, consumer), context);
    }

    private final class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer {
        final /* synthetic */ RemoveImageTransformMetaDataProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveImageTransformMetaDataConsumer(RemoveImageTransformMetaDataProducer removeImageTransformMetaDataProducer, Consumer consumer) {
            super(consumer);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.this$0 = removeImageTransformMetaDataProducer;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            CloseableReference byteBufferRef = null;
            try {
                if (EncodedImage.isValid(encodedImage) && encodedImage != null) {
                    byteBufferRef = encodedImage.getByteBufferRef();
                }
                getConsumer().onNewResult(byteBufferRef, i);
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        }
    }
}
