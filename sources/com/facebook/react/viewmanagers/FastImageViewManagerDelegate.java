package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageViewManagerDelegate extends BaseViewManagerDelegate {
    public FastImageViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "transition":
                ((FastImageViewManagerInterface) this.mViewManager).setTransition(view, (String) obj);
                break;
            case "blurRadius":
                ((FastImageViewManagerInterface) this.mViewManager).setBlurRadius(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "source":
                ((FastImageViewManagerInterface) this.mViewManager).setSource(view, (ReadableMap) obj);
                break;
            case "defaultSource":
                ((FastImageViewManagerInterface) this.mViewManager).setDefaultSource(view, obj == null ? null : (String) obj);
                break;
            case "tintColor":
                ((FastImageViewManagerInterface) this.mViewManager).setTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "resizeMode":
                ((FastImageViewManagerInterface) this.mViewManager).setResizeMode(view, (String) obj);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
