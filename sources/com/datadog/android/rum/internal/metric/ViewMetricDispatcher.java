package com.datadog.android.rum.internal.metric;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewMetricDispatcher {
    void onDurationResolved(long j);

    void onViewLoadingTimeResolved(long j);

    void sendViewEnded(ViewInitializationMetricsState viewInitializationMetricsState, ViewInitializationMetricsState viewInitializationMetricsState2);
}
