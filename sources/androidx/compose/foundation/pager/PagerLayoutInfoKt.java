package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerLayoutInfoKt {
    public static final int getMainAxisViewportSize(PagerLayoutInfo pagerLayoutInfo) {
        return pagerLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m2608getHeightimpl(pagerLayoutInfo.mo437getViewportSizeYbymL2g()) : IntSize.m2609getWidthimpl(pagerLayoutInfo.mo437getViewportSizeYbymL2g());
    }
}
