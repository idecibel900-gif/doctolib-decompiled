package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnEndMentionEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String indicator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnEndMentionEvent(int i, int i2, String indicator) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        this.indicator = indicator;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onEndMention";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("indicator", this.indicator);
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
