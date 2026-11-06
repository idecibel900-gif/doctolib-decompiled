package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class OnChangeSelectionEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int end;
    private final int start;

    public OnChangeSelectionEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.start = i3;
        this.end = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onChangeSelection";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("start", this.start);
        writableMapCreateMap.putInt("end", this.end);
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
