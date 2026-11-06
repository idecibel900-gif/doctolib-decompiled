package expo.modules.updates;

import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesModule$definition$lambda$18$$inlined$Coroutine$10 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UpdatesModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatesModule$definition$lambda$18$$inlined$Coroutine$10(Continuation continuation, UpdatesModule updatesModule) {
        super(3, continuation);
        this.this$0 = updatesModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        UpdatesModule$definition$lambda$18$$inlined$Coroutine$10 updatesModule$definition$lambda$18$$inlined$Coroutine$10 = new UpdatesModule$definition$lambda$18$$inlined$Coroutine$10(continuation, this.this$0);
        updatesModule$definition$lambda$18$$inlined$Coroutine$10.L$0 = objArr;
        return updatesModule$definition$lambda$18$$inlined$Coroutine$10.invokeSuspend(Unit.INSTANCE);
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
        long jLongValue = ((Number) ((Object[]) this.L$0)[0]).longValue();
        UpdatesModule.Companion companion = UpdatesModule.INSTANCE;
        File filesDir = this.this$0.getContext().getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.label = 1;
        Object logEntries$expo_updates_release = companion.readLogEntries$expo_updates_release(filesDir, jLongValue, this);
        return logEntries$expo_updates_release == coroutine_suspended ? coroutine_suspended : logEntries$expo_updates_release;
    }
}
