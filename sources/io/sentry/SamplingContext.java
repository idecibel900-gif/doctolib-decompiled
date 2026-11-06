package io.sentry;

import io.sentry.util.Objects;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SamplingContext {
    private final Map attributes;
    private final Double sampleRand;
    private final TransactionContext transactionContext;

    public SamplingContext(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, Double d, Map map) {
        this.transactionContext = (TransactionContext) Objects.requireNonNull(transactionContext, "transactionContexts is required");
        this.sampleRand = d;
        this.attributes = map == null ? Collections.EMPTY_MAP : map;
    }

    public TransactionContext getTransactionContext() {
        return this.transactionContext;
    }

    public Double getSampleRand() {
        return this.sampleRand;
    }
}
