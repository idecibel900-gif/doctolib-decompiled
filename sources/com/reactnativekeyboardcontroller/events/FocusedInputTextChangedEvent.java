package com.reactnativekeyboardcontroller.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputTextChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String text;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputTextChangedEvent(int i, int i2, String text) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topFocusedInputTextChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.text);
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
