package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public final class YogaConstants {
    public static final YogaConstants INSTANCE = new YogaConstants();
    public static final float UNDEFINED = Float.NaN;

    private YogaConstants() {
    }

    public static final boolean isUndefined(float f) {
        return Float.compare(f, UNDEFINED) == 0;
    }
}
