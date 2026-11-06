package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        this.state.snapToItemIndexInternal$foundation_release(i, i2, true);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int i) {
        Object obj;
        int iM2591getXimpl;
        LazyGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = visibleItemsInfo.get(i2);
            if (((LazyGridItemInfo) obj).getIndex() == i) {
                break;
            }
            i2++;
        }
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) obj;
        if (lazyGridItemInfo == null) {
            int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
            return (calculateLineAverageMainAxisSize(layoutInfo) * (((i - getFirstVisibleItemIndex()) + ((slotsPerLine$foundation_release - 1) * (i < getFirstVisibleItemIndex() ? -1 : 1))) / slotsPerLine$foundation_release)) - getFirstVisibleItemScrollOffset();
        }
        if (layoutInfo.getOrientation() == Orientation.Vertical) {
            iM2591getXimpl = IntOffset.m2592getYimpl(lazyGridItemInfo.mo389getOffsetnOccac());
        } else {
            iM2591getXimpl = IntOffset.m2591getXimpl(lazyGridItemInfo.mo389getOffsetnOccac());
        }
        return iM2591getXimpl;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        int iM2609getWidthimpl;
        final boolean z = lazyGridLayoutInfo.getOrientation() == Orientation.Vertical;
        final List visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Integer invoke(int i) {
                return Integer.valueOf(z ? ((LazyGridItemInfo) visibleItemsInfo.get(i)).getRow() : ((LazyGridItemInfo) visibleItemsInfo.get(i)).getColumn());
            }
        };
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < visibleItemsInfo.size()) {
            int iIntValue = ((Number) function1.invoke(Integer.valueOf(i))).intValue();
            if (iIntValue == -1) {
                i++;
            } else {
                int iMax = 0;
                while (i < visibleItemsInfo.size() && ((Number) function1.invoke(Integer.valueOf(i))).intValue() == iIntValue) {
                    if (z) {
                        iM2609getWidthimpl = IntSize.m2608getHeightimpl(((LazyGridItemInfo) visibleItemsInfo.get(i)).mo390getSizeYbymL2g());
                    } else {
                        iM2609getWidthimpl = IntSize.m2609getWidthimpl(((LazyGridItemInfo) visibleItemsInfo.get(i)).mo390getSizeYbymL2g());
                    }
                    iMax = Math.max(iMax, iM2609getWidthimpl);
                    i++;
                }
                i2 += iMax;
                i3++;
            }
        }
        return (i2 / i3) + lazyGridLayoutInfo.getMainAxisItemSpacing();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public Object scroll(Function2 function2, Continuation continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this.state, null, function2, continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }
}
