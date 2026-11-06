package com.github.barteksc.pdfviewer.util;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MathUtils {
    public static int ceil(float f) {
        return ((int) (((double) f) + 16384.999999999996d)) - 16384;
    }

    public static int floor(float f) {
        return ((int) (((double) f) + 16384.0d)) - 16384;
    }

    public static float limit(float f, float f2, float f3) {
        if (f <= f2) {
            return f2;
        }
        return f >= f3 ? f3 : f;
    }

    public static float max(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static float min(float f, float f2) {
        return f < f2 ? f2 : f;
    }
}
