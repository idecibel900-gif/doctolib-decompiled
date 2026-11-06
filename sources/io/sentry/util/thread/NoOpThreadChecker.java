package io.sentry.util.thread;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpThreadChecker implements IThreadChecker {
    private static final NoOpThreadChecker instance = new NoOpThreadChecker();

    @Override // io.sentry.util.thread.IThreadChecker
    public long currentThreadSystemId() {
        return 0L;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public boolean isMainThread() {
        return false;
    }

    public static NoOpThreadChecker getInstance() {
        return instance;
    }

    @Override // io.sentry.util.thread.IThreadChecker
    public String getCurrentThreadName() {
        return "";
    }
}
