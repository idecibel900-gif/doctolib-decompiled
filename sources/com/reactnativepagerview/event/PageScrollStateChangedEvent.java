package com.reactnativepagerview.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PageScrollStateChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String mPageScrollState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageScrollStateChangedEvent(int i, String mPageScrollState) {
        super(i);
        Intrinsics.checkNotNullParameter(mPageScrollState, "mPageScrollState");
        this.mPageScrollState = mPageScrollState;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topPageScrollStateChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(getViewTag(), internal_getEventNameCompat(), serializeEventData());
    }

    private final WritableMap serializeEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("pageScrollState", this.mPageScrollState);
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
