package com.facebook.react.common;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ShakeDetectorKt {
    private static final long MIN_TIME_BETWEEN_SAMPLES_NS;
    private static final float SHAKING_WINDOW_NS;

    static {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        MIN_TIME_BETWEEN_SAMPLES_NS = timeUnit.convert(20L, TimeUnit.MILLISECONDS);
        SHAKING_WINDOW_NS = timeUnit.convert(3L, TimeUnit.SECONDS);
    }
}
