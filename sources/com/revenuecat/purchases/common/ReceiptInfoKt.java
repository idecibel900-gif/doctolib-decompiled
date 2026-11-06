package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"platformProductId", "Lcom/revenuecat/purchases/common/PlatformProductId;", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReceiptInfoKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformProductId platformProductId(StoreProduct storeProduct) {
        return new PlatformProductId(storeProduct.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformProductId platformProductId(SubscriptionOption subscriptionOption) {
        if (!(subscriptionOption instanceof GoogleSubscriptionOption)) {
            return null;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) subscriptionOption;
        return new GooglePlatformProductId(googleSubscriptionOption.getProductId(), googleSubscriptionOption.getBasePlanId(), googleSubscriptionOption.getOfferId());
    }
}
