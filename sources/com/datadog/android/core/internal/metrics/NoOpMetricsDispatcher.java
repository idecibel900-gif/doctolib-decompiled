package com.datadog.android.core.internal.metrics;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpMetricsDispatcher implements MetricsDispatcher {
    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchClosedMetric(File batchFile, BatchClosedMetadata batchMetadata) {
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(batchMetadata, "batchMetadata");
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchDeletedMetric(File batchFile, RemovalReason removalReason, int i) {
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
    }
}
