package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionHandlesKt {
    private static final float HandleHeight;
    private static final float HandleWidth;
    private static final SemanticsPropertyKey SelectionHandleInfoKey = new SemanticsPropertyKey("SelectionHandleInfo", null, 2, null);

    public static final float getHandleWidth() {
        return HandleWidth;
    }

    public static final float getHandleHeight() {
        return HandleHeight;
    }

    public static final SemanticsPropertyKey getSelectionHandleInfoKey() {
        return SelectionHandleInfoKey;
    }

    /* JADX INFO: renamed from: getAdjustedCoordinates-k-4lQ0M, reason: not valid java name */
    public static final long m632getAdjustedCoordinatesk4lQ0M(long j) {
        return OffsetKt.Offset(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j) - 1.0f);
    }

    public static final boolean isLeftSelectionHandle(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        if (z) {
            return isHandleLtrDirection(resolvedTextDirection, z2);
        }
        return !isHandleLtrDirection(resolvedTextDirection, z2);
    }

    static {
        float f = 25;
        HandleWidth = Dp.m2551constructorimpl(f);
        HandleHeight = Dp.m2551constructorimpl(f);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection resolvedTextDirection, boolean z) {
        if (resolvedTextDirection != ResolvedTextDirection.Ltr || z) {
            return resolvedTextDirection == ResolvedTextDirection.Rtl && z;
        }
        return true;
    }
}
