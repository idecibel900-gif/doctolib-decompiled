package com.reactnativekeyboardcontroller.extensions;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FloatKt {
    public static final double getDp(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    public static final double getPx(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }
}
