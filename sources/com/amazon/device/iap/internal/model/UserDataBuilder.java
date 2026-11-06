package com.amazon.device.iap.internal.model;

import com.amazon.device.iap.model.LWAConsentStatus;
import com.amazon.device.iap.model.UserData;

/* JADX INFO: loaded from: classes3.dex */
public class UserDataBuilder {
    private LWAConsentStatus lwaConsentStatus;
    private String marketplace;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public String getMarketplace() {
        return this.marketplace;
    }

    public LWAConsentStatus getLWAConsentStatus() {
        return this.lwaConsentStatus;
    }

    public UserData build() {
        return new UserData(this);
    }

    public UserDataBuilder setUserId(String str) {
        this.userId = str;
        return this;
    }

    public UserDataBuilder setMarketplace(String str) {
        this.marketplace = str;
        return this;
    }

    public UserDataBuilder setLWAConsentStatus(String str) {
        this.lwaConsentStatus = LWAConsentStatus.getEnumForValue(str);
        return this;
    }
}
