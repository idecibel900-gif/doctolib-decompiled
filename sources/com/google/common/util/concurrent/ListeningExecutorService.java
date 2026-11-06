package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface ListeningExecutorService extends ExecutorService, AutoCloseable {
    ListenableFuture submit(Runnable runnable, Object obj);

    ListenableFuture submit(Callable callable);
}
