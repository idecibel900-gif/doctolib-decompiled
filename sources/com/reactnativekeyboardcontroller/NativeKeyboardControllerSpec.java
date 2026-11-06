package com.reactnativekeyboardcontroller;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeKeyboardControllerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "KeyboardController";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void dismiss(boolean z, boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void preload();

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void setDefaultMode();

    @DoNotStrip
    @ReactMethod
    public abstract void setFocusTo(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setInputMode(double d);

    public NativeKeyboardControllerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
