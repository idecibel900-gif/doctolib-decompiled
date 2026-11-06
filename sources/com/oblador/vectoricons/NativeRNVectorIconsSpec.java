package com.oblador.vectoricons;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNVectorIconsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNVectorIcons";

    @DoNotStrip
    @ReactMethod
    public abstract void getImageForFont(String str, String str2, double d, double d2, Promise promise);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getImageForFontSync(String str, String str2, double d, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void loadFontWithFileName(String str, String str2, Promise promise);

    public NativeRNVectorIconsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
