package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnRequestMarkdownResultEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final String markdown;
    private final int requestId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnRequestMarkdownResultEvent(int i, int i2, int i3, String markdown) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        this.requestId = i3;
        this.markdown = markdown;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onRequestMarkdownResult";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("requestId", this.requestId);
        writableMapCreateMap.putString("markdown", this.markdown);
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
