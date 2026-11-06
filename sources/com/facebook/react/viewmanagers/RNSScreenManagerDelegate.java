package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSScreenManagerDelegate extends BaseViewManagerDelegate {
    public RNSScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        byte b;
        str.getClass();
        switch (str) {
            case "synchronousShadowStateUpdatesEnabled":
                b = 0;
                break;
            case "bottomScrollEdgeEffect":
                b = 1;
                break;
            case "homeIndicatorHidden":
                b = 2;
                break;
            case "topScrollEdgeEffect":
                b = 3;
                break;
            case "gestureEnabled":
                b = 4;
                break;
            case "leftScrollEdgeEffect":
                b = 5;
                break;
            case "hideKeyboardOnSwipe":
                b = 6;
                break;
            case "rightScrollEdgeEffect":
                b = 7;
                break;
            case "sheetCornerRadius":
                b = 8;
                break;
            case "navigationBarHidden":
                b = 9;
                break;
            case "statusBarTranslucent":
                b = 10;
                break;
            case "stackPresentation":
                b = 11;
                break;
            case "activityState":
                b = 12;
                break;
            case "statusBarColor":
                b = 13;
                break;
            case "statusBarStyle":
                b = 14;
                break;
            case "fullScreenSwipeShadowEnabled":
                b = 15;
                break;
            case "stackAnimation":
                b = 16;
                break;
            case "navigationBarColor":
                b = 17;
                break;
            case "screenId":
                b = 18;
                break;
            case "sheetInitialDetent":
                b = 19;
                break;
            case "sheetAllowedDetents":
                b = 20;
                break;
            case "replaceAnimation":
                b = 21;
                break;
            case "preventNativeDismiss":
                b = 22;
                break;
            case "statusBarHidden":
                b = 23;
                break;
            case "fullScreenSwipeEnabled":
                b = 24;
                break;
            case "gestureResponseDistance":
                b = 25;
                break;
            case "screenOrientation":
                b = 26;
                break;
            case "sheetLargestUndimmedDetent":
                b = 27;
                break;
            case "transitionDuration":
                b = 28;
                break;
            case "sheetShouldOverflowTopInset":
                b = 29;
                break;
            case "swipeDirection":
                b = 30;
                break;
            case "customAnimationOnSwipe":
                b = 31;
                break;
            case "navigationBarTranslucent":
                b = 32;
                break;
            case "ios26AllowInteractionsDuringTransition":
                b = 33;
                break;
            case "sheetElevation":
                b = 34;
                break;
            case "sheetDefaultResizeAnimationEnabled":
                b = 35;
                break;
            case "sheetGrabberVisible":
                b = 36;
                break;
            case "statusBarAnimation":
                b = 37;
                break;
            case "nativeBackButtonDismissalEnabled":
                b = 38;
                break;
            case "androidResetScreenShadowStateOnOrientationChangeEnabled":
                b = 39;
                break;
            case "sheetExpandsWhenScrolledToEdge":
                b = 40;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSScreenManagerInterface) this.mViewManager).setSynchronousShadowStateUpdatesEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSScreenManagerInterface) this.mViewManager).setBottomScrollEdgeEffect(view, (String) obj);
                break;
            case 2:
                ((RNSScreenManagerInterface) this.mViewManager).setHomeIndicatorHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSScreenManagerInterface) this.mViewManager).setTopScrollEdgeEffect(view, (String) obj);
                break;
            case 4:
                ((RNSScreenManagerInterface) this.mViewManager).setGestureEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 5:
                ((RNSScreenManagerInterface) this.mViewManager).setLeftScrollEdgeEffect(view, (String) obj);
                break;
            case 6:
                ((RNSScreenManagerInterface) this.mViewManager).setHideKeyboardOnSwipe(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSScreenManagerInterface) this.mViewManager).setRightScrollEdgeEffect(view, (String) obj);
                break;
            case 8:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetCornerRadius(view, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 9:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSScreenManagerInterface) this.mViewManager).setStackPresentation(view, (String) obj);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSScreenManagerInterface) this.mViewManager).setActivityState(view, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 13:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 14:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarStyle(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSScreenManagerInterface) this.mViewManager).setFullScreenSwipeShadowEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 16:
                ((RNSScreenManagerInterface) this.mViewManager).setStackAnimation(view, (String) obj);
                break;
            case 17:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSScreenManagerInterface) this.mViewManager).setScreenId(view, obj == null ? "" : (String) obj);
                break;
            case 19:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetInitialDetent(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetAllowedDetents(view, (ReadableArray) obj);
                break;
            case 21:
                ((RNSScreenManagerInterface) this.mViewManager).setReplaceAnimation(view, (String) obj);
                break;
            case 22:
                ((RNSScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 23:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSScreenManagerInterface) this.mViewManager).setFullScreenSwipeEnabled(view, (String) obj);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSScreenManagerInterface) this.mViewManager).setGestureResponseDistance(view, (ReadableMap) obj);
                break;
            case 26:
                ((RNSScreenManagerInterface) this.mViewManager).setScreenOrientation(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetLargestUndimmedDetent(view, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 28:
                ((RNSScreenManagerInterface) this.mViewManager).setTransitionDuration(view, obj == null ? 500 : ((Double) obj).intValue());
                break;
            case 29:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetShouldOverflowTopInset(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 30:
                ((RNSScreenManagerInterface) this.mViewManager).setSwipeDirection(view, (String) obj);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSScreenManagerInterface) this.mViewManager).setCustomAnimationOnSwipe(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 32:
                ((RNSScreenManagerInterface) this.mViewManager).setNavigationBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 33:
                ((RNSScreenManagerInterface) this.mViewManager).setIos26AllowInteractionsDuringTransition(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 34:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetElevation(view, obj != null ? ((Double) obj).intValue() : 24);
                break;
            case 35:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetDefaultResizeAnimationEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 36:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetGrabberVisible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 37:
                ((RNSScreenManagerInterface) this.mViewManager).setStatusBarAnimation(view, obj != null ? (String) obj : null);
                break;
            case 38:
                ((RNSScreenManagerInterface) this.mViewManager).setNativeBackButtonDismissalEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 39:
                ((RNSScreenManagerInterface) this.mViewManager).setAndroidResetScreenShadowStateOnOrientationChangeEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 40:
                ((RNSScreenManagerInterface) this.mViewManager).setSheetExpandsWhenScrolledToEdge(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
