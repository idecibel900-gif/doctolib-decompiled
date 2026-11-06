package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextInputKeyPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String key;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactTextInputKeyPressEvent(int i, int i2, String key) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topKeyPress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(SubscriberAttributeKt.JSON_NAME_KEY, this.key);
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
