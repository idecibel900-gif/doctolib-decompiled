package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/ScaffoldConfigData;", "", b.S, "", "navigationButtonType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "shouldUseLargeTopBar", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;Z)V", "getNavigationButtonType", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "getShouldUseLargeTopBar", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class ScaffoldConfigData {
    private final CustomerCenterState.NavigationButtonType navigationButtonType;
    private final boolean shouldUseLargeTopBar;
    private final String title;

    public static /* synthetic */ ScaffoldConfigData copy$default(ScaffoldConfigData scaffoldConfigData, String str, CustomerCenterState.NavigationButtonType navigationButtonType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scaffoldConfigData.title;
        }
        if ((i & 2) != 0) {
            navigationButtonType = scaffoldConfigData.navigationButtonType;
        }
        if ((i & 4) != 0) {
            z = scaffoldConfigData.shouldUseLargeTopBar;
        }
        return scaffoldConfigData.copy(str, navigationButtonType, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CustomerCenterState.NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShouldUseLargeTopBar() {
        return this.shouldUseLargeTopBar;
    }

    public final ScaffoldConfigData copy(String title, CustomerCenterState.NavigationButtonType navigationButtonType, boolean shouldUseLargeTopBar) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        return new ScaffoldConfigData(title, navigationButtonType, shouldUseLargeTopBar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScaffoldConfigData)) {
            return false;
        }
        ScaffoldConfigData scaffoldConfigData = (ScaffoldConfigData) other;
        return Intrinsics.areEqual(this.title, scaffoldConfigData.title) && this.navigationButtonType == scaffoldConfigData.navigationButtonType && this.shouldUseLargeTopBar == scaffoldConfigData.shouldUseLargeTopBar;
    }

    public int hashCode() {
        String str = this.title;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.navigationButtonType.hashCode()) * 31) + Boolean.hashCode(this.shouldUseLargeTopBar);
    }

    public String toString() {
        return "ScaffoldConfigData(title=" + this.title + ", navigationButtonType=" + this.navigationButtonType + ", shouldUseLargeTopBar=" + this.shouldUseLargeTopBar + ')';
    }

    public ScaffoldConfigData(String str, CustomerCenterState.NavigationButtonType navigationButtonType, boolean z) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        this.title = str;
        this.navigationButtonType = navigationButtonType;
        this.shouldUseLargeTopBar = z;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CustomerCenterState.NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    public final boolean getShouldUseLargeTopBar() {
        return this.shouldUseLargeTopBar;
    }
}
