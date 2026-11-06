package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StatefulProducerRunnable extends StatefulRunnable {
    private final Consumer consumer;
    private final ProducerContext producerContext;
    private final ProducerListener2 producerListener;
    private final String producerName;

    protected Map getExtraMapOnCancellation() {
        return null;
    }

    protected Map getExtraMapOnFailure(Exception exc) {
        return null;
    }

    protected Map getExtraMapOnSuccess(Object obj) {
        return null;
    }

    public StatefulProducerRunnable(Consumer consumer, ProducerListener2 producerListener, ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(producerListener, "producerListener");
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        this.consumer = consumer;
        this.producerListener = producerListener;
        this.producerContext = producerContext;
        this.producerName = producerName;
        producerListener.onProducerStart(producerContext, producerName);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    protected void onSuccess(Object obj) {
        ProducerListener2 producerListener2 = this.producerListener;
        ProducerContext producerContext = this.producerContext;
        String str = this.producerName;
        producerListener2.onProducerFinishWithSuccess(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnSuccess(obj) : null);
        this.consumer.onNewResult(obj, 1);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    protected void onFailure(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ProducerListener2 producerListener2 = this.producerListener;
        ProducerContext producerContext = this.producerContext;
        String str = this.producerName;
        producerListener2.onProducerFinishWithFailure(producerContext, str, e, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnFailure(e) : null);
        this.consumer.onFailure(e);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    protected void onCancellation() {
        ProducerListener2 producerListener2 = this.producerListener;
        ProducerContext producerContext = this.producerContext;
        String str = this.producerName;
        producerListener2.onProducerFinishWithCancellation(producerContext, str, producerListener2.requiresExtraMap(producerContext, str) ? getExtraMapOnCancellation() : null);
        this.consumer.onCancellation();
    }
}
