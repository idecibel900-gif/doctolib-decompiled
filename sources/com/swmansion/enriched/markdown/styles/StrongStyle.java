package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StrongStyle {
    public static final Companion Companion = new Companion(null);
    private final Integer color;
    private final String fontFamily;
    private final String fontWeight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrongStyle)) {
            return false;
        }
        StrongStyle strongStyle = (StrongStyle) obj;
        return Intrinsics.areEqual(this.fontFamily, strongStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, strongStyle.fontWeight) && Intrinsics.areEqual(this.color, strongStyle.color);
    }

    public int hashCode() {
        int iHashCode = ((this.fontFamily.hashCode() * 31) + this.fontWeight.hashCode()) * 31;
        Integer num = this.color;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "StrongStyle(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ")";
    }

    public StrongStyle(String fontFamily, String fontWeight, Integer num) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = num;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontWeight() {
        return this.fontWeight;
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

        public final StrongStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new StrongStyle(StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), StyleParser.parseString$default(parser, map, "fontWeight", null, 4, null), parser.parseOptionalColor(map, "color"));
        }
    }
}
