package com.doctolib.apps.authentication.internal.core;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
final class AuthenticationManager$authorizeViaBrowser$resultIntent$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ CompletableDeferred $flowResult;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticationManager$authorizeViaBrowser$resultIntent$1(CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.$flowResult = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AuthenticationManager$authorizeViaBrowser$resultIntent$1(this.$flowResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AuthenticationManager$authorizeViaBrowser$resultIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        CompletableDeferred completableDeferred = this.$flowResult;
        this.label = 1;
        Object objAwait = completableDeferred.await(this);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }
}
