package com.swmansion.rnscreens.gamma.stack.screen.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StackScreenLifecycleEvent extends Event implements NamingAwareEventType {
    private final String name;
    private final String registrationName;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreenLifecycleEvent(int i, int i2, String name, String registrationName) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(registrationName, "registrationName");
        this.name = name;
        this.registrationName = registrationName;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return this.name;
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
    public String getEventRegistrationName() {
        return this.registrationName;
    }
}
