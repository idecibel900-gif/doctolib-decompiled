package com.revenuecat.purchases.react.ui.events;

import com.revenuecat.purchases.react.ui.PaywallEventKey;
import com.revenuecat.purchases.react.ui.PaywallEventName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/react/ui/events/OnPurchaseCancelledEvent;", "Lcom/revenuecat/purchases/react/ui/events/PaywallEvent;", "surfaceId", "", "viewTag", "<init>", "(II)V", "getPaywallEventName", "Lcom/revenuecat/purchases/react/ui/PaywallEventName;", "getPayload", "", "Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "", "", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnPurchaseCancelledEvent extends PaywallEvent<OnPurchaseCancelledEvent> {
    public OnPurchaseCancelledEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public PaywallEventName getPaywallEventName() {
        return PaywallEventName.ON_PURCHASE_CANCELLED;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public Map<PaywallEventKey, Map<String, Object>> getPayload() {
        return MapsKt.emptyMap();
    }
}
