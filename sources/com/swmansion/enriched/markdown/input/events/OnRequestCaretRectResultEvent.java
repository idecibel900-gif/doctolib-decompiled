package com.swmansion.enriched.markdown.input.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.enriched.markdown.input.model.CaretRect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnRequestCaretRectResultEvent extends Event {
    public static final Companion Companion = new Companion(null);
    private final CaretRect rect;
    private final int requestId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnRequestCaretRectResultEvent(int i, int i2, int i3, CaretRect rect) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.requestId = i3;
        this.rect = rect;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onRequestCaretRectResult";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("requestId", this.requestId);
        this.rect.putInto(writableMapCreateMap);
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
