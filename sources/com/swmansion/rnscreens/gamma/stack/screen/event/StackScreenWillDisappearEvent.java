package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenWillDisappearEvent extends StackScreenLifecycleEvent {
    public static final Companion Companion = new Companion(null);

    public StackScreenWillDisappearEvent(int i, int i2) {
        super(i, i2, "topWillDisappear", "onWillDisappear");
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
