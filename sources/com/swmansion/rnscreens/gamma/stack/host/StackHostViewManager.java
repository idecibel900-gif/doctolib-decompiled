package com.swmansion.rnscreens.gamma.stack.host;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;
import com.facebook.react.viewmanagers.RNSStackHostManagerDelegate;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = StackHostViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/StackHostViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "", "<init>", "()V", "", "getName", "()Ljava/lang/String;", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "()Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Lcom/facebook/react/uimanager/ThemedReactContext;", "reactContext", "createViewInstance", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "parent", "Landroid/view/View;", "child", "", "index", "", "addView", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;Landroid/view/View;I)V", "view", "removeView", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;Landroid/view/View;)V", "removeViewAt", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;I)V", "removeAllViews", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;)V", "getChildAt", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;I)Landroid/view/View;", "getChildCount", "(Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;)I", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHostViewManager extends ViewGroupManager<StackHost> implements ViewManagerWithGeneratedInterface {
    public static final String REACT_CLASS = "RNSStackHost";
    private final ViewManagerDelegate delegate;

    public StackHostViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackHostManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackHost createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackHost(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(StackHost parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof StackScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass");
        }
        parent.mountReactSubviewAt$react_native_screens_release((StackScreen) child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(StackHost parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof StackScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass");
        }
        parent.unmountReactSubview$react_native_screens_release((StackScreen) view);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(StackHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountReactSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(StackHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountAllReactSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(StackHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return (View) CollectionsKt.getOrNull(parent.getRenderedScreens$react_native_screens_release(), index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(StackHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getRenderedScreens$react_native_screens_release().size();
    }
}
