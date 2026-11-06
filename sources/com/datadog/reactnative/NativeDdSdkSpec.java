package com.datadog.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDdSdkSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DdSdk";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void addUserExtraInfo(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void clearAllData(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void consumeWebviewEvent(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void initialize(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void sendTelemetryLog(String str, ReadableMap readableMap, ReadableMap readableMap2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setAttributes(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setTrackingConsent(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUser(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void setUserInfo(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void telemetryDebug(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void telemetryError(String str, String str2, String str3, Promise promise);

    public NativeDdSdkSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
