package com.facebook.react.viewmanagers;

import android.view.View;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSTabsScreenManagerDelegate extends BaseViewManagerDelegate {
    public RNSTabsScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1991728986:
                if (str.equals("bottomScrollEdgeEffect")) {
                    b = 0;
                }
                break;
            case -1871891504:
                if (str.equals("topScrollEdgeEffect")) {
                    b = 1;
                }
                break;
            case -1829317469:
                if (str.equals("userInterfaceStyle")) {
                    b = 2;
                }
                break;
            case -1791070590:
                if (str.equals("leftScrollEdgeEffect")) {
                    b = 3;
                }
                break;
            case -1770963447:
                if (str.equals("specialEffects")) {
                    b = 4;
                }
                break;
            case -1628518761:
                if (str.equals("rightScrollEdgeEffect")) {
                    b = 5;
                }
                break;
            case -1559978286:
                if (str.equals("iconResourceName")) {
                    b = 6;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    b = 7;
                }
                break;
            case -1270820115:
                if (str.equals("isFocused")) {
                    b = 8;
                }
                break;
            case -1186468415:
                if (str.equals("overrideScrollViewContentInsetAdjustmentBehavior")) {
                    b = 9;
                }
                break;
            case -1167193694:
                if (str.equals("isTitleUndefined")) {
                    b = 10;
                }
                break;
            case -881409398:
                if (str.equals("tabKey")) {
                    b = 11;
                }
                break;
            case -776576227:
                if (str.equals("iconImageSource")) {
                    b = 12;
                }
                break;
            case -737911981:
                if (str.equals("iconType")) {
                    b = 13;
                }
                break;
            case -558395241:
                if (str.equals("tabBarItemAccessibilityLabel")) {
                    b = 14;
                }
                break;
            case -270334418:
                if (str.equals("scrollEdgeAppearance")) {
                    b = 15;
                }
                break;
            case -10721392:
                if (str.equals("drawableIconResourceName")) {
                    b = 16;
                }
                break;
            case 28389121:
                if (str.equals("standardAppearance")) {
                    b = 17;
                }
                break;
            case 110371416:
                if (str.equals(b.S)) {
                    b = 18;
                }
                break;
            case 642560482:
                if (str.equals("systemItem")) {
                    b = 19;
                }
                break;
            case 1001537282:
                if (str.equals("selectedIconImageSource")) {
                    b = 20;
                }
                break;
            case 1072026510:
                if (str.equals("badgeValue")) {
                    b = 21;
                }
                break;
            case 1519110851:
                if (str.equals("tabBarItemBadgeBackgroundColor")) {
                    b = 22;
                }
                break;
            case 1577043198:
                if (str.equals("tabBarItemTestID")) {
                    b = 23;
                }
                break;
            case 1595935908:
                if (str.equals("tabBarItemBadgeTextColor")) {
                    b = 24;
                }
                break;
            case 2021932941:
                if (str.equals("selectedIconResourceName")) {
                    b = 25;
                }
                break;
            case 2109188258:
                if (str.equals("imageIconResource")) {
                    b = 26;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setBottomScrollEdgeEffect(view, (String) obj);
                break;
            case 1:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTopScrollEdgeEffect(view, (String) obj);
                break;
            case 2:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setUserInterfaceStyle(view, (String) obj);
                break;
            case 3:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setLeftScrollEdgeEffect(view, (String) obj);
                break;
            case 4:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setSpecialEffects(view, (ReadableMap) obj);
                break;
            case 5:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setRightScrollEdgeEffect(view, (String) obj);
                break;
            case 6:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setIconResourceName(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setOrientation(view, (String) obj);
                break;
            case 8:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setIsFocused(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setOverrideScrollViewContentInsetAdjustmentBehavior(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setIsTitleUndefined(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTabKey(view, obj != null ? (String) obj : null);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setIconImageSource(view, (ReadableMap) obj);
                break;
            case 13:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setIconType(view, (String) obj);
                break;
            case 14:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTabBarItemAccessibilityLabel(view, obj != null ? (String) obj : null);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setScrollEdgeAppearance(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setDrawableIconResourceName(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setStandardAppearance(view, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTitle(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setSystemItem(view, (String) obj);
                break;
            case 20:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setSelectedIconImageSource(view, (ReadableMap) obj);
                break;
            case 21:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setBadgeValue(view, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTabBarItemBadgeBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 23:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTabBarItemTestID(view, obj != null ? (String) obj : null);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setTabBarItemBadgeTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setSelectedIconResourceName(view, obj != null ? (String) obj : null);
                break;
            case 26:
                ((RNSTabsScreenManagerInterface) this.mViewManager).setImageIconResource(view, (ReadableMap) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
