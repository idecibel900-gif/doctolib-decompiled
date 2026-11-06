package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntRectKt {
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m2603IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m2591getXimpl(j), IntOffset.m2592getYimpl(j), IntOffset.m2591getXimpl(j) + IntSize.m2609getWidthimpl(j2), IntOffset.m2592getYimpl(j) + IntSize.m2608getHeightimpl(j2));
    }

    public static final IntRect roundToIntRect(Rect rect) {
        return new IntRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }
}
