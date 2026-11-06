package com.revenuecat.purchases.ui.revenuecatui.components.pkg;

import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.style.PackageComponentStyle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$4$1", f = "PackageComponentView.kt", l = {36}, m = "invokeSuspend")
public final class PackageComponentViewKt$PackageComponentView$4$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $clickHandler;
    final /* synthetic */ PackageComponentStyle $style;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PackageComponentViewKt$PackageComponentView$4$1(PackageComponentStyle packageComponentStyle, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$style = packageComponentStyle;
        this.$clickHandler = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PackageComponentViewKt$PackageComponentView$4$1 packageComponentViewKt$PackageComponentView$4$1 = new PackageComponentViewKt$PackageComponentView$4$1(this.$style, this.$clickHandler, continuation);
        packageComponentViewKt$PackageComponentView$4$1.L$0 = obj;
        return packageComponentViewKt$PackageComponentView$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation continuation) {
        return ((PackageComponentViewKt$PackageComponentView$4$1) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PaywallAction paywallAction = (PaywallAction) this.L$0;
            if (!this.$style.isSelectable()) {
                Function2 function2 = this.$clickHandler;
                this.label = 1;
                if (function2.invoke(paywallAction, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
