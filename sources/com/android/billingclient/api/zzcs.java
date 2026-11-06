package com.android.billingclient.api;

import androidx.core.util.Consumer;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
final class zzcs implements com.google.android.gms.internal.play_billing.zzcv {
    final /* synthetic */ Consumer zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzcw zzc;
    final /* synthetic */ int zzd;

    zzcs(zzcw zzcwVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        Objects.requireNonNull(zzcwVar);
        this.zzc = zzcwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final void zza(Throwable th) {
        if (th instanceof TimeoutException) {
            this.zzc.zzaN(zzjd.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, zzdc.zzE);
            zzc.zzp("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            this.zzc.zzaN(zzjd.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdc.zzE);
            zzc.zzp("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.zzb.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        zzcw zzcwVar = this.zzc;
        if (!zzcw.zzaK(iIntValue)) {
            this.zzb.run();
        } else {
            this.zza.accept(zzcwVar.zzaL(this.zzd, num.intValue()));
        }
    }
}
