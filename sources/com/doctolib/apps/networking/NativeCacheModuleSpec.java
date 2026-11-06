package com.doctolib.apps.networking;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeCacheModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "CacheModule";

    @DoNotStrip
    @ReactMethod
    public abstract void clear();

    public NativeCacheModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CacheModule";
    }
}
