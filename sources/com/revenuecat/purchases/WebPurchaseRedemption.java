package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/WebPurchaseRedemption;", "", "redemptionToken", "", "(Ljava/lang/String;)V", "getRedemptionToken$purchases_defaultsBc8Release", "()Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebPurchaseRedemption {
    private final String redemptionToken;

    public WebPurchaseRedemption(String redemptionToken) {
        Intrinsics.checkNotNullParameter(redemptionToken, "redemptionToken");
        this.redemptionToken = redemptionToken;
    }

    /* JADX INFO: renamed from: getRedemptionToken$purchases_defaultsBc8Release, reason: from getter */
    public final String getRedemptionToken() {
        return this.redemptionToken;
    }
}
