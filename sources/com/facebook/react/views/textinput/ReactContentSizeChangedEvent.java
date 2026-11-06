package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactContentSizeChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final float contentHeight;
    private final float contentWidth;

    public ReactContentSizeChangedEvent(int i, int i2, float f, float f2) {
        super(i, i2);
        this.contentWidth = f;
        this.contentHeight = f2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topContentSizeChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("width", this.contentWidth);
        readableMapBuilder.put("height", this.contentHeight);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("contentSize", writableMapCreateMap);
        writableMapCreateMap2.putInt("target", getViewTag());
        return writableMapCreateMap2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
