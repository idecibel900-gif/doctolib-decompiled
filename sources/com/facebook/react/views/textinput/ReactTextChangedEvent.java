package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int eventCount;
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactTextChangedEvent(int i, int i2, String text, int i3) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.eventCount = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.text);
        writableMapCreateMap.putInt("eventCount", this.eventCount);
        writableMapCreateMap.putInt("target", getViewTag());
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
