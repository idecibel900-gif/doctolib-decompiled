package androidx.datastore.core;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl implements DataStore {
    public static final Companion Companion = new Companion(null);
    private int collectorCounter;
    private Job collectorJob;
    private final Mutex collectorMutex;
    private final Lazy coordinator$delegate;
    private final CorruptionHandler corruptionHandler;
    private final Flow data;
    private final DataStoreInMemoryCache inMemoryCache;
    private final InitDataStore readAndInit;
    private final CoroutineScope scope;
    private final Storage storage;
    private final Lazy storageConnectionDelegate;
    private final SimpleActor writeActor;

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$decrementCollector$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.decrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$handleUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C02611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02611(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$incrementCollector$1, reason: invalid class name and case insensitive filesystem */
    static final class C02621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02621(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.incrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    static final class C02631 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02631(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1, reason: invalid class name and case insensitive filesystem */
    static final class C02641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02641(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.readDataAndUpdateCache(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    static final class C02661 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02661(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DataStoreImpl.this.readDataOrHandleCorruption(false, this);
        }
    }

    public DataStoreImpl(Storage storage, List initTasksList, CorruptionHandler corruptionHandler, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = MutexKt.Mutex$default(false, 1, null);
        this.inMemoryCache = new DataStoreInMemoryCache();
        this.readAndInit = new InitDataStore(this, initTasksList);
        this.storageConnectionDelegate = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.DataStoreImpl$storageConnectionDelegate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final StorageConnection invoke() {
                return this.this$0.storage.createConnection();
            }
        });
        this.coordinator$delegate = LazyKt.lazy(new Function0() { // from class: androidx.datastore.core.DataStoreImpl$coordinator$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final InterProcessCoordinator invoke() {
                return this.this$0.getStorageConnection$datastore_core_release().getCoordinator();
            }
        });
        this.writeActor = new SimpleActor(scope, new Function1() { // from class: androidx.datastore.core.DataStoreImpl$writeActor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    this.this$0.inMemoryCache.tryUpdate(new Final(th));
                }
                if (this.this$0.storageConnectionDelegate.isInitialized()) {
                    this.this$0.getStorageConnection$datastore_core_release().close();
                }
            }
        }, new Function2() { // from class: androidx.datastore.core.DataStoreImpl$writeActor$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Message.Update) obj, (Throwable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Message.Update msg, Throwable th) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                CompletableDeferred ack = msg.getAck();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                ack.completeExceptionally(th);
            }
        }, new DataStoreImpl$writeActor$3(this, null));
    }

    @Override // androidx.datastore.core.DataStore
    public Flow getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object incrementCollector(Continuation continuation) {
        C02621 c02621;
        DataStoreImpl dataStoreImpl;
        Mutex mutex;
        if (continuation instanceof C02621) {
            c02621 = (C02621) continuation;
            int i = c02621.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02621.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02621 = new C02621(continuation);
            }
        } else {
            c02621 = new C02621(continuation);
        }
        Object obj = c02621.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02621.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.collectorMutex;
            c02621.L$0 = this;
            c02621.L$1 = mutex2;
            c02621.label = 1;
            if (mutex2.lock(null, c02621) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dataStoreImpl = this;
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c02621.L$1;
            dataStoreImpl = (DataStoreImpl) c02621.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            int i3 = dataStoreImpl.collectorCounter + 1;
            dataStoreImpl.collectorCounter = i3;
            if (i3 == 1) {
                dataStoreImpl.collectorJob = BuildersKt__Builders_commonKt.launch$default(dataStoreImpl.scope, null, null, new DataStoreImpl$incrementCollector$2$1(dataStoreImpl, null), 3, null);
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object decrementCollector(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        DataStoreImpl dataStoreImpl;
        Mutex mutex;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.collectorMutex;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = mutex2;
            anonymousClass1.label = 1;
            if (mutex2.lock(null, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            dataStoreImpl = this;
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) anonymousClass1.L$1;
            dataStoreImpl = (DataStoreImpl) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            int i3 = dataStoreImpl.collectorCounter - 1;
            dataStoreImpl.collectorCounter = i3;
            if (i3 == 0) {
                Job job = dataStoreImpl.collectorJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                dataStoreImpl.collectorJob = null;
            }
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2 function2, Continuation continuation) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuation.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return BuildersKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new C02702(function2, null), continuation);
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$updateData$2, reason: invalid class name and case insensitive filesystem */
    static final class C02702 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02702(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C02702 c02702 = DataStoreImpl.this.new C02702(this.$transform, continuation);
            c02702.L$0 = obj;
            return c02702;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02702) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            DataStoreImpl.this.writeActor.offer(new Message.Update(this.$transform, completableDeferredCompletableDeferred$default, DataStoreImpl.this.inMemoryCache.getCurrentState(), coroutineScope.getCoroutineContext()));
            this.label = 1;
            Object objAwait = completableDeferredCompletableDeferred$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public final StorageConnection getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readState$2, reason: invalid class name and case insensitive filesystem */
    static final class C02682 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $requireLock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02682(boolean z, Continuation continuation) {
            super(2, continuation);
            this.$requireLock = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DataStoreImpl.this.new C02682(this.$requireLock, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02682) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        
            if (r5 == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L54
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L1e
                goto L47
            L1e:
                r5 = move-exception
                goto L57
            L20:
                kotlin.ResultKt.throwOnFailure(r5)
                androidx.datastore.core.DataStoreImpl r5 = androidx.datastore.core.DataStoreImpl.this
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                boolean r5 = r5 instanceof androidx.datastore.core.Final
                if (r5 == 0) goto L3c
                androidx.datastore.core.DataStoreImpl r5 = androidx.datastore.core.DataStoreImpl.this
                androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
                androidx.datastore.core.State r5 = r5.getCurrentState()
                return r5
            L3c:
                androidx.datastore.core.DataStoreImpl r5 = androidx.datastore.core.DataStoreImpl.this     // Catch: java.lang.Throwable -> L1e
                r4.label = r3     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readAndInitOrPropagateAndThrowFailure(r5, r4)     // Catch: java.lang.Throwable -> L1e
                if (r5 != r0) goto L47
                goto L53
            L47:
                androidx.datastore.core.DataStoreImpl r5 = androidx.datastore.core.DataStoreImpl.this
                boolean r1 = r4.$requireLock
                r4.label = r2
                java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataAndUpdateCache(r5, r1, r4)
                if (r5 != r0) goto L54
            L53:
                return r0
            L54:
                androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                return r5
            L57:
                androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
                r1 = -1
                r0.<init>(r5, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.C02682.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z, Continuation continuation) {
        return BuildersKt.withContext(this.scope.getCoroutineContext(), new C02682(z, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b4, code lost:
    
        if (r9 == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.Message$Update, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [androidx.datastore.core.Message$Update] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (r4.runIfNeeded(r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl.C02631
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl.C02631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L32
            goto L6c
        L32:
            r6 = move-exception
            goto L73
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3c:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.DataStoreImpl r2 = (androidx.datastore.core.DataStoreImpl) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L57
        L44:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.datastore.core.InterProcessCoordinator r6 = r5.getCoordinator()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.getVersion(r0)
            if (r6 != r1) goto L56
            goto L6b
        L56:
            r2 = r5
        L57:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            androidx.datastore.core.DataStoreImpl$InitDataStore r4 = r2.readAndInit     // Catch: java.lang.Throwable -> L6f
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L6f
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L6f
            r0.label = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r6 = r4.runIfNeeded(r0)     // Catch: java.lang.Throwable -> L6f
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L6f:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L73:
            androidx.datastore.core.DataStoreInMemoryCache r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r6, r1)
            r0.tryUpdate(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
    
        if (r11 == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3, reason: invalid class name and case insensitive filesystem */
    static final class C02653 extends SuspendLambda implements Function1 {
        Object L$0;
        int label;

        C02653(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DataStoreImpl.this.new C02653(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C02653) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            State readException;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DataStoreImpl dataStoreImpl = DataStoreImpl.this;
                    this.label = 1;
                    obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        readException = new ReadException(th, ((Number) obj).intValue());
                        return TuplesKt.to(readException, Boxing.boxBoolean(true));
                    }
                    ResultKt.throwOnFailure(obj);
                }
                readException = (State) obj;
            } catch (Throwable th2) {
                InterProcessCoordinator coordinator = DataStoreImpl.this.getCoordinator();
                this.L$0 = th2;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != coroutine_suspended) {
                    th = th2;
                    obj = version;
                }
                return coroutine_suspended;
            }
            return TuplesKt.to(readException, Boxing.boxBoolean(true));
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $cachedVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(int i, Continuation continuation) {
            super(2, continuation);
            this.$cachedVersion = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass4 anonymousClass4 = DataStoreImpl.this.new AnonymousClass4(this.$cachedVersion, continuation);
            anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((AnonymousClass4) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r4v0 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            int iIntValue;
            ?? r0;
            ?? r1;
            State state;
            ?? r2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r3 = this.label;
            try {
                if (r3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean z = this.Z$0;
                    DataStoreImpl dataStoreImpl = DataStoreImpl.this;
                    this.Z$0 = z;
                    this.label = 1;
                    obj = dataStoreImpl.readDataOrHandleCorruption(z, this);
                    r3 = z;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (r3 != 1) {
                        if (r3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z2 = this.Z$0;
                        th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r1 = z2;
                        iIntValue = ((Number) obj).intValue();
                        r0 = r1;
                        ReadException readException = new ReadException(th, iIntValue);
                        r2 = r0;
                        state = readException;
                        return TuplesKt.to(state, Boxing.boxBoolean(r2));
                    }
                    boolean z3 = this.Z$0;
                    ResultKt.throwOnFailure(obj);
                    r3 = z3;
                }
                state = (State) obj;
                r2 = r3;
            } catch (Throwable th2) {
                if (r3 != 0) {
                    InterProcessCoordinator coordinator = DataStoreImpl.this.getCoordinator();
                    this.L$0 = th2;
                    this.Z$0 = r3;
                    this.label = 2;
                    Object version = coordinator.getVersion(this);
                    if (version != coroutine_suspended) {
                        r1 = r3;
                        th = th2;
                        obj = version;
                    }
                    return coroutine_suspended;
                }
                ?? r4 = r3;
                th = th2;
                iIntValue = this.$cachedVersion;
                r0 = r4 == true ? 1 : 0;
            }
            return TuplesKt.to(state, Boxing.boxBoolean(r2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(Continuation continuation) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), continuation);
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$transformAndWrite$2, reason: invalid class name and case insensitive filesystem */
    static final class C02692 extends SuspendLambda implements Function1 {
        final /* synthetic */ CoroutineContext $callerContext;
        final /* synthetic */ Function2 $transform;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02692(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
            super(1, continuation);
            this.$callerContext = coroutineContext;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DataStoreImpl.this.new C02692(this.$callerContext, this.$transform, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C02692) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws CorruptionException {
            Data data;
            DataStoreImpl dataStoreImpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DataStoreImpl dataStoreImpl2 = DataStoreImpl.this;
                this.label = 1;
                obj = dataStoreImpl2.readDataOrHandleCorruption(true, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return obj2;
                }
                data = (Data) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            data.checkHashCode();
            if (!Intrinsics.areEqual(data.getValue(), obj)) {
                dataStoreImpl = DataStoreImpl.this;
                this.L$0 = obj;
                this.label = 3;
                if (dataStoreImpl.writeData$datastore_core_release(obj, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
            data = (Data) obj;
            CoroutineContext coroutineContext = this.$callerContext;
            DataStoreImpl$transformAndWrite$2$newData$1 dataStoreImpl$transformAndWrite$2$newData$1 = new DataStoreImpl$transformAndWrite$2$newData$1(this.$transform, data, null);
            this.L$0 = data;
            this.label = 2;
            obj = BuildersKt.withContext(coroutineContext, dataStoreImpl$transformAndWrite$2$newData$1, this);
            if (obj != coroutine_suspended) {
                data.checkHashCode();
                if (!Intrinsics.areEqual(data.getValue(), obj)) {
                    dataStoreImpl = DataStoreImpl.this;
                    this.L$0 = obj;
                    this.label = 3;
                    if (dataStoreImpl.writeData$datastore_core_release(obj, true, this) == coroutine_suspended) {
                    }
                }
                return obj;
            }
            return coroutine_suspended;
        }
    }

    private final Object transformAndWrite(Function2 function2, CoroutineContext coroutineContext, Continuation continuation) {
        return getCoordinator().lock(new C02692(coroutineContext, function2, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object writeData$datastore_core_release(Object obj, boolean z, Continuation continuation) {
        DataStoreImpl$writeData$1 dataStoreImpl$writeData$1;
        Ref$IntRef ref$IntRef;
        if (continuation instanceof DataStoreImpl$writeData$1) {
            dataStoreImpl$writeData$1 = (DataStoreImpl$writeData$1) continuation;
            int i = dataStoreImpl$writeData$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                dataStoreImpl$writeData$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuation);
            }
        } else {
            dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuation);
        }
        Object obj2 = dataStoreImpl$writeData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dataStoreImpl$writeData$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            StorageConnection storageConnection$datastore_core_release = getStorageConnection$datastore_core_release();
            DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(ref$IntRef2, this, obj, z, null);
            dataStoreImpl$writeData$1.L$0 = ref$IntRef2;
            dataStoreImpl$writeData$1.label = 1;
            if (storageConnection$datastore_core_release.writeScope(dataStoreImpl$writeData$2, dataStoreImpl$writeData$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$IntRef = ref$IntRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$IntRef = (Ref$IntRef) dataStoreImpl$writeData$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        return Boxing.boxInt(ref$IntRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x010d  */
    /* JADX WARN: Code duplicated, block: B:66:0x012c  */
    /* JADX WARN: Code duplicated, block: B:71:0x014d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0155  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    public final Object readDataOrHandleCorruption(boolean z, Continuation continuation) throws CorruptionException {
        C02661 c02661;
        DataStoreImpl dataStoreImpl;
        Ref$ObjectRef ref$ObjectRef;
        Object objHandleCorruption;
        CorruptionException corruptionException;
        Ref$ObjectRef ref$ObjectRef2;
        DataStoreImpl dataStoreImpl2;
        Ref$IntRef ref$IntRef;
        CorruptionException corruptionException2;
        Function1 c02673;
        Ref$IntRef ref$IntRef2;
        Ref$ObjectRef ref$ObjectRef3;
        DataStoreImpl dataStoreImpl3;
        DataStoreImpl dataStoreImpl4;
        int iHashCode;
        Object version;
        boolean z2;
        int i;
        Object obj;
        if (continuation instanceof C02661) {
            c02661 = (C02661) continuation;
            int i2 = c02661.label;
            if ((i2 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c02661.label = i2 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c02661 = new C02661(continuation);
            }
        } else {
            c02661 = new C02661(continuation);
        }
        Object version2 = c02661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c02661.label;
        try {
            switch (r2) {
                case 0:
                    ResultKt.throwOnFailure(version2);
                    try {
                        if (z) {
                            c02661.L$0 = this;
                            c02661.Z$0 = z;
                            c02661.label = 1;
                            version2 = readDataFromFileOrDefault(c02661);
                            if (version2 != coroutine_suspended) {
                                dataStoreImpl4 = this;
                                if (version2 != null) {
                                    try {
                                        iHashCode = version2.hashCode();
                                    } catch (CorruptionException e) {
                                        e = e;
                                        dataStoreImpl = dataStoreImpl4;
                                        ref$ObjectRef = new Ref$ObjectRef();
                                        CorruptionHandler corruptionHandler = dataStoreImpl.corruptionHandler;
                                        c02661.L$0 = dataStoreImpl;
                                        c02661.L$1 = e;
                                        c02661.L$2 = ref$ObjectRef;
                                        c02661.L$3 = ref$ObjectRef;
                                        c02661.Z$0 = z;
                                        c02661.label = 5;
                                        objHandleCorruption = corruptionHandler.handleCorruption(e, c02661);
                                        if (objHandleCorruption != coroutine_suspended) {
                                            corruptionException = e;
                                            version2 = objHandleCorruption;
                                            ref$ObjectRef2 = ref$ObjectRef;
                                            dataStoreImpl2 = dataStoreImpl;
                                            ref$ObjectRef2.element = version2;
                                            ref$IntRef = new Ref$IntRef();
                                            try {
                                                c02673 = new C02673(ref$ObjectRef, dataStoreImpl2, ref$IntRef, null);
                                                c02661.L$0 = corruptionException;
                                                c02661.L$1 = ref$ObjectRef;
                                                c02661.L$2 = ref$IntRef;
                                                c02661.L$3 = null;
                                                c02661.label = 6;
                                                if (dataStoreImpl2.doWithWriteFileLock(z, c02673, c02661) != coroutine_suspended) {
                                                    ref$IntRef2 = ref$IntRef;
                                                    ref$ObjectRef3 = ref$ObjectRef;
                                                    Object obj2 = ref$ObjectRef3.element;
                                                    return new Data(obj2, obj2 != null ? obj2.hashCode() : 0, ref$IntRef2.element);
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                corruptionException2 = corruptionException;
                                                ExceptionsKt.addSuppressed(corruptionException2, th);
                                                throw corruptionException2;
                                            }
                                        }
                                    }
                                } else {
                                    iHashCode = 0;
                                }
                                InterProcessCoordinator coordinator = dataStoreImpl4.getCoordinator();
                                c02661.L$0 = dataStoreImpl4;
                                c02661.L$1 = version2;
                                c02661.Z$0 = z;
                                c02661.I$0 = iHashCode;
                                c02661.label = 2;
                                version = coordinator.getVersion(c02661);
                                if (version != coroutine_suspended) {
                                    int i3 = iHashCode;
                                    z2 = z;
                                    i = i3;
                                    obj = version2;
                                    version2 = version;
                                    return new Data(obj, i, ((Number) version2).intValue());
                                }
                            }
                        } else {
                            InterProcessCoordinator coordinator2 = getCoordinator();
                            c02661.L$0 = this;
                            c02661.Z$0 = z;
                            c02661.label = 3;
                            version2 = coordinator2.getVersion(c02661);
                            if (version2 != coroutine_suspended) {
                                dataStoreImpl3 = this;
                                int iIntValue = ((Number) version2).intValue();
                                InterProcessCoordinator coordinator3 = dataStoreImpl3.getCoordinator();
                                AnonymousClass2 anonymousClass2 = dataStoreImpl3.new AnonymousClass2(iIntValue, null);
                                c02661.L$0 = dataStoreImpl3;
                                c02661.Z$0 = z;
                                c02661.label = 4;
                                version2 = coordinator3.tryLock(anonymousClass2, c02661);
                                if (version2 == coroutine_suspended) {
                                }
                                return (Data) version2;
                            }
                        }
                    } catch (CorruptionException e2) {
                        e = e2;
                        dataStoreImpl = this;
                        ref$ObjectRef = new Ref$ObjectRef();
                        CorruptionHandler corruptionHandler2 = dataStoreImpl.corruptionHandler;
                        c02661.L$0 = dataStoreImpl;
                        c02661.L$1 = e;
                        c02661.L$2 = ref$ObjectRef;
                        c02661.L$3 = ref$ObjectRef;
                        c02661.Z$0 = z;
                        c02661.label = 5;
                        objHandleCorruption = corruptionHandler2.handleCorruption(e, c02661);
                        if (objHandleCorruption != coroutine_suspended) {
                            corruptionException = e;
                            version2 = objHandleCorruption;
                            ref$ObjectRef2 = ref$ObjectRef;
                            dataStoreImpl2 = dataStoreImpl;
                            ref$ObjectRef2.element = version2;
                            ref$IntRef = new Ref$IntRef();
                            c02673 = new C02673(ref$ObjectRef, dataStoreImpl2, ref$IntRef, null);
                            c02661.L$0 = corruptionException;
                            c02661.L$1 = ref$ObjectRef;
                            c02661.L$2 = ref$IntRef;
                            c02661.L$3 = null;
                            c02661.label = 6;
                            if (dataStoreImpl2.doWithWriteFileLock(z, c02673, c02661) != coroutine_suspended) {
                                ref$IntRef2 = ref$IntRef;
                                ref$ObjectRef3 = ref$ObjectRef;
                                Object obj3 = ref$ObjectRef3.element;
                                return new Data(obj3, obj3 != null ? obj3.hashCode() : 0, ref$IntRef2.element);
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    z = c02661.Z$0;
                    DataStoreImpl dataStoreImpl5 = (DataStoreImpl) c02661.L$0;
                    ResultKt.throwOnFailure(version2);
                    dataStoreImpl4 = dataStoreImpl5;
                    if (version2 != null) {
                        iHashCode = version2.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    InterProcessCoordinator coordinator4 = dataStoreImpl4.getCoordinator();
                    c02661.L$0 = dataStoreImpl4;
                    c02661.L$1 = version2;
                    c02661.Z$0 = z;
                    c02661.I$0 = iHashCode;
                    c02661.label = 2;
                    version = coordinator4.getVersion(c02661);
                    if (version != coroutine_suspended) {
                        int i4 = iHashCode;
                        z2 = z;
                        i = i4;
                        obj = version2;
                        version2 = version;
                        return new Data(obj, i, ((Number) version2).intValue());
                    }
                    return coroutine_suspended;
                case 2:
                    i = c02661.I$0;
                    z2 = c02661.Z$0;
                    obj = c02661.L$1;
                    dataStoreImpl4 = (DataStoreImpl) c02661.L$0;
                    try {
                        ResultKt.throwOnFailure(version2);
                        return new Data(obj, i, ((Number) version2).intValue());
                    } catch (CorruptionException e3) {
                        e = e3;
                        z = z2;
                        dataStoreImpl = dataStoreImpl4;
                        ref$ObjectRef = new Ref$ObjectRef();
                        CorruptionHandler corruptionHandler3 = dataStoreImpl.corruptionHandler;
                        c02661.L$0 = dataStoreImpl;
                        c02661.L$1 = e;
                        c02661.L$2 = ref$ObjectRef;
                        c02661.L$3 = ref$ObjectRef;
                        c02661.Z$0 = z;
                        c02661.label = 5;
                        objHandleCorruption = corruptionHandler3.handleCorruption(e, c02661);
                        if (objHandleCorruption != coroutine_suspended) {
                            corruptionException = e;
                            version2 = objHandleCorruption;
                            ref$ObjectRef2 = ref$ObjectRef;
                            dataStoreImpl2 = dataStoreImpl;
                            ref$ObjectRef2.element = version2;
                            ref$IntRef = new Ref$IntRef();
                            c02673 = new C02673(ref$ObjectRef, dataStoreImpl2, ref$IntRef, null);
                            c02661.L$0 = corruptionException;
                            c02661.L$1 = ref$ObjectRef;
                            c02661.L$2 = ref$IntRef;
                            c02661.L$3 = null;
                            c02661.label = 6;
                            if (dataStoreImpl2.doWithWriteFileLock(z, c02673, c02661) != coroutine_suspended) {
                                ref$IntRef2 = ref$IntRef;
                                ref$ObjectRef3 = ref$ObjectRef;
                                Object obj4 = ref$ObjectRef3.element;
                                return new Data(obj4, obj4 != null ? obj4.hashCode() : 0, ref$IntRef2.element);
                            }
                        }
                        return coroutine_suspended;
                    }
                case 3:
                    z = c02661.Z$0;
                    dataStoreImpl3 = (DataStoreImpl) c02661.L$0;
                    ResultKt.throwOnFailure(version2);
                    int iIntValue2 = ((Number) version2).intValue();
                    InterProcessCoordinator coordinator5 = dataStoreImpl3.getCoordinator();
                    AnonymousClass2 anonymousClass3 = dataStoreImpl3.new AnonymousClass2(iIntValue2, null);
                    c02661.L$0 = dataStoreImpl3;
                    c02661.Z$0 = z;
                    c02661.label = 4;
                    version2 = coordinator5.tryLock(anonymousClass3, c02661);
                    if (version2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (Data) version2;
                case 4:
                    boolean z3 = c02661.Z$0;
                    ResultKt.throwOnFailure(version2);
                    return (Data) version2;
                case 5:
                    z = c02661.Z$0;
                    Ref$ObjectRef ref$ObjectRef4 = (Ref$ObjectRef) c02661.L$3;
                    Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) c02661.L$2;
                    corruptionException = (CorruptionException) c02661.L$1;
                    DataStoreImpl dataStoreImpl6 = (DataStoreImpl) c02661.L$0;
                    ResultKt.throwOnFailure(version2);
                    ref$ObjectRef2 = ref$ObjectRef4;
                    ref$ObjectRef = ref$ObjectRef5;
                    dataStoreImpl2 = dataStoreImpl6;
                    ref$ObjectRef2.element = version2;
                    ref$IntRef = new Ref$IntRef();
                    c02673 = new C02673(ref$ObjectRef, dataStoreImpl2, ref$IntRef, null);
                    c02661.L$0 = corruptionException;
                    c02661.L$1 = ref$ObjectRef;
                    c02661.L$2 = ref$IntRef;
                    c02661.L$3 = null;
                    c02661.label = 6;
                    if (dataStoreImpl2.doWithWriteFileLock(z, c02673, c02661) != coroutine_suspended) {
                        ref$IntRef2 = ref$IntRef;
                        ref$ObjectRef3 = ref$ObjectRef;
                        Object obj5 = ref$ObjectRef3.element;
                        return new Data(obj5, obj5 != null ? obj5.hashCode() : 0, ref$IntRef2.element);
                    }
                    return coroutine_suspended;
                case 6:
                    ref$IntRef2 = (Ref$IntRef) c02661.L$2;
                    ref$ObjectRef3 = (Ref$ObjectRef) c02661.L$1;
                    corruptionException2 = (CorruptionException) c02661.L$0;
                    try {
                        ResultKt.throwOnFailure(version2);
                        Object obj6 = ref$ObjectRef3.element;
                        return new Data(obj6, obj6 != null ? obj6.hashCode() : 0, ref$IntRef2.element);
                    } catch (Throwable th2) {
                        th = th2;
                        ExceptionsKt.addSuppressed(corruptionException2, th);
                        throw corruptionException2;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CorruptionException e4) {
            e = e4;
            dataStoreImpl = r2;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $preLockVersion;
        Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation continuation) {
            super(2, continuation);
            this.$preLockVersion = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = DataStoreImpl.this.new AnonymousClass2(this.$preLockVersion, continuation);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0059  */
        /* JADX WARN: Code duplicated, block: B:23:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object obj2;
            int iIntValue;
            int iHashCode;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z = this.Z$0;
                DataStoreImpl dataStoreImpl = DataStoreImpl.this;
                this.Z$0 = z;
                this.label = 1;
                obj = dataStoreImpl.readDataFromFileOrDefault(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            iIntValue = ((Number) obj).intValue();
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            return new Data(obj2, iHashCode, iIntValue);
            if (z) {
                InterProcessCoordinator coordinator = DataStoreImpl.this.getCoordinator();
                this.L$0 = obj;
                this.label = 2;
                Object version = coordinator.getVersion(this);
                if (version != coroutine_suspended) {
                    obj2 = obj;
                    obj = version;
                    iIntValue = ((Number) obj).intValue();
                }
                return coroutine_suspended;
            }
            obj2 = obj;
            iIntValue = this.$preLockVersion;
            if (obj2 != null) {
                iHashCode = obj2.hashCode();
            } else {
                iHashCode = 0;
            }
            return new Data(obj2, iHashCode, iIntValue);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3, reason: invalid class name and case insensitive filesystem */
    static final class C02673 extends SuspendLambda implements Function1 {
        final /* synthetic */ Ref$ObjectRef $newData;
        final /* synthetic */ Ref$IntRef $version;
        Object L$0;
        int label;
        final /* synthetic */ DataStoreImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02673(Ref$ObjectRef ref$ObjectRef, DataStoreImpl dataStoreImpl, Ref$IntRef ref$IntRef, Continuation continuation) {
            super(1, continuation);
            this.$newData = ref$ObjectRef;
            this.this$0 = dataStoreImpl;
            this.$version = ref$IntRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C02673(this.$newData, this.this$0, this.$version, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C02673) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$IntRef ref$IntRef;
            Ref$ObjectRef ref$ObjectRef;
            Ref$IntRef ref$IntRef2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ref$ObjectRef = this.$newData;
                    DataStoreImpl dataStoreImpl = this.this$0;
                    this.L$0 = ref$ObjectRef;
                    this.label = 1;
                    obj = dataStoreImpl.readDataFromFileOrDefault(this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ref$ObjectRef = (Ref$ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ref$IntRef = (Ref$IntRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ref$IntRef.element = ((Number) obj).intValue();
                        return Unit.INSTANCE;
                    }
                    ref$IntRef2 = (Ref$IntRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ref$IntRef2.element = ((Number) obj).intValue();
                return Unit.INSTANCE;
                ref$ObjectRef.element = obj;
                ref$IntRef2 = this.$version;
                InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                this.L$0 = ref$IntRef2;
                this.label = 2;
                obj = coordinator.getVersion(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$IntRef2.element = ((Number) obj).intValue();
            } catch (CorruptionException unused) {
                Ref$IntRef ref$IntRef3 = this.$version;
                DataStoreImpl dataStoreImpl2 = this.this$0;
                Object obj2 = this.$newData.element;
                this.L$0 = ref$IntRef3;
                this.label = 3;
                Object objWriteData$datastore_core_release = dataStoreImpl2.writeData$datastore_core_release(obj2, true, this);
                if (objWriteData$datastore_core_release != coroutine_suspended) {
                    ref$IntRef = ref$IntRef3;
                    obj = objWriteData$datastore_core_release;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    private final Object doWithWriteFileLock(boolean z, Function1 function1, Continuation continuation) {
        if (z) {
            return function1.invoke(continuation);
        }
        return getCoordinator().lock(new AnonymousClass3(function1, null), continuation);
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$doWithWriteFileLock$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function1 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Function1 function1, Continuation continuation) {
            super(1, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass3(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function1 function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class InitDataStore extends RunOnce {
        private List initTasks;
        final /* synthetic */ DataStoreImpl this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List initTasksList) {
            Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
            this.this$0 = dataStoreImpl;
            this.initTasks = CollectionsKt.toList(initTasksList);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006e  */
        /* JADX WARN: Code duplicated, block: B:29:0x007c  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.datastore.core.RunOnce
        protected Object doRun(Continuation continuation) throws CorruptionException {
            DataStoreImpl$InitDataStore$doRun$1 dataStoreImpl$InitDataStore$doRun$1;
            InitDataStore initDataStore;
            Data data;
            if (continuation instanceof DataStoreImpl$InitDataStore$doRun$1) {
                dataStoreImpl$InitDataStore$doRun$1 = (DataStoreImpl$InitDataStore$doRun$1) continuation;
                int i = dataStoreImpl$InitDataStore$doRun$1.label;
                if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                    dataStoreImpl$InitDataStore$doRun$1.label = i - LinearLayoutManager.INVALID_OFFSET;
                } else {
                    dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuation);
                }
            } else {
                dataStoreImpl$InitDataStore$doRun$1 = new DataStoreImpl$InitDataStore$doRun$1(this, continuation);
            }
            Object dataOrHandleCorruption = dataStoreImpl$InitDataStore$doRun$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = dataStoreImpl$InitDataStore$doRun$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                List list = this.initTasks;
                if (list != null) {
                    Intrinsics.checkNotNull(list);
                    if (!list.isEmpty()) {
                        InterProcessCoordinator coordinator = this.this$0.getCoordinator();
                        DataStoreImpl$InitDataStore$doRun$initData$1 dataStoreImpl$InitDataStore$doRun$initData$1 = new DataStoreImpl$InitDataStore$doRun$initData$1(this.this$0, this, null);
                        dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                        dataStoreImpl$InitDataStore$doRun$1.label = 2;
                        dataOrHandleCorruption = coordinator.lock(dataStoreImpl$InitDataStore$doRun$initData$1, dataStoreImpl$InitDataStore$doRun$1);
                        if (dataOrHandleCorruption != coroutine_suspended) {
                            initDataStore = this;
                            data = (Data) dataOrHandleCorruption;
                        }
                    } else {
                        DataStoreImpl dataStoreImpl = this.this$0;
                        dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                        dataStoreImpl$InitDataStore$doRun$1.label = 1;
                        dataOrHandleCorruption = dataStoreImpl.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                        if (dataOrHandleCorruption != coroutine_suspended) {
                            initDataStore = this;
                            data = (Data) dataOrHandleCorruption;
                        }
                    }
                } else {
                    DataStoreImpl dataStoreImpl2 = this.this$0;
                    dataStoreImpl$InitDataStore$doRun$1.L$0 = this;
                    dataStoreImpl$InitDataStore$doRun$1.label = 1;
                    dataOrHandleCorruption = dataStoreImpl2.readDataOrHandleCorruption(false, dataStoreImpl$InitDataStore$doRun$1);
                    if (dataOrHandleCorruption != coroutine_suspended) {
                        initDataStore = this;
                        data = (Data) dataOrHandleCorruption;
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                initDataStore = (InitDataStore) dataStoreImpl$InitDataStore$doRun$1.L$0;
                ResultKt.throwOnFailure(dataOrHandleCorruption);
                data = (Data) dataOrHandleCorruption;
            }
            initDataStore.this$0.inMemoryCache.tryUpdate(data);
            return Unit.INSTANCE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
