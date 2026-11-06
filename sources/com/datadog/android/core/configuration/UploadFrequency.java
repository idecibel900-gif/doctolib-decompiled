package com.datadog.android.core.configuration;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;

/* JADX INFO: loaded from: classes3.dex */
public enum UploadFrequency {
    FREQUENT(500),
    AVERAGE(2000),
    RARE(HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS);

    private final long baseStepMs;

    UploadFrequency(long j) {
        this.baseStepMs = j;
    }

    public final long getBaseStepMs$dd_sdk_android_core_release() {
        return this.baseStepMs;
    }
}
