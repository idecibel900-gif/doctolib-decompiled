package com.zoontek.rnlocalize;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNLocalizeSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNLocalize";

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getCalendar();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getCountry();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableArray getCurrencies();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableArray getLocales();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap getNumberFormatSettings();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getTemperatureUnit();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract String getTimeZone();

    @DoNotStrip
    @ReactMethod
    public abstract void openAppLanguageSettings(Promise promise);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean uses24HourClock();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract Boolean usesAutoDateAndTime();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract Boolean usesAutoTimeZone();

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean usesMetricSystem();

    public NativeRNLocalizeSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }
}
