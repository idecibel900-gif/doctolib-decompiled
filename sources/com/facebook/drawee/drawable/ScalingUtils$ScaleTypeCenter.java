package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class ScalingUtils$ScaleTypeCenter extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeCenter();

    private ScalingUtils$ScaleTypeCenter() {
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
    }

    public String toString() {
        return "center";
    }
}
