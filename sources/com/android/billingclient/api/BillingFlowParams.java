package com.android.billingclient.api;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BillingFlowParams {
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzbw zze;
    private ArrayList zzf;
    private boolean zzg;

    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;

        public BillingFlowParams build() {
            ArrayList arrayList = this.zzd;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z2 = (list == null || list.isEmpty()) ? false : true;
            if (!z && !z2) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (z && z2) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            zzcx zzcxVar = null;
            if (!z) {
                List list2 = this.zzc;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (((ProductDetailsParams) it.next()) == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        }
                    }
                }
            } else {
                if (this.zzd.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.zzd.size() > 1) {
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.zzd.get(0));
                    throw null;
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams(zzcxVar);
            if (z) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.zzd.get(0));
                throw null;
            }
            billingFlowParams.zza = z2 && !((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty();
            billingFlowParams.zzb = this.zza;
            billingFlowParams.zzc = this.zzb;
            billingFlowParams.zzd = this.zzf.build();
            ArrayList arrayList2 = this.zzd;
            billingFlowParams.zzf = arrayList2 != null ? new ArrayList(arrayList2) : new ArrayList();
            billingFlowParams.zzg = this.zze;
            List list3 = this.zzc;
            billingFlowParams.zze = list3 != null ? com.google.android.gms.internal.play_billing.zzbw.zzj(list3) : com.google.android.gms.internal.play_billing.zzbw.zzk();
            billingFlowParams.getClass();
            return billingFlowParams;
        }

        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setProductDetailsParamsList(List list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzb(subscriptionUpdateParams);
            return this;
        }

        /* synthetic */ Builder(zzcx zzcxVar) {
            SubscriptionUpdateParams.Builder builderNewBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(builderNewBuilder);
            this.zzf = builderNewBuilder;
        }
    }

    public static final class ProductDetailsParams {
        private final ProductDetails zza;
        private final String zzb;

        public static class Builder {
            private ProductDetails zza;
            private String zzb;

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            static /* bridge */ /* synthetic */ SubscriptionProductReplacementParams zza(Builder builder) {
                builder.getClass();
                return null;
            }

            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzbj.zzc(this.zza, "ProductDetails is required for constructing ProductDetailsParams.");
                return new ProductDetailsParams(this, null);
            }

            public Builder setOfferToken(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("offerToken can not be empty");
                }
                this.zzb = str;
                return this;
            }

            public Builder setProductDetails(ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails.getOfferToken() != null) {
                        this.zzb = oneTimePurchaseOfferDetails.getOfferToken();
                    }
                }
                return this;
            }
        }

        public static class SubscriptionProductReplacementParams {
        }

        /* synthetic */ ProductDetailsParams(Builder builder, zzcx zzcxVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            Builder.zza(builder);
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public SubscriptionProductReplacementParams getSubscriptionProductReplacementParams() {
            return null;
        }

        public final ProductDetails zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;

        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;

            /* synthetic */ Builder(zzcx zzcxVar) {
            }

            static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            public SubscriptionUpdateParams build() {
                boolean z = true;
                zzcx zzcxVar = null;
                if (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) {
                    z = false;
                }
                boolean zIsEmpty = TextUtils.isEmpty(this.zzb);
                if (z && !zIsEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.zzc && !z && zIsEmpty) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzcxVar);
                subscriptionUpdateParams.zza = this.zza;
                subscriptionUpdateParams.zzc = this.zzd;
                subscriptionUpdateParams.zzb = this.zzb;
                return subscriptionUpdateParams;
            }

            public Builder setOldPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            public Builder setOriginalExternalTransactionId(String str) {
                this.zzb = str;
                return this;
            }

            public Builder setSubscriptionReplacementMode(int i) {
                this.zzd = i;
                return this;
            }

            public final Builder zzb(String str) {
                this.zza = str;
                return this;
            }
        }

        /* synthetic */ SubscriptionUpdateParams(zzcx zzcxVar) {
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        static /* bridge */ /* synthetic */ Builder zzb(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder builderNewBuilder = newBuilder();
            builderNewBuilder.zzb(subscriptionUpdateParams.zza);
            builderNewBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzc);
            builderNewBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return builderNewBuilder;
        }

        final int zza() {
            return this.zzc;
        }

        final String zzc() {
            return this.zza;
        }

        final String zzd() {
            return this.zzb;
        }
    }

    /* synthetic */ BillingFlowParams(zzcx zzcxVar) {
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public DeveloperBillingOptionParams getDeveloperBillingOptionParams() {
        return null;
    }

    public int zza() {
        return 0;
    }

    public final int zzb() {
        return this.zzd.zza();
    }

    public long zzc() {
        return 0L;
    }

    final BillingResult zzd() {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        if (this.zze.isEmpty()) {
            return zzdc.zzi;
        }
        ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zze.get(0);
        for (int i = 1; i < this.zze.size(); i++) {
            ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zze.get(i);
            if (!productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals("play_pass_subs")) {
                return zzdc.zza(5, "All products should have same ProductType.");
            }
        }
        String strZza = productDetailsParams.zza().zza();
        HashMap map = new HashMap();
        HashSet<String> hashSet = new HashSet();
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.zze;
        int size = zzbwVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            ProductDetailsParams productDetailsParams3 = (ProductDetailsParams) zzbwVar.get(i2);
            productDetailsParams3.getSubscriptionProductReplacementParams();
            if (productDetailsParams3.zza().getSubscriptionOfferDetails() != null && productDetailsParams3.zzb() == null) {
                return zzdc.zza(5, String.format("offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: %s", productDetailsParams3.zza().getProductId()));
            }
            if (map.containsKey(productDetailsParams3.zza().getProductId())) {
                return zzdc.zza(5, String.format("ProductId can not be duplicated. Invalid product id: %s.", productDetailsParams3.zza().getProductId()));
            }
            map.put(productDetailsParams3.zza().getProductId(), productDetailsParams3);
            if (!productDetailsParams.zza().getProductType().equals("play_pass_subs") && !productDetailsParams3.zza().getProductType().equals("play_pass_subs") && !strZza.equals(productDetailsParams3.zza().zza())) {
                return zzdc.zza(5, "All products must have the same package name.");
            }
        }
        for (String str : hashSet) {
            if (map.containsKey(str)) {
                ((ProductDetailsParams) map.get(str)).getSubscriptionProductReplacementParams();
                return zzdc.zza(5, String.format("OldProductId must not be one of the products to be purchased. Invalid old product id: %s.", str));
            }
        }
        List oneTimePurchaseOfferDetailsList = productDetailsParams.zza().getOneTimePurchaseOfferDetailsList();
        String strZzb = productDetailsParams.zzb();
        if (strZzb != null && oneTimePurchaseOfferDetailsList != null) {
            Iterator it = oneTimePurchaseOfferDetailsList.iterator();
            do {
                if (!it.hasNext()) {
                    oneTimePurchaseOfferDetails = null;
                    break;
                }
                oneTimePurchaseOfferDetails = (ProductDetails.OneTimePurchaseOfferDetails) it.next();
            } while (!strZzb.equals(oneTimePurchaseOfferDetails.getOfferToken()));
            if (oneTimePurchaseOfferDetails != null && oneTimePurchaseOfferDetails.zza() != null) {
                return zzdc.zza(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
            }
        }
        return zzdc.zzi;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    public String zzg() {
        return null;
    }

    public final String zzh() {
        return this.zzd.zzc();
    }

    public final String zzi() {
        return this.zzd.zzd();
    }

    public final ArrayList zzj() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    public final List zzk() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzg;
    }

    final boolean zzu() {
        if (this.zzb != null || this.zzc != null || this.zzd.zzd() != null || this.zzd.zza() != 0 || this.zza || this.zzg) {
            return true;
        }
        com.google.android.gms.internal.play_billing.zzbw zzbwVar = this.zze;
        if (zzbwVar != null) {
            int size = zzbwVar.size();
            for (int i = 0; i < size; i++) {
                ((ProductDetailsParams) zzbwVar.get(i)).getSubscriptionProductReplacementParams();
            }
        }
        return false;
    }
}
