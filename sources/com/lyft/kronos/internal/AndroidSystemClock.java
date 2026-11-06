package com.lyft.kronos.internal;

import android.os.SystemClock;
import com.lyft.kronos.Clock;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidSystemClock implements Clock {
    @Override // com.lyft.kronos.Clock
    public long getCurrentTimeMs() {
        return System.currentTimeMillis();
    }

    @Override // com.lyft.kronos.Clock
    public long getElapsedTimeMs() {
        return SystemClock.elapsedRealtime();
    }
}
