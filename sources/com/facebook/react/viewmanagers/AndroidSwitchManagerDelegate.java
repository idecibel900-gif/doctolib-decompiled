package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidSwitchManagerDelegate extends BaseViewManagerDelegate {
    public AndroidSwitchManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "thumbColor":
                ((AndroidSwitchManagerInterface) this.mViewManager).setThumbColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "enabled":
                ((AndroidSwitchManagerInterface) this.mViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "trackTintColor":
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "on":
                ((AndroidSwitchManagerInterface) this.mViewManager).setOn(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "value":
                ((AndroidSwitchManagerInterface) this.mViewManager).setValue(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "disabled":
                ((AndroidSwitchManagerInterface) this.mViewManager).setDisabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "trackColorForFalse":
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackColorForFalse(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "thumbTintColor":
                ((AndroidSwitchManagerInterface) this.mViewManager).setThumbTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "trackColorForTrue":
                ((AndroidSwitchManagerInterface) this.mViewManager).setTrackColorForTrue(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        if (str.equals("setNativeValue")) {
            ((AndroidSwitchManagerInterface) this.mViewManager).setNativeValue(view, readableArray.getBoolean(0));
        }
    }
}
