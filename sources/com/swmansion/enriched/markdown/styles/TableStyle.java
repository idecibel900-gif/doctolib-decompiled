package com.swmansion.enriched.markdown.styles;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TableStyle implements BaseBlockStyle {
    public static final Companion Companion = new Companion(null);
    private final String align;
    private final int borderColor;
    private final float borderRadius;
    private final float borderWidth;
    private final float cellPaddingHorizontal;
    private final float cellPaddingVertical;
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;
    private final int headerBackgroundColor;
    private final String headerFontFamily;
    private final int headerTextColor;
    private final float horizontalOverflow;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginTop;
    private final int rowEvenBackgroundColor;
    private final int rowOddBackgroundColor;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableStyle)) {
            return false;
        }
        TableStyle tableStyle = (TableStyle) obj;
        return Float.compare(this.fontSize, tableStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, tableStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, tableStyle.fontWeight) && this.color == tableStyle.color && Float.compare(this.marginTop, tableStyle.marginTop) == 0 && Float.compare(this.marginBottom, tableStyle.marginBottom) == 0 && Float.compare(this.lineHeight, tableStyle.lineHeight) == 0 && Intrinsics.areEqual(this.headerFontFamily, tableStyle.headerFontFamily) && this.headerBackgroundColor == tableStyle.headerBackgroundColor && this.headerTextColor == tableStyle.headerTextColor && this.rowEvenBackgroundColor == tableStyle.rowEvenBackgroundColor && this.rowOddBackgroundColor == tableStyle.rowOddBackgroundColor && this.borderColor == tableStyle.borderColor && Float.compare(this.borderWidth, tableStyle.borderWidth) == 0 && Float.compare(this.borderRadius, tableStyle.borderRadius) == 0 && Float.compare(this.cellPaddingHorizontal, tableStyle.cellPaddingHorizontal) == 0 && Float.compare(this.cellPaddingVertical, tableStyle.cellPaddingVertical) == 0 && Float.compare(this.horizontalOverflow, tableStyle.horizontalOverflow) == 0 && Intrinsics.areEqual(this.align, tableStyle.align);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + Float.hashCode(this.lineHeight)) * 31) + this.headerFontFamily.hashCode()) * 31) + Integer.hashCode(this.headerBackgroundColor)) * 31) + Integer.hashCode(this.headerTextColor)) * 31) + Integer.hashCode(this.rowEvenBackgroundColor)) * 31) + Integer.hashCode(this.rowOddBackgroundColor)) * 31) + Integer.hashCode(this.borderColor)) * 31) + Float.hashCode(this.borderWidth)) * 31) + Float.hashCode(this.borderRadius)) * 31) + Float.hashCode(this.cellPaddingHorizontal)) * 31) + Float.hashCode(this.cellPaddingVertical)) * 31) + Float.hashCode(this.horizontalOverflow)) * 31) + this.align.hashCode();
    }

    public String toString() {
        return "TableStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", lineHeight=" + this.lineHeight + ", headerFontFamily=" + this.headerFontFamily + ", headerBackgroundColor=" + this.headerBackgroundColor + ", headerTextColor=" + this.headerTextColor + ", rowEvenBackgroundColor=" + this.rowEvenBackgroundColor + ", rowOddBackgroundColor=" + this.rowOddBackgroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", borderRadius=" + this.borderRadius + ", cellPaddingHorizontal=" + this.cellPaddingHorizontal + ", cellPaddingVertical=" + this.cellPaddingVertical + ", horizontalOverflow=" + this.horizontalOverflow + ", align=" + this.align + ")";
    }

    public TableStyle(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, String headerFontFamily, int i2, int i3, int i4, int i5, int i6, float f5, float f6, float f7, float f8, float f9, String align) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(headerFontFamily, "headerFontFamily");
        Intrinsics.checkNotNullParameter(align, "align");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
        this.marginTop = f2;
        this.marginBottom = f3;
        this.lineHeight = f4;
        this.headerFontFamily = headerFontFamily;
        this.headerBackgroundColor = i2;
        this.headerTextColor = i3;
        this.rowEvenBackgroundColor = i4;
        this.rowOddBackgroundColor = i5;
        this.borderColor = i6;
        this.borderWidth = f5;
        this.borderRadius = f6;
        this.cellPaddingHorizontal = f7;
        this.cellPaddingVertical = f8;
        this.horizontalOverflow = f9;
        this.align = align;
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

    public final String getHeaderFontFamily() {
        return this.headerFontFamily;
    }

    public final int getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    public final int getHeaderTextColor() {
        return this.headerTextColor;
    }

    public final int getRowEvenBackgroundColor() {
        return this.rowEvenBackgroundColor;
    }

    public final int getRowOddBackgroundColor() {
        return this.rowOddBackgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    public final float getCellPaddingHorizontal() {
        return this.cellPaddingHorizontal;
    }

    public final float getCellPaddingVertical() {
        return this.cellPaddingVertical;
    }

    public final float getHorizontalOverflow() {
        return this.horizontalOverflow;
    }

    public final String getAlign() {
        return this.align;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TableStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            float pixelFromSP = parser.toPixelFromSP((float) map.getDouble("fontSize"));
            String string$default = StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null);
            String string = parser.parseString(map, "fontWeight", Constants.NORMAL);
            int color = parser.parseColor(map, "color");
            float pixelFromDIP = parser.toPixelFromDIP((float) map.getDouble("marginTop"));
            float pixelFromDIP2 = parser.toPixelFromDIP((float) map.getDouble("marginBottom"));
            float f = (float) map.getDouble("lineHeight");
            return new TableStyle(pixelFromSP, string$default, string, color, pixelFromDIP, pixelFromDIP2, f > 0.0f ? parser.toPixelFromSP(f) : 0.0f, StyleParser.parseString$default(parser, map, "headerFontFamily", null, 4, null), parser.parseColor(map, "headerBackgroundColor"), parser.parseColor(map, "headerTextColor"), parser.parseColor(map, "rowEvenBackgroundColor"), parser.parseColor(map, "rowOddBackgroundColor"), parser.parseColor(map, "borderColor"), parser.toPixelFromDIP((float) map.getDouble("borderWidth")), parser.toPixelFromDIP((float) map.getDouble("borderRadius")), parser.toPixelFromDIP((float) map.getDouble("cellPaddingHorizontal")), parser.toPixelFromDIP((float) map.getDouble("cellPaddingVertical")), parser.toPixelFromDIP((float) map.getDouble("horizontalOverflow")), StyleParser.parseString$default(parser, map, "align", null, 4, null));
        }
    }
}
