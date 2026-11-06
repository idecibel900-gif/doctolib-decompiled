package com.BV.LinearGradient;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LinearGradientPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new LinearGradientManager());
    }
}
