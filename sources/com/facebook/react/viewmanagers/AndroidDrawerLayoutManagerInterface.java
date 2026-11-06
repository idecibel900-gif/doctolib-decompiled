package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface AndroidDrawerLayoutManagerInterface extends ViewManagerWithGeneratedInterface {
    void closeDrawer(View view);

    void openDrawer(View view);

    void setDrawerBackgroundColor(View view, Integer num);

    void setDrawerLockMode(View view, String str);

    void setDrawerPosition(View view, String str);

    void setDrawerWidth(View view, Float f);

    void setKeyboardDismissMode(View view, String str);

    void setStatusBarBackgroundColor(View view, Integer num);
}
