package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EmphasisStyle {
    public static final Companion Companion = new Companion(null);
    private final Integer color;
    private final String fontFamily;
    private final String fontStyle;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmphasisStyle)) {
            return false;
        }
        EmphasisStyle emphasisStyle = (EmphasisStyle) obj;
        return Intrinsics.areEqual(this.fontFamily, emphasisStyle.fontFamily) && Intrinsics.areEqual(this.fontStyle, emphasisStyle.fontStyle) && Intrinsics.areEqual(this.color, emphasisStyle.color);
    }

    public int hashCode() {
        int iHashCode = ((this.fontFamily.hashCode() * 31) + this.fontStyle.hashCode()) * 31;
        Integer num = this.color;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "EmphasisStyle(fontFamily=" + this.fontFamily + ", fontStyle=" + this.fontStyle + ", color=" + this.color + ")";
    }

    public EmphasisStyle(String fontFamily, String fontStyle, Integer num) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
        this.fontFamily = fontFamily;
        this.fontStyle = fontStyle;
        this.color = num;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontStyle() {
        return this.fontStyle;
    }

    public final Integer getColor() {
        return this.color;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EmphasisStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new EmphasisStyle(StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), StyleParser.parseString$default(parser, map, "fontStyle", null, 4, null), parser.parseOptionalColor(map, "color"));
        }
    }
}
