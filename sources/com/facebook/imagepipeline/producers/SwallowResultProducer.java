package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes3.dex */
public class SwallowResultProducer implements Producer {
    private final Producer mInputProducer;

    public SwallowResultProducer(Producer producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new DelegatingConsumer(consumer) { // from class: com.facebook.imagepipeline.producers.SwallowResultProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onNewResultImpl(Object obj, int i) {
                if (BaseConsumer.isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            }
        }, producerContext);
    }
}
