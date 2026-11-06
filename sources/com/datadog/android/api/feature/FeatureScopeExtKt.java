package com.datadog.android.api.feature;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.metrics.PerformanceMetric;
import com.datadog.android.core.metrics.TelemetryMetricType;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FeatureScopeExtKt {
    public static final Object measureMethodCallPerf(InternalLogger internalLogger, Class callerClass, String operationName, float f, Function0 operation) {
        Intrinsics.checkNotNullParameter(internalLogger, "<this>");
        Intrinsics.checkNotNullParameter(callerClass, "callerClass");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        Intrinsics.checkNotNullParameter(operation, "operation");
        String name = callerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "callerClass.name");
        PerformanceMetric performanceMetricStartPerformanceMeasure = internalLogger.startPerformanceMeasure(name, TelemetryMetricType.MethodCalled, f, operationName);
        Object objInvoke = operation.invoke();
        boolean z = (objInvoke == null || ((objInvoke instanceof Collection) && ((Collection) objInvoke).isEmpty())) ? false : true;
        if (performanceMetricStartPerformanceMeasure != null) {
            performanceMetricStartPerformanceMeasure.stopAndSend(z);
        }
        return objInvoke;
    }
}
