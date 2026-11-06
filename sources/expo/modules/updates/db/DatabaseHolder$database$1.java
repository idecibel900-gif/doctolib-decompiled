package expo.modules.updates.db;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes4.dex */
final class DatabaseHolder$database$1 extends SuspendLambda implements Function2 {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DatabaseHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatabaseHolder$database$1(DatabaseHolder databaseHolder, Continuation continuation) {
        super(2, continuation);
        this.this$0 = databaseHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DatabaseHolder$database$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DatabaseHolder$database$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        DatabaseHolder databaseHolder;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.mutex;
            DatabaseHolder databaseHolder2 = this.this$0;
            this.L$0 = mutex;
            this.L$1 = databaseHolder2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            databaseHolder = databaseHolder2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            databaseHolder = (DatabaseHolder) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return databaseHolder.mDatabase;
        } finally {
            mutex.unlock(null);
        }
    }
}
