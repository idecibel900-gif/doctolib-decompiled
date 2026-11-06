package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.swmansion.gesturehandler.react.eventbuilders.RotationGestureHandlerEventDataBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RotationGestureHandler extends GestureHandler {
    public static final Companion Companion = new Companion(null);
    private float anchorX = Float.NaN;
    private float anchorY = Float.NaN;
    private final RotationGestureDetector.OnRotationGestureListener gestureListener = new RotationGestureDetector.OnRotationGestureListener() { // from class: com.swmansion.gesturehandler.core.RotationGestureHandler$gestureListener$1
        @Override // com.swmansion.gesturehandler.core.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotationBegin(RotationGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(RotationGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            double rotation = this.this$0.getRotation();
            RotationGestureHandler rotationGestureHandler = this.this$0;
            rotationGestureHandler.rotation = rotationGestureHandler.getRotation() + detector.getRotation();
            long timeDelta = detector.getTimeDelta();
            if (timeDelta > 0) {
                RotationGestureHandler rotationGestureHandler2 = this.this$0;
                rotationGestureHandler2.velocity = (rotationGestureHandler2.getRotation() - rotation) / timeDelta;
            }
            if (Math.abs(this.this$0.getRotation()) < 0.08726646259971647d || this.this$0.getState() != 2) {
                return true;
            }
            this.this$0.activate();
            return true;
        }

        @Override // com.swmansion.gesturehandler.core.RotationGestureDetector.OnRotationGestureListener
        public void onRotationEnd(RotationGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            if (this.this$0.getState() == 4) {
                this.this$0.end();
            } else {
                this.this$0.fail();
            }
        }
    };
    private double rotation;
    private RotationGestureDetector rotationGestureDetector;
    private double velocity;

    public final double getRotation() {
        return this.rotation;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (getState() == 0) {
            resetProgress();
            this.rotationGestureDetector = new RotationGestureDetector(this.gestureListener);
            this.anchorX = event.getX();
            this.anchorY = event.getY();
            begin();
        }
        RotationGestureDetector rotationGestureDetector = this.rotationGestureDetector;
        if (rotationGestureDetector != null) {
            rotationGestureDetector.onTouchEvent(sourceEvent);
        }
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 != null) {
            PointF pointFTransformPoint = transformPoint(new PointF(rotationGestureDetector2.getAnchorX(), rotationGestureDetector2.getAnchorY()));
            this.anchorX = pointFTransformPoint.x;
            this.anchorY = pointFTransformPoint.y;
        }
        if (sourceEvent.getActionMasked() == 1 && getState() == 2) {
            fail();
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
        this.rotationGestureDetector = null;
        this.anchorX = Float.NaN;
        this.anchorY = Float.NaN;
        resetProgress();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetProgress() {
        this.velocity = 0.0d;
        this.rotation = 0.0d;
    }

    public static final class Factory extends GestureHandler.Factory {
        private final Class type = RotationGestureHandler.class;
        private final String name = "RotationGestureHandler";

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
        public RotationGestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler.Factory
        public RotationGestureHandlerEventDataBuilder createEventBuilder(RotationGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new RotationGestureHandlerEventDataBuilder(handler);
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
