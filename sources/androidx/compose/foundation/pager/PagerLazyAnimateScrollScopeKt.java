package androidx.compose.foundation.pager;

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
public abstract class PagerLazyAnimateScrollScopeKt {
    public static final LazyLayoutAnimateScrollScope PagerLazyAnimateScrollScope(final PagerState pagerState) {
        return new LazyLayoutAnimateScrollScope() { // from class: androidx.compose.foundation.pager.PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope.1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getFirstVisibleItemIndex() {
                return pagerState.getFirstVisiblePage$foundation_release();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public int getLastVisibleItemIndex() {
                return ((PageInfo) CollectionsKt.last(pagerState.getLayoutInfo().getVisiblePagesInfo())).getIndex();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public void snapToItem(ScrollScope scrollScope, int i, int i2) {
                pagerState.snapToItem$foundation_release(i, i2 / pagerState.getPageSizeWithSpacing$foundation_release(), true);
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public float calculateDistanceTo(int i) {
                Object obj;
                List visiblePagesInfo = pagerState.getLayoutInfo().getVisiblePagesInfo();
                int size = visiblePagesInfo.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        obj = null;
                        break;
                    }
                    obj = visiblePagesInfo.get(i2);
                    if (((PageInfo) obj).getIndex() == i) {
                        break;
                    }
                    i2++;
                }
                PageInfo pageInfo = (PageInfo) obj;
                if (pageInfo == null) {
                    return ((i - pagerState.getCurrentPage()) * getVisibleItemsAverageSize()) - (pagerState.getCurrentPageOffsetFraction() * pagerState.getPageSizeWithSpacing$foundation_release());
                }
                return pageInfo.getOffset();
            }

            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
            public Object scroll(Function2 function2, Continuation continuation) {
                Object objScroll$default = ScrollableState.scroll$default(pagerState, null, function2, continuation, 1, null);
                return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
            }

            private final int getVisibleItemsAverageSize() {
                return pagerState.getPageSize$foundation_release() + pagerState.getPageSpacing$foundation_release();
            }
        };
    }
}
