package com.swmansion.reanimated;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;

/* JADX INFO: loaded from: classes4.dex */
public class CopiedEvent {
    private boolean canCoalesceEvent;
    private int category;
    private int customCoalesceKey;
    private String eventName;
    private WritableMap payload;
    private int surfaceId;
    private int targetTag;

    CopiedEvent(Event event) {
        event.dispatchModern(new RCTModernEventEmitter() { // from class: com.swmansion.reanimated.CopiedEvent.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // com.facebook.react.uimanager.events.RCTEventEmitter
            public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
            }

            @Override // com.facebook.react.uimanager.events.RCTEventEmitter
            public void receiveEvent(int i, String str, WritableMap writableMap) {
                CopiedEvent.this.targetTag = i;
                CopiedEvent.this.eventName = str;
                CopiedEvent.this.payload = writableMap.copy();
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
            public void receiveEvent(int i, int i2, String str, WritableMap writableMap) {
                CopiedEvent.this.surfaceId = i;
                CopiedEvent.this.targetTag = i2;
                CopiedEvent.this.eventName = str;
                CopiedEvent.this.payload = writableMap.copy();
            }

            @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
            public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4) {
                CopiedEvent.this.surfaceId = i;
                CopiedEvent.this.targetTag = i2;
                CopiedEvent.this.eventName = str;
                CopiedEvent.this.canCoalesceEvent = z;
                CopiedEvent.this.customCoalesceKey = i3;
                CopiedEvent.this.payload = writableMap.copy();
                CopiedEvent.this.category = i4;
            }
        });
    }

    public int getSurfaceId() {
        return this.surfaceId;
    }

    public int getTargetTag() {
        return this.targetTag;
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean getCanCoalesceEvent() {
        return this.canCoalesceEvent;
    }

    public int getCustomCoalesceKey() {
        return this.customCoalesceKey;
    }

    public WritableMap getPayload() {
        return this.payload;
    }

    public int getCategory() {
        return this.category;
    }
}
