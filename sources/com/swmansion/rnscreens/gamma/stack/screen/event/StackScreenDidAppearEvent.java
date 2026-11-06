package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenDidAppearEvent extends StackScreenLifecycleEvent {
    public static final Companion Companion = new Companion(null);

    public StackScreenDidAppearEvent(int i, int i2) {
        super(i, i2, "topDidAppear", "onDidAppear");
    }

    public static final class Companion implements NamingAwareEventType {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventName() {
            return "topDidAppear";
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventRegistrationName() {
            return "onDidAppear";
        }
    }
}
