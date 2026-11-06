package com.henninghall.date_picker;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DatePickerManager extends SimpleViewManager<PickerView> {
    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeRNDatePickerSpec.NAME;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public PickerView createViewInstance(ThemedReactContext themedReactContext) {
        return DatePickerManagerImpl.createViewInstance(themedReactContext);
    }

    @ReactPropGroup(names = {"date", "mode", "locale", "maximumDate", "minimumDate", "textColor", "timezoneOffsetInMinutes", "minuteInterval", "is24hourSource", DiagnosticsEntry.ID_KEY, "dividerColor"})
    public void setProps(PickerView pickerView, int i, Dynamic dynamic) {
        DatePickerManagerImpl.updateProp("setProps", pickerView, i, dynamic, getClass());
    }

    @ReactPropGroup(customType = "Style", names = {"height"})
    public void setStyle(PickerView pickerView, int i, Dynamic dynamic) {
        DatePickerManagerImpl.updateProp("setStyle", pickerView, i, dynamic, getClass());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return DatePickerManagerImpl.getCommandsMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(PickerView pickerView) {
        super.onAfterUpdateTransaction(pickerView);
        DatePickerManagerImpl.onAfterUpdateTransaction(pickerView);
    }
}
