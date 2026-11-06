package com.datadog.android.core.internal.metrics;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.metrics.MethodCallSamplingRate;
import com.datadog.android.core.metrics.PerformanceMetric;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MethodCalledTelemetry implements PerformanceMetric {
    public static final Companion Companion = new Companion(null);
    private final String callerClass;
    private final float creationSampleRate;
    private final InternalLogger internalLogger;
    private final String operationName;
    private final long startTime;

    public MethodCalledTelemetry(InternalLogger internalLogger, String operationName, String callerClass, float f, long j) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        this.internalLogger = internalLogger;
        this.operationName = operationName;
        this.callerClass = callerClass;
        this.creationSampleRate = f;
        this.startTime = j;
    }

    public /* synthetic */ MethodCalledTelemetry(InternalLogger internalLogger, String str, String str2, float f, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalLogger, str, str2, f, (i & 16) != 0 ? System.nanoTime() : j);
    }

    @Override // com.datadog.android.core.metrics.PerformanceMetric
    public void stopAndSend(boolean z) {
        long jNanoTime = System.nanoTime() - this.startTime;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("execution_time", Long.valueOf(jNanoTime));
        linkedHashMap.put("operation_name", this.operationName);
        linkedHashMap.put("caller_class", this.callerClass);
        linkedHashMap.put("is_successful", Boolean.valueOf(z));
        linkedHashMap.put("metric_type", "method called");
        this.internalLogger.logMetric(new Function0() { // from class: com.datadog.android.core.internal.metrics.MethodCalledTelemetry.stopAndSend.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "[Mobile Metric] Method Called";
            }
        }, linkedHashMap, MethodCallSamplingRate.ALL.getRate(), Float.valueOf(this.creationSampleRate));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
