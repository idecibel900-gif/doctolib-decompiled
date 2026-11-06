package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public interface DrawTransform {
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo1581clipPathmtrdDE(Path path, int i);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo1582clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    void inset(float f, float f2, float f3, float f4);

    /* JADX INFO: renamed from: rotate-Uv8p0NA */
    void mo1584rotateUv8p0NA(float f, long j);

    /* JADX INFO: renamed from: scale-0AR0LA0 */
    void mo1585scale0AR0LA0(float f, float f2, long j);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo1586transform58bKbWc(float[] fArr);

    void translate(float f, float f2);

    /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1602clipPathmtrdDE$default(DrawTransform drawTransform, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1360getIntersectrtfAjoo();
        }
        drawTransform.mo1581clipPathmtrdDE(path, i);
    }

    static /* synthetic */ void translate$default(DrawTransform drawTransform, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawTransform.translate(f, f2);
    }
}
