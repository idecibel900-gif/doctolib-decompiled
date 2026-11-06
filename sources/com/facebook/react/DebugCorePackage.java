package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugCorePackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {
    private final Lazy viewManagersMap$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.facebook.react.DebugCorePackage$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DebugCorePackage.viewManagersMap_delegate$lambda$1();
        }
    });

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return null;
    }

    private final Map getViewManagersMap() {
        return (Map) this.viewManagersMap$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map viewManagersMap_delegate$lambda$1() {
        return MapsKt.mapOf(TuplesKt.to(DebuggingOverlayManager.REACT_CLASS, ModuleSpec.INSTANCE.viewManagerSpec(new Provider() { // from class: com.facebook.react.DebugCorePackage$$ExternalSyntheticLambda2
            @Override // javax.inject.Provider
            public final Object get() {
                return DebugCorePackage.viewManagersMap_delegate$lambda$1$lambda$0();
            }
        })));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap_delegate$lambda$1$lambda$0() {
        return new DebuggingOverlayManager();
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.facebook.react.DebugCorePackage$$ExternalSyntheticLambda1
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return MapsKt.emptyMap();
            }
        };
    }

    @Override // com.facebook.react.BaseReactPackage
    public List getViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.toList(getViewManagersMap().values());
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public Collection getViewManagerNames(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return getViewManagersMap().keySet();
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    public ViewManager createViewManager(ReactApplicationContext reactContext, String viewManagerName) {
        Provider provider;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ModuleSpec moduleSpec = (ModuleSpec) getViewManagersMap().getOrDefault(viewManagerName, null);
        NativeModule nativeModule = (moduleSpec == null || (provider = moduleSpec.provider()) == null) ? null : (NativeModule) provider.get();
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }
}
