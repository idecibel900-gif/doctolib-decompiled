package com.reactnativecommunity.cookies;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CookieManagerPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CookieManagerModule(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[0]);
    }
}
