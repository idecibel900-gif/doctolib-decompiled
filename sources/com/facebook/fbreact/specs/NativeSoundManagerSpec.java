package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSoundManagerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "SoundManager";

    @DoNotStrip
    @ReactMethod
    public abstract void playTouchSound();

    public NativeSoundManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SoundManager";
    }
}
