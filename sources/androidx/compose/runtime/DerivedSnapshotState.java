package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class DerivedSnapshotState extends StateObjectImpl implements DerivedState {
    private final Function0 calculation;
    private ResultRecord first = new ResultRecord();
    private final SnapshotMutationPolicy policy;

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy getPolicy() {
        return this.policy;
    }

    public DerivedSnapshotState(Function0 function0, SnapshotMutationPolicy snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    public static final class ResultRecord extends StateRecord implements DerivedState.Record {
        private ObjectIntMap dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object getCurrentValue() {
            return this.result;
        }

        public final boolean isValid(DerivedState derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            synchronized (SnapshotKt.getLock()) {
                z = true;
                z2 = (this.validSnapshotId == snapshot.getId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) ? false : true;
            }
            if (this.result == Unset || (z2 && this.resultHash != readableHash(derivedState, snapshot))) {
                z = false;
            }
            if (!z || !z2) {
                return z;
            }
            synchronized (SnapshotKt.getLock()) {
                this.validSnapshotId = snapshot.getId();
                this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00bc  */
        public final int readableHash(DerivedState derivedState, Snapshot snapshot) {
            ObjectIntMap dependencies;
            int iIdentityHashCode;
            int size;
            Object[] content;
            int i;
            int i2;
            StateRecord stateRecordCurrent;
            synchronized (SnapshotKt.getLock()) {
                dependencies = getDependencies();
            }
            int i3 = 7;
            if (!dependencies.isNotEmpty()) {
                return 7;
            }
            MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size2 = mutableVectorDerivedStateObservers.getSize();
            if (size2 > 0) {
                Object[] content2 = mutableVectorDerivedStateObservers.getContent();
                int i4 = 0;
                do {
                    ((DerivedStateObserver) content2[i4]).start(derivedState);
                    i4++;
                } while (i4 < size2);
            }
            try {
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    iIdentityHashCode = 7;
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << i3) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8;
                            int i7 = 8 - ((~(i5 - length)) >>> 31);
                            int i8 = 0;
                            while (i8 < i7) {
                                if ((j & 255) < 128) {
                                    int i9 = (i5 << 3) + i8;
                                    Object obj = objArr[i9];
                                    int i10 = iArr[i9];
                                    i2 = i6;
                                    StateObject stateObject = (StateObject) obj;
                                    if (i10 == 1) {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            stateRecordCurrent = ((DerivedSnapshotState) stateObject).current(snapshot);
                                        } else {
                                            stateRecordCurrent = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                                        }
                                        iIdentityHashCode = (((iIdentityHashCode * 31) + ActualJvm_jvmKt.identityHashCode(stateRecordCurrent)) * 31) + stateRecordCurrent.getSnapshotId$runtime_release();
                                    }
                                } else {
                                    i2 = i6;
                                }
                                j >>= i2;
                                i8++;
                                i6 = i2;
                            }
                            if (i7 != i6) {
                                break;
                            }
                        }
                        if (i5 != length) {
                            i5++;
                            i3 = i3;
                        } else {
                            i3 = iIdentityHashCode;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    size = mutableVectorDerivedStateObservers.getSize();
                    if (size > 0) {
                        content = mutableVectorDerivedStateObservers.getContent();
                        i = 0;
                        do {
                            ((DerivedStateObserver) content[i]).done(derivedState);
                            i++;
                        } while (i < size);
                    }
                    return iIdentityHashCode;
                }
                iIdentityHashCode = i3;
                Unit unit2 = Unit.INSTANCE;
                size = mutableVectorDerivedStateObservers.getSize();
                if (size > 0) {
                    content = mutableVectorDerivedStateObservers.getContent();
                    i = 0;
                    do {
                        ((DerivedStateObserver) content[i]).done(derivedState);
                        i++;
                    } while (i < size);
                }
                return iIdentityHashCode;
            } catch (Throwable th) {
                int size3 = mutableVectorDerivedStateObservers.getSize();
                if (size3 > 0) {
                    Object[] content3 = mutableVectorDerivedStateObservers.getContent();
                    int i11 = 0;
                    do {
                        ((DerivedStateObserver) content3[i11]).done(derivedState);
                        i11++;
                    } while (i11 < size3);
                }
                throw th;
            }
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    private final ResultRecord currentRecord(ResultRecord resultRecord, Snapshot snapshot, boolean z, Function0 function0) throws Throwable {
        Snapshot.Companion companion;
        SnapshotMutationPolicy policy;
        int i;
        ResultRecord resultRecord2 = resultRecord;
        boolean z2 = true;
        if (!resultRecord2.isValid(this, snapshot)) {
            int i2 = 0;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
            final IntRef intRef = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if (intRef == null) {
                intRef = new IntRef(0);
                SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef);
            }
            final int element = intRef.getElement();
            MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = mutableVectorDerivedStateObservers.getSize();
            if (size > 0) {
                Object[] content = mutableVectorDerivedStateObservers.getContent();
                int i3 = 0;
                do {
                    ((DerivedStateObserver) content[i3]).start(this);
                    i3++;
                } while (i3 < size);
            }
            try {
                intRef.setElement(element + 1);
                Object objObserve = Snapshot.Companion.observe(new Function1() { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m1066invoke(obj);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m1066invoke(Object obj) {
                        if (obj == this.this$0) {
                            throw new IllegalStateException("A derived state calculation cannot read itself");
                        }
                        if (obj instanceof StateObject) {
                            int element2 = intRef.getElement();
                            MutableObjectIntMap mutableObjectIntMap2 = mutableObjectIntMap;
                            mutableObjectIntMap2.set(obj, Math.min(element2 - element, mutableObjectIntMap2.getOrDefault(obj, Integer.MAX_VALUE)));
                        }
                    }
                }, null, function0);
                intRef.setElement(element);
                int size2 = mutableVectorDerivedStateObservers.getSize();
                if (size2 > 0) {
                    Object[] content2 = mutableVectorDerivedStateObservers.getContent();
                    do {
                        ((DerivedStateObserver) content2[i2]).done(this);
                        i2++;
                    } while (i2 < size2);
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        companion = Snapshot.Companion;
                        Snapshot current = companion.getCurrent();
                        if (resultRecord2.getResult() == ResultRecord.Companion.getUnset() || (policy = getPolicy()) == null || !policy.equivalent(objObserve, resultRecord2.getResult())) {
                            resultRecord2 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                            resultRecord2.setDependencies(mutableObjectIntMap);
                            resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
                            resultRecord2.setResult(objObserve);
                        } else {
                            resultRecord2.setDependencies(mutableObjectIntMap);
                            resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                IntRef intRef2 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                if (intRef2 == null || intRef2.getElement() != 0) {
                    return resultRecord2;
                }
                companion.notifyObjectsInitialized();
                synchronized (SnapshotKt.getLock()) {
                    Snapshot current2 = companion.getCurrent();
                    resultRecord2.setValidSnapshotId(current2.getId());
                    resultRecord2.setValidSnapshotWriteCount(current2.getWriteCount$runtime_release());
                    Unit unit = Unit.INSTANCE;
                }
                return resultRecord2;
            } catch (Throwable th2) {
                int size3 = mutableVectorDerivedStateObservers.getSize();
                if (size3 > 0) {
                    Object[] content3 = mutableVectorDerivedStateObservers.getContent();
                    int i4 = 0;
                    do {
                        ((DerivedStateObserver) content3[i4]).done(this);
                        i4++;
                    } while (i4 < size3);
                }
                throw th2;
            }
        }
        if (z) {
            MutableVector mutableVectorDerivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
            int size4 = mutableVectorDerivedStateObservers2.getSize();
            if (size4 > 0) {
                Object[] content4 = mutableVectorDerivedStateObservers2.getContent();
                int i5 = 0;
                do {
                    ((DerivedStateObserver) content4[i5]).start(this);
                    i5++;
                } while (i5 < size4);
            }
            try {
                ObjectIntMap dependencies = resultRecord2.getDependencies();
                IntRef intRef3 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                if (intRef3 == null) {
                    intRef3 = new IntRef(0);
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef3);
                }
                int element2 = intRef3.getElement();
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j = jArr[i6];
                        boolean z3 = z2;
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8;
                            int i8 = 8 - ((~(i6 - length)) >>> 31);
                            int i9 = 0;
                            while (i9 < i8) {
                                if ((j & 255) < 128) {
                                    int i10 = (i6 << 3) + i9;
                                    try {
                                        i = i7;
                                        StateObject stateObject = (StateObject) objArr[i10];
                                        intRef3.setElement(element2 + iArr[i10]);
                                        Function1 readObserver = snapshot.getReadObserver();
                                        if (readObserver != null) {
                                            readObserver.invoke(stateObject);
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        int size5 = mutableVectorDerivedStateObservers2.getSize();
                                        if (size5 > 0) {
                                            Object[] content5 = mutableVectorDerivedStateObservers2.getContent();
                                            int i11 = 0;
                                            do {
                                                ((DerivedStateObserver) content5[i11]).done(this);
                                                i11++;
                                            } while (i11 < size5);
                                        }
                                        throw th;
                                    }
                                } else {
                                    i = i7;
                                }
                                j >>= i;
                                i9++;
                                i7 = i;
                            }
                            if (i8 != i7) {
                                break;
                            }
                        }
                        if (i6 == length) {
                            break;
                        }
                        i6++;
                        z2 = z3;
                    }
                }
                intRef3.setElement(element2);
                Unit unit2 = Unit.INSTANCE;
                int size6 = mutableVectorDerivedStateObservers2.getSize();
                if (size6 > 0) {
                    Object[] content6 = mutableVectorDerivedStateObservers2.getContent();
                    int i12 = 0;
                    do {
                        ((DerivedStateObserver) content6[i12]).done(this);
                        i12++;
                    } while (i12 < size6);
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return resultRecord2;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        Snapshot.Companion companion = Snapshot.Companion;
        Function1 readObserver = companion.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = companion.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record getCurrentRecord() {
        Snapshot current = Snapshot.Companion.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, false, this.calculation);
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(resultRecord.getResult());
        }
        return "<Not calculated>";
    }
}
