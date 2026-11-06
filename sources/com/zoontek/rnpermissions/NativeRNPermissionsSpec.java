package com.zoontek.rnpermissions;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNPermissionsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNPermissions";

    @DoNotStrip
    @ReactMethod
    public abstract void check(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void checkLocationAccuracy(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void checkMultiple(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void checkNotifications(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void openPhotoPicker(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void request(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void requestLocationAccuracy(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void requestMultiple(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void requestNotifications(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void shouldShowRequestRationale(String str, Promise promise);

    public NativeRNPermissionsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @DoNotStrip
    public final Map<String, Object> getConstants() {
        Map<String, Object> typedExportedConstants = getTypedExportedConstants();
        if (ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD) {
            HashSet hashSet = new HashSet(Arrays.asList("available"));
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet(typedExportedConstants.keySet());
            hashSet3.removeAll(hashSet);
            hashSet3.removeAll(hashSet2);
            if (!hashSet3.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module Flow doesn't declare constants: %s", hashSet3));
            }
            hashSet.removeAll(typedExportedConstants.keySet());
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException(String.format("Native Module doesn't fill in constants: %s", hashSet));
            }
        }
        return typedExportedConstants;
    }
}
