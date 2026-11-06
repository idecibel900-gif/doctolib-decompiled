package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LayerMatrixCache {
    private Matrix androidMatrixCache;
    private final Function2 getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty = true;
    private boolean isInverseDirty = true;
    private boolean isInverseValid = true;
    private float[] matrixCache;
    private Matrix previousAndroidMatrix;

    public LayerMatrixCache(Function2 function2) {
        this.getMatrix = function2;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    /* JADX INFO: renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m2070calculateMatrixGrdbGEg(Object obj) {
        float[] fArrM1436constructorimpl$default = this.matrixCache;
        if (fArrM1436constructorimpl$default == null) {
            fArrM1436constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1436constructorimpl$default(null, 1, null);
            this.matrixCache = fArrM1436constructorimpl$default;
        }
        if (!this.isDirty) {
            return fArrM1436constructorimpl$default;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.invoke(obj, matrix);
        Matrix matrix2 = this.previousAndroidMatrix;
        if (matrix2 == null || !Intrinsics.areEqual(matrix, matrix2)) {
            AndroidMatrixConversions_androidKt.m1285setFromtUYjHk(fArrM1436constructorimpl$default, matrix);
            this.androidMatrixCache = matrix2;
            this.previousAndroidMatrix = matrix;
        }
        this.isDirty = false;
        return fArrM1436constructorimpl$default;
    }

    /* JADX INFO: renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m2069calculateInverseMatrixbWbORWo(Object obj) {
        float[] fArrM1436constructorimpl$default = this.inverseMatrixCache;
        if (fArrM1436constructorimpl$default == null) {
            fArrM1436constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1436constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM1436constructorimpl$default;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m2068invertToJiSxe2E(m2070calculateMatrixGrdbGEg(obj), fArrM1436constructorimpl$default);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArrM1436constructorimpl$default;
        }
        return null;
    }
}
