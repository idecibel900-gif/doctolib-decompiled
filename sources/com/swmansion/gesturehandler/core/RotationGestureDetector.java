package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RotationGestureDetector {
    private float anchorX;
    private float anchorY;
    private long currentTime;
    private final OnRotationGestureListener gestureListener;
    private boolean isInProgress;
    private boolean isPaused;
    private final int[] pointerIds = new int[2];
    private double previousAngle;
    private long previousTime;
    private double rotation;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);

        boolean onRotationBegin(RotationGestureDetector rotationGestureDetector);

        void onRotationEnd(RotationGestureDetector rotationGestureDetector);
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.gestureListener = onRotationGestureListener;
    }

    public final double getRotation() {
        return this.rotation;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }

    public final long getTimeDelta() {
        return this.currentTime - this.previousTime;
    }

    private final void updateCurrent(MotionEvent motionEvent) {
        this.previousTime = this.currentTime;
        this.currentTime = motionEvent.getEventTime();
        int iFindPointerIndex = motionEvent.findPointerIndex(this.pointerIds[0]);
        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.pointerIds[1]);
        if (iFindPointerIndex == -1 || iFindPointerIndex2 == -1) {
            return;
        }
        float x = motionEvent.getX(iFindPointerIndex);
        float y = motionEvent.getY(iFindPointerIndex);
        float x2 = motionEvent.getX(iFindPointerIndex2);
        float y2 = motionEvent.getY(iFindPointerIndex2);
        this.anchorX = (x + x2) * 0.5f;
        this.anchorY = (y + y2) * 0.5f;
        double d = -Math.atan2(y2 - y, x2 - x);
        tryUnpause(d);
        double d2 = Double.isNaN(this.previousAngle) ? 0.0d : this.previousAngle - d;
        this.rotation = d2;
        this.previousAngle = d;
        if (d2 > 3.141592653589793d) {
            this.rotation = d2 - 3.141592653589793d;
        } else if (d2 < -3.141592653589793d) {
            this.rotation = d2 + 3.141592653589793d;
        }
        double d3 = this.rotation;
        if (d3 > 1.5707963267948966d) {
            this.rotation = d3 - 3.141592653589793d;
        } else if (d3 < -1.5707963267948966d) {
            this.rotation = d3 + 3.141592653589793d;
        }
    }

    private final void tryPause() {
        if (this.isPaused) {
            return;
        }
        this.isPaused = true;
    }

    private final void tryUnpause(double d) {
        if (this.isPaused) {
            this.previousAngle = d;
            this.isPaused = false;
        }
    }

    private final void finish() {
        if (this.isInProgress) {
            this.isPaused = false;
            this.isInProgress = false;
            OnRotationGestureListener onRotationGestureListener = this.gestureListener;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.onRotationEnd(this);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent event) {
        OnRotationGestureListener onRotationGestureListener;
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.isInProgress = false;
            this.pointerIds[0] = event.getPointerId(event.getActionIndex());
            this.pointerIds[1] = -1;
        } else if (actionMasked == 1) {
            finish();
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                if (!this.isInProgress || this.isPaused) {
                    this.pointerIds[1] = event.getPointerId(event.getActionIndex());
                    updateCurrent(event);
                }
                if (!this.isInProgress) {
                    this.isInProgress = true;
                    this.previousTime = event.getEventTime();
                    this.previousAngle = Double.NaN;
                    OnRotationGestureListener onRotationGestureListener2 = this.gestureListener;
                    if (onRotationGestureListener2 != null) {
                        onRotationGestureListener2.onRotationBegin(this);
                    }
                }
            } else if (actionMasked == 6 && this.isInProgress) {
                int pointerId = event.getPointerId(event.getActionIndex());
                int[] iArr = this.pointerIds;
                if (pointerId == iArr[0]) {
                    iArr[0] = iArr[1];
                    iArr[1] = -1;
                    tryPause();
                } else if (pointerId == iArr[1]) {
                    iArr[1] = -1;
                    tryPause();
                }
            }
        } else if (this.isInProgress) {
            updateCurrent(event);
            if (!this.isPaused && (onRotationGestureListener = this.gestureListener) != null) {
                onRotationGestureListener.onRotation(this);
            }
        }
        return true;
    }
}
