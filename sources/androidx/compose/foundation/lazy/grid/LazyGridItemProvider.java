package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;

/* JADX INFO: loaded from: classes.dex */
public interface LazyGridItemProvider extends LazyLayoutItemProvider {
    LazyLayoutKeyIndexMap getKeyIndexMap();

    LazyGridSpanLayoutProvider getSpanLayoutProvider();
}
