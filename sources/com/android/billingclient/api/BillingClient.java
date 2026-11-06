package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BillingClient {

    public static final class Builder {
        volatile boolean zza;
        private volatile PendingPurchasesParams zzd;
        private final Context zze;
        private volatile PurchasesUpdatedListener zzf;
        private volatile boolean zzm;
        private volatile boolean zzn;
        private volatile boolean zzp;
        private volatile boolean zzq;
        private volatile boolean zzr;

        /* synthetic */ Builder(Context context, zzac zzacVar) {
            this.zze = context;
        }

        private final boolean zza() {
            try {
                Context context = this.zze;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e) {
                zzc.zzp("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
                return false;
            }
        }

        public BillingClient build() {
            Context context = this.zze;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.zzf == null) {
                if (this.zzm || this.zzn || this.zzp || this.zzq || this.zzr) {
                    return zza() ? new zzcw(null, context, null, null, this) : new BillingClientImpl(null, context, null, null, this);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.zzd == null || !this.zzd.isEnabledForOneTimeProducts()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.zzf == null) {
                PendingPurchasesParams pendingPurchasesParams = this.zzd;
                return zza() ? new zzcw(null, pendingPurchasesParams, context, null, null, null, this) : new BillingClientImpl(null, pendingPurchasesParams, context, null, null, null, this);
            }
            PendingPurchasesParams pendingPurchasesParams2 = this.zzd;
            PurchasesUpdatedListener purchasesUpdatedListener = this.zzf;
            return zza() ? new zzcw(null, pendingPurchasesParams2, context, purchasesUpdatedListener, null, null, null, this) : new BillingClientImpl(null, pendingPurchasesParams2, context, purchasesUpdatedListener, null, null, null, this);
        }

        public Builder enablePendingPurchases(PendingPurchasesParams pendingPurchasesParams) {
            this.zzd = pendingPurchasesParams;
            return this;
        }

        public Builder setListener(PurchasesUpdatedListener purchasesUpdatedListener) {
            this.zzf = purchasesUpdatedListener;
            return this;
        }
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context, null);
    }

    public abstract void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener);

    public abstract void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener);

    public abstract void endConnection();

    public abstract void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, BillingConfigResponseListener billingConfigResponseListener);

    public abstract BillingResult isFeatureSupported(String str);

    public abstract boolean isReady();

    public abstract BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams);

    public abstract void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener);

    public abstract void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener);

    public abstract BillingResult showInAppMessages(Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener);

    public abstract void startConnection(BillingClientStateListener billingClientStateListener);
}
