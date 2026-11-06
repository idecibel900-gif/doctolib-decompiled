package com.shake;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeShakeSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNShake";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void configure(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    public NativeShakeSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNShake";
    }
}
