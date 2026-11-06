package com.google.android.gms.internal.play_billing;

import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes3.dex */
final class zzfg {
    private final Object zza;
    private final int zzb;

    zzfg(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        return this.zza == zzfgVar.zza && this.zzb == zzfgVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.zzb;
    }
}
