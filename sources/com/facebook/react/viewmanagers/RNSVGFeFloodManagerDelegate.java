package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeFloodManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFeFloodManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "floodColor":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setFloodColor(view, new DynamicFromObject(obj));
                break;
            case "height":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case "floodOpacity":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setFloodOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case "result":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setResult(view, obj == null ? null : (String) obj);
                break;
            case "x":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case "width":
                ((RNSVGFeFloodManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
