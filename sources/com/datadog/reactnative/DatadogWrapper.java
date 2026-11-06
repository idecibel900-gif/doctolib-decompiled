package com.datadog.reactnative;

import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.log.LogsConfiguration;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.RumConfiguration;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.trace.TraceConfiguration;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface DatadogWrapper {
    void addRumGlobalAttributes(Map map);

    void addUserExtraInfo(Map map);

    void clearAllData();

    void consumeWebviewEvent(String str);

    void enableLogs(LogsConfiguration logsConfiguration);

    void enableRum(RumConfiguration rumConfiguration);

    void enableTrace(TraceConfiguration traceConfiguration);

    boolean getBundleLogsWithRum();

    boolean getBundleLogsWithTraces();

    RumMonitor getRumMonitor();

    void initialize(Context context, Configuration configuration, TrackingConsent trackingConsent);

    boolean isInitialized();

    void sendTelemetryLog(String str, ReadableMap readableMap, ReadableMap readableMap2);

    void setBundleLogsWithRum(boolean z);

    void setBundleLogsWithTraces(boolean z);

    void setTrackingConsent(TrackingConsent trackingConsent);

    void setUser(String str, String str2, String str3, Map map);

    void setUserInfo(String str, String str2, String str3, Map map);

    void setVerbosity(int i);

    void telemetryDebug(String str);

    void telemetryError(String str, String str2, String str3);

    void telemetryError(String str, Throwable th);
}
