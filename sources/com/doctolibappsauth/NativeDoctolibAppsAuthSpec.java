package com.doctolibappsauth;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDoctolibAppsAuthSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DoctolibAppsAuth";

    @DoNotStrip
    @ReactMethod
    public abstract void getAuthStatus(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getAuthToken(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void initialize(String str, String str2, ReadableArray readableArray, ReadableMap readableMap, String str3, String str4, ReadableMap readableMap2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str5, ReadableMap readableMap3, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void isInitialized(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void login(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void logout(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void quickLoginAuthenticate(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void quickLoginCanUse(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void quickLoginEnroll(String str, String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void quickLoginEnrolledKey(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void quickLoginForgetDevice(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void reset(Promise promise);

    public NativeDoctolibAppsAuthSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "DoctolibAppsAuth";
    }
}
