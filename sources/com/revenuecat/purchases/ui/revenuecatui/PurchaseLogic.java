package com.revenuecat.purchases.ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.Package;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogic;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "performPurchase", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "activity", "Landroid/app/Activity;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "params", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PurchaseLogic extends PaywallPurchaseLogic {
    Object performPurchase(Activity activity, Package r2, Continuation continuation);

    @Override // com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic
    Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation continuation);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object performPurchase(PurchaseLogic purchaseLogic, Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation continuation) {
            return purchaseLogic.performPurchase(activity, paywallPurchaseLogicParams.getRcPackage(), continuation);
        }
    }
}
