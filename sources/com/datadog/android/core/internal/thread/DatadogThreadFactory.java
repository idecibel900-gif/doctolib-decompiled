package com.datadog.android.core.internal.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogThreadFactory implements ThreadFactory {
    private final String newThreadContext;
    private final AtomicInteger threadNumber;

    public DatadogThreadFactory(String newThreadContext) {
        Intrinsics.checkNotNullParameter(newThreadContext, "newThreadContext");
        this.newThreadContext = newThreadContext;
        this.threadNumber = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int andIncrement = this.threadNumber.getAndIncrement();
        Thread thread = new Thread(runnable, "datadog-" + this.newThreadContext + "-thread-" + andIncrement);
        thread.setPriority(5);
        thread.setDaemon(false);
        return thread;
    }
}
