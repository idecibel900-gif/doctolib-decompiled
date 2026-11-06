package com.reactnativemenu;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes4.dex */
public final class MenuOnCloseEvent extends Event {
    private final int targetId;

    public MenuOnCloseEvent(int i, int i2, int i3) {
        super(i, i2);
        this.targetId = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onCloseMenu";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
