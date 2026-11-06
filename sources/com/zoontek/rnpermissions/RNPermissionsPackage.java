package com.zoontek.rnpermissions;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RNPermissionsPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeRNPermissionsSpec.NAME)) {
            return new RNPermissionsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.zoontek.rnpermissions.RNPermissionsPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNPermissionsPackage.$r8$lambda$MooVEgue682NLCA6I3G_T8Vrjsk();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$MooVEgue682NLCA6I3G_T8Vrjsk() {
        HashMap map = new HashMap();
        map.put(NativeRNPermissionsSpec.NAME, new ReactModuleInfo(NativeRNPermissionsSpec.NAME, NativeRNPermissionsSpec.NAME, false, false, true, false, true));
        return map;
    }
}
