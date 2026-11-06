package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001CBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\u0002\u0010\u001aJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\u0015\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\u008f\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017HÆ\u0001J\u0013\u0010<\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "border", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "control", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "tabs", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle$Tab;", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTabsPartial;", "(ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;Ljava/util/List;)V", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getControl", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOverrides", "()Ljava/util/List;", "getPadding", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTabs", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "getVisible", "()Z", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "Tab", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TabsComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final BackgroundStyles background;
    private final BorderStyles border;
    private final TabControlStyle control;
    private final PaddingValues margin;
    private final List<PresentedOverride<PresentedTabsPartial>> overrides;
    private final PaddingValues padding;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final NonEmptyList<Tab> tabs;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabsComponentStyle copy$default(TabsComponentStyle tabsComponentStyle, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, BackgroundStyles backgroundStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, TabControlStyle tabControlStyle, NonEmptyList nonEmptyList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tabsComponentStyle.visible;
        }
        if ((i & 2) != 0) {
            size = tabsComponentStyle.size;
        }
        if ((i & 4) != 0) {
            paddingValues = tabsComponentStyle.padding;
        }
        if ((i & 8) != 0) {
            paddingValues2 = tabsComponentStyle.margin;
        }
        if ((i & 16) != 0) {
            backgroundStyles = tabsComponentStyle.background;
        }
        if ((i & 32) != 0) {
            shape = tabsComponentStyle.shape;
        }
        if ((i & 64) != 0) {
            borderStyles = tabsComponentStyle.border;
        }
        if ((i & 128) != 0) {
            shadowStyles = tabsComponentStyle.shadow;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            tabControlStyle = tabsComponentStyle.control;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            nonEmptyList = tabsComponentStyle.tabs;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            list = tabsComponentStyle.overrides;
        }
        NonEmptyList nonEmptyList2 = nonEmptyList;
        List list2 = list;
        ShadowStyles shadowStyles2 = shadowStyles;
        TabControlStyle tabControlStyle2 = tabControlStyle;
        Shape shape2 = shape;
        BorderStyles borderStyles2 = borderStyles;
        BackgroundStyles backgroundStyles2 = backgroundStyles;
        PaddingValues paddingValues3 = paddingValues;
        return tabsComponentStyle.copy(z, size, paddingValues3, paddingValues2, backgroundStyles2, shape2, borderStyles2, shadowStyles2, tabControlStyle2, nonEmptyList2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final NonEmptyList<Tab> component10() {
        return this.tabs;
    }

    public final List<PresentedOverride<PresentedTabsPartial>> component11() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PaddingValues getMargin() {
        return this.margin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final BackgroundStyles getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final BorderStyles getBorder() {
        return this.border;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ShadowStyles getShadow() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final TabControlStyle getControl() {
        return this.control;
    }

    public final TabsComponentStyle copy(boolean visible, Size size, PaddingValues padding, PaddingValues margin, BackgroundStyles background, Shape shape, BorderStyles border, ShadowStyles shadow, TabControlStyle control, NonEmptyList<Tab> tabs, List<PresentedOverride<PresentedTabsPartial>> overrides) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(control, "control");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new TabsComponentStyle(visible, size, padding, margin, background, shape, border, shadow, control, tabs, overrides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabsComponentStyle)) {
            return false;
        }
        TabsComponentStyle tabsComponentStyle = (TabsComponentStyle) other;
        return this.visible == tabsComponentStyle.visible && Intrinsics.areEqual(this.size, tabsComponentStyle.size) && Intrinsics.areEqual(this.padding, tabsComponentStyle.padding) && Intrinsics.areEqual(this.margin, tabsComponentStyle.margin) && Intrinsics.areEqual(this.background, tabsComponentStyle.background) && Intrinsics.areEqual(this.shape, tabsComponentStyle.shape) && Intrinsics.areEqual(this.border, tabsComponentStyle.border) && Intrinsics.areEqual(this.shadow, tabsComponentStyle.shadow) && Intrinsics.areEqual(this.control, tabsComponentStyle.control) && Intrinsics.areEqual(this.tabs, tabsComponentStyle.tabs) && Intrinsics.areEqual(this.overrides, tabsComponentStyle.overrides);
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.visible) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        return ((((((iHashCode3 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.control.hashCode()) * 31) + this.tabs.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TabsComponentStyle(visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", background=" + this.background + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", control=" + this.control + ", tabs=" + this.tabs + ", overrides=" + this.overrides + ')';
    }

    public TabsComponentStyle(boolean z, Size size, PaddingValues padding, PaddingValues margin, BackgroundStyles backgroundStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, TabControlStyle control, NonEmptyList<Tab> tabs, List<PresentedOverride<PresentedTabsPartial>> overrides) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(control, "control");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.visible = z;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.background = backgroundStyles;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.control = control;
        this.tabs = tabs;
        this.overrides = overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ TabControlStyle getControl() {
        return this.control;
    }

    public final /* synthetic */ NonEmptyList getTabs() {
        return this.tabs;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle$Tab;", "", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Tab {
        public static final int $stable = 0;
        private final StackComponentStyle stack;

        public static /* synthetic */ Tab copy$default(Tab tab, StackComponentStyle stackComponentStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                stackComponentStyle = tab.stack;
            }
            return tab.copy(stackComponentStyle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StackComponentStyle getStack() {
            return this.stack;
        }

        public final Tab copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Tab(stack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Tab) && Intrinsics.areEqual(this.stack, ((Tab) other).stack);
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Tab(stack=" + this.stack + ')';
        }

        public Tab(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }
    }
}
