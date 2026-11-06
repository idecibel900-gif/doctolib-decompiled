package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jo\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "tabIndex", "", "tabId", "", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "tabsComponentName", "tabButtonName", "tabIdsOrdered", "", "tabContextNamesById", "", "tabsDefaultTabIndex", "(ILjava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;I)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getTabButtonName", "()Ljava/lang/String;", "getTabContextNamesById", "()Ljava/util/Map;", "getTabId", "getTabIdsOrdered", "()Ljava/util/List;", "getTabIndex", "()I", "getTabsComponentName", "getTabsDefaultTabIndex", "visible", "", "getVisible", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TabControlButtonComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final StackComponentStyle stack;
    private final String tabButtonName;
    private final Map<String, String> tabContextNamesById;
    private final String tabId;
    private final List<String> tabIdsOrdered;
    private final int tabIndex;
    private final String tabsComponentName;
    private final int tabsDefaultTabIndex;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabControlButtonComponentStyle copy$default(TabControlButtonComponentStyle tabControlButtonComponentStyle, int i, String str, StackComponentStyle stackComponentStyle, String str2, String str3, List list, Map map, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tabControlButtonComponentStyle.tabIndex;
        }
        if ((i3 & 2) != 0) {
            str = tabControlButtonComponentStyle.tabId;
        }
        if ((i3 & 4) != 0) {
            stackComponentStyle = tabControlButtonComponentStyle.stack;
        }
        if ((i3 & 8) != 0) {
            str2 = tabControlButtonComponentStyle.tabsComponentName;
        }
        if ((i3 & 16) != 0) {
            str3 = tabControlButtonComponentStyle.tabButtonName;
        }
        if ((i3 & 32) != 0) {
            list = tabControlButtonComponentStyle.tabIdsOrdered;
        }
        if ((i3 & 64) != 0) {
            map = tabControlButtonComponentStyle.tabContextNamesById;
        }
        if ((i3 & 128) != 0) {
            i2 = tabControlButtonComponentStyle.tabsDefaultTabIndex;
        }
        Map map2 = map;
        int i4 = i2;
        String str4 = str3;
        List list2 = list;
        return tabControlButtonComponentStyle.copy(i, str, stackComponentStyle, str2, str4, list2, map2, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTabId() {
        return this.tabId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StackComponentStyle getStack() {
        return this.stack;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTabsComponentName() {
        return this.tabsComponentName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTabButtonName() {
        return this.tabButtonName;
    }

    public final List<String> component6() {
        return this.tabIdsOrdered;
    }

    public final Map<String, String> component7() {
        return this.tabContextNamesById;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTabsDefaultTabIndex() {
        return this.tabsDefaultTabIndex;
    }

    public final TabControlButtonComponentStyle copy(int tabIndex, String tabId, StackComponentStyle stack, String tabsComponentName, String tabButtonName, List<String> tabIdsOrdered, Map<String, String> tabContextNamesById, int tabsDefaultTabIndex) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(tabIdsOrdered, "tabIdsOrdered");
        Intrinsics.checkNotNullParameter(tabContextNamesById, "tabContextNamesById");
        return new TabControlButtonComponentStyle(tabIndex, tabId, stack, tabsComponentName, tabButtonName, tabIdsOrdered, tabContextNamesById, tabsDefaultTabIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabControlButtonComponentStyle)) {
            return false;
        }
        TabControlButtonComponentStyle tabControlButtonComponentStyle = (TabControlButtonComponentStyle) other;
        return this.tabIndex == tabControlButtonComponentStyle.tabIndex && Intrinsics.areEqual(this.tabId, tabControlButtonComponentStyle.tabId) && Intrinsics.areEqual(this.stack, tabControlButtonComponentStyle.stack) && Intrinsics.areEqual(this.tabsComponentName, tabControlButtonComponentStyle.tabsComponentName) && Intrinsics.areEqual(this.tabButtonName, tabControlButtonComponentStyle.tabButtonName) && Intrinsics.areEqual(this.tabIdsOrdered, tabControlButtonComponentStyle.tabIdsOrdered) && Intrinsics.areEqual(this.tabContextNamesById, tabControlButtonComponentStyle.tabContextNamesById) && this.tabsDefaultTabIndex == tabControlButtonComponentStyle.tabsDefaultTabIndex;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.tabIndex) * 31) + this.tabId.hashCode()) * 31) + this.stack.hashCode()) * 31;
        String str = this.tabsComponentName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tabButtonName;
        return ((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.tabIdsOrdered.hashCode()) * 31) + this.tabContextNamesById.hashCode()) * 31) + Integer.hashCode(this.tabsDefaultTabIndex);
    }

    public String toString() {
        return "TabControlButtonComponentStyle(tabIndex=" + this.tabIndex + ", tabId=" + this.tabId + ", stack=" + this.stack + ", tabsComponentName=" + this.tabsComponentName + ", tabButtonName=" + this.tabButtonName + ", tabIdsOrdered=" + this.tabIdsOrdered + ", tabContextNamesById=" + this.tabContextNamesById + ", tabsDefaultTabIndex=" + this.tabsDefaultTabIndex + ')';
    }

    public TabControlButtonComponentStyle(int i, String tabId, StackComponentStyle stack, String str, String str2, List<String> tabIdsOrdered, Map<String, String> tabContextNamesById, int i2) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(tabIdsOrdered, "tabIdsOrdered");
        Intrinsics.checkNotNullParameter(tabContextNamesById, "tabContextNamesById");
        this.tabIndex = i;
        this.tabId = tabId;
        this.stack = stack;
        this.tabsComponentName = str;
        this.tabButtonName = str2;
        this.tabIdsOrdered = tabIdsOrdered;
        this.tabContextNamesById = tabContextNamesById;
        this.tabsDefaultTabIndex = i2;
        this.visible = stack.getVisible();
        this.size = stack.getSize();
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ String getTabId() {
        return this.tabId;
    }

    public final /* synthetic */ StackComponentStyle getStack() {
        return this.stack;
    }

    public final /* synthetic */ String getTabsComponentName() {
        return this.tabsComponentName;
    }

    public final /* synthetic */ String getTabButtonName() {
        return this.tabButtonName;
    }

    public /* synthetic */ TabControlButtonComponentStyle(int i, String str, StackComponentStyle stackComponentStyle, String str2, String str3, List list, Map map, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, stackComponentStyle, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? MapsKt.emptyMap() : map, (i3 & 128) != 0 ? 0 : i2);
    }

    public final /* synthetic */ List getTabIdsOrdered() {
        return this.tabIdsOrdered;
    }

    public final /* synthetic */ Map getTabContextNamesById() {
        return this.tabContextNamesById;
    }

    public final /* synthetic */ int getTabsDefaultTabIndex() {
        return this.tabsDefaultTabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }
}
