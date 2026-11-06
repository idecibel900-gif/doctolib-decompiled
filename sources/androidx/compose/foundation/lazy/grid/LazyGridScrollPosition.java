package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyGridScrollPosition(int i, int i2) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(i2);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 90, 200);
    }

    private final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(LazyGridMeasureResult lazyGridMeasureResult) {
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        LazyGridMeasuredItem[] items2;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        LazyGridMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        this.lastKnownFirstItemKey = (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? null : lazyGridMeasuredItem2.getKey();
        if (this.hadFirstNotEmptyLayout || lazyGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleLineScrollOffset = lazyGridMeasureResult.getFirstVisibleLineScrollOffset();
            if (firstVisibleLineScrollOffset < 0.0f) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleLineScrollOffset + ')').toString());
            }
            LazyGridMeasuredLine firstVisibleLine2 = lazyGridMeasureResult.getFirstVisibleLine();
            update((firstVisibleLine2 == null || (items = firstVisibleLine2.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items)) == null) ? 0 : lazyGridMeasuredItem.getIndex(), firstVisibleLineScrollOffset);
        }
    }

    public final void updateScrollOffset(int i) {
        if (i < 0.0f) {
            throw new IllegalStateException(("scrollOffset should be non-negative (" + i + ')').toString());
        }
        setScrollOffset(i);
    }

    public final void requestPositionAndForgetLastKnownKey(int i, int i2) {
        update(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider lazyGridItemProvider, int i) {
        int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyGridItemProvider, this.lastKnownFirstItemKey, i);
        if (i != iFindIndexByKey) {
            setIndex(iFindIndexByKey);
            this.nearestRangeState.update(i);
        }
        return iFindIndexByKey;
    }

    private final void update(int i, int i2) {
        if (i < 0.0f) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
        setIndex(i);
        this.nearestRangeState.update(i);
        setScrollOffset(i2);
    }
}
