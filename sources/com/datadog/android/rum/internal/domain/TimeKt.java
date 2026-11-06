package com.datadog.android.rum.internal.domain;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TimeKt {
    public static final Time asTime(long j) {
        Time time = new Time(0L, 0L, 3, null);
        return new Time(j, TimeUnit.MILLISECONDS.toNanos(j - time.getTimestamp()) + time.getNanoTime());
    }
}
