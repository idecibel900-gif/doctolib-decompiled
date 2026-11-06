package com.facebook.react.views.image;

import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageResizeMode {
    public static final ImageResizeMode INSTANCE = new ImageResizeMode();

    private ImageResizeMode() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final ScalingUtils$ScaleType toScaleType(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        ScalingUtils$ScaleType FIT_XY = ScalingUtils$ScaleType.FIT_XY;
                        Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
                        return FIT_XY;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        ScalingUtils$ScaleType CENTER_INSIDE = ScalingUtils$ScaleType.CENTER_INSIDE;
                        Intrinsics.checkNotNullExpressionValue(CENTER_INSIDE, "CENTER_INSIDE");
                        return CENTER_INSIDE;
                    }
                    break;
                case -934531685:
                    if (str.equals("repeat")) {
                        return ScaleTypeStartInside.Companion.getINSTANCE();
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        return ScaleTypeStartInside.Companion.getINSTANCE();
                    }
                    break;
                case 94852023:
                    if (str.equals("cover")) {
                        ScalingUtils$ScaleType CENTER_CROP = ScalingUtils$ScaleType.CENTER_CROP;
                        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
                        return CENTER_CROP;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        ScalingUtils$ScaleType FIT_CENTER = ScalingUtils$ScaleType.FIT_CENTER;
                        Intrinsics.checkNotNullExpressionValue(FIT_CENTER, "FIT_CENTER");
                        return FIT_CENTER;
                    }
                    break;
            }
        }
        if (str != null) {
            FLog.w("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return defaultValue();
    }

    public static final Shader.TileMode toTileMode(String str) {
        if (Intrinsics.areEqual("contain", str) || Intrinsics.areEqual("cover", str) || Intrinsics.areEqual("stretch", str) || Intrinsics.areEqual("center", str) || Intrinsics.areEqual("none", str)) {
            return Shader.TileMode.CLAMP;
        }
        if (Intrinsics.areEqual("repeat", str)) {
            return Shader.TileMode.REPEAT;
        }
        if (str != null) {
            FLog.w("ReactNative", "Invalid resize mode: '" + str + "'");
        }
        return defaultTileMode();
    }

    public static final ScalingUtils$ScaleType defaultValue() {
        ScalingUtils$ScaleType CENTER_CROP = ScalingUtils$ScaleType.CENTER_CROP;
        Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
        return CENTER_CROP;
    }

    public static final Shader.TileMode defaultTileMode() {
        return Shader.TileMode.CLAMP;
    }
}
