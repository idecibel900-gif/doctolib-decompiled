package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSScreenStackManagerDelegate extends BaseViewManagerDelegate {
    public RNSScreenStackManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("iosPreventReattachmentOfDismissedScreens")) {
            ((RNSScreenStackManagerInterface) this.mViewManager).setIosPreventReattachmentOfDismissedScreens(view, obj == null ? true : ((Boolean) obj).booleanValue());
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
