package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeCenterCrop extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeCenterCrop();

    private ScalingUtils$ScaleTypeCenterCrop() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float fHeight;
        float fWidth;
        if (f4 > f3) {
            fWidth = rect.left + ((rect.width() - (i * f4)) * 0.5f);
            fHeight = rect.top;
            f3 = f4;
        } else {
            float f5 = rect.left;
            fHeight = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
            fWidth = f5;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((int) (fWidth + 0.5f), (int) (fHeight + 0.5f));
    }

    public String toString() {
        return "center_crop";
    }
}
