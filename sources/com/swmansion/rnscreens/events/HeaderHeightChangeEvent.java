package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class HeaderHeightChangeEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final double headerHeightInDp;

    public HeaderHeightChangeEvent(int i, int i2, double d) {
        super(i, i2);
        this.headerHeightInDp = d;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topHeaderHeightChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) this.headerHeightInDp;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("headerHeight", this.headerHeightInDp);
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
