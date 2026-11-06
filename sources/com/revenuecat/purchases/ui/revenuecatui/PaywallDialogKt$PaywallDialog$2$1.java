package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$2$1", f = "PaywallDialog.kt", l = {}, m = "invokeSuspend")
final class PaywallDialogKt$PaywallDialog$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ MutableState $currentDialogOffering$delegate;
    final /* synthetic */ PaywallDialogOptions $paywallDialogOptions;
    final /* synthetic */ MutableState $shouldDisplayDialog$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallDialogKt$PaywallDialog$2$1(PaywallDialogOptions paywallDialogOptions, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$paywallDialogOptions = paywallDialogOptions;
        this.$shouldDisplayDialog$delegate = mutableState;
        this.$currentDialogOffering$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PaywallDialogKt$PaywallDialog$2$1(this.$paywallDialogOptions, this.$shouldDisplayDialog$delegate, this.$currentDialogOffering$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PaywallDialogKt$PaywallDialog$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (PaywallDialogKt.PaywallDialog$lambda$1(this.$shouldDisplayDialog$delegate) && PaywallDialogKt.PaywallDialog$lambda$5(this.$currentDialogOffering$delegate) == null) {
                this.$currentDialogOffering$delegate.setValue(this.$paywallDialogOptions.getOfferingSelection$revenuecatui_defaultsBc8Release());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
