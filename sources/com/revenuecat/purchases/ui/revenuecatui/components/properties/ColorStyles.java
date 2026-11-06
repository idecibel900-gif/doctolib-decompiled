package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "", "light", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "dark", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)V", "getDark", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "getLight", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ColorStyles {
    public static final int $stable = 0;
    private final ColorStyle dark;
    private final ColorStyle light;

    public static /* synthetic */ ColorStyles copy$default(ColorStyles colorStyles, ColorStyle colorStyle, ColorStyle colorStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            colorStyle = colorStyles.light;
        }
        if ((i & 2) != 0) {
            colorStyle2 = colorStyles.dark;
        }
        return colorStyles.copy(colorStyle, colorStyle2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorStyle getLight() {
        return this.light;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorStyle getDark() {
        return this.dark;
    }

    public final ColorStyles copy(ColorStyle light, ColorStyle dark) {
        Intrinsics.checkNotNullParameter(light, "light");
        return new ColorStyles(light, dark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorStyles)) {
            return false;
        }
        ColorStyles colorStyles = (ColorStyles) other;
        return Intrinsics.areEqual(this.light, colorStyles.light) && Intrinsics.areEqual(this.dark, colorStyles.dark);
    }

    public int hashCode() {
        int iHashCode = this.light.hashCode() * 31;
        ColorStyle colorStyle = this.dark;
        return iHashCode + (colorStyle == null ? 0 : colorStyle.hashCode());
    }

    public String toString() {
        return "ColorStyles(light=" + this.light + ", dark=" + this.dark + ')';
    }

    public ColorStyles(ColorStyle light, ColorStyle colorStyle) {
        Intrinsics.checkNotNullParameter(light, "light");
        this.light = light;
        this.dark = colorStyle;
    }

    public /* synthetic */ ColorStyles(ColorStyle colorStyle, ColorStyle colorStyle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyle, (i & 2) != 0 ? null : colorStyle2);
    }

    public final /* synthetic */ ColorStyle getLight() {
        return this.light;
    }

    public final /* synthetic */ ColorStyle getDark() {
        return this.dark;
    }
}
