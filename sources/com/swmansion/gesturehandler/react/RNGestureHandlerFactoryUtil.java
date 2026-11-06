package com.swmansion.gesturehandler.react;

import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.ManualGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerFactoryUtil {
    public static final RNGestureHandlerFactoryUtil INSTANCE = new RNGestureHandlerFactoryUtil();
    private static final GestureHandler.Factory[] handlerFactories = {new NativeViewGestureHandler.Factory(), new TapGestureHandler.Factory(), new LongPressGestureHandler.Factory(), new PanGestureHandler.Factory(), new PinchGestureHandler.Factory(), new RotationGestureHandler.Factory(), new FlingGestureHandler.Factory(), new ManualGestureHandler.Factory(), new HoverGestureHandler.Factory()};

    private RNGestureHandlerFactoryUtil() {
    }

    public final GestureHandler.Factory findFactoryForHandler(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        for (GestureHandler.Factory factory : handlerFactories) {
            if (Intrinsics.areEqual(factory.getType(), handler.getClass())) {
                return factory;
            }
        }
        return null;
    }

    public final GestureHandler.Factory findFactoryForName(String handlerName) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        for (GestureHandler.Factory factory : handlerFactories) {
            if (Intrinsics.areEqual(factory.getName(), handlerName)) {
                return factory;
            }
        }
        return null;
    }
}
