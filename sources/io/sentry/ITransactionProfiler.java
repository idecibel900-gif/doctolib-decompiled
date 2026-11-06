package io.sentry;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface ITransactionProfiler {
    void bindTransaction(ITransaction iTransaction);

    void close();

    boolean isRunning();

    ProfilingTraceData onTransactionFinish(ITransaction iTransaction, List list, SentryOptions sentryOptions);

    void start();
}
