package com.android.billingclient.api;

/* JADX INFO: loaded from: classes3.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    public static final class Builder {
        private String zza;

        /* synthetic */ Builder(zza zzaVar) {
        }

        public AcknowledgePurchaseParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams.zza = str;
            return acknowledgePurchaseParams;
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ AcknowledgePurchaseParams(zza zzaVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
