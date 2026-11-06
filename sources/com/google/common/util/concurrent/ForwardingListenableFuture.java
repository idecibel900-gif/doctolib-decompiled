package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingListenableFuture extends ForwardingFuture implements ListenableFuture {
    @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
    protected abstract ListenableFuture delegate();

    protected ForwardingListenableFuture() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    public static abstract class SimpleForwardingListenableFuture extends ForwardingListenableFuture {
        private final ListenableFuture delegate;

        protected SimpleForwardingListenableFuture(ListenableFuture listenableFuture) {
            this.delegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final ListenableFuture delegate() {
            return this.delegate;
        }
    }
}
