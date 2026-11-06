package com.adjust.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustPlayStorePurchase {
    private final String productId;
    private final String purchaseToken;

    public AdjustPlayStorePurchase(String str, String str2) {
        this.productId = str;
        this.purchaseToken = str2;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }
}
