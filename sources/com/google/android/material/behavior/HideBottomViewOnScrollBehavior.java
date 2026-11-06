package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.R$attr;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior {
    private AccessibilityManager accessibilityManager;
    private int additionalHiddenOffsetY;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private boolean disableOnTouchExploration;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height;
    private final LinkedHashSet onScrollStateChangedListeners;
    private AccessibilityManager.TouchExplorationStateChangeListener touchExplorationListener;
    private static final int ENTER_ANIM_DURATION_ATTR = R$attr.motionDurationLong2;
    private static final int EXIT_ANIM_DURATION_ATTR = R$attr.motionDurationMedium4;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R$attr.motionEasingEmphasizedInterpolator;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior() {
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.disableOnTouchExploration = true;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.disableOnTouchExploration = true;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.height = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(view.getContext(), ENTER_ANIM_DURATION_ATTR, JfifUtil.MARKER_APP1);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(view.getContext(), EXIT_ANIM_DURATION_ATTR, 175);
        Context context = view.getContext();
        int i2 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(context, i2, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(view.getContext(), i2, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        disableIfTouchExplorationEnabled(view);
        return super.onLayoutChild(coordinatorLayout, view, i);
    }

    private void disableIfTouchExplorationEnabled(final View view) {
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        if (this.accessibilityManager == null || this.touchExplorationListener != null) {
            return;
        }
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                HideBottomViewOnScrollBehavior.m3501$r8$lambda$u8hW3V09BoGAavrLZRTR540LS0(this.f$0, view, z);
            }
        };
        this.touchExplorationListener = touchExplorationStateChangeListener;
        this.accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                if (HideBottomViewOnScrollBehavior.this.touchExplorationListener == null || HideBottomViewOnScrollBehavior.this.accessibilityManager == null) {
                    return;
                }
                HideBottomViewOnScrollBehavior.this.accessibilityManager.removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.this.touchExplorationListener);
                HideBottomViewOnScrollBehavior.this.touchExplorationListener = null;
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$u8hW3V09BoGAavr-LZRTR540LS0, reason: not valid java name */
    public static /* synthetic */ void m3501$r8$lambda$u8hW3V09BoGAavrLZRTR540LS0(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view, boolean z) {
        if (!z) {
            hideBottomViewOnScrollBehavior.getClass();
        } else if (hideBottomViewOnScrollBehavior.isScrolledDown()) {
            hideBottomViewOnScrollBehavior.slideUp(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            slideDown(view);
        } else if (i2 < 0) {
            slideUp(view);
        }
    }

    public boolean isScrolledUp() {
        return this.currentState == 2;
    }

    public void slideUp(View view) {
        slideUp(view, true);
    }

    public void slideUp(View view, boolean z) {
        if (isScrolledUp()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        updateCurrentState(view, 2);
        if (z) {
            animateChildTo(view, 0, this.enterAnimDuration, this.enterAnimInterpolator);
        } else {
            view.setTranslationY(0);
        }
    }

    public boolean isScrolledDown() {
        return this.currentState == 1;
    }

    public void slideDown(View view) {
        slideDown(view, true);
    }

    public void slideDown(View view, boolean z) {
        AccessibilityManager accessibilityManager;
        if (isScrolledDown()) {
            return;
        }
        if (this.disableOnTouchExploration && (accessibilityManager = this.accessibilityManager) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        updateCurrentState(view, 1);
        int i = this.height + this.additionalHiddenOffsetY;
        if (z) {
            animateChildTo(view, i, this.exitAnimDuration, this.exitAnimInterpolator);
        } else {
            view.setTranslationY(i);
        }
    }

    private void updateCurrentState(View view, int i) {
        this.currentState = i;
        Iterator it = this.onScrollStateChangedListeners.iterator();
        if (it.hasNext()) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
            throw null;
        }
    }

    private void animateChildTo(View view, int i, long j, TimeInterpolator timeInterpolator) {
        this.currentAnimator = view.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }
}
