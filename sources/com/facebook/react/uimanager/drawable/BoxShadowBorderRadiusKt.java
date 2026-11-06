package com.facebook.react.uimanager.drawable;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BoxShadowBorderRadiusKt {
    public static final float adjustRadiusForSpread(float f, float f2) {
        float fPow;
        if (f < Math.abs(f2)) {
            float f3 = 1;
            fPow = f3 + ((float) Math.pow((f / Math.abs(f2)) - f3, 3));
        } else {
            fPow = 1.0f;
        }
        return RangesKt.coerceAtLeast(f + (f2 * fPow), 0.0f);
    }
}
