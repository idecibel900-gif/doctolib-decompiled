package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzf implements OnSuccessListener, OnFailureListener, OnCanceledListener, zzq {
    private final Executor zza;
    private final Continuation zzb;
    private final zzw zzc;

    public zzf(Executor executor, Continuation continuation, zzw zzwVar) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.zzc.zze();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zzc.zzc(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zzc.zza(obj);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zza(Task task) {
        this.zza.execute(new zze(this, task));
    }

    final /* synthetic */ Continuation zzc() {
        return this.zzb;
    }

    final /* synthetic */ zzw zzd() {
        return this.zzc;
    }
}
