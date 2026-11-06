package com.margelo.nitro;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeNitroModulesSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NitroModules";

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String install();

    public NativeNitroModulesSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "NitroModules";
    }
}
