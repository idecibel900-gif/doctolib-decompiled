package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeStyle {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final int borderColor;
    private final int color;
    private final String fontFamily;
    private final float fontSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeStyle)) {
            return false;
        }
        CodeStyle codeStyle = (CodeStyle) obj;
        return Intrinsics.areEqual(this.fontFamily, codeStyle.fontFamily) && Float.compare(this.fontSize, codeStyle.fontSize) == 0 && this.color == codeStyle.color && this.backgroundColor == codeStyle.backgroundColor && this.borderColor == codeStyle.borderColor;
    }

    public int hashCode() {
        return (((((((this.fontFamily.hashCode() * 31) + Float.hashCode(this.fontSize)) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.borderColor);
    }

    public String toString() {
        return "CodeStyle(fontFamily=" + this.fontFamily + ", fontSize=" + this.fontSize + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ")";
    }

    public CodeStyle(String fontFamily, float f, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
        this.fontSize = f;
        this.color = i;
        this.backgroundColor = i2;
        this.borderColor = i3;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            String string$default = StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null);
            float optionalDouble$default = (float) StyleParser.parseOptionalDouble$default(parser, map, "fontSize", 0.0d, 4, null);
            return new CodeStyle(string$default, optionalDouble$default > 0.0f ? parser.toPixelFromSP(optionalDouble$default) : 0.0f, parser.parseColor(map, "color"), parser.parseColor(map, "backgroundColor"), parser.parseColor(map, "borderColor"));
        }
    }
}
