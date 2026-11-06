package com.zoontek.rnedgetoedge;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = NativeEdgeToEdgeModuleSpec.NAME)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/zoontek/rnedgetoedge/EdgeToEdgeModule;", "Lcom/zoontek/rnedgetoedge/NativeEdgeToEdgeModuleSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "invalidate", "", "getName", "", "onHostResume", "onHostPause", "onHostDestroy", "onColorSchemeChange", "setStatusBarStyle", "style", "setNavigationBarStyle", "setStatusBarHidden", "hidden", "", "setNavigationBarHidden", "react-native-edge-to-edge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgeModule extends NativeEdgeToEdgeModuleSpec implements LifecycleEventListener {
    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EdgeToEdgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeEdgeToEdgeModuleSpec.NAME;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        EdgeToEdgeModuleImpl.INSTANCE.applyEdgeToEdge(getReactApplicationContext());
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec
    public void onColorSchemeChange() {
        EdgeToEdgeModuleImpl.INSTANCE.applyEdgeToEdge(getReactApplicationContext());
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec
    public void setStatusBarStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        EdgeToEdgeModuleImpl.INSTANCE.setStatusBarStyle(getReactApplicationContext(), style);
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec
    public void setNavigationBarStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        EdgeToEdgeModuleImpl.INSTANCE.setNavigationBarStyle(getReactApplicationContext(), style);
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec
    public void setStatusBarHidden(boolean hidden) {
        EdgeToEdgeModuleImpl.INSTANCE.setStatusBarHidden(getReactApplicationContext(), hidden);
    }

    @Override // com.zoontek.rnedgetoedge.NativeEdgeToEdgeModuleSpec
    public void setNavigationBarHidden(boolean hidden) {
        EdgeToEdgeModuleImpl.INSTANCE.setNavigationBarHidden(getReactApplicationContext(), hidden);
    }
}
