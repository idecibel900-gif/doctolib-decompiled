package com.google.android.gms.common.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultClock implements Clock {
    private static final DefaultClock zza = new DefaultClock();

    private DefaultClock() {
    }

    public static Clock getInstance() {
        return zza;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
