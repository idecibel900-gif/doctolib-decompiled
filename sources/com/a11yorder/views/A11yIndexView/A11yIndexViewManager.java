package com.a11yorder.views.A11yIndexView;

import android.view.View;
import android.view.ViewGroup;
import com.a11yorder.A11yIndexViewManagerSpec;
import com.a11yorder.services.FocusUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = A11yIndexViewManager.NAME)
public class A11yIndexViewManager extends A11yIndexViewManagerSpec<A11yIndexView> {
    public static final String NAME = "A11yIndexView";

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public A11yIndexView createViewInstance(ThemedReactContext themedReactContext) {
        final A11yIndexView a11yIndexView = new A11yIndexView(themedReactContext);
        a11yIndexView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.a11yorder.views.A11yIndexView.A11yIndexViewManager.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                a11yIndexView.linkAddView(view2);
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                a11yIndexView.linkRemoveView(view2);
            }
        });
        return a11yIndexView;
    }

    @Override // com.a11yorder.A11yIndexViewManagerSpec
    @ReactProp(name = "orderIndex")
    public void setOrderIndex(A11yIndexView a11yIndexView, int i) {
        a11yIndexView.setIndex(i);
    }

    @Override // com.a11yorder.A11yIndexViewManagerSpec
    @ReactProp(name = "orderKey")
    public void setOrderKey(A11yIndexView a11yIndexView, String str) {
        a11yIndexView.setOrderKey(str);
    }

    @Override // com.a11yorder.A11yIndexViewManagerSpec
    public void focus(A11yIndexView a11yIndexView) {
        focus(a11yIndexView);
    }

    private <T extends ReactViewGroup> void focus(T t) {
        FocusUtil.focus(t);
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactViewGroup reactViewGroup, String str, ReadableArray readableArray) {
        if (str.equals("focus")) {
            focus(reactViewGroup);
        } else {
            super.receiveCommand(reactViewGroup, str, readableArray);
        }
    }
}
