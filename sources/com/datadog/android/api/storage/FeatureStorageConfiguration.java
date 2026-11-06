package com.datadog.android.api.storage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureStorageConfiguration {
    public static final Companion Companion = new Companion(null);
    private static final FeatureStorageConfiguration DEFAULT = new FeatureStorageConfiguration(524288, 500, 4194304, 64800000);
    private final long maxBatchSize;
    private final long maxItemSize;
    private final int maxItemsPerBatch;
    private final long oldBatchThreshold;

    public static /* synthetic */ FeatureStorageConfiguration copy$default(FeatureStorageConfiguration featureStorageConfiguration, long j, int i, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = featureStorageConfiguration.maxItemSize;
        }
        long j4 = j;
        if ((i2 & 2) != 0) {
            i = featureStorageConfiguration.maxItemsPerBatch;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = featureStorageConfiguration.maxBatchSize;
        }
        long j5 = j2;
        if ((i2 & 8) != 0) {
            j3 = featureStorageConfiguration.oldBatchThreshold;
        }
        return featureStorageConfiguration.copy(j4, i3, j5, j3);
    }

    public final FeatureStorageConfiguration copy(long j, int i, long j2, long j3) {
        return new FeatureStorageConfiguration(j, i, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureStorageConfiguration)) {
            return false;
        }
        FeatureStorageConfiguration featureStorageConfiguration = (FeatureStorageConfiguration) obj;
        return this.maxItemSize == featureStorageConfiguration.maxItemSize && this.maxItemsPerBatch == featureStorageConfiguration.maxItemsPerBatch && this.maxBatchSize == featureStorageConfiguration.maxBatchSize && this.oldBatchThreshold == featureStorageConfiguration.oldBatchThreshold;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.maxItemSize) * 31) + Integer.hashCode(this.maxItemsPerBatch)) * 31) + Long.hashCode(this.maxBatchSize)) * 31) + Long.hashCode(this.oldBatchThreshold);
    }

    public String toString() {
        return "FeatureStorageConfiguration(maxItemSize=" + this.maxItemSize + ", maxItemsPerBatch=" + this.maxItemsPerBatch + ", maxBatchSize=" + this.maxBatchSize + ", oldBatchThreshold=" + this.oldBatchThreshold + ")";
    }

    public FeatureStorageConfiguration(long j, int i, long j2, long j3) {
        this.maxItemSize = j;
        this.maxItemsPerBatch = i;
        this.maxBatchSize = j2;
        this.oldBatchThreshold = j3;
    }

    public final long getMaxItemSize() {
        return this.maxItemSize;
    }

    public final int getMaxItemsPerBatch() {
        return this.maxItemsPerBatch;
    }

    public final long getMaxBatchSize() {
        return this.maxBatchSize;
    }

    public final long getOldBatchThreshold() {
        return this.oldBatchThreshold;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FeatureStorageConfiguration getDEFAULT() {
            return FeatureStorageConfiguration.DEFAULT;
        }
    }
}
