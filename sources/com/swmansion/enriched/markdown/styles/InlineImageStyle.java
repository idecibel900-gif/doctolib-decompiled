package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InlineImageStyle {
    public static final Companion Companion = new Companion(null);
    private final float size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InlineImageStyle) && Float.compare(this.size, ((InlineImageStyle) obj).size) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.size);
    }

    public String toString() {
        return "InlineImageStyle(size=" + this.size + ")";
    }

    public InlineImageStyle(float f) {
        this.size = f;
    }

    public final float getSize() {
        return this.size;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InlineImageStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new InlineImageStyle(parser.toPixelFromDIP((float) map.getDouble("size")));
        }
    }
}
