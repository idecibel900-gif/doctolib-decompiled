package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeFitXY extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitXY();

    private ScalingUtils$ScaleTypeFitXY() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = rect.left;
        float f6 = rect.top;
        matrix.setScale(f3, f4);
        matrix.postTranslate((int) (f5 + 0.5f), (int) (f6 + 0.5f));
    }

    public String toString() {
        return "fit_xy";
    }
}
