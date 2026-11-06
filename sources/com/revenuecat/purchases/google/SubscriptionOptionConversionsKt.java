package com.revenuecat.purchases.google;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.models.GoogleInstallmentsInfo;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\r\u001a\u00020\u000e*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\"\u001a\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"installmentsInfo", "Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "Lcom/android/billingclient/api/ProductDetails$InstallmentPlanDetails;", "getInstallmentsInfo", "(Lcom/android/billingclient/api/ProductDetails$InstallmentPlanDetails;)Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "isBasePlan", "", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)Z", "subscriptionBillingPeriod", "", "getSubscriptionBillingPeriod", "(Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;)Ljava/lang/String;", "toSubscriptionOption", "Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "productId", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionOptionConversionsKt {
    public static final GoogleSubscriptionOption toSubscriptionOption(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, String productId, ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        List pricingPhaseList = subscriptionOfferDetails.getPricingPhases().getPricingPhaseList();
        Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "pricingPhases.pricingPhaseList");
        List<ProductDetails.PricingPhase> list = pricingPhaseList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProductDetails.PricingPhase it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(PricingPhaseConversionsKt.toRevenueCatPricingPhase(it));
        }
        String basePlanId = subscriptionOfferDetails.getBasePlanId();
        Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
        String offerId = subscriptionOfferDetails.getOfferId();
        List offerTags = subscriptionOfferDetails.getOfferTags();
        Intrinsics.checkNotNullExpressionValue(offerTags, "offerTags");
        String offerToken = subscriptionOfferDetails.getOfferToken();
        Intrinsics.checkNotNullExpressionValue(offerToken, "offerToken");
        ProductDetails.InstallmentPlanDetails installmentPlanDetails = subscriptionOfferDetails.getInstallmentPlanDetails();
        return new GoogleSubscriptionOption(productId, basePlanId, offerId, arrayList, offerTags, productDetails, offerToken, null, installmentPlanDetails != null ? getInstallmentsInfo(installmentPlanDetails) : null);
    }

    public static final String getSubscriptionBillingPeriod(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        List pricingPhaseList = subscriptionOfferDetails.getPricingPhases().getPricingPhaseList();
        Intrinsics.checkNotNullExpressionValue(pricingPhaseList, "this.pricingPhases.pricingPhaseList");
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.lastOrNull(pricingPhaseList);
        if (pricingPhase != null) {
            return pricingPhase.getBillingPeriod();
        }
        return null;
    }

    public static final boolean isBasePlan(ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails) {
        Intrinsics.checkNotNullParameter(subscriptionOfferDetails, "<this>");
        return subscriptionOfferDetails.getPricingPhases().getPricingPhaseList().size() == 1;
    }

    private static final GoogleInstallmentsInfo getInstallmentsInfo(ProductDetails.InstallmentPlanDetails installmentPlanDetails) {
        return new GoogleInstallmentsInfo(installmentPlanDetails.getInstallmentPlanCommitmentPaymentsCount(), installmentPlanDetails.getSubsequentInstallmentPlanCommitmentPaymentsCount());
    }
}
