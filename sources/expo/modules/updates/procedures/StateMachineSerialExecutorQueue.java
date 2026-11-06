package expo.modules.updates.procedures;

import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.updates.logging.IUpdatesLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes5.dex */
public final class StateMachineSerialExecutorQueue {
    private final Job executorJob;
    private final Mutex mutex;
    private final Channel procedureChannel;
    private final CoroutineScope scope;
    private final StateMachineProcedure.StateMachineProcedureContext stateMachineProcedureContext;
    private final IUpdatesLogger updatesLogger;

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1, reason: invalid class name and case insensitive filesystem */
    static final class C11091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11091(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return StateMachineSerialExecutorQueue.this.executeProcedure(null, this);
        }
    }

    public StateMachineSerialExecutorQueue(IUpdatesLogger updatesLogger, StateMachineProcedure.StateMachineProcedureContext stateMachineProcedureContext, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(updatesLogger, "updatesLogger");
        Intrinsics.checkNotNullParameter(stateMachineProcedureContext, "stateMachineProcedureContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.updatesLogger = updatesLogger;
        this.stateMachineProcedureContext = stateMachineProcedureContext;
        this.scope = scope;
        this.procedureChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.executorJob = BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    private static final class ProcedureHolder {
        private final CompletableDeferred onComplete;
        private final StateMachineProcedure procedure;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcedureHolder)) {
                return false;
            }
            ProcedureHolder procedureHolder = (ProcedureHolder) obj;
            return Intrinsics.areEqual(this.procedure, procedureHolder.procedure) && Intrinsics.areEqual(this.onComplete, procedureHolder.onComplete);
        }

        public int hashCode() {
            return (this.procedure.hashCode() * 31) + this.onComplete.hashCode();
        }

        public String toString() {
            return "ProcedureHolder(procedure=" + this.procedure + ", onComplete=" + this.onComplete + ")";
        }

        public ProcedureHolder(StateMachineProcedure procedure, CompletableDeferred onComplete) {
            Intrinsics.checkNotNullParameter(procedure, "procedure");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            this.procedure = procedure;
            this.onComplete = onComplete;
        }

        public final StateMachineProcedure getProcedure() {
            return this.procedure;
        }

        public final CompletableDeferred getOnComplete() {
            return this.onComplete;
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StateMachineSerialExecutorQueue.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003f  */
        /* JADX WARN: Code duplicated, block: B:18:0x004a  */
        /* JADX WARN: Code duplicated, block: B:21:0x005d  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        
            if (r4.executeProcedure(r7, r6) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005a -> B:7:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r7)
            L15:
                r7 = r1
                goto L34
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                java.lang.Object r1 = r6.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L42
            L27:
                kotlin.ResultKt.throwOnFailure(r7)
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue r7 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.this
                kotlinx.coroutines.channels.Channel r7 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.access$getProcedureChannel$p(r7)
                kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            L34:
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r1 = r7.hasNext(r6)
                if (r1 != r0) goto L3f
                goto L5c
            L3f:
                r5 = r1
                r1 = r7
                r7 = r5
            L42:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L5d
                java.lang.Object r7 = r1.next()
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r7 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r7
                expo.modules.updates.procedures.StateMachineSerialExecutorQueue r4 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.this
                r6.L$0 = r1
                r6.label = r2
                java.lang.Object r7 = expo.modules.updates.procedures.StateMachineSerialExecutorQueue.access$executeProcedure(r4, r7, r6)
                if (r7 != r0) goto L15
            L5c:
                return r0
            L5d:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.procedures.StateMachineSerialExecutorQueue.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r7.await(r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeProcedure(final expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof expo.modules.updates.procedures.StateMachineSerialExecutorQueue.C11091
            if (r0 == 0) goto L13
            r0 = r8
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1 r0 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.C11091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1 r0 = new expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L71
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$0
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder r7 = (expo.modules.updates.procedures.StateMachineSerialExecutorQueue.ProcedureHolder) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.updates.logging.IUpdatesLogger r8 = r6.updatesLogger
            expo.modules.updates.procedures.StateMachineProcedure r2 = r7.getProcedure()
            java.lang.String r2 = r2.getLoggerTimerLabel()
            expo.modules.core.logging.LoggerTimer r8 = r8.startTimer(r2)
            expo.modules.updates.procedures.StateMachineProcedure r2 = r7.getProcedure()
            expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$2 r5 = new expo.modules.updates.procedures.StateMachineSerialExecutorQueue$executeProcedure$2
            r5.<init>()
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r2.run(r5, r0)
            if (r8 != r1) goto L61
            goto L70
        L61:
            kotlinx.coroutines.CompletableDeferred r7 = r7.getOnComplete()
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L71
        L70:
            return r1
        L71:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.procedures.StateMachineSerialExecutorQueue.executeProcedure(expo.modules.updates.procedures.StateMachineSerialExecutorQueue$ProcedureHolder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StateMachineSerialExecutorQueue$queueExecution$1, reason: invalid class name and case insensitive filesystem */
    static final class C11101 extends SuspendLambda implements Function2 {
        final /* synthetic */ StateMachineProcedure $stateMachineProcedure;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11101(StateMachineProcedure stateMachineProcedure, Continuation continuation) {
            super(2, continuation);
            this.$stateMachineProcedure = stateMachineProcedure;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return StateMachineSerialExecutorQueue.this.new C11101(this.$stateMachineProcedure, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            StateMachineSerialExecutorQueue stateMachineSerialExecutorQueue;
            StateMachineProcedure stateMachineProcedure;
            Mutex mutex2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = StateMachineSerialExecutorQueue.this.mutex;
                    stateMachineSerialExecutorQueue = StateMachineSerialExecutorQueue.this;
                    stateMachineProcedure = this.$stateMachineProcedure;
                    this.L$0 = mutex;
                    this.L$1 = stateMachineSerialExecutorQueue;
                    this.L$2 = stateMachineProcedure;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                stateMachineProcedure = (StateMachineProcedure) this.L$2;
                stateMachineSerialExecutorQueue = (StateMachineSerialExecutorQueue) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                Channel channel = stateMachineSerialExecutorQueue.procedureChannel;
                ProcedureHolder procedureHolder = new ProcedureHolder(stateMachineProcedure, completableDeferredCompletableDeferred$default);
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (channel.send(procedureHolder, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public final void queueExecution(StateMachineProcedure stateMachineProcedure) {
        Intrinsics.checkNotNullParameter(stateMachineProcedure, "stateMachineProcedure");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11101(stateMachineProcedure, null), 3, null);
    }
}
