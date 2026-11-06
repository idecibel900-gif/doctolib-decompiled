package com.facebook.common.executors;

import android.os.Handler;
import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HandlerExecutorServiceImpl extends AbstractExecutorService implements ScheduledExecutorService, AutoCloseable {
    private final Handler mHandler;

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    public HandlerExecutorServiceImpl(Handler handler) {
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public ScheduledFutureImpl newTaskFor(Runnable runnable, Object obj) {
        return new ScheduledFutureImpl(this.mHandler, runnable, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public ScheduledFutureImpl newTaskFor(Callable callable) {
        return new ScheduledFutureImpl(this.mHandler, callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ScheduledFuture submit(Runnable runnable) {
        return submit(runnable, (Object) null);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ScheduledFuture submit(Runnable runnable, Object obj) {
        runnable.getClass();
        ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor(runnable, obj);
        execute(scheduledFutureImplNewTaskFor);
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ScheduledFuture submit(Callable callable) {
        callable.getClass();
        ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor(callable);
        execute(scheduledFutureImplNewTaskFor);
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor(runnable, (Object) null);
        this.mHandler.postDelayed(scheduledFutureImplNewTaskFor, timeUnit.toMillis(j));
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor(callable);
        this.mHandler.postDelayed(scheduledFutureImplNewTaskFor, timeUnit.toMillis(j));
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public boolean isHandlerThread() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
