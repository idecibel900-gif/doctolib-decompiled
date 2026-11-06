package com.a11yorder;

import com.a11yorder.views.A11yGroupView.A11yGroupViewManager;
import com.a11yorder.views.A11yIndexView.A11yIndexViewManager;
import com.a11yorder.views.A11yOrderView.A11yOrderViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class A11yOrderPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new A11yIndexViewManager());
        arrayList.add(new A11yOrderViewManager());
        arrayList.add(new A11yGroupViewManager());
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }
}
