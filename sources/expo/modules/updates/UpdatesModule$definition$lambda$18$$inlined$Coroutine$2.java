package expo.modules.updates;

import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.reloadscreen.ReloadScreenOptions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesModule$definition$lambda$18$$inlined$Coroutine$2 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;

    public UpdatesModule$definition$lambda$18$$inlined$Coroutine$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        UpdatesModule$definition$lambda$18$$inlined$Coroutine$2 updatesModule$definition$lambda$18$$inlined$Coroutine$2 = new UpdatesModule$definition$lambda$18$$inlined$Coroutine$2(continuation);
        updatesModule$definition$lambda$18$$inlined$Coroutine$2.L$0 = objArr;
        return updatesModule$definition$lambda$18$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReloadScreenOptions reloadScreenOptions = (ReloadScreenOptions) ((Object[]) this.L$0)[0];
            ReloadScreenManager reloadScreenManager = UpdatesController.getInstance().getReloadScreenManager();
            if (reloadScreenManager != null) {
                reloadScreenManager.setConfiguration(reloadScreenOptions);
            }
            IUpdatesController updatesController = UpdatesController.getInstance();
            this.label = 1;
            if (updatesController.relaunchReactApplicationForModule(this) == coroutine_suspended) {
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
