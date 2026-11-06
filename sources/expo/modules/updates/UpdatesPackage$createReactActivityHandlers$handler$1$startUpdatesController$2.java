package expo.modules.updates;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $useDeveloperSupport;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2(Context context, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$useDeveloperSupport = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2(this.$context, this.$useDeveloperSupport, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!UpdatesPackage.INSTANCE.isUsingCustomInit$expo_updates_release()) {
            UpdatesController.initialize(this.$context, this.$useDeveloperSupport);
            UpdatesController.getInstance().getLaunchAssetFile();
        }
        return Unit.INSTANCE;
    }
}
