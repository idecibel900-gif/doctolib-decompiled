package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface PagerLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    int getBeyondViewportPageCount();

    Orientation getOrientation();

    int getPageSize();

    int getPageSpacing();

    boolean getReverseLayout();

    SnapPosition getSnapPosition();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    long mo437getViewportSizeYbymL2g();

    int getViewportStartOffset();

    List getVisiblePagesInfo();
}
