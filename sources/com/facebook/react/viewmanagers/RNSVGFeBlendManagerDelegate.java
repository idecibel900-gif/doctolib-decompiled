package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeBlendManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFeBlendManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1221029593:
                if (str.equals("height")) {
                    b = 0;
                }
                break;
            case -934426595:
                if (str.equals("result")) {
                    b = 1;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    b = 2;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    b = 3;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    b = 4;
                }
                break;
            case 104365:
                if (str.equals("in2")) {
                    b = 5;
                }
                break;
            case 3357091:
                if (str.equals("mode")) {
                    b = 6;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 7;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setResult(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn1(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setIn2(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setMode(view, (String) obj);
                break;
            case 7:
                ((RNSVGFeBlendManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
