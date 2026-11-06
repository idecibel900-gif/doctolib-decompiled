package com.revenuecat.purchases.paywalls.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/CustomPaywallImpressionParams;", "", "paywallId", "", "offeringId", "(Ljava/lang/String;Ljava/lang/String;)V", "getOfferingId", "()Ljava/lang/String;", "getPaywallId", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomPaywallImpressionParams {
    private final String offeringId;
    private final String paywallId;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomPaywallImpressionParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomPaywallImpressionParams(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomPaywallImpressionParams)) {
            return false;
        }
        CustomPaywallImpressionParams customPaywallImpressionParams = (CustomPaywallImpressionParams) obj;
        return Intrinsics.areEqual(this.paywallId, customPaywallImpressionParams.paywallId) && Intrinsics.areEqual(this.offeringId, customPaywallImpressionParams.offeringId);
    }

    public int hashCode() {
        String str = this.paywallId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.offeringId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CustomPaywallImpressionParams(paywallId=" + this.paywallId + ", offeringId=" + this.offeringId + ')';
    }

    public CustomPaywallImpressionParams(String str, String str2) {
        this.paywallId = str;
        this.offeringId = str2;
    }

    public /* synthetic */ CustomPaywallImpressionParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getPaywallId() {
        return this.paywallId;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }
}
