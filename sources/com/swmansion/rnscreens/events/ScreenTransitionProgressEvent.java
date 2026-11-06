package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenTransitionProgressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final short coalescingKey;
    private final boolean isClosing;
    private final boolean isGoingForward;
    private final float progress;

    public ScreenTransitionProgressEvent(int i, int i2, float f, boolean z, boolean z2, short s) {
        super(i, i2);
        this.progress = f;
        this.isClosing = z;
        this.isGoingForward = z2;
        this.coalescingKey = s;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topTransitionProgress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, this.progress);
        writableMapCreateMap.putInt("closing", this.isClosing ? 1 : 0);
        writableMapCreateMap.putInt("goingForward", this.isGoingForward ? 1 : 0);
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
