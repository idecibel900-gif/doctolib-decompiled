package com.datadog.exec;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class DaemonThreadFactory implements ThreadFactory {
    private final String threadName;
    public static final DaemonThreadFactory TRACE_PROCESSOR = new DaemonThreadFactory("dd-trace-processor");
    public static final DaemonThreadFactory TRACE_WRITER = new DaemonThreadFactory("dd-trace-writer");
    public static final DaemonThreadFactory TASK_SCHEDULER = new DaemonThreadFactory("dd-task-scheduler");

    public DaemonThreadFactory(String str) {
        this.threadName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.threadName);
        thread.setDaemon(true);
        thread.setContextClassLoader(null);
        return thread;
    }
}
