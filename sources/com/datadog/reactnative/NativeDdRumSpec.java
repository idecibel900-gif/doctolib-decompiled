package com.datadog.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDdRumSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdRum";

    @DoNotStrip
    @ReactMethod
    public abstract void addAction(String str, String str2, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addError(String str, String str2, String str3, ReadableMap readableMap, double d, String str4, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addFeatureFlagEvaluation(String str, ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addTiming(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addViewLoadingTime(boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentSessionId(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startAction(String str, String str2, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startResource(String str, String str2, String str3, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void startView(String str, String str2, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopAction(String str, String str2, ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopResource(String str, double d, String str2, double d2, ReadableMap readableMap, double d3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopSession(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void stopView(String str, ReadableMap readableMap, double d, Promise promise);

    public NativeDdRumSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
