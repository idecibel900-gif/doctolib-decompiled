package com.revenuecat.purchases.ads.events.types;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.ExperimentalPreviewRevenueCatPurchasesAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ExperimentalPreviewRevenueCatPurchasesAPI
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;", "", "networkName", "", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "revenueMicros", "", b.a, "precision", "Lcom/revenuecat/purchases/ads/events/types/AdRevenuePrecision;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getCurrency", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "getPrecision-rAcPn4k", "getRevenueMicros", "()J", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdRevenueData {
    private final String adFormat;
    private final String adUnitId;
    private final String currency;
    private final String impressionId;
    private final String mediatorName;
    private final String networkName;
    private final String placement;
    private final String precision;
    private final long revenueMicros;

    public /* synthetic */ AdRevenueData(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, j, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdRevenueData)) {
            return false;
        }
        AdRevenueData adRevenueData = (AdRevenueData) obj;
        return Intrinsics.areEqual(this.networkName, adRevenueData.networkName) && AdMediatorName.m3823equalsimpl0(this.mediatorName, adRevenueData.mediatorName) && AdFormat.m3806equalsimpl0(this.adFormat, adRevenueData.adFormat) && Intrinsics.areEqual(this.placement, adRevenueData.placement) && Intrinsics.areEqual(this.adUnitId, adRevenueData.adUnitId) && Intrinsics.areEqual(this.impressionId, adRevenueData.impressionId) && this.revenueMicros == adRevenueData.revenueMicros && Intrinsics.areEqual(this.currency, adRevenueData.currency) && AdRevenuePrecision.m3838equalsimpl0(this.precision, adRevenueData.precision);
    }

    public int hashCode() {
        String str = this.networkName;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + AdMediatorName.m3824hashCodeimpl(this.mediatorName)) * 31) + AdFormat.m3807hashCodeimpl(this.adFormat)) * 31;
        String str2 = this.placement;
        return ((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.adUnitId.hashCode()) * 31) + this.impressionId.hashCode()) * 31) + Long.hashCode(this.revenueMicros)) * 31) + this.currency.hashCode()) * 31) + AdRevenuePrecision.m3839hashCodeimpl(this.precision);
    }

    public String toString() {
        return "AdRevenueData(networkName=" + this.networkName + ", mediatorName=" + ((Object) AdMediatorName.m3825toStringimpl(this.mediatorName)) + ", adFormat=" + ((Object) AdFormat.m3808toStringimpl(this.adFormat)) + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ", revenueMicros=" + this.revenueMicros + ", currency=" + this.currency + ", precision=" + ((Object) AdRevenuePrecision.m3840toStringimpl(this.precision)) + ')';
    }

    private AdRevenueData(String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, long j, String currency, String precision) {
        Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(precision, "precision");
        this.networkName = str;
        this.mediatorName = mediatorName;
        this.adFormat = adFormat;
        this.placement = str2;
        this.adUnitId = adUnitId;
        this.impressionId = impressionId;
        this.revenueMicros = j;
        this.currency = currency;
        this.precision = precision;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name and from getter */
    public final String getMediatorName() {
        return this.mediatorName;
    }

    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name and from getter */
    public final String getAdFormat() {
        return this.adFormat;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getImpressionId() {
        return this.impressionId;
    }

    public final long getRevenueMicros() {
        return this.revenueMicros;
    }

    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: getPrecision-rAcPn4k, reason: not valid java name and from getter */
    public final String getPrecision() {
        return this.precision;
    }
}
