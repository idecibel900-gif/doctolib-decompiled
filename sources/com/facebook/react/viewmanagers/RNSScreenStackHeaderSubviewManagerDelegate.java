package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSScreenStackHeaderSubviewManagerDelegate extends BaseViewManagerDelegate {
    public RNSScreenStackHeaderSubviewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "synchronousShadowStateUpdatesEnabled":
                ((RNSScreenStackHeaderSubviewManagerInterface) this.mViewManager).setSynchronousShadowStateUpdatesEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "type":
                ((RNSScreenStackHeaderSubviewManagerInterface) this.mViewManager).setType(view, (String) obj);
                break;
            case "hidesSharedBackground":
                ((RNSScreenStackHeaderSubviewManagerInterface) this.mViewManager).setHidesSharedBackground(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
