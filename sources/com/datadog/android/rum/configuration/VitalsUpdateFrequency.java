package com.datadog.android.rum.configuration;

/* JADX INFO: loaded from: classes3.dex */
public enum VitalsUpdateFrequency {
    FREQUENT(100),
    AVERAGE(500),
    RARE(1000),
    NEVER(0);

    private final long periodInMs;

    VitalsUpdateFrequency(long j) {
        this.periodInMs = j;
    }

    public final long getPeriodInMs$dd_sdk_android_rum_release() {
        return this.periodInMs;
    }
}
