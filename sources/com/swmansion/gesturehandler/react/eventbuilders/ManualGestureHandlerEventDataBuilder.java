package com.swmansion.gesturehandler.react.eventbuilders;

import com.swmansion.gesturehandler.core.ManualGestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ManualGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualGestureHandlerEventDataBuilder(ManualGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
    }
}
