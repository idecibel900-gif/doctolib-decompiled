package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.MutableState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1", f = "PaywallDialog.kt", l = {}, m = "invokeSuspend")
final class PaywallDialogKt$PaywallDialog$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1 $shouldDisplayBlock;
    final /* synthetic */ MutableState $shouldDisplayDialog$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallDialogKt$PaywallDialog$1$1(Function1 function1, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$shouldDisplayBlock = function1;
        this.$shouldDisplayDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PaywallDialogKt$PaywallDialog$1$1 paywallDialogKt$PaywallDialog$1$1 = new PaywallDialogKt$PaywallDialog$1$1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, continuation);
        paywallDialogKt$PaywallDialog$1$1.L$0 = obj;
        return paywallDialogKt$PaywallDialog$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PaywallDialogKt$PaywallDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$1$1$1", f = "PaywallDialog.kt", l = {30}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $shouldDisplayBlock;
        final /* synthetic */ MutableState $shouldDisplayDialog$delegate;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.$shouldDisplayBlock = function1;
            this.$shouldDisplayDialog$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableState mutableState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableState mutableState2 = this.$shouldDisplayDialog$delegate;
                Function1 function1 = this.$shouldDisplayBlock;
                this.L$0 = mutableState2;
                this.label = 1;
                Object objShouldDisplayPaywall = HelperFunctionsKt.shouldDisplayPaywall(function1, this);
                if (objShouldDisplayPaywall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState = mutableState2;
                obj = objShouldDisplayPaywall;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            PaywallDialogKt.PaywallDialog$lambda$2(mutableState, ((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$shouldDisplayBlock, this.$shouldDisplayDialog$delegate, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
