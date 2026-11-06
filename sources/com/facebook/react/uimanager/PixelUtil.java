package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public final class PixelUtil {
    public static final PixelUtil INSTANCE = new PixelUtil();

    public static final float toPixelFromSP(float f) {
        return toPixelFromSP$default(f, 0.0f, 2, null);
    }

    private PixelUtil() {
    }

    public static final float toPixelFromDIP(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        return TypedValue.applyDimension(1, f, DisplayMetricsHolder.getScreenDisplayMetrics());
    }

    public static final float toPixelFromDIP(double d) {
        return toPixelFromDIP((float) d);
    }

    public static /* synthetic */ float toPixelFromSP$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = Float.NaN;
        }
        return toPixelFromSP(f, f2);
    }

    public static final float toPixelFromSP(float f, float f2) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        DisplayMetrics screenDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
        float fApplyDimension = TypedValue.applyDimension(2, f, screenDisplayMetrics);
        return f2 >= 1.0f ? Math.min(fApplyDimension, f * screenDisplayMetrics.density * f2) : fApplyDimension;
    }

    public static final float toPixelFromSP(double d) {
        return toPixelFromSP$default((float) d, 0.0f, 2, null);
    }

    public static final float toDIPFromPixel(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        return f / DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public static final float getDisplayMetricDensity() {
        return DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public final float dpToPx(int i) {
        return toPixelFromDIP(i);
    }

    public final float dpToPx(float f) {
        return toPixelFromDIP(f);
    }

    public final float dpToPx(double d) {
        return toPixelFromDIP((float) d);
    }

    public final float pxToDp(int i) {
        return toDIPFromPixel(i);
    }

    public final float pxToDp(float f) {
        return toDIPFromPixel(f);
    }
}
