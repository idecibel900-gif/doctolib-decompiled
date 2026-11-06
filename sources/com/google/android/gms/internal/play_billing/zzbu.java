package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
final class zzbu extends zzbq {
    private final zzbw zza;

    zzbu(zzbw zzbwVar, int i) {
        super(zzbwVar.size(), i);
        this.zza = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
