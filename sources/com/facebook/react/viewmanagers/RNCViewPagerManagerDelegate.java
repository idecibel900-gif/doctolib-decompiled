package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNCViewPagerManagerDelegate extends BaseViewManagerDelegate {
    public RNCViewPagerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "layoutDirection":
                ((RNCViewPagerManagerInterface) this.mViewManager).setLayoutDirection(view, (String) obj);
                break;
            case "offscreenPageLimit":
                ((RNCViewPagerManagerInterface) this.mViewManager).setOffscreenPageLimit(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "orientation":
                ((RNCViewPagerManagerInterface) this.mViewManager).setOrientation(view, (String) obj);
                break;
            case "overScrollMode":
                ((RNCViewPagerManagerInterface) this.mViewManager).setOverScrollMode(view, (String) obj);
                break;
            case "scrollEnabled":
                ((RNCViewPagerManagerInterface) this.mViewManager).setScrollEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "keyboardDismissMode":
                ((RNCViewPagerManagerInterface) this.mViewManager).setKeyboardDismissMode(view, (String) obj);
                break;
            case "overdrag":
                ((RNCViewPagerManagerInterface) this.mViewManager).setOverdrag(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "pageMargin":
                ((RNCViewPagerManagerInterface) this.mViewManager).setPageMargin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "initialPage":
                ((RNCViewPagerManagerInterface) this.mViewManager).setInitialPage(view, obj != null ? ((Double) obj).intValue() : 0);
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
        switch (str) {
            case "setPageWithoutAnimation":
                ((RNCViewPagerManagerInterface) this.mViewManager).setPageWithoutAnimation(view, readableArray.getInt(0));
                break;
            case "setScrollEnabledImperatively":
                ((RNCViewPagerManagerInterface) this.mViewManager).setScrollEnabledImperatively(view, readableArray.getBoolean(0));
                break;
            case "setPage":
                ((RNCViewPagerManagerInterface) this.mViewManager).setPage(view, readableArray.getInt(0));
                break;
        }
    }
}
