package expo.modules.splashscreen;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class SplashScreenModule$definition$1$3$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ SplashScreenOptions $options;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenModule$definition$1$3$1(SplashScreenOptions splashScreenOptions, Continuation continuation) {
        super(2, continuation);
        this.$options = splashScreenOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SplashScreenModule$definition$1$3$1(this.$options, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SplashScreenModule$definition$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SplashScreenManager.INSTANCE.setSplashScreenOptions(this.$options);
        return Unit.INSTANCE;
    }
}
