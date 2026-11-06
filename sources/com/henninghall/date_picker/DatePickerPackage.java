package com.henninghall.date_picker;

import com.facebook.react.ReactPackage;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DatePickerPackage extends TurboReactPackage implements ReactPackage {
    public static ReactApplicationContext context;

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (!str.equals(NativeRNDatePickerSpec.NAME)) {
            return null;
        }
        context = reactApplicationContext;
        return new DatePickerModule(reactApplicationContext);
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.henninghall.date_picker.DatePickerPackage.1
            final boolean isTurboModule = true;

            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public Map getReactModuleInfos() {
                HashMap map = new HashMap();
                map.put(NativeRNDatePickerSpec.NAME, new ReactModuleInfo(NativeRNDatePickerSpec.NAME, NativeRNDatePickerSpec.NAME, false, false, true, false, true));
                return map;
            }
        };
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        context = reactApplicationContext;
        return Arrays.asList(new DatePickerManager());
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DatePickerModule(reactApplicationContext));
        return arrayList;
    }
}
