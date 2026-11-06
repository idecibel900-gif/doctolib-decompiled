package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ScheduledFutureImpl implements RunnableFuture, ScheduledFuture {
    private final Handler mHandler;
    private final FutureTask mListenableFuture;

    public ScheduledFutureImpl(Handler handler, Callable callable) {
        this.mHandler = handler;
        this.mListenableFuture = new FutureTask(callable);
    }

    public ScheduledFutureImpl(Handler handler, Runnable runnable, Object obj) {
        this.mHandler = handler;
        this.mListenableFuture = new FutureTask(runnable, obj);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.mListenableFuture.run();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mListenableFuture.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mListenableFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mListenableFuture.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.mListenableFuture.get();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.mListenableFuture.get(j, timeUnit);
    }
}
