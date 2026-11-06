package com.revenuecat.purchases.react;

/* JADX INFO: loaded from: classes4.dex */
class GoogleUpgradeInfo {
    private final String oldProductIdentifier;
    private final Integer prorationMode;

    public GoogleUpgradeInfo(String str, Integer num) {
        this.oldProductIdentifier = str;
        this.prorationMode = num;
    }

    public String getOldProductIdentifier() {
        return this.oldProductIdentifier;
    }

    public Integer getProrationMode() {
        return this.prorationMode;
    }
}
