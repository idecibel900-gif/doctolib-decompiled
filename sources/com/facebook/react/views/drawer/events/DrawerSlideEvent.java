package com.facebook.react.views.drawer.events;

import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawerSlideEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final float offset;

    public DrawerSlideEvent(int i, int i2, float f) {
        super(i, i2);
        this.offset = f;
    }

    public final float getOffset() {
        return this.offset;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topDrawerSlide";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(b.as, getOffset());
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
