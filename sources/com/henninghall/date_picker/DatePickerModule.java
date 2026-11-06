package com.henninghall.date_picker;

import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import net.time4j.android.ApplicationStarter;

/* JADX INFO: loaded from: classes4.dex */
public class DatePickerModule extends NativeRNDatePickerSpec {
    private final DatePickerModuleImpl module;

    @Override // com.henninghall.date_picker.NativeRNDatePickerSpec
    public void addListener(String str) {
    }

    @Override // com.henninghall.date_picker.NativeRNDatePickerSpec
    public void removeListeners(double d) {
    }

    DatePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        ApplicationStarter.initialize((Context) reactApplicationContext, false);
        this.module = new DatePickerModuleImpl(reactApplicationContext);
    }

    @Override // com.henninghall.date_picker.NativeRNDatePickerSpec
    public void openPicker(ReadableMap readableMap) {
        this.module.openPicker(readableMap);
    }

    @Override // com.henninghall.date_picker.NativeRNDatePickerSpec
    public void closePicker() {
        this.module.closePicker();
    }

    @Override // com.henninghall.date_picker.NativeRNDatePickerSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeRNDatePickerSpec.NAME;
    }
}
