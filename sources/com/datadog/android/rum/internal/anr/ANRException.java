package com.datadog.android.rum.internal.anr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ANRException extends Exception {
    public ANRException(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        setStackTrace(thread.getStackTrace());
    }
}
