package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class AwakeTimeSinceBootClock implements MonotonicNanoClock {

    @DoNotStrip
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    @Override // com.facebook.common.time.MonotonicNanoClock, com.facebook.common.time.MonotonicClock
    @DoNotStrip
    public /* bridge */ /* synthetic */ long now() {
        return super.now();
    }

    private AwakeTimeSinceBootClock() {
    }

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicNanoClock, com.facebook.common.time.MonotonicClock
    @DoNotStrip
    public long nowNanos() {
        return System.nanoTime();
    }
}
