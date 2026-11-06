package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List merged;
    private MutableScatterSet modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1 readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1 writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: getReadObserver$runtime_release */
    public Function1 getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function2) {
        super(i, snapshotIdSet, null);
        this.readObserver = function1;
        this.writeObserver = function2;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1 function1, Function1 function2) throws Throwable {
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            try {
                int i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
                SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
                setInvalid$runtime_release(invalid$runtime_release.set(i));
                try {
                    NestedMutableSnapshot nestedMutableSnapshot = new NestedMutableSnapshot(i, SnapshotKt.addRange(invalid$runtime_release, getId() + 1, i), SnapshotKt.mergedReadObserver$default(function1, getReadObserver(), false, 4, null), SnapshotKt.mergedWriteObserver(function2, getWriteObserver$runtime_release()), this);
                    if (getApplied$runtime_release() || getDisposed$runtime_release()) {
                        return nestedMutableSnapshot;
                    }
                    int id = getId();
                    synchronized (SnapshotKt.getLock()) {
                        int i2 = SnapshotKt.nextSnapshotId;
                        SnapshotKt.nextSnapshotId = i2 + 1;
                        setId$runtime_release(i2);
                        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                        Unit unit = Unit.INSTANCE;
                    }
                    setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
                    return nestedMutableSnapshot;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x018b A[EDGE_INSN: B:102:0x018b->B:77:0x018b BREAK  A[LOOP:4: B:66:0x015c->B:76:0x0188], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0149 A[Catch: all -> 0x013e, LOOP:2: B:48:0x0116->B:60:0x0149, LOOP_END, TryCatch #1 {all -> 0x013e, blocks: (B:43:0x00fa, B:45:0x010a, B:48:0x0116, B:50:0x0122, B:52:0x012c, B:54:0x0132, B:57:0x0141, B:63:0x0152, B:66:0x015c, B:68:0x0166, B:70:0x0170, B:72:0x0176, B:73:0x0180, B:76:0x0188, B:77:0x018b, B:79:0x018f, B:81:0x0196, B:82:0x01a2, B:60:0x0149), top: B:92:0x00fa }] */
    /* JADX WARN: Code duplicated, block: B:61:0x014c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0186 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0188 A[Catch: all -> 0x013e, LOOP:4: B:66:0x015c->B:76:0x0188, LOOP_END, TryCatch #1 {all -> 0x013e, blocks: (B:43:0x00fa, B:45:0x010a, B:48:0x0116, B:50:0x0122, B:52:0x012c, B:54:0x0132, B:57:0x0141, B:63:0x0152, B:66:0x015c, B:68:0x0166, B:70:0x0170, B:72:0x0176, B:73:0x0180, B:76:0x0188, B:77:0x018b, B:79:0x018f, B:81:0x0196, B:82:0x01a2, B:60:0x0149), top: B:92:0x00fa }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0150 A[EDGE_INSN: B:97:0x0150->B:62:0x0150 BREAK  A[LOOP:2: B:48:0x0116->B:60:0x0149], SYNTHETIC] */
    public SnapshotApplyResult apply() {
        MutableScatterSet modified$runtime_release;
        long j;
        long j2;
        MutableScatterSet modified$runtime_release2 = getModified$runtime_release();
        Map mapOptimisticMerges = modified$runtime_release2 != null ? SnapshotKt.optimisticMerges((MutableSnapshot) SnapshotKt.currentGlobalSnapshot.get(), this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId())) : null;
        List listEmptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release2 == null || modified$runtime_release2.getSize() == 0) {
                    closeLocked$runtime_release();
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot.getModified$runtime_release();
                    if (modified$runtime_release == null || !modified$runtime_release.isNotEmpty()) {
                        modified$runtime_release = null;
                    } else {
                        listEmptyList = SnapshotKt.applyObservers;
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(globalSnapshot2.getId()));
                    if (!Intrinsics.areEqual(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return snapshotApplyResultInnerApplyLocked$runtime_release;
                    }
                    closeLocked$runtime_release();
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot2.getModified$runtime_release();
                    setModified(null);
                    globalSnapshot2.setModified(null);
                    listEmptyList = SnapshotKt.applyObservers;
                }
                Unit unit = Unit.INSTANCE;
                this.applied = true;
                if (modified$runtime_release != null) {
                    Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                    if (!setWrapIntoSet.isEmpty()) {
                        int size = listEmptyList.size();
                        for (int i = 0; i < size; i++) {
                            ((Function2) listEmptyList.get(i)).invoke(setWrapIntoSet, this);
                        }
                    }
                }
                if (modified$runtime_release2 != null && modified$runtime_release2.isNotEmpty()) {
                    Set setWrapIntoSet2 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release2);
                    int size2 = listEmptyList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((Function2) listEmptyList.get(i2)).invoke(setWrapIntoSet2, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (modified$runtime_release != null) {
                            Object[] objArr = modified$runtime_release.elements;
                            long[] jArr = modified$runtime_release.metadata;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                j = 128;
                                while (true) {
                                    long j3 = jArr[i3];
                                    j2 = 255;
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i3 != length) {
                                            break;
                                            break;
                                        }
                                        i3++;
                                    } else {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((j3 & 255) < 128) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i3 << 3) + i5]);
                                            }
                                            j3 >>= 8;
                                        }
                                        if (i4 != 8) {
                                            break;
                                        }
                                        if (i3 != length) {
                                            break;
                                        }
                                        i3++;
                                    }
                                }
                            } else {
                                j = 128;
                                j2 = 255;
                            }
                        } else {
                            j = 128;
                            j2 = 255;
                        }
                        if (modified$runtime_release2 != null) {
                            Object[] objArr2 = modified$runtime_release2.elements;
                            long[] jArr2 = modified$runtime_release2.metadata;
                            int length2 = jArr2.length - 2;
                            if (length2 >= 0) {
                                int i6 = 0;
                                while (true) {
                                    long j4 = jArr2[i6];
                                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i6 != length2) {
                                            break;
                                            break;
                                        }
                                        i6++;
                                    } else {
                                        int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                        for (int i8 = 0; i8 < i7; i8++) {
                                            if ((j4 & j2) < j) {
                                                SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i6 << 3) + i8]);
                                            }
                                            j4 >>= 8;
                                        }
                                        if (i7 != 8) {
                                            break;
                                        }
                                        if (i6 != length2) {
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                            }
                        }
                        List list = this.merged;
                        if (list != null) {
                            int size3 = list.size();
                            for (int i9 = 0; i9 < size3; i9++) {
                                SnapshotKt.processForUnusedRecordsLocked((StateObject) list.get(i9));
                            }
                        }
                        this.merged = null;
                        Unit unit2 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return SnapshotApplyResult.Success.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        mo1108nestedDeactivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1 function1) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, i), SnapshotKt.mergedReadObserver$default(function1, getReadObserver(), false, 4, null), this);
        }
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return nestedReadonlySnapshot;
        }
        int id2 = getId();
        synchronized (SnapshotKt.getLock()) {
            int i2 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i2 + 1;
            setId$runtime_release(i2);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
            Unit unit = Unit.INSTANCE;
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo1107nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo1108nestedDeactivated$runtime_release(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed$runtime_release()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!this.applied || ((Snapshot) this).pinningTrackingHandle >= 0) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0074 A[LOOP:0: B:7:0x001c->B:24:0x0074, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0077 A[EDGE_INSN: B:28:0x0077->B:25:0x0077 BREAK  A[LOOP:0: B:7:0x001c->B:24:0x0074], SYNTHETIC] */
    private final void abandon() {
        MutableScatterSet modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] objArr = modified$runtime_release.elements;
            long[] jArr = modified$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i << 3) + i3]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                                    if (firstStateRecord.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                                        firstStateRecord.setSnapshotId$runtime_release(0);
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int i, Map map, SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3;
        Object[] objArr2;
        long[] jArr2;
        int i2;
        StateRecord stateRecord;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSetOr = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        MutableScatterSet modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] objArr3 = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        List listPlus = null;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr3[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            StateObject stateObject = (StateObject) objArr3[(i3 << 3) + i6];
                            i2 = i4;
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            ArrayList arrayList2 = arrayList;
                            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, i, snapshotIdSet);
                            if (stateRecord2 == null || (stateRecord = SnapshotKt.readable(firstStateRecord, getId(), snapshotIdSetOr)) == null) {
                                snapshotIdSet3 = snapshotIdSetOr;
                            } else {
                                snapshotIdSet3 = snapshotIdSetOr;
                                if (stateRecord.getSnapshotId$runtime_release() != 1 && !Intrinsics.areEqual(stateRecord2, stateRecord)) {
                                    StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                                    if (stateRecord3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (map == null || (stateRecordMergeRecords = (StateRecord) map.get(stateRecord2)) == null) {
                                        stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                                    }
                                    if (stateRecordMergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord3)) {
                                        if (Intrinsics.areEqual(stateRecordMergeRecords, stateRecord2)) {
                                            ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                                            arrayList3.add(TuplesKt.to(stateObject, stateRecord2.create()));
                                            if (listPlus == null) {
                                                listPlus = new ArrayList();
                                            }
                                            listPlus.add(stateObject);
                                            arrayList = arrayList3;
                                        } else {
                                            arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                                            arrayList.add(!Intrinsics.areEqual(stateRecordMergeRecords, stateRecord) ? TuplesKt.to(stateObject, stateRecordMergeRecords) : TuplesKt.to(stateObject, stateRecord.create()));
                                        }
                                    }
                                }
                            }
                            arrayList = arrayList2;
                        } else {
                            snapshotIdSet3 = snapshotIdSetOr;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i2 = i4;
                        }
                        j >>= i2;
                        i6++;
                        i4 = i2;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        snapshotIdSetOr = snapshotIdSet3;
                    }
                    snapshotIdSet2 = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    snapshotIdSet2 = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                objArr3 = objArr;
                jArr3 = jArr;
                snapshotIdSetOr = snapshotIdSet2;
            }
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                Pair pair = (Pair) arrayList.get(i7);
                StateObject stateObject2 = (StateObject) pair.getFirst();
                StateRecord stateRecord4 = (StateRecord) pair.getSecond();
                stateRecord4.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (listPlus != null) {
            int size2 = listPlus.size();
            for (int i8 = 0; i8 < size2; i8++) {
                modified$runtime_release.remove((StateObject) listPlus.get(i8));
            }
            List list = this.merged;
            if (list != null) {
                listPlus = CollectionsKt.plus((Collection) list, (Iterable) listPlus);
            }
            this.merged = listPlus;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.previousPinnedSnapshots;
        if (iArr2.length != 0) {
            iArr = ArraysKt.plus(iArr2, iArr);
        }
        this.previousPinnedSnapshots = iArr;
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo1110recordModified$runtime_release(StateObject stateObject) {
        MutableScatterSet modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public MutableScatterSet getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(MutableScatterSet mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void recordPrevious$runtime_release(int i) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }
}
