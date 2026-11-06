package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public interface IPerformanceContinuousCollector extends IPerformanceCollector {
    void clear();

    void onSpanFinished(ISpan iSpan);

    void onSpanStarted(ISpan iSpan);
}
