package com.facebook.react.internal.featureflags;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.build.ReactBuildConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNativeNewArchitectureFeatureFlags {
    public static final ReactNativeNewArchitectureFeatureFlags INSTANCE = new ReactNativeNewArchitectureFeatureFlags();

    private ReactNativeNewArchitectureFeatureFlags() {
    }

    public static final boolean enableBridgelessArchitecture() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            Assertions.assertCondition(ReactNativeFeatureFlags.enableBridgelessArchitecture(), "ReactNativeFeatureFlags.enableBridgelessArchitecture() should be set to TRUE when Strict Mode is enabled");
            return true;
        }
        return ReactNativeFeatureFlags.enableBridgelessArchitecture();
    }

    public static final boolean enableFabricRenderer() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            Assertions.assertCondition(ReactNativeFeatureFlags.enableFabricRenderer(), "ReactNativeFeatureFlags.enableFabricRenderer() should be set to TRUE when Strict Mode is enabled");
            return true;
        }
        return ReactNativeFeatureFlags.enableFabricRenderer();
    }

    public static final boolean useFabricInterop() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            Assertions.assertCondition(!ReactNativeFeatureFlags.useFabricInterop(), "ReactNativeFeatureFlags.useFabricInterop() should be set to FALSE when Strict Mode is enabled");
            return false;
        }
        return ReactNativeFeatureFlags.useFabricInterop();
    }

    public static final boolean useTurboModuleInterop() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            Assertions.assertCondition(!ReactNativeFeatureFlags.useTurboModuleInterop(), "ReactNativeFeatureFlags.useTurboModuleInterop() should be set to FALSE when Strict Mode is enabled");
            return false;
        }
        return ReactNativeFeatureFlags.useTurboModuleInterop();
    }

    public static final boolean useTurboModules() {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            Assertions.assertCondition(ReactNativeFeatureFlags.useTurboModules(), "ReactNativeFeatureFlags.useTurboModules() should be set to TRUE when Strict Mode is enabled");
            return true;
        }
        return ReactNativeFeatureFlags.useTurboModules();
    }
}
