package com.revenuecat.purchases.react.ui.events;

import com.revenuecat.purchases.react.ui.PaywallEventKey;
import com.revenuecat.purchases.react.ui.PaywallEventName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\f0\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/react/ui/events/OnMeasureEvent;", "Lcom/revenuecat/purchases/react/ui/events/PaywallEvent;", "Lcom/revenuecat/purchases/react/ui/events/OnDismissEvent;", "surfaceId", "", "viewTag", "height", "<init>", "(III)V", "getPaywallEventName", "Lcom/revenuecat/purchases/react/ui/PaywallEventName;", "getPayload", "", "Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnMeasureEvent extends PaywallEvent<OnDismissEvent> {
    private final int height;

    public OnMeasureEvent(int i, int i2, int i3) {
        super(i, i2);
        this.height = i3;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public PaywallEventName getPaywallEventName() {
        return PaywallEventName.ON_MEASURE;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public Map<PaywallEventKey, Map<String, Integer>> getPayload() {
        return MapsKt.mapOf(TuplesKt.to(PaywallEventKey.MEASUREMENTS, MapsKt.mapOf(TuplesKt.to(PaywallEventKey.HEIGHT.getKey(), Integer.valueOf(this.height)))));
    }
}
