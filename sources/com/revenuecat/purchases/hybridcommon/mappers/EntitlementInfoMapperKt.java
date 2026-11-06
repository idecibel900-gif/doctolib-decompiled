package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfo;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EntitlementInfoMapperKt {
    public static final Map<String, Object> map(EntitlementInfo entitlementInfo) {
        Intrinsics.checkNotNullParameter(entitlementInfo, "<this>");
        Pair pair = TuplesKt.to("identifier", entitlementInfo.getIdentifier());
        Pair pair2 = TuplesKt.to("isActive", Boolean.valueOf(entitlementInfo.getIsActive()));
        Pair pair3 = TuplesKt.to("willRenew", Boolean.valueOf(entitlementInfo.getWillRenew()));
        Pair pair4 = TuplesKt.to("periodType", entitlementInfo.getPeriodType().name());
        Pair pair5 = TuplesKt.to("latestPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getLatestPurchaseDate())));
        Pair pair6 = TuplesKt.to("latestPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getLatestPurchaseDate()));
        Pair pair7 = TuplesKt.to("originalPurchaseDateMillis", Long.valueOf(MappersHelpersKt.toMillis(entitlementInfo.getOriginalPurchaseDate())));
        Pair pair8 = TuplesKt.to("originalPurchaseDate", MappersHelpersKt.toIso8601(entitlementInfo.getOriginalPurchaseDate()));
        Date expirationDate = entitlementInfo.getExpirationDate();
        Pair pair9 = TuplesKt.to("expirationDateMillis", expirationDate != null ? Long.valueOf(MappersHelpersKt.toMillis(expirationDate)) : null);
        Date expirationDate2 = entitlementInfo.getExpirationDate();
        Pair pair10 = TuplesKt.to("expirationDate", expirationDate2 != null ? MappersHelpersKt.toIso8601(expirationDate2) : null);
        Pair pair11 = TuplesKt.to(ProductResponseJsonKeys.STORE, entitlementInfo.getStore().name());
        Pair pair12 = TuplesKt.to("productIdentifier", entitlementInfo.getProductIdentifier());
        Pair pair13 = TuplesKt.to("productPlanIdentifier", entitlementInfo.getProductPlanIdentifier());
        Pair pair14 = TuplesKt.to("isSandbox", Boolean.valueOf(entitlementInfo.getIsSandbox()));
        Date unsubscribeDetectedAt = entitlementInfo.getUnsubscribeDetectedAt();
        Pair pair15 = TuplesKt.to("unsubscribeDetectedAt", unsubscribeDetectedAt != null ? MappersHelpersKt.toIso8601(unsubscribeDetectedAt) : null);
        Date unsubscribeDetectedAt2 = entitlementInfo.getUnsubscribeDetectedAt();
        Pair pair16 = TuplesKt.to("unsubscribeDetectedAtMillis", unsubscribeDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(unsubscribeDetectedAt2)) : null);
        Date billingIssueDetectedAt = entitlementInfo.getBillingIssueDetectedAt();
        Pair pair17 = TuplesKt.to("billingIssueDetectedAt", billingIssueDetectedAt != null ? MappersHelpersKt.toIso8601(billingIssueDetectedAt) : null);
        Date billingIssueDetectedAt2 = entitlementInfo.getBillingIssueDetectedAt();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, TuplesKt.to("billingIssueDetectedAtMillis", billingIssueDetectedAt2 != null ? Long.valueOf(MappersHelpersKt.toMillis(billingIssueDetectedAt2)) : null), TuplesKt.to("ownershipType", entitlementInfo.getOwnershipType().name()), TuplesKt.to("verification", entitlementInfo.getVerification().name()));
    }
}
