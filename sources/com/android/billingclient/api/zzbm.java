package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjd;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
final class zzbm implements Callable {
    final /* synthetic */ PurchasesResponseListener zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ BillingClientImpl zzd;

    zzbm(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener, String str, boolean z) {
        this.zza = purchasesResponseListener;
        this.zzb = str;
        this.zzc = z;
        Objects.requireNonNull(billingClientImpl);
        this.zzd = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        BillingClientImpl billingClientImpl = this.zzd;
        if (!billingClientImpl.zzbl(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS)) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            billingClientImpl.zzbs(zzjdVar, 9, billingResult);
            this.zza.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        String str = this.zzb;
        if (TextUtils.isEmpty(str)) {
            zzc.zzo("BillingClient", "Please provide a valid product type.");
            zzjd zzjdVar2 = zzjd.EMPTY_PRODUCT_TYPE;
            BillingResult billingResult2 = zzdc.zze;
            billingClientImpl.zzbs(zzjdVar2, 9, billingResult2);
            this.zza.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        zzdz zzdzVarZzbq = billingClientImpl.zzbq(str, this.zzc, 9);
        if (zzdzVarZzbq.zzb() != null) {
            this.zza.onQueryPurchasesResponse(zzdzVarZzbq.zza(), zzdzVarZzbq.zzb());
            return null;
        }
        this.zza.onQueryPurchasesResponse(zzdzVarZzbq.zza(), com.google.android.gms.internal.play_billing.zzbw.zzk());
        return null;
    }
}
