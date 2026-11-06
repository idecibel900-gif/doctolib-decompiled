package com.datadog.android.core.internal.time;

import com.lyft.kronos.Clock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class KronosTimeProvider implements TimeProvider {
    private final Clock clock;

    public KronosTimeProvider(Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
    }

    @Override // com.datadog.android.core.internal.time.TimeProvider
    public long getDeviceTimestamp() {
        return System.currentTimeMillis();
    }

    @Override // com.datadog.android.core.internal.time.TimeProvider
    public long getServerTimestamp() {
        return this.clock.getCurrentTimeMs();
    }
}
