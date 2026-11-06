package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzp;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbs implements BillingClientStateListener {
    final /* synthetic */ zzp zza;
    final /* synthetic */ BillingClientImpl zzb;

    zzbs(BillingClientImpl billingClientImpl, zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        zzc.zzn("BillingClient", "Reconnection attempt failed.");
        try {
            this.zza.zzb(zzdc.zzj);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzH != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbq
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zza.zzb.zzH.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        zzc.zzp("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        zzc.zzn("BillingClient", "Reconnection finished with result: " + billingResult.getResponseCode());
        try {
            this.zza.zzb(billingResult);
        } catch (Throwable th) {
            zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        if (billingClientImpl.zzH != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbr
                @Override // java.lang.Runnable
                public final void run() {
                    zzbs zzbsVar = this.zza;
                    try {
                        zzbsVar.zzb.zzH.onBillingSetupFinished(billingResult);
                    } catch (Throwable th2) {
                        zzc.zzp("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
