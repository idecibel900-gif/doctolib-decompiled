package com.reactnativecommunity.picker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* JADX INFO: loaded from: classes4.dex */
public class PickerItemSelectEvent extends Event {
    private final int mPosition;

    public PickerItemSelectEvent(int i, int i2) {
        super(i);
        this.mPosition = i2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topSelect";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("position", this.mPosition);
        return writableMapCreateMap;
    }
}
