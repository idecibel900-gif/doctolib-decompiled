package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenWillAppearEvent extends StackScreenLifecycleEvent {
    public static final Companion Companion = new Companion(null);

    public StackScreenWillAppearEvent(int i, int i2) {
        super(i, i2, "topWillAppear", "onWillAppear");
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return "topWillAppear";
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventRegistrationName() {
            return "onWillAppear";
        }
    }
}
