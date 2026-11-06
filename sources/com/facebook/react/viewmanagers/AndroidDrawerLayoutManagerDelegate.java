package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidDrawerLayoutManagerDelegate extends BaseViewManagerDelegate {
    public AndroidDrawerLayoutManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "statusBarBackgroundColor":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setStatusBarBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "drawerBackgroundColor":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "keyboardDismissMode":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setKeyboardDismissMode(view, (String) obj);
                break;
            case "drawerWidth":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerWidth(view, obj == null ? null : Float.valueOf(((Double) obj).floatValue()));
                break;
            case "drawerPosition":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerPosition(view, (String) obj);
                break;
            case "drawerLockMode":
                ((AndroidDrawerLayoutManagerInterface) this.mViewManager).setDrawerLockMode(view, (String) obj);
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
        if (str.equals(ReactDrawerLayoutManager.COMMAND_CLOSE_DRAWER)) {
            ((AndroidDrawerLayoutManagerInterface) this.mViewManager).closeDrawer(view);
        } else if (str.equals(ReactDrawerLayoutManager.COMMAND_OPEN_DRAWER)) {
            ((AndroidDrawerLayoutManagerInterface) this.mViewManager).openDrawer(view);
        }
    }
}
