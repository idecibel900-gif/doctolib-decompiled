package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasureResult implements LazyGridLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final CoroutineScope coroutineScope;
    private final Density density;
    private final LazyGridMeasuredLine firstVisibleLine;
    private int firstVisibleLineScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final Function1 prefetchInfoRetriever;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int slotsPerLine;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List visibleItemsInfo;

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

    public LazyGridMeasureResult(LazyGridMeasuredLine lazyGridMeasuredLine, int i, boolean z, float f, MeasureResult measureResult, boolean z2, CoroutineScope coroutineScope, Density density, int i2, Function1 function1, List list, int i3, int i4, int i5, boolean z3, Orientation orientation, int i6, int i7) {
        this.firstVisibleLine = lazyGridMeasuredLine;
        this.firstVisibleLineScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.remeasureNeeded = z2;
        this.coroutineScope = coroutineScope;
        this.density = density;
        this.slotsPerLine = i2;
        this.prefetchInfoRetriever = function1;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i3;
        this.viewportEndOffset = i4;
        this.totalItemsCount = i5;
        this.reverseLayout = z3;
        this.orientation = orientation;
        this.afterContentPadding = i6;
        this.mainAxisItemSpacing = i7;
        this.$$delegate_0 = measureResult;
    }

    public final LazyGridMeasuredLine getFirstVisibleLine() {
        return this.firstVisibleLine;
    }

    public final int getFirstVisibleLineScrollOffset() {
        return this.firstVisibleLineScrollOffset;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final Function1 getPrefetchInfoRetriever() {
        return this.prefetchInfoRetriever;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public List getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final boolean getCanScrollBackward() {
        LazyGridMeasuredLine lazyGridMeasuredLine = this.firstVisibleLine;
        return ((lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() : 0) == 0 && this.firstVisibleLineScrollOffset == 0) ? false : true;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo393getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean tryToApplyScrollWithoutRemeasure(int i) {
        LazyGridMeasuredLine lazyGridMeasuredLine;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (!this.remeasureNeeded && !getVisibleItemsInfo().isEmpty() && (lazyGridMeasuredLine = this.firstVisibleLine) != null) {
            int mainAxisSizeWithSpacings = lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            int i2 = this.firstVisibleLineScrollOffset - i;
            if (i2 >= 0 && i2 < mainAxisSizeWithSpacings) {
                LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.first(getVisibleItemsInfo());
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) CollectionsKt.last(getVisibleItemsInfo());
                if (!lazyGridMeasuredItem.getNonScrollableItem() && !lazyGridMeasuredItem2.getNonScrollableItem() && (i >= 0 ? Math.min(getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation()), getViewportEndOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation())) > i : Math.min((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem, getOrientation()) + lazyGridMeasuredItem.getMainAxisSizeWithSpacings()) - getViewportStartOffset(), (LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridMeasuredItem2, getOrientation()) + lazyGridMeasuredItem2.getMainAxisSizeWithSpacings()) - getViewportEndOffset()) > (-i))) {
                    this.firstVisibleLineScrollOffset -= i;
                    List visibleItemsInfo = getVisibleItemsInfo();
                    int size = visibleItemsInfo.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((LazyGridMeasuredItem) visibleItemsInfo.get(i3)).applyScrollDelta(i);
                    }
                    this.consumedScroll = i;
                    z = true;
                    z = true;
                    z = true;
                    if (!this.canScrollForward && i > 0) {
                        this.canScrollForward = true;
                    }
                }
            }
        }
        return z;
    }
}
