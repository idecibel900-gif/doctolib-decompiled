package com.henninghall.date_picker;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNDatePickerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNDatePicker";

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void closePicker();

    @DoNotStrip
    @ReactMethod
    public abstract void openPicker(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    public NativeRNDatePickerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
