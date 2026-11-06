package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotKt {
    private static List applyObservers;
    private static final AtomicReference currentGlobalSnapshot;
    private static final SnapshotWeakSet extraStateObjects;
    private static List globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final Function1 emptyLambda = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        public final void invoke(SnapshotIdSet snapshotIdSet) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SnapshotIdSet) obj);
            return Unit.INSTANCE;
        }
    };
    private static final SnapshotThreadLocal threadSnapshot = new SnapshotThreadLocal();
    private static final Object lock = new Object();

    public static final int trackPinning(int i, SnapshotIdSet snapshotIdSet) {
        int iAdd;
        int iLowest = snapshotIdSet.lowest(i);
        synchronized (getLock()) {
            iAdd = pinningTable.add(iLowest);
        }
        return iAdd;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = (Snapshot) threadSnapshot.get();
        return snapshot == null ? (Snapshot) currentGlobalSnapshot.get() : snapshot;
    }

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.Companion;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 2;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet();
        applyObservers = CollectionsKt.emptyList();
        globalWriteObservers = CollectionsKt.emptyList();
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference atomicReference = new AtomicReference(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        snapshotInitializer = (Snapshot) atomicReference.get();
        pendingApplyObserverCount = new AtomicInt(0);
    }

    static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1 function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z);
    }

    static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 mergedReadObserver(final Function1 function1, final Function1 function2, boolean z) {
        if (!z) {
            function2 = null;
        }
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1112invoke(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1112invoke(Object obj) {
                function1.invoke(obj);
                function2.invoke(obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 mergedWriteObserver(final Function1 function1, final Function1 function2) {
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1113invoke(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1113invoke(Object obj) {
                function1.invoke(obj);
                function2.invoke(obj);
            }
        };
    }

    public static final Object getLock() {
        return lock;
    }

    public static final StateRecord newWritableRecord(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordNewWritableRecordLocked;
        synchronized (getLock()) {
            stateRecordNewWritableRecordLocked = newWritableRecordLocked(stateRecord, stateObject, snapshot);
        }
        return stateRecordNewWritableRecordLocked;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object takeNewGlobalSnapshot(Snapshot snapshot, Function1 function1) {
        Object objInvoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return objInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8 A[Catch: all -> 0x009e, LOOP:1: B:30:0x006e->B:42:0x00a8, LOOP_END, TryCatch #2 {all -> 0x009e, blocks: (B:25:0x005f, B:27:0x0064, B:30:0x006e, B:32:0x007e, B:34:0x008a, B:36:0x0093, B:39:0x00a0, B:42:0x00a8, B:43:0x00ab), top: B:54:0x005f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab A[EDGE_INSN: B:58:0x00ab->B:43:0x00ab BREAK  A[LOOP:1: B:30:0x006e->B:42:0x00a8], SYNTHETIC] */
    public static final Object advanceGlobalSnapshot(Function1 function1) {
        Object obj;
        MutableScatterSet modified$runtime_release;
        Object objTakeNewGlobalSnapshot;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (getLock()) {
            try {
                obj = currentGlobalSnapshot.get();
                modified$runtime_release = ((GlobalSnapshot) obj).getModified$runtime_release();
                if (modified$runtime_release != null) {
                    pendingApplyObserverCount.add(1);
                }
                objTakeNewGlobalSnapshot = takeNewGlobalSnapshot((Snapshot) obj, function1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (modified$runtime_release != null) {
            try {
                List list = applyObservers;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((Function2) list.get(i)).invoke(ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release), obj);
                }
                pendingApplyObserverCount.add(-1);
            } catch (Throwable th2) {
                pendingApplyObserverCount.add(-1);
                throw th2;
            }
        }
        synchronized (getLock()) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (modified$runtime_release != null) {
                    Object[] objArr = modified$runtime_release.elements;
                    long[] jArr = modified$runtime_release.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        while (true) {
                            long j = jArr[i2];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i2 != length) {
                                    break;
                                    break;
                                }
                                i2++;
                            } else {
                                int i3 = 8 - ((~(i2 - length)) >>> 31);
                                for (int i4 = 0; i4 < i3; i4++) {
                                    if ((255 & j) < 128) {
                                        processForUnusedRecordsLocked((StateObject) objArr[(i2 << 3) + i4]);
                                    }
                                    j >>= 8;
                                }
                                if (i3 != 8) {
                                    break;
                                }
                                if (i2 != length) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return objTakeNewGlobalSnapshot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.advanceGlobalSnapshot.3
            public final void invoke(SnapshotIdSet snapshotIdSet) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SnapshotIdSet) obj);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot takeNewSnapshot(final Function1 function1) {
        return (Snapshot) advanceGlobalSnapshot(new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotKt.takeNewSnapshot.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Snapshot invoke(SnapshotIdSet snapshotIdSet) {
                Snapshot snapshot = (Snapshot) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.getLock()) {
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        int iLowestOrDefault;
        if (openSnapshots.get(snapshot.getId())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot is not open: id=");
        sb.append(snapshot.getId());
        sb.append(", disposed=");
        sb.append(snapshot.getDisposed$runtime_release());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied$runtime_release()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (getLock()) {
            iLowestOrDefault = pinningTable.lowestOrDefault(-1);
        }
        sb.append(iLowestOrDefault);
        throw new IllegalStateException(sb.toString().toString());
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return (i2 == 0 || i2 > i || snapshotIdSet.get(i2)) ? false : true;
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateRecord readable(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord2 = null;
        while (stateRecord != null) {
            if (valid(stateRecord, i, snapshotIdSet) && (stateRecord2 == null || stateRecord2.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release())) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext$runtime_release();
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        return null;
    }

    public static final StateRecord readable(StateRecord stateRecord, StateObject stateObject) {
        StateRecord stateRecord2;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        Function1 readObserver = current.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        StateRecord stateRecord3 = readable(stateRecord, current.getId(), current.getInvalid$runtime_release());
        if (stateRecord3 != null) {
            return stateRecord3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            stateRecord2 = readable(firstStateRecord, current2.getId(), current2.getInvalid$runtime_release());
            if (stateRecord2 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return stateRecord2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() != 0) {
                if (valid(firstStateRecord, iLowestOrDefault, empty)) {
                    if (stateRecord == null) {
                        stateRecord = firstStateRecord;
                    } else if (firstStateRecord.getSnapshotId$runtime_release() >= stateRecord.getSnapshotId$runtime_release()) {
                        return stateRecord;
                    }
                }
            }
            return firstStateRecord;
        }
        return null;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.getNext$runtime_release()) {
            int snapshotId$runtime_release = firstStateRecord2.getSnapshotId$runtime_release();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= iLowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (firstStateRecord2.getSnapshotId$runtime_release() < stateRecord2.getSnapshotId$runtime_release()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (firstStateRecord.getSnapshotId$runtime_release() >= iLowestOrDefault) {
                                break;
                            }
                            if (stateRecord3.getSnapshotId$runtime_release() < firstStateRecord.getSnapshotId$runtime_release()) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.getNext$runtime_release();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            Object obj = weakReference != null ? weakReference.get() : null;
            if (obj != null && overwriteUnusedRecordsLocked((StateObject) obj)) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes$runtime_release()[i2] = snapshotWeakSet.getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            snapshotWeakSet.getValues$runtime_release()[i3] = null;
            snapshotWeakSet.getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    public static final StateRecord writableRecord(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordNewWritableRecordLocked;
        if (snapshot.getReadOnly()) {
            snapshot.mo1110recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        StateRecord stateRecord2 = readable(stateRecord, id, snapshot.getInvalid$runtime_release());
        if (stateRecord2 == null) {
            readError();
            throw new KotlinNothingValueException();
        }
        if (stateRecord2.getSnapshotId$runtime_release() == snapshot.getId()) {
            return stateRecord2;
        }
        synchronized (getLock()) {
            stateRecordNewWritableRecordLocked = readable(stateObject.getFirstStateRecord(), id, snapshot.getInvalid$runtime_release());
            if (stateRecordNewWritableRecordLocked == null) {
                readError();
                throw new KotlinNothingValueException();
            }
            if (stateRecordNewWritableRecordLocked.getSnapshotId$runtime_release() != id) {
                stateRecordNewWritableRecordLocked = newWritableRecordLocked(stateRecordNewWritableRecordLocked, stateObject, snapshot);
            }
        }
        Intrinsics.checkNotNull(stateRecordNewWritableRecordLocked, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (stateRecord2.getSnapshotId$runtime_release() != 1) {
            snapshot.mo1110recordModified$runtime_release(stateObject);
        }
        return stateRecordNewWritableRecordLocked;
    }

    public static final StateRecord overwritableRecord(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot, StateRecord stateRecord2) {
        StateRecord stateRecordNewOverwritableRecordLocked;
        if (snapshot.getReadOnly()) {
            snapshot.mo1110recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (stateRecord2.getSnapshotId$runtime_release() == id) {
            return stateRecord2;
        }
        synchronized (getLock()) {
            stateRecordNewOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, stateObject);
        }
        stateRecordNewOverwritableRecordLocked.setSnapshotId$runtime_release(id);
        if (stateRecord2.getSnapshotId$runtime_release() != 1) {
            snapshot.mo1110recordModified$runtime_release(stateObject);
        }
        return stateRecordNewOverwritableRecordLocked;
    }

    private static final StateRecord newWritableRecordLocked(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordNewOverwritableRecordLocked = newOverwritableRecordLocked(stateRecord, stateObject);
        stateRecordNewOverwritableRecordLocked.assign(stateRecord);
        stateRecordNewOverwritableRecordLocked.setSnapshotId$runtime_release(snapshot.getId());
        return stateRecordNewOverwritableRecordLocked;
    }

    public static final StateRecord newOverwritableRecordLocked(StateRecord stateRecord, StateObject stateObject) {
        StateRecord stateRecordUsedLocked = usedLocked(stateObject);
        if (stateRecordUsedLocked != null) {
            stateRecordUsedLocked.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return stateRecordUsedLocked;
        }
        StateRecord stateRecordCreate = stateRecord.create();
        stateRecordCreate.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        stateRecordCreate.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(stateRecordCreate, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        stateObject.prependStateRecord(stateRecordCreate);
        Intrinsics.checkNotNull(stateRecordCreate, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return stateRecordCreate;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1 writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i;
        Map map;
        Map map2;
        int i2;
        MutableScatterSet modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        Map map3 = null;
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetOr = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        Object[] objArr = modified$runtime_release.elements;
        long[] jArr2 = modified$runtime_release.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return null;
        }
        HashMap map4 = null;
        int i3 = 0;
        while (true) {
            long j = jArr2[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                int i6 = 0;
                while (i6 < i5) {
                    if ((255 & j) < 128) {
                        StateObject stateObject = (StateObject) objArr[(i3 << 3) + i6];
                        StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                        map2 = map3;
                        StateRecord stateRecord = readable(firstStateRecord, id, snapshotIdSet);
                        if (stateRecord == null) {
                            i2 = i4;
                        } else {
                            i2 = i4;
                            StateRecord stateRecord2 = readable(firstStateRecord, id, snapshotIdSetOr);
                            if (stateRecord2 != null && !Intrinsics.areEqual(stateRecord, stateRecord2)) {
                                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                                if (stateRecord3 == null) {
                                    readError();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord2, stateRecord, stateRecord3);
                                if (stateRecordMergeRecords == null) {
                                    return map2;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(stateRecord, stateRecordMergeRecords);
                                map4 = map4;
                            }
                        }
                    } else {
                        map2 = map3;
                        i2 = i4;
                    }
                    j >>= i2;
                    i6++;
                    map3 = map2;
                    i4 = i2;
                    jArr2 = jArr2;
                    id = id;
                }
                jArr = jArr2;
                i = id;
                map = map3;
                if (i5 != i4) {
                    return map4;
                }
            } else {
                jArr = jArr2;
                i = id;
                map = map3;
            }
            if (i3 == length) {
                return map4;
            }
            i3++;
            map3 = map;
            jArr2 = jArr;
            id = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    public static final StateRecord current(StateRecord stateRecord, Snapshot snapshot) {
        StateRecord stateRecord2 = readable(stateRecord, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final StateRecord current(StateRecord stateRecord) {
        StateRecord stateRecord2;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        StateRecord stateRecord3 = readable(stateRecord, current.getId(), current.getInvalid$runtime_release());
        if (stateRecord3 != null) {
            return stateRecord3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            stateRecord2 = readable(stateRecord, current2.getId(), current2.getInvalid$runtime_release());
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }
}
