package expo.modules.updates;

import android.os.Bundle;
import expo.modules.kotlin.exception.CodedException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesModule$definition$lambda$18$$inlined$Coroutine$4 extends SuspendLambda implements Function3 {
    int label;

    public UpdatesModule$definition$lambda$18$$inlined$Coroutine$4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        return new UpdatesModule$definition$lambda$18$$inlined$Coroutine$4(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CodedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IUpdatesController updatesController = UpdatesController.getInstance();
            this.label = 1;
            obj = updatesController.fetchUpdate(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        IUpdatesController.FetchUpdateResult fetchUpdateResult = (IUpdatesController.FetchUpdateResult) obj;
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.ErrorResult) {
            throw new CodedException("ERR_UPDATES_FETCH", "Failed to download new update", ((IUpdatesController.FetchUpdateResult.ErrorResult) fetchUpdateResult).getError());
        }
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.Failure) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRollBackToEmbedded", false);
            bundle.putBoolean("isNew", false);
            return bundle;
        }
        if (fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.RollBackToEmbedded) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isRollBackToEmbedded", true);
            bundle2.putBoolean("isNew", false);
            return bundle2;
        }
        if (!(fetchUpdateResult instanceof IUpdatesController.FetchUpdateResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("isRollBackToEmbedded", false);
        bundle3.putBoolean("isNew", true);
        bundle3.putString("manifestString", ((IUpdatesController.FetchUpdateResult.Success) fetchUpdateResult).getUpdate().getManifest().toString());
        return bundle3;
    }
}
