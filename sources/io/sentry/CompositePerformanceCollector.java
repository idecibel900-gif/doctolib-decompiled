package io.sentry;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface CompositePerformanceCollector {
    void close();

    void onSpanFinished(ISpan iSpan);

    void onSpanStarted(ISpan iSpan);

    void start(ITransaction iTransaction);

    void start(String str);

    List stop(ITransaction iTransaction);

    List stop(String str);
}
