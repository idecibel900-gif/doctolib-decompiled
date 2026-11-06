package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DelayProducer implements Producer {
    private final ScheduledExecutorService backgroundTasksExecutor;
    private final Producer inputProducer;

    public DelayProducer(Producer inputProducer, ScheduledExecutorService scheduledExecutorService) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.inputProducer = inputProducer;
        this.backgroundTasksExecutor = scheduledExecutorService;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer consumer, final ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        ImageRequest imageRequest = context.getImageRequest();
        ScheduledExecutorService scheduledExecutorService = this.backgroundTasksExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new Runnable() { // from class: com.facebook.imagepipeline.producers.DelayProducer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DelayProducer.produceResults$lambda$0(this.f$0, consumer, context);
                }
            }, imageRequest.getDelayMs(), TimeUnit.MILLISECONDS);
        } else {
            this.inputProducer.produceResults(consumer, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void produceResults$lambda$0(DelayProducer this$0, Consumer consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.inputProducer.produceResults(consumer, context);
    }
}
