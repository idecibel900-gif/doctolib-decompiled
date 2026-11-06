package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class OnAnimationFinishEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final boolean isCancelled;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public OnAnimationFinishEvent(int i, int i2, boolean z) {
        super(i, i2);
        this.isCancelled = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topAnimationFinish";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isCancelled", this.isCancelled);
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
