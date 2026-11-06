package com.facebook.imagepipeline.producers;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ExperimentalThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    private final Executor executor;

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void remove(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
    }

    public ExperimentalThreadHandoffProducerQueueImpl(Executor executor) {
        if (executor == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.executor = executor;
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void addToQueueOrExecute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.execute(runnable);
    }
}
