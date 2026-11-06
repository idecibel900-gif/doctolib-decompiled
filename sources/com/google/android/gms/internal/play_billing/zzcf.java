package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzcf extends zzca {
    private final transient zzbz zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzcf(zzbz zzbzVar, Object[] objArr, int i, int i2) {
        this.zza = zzbzVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzca
    final zzbw zzh() {
        return new zzce(this);
    }
}
