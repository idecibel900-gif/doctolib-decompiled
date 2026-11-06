package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
final class zzgs implements zzhm {
    private static final zzgz zza = new zzgq();
    private final zzgz zzb;

    public zzgs() {
        zzfp zzfpVarZza = zzfp.zza();
        int i = zzei.$r8$clinit;
        zzgr zzgrVar = new zzgr(zzfpVarZza, zza);
        byte[] bArr = zzga.zzb;
        this.zzb = zzgrVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final zzhl zza(Class cls) {
        int i = zzhn.$r8$clinit;
        if (!zzfu.class.isAssignableFrom(cls)) {
            int i2 = zzei.$r8$clinit;
        }
        zzgy zzgyVarZzb = this.zzb.zzb(cls);
        if (zzgyVarZzb.zzb()) {
            int i3 = zzei.$r8$clinit;
            return zzhf.zzc(zzhn.zzn(), zzfk.zza(), zzgyVarZzb.zza());
        }
        int i4 = zzei.$r8$clinit;
        return zzhe.zzl(cls, zzgyVarZzb, zzhh.zza(), zzgl.zza(), zzhn.zzn(), zzgyVarZzb.zzc() + (-1) != 1 ? zzfk.zza() : null, zzgx.zza());
    }
}
