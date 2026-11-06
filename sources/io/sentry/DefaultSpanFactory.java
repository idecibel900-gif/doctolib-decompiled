package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultSpanFactory implements ISpanFactory {
    @Override // io.sentry.ISpanFactory
    public ITransaction createTransaction(TransactionContext transactionContext, IScopes iScopes, TransactionOptions transactionOptions, CompositePerformanceCollector compositePerformanceCollector) {
        return new SentryTracer(transactionContext, iScopes, transactionOptions, compositePerformanceCollector);
    }
}
