package org.reactnative.maskedview;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes5.dex */
public class RNCMaskedViewManager extends ViewGroupManager<RNCMaskedView> {
    private static final String REACT_CLASS = "RNCMaskedView";

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RNCMaskedView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNCMaskedView(themedReactContext);
    }

    @ReactProp(name = "androidRenderingMode")
    public void setAndroidRenderingMode(RNCMaskedView rNCMaskedView, String str) {
        if (str != null) {
            rNCMaskedView.setRenderingMode(str);
        }
    }
}
