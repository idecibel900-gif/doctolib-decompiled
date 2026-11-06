package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeFitY extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitY();

    private ScalingUtils$ScaleTypeFitY() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fWidth = rect.left + ((rect.width() - (i * f4)) * 0.5f);
        float f5 = rect.top;
        matrix.setScale(f4, f4);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (f5 + 0.5f));
    }

    public String toString() {
        return "fit_y";
    }
}
