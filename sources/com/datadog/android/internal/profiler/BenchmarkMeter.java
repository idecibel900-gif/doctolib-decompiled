package com.datadog.android.internal.profiler;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface BenchmarkMeter {
    void createObservableGauge(String str, Map map, Function0 function0);

    BenchmarkCounter getCounter(String str);
}
