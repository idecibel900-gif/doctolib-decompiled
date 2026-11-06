package com.datadog.android.rum.internal.metric;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import com.datadog.android.rum.model.ViewEvent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SessionEndedMetricDispatcher implements SessionMetricDispatcher {
    private final InternalLogger internalLogger;
    private final ConcurrentHashMap metricsBySessionId;
    private final float sessionSamplingRate;

    public SessionEndedMetricDispatcher(InternalLogger internalLogger, float f) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.sessionSamplingRate = f;
        this.metricsBySessionId = new ConcurrentHashMap();
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void startMetric(String sessionId, RumSessionScope.StartReason startReason, long j, boolean z) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(startReason, "startReason");
        this.metricsBySessionId.put(sessionId, new SessionEndedMetric(sessionId, startReason, j, z));
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void endMetric(String sessionId, long j) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.remove(sessionId);
        if (sessionEndedMetric != null) {
            this.internalLogger.logMetric(new Function0() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher$endMetric$1$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "[Mobile Metric] RUM Session Ended";
                }
            }, sessionEndedMetric.toMetricAttributes(j), 15.0f, Float.valueOf(this.sessionSamplingRate));
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionStopped(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onSessionStopped();
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onViewTracked(final String sessionId, final ViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null ? sessionEndedMetric.onViewTracked(viewEvent) : false) {
            return;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher.onViewTracked.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SessionEndedMetricDispatcher.this.buildViewTrackError(sessionId, viewEvent);
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSdkErrorTracked(final String sessionId, final String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onErrorTracked(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.metric.SessionEndedMetricDispatcher.onSdkErrorTracked.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return SessionEndedMetricDispatcher.this.buildSdkErrorTrackError(sessionId, str);
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onMissedEventTracked(String sessionId, SessionEndedMetric.MissedEventType missedEventType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(missedEventType, "missedEventType");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onMissedEventTracked(missedEventType);
        }
    }

    @Override // com.datadog.android.rum.internal.metric.SessionMetricDispatcher
    public void onSessionReplaySkippedFrameTracked(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        SessionEndedMetric sessionEndedMetric = (SessionEndedMetric) this.metricsBySessionId.get(sessionId);
        if (sessionEndedMetric != null) {
            sessionEndedMetric.onSessionReplaySkippedFrameTracked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSdkErrorTrackError(String str, String str2) {
        return "Failed to track " + str2 + " error, session " + str + " has ended";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildViewTrackError(String str, ViewEvent viewEvent) {
        String str2;
        String url = viewEvent.getView().getUrl();
        if (Intrinsics.areEqual(url, "com/datadog/application-launch/view")) {
            str2 = "AppLaunch";
        } else {
            str2 = Intrinsics.areEqual(url, "com/datadog/background/view") ? "Background" : "Custom";
        }
        return "Failed to track " + str2 + " view in session with different UUID " + str;
    }
}
