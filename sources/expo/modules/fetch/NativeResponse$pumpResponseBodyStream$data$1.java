package expo.modules.fetch;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
final class NativeResponse$pumpResponseBodyStream$data$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ BufferedSource $stream;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeResponse$pumpResponseBodyStream$data$1(BufferedSource bufferedSource, Continuation continuation) {
        super(2, continuation);
        this.$stream = bufferedSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NativeResponse$pumpResponseBodyStream$data$1(this.$stream, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NativeResponse$pumpResponseBodyStream$data$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$stream.exhausted()) {
            return null;
        }
        return this.$stream.getBuffer().readByteArray();
    }
}
