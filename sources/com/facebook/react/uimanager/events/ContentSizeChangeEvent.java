package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class ContentSizeChangeEvent extends Event {
    private final int height;
    private final int width;

    public ContentSizeChangeEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.width = i3;
        this.height = i4;
    }

    public ContentSizeChangeEvent(int i, int i2, int i3) {
        this(-1, i, i2, i3);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topContentSizeChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(this.width));
        writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(this.height));
        return writableMapCreateMap;
    }
}
