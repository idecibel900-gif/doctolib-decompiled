package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class KeyboardControllerViewManagerDelegate extends BaseViewManagerDelegate {
    public KeyboardControllerViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "enabled":
                ((KeyboardControllerViewManagerInterface) this.mViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "statusBarTranslucent":
                ((KeyboardControllerViewManagerInterface) this.mViewManager).setStatusBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "preserveEdgeToEdge":
                ((KeyboardControllerViewManagerInterface) this.mViewManager).setPreserveEdgeToEdge(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "navigationBarTranslucent":
                ((KeyboardControllerViewManagerInterface) this.mViewManager).setNavigationBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        if (str.equals("synchronizeFocusedInputLayout")) {
            ((KeyboardControllerViewManagerInterface) this.mViewManager).synchronizeFocusedInputLayout(view);
        }
    }
}
