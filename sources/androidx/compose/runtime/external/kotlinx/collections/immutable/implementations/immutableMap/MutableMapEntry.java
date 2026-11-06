package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes.dex */
final class MutableMapEntry extends MapEntry implements Map.Entry, KMutableMap.Entry {
    private final PersistentHashMapBuilderEntriesIterator parentIterator;
    private Object value;

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(Object obj) {
        this.value = obj;
    }

    public MutableMapEntry(PersistentHashMapBuilderEntriesIterator persistentHashMapBuilderEntriesIterator, Object obj, Object obj2) {
        super(obj, obj2);
        this.parentIterator = persistentHashMapBuilderEntriesIterator;
        this.value = obj2;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public Object setValue(Object obj) {
        Object value = getValue();
        setValue(obj);
        this.parentIterator.setValue(getKey(), obj);
        return value;
    }
}
