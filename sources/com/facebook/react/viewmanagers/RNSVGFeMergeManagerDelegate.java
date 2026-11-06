package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNSVGFeMergeManagerDelegate extends BaseViewManagerDelegate {
    public RNSVGFeMergeManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "height":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case "result":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setResult(view, obj == null ? null : (String) obj);
                break;
            case "x":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case "y":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case "nodes":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setNodes(view, (ReadableArray) obj);
                break;
            case "width":
                ((RNSVGFeMergeManagerInterface) this.mViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
