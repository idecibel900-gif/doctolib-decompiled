package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: loaded from: classes.dex */
public interface Canvas {
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo1272clipPathmtrdDE(Path path, int i);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo1273clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo1274concat58bKbWc(float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo1275drawCircle9KIMszo(long j, float f, Paint paint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo1276drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo1277drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo1278drawLineWko1d7g(long j, long j2, Paint paint);

    void drawPath(Path path, Paint paint);

    void drawRect(float f, float f2, float f3, float f4, Paint paint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(Rect rect, Paint paint);

    void scale(float f, float f2);

    void translate(float f, float f2);

    /* JADX INFO: renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1355clipRectmtrdDE$default(Canvas canvas, Rect rect, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1360getIntersectrtfAjoo();
        }
        canvas.m1356clipRectmtrdDE(rect, i);
    }

    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m1356clipRectmtrdDE(Rect rect, int i) {
        mo1273clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i);
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m1354clipRectN_I0leg$default(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m1360getIntersectrtfAjoo();
        }
        canvas.mo1273clipRectN_I0leg(f, f2, f3, f4, i);
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m1353clipPathmtrdDE$default(Canvas canvas, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m1360getIntersectrtfAjoo();
        }
        canvas.mo1272clipPathmtrdDE(path, i);
    }

    default void drawRect(Rect rect, Paint paint) {
        drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }
}
