package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThematicBreakStyle {
    public static final Companion Companion = new Companion(null);
    private final int color;
    private final float height;
    private final float marginBottom;
    private final float marginTop;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThematicBreakStyle)) {
            return false;
        }
        ThematicBreakStyle thematicBreakStyle = (ThematicBreakStyle) obj;
        return this.color == thematicBreakStyle.color && Float.compare(this.height, thematicBreakStyle.height) == 0 && Float.compare(this.marginTop, thematicBreakStyle.marginTop) == 0 && Float.compare(this.marginBottom, thematicBreakStyle.marginBottom) == 0;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.color) * 31) + Float.hashCode(this.height)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom);
    }

    public String toString() {
        return "ThematicBreakStyle(color=" + this.color + ", height=" + this.height + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    }

    public ThematicBreakStyle(int i, float f, float f2, float f3) {
        this.color = i;
        this.height = f;
        this.marginTop = f2;
        this.marginBottom = f3;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getMarginTop() {
        return this.marginTop;
    }

    public final float getMarginBottom() {
        return this.marginBottom;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThematicBreakStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new ThematicBreakStyle(parser.parseColor(map, "color"), parser.toPixelFromDIP((float) map.getDouble("height")), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")));
        }
    }
}
