package com.datadog.android.internal.profiler;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpExecutionTimer implements ExecutionTimer {
    @Override // com.datadog.android.internal.profiler.ExecutionTimer
    public Object measure(Function0 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke();
    }
}
