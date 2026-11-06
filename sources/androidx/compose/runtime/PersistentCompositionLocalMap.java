package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;

/* JADX INFO: loaded from: classes.dex */
public interface PersistentCompositionLocalMap extends PersistentMap, CompositionLocalMap, CompositionLocalAccessorScope {

    public interface Builder extends PersistentMap.Builder {
        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        PersistentCompositionLocalMap build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    Builder builder();

    PersistentCompositionLocalMap putValue(CompositionLocal compositionLocal, ValueHolder valueHolder);

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    default Object getCurrentValue(CompositionLocal compositionLocal) {
        return CompositionLocalMapKt.read(this, compositionLocal);
    }
}
