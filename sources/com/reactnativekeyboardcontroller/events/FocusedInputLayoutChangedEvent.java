package com.reactnativekeyboardcontroller.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputLayoutChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final FocusedInputLayoutChangedEventData event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputLayoutChangedEvent(int i, int i2, FocusedInputLayoutChangedEventData event) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topFocusedInputLayoutChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", this.event.getTarget());
        writableMapCreateMap.putInt("parentScrollViewTarget", this.event.getParentScrollViewTarget());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("x", this.event.getX());
        writableMapCreateMap2.putDouble("y", this.event.getY());
        writableMapCreateMap2.putDouble("width", this.event.getWidth());
        writableMapCreateMap2.putDouble("height", this.event.getHeight());
        writableMapCreateMap2.putDouble("absoluteX", this.event.getAbsoluteX());
        writableMapCreateMap2.putDouble("absoluteY", this.event.getAbsoluteY());
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap.putMap("layout", writableMapCreateMap2);
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
