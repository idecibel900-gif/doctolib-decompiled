package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class SheetDetentChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int index;
    private final boolean isStable;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public SheetDetentChangedEvent(int i, int i2, int i3, boolean z) {
        super(i, i2);
        this.index = i3;
        this.isStable = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topSheetDetentChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("index", this.index);
        writableMapCreateMap.putBoolean("isStable", this.isStable);
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
