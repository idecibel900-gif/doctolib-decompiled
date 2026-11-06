package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;

/* JADX INFO: loaded from: classes.dex */
public interface LazyGridPrefetchStrategy {
    default PrefetchScheduler getPrefetchScheduler() {
        return null;
    }

    void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i);

    void onScroll(LazyGridPrefetchScope lazyGridPrefetchScope, float f, LazyGridLayoutInfo lazyGridLayoutInfo);

    void onVisibleItemsUpdated(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo);
}
