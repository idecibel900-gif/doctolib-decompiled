package com.doctolibappsauth;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DoctolibAppsAuthPackage extends BaseReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.areEqual(name, "DoctolibAppsAuth")) {
            return new DoctolibAppsAuthModule(reactContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.doctolibappsauth.DoctolibAppsAuthPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return DoctolibAppsAuthPackage.getReactModuleInfoProvider$lambda$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$0() {
        HashMap map = new HashMap();
        map.put("DoctolibAppsAuth", new ReactModuleInfo("DoctolibAppsAuth", "DoctolibAppsAuth", false, false, false, true));
        return map;
    }
}
