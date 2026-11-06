package com.datadog.android.core.internal.configuration;

import com.datadog.android.core.configuration.UploadFrequency;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataUploadConfiguration {
    public static final Companion Companion = new Companion(null);
    private final long defaultDelayMs;
    private final UploadFrequency frequency;
    private final int maxBatchesPerUploadJob;
    private final long maxDelayMs;
    private final long minDelayMs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataUploadConfiguration)) {
            return false;
        }
        DataUploadConfiguration dataUploadConfiguration = (DataUploadConfiguration) obj;
        return this.frequency == dataUploadConfiguration.frequency && this.maxBatchesPerUploadJob == dataUploadConfiguration.maxBatchesPerUploadJob;
    }

    public int hashCode() {
        return (this.frequency.hashCode() * 31) + Integer.hashCode(this.maxBatchesPerUploadJob);
    }

    public String toString() {
        return "DataUploadConfiguration(frequency=" + this.frequency + ", maxBatchesPerUploadJob=" + this.maxBatchesPerUploadJob + ")";
    }

    public DataUploadConfiguration(UploadFrequency frequency, int i) {
        Intrinsics.checkNotNullParameter(frequency, "frequency");
        this.frequency = frequency;
        this.maxBatchesPerUploadJob = i;
        this.minDelayMs = frequency.getBaseStepMs$dd_sdk_android_core_release();
        this.maxDelayMs = ((long) 10) * frequency.getBaseStepMs$dd_sdk_android_core_release();
        this.defaultDelayMs = ((long) 5) * frequency.getBaseStepMs$dd_sdk_android_core_release();
    }

    public final int getMaxBatchesPerUploadJob$dd_sdk_android_core_release() {
        return this.maxBatchesPerUploadJob;
    }

    public final long getMinDelayMs$dd_sdk_android_core_release() {
        return this.minDelayMs;
    }

    public final long getMaxDelayMs$dd_sdk_android_core_release() {
        return this.maxDelayMs;
    }

    public final long getDefaultDelayMs$dd_sdk_android_core_release() {
        return this.defaultDelayMs;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
