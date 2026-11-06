package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/CarouselPageChangeInteraction;", "", "componentName", "", "destinationPageIndex", "", "originPageIndex", "defaultPageIndex", "originContextName", "destinationContextName", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V", "getComponentName", "()Ljava/lang/String;", "getDefaultPageIndex", "()I", "getDestinationContextName", "getDestinationPageIndex", "getOriginContextName", "getOriginPageIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CarouselPageChangeInteraction {
    public static final int $stable = 0;
    private final String componentName;
    private final int defaultPageIndex;
    private final String destinationContextName;
    private final int destinationPageIndex;
    private final String originContextName;
    private final int originPageIndex;

    public static /* synthetic */ CarouselPageChangeInteraction copy$default(CarouselPageChangeInteraction carouselPageChangeInteraction, String str, int i, int i2, int i3, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = carouselPageChangeInteraction.componentName;
        }
        if ((i4 & 2) != 0) {
            i = carouselPageChangeInteraction.destinationPageIndex;
        }
        if ((i4 & 4) != 0) {
            i2 = carouselPageChangeInteraction.originPageIndex;
        }
        if ((i4 & 8) != 0) {
            i3 = carouselPageChangeInteraction.defaultPageIndex;
        }
        if ((i4 & 16) != 0) {
            str2 = carouselPageChangeInteraction.originContextName;
        }
        if ((i4 & 32) != 0) {
            str3 = carouselPageChangeInteraction.destinationContextName;
        }
        String str4 = str2;
        String str5 = str3;
        return carouselPageChangeInteraction.copy(str, i, i2, i3, str4, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComponentName() {
        return this.componentName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDestinationPageIndex() {
        return this.destinationPageIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getOriginPageIndex() {
        return this.originPageIndex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDefaultPageIndex() {
        return this.defaultPageIndex;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOriginContextName() {
        return this.originContextName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDestinationContextName() {
        return this.destinationContextName;
    }

    public final CarouselPageChangeInteraction copy(String componentName, int destinationPageIndex, int originPageIndex, int defaultPageIndex, String originContextName, String destinationContextName) {
        return new CarouselPageChangeInteraction(componentName, destinationPageIndex, originPageIndex, defaultPageIndex, originContextName, destinationContextName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CarouselPageChangeInteraction)) {
            return false;
        }
        CarouselPageChangeInteraction carouselPageChangeInteraction = (CarouselPageChangeInteraction) other;
        return Intrinsics.areEqual(this.componentName, carouselPageChangeInteraction.componentName) && this.destinationPageIndex == carouselPageChangeInteraction.destinationPageIndex && this.originPageIndex == carouselPageChangeInteraction.originPageIndex && this.defaultPageIndex == carouselPageChangeInteraction.defaultPageIndex && Intrinsics.areEqual(this.originContextName, carouselPageChangeInteraction.originContextName) && Intrinsics.areEqual(this.destinationContextName, carouselPageChangeInteraction.destinationContextName);
    }

    public int hashCode() {
        String str = this.componentName;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.destinationPageIndex)) * 31) + Integer.hashCode(this.originPageIndex)) * 31) + Integer.hashCode(this.defaultPageIndex)) * 31;
        String str2 = this.originContextName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.destinationContextName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "CarouselPageChangeInteraction(componentName=" + this.componentName + ", destinationPageIndex=" + this.destinationPageIndex + ", originPageIndex=" + this.originPageIndex + ", defaultPageIndex=" + this.defaultPageIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ')';
    }

    public CarouselPageChangeInteraction(String str, int i, int i2, int i3, String str2, String str3) {
        this.componentName = str;
        this.destinationPageIndex = i;
        this.originPageIndex = i2;
        this.defaultPageIndex = i3;
        this.originContextName = str2;
        this.destinationContextName = str3;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final int getDestinationPageIndex() {
        return this.destinationPageIndex;
    }

    public final int getOriginPageIndex() {
        return this.originPageIndex;
    }

    public final int getDefaultPageIndex() {
        return this.defaultPageIndex;
    }

    public final String getOriginContextName() {
        return this.originContextName;
    }

    public final String getDestinationContextName() {
        return this.destinationContextName;
    }
}
