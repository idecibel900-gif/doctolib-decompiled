package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNGestureHandlerRootViewManagerDelegate extends BaseViewManagerDelegate {
    public RNGestureHandlerRootViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("unstable_forceActive")) {
            ((RNGestureHandlerRootViewManagerInterface) this.mViewManager).setUnstable_forceActive(view, obj == null ? false : ((Boolean) obj).booleanValue());
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
