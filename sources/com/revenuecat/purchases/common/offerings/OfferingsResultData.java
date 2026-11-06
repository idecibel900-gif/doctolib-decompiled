package com.revenuecat.purchases.common.offerings;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Offerings;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsResultData;", "", "offerings", "Lcom/revenuecat/purchases/Offerings;", "requestedProductIds", "", "", "notFoundProductIds", "(Lcom/revenuecat/purchases/Offerings;Ljava/util/Set;Ljava/util/Set;)V", "getNotFoundProductIds", "()Ljava/util/Set;", "getOfferings", "()Lcom/revenuecat/purchases/Offerings;", "getRequestedProductIds", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OfferingsResultData {
    private final Set<String> notFoundProductIds;
    private final Offerings offerings;
    private final Set<String> requestedProductIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferingsResultData copy$default(OfferingsResultData offeringsResultData, Offerings offerings, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            offerings = offeringsResultData.offerings;
        }
        if ((i & 2) != 0) {
            set = offeringsResultData.requestedProductIds;
        }
        if ((i & 4) != 0) {
            set2 = offeringsResultData.notFoundProductIds;
        }
        return offeringsResultData.copy(offerings, set, set2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Offerings getOfferings() {
        return this.offerings;
    }

    public final Set<String> component2() {
        return this.requestedProductIds;
    }

    public final Set<String> component3() {
        return this.notFoundProductIds;
    }

    public final OfferingsResultData copy(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        return new OfferingsResultData(offerings, requestedProductIds, notFoundProductIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferingsResultData)) {
            return false;
        }
        OfferingsResultData offeringsResultData = (OfferingsResultData) other;
        return Intrinsics.areEqual(this.offerings, offeringsResultData.offerings) && Intrinsics.areEqual(this.requestedProductIds, offeringsResultData.requestedProductIds) && Intrinsics.areEqual(this.notFoundProductIds, offeringsResultData.notFoundProductIds);
    }

    public int hashCode() {
        return (((this.offerings.hashCode() * 31) + this.requestedProductIds.hashCode()) * 31) + this.notFoundProductIds.hashCode();
    }

    public String toString() {
        return "OfferingsResultData(offerings=" + this.offerings + ", requestedProductIds=" + this.requestedProductIds + ", notFoundProductIds=" + this.notFoundProductIds + ')';
    }

    public OfferingsResultData(Offerings offerings, Set<String> requestedProductIds, Set<String> notFoundProductIds) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(requestedProductIds, "requestedProductIds");
        Intrinsics.checkNotNullParameter(notFoundProductIds, "notFoundProductIds");
        this.offerings = offerings;
        this.requestedProductIds = requestedProductIds;
        this.notFoundProductIds = notFoundProductIds;
    }

    public final Offerings getOfferings() {
        return this.offerings;
    }

    public final Set<String> getRequestedProductIds() {
        return this.requestedProductIds;
    }

    public final Set<String> getNotFoundProductIds() {
        return this.notFoundProductIds;
    }
}
