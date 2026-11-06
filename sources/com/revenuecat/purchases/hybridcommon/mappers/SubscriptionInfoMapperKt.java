package com.revenuecat.purchases.hybridcommon.mappers;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/SubscriptionInfo;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionInfoMapperKt {
    public static final Map<String, Object> map(SubscriptionInfo subscriptionInfo) {
        Intrinsics.checkNotNullParameter(subscriptionInfo, "<this>");
        Pair pair = TuplesKt.to("productIdentifier", subscriptionInfo.getProductIdentifier());
        Pair pair2 = TuplesKt.to(b.Q, MappersHelpersKt.toIso8601(subscriptionInfo.getPurchaseDate()));
        Date originalPurchaseDate = subscriptionInfo.getOriginalPurchaseDate();
        Pair pair3 = TuplesKt.to("originalPurchaseDate", originalPurchaseDate != null ? MappersHelpersKt.toIso8601(originalPurchaseDate) : null);
        Date expiresDate = subscriptionInfo.getExpiresDate();
        Pair pair4 = TuplesKt.to("expiresDate", expiresDate != null ? MappersHelpersKt.toIso8601(expiresDate) : null);
        Pair pair5 = TuplesKt.to(ProductResponseJsonKeys.STORE, subscriptionInfo.getStore().name());
        Date unsubscribeDetectedAt = subscriptionInfo.getUnsubscribeDetectedAt();
        Pair pair6 = TuplesKt.to("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Pair pair7 = TuplesKt.to("isSandbox", Boolean.valueOf(subscriptionInfo.getIsSandbox()));
        Date billingIssuesDetectedAt = subscriptionInfo.getBillingIssuesDetectedAt();
        Pair pair8 = TuplesKt.to("billingIssuesDetectedAt", billingIssuesDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssuesDetectedAt) : null);
        Date gracePeriodExpiresDate = subscriptionInfo.getGracePeriodExpiresDate();
        Pair pair9 = TuplesKt.to("gracePeriodExpiresDate", gracePeriodExpiresDate != null ? MappersHelpersKt.toIso8601(gracePeriodExpiresDate) : null);
        Pair pair10 = TuplesKt.to("ownershipType", subscriptionInfo.getOwnershipType().name());
        Pair pair11 = TuplesKt.to("periodType", subscriptionInfo.getPeriodType().name());
        Date refundedAt = subscriptionInfo.getRefundedAt();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, TuplesKt.to("refundedAt", refundedAt != null ? MappersHelpersKt.toIso8601(refundedAt) : null), TuplesKt.to("storeTransactionId", subscriptionInfo.getStoreTransactionId()), TuplesKt.to("isActive", Boolean.valueOf(subscriptionInfo.getIsActive())), TuplesKt.to("willRenew", Boolean.valueOf(subscriptionInfo.getWillRenew())));
    }
}
