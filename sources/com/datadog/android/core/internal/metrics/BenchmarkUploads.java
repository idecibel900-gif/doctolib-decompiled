package com.datadog.android.core.internal.metrics;

import com.datadog.android.internal.profiler.BenchmarkSdkUploads;
import com.datadog.android.internal.profiler.GlobalBenchmark;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BenchmarkUploads {
    public static final Companion Companion = new Companion(null);
    private final BenchmarkSdkUploads benchmarkSdkUploads;

    public BenchmarkUploads(BenchmarkSdkUploads benchmarkSdkUploads) {
        Intrinsics.checkNotNullParameter(benchmarkSdkUploads, "benchmarkSdkUploads");
        this.benchmarkSdkUploads = benchmarkSdkUploads;
    }

    public /* synthetic */ BenchmarkUploads(BenchmarkSdkUploads benchmarkSdkUploads, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlobalBenchmark.INSTANCE.getBenchmarkSdkUploads() : benchmarkSdkUploads);
    }

    public final void sendBenchmarkBytesUploaded$dd_sdk_android_core_release(String featureName, long j) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, "android.benchmark.bytes_uploaded", j);
    }

    public final void sendBenchmarkBytesDeleted$dd_sdk_android_core_release(String featureName, long j) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, "android.benchmark.bytes_deleted", j);
    }

    public final void sendBenchmarkBytesWritten$dd_sdk_android_core_release(String featureName, long j) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, "android.benchmark.bytes_written", j);
    }

    public final void incrementBenchmarkUploadsCount$dd_sdk_android_core_release(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sendBenchmarkUploads(featureName, "android.benchmark.upload_count", 1L);
    }

    private final void sendBenchmarkUploads(String str, String str2, long j) {
        this.benchmarkSdkUploads.getMeter("dd-sdk-android").getCounter(str2).add(j, MapsKt.mapOf(TuplesKt.to("track", str)));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
