package com.facebook.imagepipeline.producers;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DelegatingConsumer extends BaseConsumer {
    private final Consumer consumer;

    public DelegatingConsumer(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.consumer = consumer;
    }

    public final Consumer getConsumer() {
        return this.consumer;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onFailureImpl(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        this.consumer.onFailure(t);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onCancellationImpl() {
        this.consumer.onCancellation();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    protected void onProgressUpdateImpl(float f) {
        this.consumer.onProgressUpdate(f);
    }
}
