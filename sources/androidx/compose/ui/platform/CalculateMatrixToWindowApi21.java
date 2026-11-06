package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo2046calculateMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Matrix.m1441resetimpl(fArr);
        m2049transformMatrixToWindowEL8BTi8(view, fArr);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m2049transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m2049transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m2048preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m2048preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            m2048preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m2048preTranslate3XD1CNM(fArr, iArr[0], iArr[1]);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        m2047preConcattUYjHk(fArr, matrix);
    }

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m2047preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m1285setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m2042preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m2048preTranslate3XD1CNM(float[] fArr, float f, float f2) {
        AndroidComposeView_androidKt.m2043preTranslatecG2Xzmc(fArr, f, f2, this.tmpMatrix);
    }
}
