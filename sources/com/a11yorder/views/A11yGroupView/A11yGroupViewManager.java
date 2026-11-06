package com.a11yorder.views.A11yGroupView;

import android.view.View;
import android.view.ViewGroup;
import com.a11yorder.A11yGroupViewManagerSpec;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class A11yGroupViewManager extends A11yGroupViewManagerSpec<ViewGroup> {
    public static final String REACT_CLASS = "A11yGroupView";

    @Override // com.a11yorder.A11yGroupViewManagerSpec, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewGroup(themedReactContext);
    }
}
