package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterScaffoldConfig;", "", b.S, "", "shouldUseLargeTopBar", "", "navigationButtonType", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "(Ljava/lang/String;ZLcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;)V", "getNavigationButtonType", "()Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/CustomerCenterState$NavigationButtonType;", "getShouldUseLargeTopBar", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class CustomerCenterScaffoldConfig {
    private final CustomerCenterState.NavigationButtonType navigationButtonType;
    private final boolean shouldUseLargeTopBar;
    private final String title;

    public static /* synthetic */ CustomerCenterScaffoldConfig copy$default(CustomerCenterScaffoldConfig customerCenterScaffoldConfig, String str, boolean z, CustomerCenterState.NavigationButtonType navigationButtonType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customerCenterScaffoldConfig.title;
        }
        if ((i & 2) != 0) {
            z = customerCenterScaffoldConfig.shouldUseLargeTopBar;
        }
        if ((i & 4) != 0) {
            navigationButtonType = customerCenterScaffoldConfig.navigationButtonType;
        }
        return customerCenterScaffoldConfig.copy(str, z, navigationButtonType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldUseLargeTopBar() {
        return this.shouldUseLargeTopBar;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CustomerCenterState.NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }

    public final CustomerCenterScaffoldConfig copy(String title, boolean shouldUseLargeTopBar, CustomerCenterState.NavigationButtonType navigationButtonType) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        return new CustomerCenterScaffoldConfig(title, shouldUseLargeTopBar, navigationButtonType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerCenterScaffoldConfig)) {
            return false;
        }
        CustomerCenterScaffoldConfig customerCenterScaffoldConfig = (CustomerCenterScaffoldConfig) other;
        return Intrinsics.areEqual(this.title, customerCenterScaffoldConfig.title) && this.shouldUseLargeTopBar == customerCenterScaffoldConfig.shouldUseLargeTopBar && this.navigationButtonType == customerCenterScaffoldConfig.navigationButtonType;
    }

    public int hashCode() {
        String str = this.title;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.shouldUseLargeTopBar)) * 31) + this.navigationButtonType.hashCode();
    }

    public String toString() {
        return "CustomerCenterScaffoldConfig(title=" + this.title + ", shouldUseLargeTopBar=" + this.shouldUseLargeTopBar + ", navigationButtonType=" + this.navigationButtonType + ')';
    }

    public CustomerCenterScaffoldConfig(String str, boolean z, CustomerCenterState.NavigationButtonType navigationButtonType) {
        Intrinsics.checkNotNullParameter(navigationButtonType, "navigationButtonType");
        this.title = str;
        this.shouldUseLargeTopBar = z;
        this.navigationButtonType = navigationButtonType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getShouldUseLargeTopBar() {
        return this.shouldUseLargeTopBar;
    }

    public final CustomerCenterState.NavigationButtonType getNavigationButtonType() {
        return this.navigationButtonType;
    }
}
