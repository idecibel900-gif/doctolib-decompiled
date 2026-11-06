package com.a11yorder.views.A11yOrderView;

import com.a11yorder.A11yOrderViewManagerSpec;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = A11yOrderViewManager.NAME)
public class A11yOrderViewManager extends A11yOrderViewManagerSpec<A11yOrderView> {
    public static final String NAME = "A11yOrderView";

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public A11yOrderView createViewInstance(ThemedReactContext themedReactContext) {
        return new A11yOrderView(themedReactContext);
    }

    @Override // com.a11yorder.A11yOrderViewManagerSpec
    public void setOrderKey(A11yOrderView a11yOrderView, String str) {
        a11yOrderView.setOrderKey(str);
    }
}
