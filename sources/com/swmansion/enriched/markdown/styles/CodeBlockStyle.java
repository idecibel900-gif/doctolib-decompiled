package com.swmansion.enriched.markdown.styles;

import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeBlockStyle implements BaseBlockStyle {
    public static final Companion Companion = new Companion(null);
    private static final List SYNTAX_COLOR_KEYS = CollectionsKt.listOf((Object[]) new String[]{"keyword", "operatorColor", "punctuation", "string", "number", "constant", "comment", "function", "type", "variable", "property", "tag", "attribute", "embedded"});
    private final int backgroundColor;
    private final int borderColor;
    private final float borderRadius;
    private final float borderWidth;
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;
    private final float lineHeight;
    private final float marginBottom;
    private final float marginTop;
    private final float padding;
    private final List syntaxColors;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeBlockStyle)) {
            return false;
        }
        CodeBlockStyle codeBlockStyle = (CodeBlockStyle) obj;
        return Float.compare(this.fontSize, codeBlockStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, codeBlockStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, codeBlockStyle.fontWeight) && this.color == codeBlockStyle.color && Float.compare(this.marginTop, codeBlockStyle.marginTop) == 0 && Float.compare(this.marginBottom, codeBlockStyle.marginBottom) == 0 && Float.compare(this.lineHeight, codeBlockStyle.lineHeight) == 0 && this.backgroundColor == codeBlockStyle.backgroundColor && this.borderColor == codeBlockStyle.borderColor && Float.compare(this.borderRadius, codeBlockStyle.borderRadius) == 0 && Float.compare(this.borderWidth, codeBlockStyle.borderWidth) == 0 && Float.compare(this.padding, codeBlockStyle.padding) == 0 && Intrinsics.areEqual(this.syntaxColors, codeBlockStyle.syntaxColors);
    }

    public int hashCode() {
        return (((((((((((((((((((((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + Float.hashCode(this.lineHeight)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.borderColor)) * 31) + Float.hashCode(this.borderRadius)) * 31) + Float.hashCode(this.borderWidth)) * 31) + Float.hashCode(this.padding)) * 31) + this.syntaxColors.hashCode();
    }

    public String toString() {
        return "CodeBlockStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", lineHeight=" + this.lineHeight + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ", padding=" + this.padding + ", syntaxColors=" + this.syntaxColors + ")";
    }

    public CodeBlockStyle(float f, String fontFamily, String fontWeight, int i, float f2, float f3, float f4, int i2, int i3, float f5, float f6, float f7, List syntaxColors) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(syntaxColors, "syntaxColors");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
        this.marginTop = f2;
        this.marginBottom = f3;
        this.lineHeight = f4;
        this.backgroundColor = i2;
        this.borderColor = i3;
        this.borderRadius = f5;
        this.borderWidth = f6;
        this.padding = f7;
        this.syntaxColors = syntaxColors;
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

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final float getPadding() {
        return this.padding;
    }

    public final List getSyntaxColors() {
        return this.syntaxColors;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeBlockStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Integer optionalColor;
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            float pixelFromSP = parser.toPixelFromSP((float) map.getDouble("fontSize"));
            String string$default = StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null);
            String string = parser.parseString(map, "fontWeight", Constants.NORMAL);
            int color = parser.parseColor(map, "color");
            float pixelFromDIP = parser.toPixelFromDIP((float) map.getDouble("marginTop"));
            float pixelFromDIP2 = parser.toPixelFromDIP((float) map.getDouble("marginBottom"));
            float pixelFromSP2 = parser.toPixelFromSP((float) map.getDouble("lineHeight"));
            int color2 = parser.parseColor(map, "backgroundColor");
            int color3 = parser.parseColor(map, "borderColor");
            float pixelFromDIP3 = parser.toPixelFromDIP((float) map.getDouble("borderRadius"));
            float pixelFromDIP4 = parser.toPixelFromDIP((float) map.getDouble("borderWidth"));
            float pixelFromDIP5 = parser.toPixelFromDIP((float) map.getDouble("padding"));
            ReadableMap map2 = map.getMap("syntaxColors");
            List list = CodeBlockStyle.SYNTAX_COLOR_KEYS;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf((map2 == null || (optionalColor = parser.parseOptionalColor(map2, (String) it.next())) == null) ? color : optionalColor.intValue()));
            }
            return new CodeBlockStyle(pixelFromSP, string$default, string, color, pixelFromDIP, pixelFromDIP2, pixelFromSP2, color2, color3, pixelFromDIP3, pixelFromDIP4, pixelFromDIP5, arrayList);
        }
    }
}
