package com.doctolib.apps.authentication.client;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
final class AuthClient$Companion$initialize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthClient.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthClient$Companion$initialize$1(AuthClient.Companion companion, Continuation continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.initialize(null, null, this);
    }
}
