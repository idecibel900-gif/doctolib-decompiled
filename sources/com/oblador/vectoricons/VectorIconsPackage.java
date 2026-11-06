package com.oblador.vectoricons;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class VectorIconsPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeRNVectorIconsSpec.NAME)) {
            return new VectorIconsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.oblador.vectoricons.VectorIconsPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return VectorIconsPackage.$r8$lambda$7XVmmDuBtq5TFCvJJV6BU4jAp48();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$7XVmmDuBtq5TFCvJJV6BU4jAp48() {
        HashMap map = new HashMap();
        map.put(NativeRNVectorIconsSpec.NAME, new ReactModuleInfo(NativeRNVectorIconsSpec.NAME, NativeRNVectorIconsSpec.NAME, false, false, false, false, true));
        return map;
    }
}
