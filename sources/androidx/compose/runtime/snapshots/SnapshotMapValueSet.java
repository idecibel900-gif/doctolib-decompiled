package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class SnapshotMapValueSet extends SnapshotMapSet {
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add(obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) addAll(collection)).booleanValue();
    }

    public SnapshotMapValueSet(SnapshotStateMap snapshotStateMap) {
        super(snapshotStateMap);
    }

    @Override // java.util.Set, java.util.Collection
    public Void add(Object obj) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection
    public Void addAll(Collection collection) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public StateMapMutableValuesIterator iterator() {
        return new StateMapMutableValuesIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return getMap().removeValue$runtime_release(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Set set = CollectionsKt.toSet(collection);
        SnapshotStateMap map = getMap();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) firstStateRecord);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            Iterator it = map.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = map.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord3 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, map, current);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, map);
        } while (!z);
        return z2;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Set set = CollectionsKt.toSet(collection);
        SnapshotStateMap map = getMap();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) firstStateRecord);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            Iterator it = map.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (!set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = map.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord3 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, map, current);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, map);
        } while (!z);
        return z2;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return getMap().containsValue(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!getMap().containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }
}
