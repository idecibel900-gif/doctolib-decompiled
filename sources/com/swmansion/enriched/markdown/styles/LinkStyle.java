package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkStyle {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final int color;
    private final String fontFamily;
    private final boolean underline;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkStyle)) {
            return false;
        }
        LinkStyle linkStyle = (LinkStyle) obj;
        return Intrinsics.areEqual(this.fontFamily, linkStyle.fontFamily) && this.color == linkStyle.color && this.underline == linkStyle.underline && this.backgroundColor == linkStyle.backgroundColor;
    }

    public int hashCode() {
        return (((((this.fontFamily.hashCode() * 31) + Integer.hashCode(this.color)) * 31) + Boolean.hashCode(this.underline)) * 31) + Integer.hashCode(this.backgroundColor);
    }

    public String toString() {
        return "LinkStyle(fontFamily=" + this.fontFamily + ", color=" + this.color + ", underline=" + this.underline + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public LinkStyle(String fontFamily, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
        this.color = i;
        this.underline = z;
        this.backgroundColor = i2;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getUnderline() {
        return this.underline;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinkStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new LinkStyle(StyleParser.parseString$default(parser, map, "fontFamily", null, 4, null), parser.parseColor(map, "color"), map.getBoolean("underline"), parser.parseColor(map, "backgroundColor"));
        }
    }
}
