package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
final class StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1 extends SuspendLambda implements Function2 {
    int label;

    StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation continuation) {
        return ((StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
