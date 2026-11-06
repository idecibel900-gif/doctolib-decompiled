package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;

/* JADX INFO: loaded from: classes.dex */
public final class PagerScrollPosition {
    private final MutableIntState currentPage$delegate;
    private final MutableFloatState currentPageOffsetFraction$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final PagerState state;

    public PagerScrollPosition(int i, float f, PagerState pagerState) {
        this.state = pagerState;
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.currentPageOffsetFraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    private final void setCurrentPage(int i) {
        this.currentPage$delegate.setIntValue(i);
    }

    public final int getCurrentPage() {
        return this.currentPage$delegate.getIntValue();
    }

    private final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction$delegate.setFloatValue(f);
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(PagerMeasureResult pagerMeasureResult) {
        MeasuredPage currentPage = pagerMeasureResult.getCurrentPage();
        this.lastKnownCurrentPageKey = currentPage != null ? currentPage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || !pagerMeasureResult.getVisiblePagesInfo().isEmpty()) {
            this.hadFirstNotEmptyLayout = true;
            MeasuredPage currentPage2 = pagerMeasureResult.getCurrentPage();
            update(currentPage2 != null ? currentPage2.getIndex() : 0, pagerMeasureResult.getCurrentPageOffsetFraction());
        }
    }

    public final void requestPositionAndForgetLastKnownKey(int i, float f) {
        update(i, f);
        this.lastKnownCurrentPageKey = null;
    }

    public final int matchPageWithKey(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i) {
        int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(pagerLazyLayoutItemProvider, this.lastKnownCurrentPageKey, i);
        if (i != iFindIndexByKey) {
            setCurrentPage(iFindIndexByKey);
            this.nearestRangeState.update(i);
        }
        return iFindIndexByKey;
    }

    private final void update(int i, float f) {
        setCurrentPage(i);
        this.nearestRangeState.update(i);
        setCurrentPageOffsetFraction(f);
    }

    public final void updateCurrentPageOffsetFraction(float f) {
        setCurrentPageOffsetFraction(f);
    }

    public final void applyScrollDelta(int i) {
        setCurrentPageOffsetFraction(getCurrentPageOffsetFraction() + (this.state.getPageSizeWithSpacing$foundation_release() == 0 ? 0.0f : i / this.state.getPageSizeWithSpacing$foundation_release()));
    }
}
