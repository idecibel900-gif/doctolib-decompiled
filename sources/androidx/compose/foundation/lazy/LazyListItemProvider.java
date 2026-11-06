package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyListItemProvider extends LazyLayoutItemProvider {
    List getHeaderIndexes();

    LazyItemScopeImpl getItemScope();

    LazyLayoutKeyIndexMap getKeyIndexMap();
}
