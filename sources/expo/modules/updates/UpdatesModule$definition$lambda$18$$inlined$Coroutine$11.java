package expo.modules.updates;

import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesModule$definition$lambda$18$$inlined$Coroutine$11 extends SuspendLambda implements Function3 {
    int label;
    final /* synthetic */ UpdatesModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatesModule$definition$lambda$18$$inlined$Coroutine$11(Continuation continuation, UpdatesModule updatesModule) {
        super(3, continuation);
        this.this$0 = updatesModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        return new UpdatesModule$definition$lambda$18$$inlined$Coroutine$11(continuation, this.this$0).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UpdatesModule.Companion companion = UpdatesModule.INSTANCE;
            File filesDir = this.this$0.getContext().getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
            UpdatesModule$definition$1$11$1 updatesModule$definition$1$11$1 = new Function1() { // from class: expo.modules.updates.UpdatesModule$definition$1$11$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) throws CodedException {
                    invoke((Exception) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Exception exc) throws CodedException {
                    if (exc != null) {
                        throw new CodedException("ERR_UPDATES_READ_LOGS", "There was an error when clearing the expo-updates log file", exc);
                    }
                }
            };
            this.label = 1;
            if (companion.clearLogEntries$expo_updates_release(filesDir, updatesModule$definition$1$11$1, this) == coroutine_suspended) {
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
