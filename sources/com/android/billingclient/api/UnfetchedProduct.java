package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class UnfetchedProduct {
    private final String jsonString;
    private final String productId;
    private final String productType;
    private final String serializedDocid;
    private final int statusCode;

    UnfetchedProduct(String str) {
        this.jsonString = str;
        JSONObject jSONObject = new JSONObject(str);
        this.productId = jSONObject.optString("productId");
        String strOptString = jSONObject.optString("type");
        this.productType = strOptString;
        this.statusCode = jSONObject.has("statusCode") ? jSONObject.optInt("statusCode") : 0;
        if (TextUtils.isEmpty(strOptString)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.serializedDocid = jSONObject.optString("serializedDocid");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnfetchedProduct) {
            return TextUtils.equals(this.jsonString, ((UnfetchedProduct) obj).jsonString);
        }
        return false;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getSerializedDocid() {
        return this.serializedDocid;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return this.jsonString.hashCode();
    }

    public String toString() {
        return "UnfetchedProduct{productId='" + this.productId + "', productType='" + this.productType + "', statusCode=" + this.statusCode + "}";
    }
}
