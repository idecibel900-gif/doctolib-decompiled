package com.facebook.react.runtime;

import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactHostDelegate {
    BindingsInstaller getBindingsInstaller();

    JSBundleLoader getJsBundleLoader();

    String getJsMainModulePath();

    JSRuntimeFactory getJsRuntimeFactory();

    List getReactPackages();

    ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder();

    void handleInstanceException(Exception exc);
}
