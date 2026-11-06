package com.datadog.android.internal.profiler;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DDExecutionTimer implements ExecutionTimer {
    private static final Companion Companion = new Companion(null);
    private final BenchmarkSdkUploads benchmarkSdkUploads;
    private final String track;

    public DDExecutionTimer(String track, BenchmarkSdkUploads benchmarkSdkUploads) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads, "benchmarkSdkUploads");
        this.track = track;
        this.benchmarkSdkUploads = benchmarkSdkUploads;
    }

    public /* synthetic */ DDExecutionTimer(String str, BenchmarkSdkUploads benchmarkSdkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? GlobalBenchmark.INSTANCE.getBenchmarkSdkUploads() : benchmarkSdkUploads);
    }

    @Override // com.datadog.android.internal.profiler.ExecutionTimer
    public Object measure(Function0 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.track.length() == 0) {
            return action.invoke();
        }
        long jNanoTime = System.nanoTime();
        Object objInvoke = action.invoke();
        responseLatencyReport((System.nanoTime() - jNanoTime) / 1.0E9d, this.track);
        return objInvoke;
    }

    private final void responseLatencyReport(final double d, String str) {
        this.benchmarkSdkUploads.getMeter("dd-sdk-android").createObservableGauge("android.benchmark.response_latency", MapsKt.mapOf(TuplesKt.to("track", str)), new Function0() { // from class: com.datadog.android.internal.profiler.DDExecutionTimer.responseLatencyReport.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                return Double.valueOf(d);
            }
        });
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
