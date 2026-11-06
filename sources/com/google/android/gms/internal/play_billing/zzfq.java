package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfq extends zzef {
    protected zzfu zza;
    private final zzfu zzb;

    protected zzfq(zzfu zzfuVar) {
        this.zzb = zzfuVar;
        if (zzfuVar.zzF()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzfuVar.zzs();
    }

    private static void zza(Object obj, Object obj2) {
        zzhi.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzfq clone() {
        zzfq zzfqVar = (zzfq) this.zzb.zzd(5, null, null);
        zzfqVar.zza = zzk();
        return zzfqVar;
    }

    public final zzfq zzh(zzfu zzfuVar) {
        if (!this.zzb.equals(zzfuVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzfuVar);
        }
        return this;
    }

    public final zzfu zzi() {
        zzfu zzfuVarZzk = zzk();
        if (zzfuVarZzk.zzo()) {
            return zzfuVarZzk;
        }
        throw new zzia(zzfuVarZzk);
    }

    @Override // com.google.android.gms.internal.play_billing.zzha
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public zzfu zzk() {
        if (!this.zza.zzF()) {
            return this.zza;
        }
        this.zza.zzz();
        return this.zza;
    }

    protected final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    protected void zzn() {
        zzfu zzfuVarZzs = this.zzb.zzs();
        zza(zzfuVarZzs, this.zza);
        this.zza = zzfuVarZzs;
    }
}
