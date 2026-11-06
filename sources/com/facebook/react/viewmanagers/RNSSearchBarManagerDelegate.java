package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class RNSSearchBarManagerDelegate extends BaseViewManagerDelegate {
    public RNSSearchBarManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1619312835:
                if (str.equals("hideNavigationBar")) {
                    b = 0;
                }
                break;
            case -1465798051:
                if (str.equals("headerIconColor")) {
                    b = 1;
                }
                break;
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    b = 2;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 3;
                }
                break;
            case -336520619:
                if (str.equals("barTintColor")) {
                    b = 4;
                }
                break;
            case -256845969:
                if (str.equals("hintTextColor")) {
                    b = 5;
                }
                break;
            case -186579527:
                if (str.equals("hideWhenScrolling")) {
                    b = 6;
                }
                break;
            case -146361959:
                if (str.equals("cancelButtonText")) {
                    b = 7;
                }
                break;
            case -109380883:
                if (str.equals("disableBackButtonOverride")) {
                    b = 8;
                }
                break;
            case -39414888:
                if (str.equals("shouldShowHintSearchIcon")) {
                    b = 9;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    b = 10;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    b = 11;
                }
                break;
            case 1399891586:
                if (str.equals("allowToolbarIntegration")) {
                    b = 12;
                }
                break;
            case 1584806451:
                if (str.equals("obscureBackground")) {
                    b = 13;
                }
                break;
            case 1638055017:
                if (str.equals("autoFocus")) {
                    b = 14;
                }
                break;
            case 1706976804:
                if (str.equals("inputType")) {
                    b = 15;
                }
                break;
            case 1792938725:
                if (str.equals("placement")) {
                    b = 16;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideNavigationBar(view, (String) obj);
                break;
            case 1:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHeaderIconColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 2:
                ((RNSSearchBarManagerInterface) this.mViewManager).setAutoCapitalize(view, (String) obj);
                break;
            case 3:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((RNSSearchBarManagerInterface) this.mViewManager).setBarTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 5:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHintTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSSearchBarManagerInterface) this.mViewManager).setHideWhenScrolling(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 7:
                ((RNSSearchBarManagerInterface) this.mViewManager).setCancelButtonText(view, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSSearchBarManagerInterface) this.mViewManager).setDisableBackButtonOverride(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSSearchBarManagerInterface) this.mViewManager).setShouldShowHintSearchIcon(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 10:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlaceholder(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSSearchBarManagerInterface) this.mViewManager).setTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((RNSSearchBarManagerInterface) this.mViewManager).setAllowToolbarIntegration(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 13:
                ((RNSSearchBarManagerInterface) this.mViewManager).setObscureBackground(view, (String) obj);
                break;
            case 14:
                ((RNSSearchBarManagerInterface) this.mViewManager).setAutoFocus(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((RNSSearchBarManagerInterface) this.mViewManager).setInputType(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSSearchBarManagerInterface) this.mViewManager).setPlacement(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        switch (str) {
            case "cancelSearch":
                ((RNSSearchBarManagerInterface) this.mViewManager).cancelSearch(view);
                break;
            case "clearText":
                ((RNSSearchBarManagerInterface) this.mViewManager).clearText(view);
                break;
            case "toggleCancelButton":
                ((RNSSearchBarManagerInterface) this.mViewManager).toggleCancelButton(view, readableArray.getBoolean(0));
                break;
            case "blur":
                ((RNSSearchBarManagerInterface) this.mViewManager).blur(view);
                break;
            case "focus":
                ((RNSSearchBarManagerInterface) this.mViewManager).focus(view);
                break;
            case "setText":
                ((RNSSearchBarManagerInterface) this.mViewManager).setText(view, readableArray.getString(0));
                break;
        }
    }
}
