package io.sentry.metrics;

/* JADX INFO: loaded from: classes5.dex */
public interface IMetricsBatchProcessor {
    void close(boolean z);

    void flush(long j);
}
