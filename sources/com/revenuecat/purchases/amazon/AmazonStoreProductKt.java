package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"amazonProduct", "Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "getAmazonProduct", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AmazonStoreProductKt {
    public static final AmazonStoreProduct getAmazonProduct(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        if (storeProduct instanceof AmazonStoreProduct) {
            return (AmazonStoreProduct) storeProduct;
        }
        return null;
    }
}
