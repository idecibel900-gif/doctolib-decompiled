package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
final class zzbc extends zzbo {
    zzbc() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzbo
    public final long zza() {
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
