package com.revenuecat.purchases.react.ui.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.revenuecat.purchases.react.ui.PaywallEventKey;
import com.revenuecat.purchases.react.ui.PaywallEventName;
import com.revenuecat.purchases.react.ui.RNPurchasesConverters;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b0\u000bH&J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/react/ui/events/PaywallEvent;", "T", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewTag", "<init>", "(II)V", "getPaywallEventName", "Lcom/revenuecat/purchases/react/ui/PaywallEventName;", "getPayload", "", "Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "", "", "getEventName", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PaywallEvent<T> extends Event {
    public abstract Map<PaywallEventKey, Map<String, Object>> getPayload();

    public abstract PaywallEventName getPaywallEventName();

    public PaywallEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return getPaywallEventName().getEventName();
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        Map<PaywallEventKey, Map<String, Object>> payload = getPayload();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        for (Map.Entry<PaywallEventKey, Map<String, Object>> entry : payload.entrySet()) {
            writableNativeMap.putMap(entry.getKey().getKey(), RNPurchasesConverters.convertMapToWriteableMap(entry.getValue()));
        }
        return writableNativeMap;
    }
}
