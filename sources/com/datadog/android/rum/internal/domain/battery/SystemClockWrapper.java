package com.datadog.android.rum.internal.domain.battery;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemClockWrapper {
    public final long elapsedRealTime() {
        return SystemClock.elapsedRealtime();
    }
}
