package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.opentok.android.PublisherKit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TopShouldStartLoadWithRequestEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final WritableMap mData;

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
    public TopShouldStartLoadWithRequestEvent(int i, WritableMap mData) {
        super(i);
        Intrinsics.checkNotNullParameter(mData, "mData");
        this.mData = mData;
        mData.putString("navigationType", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER);
        mData.putBoolean("isTopFrame", true);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topShouldStartLoadWithRequest";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(getViewTag(), "topShouldStartLoadWithRequest", this.mData);
    }
}
