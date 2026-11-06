package com.reactnativekeyboardcontroller.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputSelectionChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final FocusedInputSelectionChangedEventData event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputSelectionChangedEvent(int i, int i2, FocusedInputSelectionChangedEventData event) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topFocusedInputSelectionChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", this.event.getTarget());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putDouble("x", this.event.getStartX());
        writableMapCreateMap3.putDouble("y", this.event.getStartY());
        writableMapCreateMap3.putInt("position", this.event.getStart());
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap2.putMap("start", writableMapCreateMap3);
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putDouble("x", this.event.getEndX());
        writableMapCreateMap4.putDouble("y", this.event.getEndY());
        writableMapCreateMap4.putInt("position", this.event.getEnd());
        writableMapCreateMap2.putMap("end", writableMapCreateMap4);
        writableMapCreateMap.putMap("selection", writableMapCreateMap2);
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
