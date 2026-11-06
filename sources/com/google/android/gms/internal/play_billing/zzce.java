package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzce extends zzbw {
    final /* synthetic */ zzcf zza;

    zzce(zzcf zzcfVar) {
        Objects.requireNonNull(zzcfVar);
        this.zza = zzcfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzcf zzcfVar = this.zza;
        zzbj.zza(i, zzcfVar.zzc, "index");
        int i2 = i + i;
        Object obj = zzcfVar.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = zzcfVar.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public final boolean zzf() {
        return true;
    }
}
