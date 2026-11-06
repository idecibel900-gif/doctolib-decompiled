package com.facebook.react;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {
    private final List<ModuleProvider> moduleProviders;
    private final Map<ModuleProvider, Map<String, ReactModuleInfo>> packageModuleInfos;
    private final boolean shouldEnableLegacyModuleInterop;

    public interface ModuleProvider {
        NativeModule getModule(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected ReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List packages, HybridData hybridData) {
        super(hybridData);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.moduleProviders = new ArrayList();
        this.packageModuleInfos = new LinkedHashMap();
        this.shouldEnableLegacyModuleInterop = ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture() && ReactNativeNewArchitectureFeatureFlags.useTurboModuleInterop();
        initialize(reactApplicationContext, packages);
    }

    private final void initialize(final ReactApplicationContext reactApplicationContext, List list) {
        String name;
        ReactModuleInfo reactModuleInfo;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ReactPackage reactPackage = (ReactPackage) it.next();
            if (reactPackage instanceof BaseReactPackage) {
                ModuleProvider moduleProvider = new ModuleProvider() { // from class: com.facebook.react.ReactPackageTurboModuleManagerDelegate$$ExternalSyntheticLambda0
                    @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                    public final NativeModule getModule(String str) {
                        return ReactPackageTurboModuleManagerDelegate.initialize$lambda$0(reactPackage, reactApplicationContext, str);
                    }
                };
                this.moduleProviders.add(moduleProvider);
                this.packageModuleInfos.put(moduleProvider, ((BaseReactPackage) reactPackage).getReactModuleInfoProvider().getReactModuleInfos());
            } else {
                shouldSupportLegacyPackages();
                if (shouldSupportLegacyPackages()) {
                    List<NativeModule> listCreateNativeModules = reactPackage.createNativeModules(reactApplicationContext);
                    final LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (NativeModule nativeModule : listCreateNativeModules) {
                        Class<?> cls = nativeModule.getClass();
                        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                        if (reactModule == null || (name = reactModule.name()) == null) {
                            name = nativeModule.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        }
                        String str = name;
                        if (reactModule != null) {
                            String name2 = cls.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                            reactModuleInfo = new ReactModuleInfo(str, name2, reactModule.canOverrideExistingModule(), true, reactModule.isCxxModule(), ReactModuleInfo.Companion.classIsTurboModule(cls));
                        } else {
                            String name3 = cls.getName();
                            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                            reactModuleInfo = new ReactModuleInfo(str, name3, nativeModule.canOverrideExistingModule(), true, CxxModuleWrapper.class.isAssignableFrom(cls), ReactModuleInfo.Companion.classIsTurboModule(cls));
                        }
                        linkedHashMap2.put(str, reactModuleInfo);
                        linkedHashMap.put(str, nativeModule);
                    }
                    ModuleProvider moduleProvider2 = new ModuleProvider() { // from class: com.facebook.react.ReactPackageTurboModuleManagerDelegate$$ExternalSyntheticLambda1
                        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.ModuleProvider
                        public final NativeModule getModule(String str2) {
                            return ReactPackageTurboModuleManagerDelegate.initialize$lambda$2(linkedHashMap, str2);
                        }
                    };
                    this.moduleProviders.add(moduleProvider2);
                    this.packageModuleInfos.put(moduleProvider2, linkedHashMap2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule initialize$lambda$0(ReactPackage reactPackage, ReactApplicationContext reactApplicationContext, String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return ((BaseReactPackage) reactPackage).getModule(moduleName, reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule initialize$lambda$2(Map map, String module) {
        Intrinsics.checkNotNullParameter(module, "module");
        return (NativeModule) map.get(module);
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return this.shouldEnableLegacyModuleInterop;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public TurboModule getModule(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        NativeModule nativeModule = null;
        for (ModuleProvider moduleProvider : this.moduleProviders) {
            Map<String, ReactModuleInfo> map = this.packageModuleInfos.get(moduleProvider);
            ReactModuleInfo reactModuleInfo = map != null ? map.get(moduleName) : null;
            if (reactModuleInfo != null && reactModuleInfo.isTurboModule() && (nativeModule == null || reactModuleInfo.canOverrideExistingModule())) {
                NativeModule module = moduleProvider.getModule(moduleName);
                if (module != null) {
                    nativeModule = module;
                }
            }
        }
        if (!(nativeModule instanceof TurboModule)) {
            return null;
        }
        Intrinsics.checkNotNull(nativeModule, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.interfaces.TurboModule");
        return (TurboModule) nativeModule;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isModuleRegistered(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Iterator<ModuleProvider> it = this.moduleProviders.iterator();
        while (it.hasNext()) {
            Map<String, ReactModuleInfo> map = this.packageModuleInfos.get(it.next());
            ReactModuleInfo reactModuleInfo = map != null ? map.get(moduleName) : null;
            if (reactModuleInfo != null && reactModuleInfo.isTurboModule()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public boolean unstable_isLegacyModuleRegistered(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Iterator<ModuleProvider> it = this.moduleProviders.iterator();
        while (it.hasNext()) {
            Map<String, ReactModuleInfo> map = this.packageModuleInfos.get(it.next());
            ReactModuleInfo reactModuleInfo = map != null ? map.get(moduleName) : null;
            if (reactModuleInfo != null && !reactModuleInfo.isTurboModule()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public NativeModule getLegacyModule(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        if (!unstable_shouldEnableLegacyModuleInterop()) {
            return null;
        }
        NativeModule nativeModule = null;
        for (ModuleProvider moduleProvider : this.moduleProviders) {
            Map<String, ReactModuleInfo> map = this.packageModuleInfos.get(moduleProvider);
            ReactModuleInfo reactModuleInfo = map != null ? map.get(moduleName) : null;
            if (reactModuleInfo != null && !reactModuleInfo.isTurboModule() && (nativeModule == null || reactModuleInfo.canOverrideExistingModule())) {
                NativeModule module = moduleProvider.getModule(moduleName);
                if (module != null) {
                    nativeModule = module;
                }
            }
        }
        if (nativeModule instanceof TurboModule) {
            return null;
        }
        return nativeModule;
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    public List<String> getEagerInitModuleNames() {
        List listEmptyList;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<ModuleProvider> it = this.moduleProviders.iterator();
        while (it.hasNext()) {
            Map<String, ReactModuleInfo> map = this.packageModuleInfos.get(it.next());
            if (map == null || (listEmptyList = map.values()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            for (ReactModuleInfo reactModuleInfo : listEmptyList) {
                if (reactModuleInfo.isTurboModule() && reactModuleInfo.needsEagerInit()) {
                    listCreateListBuilder.add(reactModuleInfo.name());
                }
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final boolean shouldSupportLegacyPackages() {
        return unstable_shouldEnableLegacyModuleInterop();
    }

    public static abstract class Builder {
        private ReactApplicationContext context;
        private List packages;

        protected abstract ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List list);

        public final Builder setPackages(List packages) {
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.packages = CollectionsKt.toList(packages);
            return this;
        }

        public final Builder setReactApplicationContext(ReactApplicationContext reactApplicationContext) {
            this.context = reactApplicationContext;
            return this;
        }

        public final ReactPackageTurboModuleManagerDelegate build() {
            ReactApplicationContext reactApplicationContext = this.context;
            if (reactApplicationContext == null) {
                throw new IllegalArgumentException("The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            }
            List list = this.packages;
            if (list == null) {
                throw new IllegalArgumentException("A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            }
            return build(reactApplicationContext, list);
        }
    }
}
