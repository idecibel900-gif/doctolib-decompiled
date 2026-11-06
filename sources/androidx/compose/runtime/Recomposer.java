package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List _knownCompositions;
    private List _knownCompositionsCache;
    private final MutableStateFlow _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector compositionInvalidations;
    private final Map compositionValueStatesAvailable;
    private final List compositionValuesAwaitingInsert;
    private final Map compositionValuesRemoved;
    private final List compositionsAwaitingApply;
    private Set compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private MutableScatterSet snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation workContinuation;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference _hotReloadEnabled = new AtomicReference(Boolean.FALSE);

    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set set) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List performInsertValues(List list, MutableScatterSet mutableScatterSet) {
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            ControlledComposition composition$runtime_release = ((MovableContentStateReference) obj).getComposition$runtime_release();
            Object arrayList2 = map.get(composition$runtime_release);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(composition$runtime_release, arrayList2);
            }
            ((ArrayList) arrayList2).add(obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) list2.get(i2);
                            Map map2 = this.compositionValuesRemoved;
                            movableContentStateReference.getContent$runtime_release();
                            arrayList.add(TuplesKt.to(movableContentStateReference, RecomposerKt.removeLastMultiValue(map2, null)));
                        }
                    }
                    int size3 = arrayList.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        if (((Pair) arrayList.get(i3)).getSecond() != null) {
                            int size4 = arrayList.size();
                            for (int i4 = 0; i4 < size4; i4++) {
                                if (((Pair) arrayList.get(i4)).getSecond() == null) {
                                    ArrayList arrayList3 = new ArrayList(arrayList.size());
                                    int size5 = arrayList.size();
                                    for (int i5 = 0; i5 < size5; i5++) {
                                        Pair pair = (Pair) arrayList.get(i5);
                                        MovableContentStateReference movableContentStateReference2 = pair.getSecond() == null ? (MovableContentStateReference) pair.getFirst() : null;
                                        if (movableContentStateReference2 != null) {
                                            arrayList3.add(movableContentStateReference2);
                                        }
                                    }
                                    synchronized (this.stateLock) {
                                        CollectionsKt.addAll(this.compositionValuesAwaitingInsert, arrayList3);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    int size6 = arrayList.size();
                                    for (int i6 = 0; i6 < size6; i6++) {
                                        Object obj2 = arrayList.get(i6);
                                        if (((Pair) obj2).getSecond() != null) {
                                            arrayList4.add(obj2);
                                        }
                                    }
                                    arrayList = arrayList4;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit2 = Unit.INSTANCE;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                throw th2;
            }
        }
        return CollectionsKt.toList(map.keySet());
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1081invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1081invoke() {
                CancellableContinuation cancellableContinuationDeriveStateLocked;
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                    if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                    }
                }
                if (cancellableContinuationDeriveStateLocked != null) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationDeriveStateLocked.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
        this.compositionInvalidations = new MutableVector(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.Key));
        completableJobJob.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(final Throwable th) {
                CancellableContinuation cancellableContinuation;
                CancellableContinuation cancellableContinuation2;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = this.this$0.stateLock;
                final Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    try {
                        Job job = recomposer.runnerJob;
                        cancellableContinuation = null;
                        if (job != null) {
                            recomposer._state.setValue(Recomposer.State.ShuttingDown);
                            if (recomposer.isClosed) {
                                if (recomposer.workContinuation != null) {
                                    cancellableContinuation2 = recomposer.workContinuation;
                                }
                                recomposer.workContinuation = null;
                                job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((Throwable) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Throwable th2) {
                                        Object obj2 = recomposer.stateLock;
                                        Recomposer recomposer2 = recomposer;
                                        Throwable th3 = th;
                                        synchronized (obj2) {
                                            if (th3 == null) {
                                                th3 = null;
                                            } else if (th2 != null) {
                                                try {
                                                    if (th2 instanceof CancellationException) {
                                                        th2 = null;
                                                    }
                                                    if (th2 != null) {
                                                        kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                    }
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            }
                                            recomposer2.closeCause = th3;
                                            recomposer2._state.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation2;
                            } else {
                                job.cancel(CancellationException);
                            }
                            cancellableContinuation2 = null;
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new Function1() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((Throwable) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Throwable th2) {
                                    Object obj2 = recomposer.stateLock;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 == null) {
                                            th3 = null;
                                        } else if (th2 != null) {
                                            try {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        recomposer2.closeCause = th3;
                                        recomposer2._state.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation2;
                        } else {
                            recomposer.closeCause = CancellationException;
                            recomposer._state.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = completableJobJob;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(completableJobJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List getKnownCompositions() {
        List listEmptyList = this._knownCompositionsCache;
        if (listEmptyList == null) {
            List list = this._knownCompositions;
            listEmptyList = list.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list);
            this._knownCompositionsCache = listEmptyList;
        }
        return listEmptyList;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation deriveStateLocked() {
        State state;
        if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else if (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        Iterator it = this.effectJob.getChildren().iterator();
        while (it.hasNext()) {
            if (((Job) it.next()).isActive()) {
                return true;
            }
        }
        return false;
    }

    public final StateFlow getCurrentState() {
        return this._state;
    }

    private final class RecomposerInfoImpl {
        public RecomposerInfoImpl() {
        }
    }

    private static final class RecomposerErrorState {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                int size = knownCompositions.size();
                for (int i = 0; i < size; i++) {
                    ((ControlledComposition) knownCompositions.get(i)).recordModificationsOf(setWrapIntoSet);
                    if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = job;
            deriveStateLocked();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    static final class C02342 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        C02342(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation continuation) {
            C02342 c02342 = Recomposer.this.new C02342(continuation);
            c02342.L$0 = monotonicFrameClock;
            return c02342.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:17:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:20:0x00df  */
        /* JADX WARN: Code duplicated, block: B:23:0x0101  */
        /* JADX WARN: Code duplicated, block: B:25:0x010f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0101 -> B:24:0x0109). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x010f -> B:12:0x00ac). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C02342.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:21:0x0077 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:22:0x0079 A[Catch: all -> 0x002b, LOOP:1: B:12:0x0043->B:22:0x0079, LOOP_END, TryCatch #0 {all -> 0x002b, blocks: (B:4:0x000d, B:6:0x001a, B:9:0x002e, B:12:0x0043, B:14:0x0054, B:16:0x005e, B:18:0x0064, B:19:0x0071, B:24:0x0084, B:27:0x0091, B:29:0x009c, B:31:0x00a6, B:33:0x00ac, B:34:0x00b6, B:37:0x00be, B:38:0x00c1, B:41:0x00d1, B:43:0x00dc, B:45:0x00e6, B:47:0x00ec, B:48:0x00f9, B:51:0x0101, B:52:0x0104, B:22:0x0079), top: B:57:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00bc A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:37:0x00be A[Catch: all -> 0x002b, LOOP:3: B:27:0x0091->B:37:0x00be, LOOP_END, TryCatch #0 {all -> 0x002b, blocks: (B:4:0x000d, B:6:0x001a, B:9:0x002e, B:12:0x0043, B:14:0x0054, B:16:0x005e, B:18:0x0064, B:19:0x0071, B:24:0x0084, B:27:0x0091, B:29:0x009c, B:31:0x00a6, B:33:0x00ac, B:34:0x00b6, B:37:0x00be, B:38:0x00c1, B:41:0x00d1, B:43:0x00dc, B:45:0x00e6, B:47:0x00ec, B:48:0x00f9, B:51:0x0101, B:52:0x0104, B:22:0x0079), top: B:57:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00ff A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:51:0x0101 A[Catch: all -> 0x002b, LOOP:5: B:41:0x00d1->B:51:0x0101, LOOP_END, TryCatch #0 {all -> 0x002b, blocks: (B:4:0x000d, B:6:0x001a, B:9:0x002e, B:12:0x0043, B:14:0x0054, B:16:0x005e, B:18:0x0064, B:19:0x0071, B:24:0x0084, B:27:0x0091, B:29:0x009c, B:31:0x00a6, B:33:0x00ac, B:34:0x00b6, B:37:0x00be, B:38:0x00c1, B:41:0x00d1, B:43:0x00dc, B:45:0x00e6, B:47:0x00ec, B:48:0x00f9, B:51:0x0101, B:52:0x0104, B:22:0x0079), top: B:57:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:61:0x0084 A[EDGE_INSN: B:61:0x0084->B:24:0x0084 BREAK  A[LOOP:1: B:12:0x0043->B:22:0x0079], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:66:0x00c1 A[EDGE_INSN: B:66:0x00c1->B:38:0x00c1 BREAK  A[LOOP:3: B:27:0x0091->B:37:0x00be], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x0104 A[EDGE_INSN: B:71:0x0104->B:52:0x0104 BREAK  A[LOOP:5: B:41:0x00d1->B:51:0x0101], SYNTHETIC] */
        public static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List list, List list2, List list3, MutableScatterSet mutableScatterSet, MutableScatterSet mutableScatterSet2, MutableScatterSet mutableScatterSet3, MutableScatterSet mutableScatterSet4) {
            char c;
            long j;
            long j2;
            synchronized (recomposer.stateLock) {
                try {
                    list.clear();
                    list2.clear();
                    int size = list3.size();
                    for (int i = 0; i < size; i++) {
                        ControlledComposition controlledComposition = (ControlledComposition) list3.get(i);
                        controlledComposition.abandonChanges();
                        recomposer.recordFailedCompositionLocked(controlledComposition);
                    }
                    list3.clear();
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        j = 255;
                        while (true) {
                            long j3 = jArr[i2];
                            c = 7;
                            j2 = -9187201950435737472L;
                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i2 != length) {
                                    break;
                                    break;
                                }
                                i2++;
                            } else {
                                int i3 = 8 - ((~(i2 - length)) >>> 31);
                                for (int i4 = 0; i4 < i3; i4++) {
                                    if ((j3 & 255) < 128) {
                                        ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i2 << 3) + i4];
                                        controlledComposition2.abandonChanges();
                                        recomposer.recordFailedCompositionLocked(controlledComposition2);
                                    }
                                    j3 >>= 8;
                                }
                                if (i3 != 8) {
                                    break;
                                } else if (i2 != length) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    } else {
                        c = 7;
                        j = 255;
                        j2 = -9187201950435737472L;
                    }
                    mutableScatterSet.clear();
                    Object[] objArr2 = mutableScatterSet2.elements;
                    long[] jArr2 = mutableScatterSet2.metadata;
                    int length2 = jArr2.length - 2;
                    if (length2 >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j4 = jArr2[i5];
                            if ((((~j4) << c) & j4 & j2) == j2) {
                                if (i5 != length2) {
                                    break;
                                    break;
                                }
                                i5++;
                            } else {
                                int i6 = 8 - ((~(i5 - length2)) >>> 31);
                                for (int i7 = 0; i7 < i6; i7++) {
                                    if ((j4 & j) < 128) {
                                        ((ControlledComposition) objArr2[(i5 << 3) + i7]).changesApplied();
                                    }
                                    j4 >>= 8;
                                }
                                if (i6 != 8) {
                                    break;
                                } else if (i5 != length2) {
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                        }
                    }
                    mutableScatterSet2.clear();
                    mutableScatterSet3.clear();
                    Object[] objArr3 = mutableScatterSet4.elements;
                    long[] jArr3 = mutableScatterSet4.metadata;
                    int length3 = jArr3.length - 2;
                    if (length3 >= 0) {
                        int i8 = 0;
                        while (true) {
                            long j5 = jArr3[i8];
                            if ((((~j5) << c) & j5 & j2) == j2) {
                                if (i8 != length3) {
                                    break;
                                    break;
                                }
                                i8++;
                            } else {
                                int i9 = 8 - ((~(i8 - length3)) >>> 31);
                                for (int i10 = 0; i10 < i9; i10++) {
                                    if ((j5 & j) < 128) {
                                        ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i8 << 3) + i10];
                                        controlledComposition3.abandonChanges();
                                        recomposer.recordFailedCompositionLocked(controlledComposition3);
                                    }
                                    j5 >>= 8;
                                }
                                if (i9 != 8) {
                                    break;
                                } else if (i8 != length3) {
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                        }
                    }
                    mutableScatterSet4.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                try {
                    List list2 = recomposer.compositionValuesAwaitingInsert;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((MovableContentStateReference) list2.get(i));
                    }
                    recomposer.compositionValuesAwaitingInsert.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation continuation) {
        Object objRecompositionRunner = recompositionRunner(new C02342(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z) throws Exception {
        if (!((Boolean) _hotReloadEnabled.get()).booleanValue() || (exc instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, exc);
                Unit unit = Unit.INSTANCE;
            }
            throw exc;
        }
        synchronized (this.stateLock) {
            try {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", exc);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(z, exc);
                if (controlledComposition != null) {
                    recordFailedCompositionLocked(controlledComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final void removeKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.remove(controlledComposition);
        this._knownCompositionsCache = null;
    }

    private final void addKnownCompositionLocked(ControlledComposition controlledComposition) {
        this._knownCompositions.add(controlledComposition);
        this._knownCompositionsCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition controlledComposition) {
        List arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(controlledComposition)) {
            arrayList.add(controlledComposition);
        }
        removeKnownCompositionLocked(controlledComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (!getHasSchedulingWork()) {
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl2.initCancellability();
            synchronized (this.stateLock) {
                if (getHasSchedulingWork()) {
                    cancellableContinuationImpl = cancellableContinuationImpl2;
                } else {
                    this.workContinuation = cancellableContinuationImpl2;
                    cancellableContinuationImpl = null;
                }
            }
            if (cancellableContinuationImpl != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
            }
            Object result = cancellableContinuationImpl2.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    static final class C02332 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function3 $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02332(Function3 function3, MonotonicFrameClock monotonicFrameClock, Continuation continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C02332 c02332 = Recomposer.this.new C02332(this.$block, this.$parentFrameClock, continuation);
            c02332.L$0 = obj;
            return c02332;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x009f A[Catch: all -> 0x00a3, TryCatch #2 {all -> 0x00a3, blocks: (B:28:0x0099, B:30:0x009f, B:33:0x00a5), top: B:58:0x0099 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x00ce A[Catch: all -> 0x00d2, TryCatch #1 {all -> 0x00d2, blocks: (B:44:0x00c8, B:46:0x00ce, B:49:0x00d4), top: B:56:0x00c8 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Job job;
            ObserverHandle observerHandle;
            Throwable th;
            List knownCompositions;
            Object obj2;
            Recomposer recomposer;
            Object obj3;
            Recomposer recomposer2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                observerHandle = (ObserverHandle) this.L$1;
                job = (Job) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    recomposer2 = Recomposer.this;
                    synchronized (obj3) {
                        try {
                            if (recomposer2.runnerJob == job) {
                                recomposer2.runnerJob = null;
                            }
                            recomposer2.deriveStateLocked();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    recomposer = Recomposer.this;
                    synchronized (obj2) {
                        try {
                            if (recomposer.runnerJob == job) {
                                recomposer.runnerJob = null;
                            }
                            recomposer.deriveStateLocked();
                            Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                            throw th;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            Recomposer.this.registerRunnerJob(job);
            Snapshot.Companion companion = Snapshot.Companion;
            final Recomposer recomposer3 = Recomposer.this;
            ObserverHandle observerHandleRegisterApplyObserver = companion.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((Set) obj4, (Snapshot) obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(Set set, Snapshot snapshot) {
                    CancellableContinuation cancellableContinuationDeriveStateLocked;
                    Object obj4 = recomposer3.stateLock;
                    Recomposer recomposer4 = recomposer3;
                    synchronized (obj4) {
                        try {
                            if (((Recomposer.State) recomposer4._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                                MutableScatterSet mutableScatterSet = recomposer4.snapshotInvalidations;
                                if (set instanceof ScatterSetWrapper) {
                                    ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
                                    Object[] objArr = set$runtime_release.elements;
                                    long[] jArr = set$runtime_release.metadata;
                                    int length = jArr.length - 2;
                                    if (length >= 0) {
                                        int i2 = 0;
                                        while (true) {
                                            long j = jArr[i2];
                                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i3 = 8 - ((~(i2 - length)) >>> 31);
                                                for (int i4 = 0; i4 < i3; i4++) {
                                                    if ((255 & j) < 128) {
                                                        Object obj5 = objArr[(i2 << 3) + i4];
                                                        if (!(obj5 instanceof StateObjectImpl) || ((StateObjectImpl) obj5).m1116isReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(1))) {
                                                            mutableScatterSet.add(obj5);
                                                        }
                                                    }
                                                    j >>= 8;
                                                }
                                                if (i3 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i2 == length) {
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        }
                                    }
                                } else {
                                    for (Object obj6 : set) {
                                        if (!(obj6 instanceof StateObjectImpl) || ((StateObjectImpl) obj6).m1116isReadInh_f27i8$runtime_release(ReaderKind.m1111constructorimpl(1))) {
                                            mutableScatterSet.add(obj6);
                                        }
                                    }
                                }
                                cancellableContinuationDeriveStateLocked = recomposer4.deriveStateLocked();
                            } else {
                                cancellableContinuationDeriveStateLocked = null;
                            }
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    if (cancellableContinuationDeriveStateLocked != null) {
                        Result.Companion companion2 = Result.Companion;
                        cancellableContinuationDeriveStateLocked.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                    }
                }
            });
            Recomposer.Companion.addRunning(Recomposer.this.recomposerInfo);
            try {
                Object obj4 = Recomposer.this.stateLock;
                Recomposer recomposer4 = Recomposer.this;
                synchronized (obj4) {
                    knownCompositions = recomposer4.getKnownCompositions();
                }
                int size = knownCompositions.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((ControlledComposition) knownCompositions.get(i2)).invalidateAll();
                }
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);
                this.L$0 = job;
                this.L$1 = observerHandleRegisterApplyObserver;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                observerHandle = observerHandleRegisterApplyObserver;
                observerHandle.dispose();
                obj3 = Recomposer.this.stateLock;
                recomposer2 = Recomposer.this;
                synchronized (obj3) {
                    if (recomposer2.runnerJob == job) {
                        recomposer2.runnerJob = null;
                    }
                    recomposer2.deriveStateLocked();
                    Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                    return Unit.INSTANCE;
                }
            } catch (Throwable th5) {
                observerHandle = observerHandleRegisterApplyObserver;
                th = th5;
                observerHandle.dispose();
                obj2 = Recomposer.this.stateLock;
                recomposer = Recomposer.this;
                synchronized (obj2) {
                    if (recomposer.runnerJob == job) {
                        recomposer.runnerJob = null;
                    }
                    recomposer.deriveStateLocked();
                }
                Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                throw th;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2 {
            final /* synthetic */ Function3 $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Function3 function3, MonotonicFrameClock monotonicFrameClock, Continuation continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function3 function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final Object recompositionRunner(Function3 function3, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C02332(function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (((State) this._state.getValue()).compareTo(State.Idle) >= 0) {
                    this._state.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default(this.effectJob, null, 1, null);
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(State state, Continuation continuation) {
            return ((AnonymousClass2) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0) == State.ShutDown);
        }
    }

    public final Object join(Continuation continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new AnonymousClass2(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2 function2) throws Exception {
        Throwable th;
        boolean zIsComposing = controlledComposition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.Companion;
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, null));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    controlledComposition.composeContent(function2);
                    Unit unit = Unit.INSTANCE;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    if (!zIsComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        try {
                            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) > 0) {
                                try {
                                    if (!getKnownCompositions().contains(controlledComposition)) {
                                        addKnownCompositionLocked(controlledComposition);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            try {
                                performInitialMovableContentInserts(controlledComposition);
                                try {
                                    controlledComposition.applyChanges();
                                    controlledComposition.applyLateChanges();
                                    if (zIsComposing) {
                                        return;
                                    }
                                    companion.notifyObjectsInitialized();
                                } catch (Exception e) {
                                    processCompositionError$default(this, e, null, false, 6, null);
                                }
                            } catch (Exception e2) {
                                processCompositionError(e2, controlledComposition, true);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        throw th4;
                    } catch (Throwable th5) {
                        th = th5;
                        Throwable th6 = th;
                        try {
                            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                            throw th6;
                        } catch (Exception e3) {
                            e = e3;
                            processCompositionError(e, controlledComposition, true);
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private final void performInitialMovableContentInserts(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            List list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(((MovableContentStateReference) list.get(i)).getComposition$runtime_release(), controlledComposition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                Iterator it = recomposer.compositionValuesAwaitingInsert.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) it.next();
                    if (Intrinsics.areEqual(movableContentStateReference.getComposition$runtime_release(), controlledComposition)) {
                        list.add(movableContentStateReference);
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition controlledComposition, final MutableScatterSet mutableScatterSet) {
        Set set;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, mutableScatterSet));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            if (mutableScatterSet != null) {
                try {
                    if (mutableScatterSet.isNotEmpty()) {
                        controlledComposition.prepareCompose(new Function0() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1082invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m1082invoke() {
                                MutableScatterSet mutableScatterSet2 = mutableScatterSet;
                                ControlledComposition controlledComposition2 = controlledComposition;
                                Object[] objArr = mutableScatterSet2.elements;
                                long[] jArr = mutableScatterSet2.metadata;
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
                                                controlledComposition2.recordWriteOf(objArr[(i << 3) + i3]);
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
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = controlledComposition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            if (zRecompose) {
                return controlledComposition;
            }
            return null;
        } catch (Throwable th2) {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List listEmptyList;
        synchronized (this.stateLock) {
            try {
                if (!this.compositionValuesRemoved.isEmpty()) {
                    List listFlatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    listEmptyList = new ArrayList(listFlatten.size());
                    int size = listFlatten.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listFlatten.get(i2);
                        listEmptyList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                    }
                    this.compositionValueStatesAvailable.clear();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size2 = listEmptyList.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) listEmptyList.get(i);
        }
    }

    private final Function1 readObserverOf(final ControlledComposition controlledComposition) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer.readObserverOf.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1083invoke(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1083invoke(Object obj) {
                controlledComposition.recordReadOf(obj);
            }
        };
    }

    private final Function1 writeObserverOf(final ControlledComposition controlledComposition, final MutableScatterSet mutableScatterSet) {
        return new Function1() { // from class: androidx.compose.runtime.Recomposer.writeObserverOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1084invoke(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m1084invoke(Object obj) {
                controlledComposition.recordWriteOf(obj);
                MutableScatterSet mutableScatterSet2 = mutableScatterSet;
                if (mutableScatterSet2 != null) {
                    mutableScatterSet2.add(obj);
                }
            }
        };
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
            mutableSnapshot.dispose();
        } catch (Throwable th) {
            mutableSnapshot.dispose();
            throw th;
        }
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return ((Boolean) _hotReloadEnabled.get()).booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition controlledComposition) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(controlledComposition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(movableContentStateReference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            try {
                Set linkedHashSet = this.compositionsRemoved;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.compositionsRemoved = linkedHashSet;
                }
                linkedHashSet.add(controlledComposition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
        MovableContentState movableContentState;
        synchronized (this.stateLock) {
            movableContentState = (MovableContentState) this.compositionValueStatesAvailable.remove(movableContentStateReference);
        }
        return movableContentState;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add((Object) recomposerInfoImpl);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove((Object) recomposerInfoImpl);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetRemove));
        }
    }
}
