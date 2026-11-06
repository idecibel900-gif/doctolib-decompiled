package com.datadog.android.core.internal.metrics;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface MetricsDispatcher {
    void sendBatchClosedMetric(File file, BatchClosedMetadata batchClosedMetadata);

    void sendBatchDeletedMetric(File file, RemovalReason removalReason, int i);
}
