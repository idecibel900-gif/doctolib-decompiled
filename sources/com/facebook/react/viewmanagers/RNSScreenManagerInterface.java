package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSScreenManagerInterface extends ViewManagerWithGeneratedInterface {
    void setActivityState(View view, float f);

    void setAndroidResetScreenShadowStateOnOrientationChangeEnabled(View view, boolean z);

    void setBottomScrollEdgeEffect(View view, String str);

    void setCustomAnimationOnSwipe(View view, boolean z);

    void setFullScreenSwipeEnabled(View view, String str);

    void setFullScreenSwipeShadowEnabled(View view, boolean z);

    void setGestureEnabled(View view, boolean z);

    void setGestureResponseDistance(View view, ReadableMap readableMap);

    void setHideKeyboardOnSwipe(View view, boolean z);

    void setHomeIndicatorHidden(View view, boolean z);

    void setIos26AllowInteractionsDuringTransition(View view, boolean z);

    void setLeftScrollEdgeEffect(View view, String str);

    void setNativeBackButtonDismissalEnabled(View view, boolean z);

    void setNavigationBarColor(View view, Integer num);

    void setNavigationBarHidden(View view, boolean z);

    void setNavigationBarTranslucent(View view, boolean z);

    void setPreventNativeDismiss(View view, boolean z);

    void setReplaceAnimation(View view, String str);

    void setRightScrollEdgeEffect(View view, String str);

    void setScreenId(View view, String str);

    void setScreenOrientation(View view, String str);

    void setSheetAllowedDetents(View view, ReadableArray readableArray);

    void setSheetCornerRadius(View view, float f);

    void setSheetDefaultResizeAnimationEnabled(View view, boolean z);

    void setSheetElevation(View view, int i);

    void setSheetExpandsWhenScrolledToEdge(View view, boolean z);

    void setSheetGrabberVisible(View view, boolean z);

    void setSheetInitialDetent(View view, int i);

    void setSheetLargestUndimmedDetent(View view, int i);

    void setSheetShouldOverflowTopInset(View view, boolean z);

    void setStackAnimation(View view, String str);

    void setStackPresentation(View view, String str);

    void setStatusBarAnimation(View view, String str);

    void setStatusBarColor(View view, Integer num);

    void setStatusBarHidden(View view, boolean z);

    void setStatusBarStyle(View view, String str);

    void setStatusBarTranslucent(View view, boolean z);

    void setSwipeDirection(View view, String str);

    void setSynchronousShadowStateUpdatesEnabled(View view, boolean z);

    void setTopScrollEdgeEffect(View view, String str);

    void setTransitionDuration(View view, int i);
}
