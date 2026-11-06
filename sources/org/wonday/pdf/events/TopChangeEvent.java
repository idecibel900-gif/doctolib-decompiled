package org.wonday.pdf.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* JADX INFO: loaded from: classes5.dex */
public class TopChangeEvent extends Event {
    private WritableMap eventData;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public TopChangeEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.eventData = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return this.eventData;
    }
}
