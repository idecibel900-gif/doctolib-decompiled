package com.reactnativecommunity.picker;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RNCPickerPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactDialogPickerManager());
        arrayList.add(new ReactDropdownPickerManager());
        return arrayList;
    }
}
