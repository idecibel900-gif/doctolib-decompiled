package com.datadog.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDdTraceSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdTrace";

    @DoNotStrip
    @ReactMethod
    public abstract void finishSpan(String str, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startSpan(String str, ReadableMap readableMap, double d, Promise promise);

    public NativeDdTraceSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
