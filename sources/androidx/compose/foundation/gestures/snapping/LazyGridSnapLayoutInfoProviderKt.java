package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridSnapLayoutInfoProviderKt {
    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return IntSize.m2608getHeightimpl(lazyGridItemInfo.mo390getSizeYbymL2g());
        }
        return IntSize.m2609getWidthimpl(lazyGridItemInfo.mo390getSizeYbymL2g());
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return IntOffset.m2592getYimpl(lazyGridItemInfo.mo389getOffsetnOccac());
        }
        return IntOffset.m2591getXimpl(lazyGridItemInfo.mo389getOffsetnOccac());
    }
}
