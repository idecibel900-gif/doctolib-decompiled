package com.facebook.react.devsupport.perfmonitor;

import com.facebook.react.devsupport.inspector.TracingState;

/* JADX INFO: loaded from: classes3.dex */
public interface PerfMonitorInspectorTargetBinding {
    TracingState getTracingState();

    boolean pauseAndAnalyzeBackgroundTrace();

    void resumeBackgroundTrace();

    void stopBackgroundTrace();
}
