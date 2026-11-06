package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/ProductChangeCallback;", "Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "onCompleted", "", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ProductChangeCallback extends PurchaseErrorCallback {
    void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo);
}
