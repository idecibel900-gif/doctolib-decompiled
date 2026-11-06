package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnLinkDetectedEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final int end;
    private final int start;
    private final String text;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnLinkDetectedEvent(int i, int i2, String text, String url, int i3, int i4) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(url, "url");
        this.text = text;
        this.url = url;
        this.start = i3;
        this.end = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onLinkDetected";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.text);
        writableMapCreateMap.putString("url", this.url);
        writableMapCreateMap.putInt("start", this.start);
        writableMapCreateMap.putInt("end", this.end);
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
