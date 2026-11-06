package com.revenuecat.purchases.google;

import com.amazon.a.a.o.c.a.b;
import com.android.billingclient.api.BillingResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getOnPurchasesUpdatedSubResponseCodeName", "", "", "toHumanReadableDescription", "Lcom/android/billingclient/api/BillingResult;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingResultExtensionsBillingIndependentKt {
    public static final String toHumanReadableDescription(BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "<this>");
        return "DebugMessage: " + billingResult.getDebugMessage() + ". ErrorCode: " + ErrorsKt.getBillingResponseCodeName(billingResult.getResponseCode()) + ". SubResponseCode: " + getOnPurchasesUpdatedSubResponseCodeName(billingResult.getOnPurchasesUpdatedSubResponseCode()) + b.a;
    }

    private static final String getOnPurchasesUpdatedSubResponseCodeName(int i) {
        if (i == 0) {
            return "NO_APPLICABLE_SUB_RESPONSE_CODE";
        }
        if (i == 1) {
            return "PAYMENT_DECLINED_DUE_TO_INSUFFICIENT_FUNDS";
        }
        if (i == 2) {
            return "USER_INELIGIBLE";
        }
        return "UNKNOWN_SUB_RESPONSE_CODE (" + i + ')';
    }
}
