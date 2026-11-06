package com.datadog.legacy.trace.common.util;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Clock {
    public static long currentNanoTicks() {
        return System.nanoTime();
    }

    public static long currentMicroTime() {
        return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
    }

    public static long currentNanoTime() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }
}
