package com.datadog.android.rum.internal.thread;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpScheduledExecutorService implements ScheduledExecutorService, AutoCloseable {
    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return null;
    }
}
