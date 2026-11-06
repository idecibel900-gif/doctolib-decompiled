package com.datadog.android.internal.profiler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpBenchmarkSdkUploads implements BenchmarkSdkUploads {
    @Override // com.datadog.android.internal.profiler.BenchmarkSdkUploads
    public BenchmarkMeter getMeter(String operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new NoOpBenchmarkMeter();
    }
}
