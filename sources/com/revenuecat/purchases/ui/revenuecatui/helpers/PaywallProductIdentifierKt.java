package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"paywallProductIdentifier", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallProductIdentifierKt {
    public static final String paywallProductIdentifier(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        if (storeProduct instanceof GoogleStoreProduct) {
            return ((GoogleStoreProduct) storeProduct).getProductId();
        }
        return storeProduct.getId();
    }
}
