package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.StylusData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PanGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder {
    private final float absoluteX;
    private final float absoluteY;
    private final StylusData stylusData;
    private final float translationX;
    private final float translationY;
    private final float velocityX;
    private final float velocityY;
    private final float x;
    private final float y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanGestureHandlerEventDataBuilder(PanGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.x = handler.getLastRelativePositionX();
        this.y = handler.getLastRelativePositionY();
        this.absoluteX = handler.getLastPositionInWindowX();
        this.absoluteY = handler.getLastPositionInWindowY();
        this.translationX = handler.getTranslationX();
        this.translationY = handler.getTranslationY();
        this.velocityX = handler.getVelocityX();
        this.velocityY = handler.getVelocityY();
        this.stylusData = handler.getStylusData();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public void buildEventData(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.buildEventData(eventData);
        eventData.putDouble("x", PixelUtil.toDIPFromPixel(this.x));
        eventData.putDouble("y", PixelUtil.toDIPFromPixel(this.y));
        eventData.putDouble("absoluteX", PixelUtil.toDIPFromPixel(this.absoluteX));
        eventData.putDouble("absoluteY", PixelUtil.toDIPFromPixel(this.absoluteY));
        eventData.putDouble("translationX", PixelUtil.toDIPFromPixel(this.translationX));
        eventData.putDouble("translationY", PixelUtil.toDIPFromPixel(this.translationY));
        eventData.putDouble("velocityX", PixelUtil.toDIPFromPixel(this.velocityX));
        eventData.putDouble("velocityY", PixelUtil.toDIPFromPixel(this.velocityY));
        if (this.stylusData.getPressure() == -1.0d) {
            return;
        }
        eventData.putMap("stylusData", this.stylusData.toReadableMap());
    }
}
