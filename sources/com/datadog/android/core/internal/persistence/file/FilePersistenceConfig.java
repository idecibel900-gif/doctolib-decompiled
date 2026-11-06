package com.datadog.android.core.internal.persistence.file;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class FilePersistenceConfig {
    public static final Companion Companion = new Companion(null);
    private final long cleanupFrequencyThreshold;
    private final long maxBatchSize;
    private final long maxDiskSpace;
    private final long maxItemSize;
    private final int maxItemsPerBatch;
    private final long oldFileThreshold;
    private final long recentDelayMs;

    public final FilePersistenceConfig copy(long j, long j2, long j3, int i, long j4, long j5, long j6) {
        return new FilePersistenceConfig(j, j2, j3, i, j4, j5, j6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePersistenceConfig)) {
            return false;
        }
        FilePersistenceConfig filePersistenceConfig = (FilePersistenceConfig) obj;
        return this.recentDelayMs == filePersistenceConfig.recentDelayMs && this.maxBatchSize == filePersistenceConfig.maxBatchSize && this.maxItemSize == filePersistenceConfig.maxItemSize && this.maxItemsPerBatch == filePersistenceConfig.maxItemsPerBatch && this.oldFileThreshold == filePersistenceConfig.oldFileThreshold && this.maxDiskSpace == filePersistenceConfig.maxDiskSpace && this.cleanupFrequencyThreshold == filePersistenceConfig.cleanupFrequencyThreshold;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.recentDelayMs) * 31) + Long.hashCode(this.maxBatchSize)) * 31) + Long.hashCode(this.maxItemSize)) * 31) + Integer.hashCode(this.maxItemsPerBatch)) * 31) + Long.hashCode(this.oldFileThreshold)) * 31) + Long.hashCode(this.maxDiskSpace)) * 31) + Long.hashCode(this.cleanupFrequencyThreshold);
    }

    public String toString() {
        return "FilePersistenceConfig(recentDelayMs=" + this.recentDelayMs + ", maxBatchSize=" + this.maxBatchSize + ", maxItemSize=" + this.maxItemSize + ", maxItemsPerBatch=" + this.maxItemsPerBatch + ", oldFileThreshold=" + this.oldFileThreshold + ", maxDiskSpace=" + this.maxDiskSpace + ", cleanupFrequencyThreshold=" + this.cleanupFrequencyThreshold + ")";
    }

    public FilePersistenceConfig(long j, long j2, long j3, int i, long j4, long j5, long j6) {
        this.recentDelayMs = j;
        this.maxBatchSize = j2;
        this.maxItemSize = j3;
        this.maxItemsPerBatch = i;
        this.oldFileThreshold = j4;
        this.maxDiskSpace = j5;
        this.cleanupFrequencyThreshold = j6;
    }

    public /* synthetic */ FilePersistenceConfig(long j, long j2, long j3, int i, long j4, long j5, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5000L : j, (i2 & 2) != 0 ? 4194304L : j2, (i2 & 4) != 0 ? 524288L : j3, (i2 & 8) != 0 ? 500 : i, (i2 & 16) != 0 ? 64800000L : j4, (i2 & 32) != 0 ? 536870912L : j5, (i2 & 64) != 0 ? 5000L : j6);
    }

    public final long getRecentDelayMs() {
        return this.recentDelayMs;
    }

    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    public final long getOldFileThreshold() {
        return this.oldFileThreshold;
    }

    public final long getMaxDiskSpace() {
        return this.maxDiskSpace;
    }

    public final long getCleanupFrequencyThreshold() {
        return this.cleanupFrequencyThreshold;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
