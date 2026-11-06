package com.facebook.react.views.swiperefresh;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes3.dex */
public final class RefreshEvent extends Event {
    public RefreshEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topRefresh";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
