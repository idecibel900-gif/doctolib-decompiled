package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeFocusCrop extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFocusCrop();

    private ScalingUtils$ScaleTypeFocusCrop() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMax;
        float fMax2;
        if (f4 > f3) {
            float f5 = i * f4;
            fMax = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f * f5), 0.0f), rect.width() - f5);
            fMax2 = rect.top;
            f3 = f4;
        } else {
            fMax = rect.left;
            float f6 = i2 * f3;
            fMax2 = Math.max(Math.min((rect.height() * 0.5f) - (f2 * f6), 0.0f), rect.height() - f6) + rect.top;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (fMax + 0.5f), (int) (fMax2 + 0.5f));
    }

    public String toString() {
        return "focus_crop";
    }
}
