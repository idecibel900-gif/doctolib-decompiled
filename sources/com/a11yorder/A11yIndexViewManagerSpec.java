package com.a11yorder;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class A11yIndexViewManagerSpec<T extends ReactViewGroup> extends ReactViewManager implements ViewManagerWithGeneratedInterface {
    public abstract /* synthetic */ void focus(View view);

    public abstract /* synthetic */ void setOrderIndex(View view, int i);

    public abstract /* synthetic */ void setOrderKey(View view, String str);
}
