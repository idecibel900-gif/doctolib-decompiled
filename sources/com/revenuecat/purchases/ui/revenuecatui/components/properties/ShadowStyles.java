package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.unit.Dp;
import com.BV.LinearGradient.LinearGradientManager;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u0016\u0010\u0015\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\fJ;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "", LinearGradientManager.PROP_COLORS, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "radius", "Landroidx/compose/ui/unit/Dp;", "x", "y", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getRadius-D9Ej5fM", "()F", "F", "getX-D9Ej5fM", "getY-D9Ej5fM", "component1", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "copy", "copy-qQh39rQ", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;FFF)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ShadowStyles {
    public static final int $stable = 0;
    private final ColorStyles colors;
    private final float radius;
    private final float x;
    private final float y;

    public /* synthetic */ ShadowStyles(ColorStyles colorStyles, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyles, f, f2, f3);
    }

    /* JADX INFO: renamed from: copy-qQh39rQ$default, reason: not valid java name */
    public static /* synthetic */ ShadowStyles m4148copyqQh39rQ$default(ShadowStyles shadowStyles, ColorStyles colorStyles, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            colorStyles = shadowStyles.colors;
        }
        if ((i & 2) != 0) {
            f = shadowStyles.radius;
        }
        if ((i & 4) != 0) {
            f2 = shadowStyles.x;
        }
        if ((i & 8) != 0) {
            f3 = shadowStyles.y;
        }
        return shadowStyles.m4152copyqQh39rQ(colorStyles, f, f2, f3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: copy-qQh39rQ, reason: not valid java name */
    public final ShadowStyles m4152copyqQh39rQ(ColorStyles colors, float radius, float x, float y) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new ShadowStyles(colors, radius, x, y, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowStyles)) {
            return false;
        }
        ShadowStyles shadowStyles = (ShadowStyles) other;
        return Intrinsics.areEqual(this.colors, shadowStyles.colors) && Dp.m2553equalsimpl0(this.radius, shadowStyles.radius) && Dp.m2553equalsimpl0(this.x, shadowStyles.x) && Dp.m2553equalsimpl0(this.y, shadowStyles.y);
    }

    public int hashCode() {
        return (((((this.colors.hashCode() * 31) + Dp.m2554hashCodeimpl(this.radius)) * 31) + Dp.m2554hashCodeimpl(this.x)) * 31) + Dp.m2554hashCodeimpl(this.y);
    }

    public String toString() {
        return "ShadowStyles(colors=" + this.colors + ", radius=" + ((Object) Dp.m2555toStringimpl(this.radius)) + ", x=" + ((Object) Dp.m2555toStringimpl(this.x)) + ", y=" + ((Object) Dp.m2555toStringimpl(this.y)) + ')';
    }

    private ShadowStyles(ColorStyles colors, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.radius = f;
        this.x = f2;
        this.y = f3;
    }

    public final /* synthetic */ ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: getRadius-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m4153getRadiusD9Ej5fM() {
        return this.radius;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m4154getXD9Ej5fM() {
        return this.x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m4155getYD9Ej5fM() {
        return this.y;
    }
}
