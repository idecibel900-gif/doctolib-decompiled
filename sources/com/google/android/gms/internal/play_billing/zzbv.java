package com.google.android.gms.internal.play_billing;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbv extends zzbw {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbw zzc;

    zzbv(zzbw zzbwVar, int i, int i2) {
        Objects.requireNonNull(zzbwVar);
        this.zzc = zzbwVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbj.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    /* JADX INFO: renamed from: zzh */
    public final zzbw subList(int i, int i2) {
        zzbj.zzd(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
