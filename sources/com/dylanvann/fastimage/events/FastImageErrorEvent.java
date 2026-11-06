package com.dylanvann.fastimage.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageErrorEvent extends Event {
    private final ReadableMap mSource;

    public FastImageErrorEvent(int i, int i2, ReadableMap readableMap) {
        super(i, i2);
        this.mSource = readableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onFastImageError";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (this.mSource != null) {
            writableMapCreateMap.putString("error", "Invalid source prop:" + this.mSource);
        }
        return writableMapCreateMap;
    }
}
