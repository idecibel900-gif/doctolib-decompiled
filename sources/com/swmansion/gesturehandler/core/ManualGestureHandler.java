package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.view.MotionEvent;
import com.swmansion.gesturehandler.react.eventbuilders.ManualGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ManualGestureHandler extends GestureHandler {
    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (getState() == 0) {
            begin();
        }
    }

    public static final class Factory extends GestureHandler.Factory {
        private final Class type = ManualGestureHandler.class;
        private final String name = "ManualGestureHandler";

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public Class getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public String getName() {
            return this.name;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public ManualGestureHandler create(Context context) {
            return new ManualGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public ManualGestureHandlerEventDataBuilder createEventBuilder(ManualGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new ManualGestureHandlerEventDataBuilder(handler);
        }
    }
}
