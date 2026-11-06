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
public final class UpdatesModule$definition$lambda$18$$inlined$Coroutine$3 extends SuspendLambda implements Function3 {
    int label;

    public UpdatesModule$definition$lambda$18$$inlined$Coroutine$3(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        return new UpdatesModule$definition$lambda$18$$inlined$Coroutine$3(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CodedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IUpdatesController updatesController = UpdatesController.getInstance();
            this.label = 1;
            obj = updatesController.checkForUpdate(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        IUpdatesController.CheckForUpdateResult checkForUpdateResult = (IUpdatesController.CheckForUpdateResult) obj;
        if (checkForUpdateResult instanceof IUpdatesController.CheckForUpdateResult.ErrorResult) {
            throw new CodedException("ERR_UPDATES_CHECK", "Failed to check for update", ((IUpdatesController.CheckForUpdateResult.ErrorResult) checkForUpdateResult).getError());
        }
        if (checkForUpdateResult instanceof IUpdatesController.CheckForUpdateResult.NoUpdateAvailable) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRollBackToEmbedded", false);
            bundle.putBoolean("isAvailable", false);
            bundle.putString("reason", ((IUpdatesController.CheckForUpdateResult.NoUpdateAvailable) checkForUpdateResult).getReason().getValue());
            return bundle;
        }
        if (checkForUpdateResult instanceof IUpdatesController.CheckForUpdateResult.RollBackToEmbedded) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isRollBackToEmbedded", true);
            bundle2.putBoolean("isAvailable", false);
            return bundle2;
        }
        if (!(checkForUpdateResult instanceof IUpdatesController.CheckForUpdateResult.UpdateAvailable)) {
            throw new NoWhenBranchMatchedException();
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("isRollBackToEmbedded", false);
        bundle3.putBoolean("isAvailable", true);
        bundle3.putString("manifestString", ((IUpdatesController.CheckForUpdateResult.UpdateAvailable) checkForUpdateResult).getUpdate().getManifest().toString());
        return bundle3;
    }
}
