package com.henninghall.date_picker;

import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.henninghall.date_picker.ui.SpinnerState;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Emitter {
    private static DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter() {
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) DatePickerPackage.context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    public static void onSpinnerStateChange(SpinnerState spinnerState, String str, View view) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("spinnerState", spinnerState.toString());
        writableMapCreateMap.putString(DiagnosticsEntry.ID_KEY, str);
        deviceEventEmitter().emit("spinnerStateChange", writableMapCreateMap);
    }

    public static void onDateChange(Calendar calendar, String str, String str2, View view) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("date", Utils.dateToIso(calendar));
        writableMapCreateMap.putString("dateString", str);
        writableMapCreateMap.putString(DiagnosticsEntry.ID_KEY, str2);
        deviceEventEmitter().emit("dateChange", writableMapCreateMap);
    }

    public static void onConfirm(String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("date", str);
        writableMapCreateMap.putString(DiagnosticsEntry.ID_KEY, str2);
        deviceEventEmitter().emit("onConfirm", writableMapCreateMap);
    }

    public static void onCancel(String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(DiagnosticsEntry.ID_KEY, str);
        deviceEventEmitter().emit("onCancel", writableMapCreateMap);
    }
}
