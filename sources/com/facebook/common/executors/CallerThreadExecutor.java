package com.facebook.common.executors;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class CallerThreadExecutor extends AbstractExecutorService implements AutoCloseable {
    private static final CallerThreadExecutor sInstance = new CallerThreadExecutor();

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return true;
    }

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

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    public static CallerThreadExecutor getInstance() {
        return sInstance;
    }

    private CallerThreadExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        shutdown();
        return Collections.EMPTY_LIST;
    }
}
