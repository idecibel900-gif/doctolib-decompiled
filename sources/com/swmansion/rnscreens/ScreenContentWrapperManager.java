package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.viewmanagers.RNSScreenContentWrapperManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = ScreenContentWrapperManager.REACT_CLASS)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/ScreenContentWrapperManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenContentWrapper;", "", "<init>", "()V", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "reactContext", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/swmansion/rnscreens/ScreenContentWrapper;", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "()Lcom/facebook/react/uimanager/ViewManagerDelegate;", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenContentWrapperManager extends ViewGroupManager<ScreenContentWrapper> implements ViewManagerWithGeneratedInterface {
    public static final String REACT_CLASS = "RNSScreenContentWrapper";
    private final ViewManagerDelegate delegate;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    public ScreenContentWrapperManager() {
        super(null, 1, null);
        this.delegate = new RNSScreenContentWrapperManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenContentWrapper createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenContentWrapper(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }
}
