package com.datadog.android.log;

import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.log.internal.LogsFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Logs {
    public static final Logs INSTANCE = new Logs();

    private Logs() {
    }

    public static final void enable(LogsConfiguration logsConfiguration, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(logsConfiguration, "logsConfiguration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        featureSdkCore.registerFeature(new LogsFeature(featureSdkCore, logsConfiguration.getCustomEndpointUrl$dd_sdk_android_logs_release(), logsConfiguration.getEventMapper$dd_sdk_android_logs_release()));
    }
}
