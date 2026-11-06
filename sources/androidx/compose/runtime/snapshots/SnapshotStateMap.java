package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateMap implements StateObject, Map, KMutableMap {
    private final Set entries;
    private StateRecord firstStateRecord;
    private final Set keys;
    private final Collection values;

    public SnapshotStateMap() {
        PersistentMap persistentMapPersistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        StateMapStateRecord stateMapStateRecord = new StateMapStateRecord(persistentMapPersistentHashMapOf);
        if (Snapshot.Companion.isInSnapshot()) {
            StateMapStateRecord stateMapStateRecord2 = new StateMapStateRecord(persistentMapPersistentHashMapOf);
            stateMapStateRecord2.setSnapshotId$runtime_release(1);
            stateMapStateRecord.setNext$runtime_release(stateMapStateRecord2);
        }
        this.firstStateRecord = stateMapStateRecord;
        this.entries = new SnapshotMapEntrySet(this);
        this.keys = new SnapshotMapKeySet(this);
        this.values = new SnapshotMapValueSet(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public Set getEntries() {
        return this.entries;
    }

    public Set getKeys() {
        return this.keys;
    }

    public Collection getValues() {
        return this.values;
    }

    public String toString() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord)).getMap$runtime_release() + ")@" + hashCode();
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final boolean removeValue$runtime_release(Object obj) {
        Object next;
        Iterator it = entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Map.Entry) next).getValue(), obj));
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    public final StateMapStateRecord getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) firstStateRecord, this);
    }

    @Override // java.util.Map
    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord);
        stateMapStateRecord.getMap$runtime_release();
        PersistentMap persistentMapPersistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        if (persistentMapPersistentHashMapOf != stateMapStateRecord.getMap$runtime_release()) {
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                synchronized (SnapshotStateMapKt.sync) {
                    stateMapStateRecord3.setMap$runtime_release(persistentMapPersistentHashMapOf);
                    stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                }
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Object objPut;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            objPut = builder.put(obj, obj2);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                        z = true;
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return objPut;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0077 */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void putAll(java.util.Map r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r2 = r1.getMap$runtime_release()     // Catch: java.lang.Throwable -> L7e
            int r1 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r0 = r2.builder()
            r0.putAll(r8)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r0.build()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 != 0) goto L7d
            androidx.compose.runtime.snapshots.StateRecord r2 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r2
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r2, r7, r4)     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r2     // Catch: java.lang.Throwable -> L77
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.access$getSync$p()     // Catch: java.lang.Throwable -> L77
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L77
            int r6 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6c
            if (r6 != r1) goto L6e
            r2.setMap$runtime_release(r0)     // Catch: java.lang.Throwable -> L6c
            int r0 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6c
            r1 = 1
            int r0 = r0 + r1
            r2.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L6c
            goto L6f
        L6c:
            r8 = move-exception
            goto L79
        L6e:
            r1 = 0
        L6f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r1 == 0) goto L0
            goto L7d
        L77:
            r8 = move-exception
            goto L7b
        L79:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            throw r8     // Catch: java.lang.Throwable -> L77
        L7b:
            monitor-exit(r3)
            throw r8
        L7d:
            return
        L7e:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.putAll(java.util.Map):void");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Object objRemove;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            objRemove = builder.remove(obj);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(persistentMapBuild);
                        z = true;
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return objRemove;
    }

    public static final class StateMapStateRecord extends StateRecord {
        private PersistentMap map;
        private int modification;

        public final PersistentMap getMap$runtime_release() {
            return this.map;
        }

        public final void setMap$runtime_release(PersistentMap persistentMap) {
            this.map = persistentMap;
        }

        public StateMapStateRecord(PersistentMap persistentMap) {
            this.map = persistentMap;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }
    }
}
