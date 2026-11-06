package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondViewportPageCount;
    private boolean canScrollForward;
    private final CoroutineScope coroutineScope;
    private final MeasuredPage currentPage;
    private float currentPageOffsetFraction;
    private final List extraPagesAfter;
    private final List extraPagesBefore;
    private final MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final SnapPosition snapPosition;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List visiblePagesInfo;

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 getRulers() {
        return this.$$delegate_0.getRulers();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public PagerMeasureResult(List list, int i, int i2, int i3, Orientation orientation, int i4, int i5, boolean z, int i6, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i7, boolean z2, SnapPosition snapPosition, MeasureResult measureResult, boolean z3, List list2, List list3, CoroutineScope coroutineScope) {
        this.visiblePagesInfo = list;
        this.pageSize = i;
        this.pageSpacing = i2;
        this.afterContentPadding = i3;
        this.orientation = orientation;
        this.viewportStartOffset = i4;
        this.viewportEndOffset = i5;
        this.reverseLayout = z;
        this.beyondViewportPageCount = i6;
        this.firstVisiblePage = measuredPage;
        this.currentPage = measuredPage2;
        this.currentPageOffsetFraction = f;
        this.firstVisiblePageScrollOffset = i7;
        this.canScrollForward = z2;
        this.snapPosition = snapPosition;
        this.remeasureNeeded = z3;
        this.extraPagesBefore = list2;
        this.extraPagesAfter = list3;
        this.coroutineScope = coroutineScope;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public List getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getPageSpacing() {
        return this.pageSpacing;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeyondViewportPageCount() {
        return this.beyondViewportPageCount;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public SnapPosition getSnapPosition() {
        return this.snapPosition;
    }

    public /* synthetic */ PagerMeasureResult(List list, int i, int i2, int i3, Orientation orientation, int i4, int i5, boolean z, int i6, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i7, boolean z2, SnapPosition snapPosition, MeasureResult measureResult, boolean z3, List list2, List list3, CoroutineScope coroutineScope, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, i3, orientation, i4, i5, z, i6, measuredPage, measuredPage2, f, i7, z2, snapPosition, measureResult, z3, (i8 & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i8 & 262144) != 0 ? CollectionsKt.emptyList() : list3, coroutineScope);
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo437getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage measuredPage = this.firstVisiblePage;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.firstVisiblePageScrollOffset == 0) ? false : true;
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int i) {
        int i2;
        int pageSize = getPageSize() + getPageSpacing();
        if (!this.remeasureNeeded && !getVisiblePagesInfo().isEmpty() && this.firstVisiblePage != null && (i2 = this.firstVisiblePageScrollOffset - i) >= 0 && i2 < pageSize) {
            float f = pageSize != 0 ? i / pageSize : 0.0f;
            float f2 = this.currentPageOffsetFraction - f;
            if (this.currentPage != null && f2 < 0.5f && f2 > -0.5f) {
                MeasuredPage measuredPage = (MeasuredPage) CollectionsKt.first(getVisiblePagesInfo());
                MeasuredPage measuredPage2 = (MeasuredPage) CollectionsKt.last(getVisiblePagesInfo());
                if (i >= 0 ? Math.min(getViewportStartOffset() - measuredPage.getOffset(), getViewportEndOffset() - measuredPage2.getOffset()) > i : Math.min((measuredPage.getOffset() + pageSize) - getViewportStartOffset(), (measuredPage2.getOffset() + pageSize) - getViewportEndOffset()) > (-i)) {
                    this.currentPageOffsetFraction -= f;
                    this.firstVisiblePageScrollOffset -= i;
                    List visiblePagesInfo = getVisiblePagesInfo();
                    int size = visiblePagesInfo.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((MeasuredPage) visiblePagesInfo.get(i3)).applyScrollDelta(i);
                    }
                    List list = this.extraPagesBefore;
                    int size2 = list.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((MeasuredPage) list.get(i4)).applyScrollDelta(i);
                    }
                    List list2 = this.extraPagesAfter;
                    int size3 = list2.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ((MeasuredPage) list2.get(i5)).applyScrollDelta(i);
                    }
                    if (!this.canScrollForward && i > 0) {
                        this.canScrollForward = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
