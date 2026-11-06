package androidx.compose.foundation.gestures.snapping;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapPositionKt {
    public static final float calculateDistanceToDesiredSnapPosition(int i, int i2, int i3, int i4, int i5, int i6, SnapPosition snapPosition, int i7) {
        return i5 - snapPosition.position(i, i4, i2, i3, i6, i7);
    }
}
