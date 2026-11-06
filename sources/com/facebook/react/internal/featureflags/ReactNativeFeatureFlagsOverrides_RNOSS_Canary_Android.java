package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeFeatureFlagsOverrides_RNOSS_Canary_Android extends ReactNativeFeatureFlagsDefaults {
    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableBridgelessArchitecture() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIntersectionObserverByDefault() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        return true;
    }
}
