package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ui.revenuecatui.helpers.CancellableContinuationExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rH&J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\rH&¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicWithCallback;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "()V", "performPurchase", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "activity", "Landroid/app/Activity;", "params", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performPurchaseWithCompletion", "", "completion", "Lkotlin/Function1;", "performRestore", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRestoreWithCompletion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallPurchaseLogicWithCallback implements PaywallPurchaseLogic {
    public static final int $stable = 0;

    public abstract void performPurchaseWithCompletion(Activity activity, PaywallPurchaseLogicParams params, Function1 completion);

    public abstract void performRestoreWithCompletion(CustomerInfo customerInfo, Function1 completion);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public final Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        performPurchaseWithCompletion(activity, paywallPurchaseLogicParams, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogicWithCallback$performPurchase$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchaseLogicResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, result);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    public final Object performRestore(CustomerInfo customerInfo, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        performRestoreWithCompletion(customerInfo, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogicWithCallback$performRestore$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchaseLogicResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchaseLogicResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, result);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
