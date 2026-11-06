package com.datadog.android.ndk.internal;

import com.datadog.android.api.feature.FeatureSdkCore;

/* JADX INFO: loaded from: classes3.dex */
public interface NdkCrashHandler {

    public enum ReportTarget {
        RUM,
        LOGS
    }

    void handleNdkCrash(FeatureSdkCore featureSdkCore, ReportTarget reportTarget);

    void prepareData();
}
