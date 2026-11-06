package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzc {
    private Object zza;
    private boolean zzb;
    final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        java.util.Objects.requireNonNull(baseGmsClient);
        this.zzd = baseGmsClient;
        this.zza = obj;
        this.zzb = false;
    }

    protected abstract void zzc(Object obj);

    public final void zzd() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.zza;
                if (this.zzb) {
                    new StringBuilder(toString().length() + 47);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            zzc(obj);
        }
        synchronized (this) {
            this.zzb = true;
        }
        zze();
    }

    public final void zze() {
        zzf();
        BaseGmsClient baseGmsClient = this.zzd;
        synchronized (baseGmsClient.zzj()) {
            baseGmsClient.zzj().remove(this);
        }
    }

    public final void zzf() {
        synchronized (this) {
            this.zza = null;
        }
    }
}
