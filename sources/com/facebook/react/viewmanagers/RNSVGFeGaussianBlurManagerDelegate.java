package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeGaussianBlurManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFeGaussianBlurManagerDelegate(BaseViewManager baseViewManager) {
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
            case 113126854:
                if (str.equals("width")) {
                    b = 5;
                }
                break;
            case 1530721536:
                if (str.equals("edgeMode")) {
                    b = 6;
                }
                break;
            case 1837475450:
                if (str.equals("stdDeviationX")) {
                    b = 7;
                }
                break;
            case 1837475451:
                if (str.equals("stdDeviationY")) {
                    b = 8;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setResult(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setIn1(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            case 6:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setEdgeMode(view, (String) obj);
                break;
            case 7:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setStdDeviationX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 8:
                ((RNSVGFeGaussianBlurManagerInterface) this.mViewManager).setStdDeviationY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
