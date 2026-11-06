package com.swmansion.rnscreens.gamma.tabs.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsHostNativeFocusChangeEvent extends Event implements NamingAwareEventType {
    public static final Companion Companion = new Companion(null);
    private final boolean repeatedSelectionHandledBySpecialEffect;
    private final String tabKey;
    private final int tabNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostNativeFocusChangeEvent(int i, int i2, String tabKey, int i3, boolean z) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        this.tabKey = tabKey;
        this.tabNumber = i3;
        this.repeatedSelectionHandledBySpecialEffect = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topNativeFocusChange";
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
    public String getEventRegistrationName() {
        return "onNativeFocusChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) ((this.tabNumber * 10) + (this.repeatedSelectionHandledBySpecialEffect ? 1 : 0));
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("tabKey", this.tabKey);
        writableMapCreateMap.putBoolean("repeatedSelectionHandledBySpecialEffect", this.repeatedSelectionHandledBySpecialEffect);
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
            return "topNativeFocusChange";
        }

        @Override // com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType
        public String getEventRegistrationName() {
            return "onNativeFocusChange";
        }
    }
}
