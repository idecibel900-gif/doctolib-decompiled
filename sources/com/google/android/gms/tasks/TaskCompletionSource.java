package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes3.dex */
public class TaskCompletionSource {
    private final zzw zza = new zzw();

    public Task getTask() {
        return this.zza;
    }

    public void setException(Exception exc) {
        this.zza.zzc(exc);
    }

    public void setResult(Object obj) {
        this.zza.zza(obj);
    }

    public boolean trySetException(Exception exc) {
        return this.zza.zzd(exc);
    }

    public boolean trySetResult(Object obj) {
        return this.zza.zzb(obj);
    }
}
