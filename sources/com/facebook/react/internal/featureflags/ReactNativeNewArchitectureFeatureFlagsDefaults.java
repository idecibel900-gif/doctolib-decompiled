package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactNativeNewArchitectureFeatureFlagsDefaults extends ReactNativeFeatureFlagsDefaults {
    private final boolean newArchitectureEnabled = true;

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableBridgelessArchitecture() {
        return this.newArchitectureEnabled;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        return this.newArchitectureEnabled;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        return this.newArchitectureEnabled || super.useNativeViewConfigsInBridgelessMode();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        return this.newArchitectureEnabled || super.useTurboModuleInterop();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        return this.newArchitectureEnabled;
    }
}
