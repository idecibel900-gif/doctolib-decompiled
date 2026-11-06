package com.datadog.android.ndk.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpNdkCrashHandler implements NdkCrashHandler {
    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void handleNdkCrash(FeatureSdkCore sdkCore, NdkCrashHandler.ReportTarget reportTarget) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(reportTarget, "reportTarget");
    }

    @Override // com.datadog.android.ndk.internal.NdkCrashHandler
    public void prepareData() {
    }
}
