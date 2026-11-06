package com.revenuecat.purchases.react.ui.customercenter.events;

import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/react/ui/customercenter/events/CustomerCenterEvent;", "T", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewTag", "<init>", "(II)V", "getCustomerCenterEventName", "Lcom/revenuecat/purchases/react/ui/customercenter/events/CustomerCenterEventName;", "getEventName", "", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CustomerCenterEvent<T> extends Event {
    public abstract CustomerCenterEventName getCustomerCenterEventName();

    public CustomerCenterEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return getCustomerCenterEventName().getEventName();
    }
}
