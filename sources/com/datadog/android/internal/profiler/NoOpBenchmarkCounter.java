package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpBenchmarkCounter implements BenchmarkCounter {
    @Override // com.datadog.android.internal.profiler.BenchmarkCounter
    public void add(long j, Map attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }
}
