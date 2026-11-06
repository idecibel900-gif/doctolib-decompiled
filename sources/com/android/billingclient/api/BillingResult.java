package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingResult {
    private int zza;
    private int zzb;
    private String zzc;

    public static class Builder {
        private int zza;
        private int zzb = 0;
        private String zzc = "";

        /* synthetic */ Builder(zzdb zzdbVar) {
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            billingResult.zzc = this.zzc;
            return billingResult;
        }

        public Builder setDebugMessage(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setOnPurchasesUpdatedSubResponseCode(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setResponseCode(int i) {
            this.zza = i;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getDebugMessage() {
        return this.zzc;
    }

    public int getOnPurchasesUpdatedSubResponseCode() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }

    public String toString() {
        return "Response Code: " + zzc.zzl(this.zza) + ", Debug Message: " + this.zzc;
    }
}
