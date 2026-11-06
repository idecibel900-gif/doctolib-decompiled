package com.swmansion.enriched.markdown.styles;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ParagraphStyle implements BaseBlockStyle {
    public static final Companion Companion = new Companion(null);
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginTop;
    private final TextAlignment textAlign;

    public static /* synthetic */ ParagraphStyle copy$default(ParagraphStyle paragraphStyle, float f, String str, String str2, int i, float f2, float f3, float f4, TextAlignment textAlignment, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = paragraphStyle.fontSize;
        }
        if ((i2 & 2) != 0) {
            str = paragraphStyle.fontFamily;
        }
        if ((i2 & 4) != 0) {
            str2 = paragraphStyle.fontWeight;
        }
        if ((i2 & 8) != 0) {
            i = paragraphStyle.color;
        }
        if ((i2 & 16) != 0) {
            f2 = paragraphStyle.marginTop;
        }
        if ((i2 & 32) != 0) {
            f3 = paragraphStyle.marginBottom;
        }
        if ((i2 & 64) != 0) {
            f4 = paragraphStyle.lineHeight;
        }
        if ((i2 & 128) != 0) {
            textAlignment = paragraphStyle.textAlign;
        }
        float f5 = f4;
        TextAlignment textAlignment2 = textAlignment;
        float f6 = f2;
        float f7 = f3;
        return paragraphStyle.copy(f, str, str2, i, f6, f7, f5, textAlignment2);
    }

    public final ParagraphStyle copy(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, TextAlignment textAlign) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        return new ParagraphStyle(f, fontFamily, fontWeight, i, f2, f3, f4, textAlign);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return Float.compare(this.fontSize, paragraphStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, paragraphStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, paragraphStyle.fontWeight) && this.color == paragraphStyle.color && Float.compare(this.marginTop, paragraphStyle.marginTop) == 0 && Float.compare(this.marginBottom, paragraphStyle.marginBottom) == 0 && Float.compare(this.lineHeight, paragraphStyle.lineHeight) == 0 && this.textAlign == paragraphStyle.textAlign;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + Float.hashCode(this.lineHeight)) * 31) + this.textAlign.hashCode();
    }

    public String toString() {
        return "ParagraphStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", lineHeight=" + this.lineHeight + ", textAlign=" + this.textAlign + ")";
    }

    public ParagraphStyle(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, TextAlignment textAlign) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
        this.marginTop = f2;
        this.marginBottom = f3;
        this.lineHeight = f4;
        this.textAlign = textAlign;
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

    public final TextAlignment getTextAlign() {
        return this.textAlign;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ParagraphStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new ParagraphStyle(parser.toPixelFromSP((float) map.getDouble("fontSize")), StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), parser.parseString(map, "fontWeight", Constants.NORMAL), parser.parseColor(map, "color"), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")), parser.toPixelFromSP((float) map.getDouble("lineHeight")), parser.parseTextAlign(map, "textAlign"));
        }
    }
}
