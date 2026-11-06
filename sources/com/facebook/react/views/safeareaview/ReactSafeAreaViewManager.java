package com.facebook.react.views.safeareaview;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.viewmanagers.SafeAreaViewManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ReactSafeAreaViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/facebook/react/views/safeareaview/ReactSafeAreaViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/facebook/react/views/safeareaview/ReactSafeAreaView;", "", "<init>", "()V", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "()Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "context", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/facebook/react/views/safeareaview/ReactSafeAreaView;", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "createShadowNodeInstance", "()Lcom/facebook/react/uimanager/LayoutShadowNode;", "Ljava/lang/Class;", "getShadowNodeClass", "()Ljava/lang/Class;", "view", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "props", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "updateState", "(Lcom/facebook/react/views/safeareaview/ReactSafeAreaView;Lcom/facebook/react/uimanager/ReactStylesDiffMap;Lcom/facebook/react/uimanager/StateWrapper;)Ljava/lang/Object;", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactSafeAreaViewManager extends ViewGroupManager<ReactSafeAreaView> implements ViewManagerWithGeneratedInterface {
    public static final String REACT_CLASS = "RCTSafeAreaView";
    private final ViewManagerDelegate delegate;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        super.removeAllViews(view);
    }

    public ReactSafeAreaViewManager() {
        super(null, 1, null);
        this.delegate = new SafeAreaViewManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSafeAreaView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactSafeAreaView(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new LayoutShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactSafeAreaView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        view.setStateWrapper$ReactAndroid_release(stateWrapper);
        return null;
    }
}
