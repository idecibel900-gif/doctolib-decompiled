package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;

/* JADX INFO: loaded from: classes.dex */
public interface LazyListPrefetchStrategy {
    default PrefetchScheduler getPrefetchScheduler() {
        return null;
    }

    void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i);

    void onScroll(LazyListPrefetchScope lazyListPrefetchScope, float f, LazyListLayoutInfo lazyListLayoutInfo);

    void onVisibleItemsUpdated(LazyListPrefetchScope lazyListPrefetchScope, LazyListLayoutInfo lazyListLayoutInfo);
}
