package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextInputSelectionEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int selectionEnd;
    private final int selectionStart;

    public ReactTextInputSelectionEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.selectionStart = i3;
        this.selectionEnd = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topSelectionChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("start", this.selectionStart);
        readableMapBuilder.put("end", this.selectionEnd);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("selection", writableMapCreateMap);
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
