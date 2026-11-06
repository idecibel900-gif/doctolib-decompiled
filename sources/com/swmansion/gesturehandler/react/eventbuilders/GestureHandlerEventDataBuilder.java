package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GestureHandlerEventDataBuilder {
    private final int handlerTag;
    private final int numberOfPointers;
    private final int pointerType;
    private final int state;

    public GestureHandlerEventDataBuilder(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.numberOfPointers = handler.getNumberOfPointers();
        this.handlerTag = handler.getTag();
        this.state = handler.getState();
        this.pointerType = handler.getPointerType();
    }

    public void buildEventData(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        eventData.putInt("numberOfPointers", this.numberOfPointers);
        eventData.putInt("handlerTag", this.handlerTag);
        eventData.putInt("state", this.state);
        eventData.putInt("pointerType", this.pointerType);
    }
}
