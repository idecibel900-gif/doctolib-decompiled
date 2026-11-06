package expo.modules.updates.procedures;

import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.UpdateEntity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
final class StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ StartupProcedure this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(StartupProcedure startupProcedure, Continuation continuation) {
        super(2, continuation);
        this.this$0 = startupProcedure;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UpdateEntity launchedUpdate = this.this$0.getLaunchedUpdate();
            if (launchedUpdate == null) {
                return Unit.INSTANCE;
            }
            DatabaseHolder databaseHolder = this.this$0.databaseHolder;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(launchedUpdate, null);
            this.label = 1;
            if (databaseHolder.withDatabase(anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: expo.modules.updates.procedures.StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ UpdateEntity $launchedUpdate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdateEntity updateEntity, Continuation continuation) {
            super(2, continuation);
            this.$launchedUpdate = updateEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$launchedUpdate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(UpdatesDatabase updatesDatabase, Continuation continuation) {
            return ((AnonymousClass1) create(updatesDatabase, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((UpdatesDatabase) this.L$0).updateDao().incrementFailedLaunchCount(this.$launchedUpdate);
            return Unit.INSTANCE;
        }
    }
}
