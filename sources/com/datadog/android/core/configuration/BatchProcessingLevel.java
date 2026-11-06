package com.datadog.android.core.configuration;

/* JADX INFO: loaded from: classes3.dex */
public enum BatchProcessingLevel {
    LOW(1),
    MEDIUM(20),
    HIGH(100);

    private final int maxBatchesPerUploadJob;

    BatchProcessingLevel(int i) {
        this.maxBatchesPerUploadJob = i;
    }

    public final int getMaxBatchesPerUploadJob() {
        return this.maxBatchesPerUploadJob;
    }
}
