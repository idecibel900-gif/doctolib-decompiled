package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzax;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcu implements ServiceConnection {
    final /* synthetic */ zzcw zza;

    /* synthetic */ zzcu(zzcw zzcwVar, zzcv zzcvVar) {
        Objects.requireNonNull(zzcwVar);
        this.zza = zzcwVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzc.zzn("BillingClientTesting", "Billing Override Service connected.");
        zzcw zzcwVar = this.zza;
        zzcwVar.zzc = zzax.zzb(iBinder);
        zzcwVar.zzb = 2;
        zzcwVar.zzaO(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzo("BillingClientTesting", "Billing Override Service disconnected.");
        zzcw zzcwVar = this.zza;
        zzcwVar.zzc = null;
        zzcwVar.zzb = 0;
    }
}
