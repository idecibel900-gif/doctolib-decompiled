package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes3.dex */
public interface ThreadHandoffProducerQueue {
    void addToQueueOrExecute(Runnable runnable);

    void remove(Runnable runnable);
}
