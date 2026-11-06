package com.th3rdwave.safeareacontext;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaContextPackage extends BaseReactPackage {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$0(Map map) {
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.areEqual(name, "RNCSafeAreaContext")) {
            return new SafeAreaContextModule(reactContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        final HashMap map = new HashMap();
        Class cls = new Class[]{SafeAreaContextModule.class}[0];
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            map.put(strName, new ReactModuleInfo(strName2, name, true, reactModule.needsEagerInit(), reactModule.isCxxModule(), true));
        }
        return new ReactModuleInfoProvider() { // from class: com.th3rdwave.safeareacontext.SafeAreaContextPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return SafeAreaContextPackage.getReactModuleInfoProvider$lambda$0(map);
            }
        };
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf((Object[]) new ViewManager[]{new SafeAreaProviderManager(), new SafeAreaViewManager()});
    }
}
