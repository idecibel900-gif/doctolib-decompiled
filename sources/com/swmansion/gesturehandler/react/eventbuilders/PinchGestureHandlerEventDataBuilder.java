package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PinchGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder {
    private final float focalX;
    private final float focalY;
    private final double scale;
    private final double velocity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchGestureHandlerEventDataBuilder(PinchGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.scale = handler.getScale();
        this.focalX = handler.getFocalPointX();
        this.focalY = handler.getFocalPointY();
        this.velocity = handler.getVelocity();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putDouble("scale", this.scale);
        eventData.putDouble("focalX", PixelUtil.toDIPFromPixel(this.focalX));
        eventData.putDouble("focalY", PixelUtil.toDIPFromPixel(this.focalY));
        eventData.putDouble("velocity", this.velocity);
    }
}
