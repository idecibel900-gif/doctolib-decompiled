package com.google.android.gms.tasks;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    zzm(zzn zznVar, Task task) {
        this.zza = task;
        Objects.requireNonNull(zznVar);
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzn zznVar = this.zzb;
        synchronized (zznVar.zzc()) {
            try {
                if (zznVar.zzd() != null) {
                    zznVar.zzd().onSuccess(this.zza.getResult());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
