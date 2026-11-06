package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeFitEnd extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitEnd();

    private ScalingUtils$ScaleTypeFitEnd() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fMin = Math.min(f3, f4);
        float fWidth = rect.left + (rect.width() - (i * fMin));
        float fHeight = rect.top + (rect.height() - (i2 * fMin));
        matrix.setScale(fMin, fMin);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "fit_end";
    }
}
