package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleSettableFuture implements Future {
    private Exception exception;
    private final CountDownLatch readyLatch = new CountDownLatch(1);
    private Object result;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    public final void set(Object obj) {
        checkNotSet();
        this.result = obj;
        this.readyLatch.countDown();
    }

    public final void setException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        checkNotSet();
        this.exception = exception;
        this.readyLatch.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.readyLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        this.readyLatch.await();
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit unit) throws ExecutionException, TimeoutException {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!this.readyLatch.await(j, unit)) {
            throw new TimeoutException("Timed out waiting for result");
        }
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }

    public final Object getOrThrow() {
        try {
            return get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    private final void checkNotSet() {
        if (this.readyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
