package com.dylanvann.fastimage;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FastImageViewPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeFastImageViewModuleSpec.NAME)) {
            return new FastImageViewModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.dylanvann.fastimage.FastImageViewPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return FastImageViewPackage.$r8$lambda$scSf7TLab5eZXJSOeMR8yahpz_Y();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$scSf7TLab5eZXJSOeMR8yahpz_Y() {
        HashMap map = new HashMap();
        map.put(NativeFastImageViewModuleSpec.NAME, new ReactModuleInfo(NativeFastImageViewModuleSpec.NAME, NativeFastImageViewModuleSpec.NAME, false, false, true, false, true));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new FastImageViewManager());
    }
}
