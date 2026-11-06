package com.reactnativemenu;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes4.dex */
public final class MenuOnPressActionEvent extends Event {
    private final String event;
    private final int target;

    public MenuOnPressActionEvent(int i, int i2, String str, int i3) {
        super(i, i2);
        this.event = str;
        this.target = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onPressAction";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        String str = this.event;
        if (str != null) {
            writableMapCreateMap.putString("event", str);
        }
        writableMapCreateMap.putString("target", String.valueOf(this.target));
        return writableMapCreateMap;
    }
}
