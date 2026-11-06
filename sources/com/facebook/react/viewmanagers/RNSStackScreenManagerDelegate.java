package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSStackScreenManagerDelegate extends BaseViewManagerDelegate {
    public RNSStackScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "preventNativeDismiss":
                ((RNSStackScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "screenKey":
                ((RNSStackScreenManagerInterface) this.mViewManager).setScreenKey(view, obj == null ? null : (String) obj);
                break;
            case "activityMode":
                ((RNSStackScreenManagerInterface) this.mViewManager).setActivityMode(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
