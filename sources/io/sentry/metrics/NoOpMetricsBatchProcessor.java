package io.sentry.metrics;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpMetricsBatchProcessor implements IMetricsBatchProcessor {
    private static final NoOpMetricsBatchProcessor instance = new NoOpMetricsBatchProcessor();

    @Override // io.sentry.metrics.IMetricsBatchProcessor
    public void close(boolean z) {
    }

    @Override // io.sentry.metrics.IMetricsBatchProcessor
    public void flush(long j) {
    }

    private NoOpMetricsBatchProcessor() {
    }

    public static NoOpMetricsBatchProcessor getInstance() {
        return instance;
    }
}
