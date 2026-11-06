package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class ModalHostViewManagerDelegate extends BaseViewManagerDelegate {
    public ModalHostViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "presentationStyle":
                ((ModalHostViewManagerInterface) this.mViewManager).setPresentationStyle(view, (String) obj);
                break;
            case "supportedOrientations":
                ((ModalHostViewManagerInterface) this.mViewManager).setSupportedOrientations(view, (ReadableArray) obj);
                break;
            case "transparent":
                ((ModalHostViewManagerInterface) this.mViewManager).setTransparent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "identifier":
                ((ModalHostViewManagerInterface) this.mViewManager).setIdentifier(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "statusBarTranslucent":
                ((ModalHostViewManagerInterface) this.mViewManager).setStatusBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "allowSwipeDismissal":
                ((ModalHostViewManagerInterface) this.mViewManager).setAllowSwipeDismissal(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "animated":
                ((ModalHostViewManagerInterface) this.mViewManager).setAnimated(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "visible":
                ((ModalHostViewManagerInterface) this.mViewManager).setVisible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "navigationBarTranslucent":
                ((ModalHostViewManagerInterface) this.mViewManager).setNavigationBarTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "hardwareAccelerated":
                ((ModalHostViewManagerInterface) this.mViewManager).setHardwareAccelerated(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "animationType":
                ((ModalHostViewManagerInterface) this.mViewManager).setAnimationType(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
