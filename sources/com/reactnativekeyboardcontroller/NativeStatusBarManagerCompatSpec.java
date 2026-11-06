package com.reactnativekeyboardcontroller;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeStatusBarManagerCompatSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "StatusBarManagerCompat";

    @DoNotStrip
    @ReactMethod
    public abstract void setColor(double d, boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void setHidden(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void setStyle(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setTranslucent(boolean z);

    public NativeStatusBarManagerCompatSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
