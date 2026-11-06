package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1 onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference pendingChanges = new AtomicReference(null);
    private final Function2 applyObserver = new Function2() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Set) obj, (Snapshot) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(Set set, Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };
    private final Function1 readObserver = new Function1() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1114invoke(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1114invoke(Object obj) {
            if (this.this$0.isPaused) {
                return;
            }
            MutableVector mutableVector = this.this$0.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (mutableVector) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final MutableVector observedScopeMaps = new MutableVector(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    public SnapshotStateObserver(Function1 function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        int i = 0;
                        do {
                            z2 = ((ObservedScopeMap) content[i]).recordInvalidation(setRemoveChanges) || z2;
                            i++;
                        } while (i < size);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1115invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1115invoke() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        try {
                            if (!snapshotStateObserver.sendingNotifications) {
                                snapshotStateObserver.sendingNotifications = true;
                                try {
                                    MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                    int size = mutableVector2.getSize();
                                    if (size > 0) {
                                        Object[] content = mutableVector2.getContent();
                                        int i = 0;
                                        do {
                                            ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                            i++;
                                        } while (i < size);
                                    }
                                    snapshotStateObserver.sendingNotifications = false;
                                } catch (Throwable th) {
                                    snapshotStateObserver.sendingNotifications = false;
                                    throw th;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set set) {
        Object obj;
        List listPlus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, listPlus));
    }

    private final Set removeChanges() {
        Object obj;
        Object objSubList;
        Set set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        ((ObservedScopeMap) content[i]).clear();
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clear(Object obj) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                    observedScopeMap.clearScopeObservations(obj);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(Function1 function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                    observedScopeMap.removeScopeIf(function1);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void observeReads(Object obj, Function1 function1, Function0 function0) {
        ObservedScopeMap observedScopeMapEnsureMap;
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(function1);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j != -1) {
            if (!(j == ActualJvm_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            observedScopeMapEnsureMap.observe(obj, this.readObserver, function0);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
            this.currentMapThreadId = j;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    private final ObservedScopeMap ensureMap(Function1 function1) {
        Object obj;
        MutableVector mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size <= 0) {
            obj = null;
            break;
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        while (true) {
            obj = content[i];
            if (((ObservedScopeMap) obj).getOnChanged() == function1) {
                break;
            }
            i++;
            if (i >= size) {
                obj = null;
                break;
            }
        }
        ObservedScopeMap observedScopeMap = (ObservedScopeMap) obj;
        if (observedScopeMap != null) {
            return observedScopeMap;
        }
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap2 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
        this.observedScopeMaps.add(observedScopeMap2);
        return observedScopeMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap currentScopeReads;
        private int deriveStateScopeCount;
        private final Function1 onChanged;
        private int currentToken = -1;
        private final ScopeMap valueToScopes = new ScopeMap();
        private final MutableScatterMap scopeToValues = new MutableScatterMap(0, 1, null);
        private final MutableScatterSet invalidated = new MutableScatterSet(0, 1, null);
        private final MutableVector statesToReread = new MutableVector(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState derivedState) {
                this.this$0.deriveStateScopeCount--;
            }
        };
        private final ScopeMap dependencyToDerivedStates = new ScopeMap();
        private final HashMap recordedDerivedStateValues = new HashMap();

        public ObservedScopeMap(Function1 function1) {
            this.onChanged = function1;
        }

        public final Function1 getOnChanged() {
            return this.onChanged;
        }

        public final void recordRead(Object obj) {
            Object obj2 = this.currentScope;
            Intrinsics.checkNotNull(obj2);
            int i = this.currentToken;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj2, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(obj, i, obj2, mutableObjectIntMap);
        }

        private final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap mutableObjectIntMap) {
            int i2;
            int i3;
            int i4;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iPut = mutableObjectIntMap.put(obj, i, -1);
            int i5 = 2;
            if (!(obj instanceof DerivedState) || iPut == i) {
                i2 = 2;
                i3 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.getCurrentValue());
                ObjectIntMap dependencies = currentRecord.getDependencies();
                ScopeMap scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(obj);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j = jArr[i6];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8 - ((~(i6 - length)) >>> 31);
                            int i8 = 0;
                            while (i8 < i7) {
                                if ((j & 255) < 128) {
                                    i4 = i5;
                                    StateObject stateObject = (StateObject) objArr[(i6 << 3) + i8];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m1117recordReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(i4));
                                    }
                                    scopeMap.add(stateObject, obj);
                                } else {
                                    i4 = i5;
                                }
                                j >>= 8;
                                i8++;
                                i5 = i4;
                            }
                            i2 = i5;
                            if (i7 != 8) {
                                break;
                            }
                        } else {
                            i2 = i5;
                        }
                        if (i6 == length) {
                            break;
                        }
                        i6++;
                        i5 = i2;
                    }
                } else {
                    i2 = 2;
                }
                i3 = -1;
            }
            if (iPut == i3) {
                if (obj instanceof StateObjectImpl) {
                    ((StateObjectImpl) obj).m1117recordReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(i2));
                }
                this.valueToScopes.add(obj, obj2);
            }
        }

        public final void observe(Object obj, Function1 function1, Function0 function0) {
            Object obj2 = this.currentScope;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = (MutableObjectIntMap) this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion.observe(function1, null, function0);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj3 = this.currentScope;
                Intrinsics.checkNotNull(obj3);
                clearObsoleteStateReads(obj3);
                this.currentScope = obj2;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            MutableObjectIntMap mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj2 = mutableObjectIntMap.keys[i5];
                            boolean z = mutableObjectIntMap.values[i5] != i;
                            if (z) {
                                removeObservation(obj, obj2);
                            }
                            if (z) {
                                mutableObjectIntMap.removeValueAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return;
                    }
                }
                if (i2 == length) {
                    return;
                } else {
                    i2++;
                }
            }
        }

        public final void clearScopeObservations(Object obj) {
            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.scopeToValues.remove(obj);
            if (mutableObjectIntMap == null) {
                return;
            }
            Object[] objArr = mutableObjectIntMap.keys;
            int[] iArr = mutableObjectIntMap.values;
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj2 = objArr[i4];
                            int i5 = iArr[i4];
                            removeObservation(obj, obj2);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:27:0x009d A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x009f A[LOOP:2: B:16:0x0066->B:28:0x009f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ac A[EDGE_INSN: B:49:0x00ac->B:30:0x00ac BREAK  A[LOOP:2: B:16:0x0066->B:28:0x009f], SYNTHETIC] */
        public final void removeScopeIf(Function1 function1) {
            long[] jArr;
            long[] jArr2;
            long j;
            char c;
            long j2;
            int i;
            MutableScatterMap mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                long j3 = jArr3[i2];
                char c2 = 7;
                long j4 = -9187201950435737472L;
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j3 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c = c2;
                            Object obj = mutableScatterMap.keys[i6];
                            j2 = j4;
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i6];
                            Boolean bool = (Boolean) function1.invoke(obj);
                            if (bool.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int i7 = i3;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    jArr2 = jArr3;
                                    j = j3;
                                    int i8 = 0;
                                    while (true) {
                                        long j5 = jArr4[i8];
                                        long[] jArr5 = jArr4;
                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                            int i9 = 8 - ((~(i8 - length2)) >>> 31);
                                            for (int i10 = 0; i10 < i9; i10++) {
                                                if ((j5 & 255) < 128) {
                                                    int i11 = (i8 << 3) + i10;
                                                    Object obj2 = objArr[i11];
                                                    int i12 = iArr[i11];
                                                    removeObservation(obj, obj2);
                                                }
                                                j5 >>= i7;
                                            }
                                            if (i9 != i7) {
                                                break;
                                            }
                                            if (i8 != length2) {
                                                break;
                                            }
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        } else if (i8 != length2) {
                                            break;
                                            break;
                                        } else {
                                            i8++;
                                            jArr4 = jArr5;
                                            i7 = 8;
                                        }
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j = j3;
                                }
                            } else {
                                jArr2 = jArr3;
                                j = j3;
                            }
                            if (bool.booleanValue()) {
                                mutableScatterMap.removeValueAt(i6);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr3;
                            j = j3;
                            c = c2;
                            j2 = j4;
                            i = i3;
                        }
                        i5++;
                        i3 = i;
                        j3 = j >> i;
                        c2 = c;
                        j4 = j2;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i4 != i3) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i2 == length) {
                    return;
                }
                i2++;
                jArr3 = jArr;
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if (!(obj2 instanceof DerivedState) || this.valueToScopes.contains(obj2)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0243  */
        /* JADX WARN: Code duplicated, block: B:118:0x029d A[DONT_INVERT, PHI: r11
          0x029d: PHI (r11v42 boolean) = (r11v41 boolean), (r11v43 boolean) binds: [B:109:0x0274, B:117:0x029b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:119:0x029f A[LOOP:6: B:108:0x026a->B:119:0x029f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:177:0x040a A[DONT_INVERT, PHI: r13
          0x040a: PHI (r13v5 boolean) = (r13v4 boolean), (r13v7 boolean) binds: [B:168:0x03dd, B:176:0x0408] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:178:0x040c A[LOOP:14: B:167:0x03cf->B:178:0x040c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:214:0x04c9 A[DONT_INVERT, PHI: r11
          0x04c9: PHI (r11v14 boolean) = (r11v13 boolean), (r11v15 boolean) binds: [B:205:0x04a0, B:213:0x04c7] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:215:0x04cb A[LOOP:18: B:204:0x0496->B:215:0x04cb, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:218:0x04da  */
        /* JADX WARN: Code duplicated, block: B:262:0x015f A[EDGE_INSN: B:262:0x015f->B:59:0x015f BREAK  A[LOOP:4: B:46:0x011a->B:58:0x0156], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:267:0x02a7 A[EDGE_INSN: B:267:0x02a7->B:121:0x02a7 BREAK  A[LOOP:6: B:108:0x026a->B:119:0x029f], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:271:0x024f A[EDGE_INSN: B:271:0x024f->B:101:0x024f BREAK  A[LOOP:8: B:86:0x01ff->B:97:0x0234], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:286:0x0413 A[EDGE_INSN: B:286:0x0413->B:179:0x0413 BREAK  A[LOOP:14: B:167:0x03cf->B:178:0x040c], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:294:0x04de A[EDGE_INSN: B:294:0x04de->B:219:0x04de BREAK  A[LOOP:18: B:204:0x0496->B:215:0x04cb], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x0154 A[DONT_INVERT, PHI: r39
          0x0154: PHI (r39v2 boolean) = (r39v1 boolean), (r39v4 boolean) binds: [B:47:0x0128, B:56:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:58:0x0156 A[LOOP:4: B:46:0x011a->B:58:0x0156, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:96:0x0232 A[DONT_INVERT, PHI: r11
          0x0232: PHI (r11v51 boolean) = (r11v50 boolean), (r11v52 boolean) binds: [B:87:0x0209, B:95:0x0230] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:97:0x0234 A[LOOP:8: B:86:0x01ff->B:97:0x0234, LOOP_END] */
        public final boolean recordInvalidation(Set set) {
            boolean z;
            Iterator it;
            ScopeMap scopeMap;
            Object obj;
            long[] jArr;
            Iterator it2;
            ScopeMap scopeMap2;
            long[] jArr2;
            long[] jArr3;
            ScopeMap scopeMap3;
            Object[] objArr;
            String str;
            int i;
            ScopeMap scopeMap4;
            Object[] objArr2;
            String str2;
            int i2;
            int i3;
            long j;
            int i4;
            int i5;
            Object obj2;
            Object[] objArr3;
            int i6;
            long j2;
            ScopeMap scopeMap5 = this.dependencyToDerivedStates;
            HashMap map = this.recordedDerivedStateValues;
            ScopeMap scopeMap6 = this.valueToScopes;
            MutableScatterSet mutableScatterSet = this.invalidated;
            String str3 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            int i7 = 8;
            int i8 = 0;
            if (set instanceof ScatterSetWrapper) {
                ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
                Object[] objArr4 = set$runtime_release.elements;
                long[] jArr4 = set$runtime_release.metadata;
                int length = jArr4.length - 2;
                if (length >= 0) {
                    int i9 = 0;
                    z = false;
                    while (true) {
                        long j3 = jArr4[i9];
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i10 = 8 - ((~(i9 - length)) >>> 31);
                            int i11 = 0;
                            while (i11 < i10) {
                                if ((j3 & 255) < 128) {
                                    int i12 = i7;
                                    Object obj3 = objArr4[(i9 << 3) + i11];
                                    if (obj3 instanceof StateObjectImpl) {
                                        scopeMap4 = scopeMap6;
                                        if (!((StateObjectImpl) obj3).m1116isReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(2))) {
                                            objArr2 = objArr4;
                                            str2 = str3;
                                            i2 = length;
                                            i3 = i9;
                                            j = j3;
                                            i4 = i10;
                                        }
                                        i5 = 8;
                                    } else {
                                        scopeMap4 = scopeMap6;
                                    }
                                    if (!scopeMap5.contains(obj3) || (obj2 = scopeMap5.getMap().get(obj3)) == null) {
                                        objArr2 = objArr4;
                                        str2 = str3;
                                        i2 = length;
                                        i3 = i9;
                                        j = j3;
                                        i4 = i10;
                                    } else if (obj2 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj2;
                                        Object[] objArr5 = mutableScatterSet2.elements;
                                        long[] jArr5 = mutableScatterSet2.metadata;
                                        int length2 = jArr5.length - 2;
                                        if (length2 >= 0) {
                                            j = j3;
                                            int i13 = 0;
                                            boolean z2 = z;
                                            while (true) {
                                                long j4 = jArr5[i13];
                                                i2 = length;
                                                i3 = i9;
                                                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i14 = 8 - ((~(i13 - length2)) >>> 31);
                                                    int i15 = 0;
                                                    while (i15 < i14) {
                                                        if ((j4 & 255) < 128) {
                                                            objArr3 = objArr4;
                                                            DerivedState derivedState = (DerivedState) objArr5[(i13 << 3) + i15];
                                                            Intrinsics.checkNotNull(derivedState, str3);
                                                            i6 = i15;
                                                            Object obj4 = map.get(derivedState);
                                                            SnapshotMutationPolicy policy = derivedState.getPolicy();
                                                            if (policy == null) {
                                                                policy = SnapshotStateKt.structuralEqualityPolicy();
                                                            }
                                                            j2 = j4;
                                                            if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj4)) {
                                                                str3 = str3;
                                                                this.statesToReread.add(derivedState);
                                                            } else {
                                                                Object obj5 = scopeMap4.getMap().get(derivedState);
                                                                if (obj5 != null) {
                                                                    if (obj5 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj5;
                                                                        Object[] objArr6 = mutableScatterSet3.elements;
                                                                        long[] jArr6 = mutableScatterSet3.metadata;
                                                                        int length3 = jArr6.length - 2;
                                                                        if (length3 >= 0) {
                                                                            boolean z3 = z2;
                                                                            int i16 = 0;
                                                                            while (true) {
                                                                                long j5 = jArr6[i16];
                                                                                long[] jArr7 = jArr6;
                                                                                str3 = str3;
                                                                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                                    if (i16 != length3) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    i16++;
                                                                                    str3 = str3;
                                                                                    jArr6 = jArr7;
                                                                                    i12 = 8;
                                                                                } else {
                                                                                    int i17 = 8 - ((~(i16 - length3)) >>> 31);
                                                                                    for (int i18 = 0; i18 < i17; i18++) {
                                                                                        if ((j5 & 255) < 128) {
                                                                                            mutableScatterSet.add(objArr6[(i16 << 3) + i18]);
                                                                                            z3 = true;
                                                                                        }
                                                                                        j5 >>= i12;
                                                                                    }
                                                                                    if (i17 != i12) {
                                                                                        break;
                                                                                    }
                                                                                    if (i16 != length3) {
                                                                                        break;
                                                                                    }
                                                                                    i16++;
                                                                                    str3 = str3;
                                                                                    jArr6 = jArr7;
                                                                                    i12 = 8;
                                                                                }
                                                                            }
                                                                            z2 = z3;
                                                                        }
                                                                    } else {
                                                                        str3 = str3;
                                                                        mutableScatterSet.add(obj5);
                                                                        z2 = true;
                                                                    }
                                                                }
                                                            }
                                                            j4 = j2 >> 8;
                                                            i15 = i6 + 1;
                                                            i12 = 8;
                                                            objArr4 = objArr3;
                                                            i10 = i10;
                                                            str3 = str3;
                                                        } else {
                                                            objArr3 = objArr4;
                                                            i6 = i15;
                                                            j2 = j4;
                                                        }
                                                        j4 = j2 >> 8;
                                                        i15 = i6 + 1;
                                                        i12 = 8;
                                                        objArr4 = objArr3;
                                                        i10 = i10;
                                                        str3 = str3;
                                                    }
                                                    objArr2 = objArr4;
                                                    str2 = str3;
                                                    i4 = i10;
                                                    if (i14 != i12) {
                                                        break;
                                                    }
                                                } else {
                                                    objArr2 = objArr4;
                                                    str2 = str3;
                                                    i4 = i10;
                                                }
                                                if (i13 == length2) {
                                                    break;
                                                }
                                                i13++;
                                                length = i2;
                                                i9 = i3;
                                                objArr4 = objArr2;
                                                i10 = i4;
                                                str3 = str2;
                                                i12 = 8;
                                            }
                                            z = z2;
                                        } else {
                                            objArr2 = objArr4;
                                            str2 = str3;
                                            i2 = length;
                                            i3 = i9;
                                            j = j3;
                                            i4 = i10;
                                        }
                                    } else {
                                        objArr2 = objArr4;
                                        str2 = str3;
                                        i2 = length;
                                        i3 = i9;
                                        j = j3;
                                        i4 = i10;
                                        DerivedState derivedState2 = (DerivedState) obj2;
                                        Object obj6 = map.get(derivedState2);
                                        SnapshotMutationPolicy policy2 = derivedState2.getPolicy();
                                        if (policy2 == null) {
                                            policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                        }
                                        if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj6)) {
                                            this.statesToReread.add(derivedState2);
                                        } else {
                                            Object obj7 = scopeMap4.getMap().get(derivedState2);
                                            if (obj7 != null) {
                                                if (obj7 instanceof MutableScatterSet) {
                                                    MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj7;
                                                    Object[] objArr7 = mutableScatterSet4.elements;
                                                    long[] jArr8 = mutableScatterSet4.metadata;
                                                    int length4 = jArr8.length - 2;
                                                    if (length4 >= 0) {
                                                        int i19 = 0;
                                                        while (true) {
                                                            long j6 = jArr8[i19];
                                                            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                if (i19 != length4) {
                                                                    break;
                                                                    break;
                                                                }
                                                                i19++;
                                                            } else {
                                                                int i20 = 8 - ((~(i19 - length4)) >>> 31);
                                                                for (int i21 = 0; i21 < i20; i21++) {
                                                                    if ((j6 & 255) < 128) {
                                                                        mutableScatterSet.add(objArr7[(i19 << 3) + i21]);
                                                                        z = true;
                                                                    }
                                                                    j6 >>= 8;
                                                                }
                                                                if (i20 != 8) {
                                                                    break;
                                                                }
                                                                if (i19 != length4) {
                                                                    break;
                                                                }
                                                                i19++;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    mutableScatterSet.add(obj7);
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                    Object obj8 = scopeMap4.getMap().get(obj3);
                                    if (obj8 != null) {
                                        if (obj8 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj8;
                                            Object[] objArr8 = mutableScatterSet5.elements;
                                            long[] jArr9 = mutableScatterSet5.metadata;
                                            int length5 = jArr9.length - 2;
                                            if (length5 >= 0) {
                                                int i22 = 0;
                                                while (true) {
                                                    long j7 = jArr9[i22];
                                                    if ((((~j7) << 7) & j7 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                        if (i22 != length5) {
                                                            break;
                                                            break;
                                                        }
                                                        i22++;
                                                    } else {
                                                        int i23 = 8 - ((~(i22 - length5)) >>> 31);
                                                        for (int i24 = 0; i24 < i23; i24++) {
                                                            if ((j7 & 255) < 128) {
                                                                mutableScatterSet.add(objArr8[(i22 << 3) + i24]);
                                                                z = true;
                                                            }
                                                            j7 >>= 8;
                                                        }
                                                        if (i23 != 8) {
                                                            break;
                                                        }
                                                        if (i22 != length5) {
                                                            break;
                                                        }
                                                        i22++;
                                                    }
                                                }
                                            }
                                        } else {
                                            mutableScatterSet.add(obj8);
                                            z = true;
                                        }
                                    }
                                    i5 = 8;
                                } else {
                                    scopeMap4 = scopeMap6;
                                    objArr2 = objArr4;
                                    str2 = str3;
                                    i2 = length;
                                    i3 = i9;
                                    j = j3;
                                    i4 = i10;
                                    i5 = i7;
                                }
                                j3 = j >> i5;
                                i11++;
                                i7 = i5;
                                jArr4 = jArr4;
                                scopeMap6 = scopeMap4;
                                length = i2;
                                i9 = i3;
                                objArr4 = objArr2;
                                i10 = i4;
                                str3 = str2;
                            }
                            jArr3 = jArr4;
                            scopeMap3 = scopeMap6;
                            objArr = objArr4;
                            str = str3;
                            int i25 = length;
                            int i26 = i9;
                            if (i10 != i7) {
                                break;
                            }
                            length = i25;
                            i = i26;
                        } else {
                            jArr3 = jArr4;
                            scopeMap3 = scopeMap6;
                            objArr = objArr4;
                            str = str3;
                            i = i9;
                        }
                        if (i == length) {
                            break;
                        }
                        i9 = i + 1;
                        jArr4 = jArr3;
                        scopeMap6 = scopeMap3;
                        objArr4 = objArr;
                        str3 = str;
                        i7 = 8;
                    }
                } else {
                    z = false;
                }
            } else {
                Iterator it3 = set.iterator();
                z = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (!(next instanceof StateObjectImpl) || ((StateObjectImpl) next).m1116isReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(2))) {
                        if (!scopeMap5.contains(next) || (obj = scopeMap5.getMap().get(next)) == null) {
                            it = it3;
                            scopeMap = scopeMap5;
                        } else if (obj instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj;
                            Object[] objArr9 = mutableScatterSet6.elements;
                            long[] jArr10 = mutableScatterSet6.metadata;
                            int length6 = jArr10.length - 2;
                            if (length6 >= 0) {
                                int i27 = 0;
                                while (true) {
                                    long j8 = jArr10[i27];
                                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i28 = 8 - ((~(i27 - length6)) >>> 31);
                                        int i29 = 0;
                                        while (i29 < i28) {
                                            if ((j8 & 255) < 128) {
                                                DerivedState derivedState3 = (DerivedState) objArr9[(i27 << 3) + i29];
                                                it2 = it3;
                                                Intrinsics.checkNotNull(derivedState3, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                                Object obj9 = map.get(derivedState3);
                                                SnapshotMutationPolicy policy3 = derivedState3.getPolicy();
                                                if (policy3 == null) {
                                                    policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                }
                                                scopeMap2 = scopeMap5;
                                                jArr2 = jArr10;
                                                if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj9)) {
                                                    this.statesToReread.add(derivedState3);
                                                } else {
                                                    Object obj10 = scopeMap6.getMap().get(derivedState3);
                                                    if (obj10 != null) {
                                                        if (obj10 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj10;
                                                            Object[] objArr10 = mutableScatterSet7.elements;
                                                            long[] jArr11 = mutableScatterSet7.metadata;
                                                            int length7 = jArr11.length - 2;
                                                            if (length7 >= 0) {
                                                                int i30 = 0;
                                                                boolean z4 = z;
                                                                while (true) {
                                                                    long j9 = jArr11[i30];
                                                                    long[] jArr12 = jArr11;
                                                                    Object[] objArr11 = objArr10;
                                                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                        if (i30 != length7) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        i30++;
                                                                        objArr10 = objArr11;
                                                                        jArr11 = jArr12;
                                                                    } else {
                                                                        int i31 = 8 - ((~(i30 - length7)) >>> 31);
                                                                        for (int i32 = 0; i32 < i31; i32++) {
                                                                            if ((j9 & 255) < 128) {
                                                                                mutableScatterSet.add(objArr11[(i30 << 3) + i32]);
                                                                                z4 = true;
                                                                            }
                                                                            j9 >>= 8;
                                                                        }
                                                                        if (i31 != 8) {
                                                                            break;
                                                                        }
                                                                        if (i30 != length7) {
                                                                            break;
                                                                        }
                                                                        i30++;
                                                                        objArr10 = objArr11;
                                                                        jArr11 = jArr12;
                                                                    }
                                                                }
                                                                z = z4;
                                                            }
                                                        } else {
                                                            mutableScatterSet.add(obj10);
                                                            z = true;
                                                        }
                                                    }
                                                }
                                                j8 >>= 8;
                                                i29++;
                                                it3 = it2;
                                                scopeMap5 = scopeMap2;
                                                jArr10 = jArr2;
                                            } else {
                                                it2 = it3;
                                                scopeMap2 = scopeMap5;
                                                jArr2 = jArr10;
                                            }
                                            j8 >>= 8;
                                            i29++;
                                            it3 = it2;
                                            scopeMap5 = scopeMap2;
                                            jArr10 = jArr2;
                                        }
                                        it = it3;
                                        scopeMap = scopeMap5;
                                        jArr = jArr10;
                                        if (i28 != 8) {
                                            break;
                                        }
                                    } else {
                                        it = it3;
                                        scopeMap = scopeMap5;
                                        jArr = jArr10;
                                    }
                                    if (i27 == length6) {
                                        break;
                                    }
                                    i27++;
                                    it3 = it;
                                    scopeMap5 = scopeMap;
                                    jArr10 = jArr;
                                }
                            } else {
                                it = it3;
                                scopeMap = scopeMap5;
                            }
                        } else {
                            it = it3;
                            scopeMap = scopeMap5;
                            DerivedState derivedState4 = (DerivedState) obj;
                            Object obj11 = map.get(derivedState4);
                            SnapshotMutationPolicy policy4 = derivedState4.getPolicy();
                            if (policy4 == null) {
                                policy4 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj11)) {
                                this.statesToReread.add(derivedState4);
                            } else {
                                Object obj12 = scopeMap6.getMap().get(derivedState4);
                                if (obj12 != null) {
                                    if (obj12 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj12;
                                        Object[] objArr12 = mutableScatterSet8.elements;
                                        long[] jArr13 = mutableScatterSet8.metadata;
                                        int length8 = jArr13.length - 2;
                                        if (length8 >= 0) {
                                            int i33 = 0;
                                            while (true) {
                                                long j10 = jArr13[i33];
                                                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                    if (i33 != length8) {
                                                        break;
                                                        break;
                                                    }
                                                    i33++;
                                                } else {
                                                    int i34 = 8 - ((~(i33 - length8)) >>> 31);
                                                    for (int i35 = 0; i35 < i34; i35++) {
                                                        if ((j10 & 255) < 128) {
                                                            mutableScatterSet.add(objArr12[(i33 << 3) + i35]);
                                                            z = true;
                                                        }
                                                        j10 >>= 8;
                                                    }
                                                    if (i34 != 8) {
                                                        break;
                                                    }
                                                    if (i33 != length8) {
                                                        break;
                                                    }
                                                    i33++;
                                                }
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.add(obj12);
                                        z = true;
                                    }
                                }
                            }
                        }
                        Object obj13 = scopeMap6.getMap().get(next);
                        if (obj13 != null) {
                            if (obj13 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj13;
                                Object[] objArr13 = mutableScatterSet9.elements;
                                long[] jArr14 = mutableScatterSet9.metadata;
                                int length9 = jArr14.length - 2;
                                if (length9 >= 0) {
                                    int i36 = 0;
                                    while (true) {
                                        long j11 = jArr14[i36];
                                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i37 = 8 - ((~(i36 - length9)) >>> 31);
                                            for (int i38 = 0; i38 < i37; i38++) {
                                                if ((j11 & 255) < 128) {
                                                    mutableScatterSet.add(objArr13[(i36 << 3) + i38]);
                                                    z = true;
                                                }
                                                j11 >>= 8;
                                            }
                                            if (i37 != 8) {
                                                break;
                                            }
                                        }
                                        if (i36 == length9) {
                                            break;
                                        }
                                        i36++;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj13);
                                z = true;
                            }
                        }
                        it3 = it;
                        scopeMap5 = scopeMap;
                    } else {
                        it = it3;
                        scopeMap = scopeMap5;
                    }
                    it3 = it;
                    scopeMap5 = scopeMap;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector mutableVector = this.statesToReread;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    while (true) {
                        rereadDerivedState((DerivedState) content[i8]);
                        int i39 = i8 + 1;
                        if (i39 >= size) {
                            break;
                        }
                        i8 = i39;
                    }
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void rereadDerivedState(DerivedState derivedState) {
            long[] jArr;
            MutableObjectIntMap mutableObjectIntMap;
            MutableScatterMap mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            if (obj instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr2 = mutableScatterSet.metadata;
                int length = jArr2.length - 2;
                if (length < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    long j = jArr2[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8;
                        int i3 = 8 - ((~(i - length)) >>> 31);
                        int i4 = 0;
                        while (i4 < i3) {
                            if ((j & 255) < 128) {
                                Object obj2 = objArr[(i << 3) + i4];
                                MutableObjectIntMap mutableObjectIntMap2 = (MutableObjectIntMap) mutableScatterMap.get(obj2);
                                if (mutableObjectIntMap2 == null) {
                                    mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
                                    mutableScatterMap.set(obj2, mutableObjectIntMap);
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    mutableObjectIntMap = mutableObjectIntMap2;
                                }
                                recordRead(derivedState, id, obj2, mutableObjectIntMap);
                            }
                            j >>= i2;
                            i4++;
                            i2 = i2;
                            jArr2 = jArr2;
                        }
                        jArr = jArr2;
                        if (i3 != i2) {
                            return;
                        }
                    } else {
                        jArr = jArr2;
                    }
                    if (i == length) {
                        return;
                    }
                    i++;
                    jArr2 = jArr;
                }
            } else {
                MutableObjectIntMap mutableObjectIntMap3 = (MutableObjectIntMap) mutableScatterMap.get(obj);
                if (mutableObjectIntMap3 == null) {
                    mutableObjectIntMap3 = new MutableObjectIntMap(0, 1, null);
                    mutableScatterMap.set(obj, mutableObjectIntMap3);
                    Unit unit2 = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap3);
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0044 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0046 A[LOOP:0: B:5:0x0011->B:15:0x0046, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:19:0x0049 A[EDGE_INSN: B:19:0x0049->B:16:0x0049 BREAK  A[LOOP:0: B:5:0x0011->B:15:0x0046], SYNTHETIC] */
        public final void notifyInvalidatedScopes() {
            MutableScatterSet mutableScatterSet = this.invalidated;
            Function1 function1 = this.onChanged;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
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
                                function1.invoke(objArr[(i << 3) + i3]);
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
            mutableScatterSet.clear();
        }
    }
}
