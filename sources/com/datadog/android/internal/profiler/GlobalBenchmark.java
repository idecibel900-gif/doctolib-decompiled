package com.datadog.android.internal.profiler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalBenchmark {
    public static final GlobalBenchmark INSTANCE = new GlobalBenchmark();
    private static BenchmarkProfiler benchmarkProfiler = new NoOpBenchmarkProfiler();
    private static BenchmarkSdkUploads benchmarkSdkUploads = new NoOpBenchmarkSdkUploads();

    private GlobalBenchmark() {
    }

    public final BenchmarkSdkUploads getBenchmarkSdkUploads() {
        return benchmarkSdkUploads;
    }

    public final ExecutionTimer createExecutionTimer(String track) {
        Intrinsics.checkNotNullParameter(track, "track");
        if (benchmarkSdkUploads instanceof NoOpBenchmarkSdkUploads) {
            return new NoOpExecutionTimer();
        }
        return new DDExecutionTimer(track, null, 2, null);
    }
}
