package com.facebook.react.viewmanagers;

import android.view.View;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSScreenStackHeaderConfigManagerDelegate extends BaseViewManagerDelegate {
    public RNSScreenStackHeaderConfigManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -2035671681:
                if (str.equals("synchronousShadowStateUpdatesEnabled")) {
                    b = 0;
                }
                break;
            case -1829317469:
                if (str.equals("userInterfaceStyle")) {
                    b = 1;
                }
                break;
            case -1822687399:
                if (str.equals("translucent")) {
                    b = 2;
                }
                break;
            case -1799367701:
                if (str.equals("titleColor")) {
                    b = 3;
                }
                break;
            case -1795707688:
                if (str.equals("blurEffect")) {
                    b = 4;
                }
                break;
            case -1774658170:
                if (str.equals("largeTitleColor")) {
                    b = 5;
                }
                break;
            case -1715368693:
                if (str.equals("titleFontFamily")) {
                    b = 6;
                }
                break;
            case -1503810304:
                if (str.equals("disableBackButtonMenu")) {
                    b = 7;
                }
                break;
            case -1225100257:
                if (str.equals("titleFontWeight")) {
                    b = 8;
                }
                break;
            case -1217487446:
                if (str.equals("hidden")) {
                    b = 9;
                }
                break;
            case -1094575123:
                if (str.equals("largeTitleFontSize")) {
                    b = 10;
                }
                break;
            case -1093089076:
                if (str.equals("backButtonDisplayMode")) {
                    b = 11;
                }
                break;
            case -1063138943:
                if (str.equals("backTitleVisible")) {
                    b = 12;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 13;
                }
                break;
            case -389245640:
                if (str.equals("largeTitleBackgroundColor")) {
                    b = 14;
                }
                break;
            case -140063148:
                if (str.equals("backButtonInCustomView")) {
                    b = 15;
                }
                break;
            case 347216:
                if (str.equals("largeTitleFontFamily")) {
                    b = 16;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 17;
                }
                break;
            case 110371416:
                if (str.equals(b.S)) {
                    b = 18;
                }
                break;
            case 183888321:
                if (str.equals("backTitleFontSize")) {
                    b = 19;
                }
                break;
            case 243070244:
                if (str.equals("backTitleFontFamily")) {
                    b = 20;
                }
                break;
            case 339462402:
                if (str.equals("hideShadow")) {
                    b = 21;
                }
                break;
            case 490615652:
                if (str.equals("largeTitleFontWeight")) {
                    b = 22;
                }
                break;
            case 946001674:
                if (str.equals("headerRightBarButtonItems")) {
                    b = 23;
                }
                break;
            case 1038753243:
                if (str.equals("hideBackButton")) {
                    b = 24;
                }
                break;
            case 1249557231:
                if (str.equals("headerLeftBarButtonItems")) {
                    b = 25;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    b = 26;
                }
                break;
            case 1324688817:
                if (str.equals("backTitle")) {
                    b = 27;
                }
                break;
            case 1518161768:
                if (str.equals("titleFontSize")) {
                    b = 28;
                }
                break;
            case 1564506303:
                if (str.equals("largeTitleHideShadow")) {
                    b = 29;
                }
                break;
            case 2029798365:
                if (str.equals("largeTitle")) {
                    b = 30;
                }
                break;
            case 2099541337:
                if (str.equals("topInsetEnabled")) {
                    b = 31;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setSynchronousShadowStateUpdatesEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setUserInterfaceStyle(view, (String) obj);
                break;
            case 2:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTitleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBlurEffect(view, (String) obj);
                break;
            case 5:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setDisableBackButtonMenu(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTitleFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 10:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackButtonDisplayMode(view, (String) obj);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackTitleVisible(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 13:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setDirection(view, (String) obj);
                break;
            case 14:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackButtonInCustomView(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 16:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTitle(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setHideShadow(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 22:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 23:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setHeaderRightBarButtonItems(view, (ReadableArray) obj);
                break;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setHideBackButton(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setHeaderLeftBarButtonItems(view, (ReadableArray) obj);
                break;
            case 26:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 27:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setBackTitle(view, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitleHideShadow(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 30:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setLargeTitle(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                ((RNSScreenStackHeaderConfigManagerInterface) this.mViewManager).setTopInsetEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
