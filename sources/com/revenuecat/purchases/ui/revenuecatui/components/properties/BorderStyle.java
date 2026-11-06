package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.unit.Dp;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyle;", "", "width", "Landroidx/compose/ui/unit/Dp;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "(FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "getWidth-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyle;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BorderStyle {
    public static final int $stable = 0;
    private final ColorStyle color;
    private final float width;

    public /* synthetic */ BorderStyle(float f, ColorStyle colorStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, colorStyle);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStyle m4111copyD5KLDUw$default(BorderStyle borderStyle, float f, ColorStyle colorStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            f = borderStyle.width;
        }
        if ((i & 2) != 0) {
            colorStyle = borderStyle.color;
        }
        return borderStyle.m4113copyD5KLDUw(f, colorStyle);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorStyle getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStyle m4113copyD5KLDUw(float width, ColorStyle color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new BorderStyle(width, color, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderStyle)) {
            return false;
        }
        BorderStyle borderStyle = (BorderStyle) other;
        return Dp.m2553equalsimpl0(this.width, borderStyle.width) && Intrinsics.areEqual(this.color, borderStyle.color);
    }

    public int hashCode() {
        return (Dp.m2554hashCodeimpl(this.width) * 31) + this.color.hashCode();
    }

    public String toString() {
        return "BorderStyle(width=" + ((Object) Dp.m2555toStringimpl(this.width)) + ", color=" + this.color + ')';
    }

    private BorderStyle(float f, ColorStyle color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.width = f;
        this.color = color;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m4114getWidthD9Ej5fM() {
        return this.width;
    }

    public final /* synthetic */ ColorStyle getColor() {
        return this.color;
    }
}
