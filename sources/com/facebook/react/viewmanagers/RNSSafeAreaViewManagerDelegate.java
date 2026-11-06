package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSSafeAreaViewManagerDelegate extends BaseViewManagerDelegate {
    public RNSSafeAreaViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        if (str.equals("insetType")) {
            ((RNSSafeAreaViewManagerInterface) this.mViewManager).setInsetType(view, (String) obj);
        } else if (str.equals("edges")) {
            ((RNSSafeAreaViewManagerInterface) this.mViewManager).setEdges(view, (ReadableMap) obj);
        } else {
            super.setProperty(view, str, obj);
        }
    }
}
