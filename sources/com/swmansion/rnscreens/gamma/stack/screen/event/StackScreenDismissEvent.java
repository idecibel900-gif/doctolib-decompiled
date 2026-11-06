package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenDismissEvent extends StackScreenLifecycleEvent {
    public static final Companion Companion = new Companion(null);
    private final boolean isNativeDismiss;

    public StackScreenDismissEvent(int i, int i2, boolean z) {
        super(i, i2, "topDismiss", "onDismiss");
        this.isNativeDismiss = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenLifecycleEvent, com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isNativeDismiss", this.isNativeDismiss);
        return writableMapCreateMap;
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return "topDismiss";
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventRegistrationName() {
            return "onDismiss";
        }
    }
}
