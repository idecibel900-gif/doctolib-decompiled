package com.revenuecat.purchases;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020$8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams;", "", "builder", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;)V", "activity", "Landroid/app/Activity;", "getActivity$purchases_defaultsBc8Release", "()Landroid/app/Activity;", "getBuilder", "()Lcom/revenuecat/purchases/PurchaseParams$Builder;", "containsAddOnItems", "", "getContainsAddOnItems$purchases_defaultsBc8Release$annotations", "()V", "getContainsAddOnItems$purchases_defaultsBc8Release", "()Z", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getGoogleReplacementMode$annotations", "getGoogleReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "isPersonalizedPrice", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "oldProductId", "", "getOldProductId", "()Ljava/lang/String;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPresentedOfferingContext$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/PurchasingData;", "replacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "getReplacementMode", "()Lcom/revenuecat/purchases/models/StoreReplacementMode;", "Builder", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseParams {
    private final Activity activity;
    private final Builder builder;
    private final Boolean isPersonalizedPrice;
    private final String oldProductId;
    private PresentedOfferingContext presentedOfferingContext;
    private final PurchasingData purchasingData;
    private final StoreReplacementMode replacementMode;

    public static /* synthetic */ void getContainsAddOnItems$purchases_defaultsBc8Release$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getGoogleReplacementMode$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchaseParams) && Intrinsics.areEqual(this.builder, ((PurchaseParams) obj).builder);
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public String toString() {
        return "PurchaseParams(builder=" + this.builder + ')';
    }

    public PurchaseParams(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.isPersonalizedPrice = builder.getIsPersonalizedPrice();
        this.oldProductId = builder.getOldProductId();
        this.replacementMode = builder.getReplacementMode();
        this.purchasingData = builder.getPurchasingData();
        this.activity = builder.getActivity();
        this.presentedOfferingContext = builder.getPresentedOfferingContext();
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    /* JADX INFO: renamed from: isPersonalizedPrice, reason: from getter */
    public final Boolean getIsPersonalizedPrice() {
        return this.isPersonalizedPrice;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return StoreReplacementModeConversionsKt.toGoogleReplacementMode(this.replacementMode);
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    /* JADX INFO: renamed from: getPurchasingData$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PurchasingData getPurchasingData() {
        return this.purchasingData;
    }

    /* JADX INFO: renamed from: getActivity$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: getPresentedOfferingContext$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public final /* synthetic */ boolean getContainsAddOnItems$purchases_defaultsBc8Release() {
        List addOnProducts;
        PurchasingData purchasingData = this.purchasingData;
        GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
        if (subscription == null || (addOnProducts = subscription.getAddOnProducts()) == null) {
            return false;
        }
        return !addOnProducts.isEmpty();
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\u0016\u00103\u001a\u00020\u00002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0007J\u0016\u00105\u001a\u00020\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\b04H\u0007J\u0016\u00106\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b04H\u0007J\u0016\u00107\u001a\u00020\u00002\f\u00108\u001a\b\u0012\u0004\u0012\u00020904H\u0002J\b\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=H\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168@@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001d8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010.\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020-8@@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams$Builder;", "", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;)V", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;)V", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "product", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/models/StoreProduct;)V", "getActivity$purchases_defaultsBc8Release", "()Landroid/app/Activity;", "<set-?>", "", "isPersonalizedPrice", "isPersonalizedPrice$purchases_defaultsBc8Release", "()Ljava/lang/Boolean;", "setPersonalizedPrice$purchases_defaultsBc8Release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "", "oldProductId", "getOldProductId$purchases_defaultsBc8Release", "()Ljava/lang/String;", "setOldProductId$purchases_defaultsBc8Release", "(Ljava/lang/String;)V", "getPresentedOfferingContext$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "setPresentedOfferingContext$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getProduct$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchasingData$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/PurchasingData;", "setPurchasingData$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/PurchasingData;)V", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "replacementMode", "getReplacementMode$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/models/StoreReplacementMode;", "setReplacementMode$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/models/StoreReplacementMode;)V", "addOnPackages", "", "addOnStoreProducts", "addOnSubscriptionOptions", "attachSubscriptionAddOns", "addOns", "Lcom/revenuecat/purchases/models/GooglePurchasingData;", "build", "Lcom/revenuecat/purchases/PurchaseParams;", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class Builder {
        private final Activity activity;
        private Boolean isPersonalizedPrice;
        private String oldProductId;
        private PresentedOfferingContext presentedOfferingContext;
        private final StoreProduct product;
        private PurchasingData purchasingData;
        private StoreReplacementMode replacementMode;

        private Builder(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, StoreProduct storeProduct) {
            this.activity = activity;
            this.purchasingData = purchasingData;
            this.presentedOfferingContext = presentedOfferingContext;
            this.product = storeProduct;
            this.replacementMode = StoreReplacementMode.WITHOUT_PRORATION;
        }

        /* JADX INFO: renamed from: getActivity$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ Activity getActivity() {
            return this.activity;
        }

        /* JADX INFO: renamed from: getPurchasingData$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ PurchasingData getPurchasingData() {
            return this.purchasingData;
        }

        public final void setPurchasingData$purchases_defaultsBc8Release(PurchasingData purchasingData) {
            Intrinsics.checkNotNullParameter(purchasingData, "<set-?>");
            this.purchasingData = purchasingData;
        }

        /* JADX INFO: renamed from: getPresentedOfferingContext$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
            this.presentedOfferingContext = presentedOfferingContext;
        }

        /* JADX INFO: renamed from: getProduct$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ StoreProduct getProduct() {
            return this.product;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, Package packageToPurchase) {
            this(activity, packageToPurchase.getProduct().getPurchasingData(), packageToPurchase.getPresentedOfferingContext(), packageToPurchase.getProduct());
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, StoreProduct storeProduct) {
            this(activity, storeProduct.getPurchasingData(), storeProduct.getPresentedOfferingContext(), storeProduct);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, SubscriptionOption subscriptionOption) {
            this(activity, subscriptionOption.getPurchasingData(), subscriptionOption.getPresentedOfferingContext(), null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        }

        /* JADX INFO: renamed from: isPersonalizedPrice$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ Boolean getIsPersonalizedPrice() {
            return this.isPersonalizedPrice;
        }

        public final /* synthetic */ void setPersonalizedPrice$purchases_defaultsBc8Release(Boolean bool) {
            this.isPersonalizedPrice = bool;
        }

        /* JADX INFO: renamed from: getOldProductId$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ String getOldProductId() {
            return this.oldProductId;
        }

        public final /* synthetic */ void setOldProductId$purchases_defaultsBc8Release(String str) {
            this.oldProductId = str;
        }

        /* JADX INFO: renamed from: getReplacementMode$purchases_defaultsBc8Release, reason: from getter */
        public final /* synthetic */ StoreReplacementMode getReplacementMode() {
            return this.replacementMode;
        }

        public final /* synthetic */ void setReplacementMode$purchases_defaultsBc8Release(StoreReplacementMode storeReplacementMode) {
            Intrinsics.checkNotNullParameter(storeReplacementMode, "<set-?>");
            this.replacementMode = storeReplacementMode;
        }

        public final Builder presentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.presentedOfferingContext = presentedOfferingContext;
            return this;
        }

        public final Builder isPersonalizedPrice(boolean isPersonalizedPrice) {
            this.isPersonalizedPrice = Boolean.valueOf(isPersonalizedPrice);
            return this;
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        @Deprecated
        public final Builder googleReplacementMode(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
            this.replacementMode = StoreReplacementModeConversionsKt.toStoreReplacementMode(googleReplacementMode);
            return this;
        }

        public final Builder replacementMode(StoreReplacementMode replacementMode) {
            Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
            this.replacementMode = replacementMode;
            return this;
        }

        @ExperimentalPreviewRevenueCatPurchasesAPI
        public final Builder addOnPackages(List<Package> addOnPackages) {
            Intrinsics.checkNotNullParameter(addOnPackages, "addOnPackages");
            List<Package> list = addOnPackages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Package) it.next()).getProduct());
            }
            addOnStoreProducts(arrayList);
            return this;
        }

        @ExperimentalPreviewRevenueCatPurchasesAPI
        public final Builder addOnStoreProducts(List<? extends StoreProduct> addOnStoreProducts) {
            Intrinsics.checkNotNullParameter(addOnStoreProducts, "addOnStoreProducts");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnStoreProducts.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((StoreProduct) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        @ExperimentalPreviewRevenueCatPurchasesAPI
        public final Builder addOnSubscriptionOptions(List<? extends SubscriptionOption> addOnSubscriptionOptions) {
            Intrinsics.checkNotNullParameter(addOnSubscriptionOptions, "addOnSubscriptionOptions");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnSubscriptionOptions.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((SubscriptionOption) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final Builder attachSubscriptionAddOns(List<? extends GooglePurchasingData> addOns) {
            if (addOns.isEmpty()) {
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.PurchaseParams$Builder$attachSubscriptionAddOns$lambda$14$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.EMPTY_ADD_ONS_LIST_PASSED;
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                }
            } else {
                PurchasingData purchasingData = this.purchasingData;
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GooglePurchasingData googlePurchasingData : addOns) {
                        GooglePurchasingData.Subscription subscription2 = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
                        if (subscription2 != null) {
                            arrayList.add(subscription2);
                        }
                    }
                    String productId = subscription.getProductId();
                    String optionId = subscription.getOptionId();
                    ProductDetails productDetails = subscription.getProductDetails();
                    String token = subscription.getToken();
                    Period billingPeriod = subscription.getBillingPeriod();
                    List addOnProducts = subscription.getAddOnProducts();
                    if (addOnProducts == null) {
                        addOnProducts = CollectionsKt.emptyList();
                    }
                    this.purchasingData = new GooglePurchasingData.Subscription(productId, optionId, productDetails, token, billingPeriod, CollectionsKt.plus((Collection) addOnProducts, (Iterable) arrayList));
                }
            }
            return this;
        }

        public PurchaseParams build() {
            return new PurchaseParams(this);
        }
    }
}
