package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class KeyboardGestureAreaManagerDelegate extends BaseViewManagerDelegate {
    public KeyboardGestureAreaManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "showOnSwipeUp":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setShowOnSwipeUp(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "offset":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setOffset(view, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case "textInputNativeID":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setTextInputNativeID(view, obj == null ? null : (String) obj);
                break;
            case "enableSwipeToDismiss":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setEnableSwipeToDismiss(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "interpolator":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setInterpolator(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
