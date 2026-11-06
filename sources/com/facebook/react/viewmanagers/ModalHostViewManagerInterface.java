package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface ModalHostViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAllowSwipeDismissal(View view, boolean z);

    void setAnimated(View view, boolean z);

    void setAnimationType(View view, String str);

    void setHardwareAccelerated(View view, boolean z);

    void setIdentifier(View view, int i);

    void setNavigationBarTranslucent(View view, boolean z);

    void setPresentationStyle(View view, String str);

    void setStatusBarTranslucent(View view, boolean z);

    void setSupportedOrientations(View view, ReadableArray readableArray);

    void setTransparent(View view, boolean z);

    void setVisible(View view, boolean z);
}
