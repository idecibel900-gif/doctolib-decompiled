package com.revenuecat.purchases.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RNPurchasesPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public /* bridge */ /* synthetic */ NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return super.getModule(str, reactApplicationContext);
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNPurchasesModule(reactApplicationContext));
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }
}
