package com.reactcommunity.rndatetimepicker;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RNDateTimePickerPackage extends BaseReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("RNCDatePicker")) {
            return new DatePickerModule(reactApplicationContext);
        }
        if (str.equals("RNCTimePicker")) {
            return new TimePickerModule(reactApplicationContext);
        }
        if (str.equals("RNCMaterialDatePicker")) {
            return new MaterialDatePickerModule(reactApplicationContext);
        }
        if (str.equals("RNCMaterialTimePicker")) {
            return new MaterialTimePickerModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNDateTimePickerPackage.$r8$lambda$XviH2T9OBuKO_DZA0AspW9DLK0g();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$XviH2T9OBuKO_DZA0AspW9DLK0g() {
        HashMap map = new HashMap();
        map.put("RNCDatePicker", new ReactModuleInfo("RNCDatePicker", "RNCDatePicker", false, false, false, true));
        map.put("RNCTimePicker", new ReactModuleInfo("RNCTimePicker", "RNCTimePicker", false, false, false, true));
        map.put("RNCMaterialDatePicker", new ReactModuleInfo("RNCMaterialDatePicker", "RNCMaterialDatePicker", false, false, false, false, true));
        map.put("RNCMaterialTimePicker", new ReactModuleInfo("RNCMaterialTimePicker", "RNCMaterialTimePicker", false, false, false, false, true));
        return map;
    }
}
