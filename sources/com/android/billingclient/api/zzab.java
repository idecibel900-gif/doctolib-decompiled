package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes3.dex */
final class zzab {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzcz zzf;
    private final zzaa zzg = new zzaa(this, true);
    private final zzaa zzh = new zzaa(this, false);
    private boolean zzi;

    zzab(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzdo zzdoVar, zzb zzbVar, UserChoiceBillingListener userChoiceBillingListener, DeveloperProvidedBillingListener developerProvidedBillingListener, zzcz zzczVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zzf = zzczVar;
    }

    static /* bridge */ /* synthetic */ zzb zza(zzab zzabVar) {
        zzabVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ DeveloperProvidedBillingListener zzc(zzab zzabVar) {
        zzabVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ UserChoiceBillingListener zzg(zzab zzabVar) {
        zzabVar.getClass();
        return null;
    }

    final PurchasesUpdatedListener zzf() {
        return this.zzb;
    }

    final void zzh() {
        zzaa zzaaVar = this.zzg;
        Context context = this.zza;
        zzaaVar.zzc(context);
        this.zzh.zzc(context);
    }

    final void zzi(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzi = z;
        zzaa zzaaVar = this.zzh;
        Context context = this.zza;
        zzaaVar.zza(context, intentFilter2);
        if (this.zzi) {
            this.zzg.zzb(context, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.zzg.zza(context, intentFilter);
        }
    }
}
