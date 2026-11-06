package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzaa extends BroadcastReceiver {
    final /* synthetic */ zzab zza;
    private boolean zzb;
    private final boolean zzc;

    zzaa(zzab zzabVar, boolean z) {
        Objects.requireNonNull(zzabVar);
        this.zza = zzabVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i, zzjk zzjkVar, long j, boolean z) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.zza.zzf.zzd(zziw.zzc(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD")), j, z);
            } else {
                this.zza.zzf.zzd(zzcy.zzb(zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, billingResult, null, zzjkVar), j, z);
            }
        } catch (Throwable unused) {
            zzc.zzo("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzjk zzjkVar;
        int i;
        int i2;
        BillingResult billingResultZzi;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                if (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                    zzjkVar = zzjk.ALTERNATIVE_BILLING_ACTION;
                } else {
                    zzjkVar = zzjk.BROADCAST_ACTION_UNSPECIFIED;
                }
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                zzjkVar = zzjk.LOCAL_PURCHASES_UPDATED_ACTION;
            } else {
                zzjkVar = zzjk.BROADCAST_ACTION_UNSPECIFIED;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            zzjkVar = zzjk.PURCHASES_UPDATED_ACTION;
        } else {
            zzjkVar = zzjk.BROADCAST_ACTION_UNSPECIFIED;
        }
        zzjk zzjkVar2 = zzjkVar;
        zzjk zzjkVar3 = zzjk.LOCAL_PURCHASES_UPDATED_ACTION;
        if (zzjkVar2.equals(zzjkVar3) || zzjkVar2.equals(zzjk.ALTERNATIVE_BILLING_ACTION)) {
            i = 2;
            i2 = 2;
        } else {
            i2 = zzjkVar2.equals(zzjk.PURCHASES_UPDATED_ACTION) ? 32 : 1;
            i = 2;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zzc.zzo("BillingBroadcastManager", "Bundle is null.");
            zzab zzabVar = this.zza;
            zzcz zzczVar = zzabVar.zzf;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            BillingResult billingResult = zzdc.zzh;
            zzczVar.zza(zzcy.zzb(zzjdVar, i2, billingResult, null, zzjkVar2));
            if (zzabVar.zzb != null) {
                zzabVar.zzb.onPurchasesUpdated(billingResult, null);
            }
        } else {
            if (i2 == i) {
                int i3 = zzc.zza;
                BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                builderNewBuilder.setResponseCode(zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
                Bundle extras2 = intent.getExtras();
                if (extras2 == null) {
                    zzc.zzo("BillingBroadcastManager", "Unexpected null bundle received!");
                } else {
                    Object obj = extras2.get("SUB_RESPONSE_CODE");
                    if (obj == null) {
                        zzc.zzn("BillingBroadcastManager", "getOnPurchasesUpdatedSubResponseCodeFromBundle() got null response code, assuming OK");
                    } else {
                        if (obj instanceof Integer) {
                            iIntValue = ((Integer) obj).intValue();
                        } else {
                            zzc.zzo("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(obj.getClass().getName()));
                        }
                        builderNewBuilder.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                        builderNewBuilder.setDebugMessage(zzc.zzk(intent.getExtras(), "BillingBroadcastManager"));
                        billingResultZzi = builderNewBuilder.build();
                    }
                }
                iIntValue = 0;
                builderNewBuilder.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                builderNewBuilder.setDebugMessage(zzc.zzk(intent.getExtras(), "BillingBroadcastManager"));
                billingResultZzi = builderNewBuilder.build();
            } else {
                billingResultZzi = zzc.zzi(intent, "BillingBroadcastManager");
            }
            long j = extras.getLong("billingClientTransactionId", 0L);
            boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
            if (zzjkVar2.equals(zzjk.PURCHASES_UPDATED_ACTION) || zzjkVar2.equals(zzjkVar3)) {
                BillingResult billingResult2 = billingResultZzi;
                List listZzm = zzc.zzm(extras);
                if (billingResult2.getResponseCode() == 0) {
                    this.zza.zzf.zzh(zzcy.zzc(i2, zzjkVar2), j, z);
                } else {
                    zzd(extras, billingResult2, i2, zzjkVar2, j, z);
                }
                this.zza.zzb.onPurchasesUpdated(billingResult2, listZzm);
                return;
            }
            if (zzjkVar2.equals(zzjk.ALTERNATIVE_BILLING_ACTION)) {
                if (billingResultZzi.getResponseCode() != 0) {
                    BillingResult billingResult3 = billingResultZzi;
                    zzd(extras, billingResult3, i2, zzjkVar2, j, z);
                    this.zza.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzbw.zzk());
                    return;
                }
                zzab zzabVar2 = this.zza;
                zzab.zza(zzabVar2);
                zzab.zzg(zzabVar2);
                zzab.zzc(zzabVar2);
                zzc.zzo("BillingBroadcastManager", "No valid alternative billing listener is registered.");
                zzcz zzczVar2 = zzabVar2.zzf;
                zzjd zzjdVar2 = zzjd.NULL_DEVELOPER_MANAGED_BILLING_LISTENER;
                BillingResult billingResult4 = zzdc.zzh;
                zzczVar2.zzd(zzcy.zzb(zzjdVar2, i2, billingResult4, null, zzjkVar2), j, z);
                zzabVar2.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzbw.zzk());
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        try {
            if (this.zzb) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.zzb = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzaa zzaaVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzaaVar = this;
                    context.registerReceiver(zzaaVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzaaVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzaaVar.zzb = true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            zzc.zzo("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
