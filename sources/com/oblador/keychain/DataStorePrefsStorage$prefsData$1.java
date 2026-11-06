package com.oblador.keychain;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes4.dex */
final class DataStorePrefsStorage$prefsData$1 extends SuspendLambda implements Function1 {
    int label;
    final /* synthetic */ DataStorePrefsStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStorePrefsStorage$prefsData$1(DataStorePrefsStorage dataStorePrefsStorage, Continuation continuation) {
        super(1, continuation);
        this.this$0 = dataStorePrefsStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStorePrefsStorage$prefsData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DataStorePrefsStorage$prefsData$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Flow data = this.this$0.prefs.getData();
        this.label = 1;
        Object objFirst = FlowKt.first(data, this);
        return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
    }
}
