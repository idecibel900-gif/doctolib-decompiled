package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.material3.ColorScheme;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$1$1", f = "InternalCustomerCenter.kt", l = {}, m = "invokeSuspend")
final class InternalCustomerCenterKt$InternalCustomerCenter$1$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ColorScheme $colorScheme;
    final /* synthetic */ boolean $isDark;
    final /* synthetic */ CustomerCenterViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalCustomerCenterKt$InternalCustomerCenter$1$1(CustomerCenterViewModel customerCenterViewModel, ColorScheme colorScheme, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$viewModel = customerCenterViewModel;
        this.$colorScheme = colorScheme;
        this.$isDark = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InternalCustomerCenterKt$InternalCustomerCenter$1$1(this.$viewModel, this.$colorScheme, this.$isDark, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InternalCustomerCenterKt$InternalCustomerCenter$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.refreshColors(this.$colorScheme, this.$isDark);
        return Unit.INSTANCE;
    }
}
