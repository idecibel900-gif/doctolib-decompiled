package com.revenuecat.purchases;

import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Purchases$awaitGetWorkflow$2$1 extends FunctionReferenceImpl implements Function1 {
    Purchases$awaitGetWorkflow$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WorkflowDataResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(WorkflowDataResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((Continuation) this.receiver).resumeWith(Result.m5243constructorimpl(p0));
    }
}
