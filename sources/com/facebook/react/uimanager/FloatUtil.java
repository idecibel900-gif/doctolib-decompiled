package com.facebook.react.uimanager;

/* JADX INFO: loaded from: classes3.dex */
public final class FloatUtil {
    public static final FloatUtil INSTANCE = new FloatUtil();

    private FloatUtil() {
    }

    public static final boolean floatsEqual(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return Float.isNaN(f) && Float.isNaN(f2);
        }
        return Math.abs(f2 - f) < 1.0E-5f;
    }

    public static final boolean floatsEqual(Float f, Float f2) {
        if (f == null) {
            return f2 == null;
        }
        if (f2 == null) {
            return false;
        }
        return floatsEqual(f.floatValue(), f2.floatValue());
    }
}
