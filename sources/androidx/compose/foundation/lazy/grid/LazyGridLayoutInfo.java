package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyGridLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    int getMainAxisItemSpacing();

    Orientation getOrientation();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    long mo393getViewportSizeYbymL2g();

    int getViewportStartOffset();

    List getVisibleItemsInfo();
}
