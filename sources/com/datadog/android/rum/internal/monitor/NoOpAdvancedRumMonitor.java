package com.datadog.android.rum.internal.monitor;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumPerformanceMetric;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumResourceMethod;
import com.datadog.android.rum._RumInternalProxy;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpAdvancedRumMonitor implements AdvancedRumMonitor {
    @Override // com.datadog.android.rum.RumMonitor
    public _RumInternalProxy _getInternal() {
        return null;
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAction(RumActionType type, String name, Map attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addAttribute(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addCrash(String message, RumErrorSource source, Throwable throwable, List threads) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(threads, "threads");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addError(String message, RumErrorSource source, Throwable th, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addErrorWithStacktrace(String message, RumErrorSource source, String str, Map attributes) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addFeatureFlagEvaluation(String name, Object value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addLongTask(long j, String target) {
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void addSessionReplaySkippedFrame() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addTiming(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void addViewLoadingTime(boolean z) {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventDropped(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void eventSent(String viewId, StorageEvent event) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void getCurrentSessionId(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendTelemetryEvent(InternalTelemetryEvent telemetryEvent) {
        Intrinsics.checkNotNullParameter(telemetryEvent, "telemetryEvent");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void sendWebViewEvent() {
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void setSyntheticsAttribute(String testId, String resultId) {
        Intrinsics.checkNotNullParameter(testId, "testId");
        Intrinsics.checkNotNullParameter(resultId, "resultId");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startAction(RumActionType type, String name, Map attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startResource(String key, RumResourceMethod method, String url, Map attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void startView(Object key, String name, Map attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopAction(RumActionType type, String name, Map attributes) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopResource(String key, Integer num, Long l, RumResourceKind kind, Map attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopSession() {
    }

    @Override // com.datadog.android.rum.RumMonitor
    public void stopView(Object key, Map attributes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }

    @Override // com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
    public void updatePerformanceMetric(RumPerformanceMetric metric, double d) {
        Intrinsics.checkNotNullParameter(metric, "metric");
    }

    @Override // com.datadog.android.rum.RumMonitor
    public Map getAttributes() {
        return MapsKt.emptyMap();
    }
}
