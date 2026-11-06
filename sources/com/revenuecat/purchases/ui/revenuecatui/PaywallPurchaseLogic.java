package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.CustomerInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "", "performPurchase", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "activity", "Landroid/app/Activity;", "params", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRestore", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallPurchaseLogic {
    Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation continuation);

    Object performRestore(CustomerInfo customerInfo, Continuation continuation);
}
