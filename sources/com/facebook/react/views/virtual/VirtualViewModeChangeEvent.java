package com.facebook.react.views.virtual;

import android.graphics.Rect;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualViewModeChangeEvent extends Event {
    private final VirtualViewMode mode;
    private final boolean synchronous;
    private final ReadableMap targetRectAsMap;
    private final ReadableMap thresholdRectAsMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualViewModeChangeEvent(int i, int i2, VirtualViewMode mode, Rect targetRect, Rect thresholdRect, boolean z) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        Intrinsics.checkNotNullParameter(thresholdRect, "thresholdRect");
        this.mode = mode;
        this.synchronous = z;
        this.targetRectAsMap = VirtualViewModeChangeEventKt.toReadableMap(targetRect);
        this.thresholdRectAsMap = VirtualViewModeChangeEventKt.toReadableMap(thresholdRect);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "modeChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("mode", this.mode.getValue());
        writableMapCreateMap.putMap("targetRect", this.targetRectAsMap);
        writableMapCreateMap.putMap("thresholdRect", this.thresholdRectAsMap);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected boolean experimental_isSynchronous() {
        return this.synchronous;
    }
}
