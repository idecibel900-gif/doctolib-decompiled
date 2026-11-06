package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;

/* JADX INFO: loaded from: classes.dex */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    default float getHandwritingGestureLineMargin() {
        return 16.0f;
    }

    default float getHandwritingSlop() {
        return 2.0f;
    }

    long getLongPressTimeoutMillis();

    default float getMaximumFlingVelocity() {
        return Float.MAX_VALUE;
    }

    float getTouchSlop();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    default long mo1908getMinimumTouchTargetSizeMYxV2XQ() {
        float f = 48;
        return DpKt.m2562DpSizeYgX7TsA(Dp.m2551constructorimpl(f), Dp.m2551constructorimpl(f));
    }
}
