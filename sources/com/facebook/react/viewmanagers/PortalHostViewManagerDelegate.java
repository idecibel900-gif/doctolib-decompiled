package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class PortalHostViewManagerDelegate extends BaseViewManagerDelegate {
    public PortalHostViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("name")) {
            ((PortalHostViewManagerInterface) this.mViewManager).setName(view, obj == null ? null : (String) obj);
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
