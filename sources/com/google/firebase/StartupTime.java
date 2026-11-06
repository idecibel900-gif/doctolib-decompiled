package com.google.firebase;

import android.os.SystemClock;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class StartupTime {
    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();

    public static StartupTime create(long j, long j2, long j3) {
        return new AutoValue_StartupTime(j, j2, j3);
    }

    public static StartupTime now() {
        return create(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }
}
