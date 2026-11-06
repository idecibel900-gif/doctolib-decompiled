package com.datadog.android.internal.utils;

import android.os.StrictMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StrictModeExtKt {
    public static final Object allowThreadDiskReads(Function0 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return operation.invoke();
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }
}
