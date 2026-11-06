package com.revenuecat.purchases.models;

import com.android.billingclient.api.ProductDetails;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eB\u0019\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012Be\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\u00020-8VX\u0096\u0004¢\u0006\f\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u00100R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productId", "", "basePlanId", "offerId", "pricingPhases", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "tags", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "offerToken", "presentedOfferingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Ljava/lang/String;)V", "subscriptionOption", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "installmentsInfo", "Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;)V", "getBasePlanId", "()Ljava/lang/String;", DiagnosticsEntry.ID_KEY, "getId", "getInstallmentsInfo", "()Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "getOfferId", "getOfferToken", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPricingPhases", "()Ljava/util/List;", "primaryPricingPhase", "getPrimaryPricingPhase", "()Lcom/revenuecat/purchases/models/PricingPhase;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData$annotations", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "getTags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final GoogleInstallmentsInfo installmentsInfo;
    private final String offerId;
    private final String offerToken;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final ProductDetails productDetails;
    private final String productId;
    private final List<String> tags;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, null, null, 384, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, presentedOfferingContext, null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
    }

    @Deprecated
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public static /* synthetic */ void getPurchasingData$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleSubscriptionOption)) {
            return false;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) obj;
        return Intrinsics.areEqual(this.productId, googleSubscriptionOption.productId) && Intrinsics.areEqual(this.basePlanId, googleSubscriptionOption.basePlanId) && Intrinsics.areEqual(this.offerId, googleSubscriptionOption.offerId) && Intrinsics.areEqual(this.pricingPhases, googleSubscriptionOption.pricingPhases) && Intrinsics.areEqual(this.tags, googleSubscriptionOption.tags) && Intrinsics.areEqual(this.productDetails, googleSubscriptionOption.productDetails) && Intrinsics.areEqual(this.offerToken, googleSubscriptionOption.offerToken) && Intrinsics.areEqual(this.presentedOfferingContext, googleSubscriptionOption.presentedOfferingContext) && Intrinsics.areEqual(this.installmentsInfo, googleSubscriptionOption.installmentsInfo);
    }

    public int hashCode() {
        int iHashCode = ((this.productId.hashCode() * 31) + this.basePlanId.hashCode()) * 31;
        String str = this.offerId;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.pricingPhases.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.offerToken.hashCode()) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode3 = (iHashCode2 + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode())) * 31;
        GoogleInstallmentsInfo googleInstallmentsInfo = this.installmentsInfo;
        return iHashCode3 + (googleInstallmentsInfo != null ? googleInstallmentsInfo.hashCode() : 0);
    }

    public String toString() {
        return "GoogleSubscriptionOption(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", offerId=" + this.offerId + ", pricingPhases=" + this.pricingPhases + ", tags=" + this.tags + ", productDetails=" + this.productDetails + ", offerToken=" + this.offerToken + ", presentedOfferingContext=" + this.presentedOfferingContext + ", installmentsInfo=" + this.installmentsInfo + ')';
    }

    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
        this.productId = productId;
        this.basePlanId = basePlanId;
        this.offerId = str;
        this.pricingPhases = pricingPhases;
        this.tags = tags;
        this.productDetails = productDetails;
        this.offerToken = offerToken;
        this.presentedOfferingContext = presentedOfferingContext;
        this.installmentsInfo = googleInstallmentsInfo;
    }

    public /* synthetic */ GoogleSubscriptionOption(String str, String str2, String str3, List list, List list2, ProductDetails productDetails, String str4, PresentedOfferingContext presentedOfferingContext, GoogleInstallmentsInfo googleInstallmentsInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, list2, productDetails, str4, (i & 128) != 0 ? null : presentedOfferingContext, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : googleInstallmentsInfo);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public List<String> getTags() {
        return this.tags;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String getOfferToken() {
        return this.offerToken;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public GoogleInstallmentsInfo getInstallmentsInfo() {
        return this.installmentsInfo;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleSubscriptionOption(String productId, String basePlanId, String str, List<PricingPhase> pricingPhases, List<String> tags, ProductDetails productDetails, String offerToken, String presentedOfferingId) {
        this(productId, basePlanId, str, pricingPhases, tags, productDetails, offerToken, new PresentedOfferingContext(presentedOfferingId), null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePlanId, "basePlanId");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        Intrinsics.checkNotNullParameter(offerToken, "offerToken");
        Intrinsics.checkNotNullParameter(presentedOfferingId, "presentedOfferingId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(GoogleSubscriptionOption subscriptionOption, PresentedOfferingContext presentedOfferingContext) {
        this(subscriptionOption.productId, subscriptionOption.basePlanId, subscriptionOption.offerId, subscriptionOption.getPricingPhases(), subscriptionOption.getTags(), subscriptionOption.productDetails, subscriptionOption.offerToken, presentedOfferingContext, subscriptionOption.getInstallmentsInfo());
        Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    /* JADX INFO: renamed from: getId */
    public String get$id() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.basePlanId);
        String str2 = this.offerId;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = "";
        } else {
            str = ':' + this.offerId;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    @Override // com.revenuecat.purchases.models.SubscriptionOption
    public PurchasingData getPurchasingData() {
        String str = this.productId;
        String id = get$id();
        ProductDetails productDetails = this.productDetails;
        String str2 = this.offerToken;
        PricingPhase primaryPricingPhase = getPrimaryPricingPhase();
        return new GooglePurchasingData.Subscription(str, id, productDetails, str2, primaryPricingPhase != null ? primaryPricingPhase.getBillingPeriod() : null, CollectionsKt.emptyList());
    }

    private final PricingPhase getPrimaryPricingPhase() {
        Object next;
        Iterator<T> it = getPricingPhases().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((PricingPhase) next).getRecurrenceMode() != RecurrenceMode.INFINITE_RECURRING);
        PricingPhase pricingPhase = (PricingPhase) next;
        return pricingPhase == null ? (PricingPhase) CollectionsKt.lastOrNull((List) getPricingPhases()) : pricingPhase;
    }
}
