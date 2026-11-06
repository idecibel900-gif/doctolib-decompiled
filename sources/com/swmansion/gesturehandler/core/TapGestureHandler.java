package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.eventbuilders.TapGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TapGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private Handler handler;
    private float lastX;
    private float lastY;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private int tapsSoFar;
    private float maxDeltaX = Float.MIN_VALUE;
    private float maxDeltaY = Float.MIN_VALUE;
    private float maxDist = Float.MIN_VALUE;
    private long maxDurationMs = 500;
    private long maxDelayMs = 200;
    private int numberOfTaps = 1;
    private int minNumberOfPointers = 1;
    private int currentMaxNumberOfPointers = 1;
    private final Runnable failDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.TapGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.fail();
        }
    };

    public TapGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.maxDeltaX = Float.MIN_VALUE;
        this.maxDeltaY = Float.MIN_VALUE;
        this.maxDist = Float.MIN_VALUE;
        this.maxDurationMs = 500L;
        this.maxDelayMs = 200L;
        this.numberOfTaps = 1;
        this.minNumberOfPointers = 1;
        setShouldCancelWhenOutside(true);
    }

    private final void startTap() {
        Handler handler = this.handler;
        if (handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.postDelayed(this.failDelayed, this.maxDurationMs);
    }

    private final void endTap() {
        Handler handler = this.handler;
        if (handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages(null);
        }
        int i = this.tapsSoFar + 1;
        this.tapsSoFar = i;
        if (i == this.numberOfTaps && this.currentMaxNumberOfPointers >= this.minNumberOfPointers) {
            activate();
            return;
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.postDelayed(this.failDelayed, this.maxDelayMs);
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        if (this.maxDeltaX != Float.MIN_VALUE && Math.abs(f) > this.maxDeltaX) {
            return true;
        }
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.maxDeltaY != Float.MIN_VALUE && Math.abs(f2) > this.maxDeltaY) {
            return true;
        }
        float f3 = (f2 * f2) + (f * f);
        float f4 = this.maxDist;
        return f4 != Float.MIN_VALUE && f3 > f4 * f4;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            int state = getState();
            int actionMasked = sourceEvent.getActionMasked();
            if (state == 0) {
                this.offsetX = 0.0f;
                this.offsetY = 0.0f;
                GestureUtils gestureUtils = GestureUtils.INSTANCE;
                this.startX = gestureUtils.getLastPointerX(sourceEvent, true);
                this.startY = gestureUtils.getLastPointerY(sourceEvent, true);
            }
            if (actionMasked == 5 || actionMasked == 6) {
                this.offsetX += this.lastX - this.startX;
                this.offsetY += this.lastY - this.startY;
                GestureUtils gestureUtils2 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils2.getLastPointerX(sourceEvent, true);
                float lastPointerY = gestureUtils2.getLastPointerY(sourceEvent, true);
                this.lastY = lastPointerY;
                this.startX = this.lastX;
                this.startY = lastPointerY;
            } else {
                GestureUtils gestureUtils3 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils3.getLastPointerX(sourceEvent, true);
                this.lastY = gestureUtils3.getLastPointerY(sourceEvent, true);
            }
            if (this.currentMaxNumberOfPointers < sourceEvent.getPointerCount()) {
                this.currentMaxNumberOfPointers = sourceEvent.getPointerCount();
            }
            if (shouldFail()) {
                fail();
                return;
            }
            if (state == 0) {
                if (actionMasked == 0 || actionMasked == 11) {
                    begin();
                }
                startTap();
                return;
            }
            if (state == 2) {
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 11) {
                            if (actionMasked != 12) {
                                return;
                            }
                        }
                    }
                    endTap();
                    return;
                }
                startTap();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean z) {
        super.activate(z);
        end();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        this.tapsSoFar = 0;
        this.currentMaxNumberOfPointers = 0;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public static final class Factory extends GestureHandler.Factory {
        public static final Companion Companion = new Companion(null);
        private final Class type = TapGestureHandler.class;
        private final String name = "TapGestureHandler";

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
        public TapGestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(TapGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig((GestureHandler) handler, config);
            if (config.hasKey("numberOfTaps")) {
                handler.numberOfTaps = config.getInt("numberOfTaps");
            }
            if (config.hasKey("maxDurationMs")) {
                handler.maxDurationMs = config.getInt("maxDurationMs");
            }
            if (config.hasKey("maxDelayMs")) {
                handler.maxDelayMs = config.getInt("maxDelayMs");
            }
            if (config.hasKey("maxDeltaX")) {
                handler.maxDeltaX = PixelUtil.toPixelFromDIP(config.getDouble("maxDeltaX"));
            }
            if (config.hasKey("maxDeltaY")) {
                handler.maxDeltaY = PixelUtil.toPixelFromDIP(config.getDouble("maxDeltaY"));
            }
            if (config.hasKey("maxDist")) {
                handler.maxDist = PixelUtil.toPixelFromDIP(config.getDouble("maxDist"));
            }
            if (config.hasKey("minPointers")) {
                handler.minNumberOfPointers = config.getInt("minPointers");
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public TapGestureHandlerEventDataBuilder createEventBuilder(TapGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new TapGestureHandlerEventDataBuilder(handler);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
