package androidx.compose.foundation.gestures.snapping;

/* JADX INFO: loaded from: classes.dex */
public interface SnapPosition {
    int position(int i, int i2, int i3, int i4, int i5, int i6);

    public static final class Start implements SnapPosition {
        public static final Start INSTANCE = new Start();

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public int position(int i, int i2, int i3, int i4, int i5, int i6) {
            return 0;
        }

        private Start() {
        }

        public String toString() {
            return "Start";
        }
    }
}
