package com.dylanvann.fastimage.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageLoadStartEvent extends Event {
    public FastImageLoadStartEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onFastImageLoadStart";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
