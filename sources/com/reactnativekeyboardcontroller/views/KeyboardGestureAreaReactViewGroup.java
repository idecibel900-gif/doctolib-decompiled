package com.reactnativekeyboardcontroller.views;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController;
import com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator;
import com.reactnativekeyboardcontroller.interactive.interpolators.LinearInterpolator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardGestureAreaReactViewGroup extends ReactViewGroup {
    public static final Companion Companion = new Companion(null);
    private final Rect bounds;
    private final KeyboardAnimationController controller;
    private Interpolator interpolator;
    private boolean isHandling;
    private int keyboardHeight;
    private float lastTouchX;
    private float lastTouchY;
    private int lastWindowY;
    private int offset;
    private final ThemedReactContext reactContext;
    private boolean scrollKeyboardOffScreenWhenVisible;
    private boolean scrollKeyboardOnScreenWhenNotVisible;
    private VelocityTracker velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardGestureAreaReactViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.interpolator = new LinearInterpolator();
        this.scrollKeyboardOffScreenWhenVisible = true;
        this.bounds = new Rect();
        this.controller = new KeyboardAnimationController();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            onActionDown(motionEvent);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            onActionMove(motionEvent);
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            onActionUp(motionEvent);
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            onActionCancel();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setOffset(double d) {
        this.offset = (int) FloatKt.getPx((float) d);
    }

    public final void setInterpolator(String interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Interpolator linearInterpolator = (Interpolator) KeyboardGestureAreaReactViewGroupKt.getInterpolators().get(interpolator);
        if (linearInterpolator == null) {
            linearInterpolator = new LinearInterpolator();
        }
        this.interpolator = linearInterpolator;
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(boolean z) {
        this.scrollKeyboardOnScreenWhenNotVisible = z;
    }

    public final void setScrollKeyboardOffScreenWhenVisible(boolean z) {
        this.scrollKeyboardOffScreenWhenVisible = z;
    }

    private final void onActionDown(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        this.lastTouchX = motionEvent.getX();
        this.lastTouchY = motionEvent.getY();
        ViewKt.copyBoundsInWindow(this, this.bounds);
        this.lastWindowY = this.bounds.top;
    }

    private final void onActionMove(MotionEvent motionEvent) {
        ViewKt.copyBoundsInWindow(this, this.bounds);
        int i = this.bounds.top - this.lastWindowY;
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, i);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEventObtain);
        }
        float x = motionEventObtain.getX() - this.lastTouchX;
        float y = motionEventObtain.getY() - this.lastTouchY;
        boolean z = false;
        if (!this.isHandling) {
            this.isHandling = Math.abs(y) > Math.abs(x) && Math.abs(y) >= ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
        }
        if (this.isHandling) {
            if (this.controller.isInsetAnimationInProgress()) {
                if (this.keyboardHeight == 0) {
                    this.keyboardHeight = this.controller.getCurrentKeyboardHeight();
                }
                int iInterpolate = this.interpolator.interpolate(MathKt.roundToInt(y), getWindowHeight() - ((int) motionEvent.getRawY()), this.controller.getCurrentKeyboardHeight(), this.offset);
                if (iInterpolate != 0) {
                    this.controller.insetBy(iInterpolate);
                }
            } else if (!this.controller.isInsetAnimationRequestPending()) {
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this);
                if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
                    z = true;
                }
                if (shouldStartRequest(y, z)) {
                    KeyboardAnimationController.startControlRequest$default(this.controller, this, null, 2, null);
                }
            }
            this.lastTouchY = motionEvent.getY();
            this.lastTouchX = motionEvent.getX();
            this.lastWindowY = this.bounds.top;
        }
    }

    private final void onActionUp(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(500);
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        this.controller.animateToFinish((this.controller.isInsetAnimationInProgress() && this.keyboardHeight == this.controller.getCurrentKeyboardHeight()) ? null : velocityTracker3 != null ? Float.valueOf(velocityTracker3.getYVelocity()) : null);
        reset();
    }

    private final void onActionCancel() {
        this.controller.cancel();
        reset();
    }

    private final void reset() {
        this.isHandling = false;
        this.lastTouchX = 0.0f;
        this.lastTouchY = 0.0f;
        this.lastWindowY = 0;
        this.keyboardHeight = 0;
        this.bounds.setEmpty();
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    private final boolean shouldStartRequest(float f, boolean z) {
        if (f < 0.0f) {
            return !z && this.scrollKeyboardOnScreenWhenNotVisible;
        }
        return f > 0.0f && z && this.scrollKeyboardOffScreenWhenVisible;
    }

    private final int getWindowHeight() {
        Rect bounds;
        WindowManager windowManager;
        if (Build.VERSION.SDK_INT >= 30) {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            WindowMetrics currentWindowMetrics = (currentActivity == null || (windowManager = currentActivity.getWindowManager()) == null) ? null : windowManager.getCurrentWindowMetrics();
            if (currentWindowMetrics != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                return bounds.height();
            }
        }
        return 0;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
