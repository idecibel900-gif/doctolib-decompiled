package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFilterManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFilterManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "primitiveUnits":
                ((RNSVGFilterManagerInterface) this.mViewManager).setPrimitiveUnits(view, (String) obj);
                break;
            case "height":
                ((RNSVGFilterManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case "filterUnits":
                ((RNSVGFilterManagerInterface) this.mViewManager).setFilterUnits(view, (String) obj);
                break;
            case "x":
                ((RNSVGFilterManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFilterManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case "name":
                ((RNSVGFilterManagerInterface) this.mViewManager).setName(view, obj == null ? null : (String) obj);
                break;
            case "width":
                ((RNSVGFilterManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
