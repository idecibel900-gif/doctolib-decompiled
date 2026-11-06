package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class OnAnimationFailureEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final Throwable error;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnAnimationFailureEvent(int i, int i2, Throwable error) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topAnimationFailure";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("error", this.error.getMessage());
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
