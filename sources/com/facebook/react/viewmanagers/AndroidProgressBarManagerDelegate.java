package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidProgressBarManagerDelegate extends BaseViewManagerDelegate {
    public AndroidProgressBarManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1001078227:
                if (str.equals(ReactProgressBarViewManager.PROP_PROGRESS)) {
                    b = 0;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    b = 1;
                }
                break;
            case -676876213:
                if (str.equals(ReactProgressBarViewManager.PROP_ATTR)) {
                    b = 2;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 3;
                }
                break;
            case 633138363:
                if (str.equals(ReactProgressBarViewManager.PROP_INDETERMINATE)) {
                    b = 4;
                }
                break;
            case 1118509918:
                if (str.equals(ReactProgressBarViewManager.PROP_ANIMATING)) {
                    b = 5;
                }
                break;
            case 1804741442:
                if (str.equals(ReactProgressBarViewManager.PROP_STYLE)) {
                    b = 6;
                }
                break;
        }
        switch (b) {
            case 0:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setProgress(view, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case 1:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setTestID(view, obj == null ? "" : (String) obj);
                break;
            case 2:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setTypeAttr(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setIndeterminate(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setAnimating(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 6:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setStyleAttr(view, obj != null ? (String) obj : null);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
