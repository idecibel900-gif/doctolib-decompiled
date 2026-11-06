package io.sentry.logger;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpLoggerBatchProcessor implements ILoggerBatchProcessor {
    private static final NoOpLoggerBatchProcessor instance = new NoOpLoggerBatchProcessor();

    @Override // io.sentry.logger.ILoggerBatchProcessor
    public void close(boolean z) {
    }

    @Override // io.sentry.logger.ILoggerBatchProcessor
    public void flush(long j) {
    }

    private NoOpLoggerBatchProcessor() {
    }

    public static NoOpLoggerBatchProcessor getInstance() {
        return instance;
    }
}
