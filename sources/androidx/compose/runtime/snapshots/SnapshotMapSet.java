package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes.dex */
abstract class SnapshotMapSet implements Set, KMutableSet {
    private final SnapshotStateMap map;

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.toArray(this, objArr);
    }

    public SnapshotMapSet(SnapshotStateMap snapshotStateMap) {
        this.map = snapshotStateMap;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final SnapshotStateMap getMap() {
        return this.map;
    }

    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
}
