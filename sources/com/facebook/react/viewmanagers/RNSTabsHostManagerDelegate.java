package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSTabsHostManagerDelegate extends BaseViewManagerDelegate {
    public RNSTabsHostManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1873119606:
                if (str.equals("tabBarTintColor")) {
                    b = 0;
                }
                break;
            case -1716883528:
                if (str.equals("tabBarItemLabelVisibilityMode")) {
                    b = 1;
                }
                break;
            case -1583805635:
                if (str.equals("tabBarControllerMode")) {
                    b = 2;
                }
                break;
            case -1167805191:
                if (str.equals("tabBarItemIconColor")) {
                    b = 3;
                }
                break;
            case -1140765365:
                if (str.equals("tabBarItemActiveIndicatorColor")) {
                    b = 4;
                }
                break;
            case -727132909:
                if (str.equals("tabBarItemTitleFontColorActive")) {
                    b = 5;
                }
                break;
            case -149697865:
                if (str.equals("tabBarBackgroundColor")) {
                    b = 6;
                }
                break;
            case -141083017:
                if (str.equals("tabBarItemTitleFontSize")) {
                    b = 7;
                }
                break;
            case -93216851:
                if (str.equals("tabBarItemTitleFontColor")) {
                    b = 8;
                }
                break;
            case -78279173:
                if (str.equals("tabBarItemTitleFontStyle")) {
                    b = 9;
                }
                break;
            case 144476014:
                if (str.equals("tabBarMinimizeBehavior")) {
                    b = 10;
                }
                break;
            case 278168456:
                if (str.equals("tabBarHidden")) {
                    b = 11;
                }
                break;
            case 595595083:
                if (str.equals("nativeContainerBackgroundColor")) {
                    b = 12;
                }
                break;
            case 676974377:
                if (str.equals("tabBarItemActiveIndicatorEnabled")) {
                    b = 13;
                }
                break;
            case 697418079:
                if (str.equals("tabBarItemIconColorActive")) {
                    b = 14;
                }
                break;
            case 1458977038:
                if (str.equals("controlNavigationStateInJS")) {
                    b = 15;
                }
                break;
            case 1478227034:
                if (str.equals("tabBarItemTitleFontFamily")) {
                    b = 16;
                }
                break;
            case 1935822306:
                if (str.equals("tabBarItemRippleColor")) {
                    b = 17;
                }
                break;
            case 1968495470:
                if (str.equals("tabBarItemTitleFontWeight")) {
                    b = 18;
                }
                break;
            case 2018161757:
                if (str.equals("tabBarItemTitleFontSizeActive")) {
                    b = 19;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 1:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemLabelVisibilityMode(view, (String) obj);
                break;
            case 2:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarControllerMode(view, (String) obj);
                break;
            case 3:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemIconColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemActiveIndicatorColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 5:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontColorActive(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 7:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontSize(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 8:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 9:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontStyle(view, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarMinimizeBehavior(view, (String) obj);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSTabsHostManagerInterface) this.mViewManager).setNativeContainerBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 13:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemActiveIndicatorEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 14:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemIconColorActive(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSTabsHostManagerInterface) this.mViewManager).setControlNavigationStateInJS(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemRippleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSTabsHostManagerInterface) this.mViewManager).setTabBarItemTitleFontSizeActive(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
