package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TopCustomMenuSelectionEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final WritableMap mEventData;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopCustomMenuSelectionEvent(int i, WritableMap mEventData) {
        super(i);
        Intrinsics.checkNotNullParameter(mEventData, "mEventData");
        this.mEventData = mEventData;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topCustomMenuSelection";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(getViewTag(), internal_getEventNameCompat(), this.mEventData);
    }
}
