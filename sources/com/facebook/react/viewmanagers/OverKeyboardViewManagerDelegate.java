package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class OverKeyboardViewManagerDelegate extends BaseViewManagerDelegate {
    public OverKeyboardViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("visible")) {
            ((OverKeyboardViewManagerInterface) this.mViewManager).setVisible(view, obj == null ? false : ((Boolean) obj).booleanValue());
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
