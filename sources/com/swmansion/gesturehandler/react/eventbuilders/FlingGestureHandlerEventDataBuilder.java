package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FlingGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder {
    private final float absoluteX;
    private final float absoluteY;
    private final float x;
    private final float y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlingGestureHandlerEventDataBuilder(FlingGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.x = handler.getLastRelativePositionX();
        this.y = handler.getLastRelativePositionY();
        this.absoluteX = handler.getLastPositionInWindowX();
        this.absoluteY = handler.getLastPositionInWindowY();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putDouble("x", PixelUtil.toDIPFromPixel(this.x));
        eventData.putDouble("y", PixelUtil.toDIPFromPixel(this.y));
        eventData.putDouble("absoluteX", PixelUtil.toDIPFromPixel(this.absoluteX));
        eventData.putDouble("absoluteY", PixelUtil.toDIPFromPixel(this.absoluteY));
    }
}
