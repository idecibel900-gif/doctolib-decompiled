package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class zzcy {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        int i = zzcz.$r8$clinit;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + com.google.android.gms.internal.play_billing.zzbm.zzc(exc.getMessage());
            int i = zzc.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            zzc.zzp("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zziw zzb(zzjd zzjdVar, int i, BillingResult billingResult, String str, zzjk zzjkVar) {
        try {
            zzjb zzjbVarZza = zzjf.zza();
            zzjbVarZza.zzp(billingResult.getResponseCode());
            zzjbVarZza.zzb(billingResult.getDebugMessage());
            if (billingResult.getOnPurchasesUpdatedSubResponseCode() != 0) {
                zzjbVarZza.zzd(billingResult.getOnPurchasesUpdatedSubResponseCode());
            }
            if (zzjdVar != null) {
                zzjbVarZza.zze(zzjdVar);
            }
            if (str != null) {
                zzjbVarZza.zza(str);
            }
            zziu zziuVarZza = zziw.zza();
            zziuVarZza.zzb(zzjbVarZza);
            zziuVarZza.zzp(i);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zziuVarZza.zza(zzjkVar);
            }
            return (zziw) zziuVarZza.zzi();
        } catch (Throwable th) {
            zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzja zzc(int i, zzjk zzjkVar) {
        try {
            zziy zziyVarZza = zzja.zza();
            zziyVarZza.zze(i);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zziyVarZza.zza(zzjkVar);
            }
            return (zzja) zziyVarZza.zzi();
        } catch (Exception e) {
            zzc.zzp("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
