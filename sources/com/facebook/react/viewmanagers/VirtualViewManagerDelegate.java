package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class VirtualViewManagerDelegate extends BaseViewManagerDelegate {
    public VirtualViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "renderState":
                ((VirtualViewManagerInterface) this.mViewManager).setRenderState(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "initialHidden":
                ((VirtualViewManagerInterface) this.mViewManager).setInitialHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "removeClippedSubviews":
                ((VirtualViewManagerInterface) this.mViewManager).setRemoveClippedSubviews(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
