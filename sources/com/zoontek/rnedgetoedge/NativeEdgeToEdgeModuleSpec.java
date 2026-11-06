package com.zoontek.rnedgetoedge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeEdgeToEdgeModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNEdgeToEdge";

    @DoNotStrip
    @ReactMethod
    public abstract void onColorSchemeChange();

    @DoNotStrip
    @ReactMethod
    public abstract void setNavigationBarHidden(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void setNavigationBarStyle(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setStatusBarHidden(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void setStatusBarStyle(String str);

    public NativeEdgeToEdgeModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
