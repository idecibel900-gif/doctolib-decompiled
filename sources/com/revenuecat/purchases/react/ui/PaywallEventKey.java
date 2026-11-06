package com.revenuecat.purchases.react.ui;

import com.amazon.a.a.m.c;
import com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", c.f, "REQUEST_ID", "CUSTOMER_INFO", "STORE_TRANSACTION", HybridPurchaseLogicBridge.RESULT_ERROR, "MEASUREMENTS", "HEIGHT", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum PaywallEventKey {
    PACKAGE(HybridPurchaseLogicBridge.EVENT_KEY_PACKAGE_BEING_PURCHASED),
    REQUEST_ID("requestId"),
    CUSTOMER_INFO("customerInfo"),
    STORE_TRANSACTION("storeTransaction"),
    ERROR("error"),
    MEASUREMENTS("measurements"),
    HEIGHT("height");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String key;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    PaywallEventKey(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
