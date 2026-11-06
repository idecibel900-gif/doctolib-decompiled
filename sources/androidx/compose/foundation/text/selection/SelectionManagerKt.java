package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionManagerKt {
    private static final Rect invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect rectBoundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m1246Rect0a9Yr6o(layoutCoordinates.mo1853windowToLocalMKHz9U(rectBoundsInWindow.m1244getTopLeftF1C5BW0()), layoutCoordinates.mo1853windowToLocalMKHz9U(rectBoundsInWindow.m1241getBottomRightF1C5BW0()));
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m639containsInclusiveUv8p0NA(Rect rect, long j) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float fM1223getXimpl = Offset.m1223getXimpl(j);
        if (left > fM1223getXimpl || fM1223getXimpl > right) {
            return false;
        }
        float top = rect.getTop();
        float bottom = rect.getBottom();
        float fM1224getYimpl = Offset.m1224getYimpl(j);
        return top <= fM1224getYimpl && fM1224getYimpl <= bottom;
    }
}
