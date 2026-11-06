package io.sentry.util.thread;

/* JADX INFO: loaded from: classes5.dex */
public final class ThreadChecker implements IThreadChecker {
    private static final long mainThreadId = Thread.currentThread().getId();
    private static final ThreadChecker instance = new ThreadChecker();

    public static ThreadChecker getInstance() {
        return instance;
    }

    private ThreadChecker() {
    }

    public boolean isMainThread(long j) {
        return mainThreadId == j;
    }

    public boolean isMainThread(Thread thread) {
        return isMainThread(thread.getId());
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public long currentThreadSystemId() {
        return Thread.currentThread().getId();
    }
}
