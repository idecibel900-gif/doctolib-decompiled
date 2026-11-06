package com.swmansion.worklets;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class WorkletsPackage extends BaseReactPackage implements ReactPackage {
    public static /* synthetic */ Map $r8$lambda$u8evFHx6SrNscn0WJVQP7wk4tuA(Map map) {
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeWorkletsModuleSpec.NAME)) {
            return new WorkletsModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        final HashMap map = new HashMap();
        Class cls = new Class[]{WorkletsModule.class}[0];
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        Objects.requireNonNull(reactModule);
        ReactModule reactModule2 = reactModule;
        map.put(reactModule2.name(), new ReactModuleInfo(reactModule2.name(), cls.getName(), reactModule2.canOverrideExistingModule(), reactModule2.needsEagerInit(), reactModule2.isCxxModule(), true));
        return new ReactModuleInfoProvider() { // from class: com.swmansion.worklets.WorkletsPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return WorkletsPackage.$r8$lambda$u8evFHx6SrNscn0WJVQP7wk4tuA(map);
            }
        };
    }
}
