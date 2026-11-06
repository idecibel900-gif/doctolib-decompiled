package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeFitBottomStart extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitBottomStart();

    private ScalingUtils$ScaleTypeFitBottomStart() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMin = Math.min(f3, f4);
        float f5 = rect.left;
        float fHeight = rect.top + (rect.height() - (i2 * fMin));
        matrix.setScale(fMin, fMin);
        matrix.postTranslate((int) (f5 + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "fit_bottom_start";
    }
}
