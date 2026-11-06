package com.swmansion.rnscreens.gamma.tabs.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsScreenWillDisappearEvent extends Event implements NamingAwareEventType {
    public static final Companion Companion = new Companion(null);

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    public TabsScreenWillDisappearEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topWillDisappear";
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
    public String getEventRegistrationName() {
        return "onWillDisappear";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return "topWillDisappear";
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventRegistrationName() {
            return "onWillDisappear";
        }
    }
}
