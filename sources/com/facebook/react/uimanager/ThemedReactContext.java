package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThemedReactContext extends ReactContext {
    private final String moduleName;
    private final ReactApplicationContext reactApplicationContext;
    private final int surfaceId;

    public final ReactApplicationContext getReactApplicationContext() {
        return this.reactApplicationContext;
    }

    public final int getSurfaceId() {
        return this.surfaceId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context base, String str, int i) {
        super(base);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(base, "base");
        this.reactApplicationContext = reactApplicationContext;
        this.moduleName = str;
        this.surfaceId = i;
        initializeFromOther(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void addLifecycleEventListener(LifecycleEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.reactApplicationContext.addLifecycleEventListener(listener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void removeLifecycleEventListener(LifecycleEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.reactApplicationContext.removeLifecycleEventListener(listener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCurrentActivity() {
        return this.reactApplicationContext.hasCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Activity getCurrentActivity() {
        return this.reactApplicationContext.getCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public JavaScriptModule getJSModule(Class jsInterface) {
        Intrinsics.checkNotNullParameter(jsInterface, "jsInterface");
        JavaScriptModule jSModule = this.reactApplicationContext.getJSModule(jsInterface);
        Intrinsics.checkNotNullExpressionValue(jSModule, "getJSModule(...)");
        return jSModule;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasNativeModule(Class nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        return this.reactApplicationContext.hasNativeModule(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Collection getNativeModules() {
        return this.reactApplicationContext.getNativeModules();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(Class nativeModuleInterface) {
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        return this.reactApplicationContext.getNativeModule(nativeModuleInterface);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public NativeModule getNativeModule(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return this.reactApplicationContext.getNativeModule(moduleName);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CatalystInstance getCatalystInstance() {
        return this.reactApplicationContext.getCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveCatalystInstance() {
        return this.reactApplicationContext.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasActiveReactInstance() {
        return this.reactApplicationContext.hasActiveCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCatalystInstance() {
        return this.reactApplicationContext.hasCatalystInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasReactInstance() {
        return this.reactApplicationContext.hasReactInstance();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void destroy() {
        this.reactApplicationContext.destroy();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void handleException(Exception exc) {
        this.reactApplicationContext.handleException(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean isBridgeless() {
        return this.reactApplicationContext.isBridgeless();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.reactApplicationContext.getJavaScriptContextHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.reactApplicationContext.getJSCallInvokerHolder();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public UIManager getFabricUIManager() {
        return this.reactApplicationContext.getFabricUIManager();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public String getSourceURL() {
        return this.reactApplicationContext.getSourceURL();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void registerSegment(int i, String str, Callback callback) {
        this.reactApplicationContext.registerSegment(i, str, callback);
    }
}
