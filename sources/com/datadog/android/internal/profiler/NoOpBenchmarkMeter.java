package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpBenchmarkMeter implements BenchmarkMeter {
    @Override // com.datadog.android.internal.profiler.BenchmarkMeter
    public void createObservableGauge(String metricName, Map tags, Function0 callback) {
        Intrinsics.checkNotNullParameter(metricName, "metricName");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.datadog.android.internal.profiler.BenchmarkMeter
    public BenchmarkCounter getCounter(String operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new NoOpBenchmarkCounter();
    }
}
