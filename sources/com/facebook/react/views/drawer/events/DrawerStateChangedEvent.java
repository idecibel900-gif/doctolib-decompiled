package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawerStateChangedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int drawerState;

    public DrawerStateChangedEvent(int i, int i2, int i3) {
        super(i, i2);
        this.drawerState = i3;
    }

    public final int getDrawerState() {
        return this.drawerState;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topDrawerStateChanged";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("drawerState", getDrawerState());
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
