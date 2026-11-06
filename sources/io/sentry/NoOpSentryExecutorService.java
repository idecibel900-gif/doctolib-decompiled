package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpSentryExecutorService implements ISentryExecutorService {
    private static final NoOpSentryExecutorService instance = new NoOpSentryExecutorService();

    @Override // io.sentry.ISentryExecutorService
    public void close(long j) {
    }

    @Override // io.sentry.ISentryExecutorService
    public boolean isClosed() {
        return false;
    }

    @Override // io.sentry.ISentryExecutorService
    public void prewarm() {
    }

    private NoOpSentryExecutorService() {
    }

    public static ISentryExecutorService getInstance() {
        return instance;
    }

    public static /* synthetic */ Object $r8$lambda$QwqSlniMDN0uXNxKPiPiRMo5zRo() {
        return null;
    }

    @Override // io.sentry.ISentryExecutorService
    public Future submit(Runnable runnable) {
        return new FutureTask(new Callable() { // from class: io.sentry.NoOpSentryExecutorService$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NoOpSentryExecutorService.$r8$lambda$QwqSlniMDN0uXNxKPiPiRMo5zRo();
            }
        });
    }

    public static /* synthetic */ Object $r8$lambda$V1LAgciVdoGWhDr3mXVEGgoFtKA() {
        return null;
    }

    @Override // io.sentry.ISentryExecutorService
    public Future schedule(Runnable runnable, long j) {
        return new FutureTask(new Callable() { // from class: io.sentry.NoOpSentryExecutorService$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NoOpSentryExecutorService.$r8$lambda$V1LAgciVdoGWhDr3mXVEGgoFtKA();
            }
        });
    }
}
