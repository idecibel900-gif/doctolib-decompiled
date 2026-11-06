package com.swmansion.enriched.markdown.styles;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockquoteStyle implements BaseBlockStyle {
    public static final Companion Companion = new Companion(null);
    private final Integer backgroundColor;
    private final int borderColor;
    private final float borderRadius;
    private final float borderWidth;
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;
    private final float gapWidth;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginTop;
    private final float padding;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockquoteStyle)) {
            return false;
        }
        BlockquoteStyle blockquoteStyle = (BlockquoteStyle) obj;
        return Float.compare(this.fontSize, blockquoteStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, blockquoteStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, blockquoteStyle.fontWeight) && this.color == blockquoteStyle.color && Float.compare(this.marginTop, blockquoteStyle.marginTop) == 0 && Float.compare(this.marginBottom, blockquoteStyle.marginBottom) == 0 && Float.compare(this.lineHeight, blockquoteStyle.lineHeight) == 0 && this.borderColor == blockquoteStyle.borderColor && Float.compare(this.borderWidth, blockquoteStyle.borderWidth) == 0 && Float.compare(this.gapWidth, blockquoteStyle.gapWidth) == 0 && Intrinsics.areEqual(this.backgroundColor, blockquoteStyle.backgroundColor) && Float.compare(this.borderRadius, blockquoteStyle.borderRadius) == 0 && Float.compare(this.padding, blockquoteStyle.padding) == 0;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + Float.hashCode(this.lineHeight)) * 31) + Integer.hashCode(this.borderColor)) * 31) + Float.hashCode(this.borderWidth)) * 31) + Float.hashCode(this.gapWidth)) * 31;
        Integer num = this.backgroundColor;
        return ((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Float.hashCode(this.borderRadius)) * 31) + Float.hashCode(this.padding);
    }

    public String toString() {
        return "BlockquoteStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", lineHeight=" + this.lineHeight + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", gapWidth=" + this.gapWidth + ", backgroundColor=" + this.backgroundColor + ", borderRadius=" + this.borderRadius + ", padding=" + this.padding + ")";
    }

    public BlockquoteStyle(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, int i2, float f5, float f6, Integer num, float f7, float f8) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
        this.marginTop = f2;
        this.marginBottom = f3;
        this.lineHeight = f4;
        this.borderColor = i2;
        this.borderWidth = f5;
        this.gapWidth = f6;
        this.backgroundColor = num;
        this.borderRadius = f7;
        this.padding = f8;
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

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final float getGapWidth() {
        return this.gapWidth;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    public final float getPadding() {
        return this.padding;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlockquoteStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new BlockquoteStyle(parser.toPixelFromSP((float) map.getDouble("fontSize")), StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), parser.parseString(map, "fontWeight", Constants.NORMAL), parser.parseColor(map, "color"), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")), parser.toPixelFromSP((float) map.getDouble("lineHeight")), parser.parseColor(map, "borderColor"), parser.toPixelFromDIP((float) map.getDouble("borderWidth")), parser.toPixelFromDIP((float) map.getDouble("gapWidth")), parser.parseOptionalColor(map, "backgroundColor"), parser.toPixelFromDIP((float) map.getDouble("borderRadius")), parser.toPixelFromDIP((float) map.getDouble("padding")));
        }
    }
}
