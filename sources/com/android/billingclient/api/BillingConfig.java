package com.android.billingclient.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingConfig {
    private final String countryCode;

    BillingConfig(String str) {
        this.countryCode = new JSONObject(str).optString("countryCode");
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}
