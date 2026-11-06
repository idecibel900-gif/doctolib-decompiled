package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ReceiveCustomerInfoCallback {
    void onError(PurchasesError error);

    void onReceived(CustomerInfo customerInfo);
}
