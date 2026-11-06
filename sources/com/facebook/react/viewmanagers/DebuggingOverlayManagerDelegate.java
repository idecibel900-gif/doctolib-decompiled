package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class DebuggingOverlayManagerDelegate extends BaseViewManagerDelegate {
    public DebuggingOverlayManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        super.setProperty(view, str, obj);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        switch (str) {
            case "clearElementsHighlights":
                ((DebuggingOverlayManagerInterface) this.mViewManager).clearElementsHighlights(view);
                break;
            case "highlightTraceUpdates":
                ((DebuggingOverlayManagerInterface) this.mViewManager).highlightTraceUpdates(view, readableArray.getArray(0));
                break;
            case "highlightElements":
                ((DebuggingOverlayManagerInterface) this.mViewManager).highlightElements(view, readableArray.getArray(0));
                break;
        }
    }
}
