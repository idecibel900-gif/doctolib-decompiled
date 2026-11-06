package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.core.internal.metrics.RemovalReason;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface Storage {
    void confirmBatchRead(BatchId batchId, RemovalReason removalReason, boolean z);

    void dropAll();

    BatchData readNextBatch();

    void writeCurrentBatch(DatadogContext datadogContext, boolean z, Function1 function1);
}
