package com.reactnativekeyboardcontroller.interactive;

import android.os.CancellationSignal;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.DynamicAnimationKt;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardAnimationController {
    private final Lazy animationControlListener$delegate = LazyKt.lazy(new Function0() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return KeyboardAnimationController.animationControlListener_delegate$lambda$0(this.f$0);
        }
    });
    private SpringAnimation currentSpringAnimation;
    private WindowInsetsAnimationControllerCompat insetsAnimationController;
    private boolean isImeShownAtStart;
    private CancellationSignal pendingRequestCancellationSignal;
    private Function1 pendingRequestOnReady;

    private final KeyboardAnimationController$animationControlListener$2$1 getAnimationControlListener() {
        return (KeyboardAnimationController$animationControlListener$2$1) this.animationControlListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2$1] */
    public static final KeyboardAnimationController$animationControlListener$2$1 animationControlListener_delegate$lambda$0(final KeyboardAnimationController keyboardAnimationController) {
        return new WindowInsetsAnimationControlListenerCompat() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2$1
            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onReady(WindowInsetsAnimationControllerCompat controller, int i) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                this.this$0.onRequestReady(controller);
            }

            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onFinished(WindowInsetsAnimationControllerCompat controller) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                this.this$0.reset();
            }

            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onCancelled(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
                this.this$0.reset();
            }
        };
    }

    public static /* synthetic */ void startControlRequest$default(KeyboardAnimationController keyboardAnimationController, View view, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        keyboardAnimationController.startControlRequest(view, function1);
    }

    public final void startControlRequest(View view, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isInsetAnimationInProgress()) {
            throw new IllegalStateException("Animation in progress. Can not start a new request to controlWindowInsetsAnimation()");
        }
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        boolean z = false;
        if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            z = true;
        }
        this.isImeShownAtStart = z;
        this.pendingRequestCancellationSignal = new CancellationSignal();
        this.pendingRequestOnReady = function1;
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(view);
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(WindowInsetsCompat.Type.ime(), -1L, KeyboardAnimationControllerKt.linearInterpolator, this.pendingRequestCancellationSignal, getAnimationControlListener());
        }
    }

    public final int insetBy(int i) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        return insetTo(windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - i);
    }

    public final int insetTo(int i) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        int i2 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        boolean z = this.isImeShownAtStart;
        int i4 = z ? i3 : i2;
        int i5 = z ? i2 : i3;
        int iCoerceIn = RangesKt.coerceIn(i, i2, i3);
        int i6 = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - iCoerceIn;
        windowInsetsAnimationControllerCompat.setInsetsAndAlpha(Insets.of(0, 0, 0, iCoerceIn), 1.0f, (iCoerceIn - i4) / (i5 - i4));
        return i6;
    }

    public final boolean isInsetAnimationInProgress() {
        return this.insetsAnimationController != null;
    }

    public final boolean isInsetAnimationRequestPending() {
        return this.pendingRequestCancellationSignal != null;
    }

    public final void cancel() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat != null) {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
        CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        reset();
    }

    public final void finish() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            windowInsetsAnimationControllerCompat.finish(!this.isImeShownAtStart);
        } else {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
    }

    public final void animateToFinish(Float f) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(false);
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (f != null) {
            animateImeToVisibility(f.floatValue() < 0.0f, f);
            return;
        }
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            animateImeToVisibility$default(this, !this.isImeShownAtStart, null, 2, null);
        } else {
            animateImeToVisibility$default(this, this.isImeShownAtStart, null, 2, null);
        }
    }

    public final int getCurrentKeyboardHeight() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        return windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestReady(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
        this.pendingRequestCancellationSignal = null;
        this.insetsAnimationController = windowInsetsAnimationControllerCompat;
        Function1 function1 = this.pendingRequestOnReady;
        if (function1 != null) {
            function1.invoke(windowInsetsAnimationControllerCompat);
        }
        this.pendingRequestOnReady = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reset() {
        this.insetsAnimationController = null;
        this.pendingRequestCancellationSignal = null;
        this.isImeShownAtStart = false;
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.currentSpringAnimation = null;
        this.pendingRequestOnReady = null;
    }

    static /* synthetic */ void animateImeToVisibility$default(KeyboardAnimationController keyboardAnimationController, boolean z, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        keyboardAnimationController.animateImeToVisibility(z, f);
    }

    private final void animateImeToVisibility(boolean z, Float f) {
        int i;
        final WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Controller should not be null");
        }
        Function1 function1 = new Function1() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeyboardAnimationController.animateImeToVisibility$lambda$3(this.f$0, ((Float) obj).floatValue());
            }
        };
        Function0 function0 = new Function0() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(KeyboardAnimationController.animateImeToVisibility$lambda$4(windowInsetsAnimationControllerCompat));
            }
        };
        if (z) {
            i = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        } else {
            i = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        }
        SpringAnimation springAnimationSpringAnimationOf = DynamicAnimationKt.springAnimationOf(function1, function0, i);
        if (springAnimationSpringAnimationOf.getSpring() == null) {
            springAnimationSpringAnimationOf.setSpring(new SpringForce());
        }
        SpringForce spring = springAnimationSpringAnimationOf.getSpring();
        Intrinsics.checkExpressionValueIsNotNull(spring, "spring");
        spring.setDampingRatio(1.0f);
        spring.setStiffness(1500.0f);
        if (f != null) {
            springAnimationSpringAnimationOf.setStartVelocity(f.floatValue());
        }
        springAnimationSpringAnimationOf.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f2, float f3) {
                KeyboardAnimationController.animateImeToVisibility$lambda$7$lambda$6(this.f$0, dynamicAnimation, z2, f2, f3);
            }
        });
        springAnimationSpringAnimationOf.start();
        this.currentSpringAnimation = springAnimationSpringAnimationOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateImeToVisibility$lambda$3(KeyboardAnimationController keyboardAnimationController, float f) {
        keyboardAnimationController.insetTo(MathKt.roundToInt(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float animateImeToVisibility$lambda$4(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
        return windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateImeToVisibility$lambda$7$lambda$6(KeyboardAnimationController keyboardAnimationController, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        if (Intrinsics.areEqual(dynamicAnimation, keyboardAnimationController.currentSpringAnimation)) {
            keyboardAnimationController.currentSpringAnimation = null;
        }
        keyboardAnimationController.finish();
    }
}
