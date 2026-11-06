package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkVariantEntry {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final int color;
    private final String pattern;
    private final boolean underline;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkVariantEntry)) {
            return false;
        }
        LinkVariantEntry linkVariantEntry = (LinkVariantEntry) obj;
        return Intrinsics.areEqual(this.pattern, linkVariantEntry.pattern) && this.color == linkVariantEntry.color && this.underline == linkVariantEntry.underline && this.backgroundColor == linkVariantEntry.backgroundColor;
    }

    public int hashCode() {
        return (((((this.pattern.hashCode() * 31) + Integer.hashCode(this.color)) * 31) + Boolean.hashCode(this.underline)) * 31) + Integer.hashCode(this.backgroundColor);
    }

    public String toString() {
        return "LinkVariantEntry(pattern=" + this.pattern + ", color=" + this.color + ", underline=" + this.underline + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public LinkVariantEntry(String pattern, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        this.color = i;
        this.underline = z;
        this.backgroundColor = i2;
    }

    public final String getPattern() {
        return this.pattern;
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

        public final LinkVariantEntry fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            String string = map.getString("pattern");
            if (string == null) {
                string = "";
            }
            return new LinkVariantEntry(string, parser.parseColor(map, "color"), StyleParser.parseBoolean$default(parser, map, "underline", false, 4, null), parser.parseColor(map, "backgroundColor"));
        }
    }
}
