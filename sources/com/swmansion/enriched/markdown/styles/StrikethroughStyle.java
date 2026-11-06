package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StrikethroughStyle {
    public static final Companion Companion = new Companion(null);
    private final int color;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StrikethroughStyle) && this.color == ((StrikethroughStyle) obj).color;
    }

    public int hashCode() {
        return Integer.hashCode(this.color);
    }

    public String toString() {
        return "StrikethroughStyle(color=" + this.color + ")";
    }

    public StrikethroughStyle(int i) {
        this.color = i;
    }

    public final int getColor() {
        return this.color;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StrikethroughStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new StrikethroughStyle(parser.parseColor(map, "color"));
        }
    }
}
