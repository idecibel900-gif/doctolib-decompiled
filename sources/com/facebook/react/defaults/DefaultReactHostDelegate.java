package com.facebook.react.defaults;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", "handleInstanceException", "(Ljava/lang/Exception;)V", "", "jsMainModulePath", "Ljava/lang/String;", "getJsMainModulePath", "()Ljava/lang/String;", "Lcom/facebook/react/bridge/JSBundleLoader;", "jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "", "Lcom/facebook/react/ReactPackage;", "reactPackages", "Ljava/util/List;", "getReactPackages", "()Ljava/util/List;", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "getJsRuntimeFactory", "()Lcom/facebook/react/runtime/JSRuntimeFactory;", "Lcom/facebook/react/runtime/BindingsInstaller;", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "Lkotlin/Function1;", "exceptionHandler", "Lkotlin/jvm/functions/Function1;", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReactHostDelegate implements ReactHostDelegate {
    private final BindingsInstaller bindingsInstaller;
    private final Function1 exceptionHandler;
    private final JSBundleLoader jsBundleLoader;
    private final String jsMainModulePath;
    private final JSRuntimeFactory jsRuntimeFactory;
    private final List reactPackages;
    private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public String getJsMainModulePath() {
        return this.jsMainModulePath;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public JSBundleLoader getJsBundleLoader() {
        return this.jsBundleLoader;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public List getReactPackages() {
        return this.reactPackages;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public JSRuntimeFactory getJsRuntimeFactory() {
        return this.jsRuntimeFactory;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public BindingsInstaller getBindingsInstaller() {
        return this.bindingsInstaller;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
        return this.turboModuleManagerDelegateBuilder;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public void handleInstanceException(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.exceptionHandler.invoke(error);
    }
}
