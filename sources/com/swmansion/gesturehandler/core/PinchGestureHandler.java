package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.swmansion.gesturehandler.react.eventbuilders.PinchGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PinchGestureHandler extends GestureHandler {
    private float focalPointX = Float.NaN;
    private float focalPointY = Float.NaN;
    private final ScaleGestureDetector.OnScaleGestureListener gestureListener = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.swmansion.gesturehandler.core.PinchGestureHandler$gestureListener$1
        @Override // com.swmansion.gesturehandler.core.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }

        @Override // com.swmansion.gesturehandler.core.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            double scale = this.this$0.getScale();
            PinchGestureHandler pinchGestureHandler = this.this$0;
            pinchGestureHandler.scale = pinchGestureHandler.getScale() * ((double) detector.getScaleFactor());
            double timeDeltaSeconds = detector.getTimeDeltaSeconds();
            if (timeDeltaSeconds > 0.0d) {
                PinchGestureHandler pinchGestureHandler2 = this.this$0;
                pinchGestureHandler2.velocity = (pinchGestureHandler2.getScale() - scale) / timeDeltaSeconds;
            }
            if (Math.abs(this.this$0.startingSpan - detector.getCurrentSpan()) < this.this$0.spanSlop || this.this$0.getState() != 2) {
                return true;
            }
            this.this$0.activate();
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            this.this$0.startingSpan = detector.getCurrentSpan();
            return true;
        }
    };
    private double scale;
    private ScaleGestureDetector scaleGestureDetector;
    private float spanSlop;
    private float startingSpan;
    private double velocity;

    public final double getScale() {
        return this.scale;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getFocalPointX() {
        return this.focalPointX;
    }

    public final float getFocalPointY() {
        return this.focalPointY;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (getState() == 0) {
            View view = getView();
            Intrinsics.checkNotNull(view);
            Context context = view.getContext();
            resetProgress();
            this.scaleGestureDetector = new ScaleGestureDetector(context, this.gestureListener);
            this.spanSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            this.focalPointX = event.getX();
            this.focalPointY = event.getY();
            begin();
        }
        ScaleGestureDetector scaleGestureDetector = this.scaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(sourceEvent);
        }
        ScaleGestureDetector scaleGestureDetector2 = this.scaleGestureDetector;
        if (scaleGestureDetector2 != null) {
            PointF pointFTransformPoint = transformPoint(new PointF(scaleGestureDetector2.getFocusX(), scaleGestureDetector2.getFocusY()));
            this.focalPointX = pointFTransformPoint.x;
            this.focalPointY = pointFTransformPoint.y;
        }
        if (sourceEvent.getActionMasked() == 1) {
            if (getState() == 4) {
                end();
            } else {
                fail();
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
    protected void onReset() {
        this.scaleGestureDetector = null;
        this.focalPointX = Float.NaN;
        this.focalPointY = Float.NaN;
        resetProgress();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetProgress() {
        this.velocity = 0.0d;
        this.scale = 1.0d;
    }

    public static final class Factory extends GestureHandler.Factory {
        private final Class type = PinchGestureHandler.class;
        private final String name = "PinchGestureHandler";

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
        public PinchGestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public PinchGestureHandlerEventDataBuilder createEventBuilder(PinchGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PinchGestureHandlerEventDataBuilder(handler);
        }
    }
}
