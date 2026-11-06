package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "", "stackStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "alignment", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;)V", "getAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "getStackStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BadgeStyle {
    public static final int $stable = 0;
    private final TwoDimensionalAlignment alignment;
    private final StackComponentStyle stackStyle;
    private final Badge.Style style;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeStyle)) {
            return false;
        }
        BadgeStyle badgeStyle = (BadgeStyle) obj;
        return Intrinsics.areEqual(this.stackStyle, badgeStyle.stackStyle) && this.style == badgeStyle.style && this.alignment == badgeStyle.alignment;
    }

    public int hashCode() {
        return (((this.stackStyle.hashCode() * 31) + this.style.hashCode()) * 31) + this.alignment.hashCode();
    }

    public String toString() {
        return "BadgeStyle(stackStyle=" + this.stackStyle + ", style=" + this.style + ", alignment=" + this.alignment + ')';
    }

    public BadgeStyle(StackComponentStyle stackStyle, Badge.Style style, TwoDimensionalAlignment alignment) {
        Intrinsics.checkNotNullParameter(stackStyle, "stackStyle");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.stackStyle = stackStyle;
        this.style = style;
        this.alignment = alignment;
    }

    public final /* synthetic */ StackComponentStyle getStackStyle() {
        return this.stackStyle;
    }

    public final /* synthetic */ Badge.Style getStyle() {
        return this.style;
    }

    public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
        return this.alignment;
    }
}
