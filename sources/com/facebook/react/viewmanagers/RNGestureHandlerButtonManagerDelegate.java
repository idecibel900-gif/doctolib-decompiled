package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNGestureHandlerButtonManagerDelegate extends BaseViewManagerDelegate {
    public RNGestureHandlerButtonManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "rippleRadius":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setRippleRadius(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "rippleColor":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setRippleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "pointerEvents":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setPointerEvents(view, (String) obj);
                break;
            case "borderColor":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "borderStyle":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderStyle(view, obj == null ? "solid" : (String) obj);
                break;
            case "borderWidth":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderWidth(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "touchSoundDisabled":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setTouchSoundDisabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "exclusive":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setExclusive(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "borderless":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setBorderless(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "foreground":
                ((RNGestureHandlerButtonManagerInterface) this.mViewManager).setForeground(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
