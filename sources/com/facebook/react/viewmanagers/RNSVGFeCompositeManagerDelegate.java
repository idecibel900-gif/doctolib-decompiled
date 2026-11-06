package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeCompositeManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFeCompositeManagerDelegate(BaseViewManager baseViewManager) {
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
            case 3366:
                if (str.equals("k1")) {
                    b = 4;
                }
                break;
            case 3367:
                if (str.equals("k2")) {
                    b = 5;
                }
                break;
            case 3368:
                if (str.equals("k3")) {
                    b = 6;
                }
                break;
            case 3369:
                if (str.equals("k4")) {
                    b = 7;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    b = 8;
                }
                break;
            case 104365:
                if (str.equals("in2")) {
                    b = 9;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    b = 10;
                }
                break;
            case 1662708749:
                if (str.equals("operator1")) {
                    b = 11;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setResult(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 4:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setK1(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 5:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setK2(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 6:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setK3(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 7:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setK4(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 8:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setIn1(view, obj != null ? (String) obj : null);
                break;
            case 9:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setIn2(view, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((RNSVGFeCompositeManagerInterface) this.mViewManager).setOperator1(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
