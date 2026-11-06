package com.facebook.imagepipeline.producers;

import android.os.Looper;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadHandoffProducer implements Producer {
    public static final Companion Companion = new Companion(null);
    private final Producer inputProducer;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer inputProducer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        this.inputProducer = inputProducer;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public final Producer getInputProducer() {
        return this.inputProducer;
    }

    public final ThreadHandoffProducerQueue getThreadHandoffProducerQueue() {
        return this.threadHandoffProducerQueue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer consumer, final ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!FrescoSystrace.isTracing()) {
            final ProducerListener2 producerListener = context.getProducerListener();
            Companion companion = Companion;
            if (companion.shouldRunImmediately(context)) {
                producerListener.onProducerStart(context, "BackgroundThreadHandoffProducer");
                producerListener.onProducerFinishWithSuccess(context, "BackgroundThreadHandoffProducer", null);
                this.inputProducer.produceResults(consumer, context);
                return;
            } else {
                final StatefulProducerRunnable statefulProducerRunnable = new StatefulProducerRunnable(producerListener, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ ProducerContext $context;
                    final /* synthetic */ ProducerListener2 $producerListener;
                    final /* synthetic */ ThreadHandoffProducer this$0;

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected void disposeResult(Object obj) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected Object getResult() {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this.$consumer, producerListener, context, "BackgroundThreadHandoffProducer");
                        this.$producerListener = producerListener;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void onSuccess(Object obj) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, "BackgroundThreadHandoffProducer", null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(statefulProducerRunnable, companion.getInstrumentationTag(context)));
                return;
            }
        }
        FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
        try {
            final ProducerListener2 producerListener2 = context.getProducerListener();
            Companion companion2 = Companion;
            if (companion2.shouldRunImmediately(context)) {
                producerListener2.onProducerStart(context, "BackgroundThreadHandoffProducer");
                producerListener2.onProducerFinishWithSuccess(context, "BackgroundThreadHandoffProducer", null);
                this.inputProducer.produceResults(consumer, context);
            } else {
                final StatefulProducerRunnable statefulProducerRunnable2 = new StatefulProducerRunnable(producerListener2, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ ProducerContext $context;
                    final /* synthetic */ ProducerListener2 $producerListener;
                    final /* synthetic */ ThreadHandoffProducer this$0;

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected void disposeResult(Object obj) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected Object getResult() {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this.$consumer, producerListener2, context, "BackgroundThreadHandoffProducer");
                        this.$producerListener = producerListener2;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void onSuccess(Object obj) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, "BackgroundThreadHandoffProducer", null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable2.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable2);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(statefulProducerRunnable2, companion2.getInstrumentationTag(context)));
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            FrescoSystrace.endSection();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getInstrumentationTag(ProducerContext producerContext) {
            if (!FrescoInstrumenter.isTracing()) {
                return null;
            }
            return "ThreadHandoffProducer_produceResults_" + producerContext.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldRunImmediately(ProducerContext producerContext) {
            return producerContext.getImagePipelineConfig().getExperiments().getHandOffOnUiThreadOnly() && Looper.getMainLooper().getThread() != Thread.currentThread();
        }
    }
}
