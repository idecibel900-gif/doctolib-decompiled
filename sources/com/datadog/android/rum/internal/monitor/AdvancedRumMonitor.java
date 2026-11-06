package com.datadog.android.rum.internal.monitor;

import com.datadog.android.internal.telemetry.InternalTelemetryEvent;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumPerformanceMetric;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AdvancedRumMonitor extends RumMonitor {
    void addCrash(String str, RumErrorSource rumErrorSource, Throwable th, List list);

    void addLongTask(long j, String str);

    void addSessionReplaySkippedFrame();

    void eventDropped(String str, StorageEvent storageEvent);

    void eventSent(String str, StorageEvent storageEvent);

    void sendTelemetryEvent(InternalTelemetryEvent internalTelemetryEvent);

    void sendWebViewEvent();

    void setSyntheticsAttribute(String str, String str2);

    void updatePerformanceMetric(RumPerformanceMetric rumPerformanceMetric, double d);
}
