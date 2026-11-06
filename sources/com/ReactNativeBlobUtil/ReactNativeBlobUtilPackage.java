package com.ReactNativeBlobUtil;

import com.facebook.fbreact.specs.NativeBlobUtilsSpec;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeBlobUtilPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeBlobUtilsSpec.NAME)) {
            return new ReactNativeBlobUtil(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return ReactNativeBlobUtilPackage.$r8$lambda$7mgMkhDXBzzxf0nV5pW2xfiqA28();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$7mgMkhDXBzzxf0nV5pW2xfiqA28() {
        HashMap map = new HashMap();
        map.put(NativeBlobUtilsSpec.NAME, new ReactModuleInfo(NativeBlobUtilsSpec.NAME, NativeBlobUtilsSpec.NAME, false, false, true, false, true));
        return map;
    }
}
