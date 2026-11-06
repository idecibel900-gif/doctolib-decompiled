package com.swmansion.enriched.markdown.styles;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ListStyle implements BaseBlockStyle {
    public static final Companion Companion = new Companion(null);
    private final int bulletColor;
    private final float bulletSize;
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;
    private final float gapWidth;
    private final float itemSpacing;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginLeft;
    private final float marginTop;
    private final int markerColor;
    private final String markerFontWeight;
    private final float markerMinWidth;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListStyle)) {
            return false;
        }
        ListStyle listStyle = (ListStyle) obj;
        return Float.compare(this.fontSize, listStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, listStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, listStyle.fontWeight) && this.color == listStyle.color && Float.compare(this.marginTop, listStyle.marginTop) == 0 && Float.compare(this.marginBottom, listStyle.marginBottom) == 0 && Float.compare(this.lineHeight, listStyle.lineHeight) == 0 && this.bulletColor == listStyle.bulletColor && Float.compare(this.bulletSize, listStyle.bulletSize) == 0 && Float.compare(this.markerMinWidth, listStyle.markerMinWidth) == 0 && this.markerColor == listStyle.markerColor && Intrinsics.areEqual(this.markerFontWeight, listStyle.markerFontWeight) && Float.compare(this.gapWidth, listStyle.gapWidth) == 0 && Float.compare(this.marginLeft, listStyle.marginLeft) == 0 && Float.compare(this.itemSpacing, listStyle.itemSpacing) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + Float.hashCode(this.lineHeight)) * 31) + Integer.hashCode(this.bulletColor)) * 31) + Float.hashCode(this.bulletSize)) * 31) + Float.hashCode(this.markerMinWidth)) * 31) + Integer.hashCode(this.markerColor)) * 31) + this.markerFontWeight.hashCode()) * 31) + Float.hashCode(this.gapWidth)) * 31) + Float.hashCode(this.marginLeft)) * 31) + Float.hashCode(this.itemSpacing);
    }

    public String toString() {
        return "ListStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", lineHeight=" + this.lineHeight + ", bulletColor=" + this.bulletColor + ", bulletSize=" + this.bulletSize + ", markerMinWidth=" + this.markerMinWidth + ", markerColor=" + this.markerColor + ", markerFontWeight=" + this.markerFontWeight + ", gapWidth=" + this.gapWidth + ", marginLeft=" + this.marginLeft + ", itemSpacing=" + this.itemSpacing + ")";
    }

    public ListStyle(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, int i2, float f5, float f6, int i3, String markerFontWeight, float f7, float f8, float f9) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(markerFontWeight, "markerFontWeight");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
        this.marginTop = f2;
        this.marginBottom = f3;
        this.lineHeight = f4;
        this.bulletColor = i2;
        this.bulletSize = f5;
        this.markerMinWidth = f6;
        this.markerColor = i3;
        this.markerFontWeight = markerFontWeight;
        this.gapWidth = f7;
        this.marginLeft = f8;
        this.itemSpacing = f9;
    }

    @Override // com.swmansion.enriched.markdown.styles.BaseBlockStyle
    public float getFontSize() {
        return this.fontSize;
    }

    @Override // com.swmansion.enriched.markdown.styles.BaseBlockStyle
    public String getFontFamily() {
        return this.fontFamily;
    }

    @Override // com.swmansion.enriched.markdown.styles.BaseBlockStyle
    public String getFontWeight() {
        return this.fontWeight;
    }

    @Override // com.swmansion.enriched.markdown.styles.BaseBlockStyle
    public int getColor() {
        return this.color;
    }

    public float getMarginTop() {
        return this.marginTop;
    }

    public float getMarginBottom() {
        return this.marginBottom;
    }

    public float getLineHeight() {
        return this.lineHeight;
    }

    public final int getBulletColor() {
        return this.bulletColor;
    }

    public final float getBulletSize() {
        return this.bulletSize;
    }

    public final int getMarkerColor() {
        return this.markerColor;
    }

    public final String getMarkerFontWeight() {
        return this.markerFontWeight;
    }

    public final float getGapWidth() {
        return this.gapWidth;
    }

    public final float getMarginLeft() {
        return this.marginLeft;
    }

    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    public final float effectiveMarkerWidth(float f) {
        return RangesKt.coerceAtLeast(f, this.markerMinWidth);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new ListStyle(parser.toPixelFromSP((float) map.getDouble("fontSize")), StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), parser.parseString(map, "fontWeight", Constants.NORMAL), parser.parseColor(map, "color"), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")), parser.toPixelFromSP((float) map.getDouble("lineHeight")), parser.parseColor(map, "bulletColor"), parser.toPixelFromSP((float) map.getDouble("bulletSize")), parser.toPixelFromDIP(RangesKt.coerceAtLeast((float) map.getDouble("markerMinWidth"), 0.0f)), parser.parseColor(map, "markerColor"), parser.parseString(map, "markerFontWeight", Constants.NORMAL), parser.toPixelFromDIP((float) map.getDouble("gapWidth")), parser.toPixelFromDIP((float) map.getDouble("marginLeft")), parser.toPixelFromDIP(RangesKt.coerceAtLeast((float) map.getDouble("itemSpacing"), 0.0f)));
        }
    }
}
