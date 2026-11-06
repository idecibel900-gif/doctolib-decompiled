package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingFuture extends ForwardingObject implements Future {
    @Override // com.google.common.collect.ForwardingObject
    protected abstract Future delegate();

    protected ForwardingFuture() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return delegate().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return delegate().get(j, timeUnit);
    }
}
