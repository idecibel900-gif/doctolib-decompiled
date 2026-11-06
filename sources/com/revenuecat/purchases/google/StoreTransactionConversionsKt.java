package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aP\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"originalGooglePurchase", "Lcom/android/billingclient/api/Purchase;", "Lcom/revenuecat/purchases/models/StoreTransaction;", "getOriginalGooglePurchase", "(Lcom/revenuecat/purchases/models/StoreTransaction;)Lcom/android/billingclient/api/Purchase;", "toStoreTransaction", "productType", "Lcom/revenuecat/purchases/ProductType;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "subscriptionOptionId", "", "subscriptionOptionIdForProductIDs", "", "replacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "purchaseContext", "Lcom/revenuecat/purchases/google/PurchaseContext;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StoreTransactionConversionsKt {
    public static /* synthetic */ StoreTransaction toStoreTransaction$default(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, Map map, StoreReplacementMode storeReplacementMode, int i, Object obj) {
        if ((i & 2) != 0) {
            presentedOfferingContext = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            map = null;
        }
        if ((i & 16) != 0) {
            storeReplacementMode = null;
        }
        return toStoreTransaction(purchase, productType, presentedOfferingContext, str, map, storeReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, Map<String, String> map, StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(productType, "productType");
        String orderId = purchase.getOrderId();
        List products = purchase.getProducts();
        Intrinsics.checkNotNullExpressionValue(products, "this.products");
        long purchaseTime = purchase.getPurchaseTime();
        String purchaseToken = purchase.getPurchaseToken();
        Intrinsics.checkNotNullExpressionValue(purchaseToken, "this.purchaseToken");
        return new StoreTransaction(orderId, products, productType, purchaseTime, purchaseToken, PurchaseStateConversionsKt.toRevenueCatPurchaseState(purchase.getPurchaseState()), Boolean.valueOf(purchase.isAutoRenewing()), purchase.getSignature(), new JSONObject(purchase.getOriginalJson()), presentedOfferingContext, null, PurchaseType.GOOGLE_PURCHASE, null, str, map, storeReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, PurchaseContext purchaseContext) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(purchaseContext, "purchaseContext");
        return toStoreTransaction(purchase, purchaseContext.getProductType(), purchaseContext.getPresentedOfferingContext(), purchaseContext.getSelectedSubscriptionOptionId(), purchaseContext.getSubscriptionOptionIdForProductIDs(), purchaseContext.getReplacementMode());
    }

    public static final Purchase getOriginalGooglePurchase(StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(storeTransaction, "<this>");
        String signature = storeTransaction.getSignature();
        if (signature == null) {
            return null;
        }
        if (storeTransaction.getPurchaseType() != PurchaseType.GOOGLE_PURCHASE) {
            signature = null;
        }
        if (signature != null) {
            return new Purchase(storeTransaction.getOriginalJson().toString(), signature);
        }
        return null;
    }
}
