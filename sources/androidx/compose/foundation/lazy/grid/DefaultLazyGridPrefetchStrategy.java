package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;
    private int lineToPrefetch = -1;
    private final MutableVector currentLinePrefetchHandles = new MutableVector(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);

    public DefaultLazyGridPrefetchStrategy(int i) {
        this.nestedPrefetchItemCount = i;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(LazyGridPrefetchScope lazyGridPrefetchScope, float f, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        int index;
        MutableVector mutableVector;
        int size;
        MutableVector mutableVector2;
        int size2;
        MutableVector mutableVector3;
        int size3;
        if (lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        int i = 0;
        boolean z = f < 0.0f;
        if (z) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
            index = ((LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
            index = ((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
        }
        if (index < 0 || index >= lazyGridLayoutInfo.getTotalItemsCount()) {
            return;
        }
        if (row != this.lineToPrefetch) {
            if (this.wasScrollingForward != z && (size3 = (mutableVector3 = this.currentLinePrefetchHandles).getSize()) > 0) {
                Object[] content = mutableVector3.getContent();
                int i2 = 0;
                do {
                    ((LazyLayoutPrefetchState.PrefetchHandle) content[i2]).cancel();
                    i2++;
                } while (i2 < size3);
            }
            this.wasScrollingForward = z;
            this.lineToPrefetch = row;
            this.currentLinePrefetchHandles.clear();
            MutableVector mutableVector4 = this.currentLinePrefetchHandles;
            mutableVector4.addAll(mutableVector4.getSize(), lazyGridPrefetchScope.scheduleLinePrefetch(row));
        }
        if (!z) {
            if (lazyGridLayoutInfo.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo()), lazyGridLayoutInfo.getOrientation()) >= f || (size = (mutableVector = this.currentLinePrefetchHandles).getSize()) <= 0) {
                return;
            }
            Object[] content2 = mutableVector.getContent();
            do {
                ((LazyLayoutPrefetchState.PrefetchHandle) content2[i]).markAsUrgent();
                i++;
            } while (i < size);
            return;
        }
        LazyGridItemInfo lazyGridItemInfo3 = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
        if (((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation())) + lazyGridLayoutInfo.getMainAxisItemSpacing()) - lazyGridLayoutInfo.getViewportEndOffset() >= (-f) || (size2 = (mutableVector2 = this.currentLinePrefetchHandles).getSize()) <= 0) {
            return;
        }
        Object[] content3 = mutableVector2.getContent();
        do {
            ((LazyLayoutPrefetchState.PrefetchHandle) content3[i]).markAsUrgent();
            i++;
        } while (i < size2);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        if (this.lineToPrefetch == -1 || lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        if (this.wasScrollingForward) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
        }
        if (this.lineToPrefetch != row) {
            this.lineToPrefetch = -1;
            MutableVector mutableVector = this.currentLinePrefetchHandles;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    ((LazyLayoutPrefetchState.PrefetchHandle) content[i]).cancel();
                    i++;
                } while (i < size);
            }
            this.currentLinePrefetchHandles.clear();
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i) {
        int i2 = this.nestedPrefetchItemCount;
        for (int i3 = 0; i3 < i2; i3++) {
            nestedPrefetchScope.schedulePrefetch(i + i3);
        }
    }
}
