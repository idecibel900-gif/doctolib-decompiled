package com.datadog.android.trace;

import com.datadog.android.api.SdkCore;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.trace.internal.TracingFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Trace {
    public static final Trace INSTANCE = new Trace();

    private Trace() {
    }

    public static final void enable(TraceConfiguration traceConfiguration, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(traceConfiguration, "traceConfiguration");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        FeatureSdkCore featureSdkCore = (FeatureSdkCore) sdkCore;
        featureSdkCore.registerFeature(new TracingFeature(featureSdkCore, traceConfiguration.getCustomEndpointUrl$dd_sdk_android_trace_release(), traceConfiguration.getEventMapper$dd_sdk_android_trace_release(), traceConfiguration.getNetworkInfoEnabled$dd_sdk_android_trace_release()));
    }
}
