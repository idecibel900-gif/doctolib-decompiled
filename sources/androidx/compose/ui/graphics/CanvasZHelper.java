package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
final class CanvasZHelper {
    public static final CanvasZHelper INSTANCE = new CanvasZHelper();

    private CanvasZHelper() {
    }

    public final void enableZ(android.graphics.Canvas canvas, boolean z) {
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
