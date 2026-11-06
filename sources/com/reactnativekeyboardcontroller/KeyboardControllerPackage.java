package com.reactnativekeyboardcontroller;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardControllerPackage extends BaseReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Intrinsics.areEqual(name, NativeKeyboardControllerSpec.NAME)) {
            return new KeyboardControllerModule(reactContext);
        }
        if (Intrinsics.areEqual(name, "StatusBarManager")) {
            return new StatusBarManagerCompatModule(reactContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.reactnativekeyboardcontroller.KeyboardControllerPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return KeyboardControllerPackage.getReactModuleInfoProvider$lambda$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$0() {
        HashMap map = new HashMap();
        map.put(NativeKeyboardControllerSpec.NAME, new ReactModuleInfo(NativeKeyboardControllerSpec.NAME, NativeKeyboardControllerSpec.NAME, false, false, false, true));
        map.put("StatusBarManager", new ReactModuleInfo("StatusBarManager", "StatusBarManager", true, false, false, true));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf((Object[]) new ViewManager[]{new KeyboardControllerViewManager(), new KeyboardGestureAreaViewManager(), new OverKeyboardViewManager(), new KeyboardBackgroundViewManager()});
    }
}
