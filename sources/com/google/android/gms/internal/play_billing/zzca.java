package com.google.android.gms.internal.play_billing;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzca extends zzbt implements Set {
    private transient zzbw zza;

    zzca() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzcj.zza(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public zzbw zzd() {
        zzbw zzbwVar = this.zza;
        if (zzbwVar != null) {
            return zzbwVar;
        }
        zzbw zzbwVarZzh = zzh();
        this.zza = zzbwVarZzh;
        return zzbwVarZzh;
    }

    zzbw zzh() {
        Object[] array = toArray();
        int i = zzbw.$r8$clinit;
        return zzbw.zzi(array, array.length);
    }
}
