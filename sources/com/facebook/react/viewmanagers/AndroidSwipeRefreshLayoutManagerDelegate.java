package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidSwipeRefreshLayoutManagerDelegate extends BaseViewManagerDelegate {
    public AndroidSwipeRefreshLayoutManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "enabled":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "colors":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setColors(view, (ReadableArray) obj);
                break;
            case "progressBackgroundColor":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setProgressBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "progressViewOffset":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setProgressViewOffset(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "refreshing":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setRefreshing(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "size":
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setSize(view, (String) obj);
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
        if (str.equals("setNativeRefreshing")) {
            ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setNativeRefreshing(view, readableArray.getBoolean(0));
        }
    }
}
