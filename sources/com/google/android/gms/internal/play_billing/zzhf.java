package com.google.android.gms.internal.play_billing;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;

/* JADX INFO: loaded from: classes3.dex */
final class zzhf implements zzhl {
    private final zzhb zza;
    private final zzib zzb;
    private final boolean zzc = false;
    private final zzfi zzd;

    private zzhf(zzib zzibVar, zzfi zzfiVar, zzhb zzhbVar) {
        this.zzb = zzibVar;
        this.zzd = zzfiVar;
        this.zza = zzhbVar;
    }

    static zzhf zzc(zzib zzibVar, zzfi zzfiVar, zzhb zzhbVar) {
        return new zzhf(zzibVar, zzfiVar, zzhbVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zza(Object obj) {
        int iZzb = ((zzfu) obj).zzc.zzb();
        if (!this.zzc) {
            return iZzb;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zzb(Object obj) {
        int iHashCode = ((zzfu) obj).zzc.hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final Object zze() {
        zzhb zzhbVar = this.zza;
        return zzhbVar instanceof zzfu ? ((zzfu) zzhbVar).zzs() : zzhbVar.zzw().zzk();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzf(Object obj) {
        this.zzb.zzb(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzg(Object obj, Object obj2) {
        zzhn.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhn.zzp(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzej zzejVar) {
        zzfu zzfuVar = (zzfu) obj;
        if (zzfuVar.zzc == zzic.zzc()) {
            zzfuVar.zzc = zzic.zzf();
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzi(Object obj, zzit zzitVar) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzfu) obj).zzc.equals(((zzfu) obj2).zzc)) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzk(Object obj) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }
}
