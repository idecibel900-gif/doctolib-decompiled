package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    private final LazyListState state;

    public LazyListAnimateScrollScope(LazyListState lazyListState) {
        this.state = lazyListState;
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
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
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
        LazyListLayoutInfo layoutInfo = this.state.getLayoutInfo();
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
            if (((LazyListItemInfo) obj).getIndex() == i) {
                break;
            }
            i2++;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) obj;
        if (lazyListItemInfo == null) {
            return (calculateVisibleItemsAverageSize(layoutInfo) * (i - getFirstVisibleItemIndex())) - getFirstVisibleItemScrollOffset();
        }
        return lazyListItemInfo.getOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public Object scroll(Function2 function2, Continuation continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this.state, null, function2, continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    private final int calculateVisibleItemsAverageSize(LazyListLayoutInfo lazyListLayoutInfo) {
        List visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int size2 = 0;
        for (int i = 0; i < size; i++) {
            size2 += ((LazyListItemInfo) visibleItemsInfo.get(i)).getSize();
        }
        return (size2 / visibleItemsInfo.size()) + lazyListLayoutInfo.getMainAxisItemSpacing();
    }
}
