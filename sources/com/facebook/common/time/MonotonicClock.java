package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface MonotonicClock {
    @DoNotStrip
    long nowNanos();

    @DoNotStrip
    default long now() {
        return TimeUnit.NANOSECONDS.toMillis(nowNanos());
    }
}
