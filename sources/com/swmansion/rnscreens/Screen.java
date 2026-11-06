package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.bottomsheet.BottomSheetBehaviorExtKt;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetDetents;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.utils.DecorViewInsetsUtilsKt;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Screen extends FabricEnabledViewGroup implements ScreenContentWrapper.OnLayoutCallback, FragmentProviding {
    public static final Companion Companion = new Companion(null);
    private ActivityState activityState;
    private ScreenContainer container;
    private ScreenFooter footer;
    private ScreenFragmentWrapper fragmentWrapper;
    private boolean insetsApplied;
    private boolean isBeingRemoved;
    private boolean isGestureEnabled;
    private Boolean isNavigationBarHidden;
    private boolean isSheetGrabberVisible;
    private Boolean isStatusBarAnimated;
    private Boolean isStatusBarHidden;
    private boolean isTransitioning;
    private boolean nativeBackButtonDismissalEnabled;
    private final ThemedReactContext reactContext;
    private ReplaceAnimation replaceAnimation;
    private String screenId;
    private Integer screenOrientation;
    private boolean sheetClosesOnTouchOutside;
    private float sheetCornerRadius;
    private boolean sheetDefaultResizeAnimationEnabled;
    private SheetDetents sheetDetents;
    private float sheetElevation;
    private boolean sheetExpandsWhenScrolledToEdge;
    private int sheetInitialDetentIndex;
    private int sheetLargestUndimmedDetentIndex;
    private boolean sheetShouldOverflowTopInset;
    private boolean shouldTriggerPostponedTransitionAfterLayout;
    private boolean shouldUpdateSheetCornerRadius;
    private StackAnimation stackAnimation;
    private StackPresentation stackPresentation;
    private String statusBarStyle;

    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public enum ReplaceAnimation {
        PUSH,
        POP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM,
        IOS_FROM_RIGHT,
        IOS_FROM_LEFT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL,
        FORM_SHEET;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackPresentation.values().length];
            try {
                iArr[StackPresentation.TRANSPARENT_MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackPresentation.FORM_SHEET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public enum WindowTraits {
        ORIENTATION,
        STYLE,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_HIDDEN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Screen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.stackPresentation = StackPresentation.PUSH;
        this.replaceAnimation = ReplaceAnimation.POP;
        this.stackAnimation = StackAnimation.DEFAULT;
        this.isGestureEnabled = true;
        this.sheetExpandsWhenScrolledToEdge = true;
        this.sheetDetents = new SheetDetents(CollectionsKt.listOf(Double.valueOf(1.0d)));
        this.sheetLargestUndimmedDetentIndex = -1;
        this.sheetClosesOnTouchOutside = true;
        this.sheetElevation = 24.0f;
        this.sheetDefaultResizeAnimationEnabled = true;
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.nativeBackButtonDismissalEnabled = true;
    }

    public final Fragment getFragment() {
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getFragment();
        }
        return null;
    }

    public final BottomSheetBehavior<Screen> getSheetBehavior() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        CoordinatorLayout.Behavior behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        return null;
    }

    public final EventDispatcher getReactEventDispatcher() {
        return UIManagerHelper.getEventDispatcherForReactTag(this.reactContext, getId());
    }

    public final boolean getInsetsApplied() {
        return this.insetsApplied;
    }

    public final void setInsetsApplied(boolean z) {
        this.insetsApplied = z;
    }

    public final ScreenFragmentWrapper getFragmentWrapper() {
        return this.fragmentWrapper;
    }

    public final void setFragmentWrapper(ScreenFragmentWrapper screenFragmentWrapper) {
        this.fragmentWrapper = screenFragmentWrapper;
    }

    public final ScreenContainer getContainer() {
        return this.container;
    }

    public final void setContainer(ScreenContainer screenContainer) {
        this.container = screenContainer;
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final void setStackPresentation(StackPresentation stackPresentation) {
        Intrinsics.checkNotNullParameter(stackPresentation, "<set-?>");
        this.stackPresentation = stackPresentation;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation) {
        Intrinsics.checkNotNullParameter(replaceAnimation, "<set-?>");
        this.replaceAnimation = replaceAnimation;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final void setStackAnimation(StackAnimation stackAnimation) {
        Intrinsics.checkNotNullParameter(stackAnimation, "<set-?>");
        this.stackAnimation = stackAnimation;
    }

    public final void setGestureEnabled(boolean z) {
        this.isGestureEnabled = z;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final String getScreenId() {
        return this.screenId;
    }

    public final void setScreenId(String str) {
        this.screenId = str;
    }

    public final Boolean isStatusBarAnimated() {
        return this.isStatusBarAnimated;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    public final boolean isBeingRemoved() {
        return this.isBeingRemoved;
    }

    public final void setBeingRemoved(boolean z) {
        this.isBeingRemoved = z;
    }

    public final void setSheetGrabberVisible(boolean z) {
        this.isSheetGrabberVisible = z;
    }

    public final float getSheetCornerRadius() {
        return this.sheetCornerRadius;
    }

    public final void setSheetCornerRadius(float f) {
        if (this.sheetCornerRadius == f) {
            return;
        }
        this.sheetCornerRadius = f;
        this.shouldUpdateSheetCornerRadius = true;
    }

    public final boolean getSheetExpandsWhenScrolledToEdge() {
        return this.sheetExpandsWhenScrolledToEdge;
    }

    public final void setSheetExpandsWhenScrolledToEdge(boolean z) {
        this.sheetExpandsWhenScrolledToEdge = z;
    }

    public final SheetDetents getSheetDetents() {
        return this.sheetDetents;
    }

    public final void setSheetDetents(SheetDetents sheetDetents) {
        Intrinsics.checkNotNullParameter(sheetDetents, "<set-?>");
        this.sheetDetents = sheetDetents;
    }

    public final int getSheetLargestUndimmedDetentIndex() {
        return this.sheetLargestUndimmedDetentIndex;
    }

    public final void setSheetLargestUndimmedDetentIndex(int i) {
        this.sheetLargestUndimmedDetentIndex = i;
    }

    public final int getSheetInitialDetentIndex() {
        return this.sheetInitialDetentIndex;
    }

    public final void setSheetInitialDetentIndex(int i) {
        this.sheetInitialDetentIndex = i;
    }

    public final boolean getSheetClosesOnTouchOutside() {
        return this.sheetClosesOnTouchOutside;
    }

    public final void setSheetClosesOnTouchOutside(boolean z) {
        this.sheetClosesOnTouchOutside = z;
    }

    public final float getSheetElevation() {
        return this.sheetElevation;
    }

    public final void setSheetElevation(float f) {
        this.sheetElevation = f;
    }

    public final boolean getSheetShouldOverflowTopInset() {
        return this.sheetShouldOverflowTopInset;
    }

    public final void setSheetShouldOverflowTopInset(boolean z) {
        this.sheetShouldOverflowTopInset = z;
    }

    public final boolean getSheetDefaultResizeAnimationEnabled() {
        return this.sheetDefaultResizeAnimationEnabled;
    }

    public final void setSheetDefaultResizeAnimationEnabled(boolean z) {
        this.sheetDefaultResizeAnimationEnabled = z;
    }

    public final boolean getShouldTriggerPostponedTransitionAfterLayout() {
        return this.shouldTriggerPostponedTransitionAfterLayout;
    }

    public final void setShouldTriggerPostponedTransitionAfterLayout(boolean z) {
        this.shouldTriggerPostponedTransitionAfterLayout = z;
    }

    public final ScreenFooter getFooter() {
        return this.footer;
    }

    public final void setFooter(ScreenFooter screenFooter) {
        BottomSheetBehavior<Screen> sheetBehavior;
        if (screenFooter == null && this.footer != null) {
            BottomSheetBehavior<Screen> sheetBehavior2 = getSheetBehavior();
            if (sheetBehavior2 != null) {
                ScreenFooter screenFooter2 = this.footer;
                Intrinsics.checkNotNull(screenFooter2);
                screenFooter2.unregisterWithSheetBehavior(sheetBehavior2);
            }
        } else if (screenFooter != null && (sheetBehavior = getSheetBehavior()) != null) {
            screenFooter.registerWithSheetBehavior(sheetBehavior);
        }
        this.footer = screenFooter;
    }

    private final boolean isNativeStackScreen() {
        return this.container instanceof ScreenStack;
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        return getFragment();
    }

    @Override // com.swmansion.rnscreens.ScreenContentWrapper.OnLayoutCallback
    public void onContentWrapperLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i4 - i2;
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (SheetUtilsKt.usesFormSheetPresentation(this) && SheetUtilsKt.isSheetFitToContents(this) && sheetBehavior != null) {
            int iFitToContentsSheetHeight = BottomSheetBehaviorExtKt.fitToContentsSheetHeight(sheetBehavior);
            boolean z2 = iFitToContentsSheetHeight == 0;
            if (iFitToContentsSheetHeight != i5) {
                if (z2) {
                    setupInitialSheetContentHeight(sheetBehavior, i5);
                } else if (this.sheetDefaultResizeAnimationEnabled) {
                    updateSheetContentHeightWithAnimation(sheetBehavior, iFitToContentsSheetHeight, i5);
                } else {
                    updateSheetContentHeightWithoutAnimation(sheetBehavior, i5);
                }
            }
        }
    }

    private final void updateSheetContentHeightWithAnimation(final BottomSheetBehavior bottomSheetBehavior, int i, int i2) {
        final float translationY = getTranslationY();
        int iResolveClampedHeight = resolveClampedHeight(i, translationY);
        final int iResolveClampedHeight2 = resolveClampedHeight(i2, translationY);
        float f = iResolveClampedHeight2 - iResolveClampedHeight;
        if (f == 0.0f) {
            return;
        }
        if (f > 0.0f) {
            setTranslationY(getTranslationY() + f);
            animate().translationY(translationY).withStartAction(new Runnable() { // from class: com.swmansion.rnscreens.Screen$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Screen.updateSheetContentHeightWithAnimation$lambda$2(bottomSheetBehavior, iResolveClampedHeight2, this);
                }
            }).withEndAction(new Runnable() { // from class: com.swmansion.rnscreens.Screen$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Screen.updateSheetContentHeightWithAnimation$lambda$3(this.f$0);
                }
            }).start();
        } else {
            animate().translationY(translationY - f).withStartAction(new Runnable() { // from class: com.swmansion.rnscreens.Screen$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    Screen.updateSheetContentHeightWithAnimation$lambda$4(bottomSheetBehavior, iResolveClampedHeight2);
                }
            }).withEndAction(new Runnable() { // from class: com.swmansion.rnscreens.Screen$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    Screen.updateSheetContentHeightWithAnimation$lambda$5(this.f$0, iResolveClampedHeight2, translationY);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSheetContentHeightWithAnimation$lambda$2(BottomSheetBehavior bottomSheetBehavior, int i, Screen screen) {
        BottomSheetBehaviorExtKt.updateMetrics$default(bottomSheetBehavior, Integer.valueOf(i), null, 2, null);
        screen.layout(screen.getLeft(), screen.getBottom() - i, screen.getRight(), screen.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSheetContentHeightWithAnimation$lambda$3(Screen screen) {
        screen.getParent().requestLayout();
        screen.onSheetYTranslationChanged$react_native_screens_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSheetContentHeightWithAnimation$lambda$4(BottomSheetBehavior bottomSheetBehavior, int i) {
        BottomSheetBehaviorExtKt.updateMetrics$default(bottomSheetBehavior, Integer.valueOf(i), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSheetContentHeightWithAnimation$lambda$5(Screen screen, int i, float f) {
        screen.layout(screen.getLeft(), screen.getBottom() - i, screen.getRight(), screen.getBottom());
        screen.setTranslationY(f);
        screen.getParent().requestLayout();
        screen.onSheetYTranslationChanged$react_native_screens_release();
    }

    private final void updateSheetContentHeightWithoutAnimation(BottomSheetBehavior bottomSheetBehavior, int i) {
        int iResolveClampedHeight = resolveClampedHeight(i, getTranslationY());
        BottomSheetBehaviorExtKt.updateMetrics$default(bottomSheetBehavior, Integer.valueOf(iResolveClampedHeight), null, 2, null);
        layout(getLeft(), getBottom() - iResolveClampedHeight, getRight(), getBottom());
        getParent().requestLayout();
        updateScreenSizeFabric(getWidth(), iResolveClampedHeight, getTop() + ((int) getTranslationY()));
    }

    private final void setupInitialSheetContentHeight(BottomSheetBehavior bottomSheetBehavior, int i) {
        BottomSheetBehaviorExtKt.useSingleDetent$default(bottomSheetBehavior, Integer.valueOf(i), false, null, 6, null);
        requestLayout();
    }

    private final int resolveClampedHeight(int i, float f) {
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate$react_native_screens_release;
        Integer numTryResolveMaxFormSheetHeight$react_native_screens_release;
        Fragment fragment = getFragment();
        return (fragment == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate$react_native_screens_release = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null || (numTryResolveMaxFormSheetHeight$react_native_screens_release = sheetDelegate$react_native_screens_release.tryResolveMaxFormSheetHeight$react_native_screens_release()) == null) ? i : RangesKt.coerceAtMost(i, (int) (numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue() + f));
    }

    public final void registerLayoutCallbackForWrapper(ScreenContentWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        wrapper.setDelegate$react_native_screens_release(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ScreenStackHeaderConfig headerConfig;
        ScreenStackHeaderConfig headerConfig2;
        Window window;
        if (z && isNativeStackScreen() && !SheetUtilsKt.usesFormSheetPresentation(this)) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (!this.insetsApplied && (headerConfig = getHeaderConfig()) != null && !headerConfig.isHeaderHidden() && (headerConfig2 = getHeaderConfig()) != null && !headerConfig2.isHeaderTranslucent()) {
                Activity currentActivity = this.reactContext.getCurrentActivity();
                View decorView = (currentActivity == null || (window = currentActivity.getWindow()) == null) ? null : window.getDecorView();
                if (decorView == null) {
                    throw new IllegalArgumentException("[RNScreens] DecorView is required for applying inset correction, but was null.");
                }
                int decorViewTopInset = DecorViewInsetsUtilsKt.getDecorViewTopInset(decorView);
                dispatchShadowStateUpdate(i5, i6 - decorViewTopInset, i2 + decorViewTopInset);
                return;
            }
            dispatchShadowStateUpdate(i5, i6, i2);
        }
    }

    public final void onBottomSheetBehaviorDidLayout$react_native_screens_release(boolean z) {
        if (SheetUtilsKt.usesFormSheetPresentation(this) && isNativeStackScreen()) {
            if (SheetUtilsKt.isSheetFitToContents(this)) {
                requestLayout();
            }
            if (z) {
                dispatchShadowStateUpdate(getWidth(), getHeight(), getTop());
            }
            ScreenFooter screenFooter = this.footer;
            if (screenFooter != null) {
                int left = getLeft();
                int top = getTop();
                int right = getRight();
                int bottom = getBottom();
                ScreenContainer screenContainer = this.container;
                Intrinsics.checkNotNull(screenContainer);
                screenFooter.onParentLayout(z, left, top, right, bottom, screenContainer.getHeight());
            }
        }
    }

    public final void requestTriggeringPostponedEnterTransition$react_native_screens_release() {
        if (this.sheetShouldOverflowTopInset) {
            return;
        }
        this.shouldTriggerPostponedTransitionAfterLayout = true;
    }

    public final void triggerPostponedEnterTransitionIfNeeded$react_native_screens_release() {
        if (this.shouldTriggerPostponedTransitionAfterLayout) {
            this.shouldTriggerPostponedTransitionAfterLayout = false;
            Fragment fragment = getFragment();
            if (fragment != null) {
                fragment.startPostponedEnterTransition();
            }
        }
    }

    private final void dispatchShadowStateUpdate(int i, int i2, int i3) {
        updateScreenSizeFabric(i, i2, i3);
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        Object next;
        Iterator it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((View) next) instanceof ScreenStackHeaderConfig));
        if (next instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) next;
        }
        return null;
    }

    public final ScreenContentWrapper getContentWrapper() {
        Object next;
        Iterator it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((View) next) instanceof ScreenContentWrapper));
        if (next instanceof ScreenContentWrapper) {
            return (ScreenContentWrapper) next;
        }
        return null;
    }

    public final void setTransitioning(boolean z) {
        if (this.isTransitioning == z) {
            return;
        }
        this.isTransitioning = z;
        boolean zHasWebView = hasWebView(this);
        if (!zHasWebView || getLayerType() == 2) {
            super.setLayerType((!z || zHasWebView) ? 0 : 2, null);
        }
    }

    public final boolean isTranslucent() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.stackPresentation.ordinal()];
        return i == 1 || i == 2;
    }

    private final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void setActivityState(ActivityState activityState) {
        Intrinsics.checkNotNullParameter(activityState, "activityState");
        ActivityState activityState2 = this.activityState;
        if (activityState == activityState2) {
            return;
        }
        if ((this.container instanceof ScreenStack) && activityState2 != null) {
            Intrinsics.checkNotNull(activityState2);
            if (activityState.compareTo(activityState2) < 0) {
                throw new IllegalStateException("[RNScreens] activityState can only progress in NativeStack");
            }
        }
        this.activityState = activityState;
        ScreenContainer screenContainer = this.container;
        if (screenContainer != null) {
            screenContainer.onChildUpdate();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    public final void setScreenOrientation(String str) {
        int i;
        if (str == null) {
            this.screenOrientation = null;
            return;
        }
        ScreenWindowTraits screenWindowTraits = ScreenWindowTraits.INSTANCE;
        screenWindowTraits.applyDidSetOrientation$react_native_screens_release();
        switch (str) {
            case "portrait_down":
                i = 9;
                break;
            case "all":
                i = 10;
                break;
            case "portrait":
                i = 7;
                break;
            case "landscape":
                i = 6;
                break;
            case "portrait_up":
                i = 1;
                break;
            case "landscape_left":
                i = 8;
                break;
            case "landscape_right":
                i = 0;
                break;
            default:
                i = -1;
                break;
        }
        this.screenOrientation = Integer.valueOf(i);
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            screenWindowTraits.setOrientation$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final void changeAccessibilityMode(int i) {
        CustomToolbar toolbar;
        setImportantForAccessibility(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig == null || (toolbar = headerConfig.getToolbar()) == null) {
            return;
        }
        toolbar.setImportantForAccessibility(i);
    }

    public final void changeFocusability$react_native_screens_release(int i, int i2) {
        CustomToolbar toolbar;
        CustomToolbar toolbar2;
        setFocusable(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null && (toolbar2 = headerConfig.getToolbar()) != null) {
            toolbar2.setFocusable(i);
        }
        setDescendantFocusability(i2);
        ScreenStackHeaderConfig headerConfig2 = getHeaderConfig();
        if (headerConfig2 == null || (toolbar = headerConfig2.getToolbar()) == null) {
            return;
        }
        toolbar.setDescendantFocusability(i2);
    }

    public final void changeFocusabilityCompat$react_native_screens_release(boolean z, int i) {
        CustomToolbar toolbar;
        CustomToolbar toolbar2;
        setFocusable(z);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig != null && (toolbar2 = headerConfig.getToolbar()) != null) {
            toolbar2.setFocusable(z);
        }
        setDescendantFocusability(i);
        ScreenStackHeaderConfig headerConfig2 = getHeaderConfig();
        if (headerConfig2 == null || (toolbar = headerConfig2.getToolbar()) == null) {
            return;
        }
        toolbar.setDescendantFocusability(i);
    }

    public final String getStatusBarStyle() {
        return this.statusBarStyle;
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarStyle = str;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setStyle$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Boolean isStatusBarHidden() {
        return this.isStatusBarHidden;
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final Boolean isNavigationBarHidden() {
        return this.isNavigationBarHidden;
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.nativeBackButtonDismissalEnabled;
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.nativeBackButtonDismissalEnabled = z;
    }

    public final void startRemovalTransition() {
        if (this.isBeingRemoved) {
            return;
        }
        this.isBeingRemoved = true;
        startTransitionRecursive(this);
    }

    public final void endRemovalTransition() {
        if (this.isBeingRemoved) {
            this.isBeingRemoved = false;
            endTransitionRecursive(this);
        }
    }

    private final void endTransitionRecursive(ViewGroup viewGroup) {
        for (View view : ViewGroupKt.getChildren(viewGroup)) {
            viewGroup.endViewTransition(view);
            if (view instanceof ScreenStackHeaderConfig) {
                endTransitionRecursive(((ScreenStackHeaderConfig) view).getToolbar());
            }
            if (view instanceof ViewGroup) {
                endTransitionRecursive((ViewGroup) view);
            }
        }
    }

    private final void startTransitionRecursive(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((viewGroup instanceof SwipeRefreshLayout) && (childAt instanceof ImageView)) {
                    viewGroup.addView(new View(getContext()), i);
                } else if (childAt != null) {
                    viewGroup.startViewTransition(childAt);
                }
                if (childAt instanceof ScreenStackHeaderConfig) {
                    startTransitionRecursive(((ScreenStackHeaderConfig) childAt).getToolbar());
                }
                if (childAt instanceof ViewGroup) {
                    startTransitionRecursive((ViewGroup) childAt);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (SheetUtilsKt.usesFormSheetPresentation(this)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void notifyHeaderHeightChange$react_native_screens_release(int i) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderHeightChangeEvent(surfaceId, getId(), PixelUtil.toDIPFromPixel(i)));
        }
    }

    public final void onSheetDetentChanged$react_native_screens_release(int i, boolean z) {
        dispatchSheetDetentChanged(i, z);
        if (z) {
            onSheetYTranslationChanged$react_native_screens_release();
        }
        ScreenContainer screenContainer = this.container;
        if (!(screenContainer == null ? true : screenContainer instanceof ScreenStack)) {
            throw new IllegalStateException("[RNScreens] Expected native stack screen.");
        }
        ScreenStack screenStack = (ScreenStack) screenContainer;
        if (screenStack != null) {
            screenStack.updateA11yForVisibleScreens$react_native_screens_release();
        }
    }

    public final void onSheetYTranslationChanged$react_native_screens_release() {
        updateScreenSizeFabric(getWidth(), getHeight(), getTop() + ((int) getTranslationY()));
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        this.insetsApplied = true;
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Fragment fragment;
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate$react_native_screens_release;
        super.onAttachedToWindow();
        if (!SheetUtilsKt.usesFormSheetPresentation(this) || (fragment = getFragment()) == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate$react_native_screens_release = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null) {
            return;
        }
        InsetsObserverProxy.INSTANCE.addOnApplyWindowInsetsListener(sheetDelegate$react_native_screens_release);
    }

    private final void dispatchSheetDetentChanged(int i, boolean z) {
        int surfaceId = UIManagerHelper.getSurfaceId(this.reactContext);
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher != null) {
            reactEventDispatcher.dispatchEvent(new SheetDetentChangedEvent(surfaceId, getId(), i, z));
        }
    }

    public final void onFinalizePropsUpdate$react_native_screens_release() {
        if (this.shouldUpdateSheetCornerRadius) {
            this.shouldUpdateSheetCornerRadius = false;
            onSheetCornerRadiusChange$react_native_screens_release();
        }
    }

    public final void onSheetCornerRadiusChange$react_native_screens_release() {
        if (this.stackPresentation != StackPresentation.FORM_SHEET || getBackground() == null) {
            return;
        }
        Drawable background = getBackground();
        MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
        if (materialShapeDrawable != null) {
            float fMax = Math.max(PixelUtil.toDIPFromPixel(this.sheetCornerRadius), 0.0f);
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
            builder.setTopLeftCorner(0, fMax);
            builder.setTopRightCorner(0, fMax);
            materialShapeDrawable.setShapeAppearanceModel(builder.build());
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
