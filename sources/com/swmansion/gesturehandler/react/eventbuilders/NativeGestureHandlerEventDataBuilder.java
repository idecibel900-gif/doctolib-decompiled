package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder {
    private final boolean pointerInside;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeGestureHandlerEventDataBuilder(NativeViewGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.pointerInside = handler.isWithinBounds();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putBoolean("pointerInside", this.pointerInside);
    }
}
