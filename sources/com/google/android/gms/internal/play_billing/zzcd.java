package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcd extends zzbw {
    static final zzbw zza = new zzcd(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzcd(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbj.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, com.google.android.gms.internal.play_billing.zzbt
    final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final Object[] zzg() {
        return this.zzb;
    }
}
