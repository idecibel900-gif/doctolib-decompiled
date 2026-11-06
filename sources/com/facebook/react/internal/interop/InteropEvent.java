package com.facebook.react.internal.interop;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InteropEvent extends Event {
    private static final Companion Companion = new Companion(null);
    private final WritableMap eventData;
    private final String interopEventName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteropEvent(String interopEventName, WritableMap writableMap, int i, int i2) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(interopEventName, "interopEventName");
        this.interopEventName = interopEventName;
        this.eventData = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return this.interopEventName;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return this.eventData;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture$default("InteropEvent", null, 2, null);
    }
}
