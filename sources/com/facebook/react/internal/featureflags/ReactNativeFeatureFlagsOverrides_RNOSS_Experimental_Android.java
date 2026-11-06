package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeFeatureFlagsOverrides_RNOSS_Experimental_Android extends ReactNativeFeatureFlagsOverrides_RNOSS_Canary_Android {
    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccessibilityOrder() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableSwiftUIBasedFilters() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean preventShadowTreeCommitExhaustion() {
        return true;
    }
}
