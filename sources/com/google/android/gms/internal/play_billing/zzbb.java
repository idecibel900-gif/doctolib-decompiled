package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
final class zzbb extends zzbo {
    zzbb() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzbo
    public final long zza() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
