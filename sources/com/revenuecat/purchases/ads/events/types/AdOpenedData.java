package com.revenuecat.purchases.ads.events.types;

import com.revenuecat.purchases.ExperimentalPreviewRevenueCatPurchasesAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ExperimentalPreviewRevenueCatPurchasesAPI
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;", "", "networkName", "", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdOpenedData {
    private final String adFormat;
    private final String adUnitId;
    private final String impressionId;
    private final String mediatorName;
    private final String networkName;
    private final String placement;

    public /* synthetic */ AdOpenedData(String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdOpenedData)) {
            return false;
        }
        AdOpenedData adOpenedData = (AdOpenedData) obj;
        return Intrinsics.areEqual(this.networkName, adOpenedData.networkName) && AdMediatorName.m3823equalsimpl0(this.mediatorName, adOpenedData.mediatorName) && AdFormat.m3806equalsimpl0(this.adFormat, adOpenedData.adFormat) && Intrinsics.areEqual(this.placement, adOpenedData.placement) && Intrinsics.areEqual(this.adUnitId, adOpenedData.adUnitId) && Intrinsics.areEqual(this.impressionId, adOpenedData.impressionId);
    }

    public int hashCode() {
        String str = this.networkName;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + AdMediatorName.m3824hashCodeimpl(this.mediatorName)) * 31) + AdFormat.m3807hashCodeimpl(this.adFormat)) * 31;
        String str2 = this.placement;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.adUnitId.hashCode()) * 31) + this.impressionId.hashCode();
    }

    public String toString() {
        return "AdOpenedData(networkName=" + this.networkName + ", mediatorName=" + ((Object) AdMediatorName.m3825toStringimpl(this.mediatorName)) + ", adFormat=" + ((Object) AdFormat.m3808toStringimpl(this.adFormat)) + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ')';
    }

    private AdOpenedData(String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId) {
        Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        this.networkName = str;
        this.mediatorName = mediatorName;
        this.adFormat = adFormat;
        this.placement = str2;
        this.adUnitId = adUnitId;
        this.impressionId = impressionId;
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
}
