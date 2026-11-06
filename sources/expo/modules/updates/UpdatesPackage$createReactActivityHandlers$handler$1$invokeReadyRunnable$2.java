package expo.modules.updates;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Runnable $whenReadyRunnable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2(Runnable runnable, Continuation continuation) {
        super(2, continuation);
        this.$whenReadyRunnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2(this.$whenReadyRunnable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$whenReadyRunnable.run();
        return Unit.INSTANCE;
    }
}
