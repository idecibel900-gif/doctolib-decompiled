package com.datadog.android.rum.internal.metric;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.model.ViewEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface SessionMetricDispatcher {
    void endMetric(String str, long j);

    void onMissedEventTracked(String str, SessionEndedMetric.MissedEventType missedEventType);

    void onSdkErrorTracked(String str, String str2);

    void onSessionReplaySkippedFrameTracked(String str);

    void onSessionStopped(String str);

    void onViewTracked(String str, ViewEvent viewEvent);

    void startMetric(String str, RumSessionScope.StartReason startReason, long j, boolean z);
}
