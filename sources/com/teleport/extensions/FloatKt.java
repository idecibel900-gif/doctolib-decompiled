package com.teleport.extensions;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FloatKt {
    public static final double getDp(float f) {
        return f / getDisplayDensity();
    }

    private static final float getDisplayDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }
}
