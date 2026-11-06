package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MathStyle {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final int color;
    private final float fontSize;
    private final float marginBottom;
    private final float marginTop;
    private final float padding;
    private final String textAlign;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MathStyle)) {
            return false;
        }
        MathStyle mathStyle = (MathStyle) obj;
        return Float.compare(this.fontSize, mathStyle.fontSize) == 0 && this.color == mathStyle.color && this.backgroundColor == mathStyle.backgroundColor && Float.compare(this.padding, mathStyle.padding) == 0 && Float.compare(this.marginTop, mathStyle.marginTop) == 0 && Float.compare(this.marginBottom, mathStyle.marginBottom) == 0 && Intrinsics.areEqual(this.textAlign, mathStyle.textAlign);
    }

    public int hashCode() {
        return (((((((((((Float.hashCode(this.fontSize) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Float.hashCode(this.padding)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom)) * 31) + this.textAlign.hashCode();
    }

    public String toString() {
        return "MathStyle(fontSize=" + this.fontSize + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", padding=" + this.padding + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", textAlign=" + this.textAlign + ")";
    }

    public MathStyle(float f, int i, int i2, float f2, float f3, float f4, String textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        this.fontSize = f;
        this.color = i;
        this.backgroundColor = i2;
        this.padding = f2;
        this.marginTop = f3;
        this.marginBottom = f4;
        this.textAlign = textAlign;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final float getPadding() {
        return this.padding;
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

        public final MathStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            return new MathStyle(parser.toPixelFromSP((float) map.getDouble("fontSize")), parser.parseColor(map, "color"), parser.parseColor(map, "backgroundColor"), parser.toPixelFromDIP((float) map.getDouble("padding")), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")), parser.parseString(map, "textAlign", "center"));
        }
    }
}
