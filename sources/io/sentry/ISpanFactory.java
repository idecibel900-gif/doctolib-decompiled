package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public interface ISpanFactory {
    ITransaction createTransaction(TransactionContext transactionContext, IScopes iScopes, TransactionOptions transactionOptions, CompositePerformanceCollector compositePerformanceCollector);
}
