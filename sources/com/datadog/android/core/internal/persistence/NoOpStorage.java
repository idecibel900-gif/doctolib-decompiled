package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.metrics.RemovalReason;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpStorage implements Storage {
    @Override // com.datadog.android.core.internal.persistence.Storage
    public void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean z) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void dropAll() {
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public BatchData readNextBatch() {
        return null;
    }

    @Override // com.datadog.android.core.internal.persistence.Storage
    public void writeCurrentBatch(DatadogContext datadogContext, boolean z, Function1 callback) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }
}
