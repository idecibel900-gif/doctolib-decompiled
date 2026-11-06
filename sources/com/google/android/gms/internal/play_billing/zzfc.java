package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfc extends zzem {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final boolean zzc = zzii.zzx();
    Object zza;

    /* synthetic */ zzfc(zzfb zzfbVar) {
    }

    public static int zzy(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzz(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b);

    public abstract void zzd(int i, boolean z);

    public abstract void zzf(int i, zzev zzevVar);

    public abstract void zzh(int i, int i2);

    public abstract void zzi(int i);

    public abstract void zzj(int i, long j);

    public abstract void zzk(long j);

    public abstract void zzl(int i, int i2);

    public abstract void zzm(int i);

    public abstract void zzq(int i, String str);

    public abstract void zzs(int i, int i2);

    public abstract void zzt(int i, int i2);

    public abstract void zzu(int i);

    public abstract void zzv(int i, long j);

    public abstract void zzw(long j);
}
