package com.swmansion.enriched.markdown.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkPressEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPressEvent(int i, int i2, String url) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onLinkPress";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("url", this.url);
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
