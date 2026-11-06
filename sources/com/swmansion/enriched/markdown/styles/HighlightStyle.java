package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class HighlightStyle {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final int color;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightStyle)) {
            return false;
        }
        HighlightStyle highlightStyle = (HighlightStyle) obj;
        return this.color == highlightStyle.color && this.backgroundColor == highlightStyle.backgroundColor;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Integer.hashCode(this.backgroundColor);
    }

    public String toString() {
        return "HighlightStyle(color=" + this.color + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public HighlightStyle(int i, int i2) {
        this.color = i;
        this.backgroundColor = i2;
    }

    public final int getColor() {
        return this.color;
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

        public final HighlightStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new HighlightStyle(parser.parseColor(map, "color"), parser.parseColor(map, "backgroundColor"));
        }
    }
}
