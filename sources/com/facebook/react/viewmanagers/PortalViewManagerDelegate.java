package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class PortalViewManagerDelegate extends BaseViewManagerDelegate {
    public PortalViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("hostName")) {
            ((PortalViewManagerInterface) this.mViewManager).setHostName(view, obj != null ? (String) obj : null);
        } else if (str.equals("name")) {
            ((PortalViewManagerInterface) this.mViewManager).setName(view, obj != null ? (String) obj : null);
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
