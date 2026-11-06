package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {
    private final Executor executor;
    private boolean queueing;
    private final Deque runnableList;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.executor = executor;
        this.runnableList = new ArrayDeque();
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void addToQueueOrExecute(Runnable runnable) {
        try {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            if (this.queueing) {
                this.runnableList.add(runnable);
            } else {
                this.executor.execute(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public synchronized void remove(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.runnableList.remove(runnable);
    }
}
