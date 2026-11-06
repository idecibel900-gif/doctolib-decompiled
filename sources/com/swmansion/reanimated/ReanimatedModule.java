package com.swmansion.reanimated;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = NativeReanimatedModuleSpec.NAME)
public class ReanimatedModule extends NativeReanimatedModuleSpec implements LifecycleEventListener {
    private NodesManager mNodesManager;
    private boolean mTurboModuleInstalled;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mTurboModuleInstalled = false;
        reactApplicationContext.assertOnJSQueueThread();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnJSQueueThread();
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostPause();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostResume();
        }
    }

    public NodesManager getNodesManager() {
        return this.mNodesManager;
    }

    @Override // com.swmansion.reanimated.NativeReanimatedModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnJSQueueThread();
        NodesManager nodesManager = new NodesManager(reactApplicationContext);
        this.mNodesManager = nodesManager;
        nodesManager.getNativeProxy().installJSIBindings();
        return true;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.invalidate();
        }
        getReactApplicationContext().removeLifecycleEventListener(this);
    }
}
