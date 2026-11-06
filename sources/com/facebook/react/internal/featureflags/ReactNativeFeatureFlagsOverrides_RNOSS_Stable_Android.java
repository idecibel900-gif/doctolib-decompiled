package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNativeFeatureFlagsOverrides_RNOSS_Stable_Android extends ReactNativeNewArchitectureFeatureFlagsDefaults {
    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useShadowNodeStateOnClone() {
        return true;
    }
}
