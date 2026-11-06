package com.revenuecat.purchases.react.ui.events;

import com.facebook.react.bridge.WritableMap;
import com.revenuecat.purchases.react.ui.PaywallEventKey;
import com.revenuecat.purchases.react.ui.PaywallEventName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/react/ui/events/OnPerformRestoreEvent;", "Lcom/revenuecat/purchases/react/ui/events/PaywallEvent;", "surfaceId", "", "viewTag", "requestId", "", "<init>", "(IILjava/lang/String;)V", "getPaywallEventName", "Lcom/revenuecat/purchases/react/ui/PaywallEventName;", "getPayload", "", "Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnPerformRestoreEvent extends PaywallEvent<OnPerformRestoreEvent> {
    private final String requestId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnPerformRestoreEvent(int i, int i2, String requestId) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        this.requestId = requestId;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public PaywallEventName getPaywallEventName() {
        return PaywallEventName.ON_PERFORM_RESTORE;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public Map<PaywallEventKey, Map<String, Object>> getPayload() {
        return MapsKt.emptyMap();
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent, com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap eventData = super.getEventData();
        eventData.putString(PaywallEventKey.REQUEST_ID.getKey(), this.requestId);
        return eventData;
    }
}
