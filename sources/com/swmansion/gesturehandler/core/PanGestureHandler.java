package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.react.eventbuilders.PanGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PanGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private long activateAfterLongPress;
    private boolean averageTouches;
    private final float defaultMinDist;
    private Handler handler;
    private float lastX;
    private float lastY;
    private float minDist;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private VelocityTracker velocityTracker;
    private float velocityX;
    private float velocityY;
    private float activeOffsetXStart = Float.MAX_VALUE;
    private float activeOffsetXEnd = Float.MIN_VALUE;
    private float failOffsetXStart = Float.MIN_VALUE;
    private float failOffsetXEnd = Float.MAX_VALUE;
    private float activeOffsetYStart = Float.MAX_VALUE;
    private float activeOffsetYEnd = Float.MIN_VALUE;
    private float failOffsetYStart = Float.MIN_VALUE;
    private float failOffsetYEnd = Float.MAX_VALUE;
    private float minVelocityX = Float.MAX_VALUE;
    private float minVelocityY = Float.MAX_VALUE;
    private float minVelocity = Float.MAX_VALUE;
    private int minPointers = 1;
    private int maxPointers = 10;
    private final Runnable activateDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.PanGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.activate();
        }
    };
    private StylusData stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);

    public PanGestureHandler(Context context) {
        this.minDist = Float.MIN_VALUE;
        Intrinsics.checkNotNull(context);
        float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.defaultMinDist = scaledTouchSlop;
        this.minDist = scaledTouchSlop;
    }

    public final float getVelocityX() {
        return this.velocityX;
    }

    public final float getVelocityY() {
        return this.velocityY;
    }

    public final float getTranslationX() {
        return (this.lastX - this.startX) + this.offsetX;
    }

    public final float getTranslationY() {
        return (this.lastY - this.startY) + this.offsetY;
    }

    public final StylusData getStylusData() {
        return this.stylusData;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocity = Float.MAX_VALUE;
        this.minDist = this.defaultMinDist;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.activateAfterLongPress = 0L;
        this.averageTouches = false;
    }

    private final boolean shouldActivate() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = this.activeOffsetXStart;
        if (f2 != Float.MAX_VALUE && f < f2) {
            return true;
        }
        float f3 = this.activeOffsetXEnd;
        if (f3 != Float.MIN_VALUE && f > f3) {
            return true;
        }
        float f4 = (this.lastY - this.startY) + this.offsetY;
        float f5 = this.activeOffsetYStart;
        if (f5 != Float.MAX_VALUE && f4 < f5) {
            return true;
        }
        float f6 = this.activeOffsetYEnd;
        if (f6 != Float.MIN_VALUE && f4 > f6) {
            return true;
        }
        float f7 = (f * f) + (f4 * f4);
        float f8 = this.minDist;
        if (f8 != Float.MAX_VALUE && f7 >= f8 * f8) {
            return true;
        }
        float f9 = this.velocityX;
        float f10 = this.minVelocityX;
        if (f10 != Float.MAX_VALUE && ((f10 < 0.0f && f9 <= f10) || (0.0f <= f10 && f10 <= f9))) {
            return true;
        }
        float f11 = this.velocityY;
        float f12 = this.minVelocityY;
        if (f12 != Float.MAX_VALUE && ((f12 < 0.0f && f9 <= f12) || (0.0f <= f12 && f12 <= f9))) {
            return true;
        }
        float f13 = (f9 * f9) + (f11 * f11);
        float f14 = this.minVelocity;
        return f14 != Float.MAX_VALUE && f13 >= f14 * f14;
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.activateAfterLongPress > 0) {
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.defaultMinDist;
            if (f3 > f4 * f4) {
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                return true;
            }
        }
        float f5 = this.failOffsetXStart;
        if (f5 != Float.MIN_VALUE && f < f5) {
            return true;
        }
        float f6 = this.failOffsetXEnd;
        if (f6 != Float.MAX_VALUE && f > f6) {
            return true;
        }
        float f7 = this.failOffsetYStart;
        if (f7 != Float.MIN_VALUE && f2 < f7) {
            return true;
        }
        float f8 = this.failOffsetYEnd;
        return f8 != Float.MAX_VALUE && f2 > f8;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (event.getToolType(0) == 2) {
                this.stylusData = StylusData.Companion.fromEvent(event);
            }
            int state = getState();
            int actionMasked = sourceEvent.getActionMasked();
            if (actionMasked == 5 || actionMasked == 6) {
                this.offsetX += this.lastX - this.startX;
                this.offsetY += this.lastY - this.startY;
                GestureUtils gestureUtils = GestureUtils.INSTANCE;
                this.lastX = gestureUtils.getLastPointerX(sourceEvent, this.averageTouches);
                float lastPointerY = gestureUtils.getLastPointerY(sourceEvent, this.averageTouches);
                this.lastY = lastPointerY;
                this.startX = this.lastX;
                this.startY = lastPointerY;
            } else {
                GestureUtils gestureUtils2 = GestureUtils.INSTANCE;
                this.lastX = gestureUtils2.getLastPointerX(sourceEvent, this.averageTouches);
                this.lastY = gestureUtils2.getLastPointerY(sourceEvent, this.averageTouches);
            }
            if (state == 0 && sourceEvent.getPointerCount() >= this.minPointers) {
                resetProgress();
                this.offsetX = 0.0f;
                this.offsetY = 0.0f;
                this.velocityX = 0.0f;
                this.velocityY = 0.0f;
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.velocityTracker = velocityTrackerObtain;
                Companion.addVelocityMovement(velocityTrackerObtain, sourceEvent);
                begin();
                if (this.activateAfterLongPress > 0) {
                    if (this.handler == null) {
                        this.handler = new Handler(Looper.getMainLooper());
                    }
                    Handler handler = this.handler;
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(this.activateDelayed, this.activateAfterLongPress);
                }
            } else {
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    Companion.addVelocityMovement(velocityTracker, sourceEvent);
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker2);
                    velocityTracker2.computeCurrentVelocity(1000);
                    VelocityTracker velocityTracker3 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker3);
                    this.velocityX = velocityTracker3.getXVelocity();
                    VelocityTracker velocityTracker4 = this.velocityTracker;
                    Intrinsics.checkNotNull(velocityTracker4);
                    this.velocityY = velocityTracker4.getYVelocity();
                }
            }
            if (actionMasked == 1 || actionMasked == 12) {
                if (state == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 5 && sourceEvent.getPointerCount() > this.maxPointers) {
                if (state == 4) {
                    cancel();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (actionMasked == 6 && state == 4 && sourceEvent.getPointerCount() < this.minPointers) {
                fail();
                return;
            }
            if (state == 2) {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    activate();
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean z) {
        if (getState() != 4) {
            resetProgress();
        }
        super.activate(z);
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
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        this.stylusData = new StylusData(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetProgress() {
        this.startX = this.lastX;
        this.startY = this.lastY;
    }

    public static final class Factory extends GestureHandler.Factory {
        public static final Companion Companion = new Companion(null);
        private final Class type = PanGestureHandler.class;
        private final String name = "PanGestureHandler";

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
        public PanGestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public void setConfig(PanGestureHandler handler, ReadableMap config) {
            boolean z;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.setConfig((GestureHandler) handler, config);
            boolean z2 = true;
            if (config.hasKey("activeOffsetXStart")) {
                handler.activeOffsetXStart = PixelUtil.toPixelFromDIP(config.getDouble("activeOffsetXStart"));
                z = true;
            } else {
                z = false;
            }
            if (config.hasKey("activeOffsetXEnd")) {
                handler.activeOffsetXEnd = PixelUtil.toPixelFromDIP(config.getDouble("activeOffsetXEnd"));
                z = true;
            }
            if (config.hasKey("failOffsetXStart")) {
                handler.failOffsetXStart = PixelUtil.toPixelFromDIP(config.getDouble("failOffsetXStart"));
                z = true;
            }
            if (config.hasKey("failOffsetXEnd")) {
                handler.failOffsetXEnd = PixelUtil.toPixelFromDIP(config.getDouble("failOffsetXEnd"));
                z = true;
            }
            if (config.hasKey("activeOffsetYStart")) {
                handler.activeOffsetYStart = PixelUtil.toPixelFromDIP(config.getDouble("activeOffsetYStart"));
                z = true;
            }
            if (config.hasKey("activeOffsetYEnd")) {
                handler.activeOffsetYEnd = PixelUtil.toPixelFromDIP(config.getDouble("activeOffsetYEnd"));
                z = true;
            }
            if (config.hasKey("failOffsetYStart")) {
                handler.failOffsetYStart = PixelUtil.toPixelFromDIP(config.getDouble("failOffsetYStart"));
                z = true;
            }
            if (config.hasKey("failOffsetYEnd")) {
                handler.failOffsetYEnd = PixelUtil.toPixelFromDIP(config.getDouble("failOffsetYEnd"));
                z = true;
            }
            if (config.hasKey("minVelocity")) {
                handler.minVelocity = PixelUtil.toPixelFromDIP(config.getDouble("minVelocity"));
                z = true;
            }
            if (config.hasKey("minVelocityX")) {
                handler.minVelocityX = PixelUtil.toPixelFromDIP(config.getDouble("minVelocityX"));
                z = true;
            }
            if (config.hasKey("minVelocityY")) {
                handler.minVelocityY = PixelUtil.toPixelFromDIP(config.getDouble("minVelocityY"));
            } else {
                z2 = z;
            }
            if (config.hasKey("minDist")) {
                handler.minDist = PixelUtil.toPixelFromDIP(config.getDouble("minDist"));
            } else if (z2) {
                handler.minDist = Float.MAX_VALUE;
            }
            if (config.hasKey("minPointers")) {
                handler.minPointers = config.getInt("minPointers");
            }
            if (config.hasKey("maxPointers")) {
                handler.maxPointers = config.getInt("maxPointers");
            }
            if (config.hasKey("avgTouches")) {
                handler.averageTouches = config.getBoolean("avgTouches");
            }
            if (config.hasKey("activateAfterLongPress")) {
                handler.activateAfterLongPress = config.getInt("activateAfterLongPress");
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public PanGestureHandlerEventDataBuilder createEventBuilder(PanGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PanGestureHandlerEventDataBuilder(handler);
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

        /* JADX INFO: Access modifiers changed from: private */
        public final void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }
    }
}
