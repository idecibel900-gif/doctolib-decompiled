package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageStyle {
    public static final Companion Companion = new Companion(null);
    private final float aspectRatio;
    private final float borderRadius;
    private final float height;
    private final float marginBottom;
    private final float marginTop;
    private final float maxHeight;
    private final String resizeMode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageStyle)) {
            return false;
        }
        ImageStyle imageStyle = (ImageStyle) obj;
        return Float.compare(this.height, imageStyle.height) == 0 && Float.compare(this.maxHeight, imageStyle.maxHeight) == 0 && Float.compare(this.aspectRatio, imageStyle.aspectRatio) == 0 && Intrinsics.areEqual(this.resizeMode, imageStyle.resizeMode) && Float.compare(this.borderRadius, imageStyle.borderRadius) == 0 && Float.compare(this.marginTop, imageStyle.marginTop) == 0 && Float.compare(this.marginBottom, imageStyle.marginBottom) == 0;
    }

    public int hashCode() {
        return (((((((((((Float.hashCode(this.height) * 31) + Float.hashCode(this.maxHeight)) * 31) + Float.hashCode(this.aspectRatio)) * 31) + this.resizeMode.hashCode()) * 31) + Float.hashCode(this.borderRadius)) * 31) + Float.hashCode(this.marginTop)) * 31) + Float.hashCode(this.marginBottom);
    }

    public String toString() {
        return "ImageStyle(height=" + this.height + ", maxHeight=" + this.maxHeight + ", aspectRatio=" + this.aspectRatio + ", resizeMode=" + this.resizeMode + ", borderRadius=" + this.borderRadius + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    }

    public ImageStyle(float f, float f2, float f3, String resizeMode, float f4, float f5, float f6) {
        Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
        this.height = f;
        this.maxHeight = f2;
        this.aspectRatio = f3;
        this.resizeMode = resizeMode;
        this.borderRadius = f4;
        this.marginTop = f5;
        this.marginBottom = f6;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getMaxHeight() {
        return this.maxHeight;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getResizeMode() {
        return this.resizeMode;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
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

        public final ImageStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            float pixelFromDIP = parser.toPixelFromDIP((float) map.getDouble("height"));
            float pixelFromDIP2 = parser.toPixelFromDIP((float) map.getDouble("maxHeight"));
            float f = (float) map.getDouble("aspectRatio");
            String string = map.getString("resizeMode");
            if (string == null) {
                string = "";
            }
            return new ImageStyle(pixelFromDIP, pixelFromDIP2, f, string, parser.toPixelFromDIP((float) map.getDouble("borderRadius")), parser.toPixelFromDIP((float) map.getDouble("marginTop")), parser.toPixelFromDIP((float) map.getDouble("marginBottom")));
        }
    }
}
