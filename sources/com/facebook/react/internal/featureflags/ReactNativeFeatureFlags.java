package com.facebook.react.internal.featureflags;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNativeFeatureFlags {
    public static final ReactNativeFeatureFlags INSTANCE = new ReactNativeFeatureFlags();
    private static ReactNativeFeatureFlagsAccessor accessor;
    private static Function0 accessorProvider;

    private ReactNativeFeatureFlags() {
    }

    static {
        Function0 function0 = new Function0() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlags$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactNativeFeatureFlags.accessorProvider$lambda$0();
            }
        };
        accessorProvider = function0;
        accessor = (ReactNativeFeatureFlagsAccessor) function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactNativeFeatureFlagsCxxAccessor accessorProvider$lambda$0() {
        return new ReactNativeFeatureFlagsCxxAccessor();
    }

    public static final boolean cxxNativeAnimatedEnabled() {
        return accessor.cxxNativeAnimatedEnabled();
    }

    public static final boolean disableEarlyViewCommandExecution() {
        return accessor.disableEarlyViewCommandExecution();
    }

    public static final boolean disableOldAndroidAttachmentMetricsWorkarounds() {
        return accessor.disableOldAndroidAttachmentMetricsWorkarounds();
    }

    public static final boolean enableAccessibilityOrder() {
        return accessor.enableAccessibilityOrder();
    }

    public static final boolean enableAndroidLinearText() {
        return accessor.enableAndroidLinearText();
    }

    public static final boolean enableAndroidTextMeasurementOptimizations() {
        return accessor.enableAndroidTextMeasurementOptimizations();
    }

    public static final boolean enableBridgelessArchitecture() {
        return accessor.enableBridgelessArchitecture();
    }

    public static final boolean enableCustomFocusSearchOnClippedElementsAndroid() {
        return accessor.enableCustomFocusSearchOnClippedElementsAndroid();
    }

    public static final boolean enableEagerRootViewAttachment() {
        return accessor.enableEagerRootViewAttachment();
    }

    public static final boolean enableFabricLogs() {
        return accessor.enableFabricLogs();
    }

    public static final boolean enableFabricRenderer() {
        return accessor.enableFabricRenderer();
    }

    public static final boolean enableFontScaleChangesUpdatingLayout() {
        return accessor.enableFontScaleChangesUpdatingLayout();
    }

    public static final boolean enableImagePrefetchingAndroid() {
        return accessor.enableImagePrefetchingAndroid();
    }

    public static final boolean enableImagePrefetchingOnUiThreadAndroid() {
        return accessor.enableImagePrefetchingOnUiThreadAndroid();
    }

    public static final boolean enableImperativeFocus() {
        return accessor.enableImperativeFocus();
    }

    public static final boolean enableNetworkEventReporting() {
        return accessor.enableNetworkEventReporting();
    }

    public static final boolean enablePreparedTextLayout() {
        return accessor.enablePreparedTextLayout();
    }

    public static final boolean enablePropsUpdateReconciliationAndroid() {
        return accessor.enablePropsUpdateReconciliationAndroid();
    }

    public static final boolean enableViewCulling() {
        return accessor.enableViewCulling();
    }

    public static final boolean enableViewRecycling() {
        return accessor.enableViewRecycling();
    }

    public static final boolean enableViewRecyclingForScrollView() {
        return accessor.enableViewRecyclingForScrollView();
    }

    public static final boolean enableViewRecyclingForText() {
        return accessor.enableViewRecyclingForText();
    }

    public static final boolean enableViewRecyclingForView() {
        return accessor.enableViewRecyclingForView();
    }

    public static final boolean enableVirtualViewClippingWithoutScrollViewClipping() {
        return accessor.enableVirtualViewClippingWithoutScrollViewClipping();
    }

    public static final boolean enableVirtualViewContainerStateExperimental() {
        return accessor.enableVirtualViewContainerStateExperimental();
    }

    public static final boolean enableVirtualViewDebugFeatures() {
        return accessor.enableVirtualViewDebugFeatures();
    }

    public static final boolean enableVirtualViewRenderState() {
        return accessor.enableVirtualViewRenderState();
    }

    public static final boolean enableVirtualViewWindowFocusDetection() {
        return accessor.enableVirtualViewWindowFocusDetection();
    }

    public static final boolean overrideBySynchronousMountPropsAtMountingAndroid() {
        return accessor.overrideBySynchronousMountPropsAtMountingAndroid();
    }

    public static final boolean perfMonitorV2Enabled() {
        return accessor.perfMonitorV2Enabled();
    }

    public static final boolean shouldTriggerResponderTransferOnScrollAndroid() {
        return accessor.shouldTriggerResponderTransferOnScrollAndroid();
    }

    public static final boolean skipActivityIdentityAssertionOnHostPause() {
        return accessor.skipActivityIdentityAssertionOnHostPause();
    }

    public static final boolean sweepActiveTouchOnChildNativeGesturesAndroid() {
        return accessor.sweepActiveTouchOnChildNativeGesturesAndroid();
    }

    public static final boolean useFabricInterop() {
        return accessor.useFabricInterop();
    }

    public static final boolean useNativeEqualsInNativeReadableArrayAndroid() {
        return accessor.useNativeEqualsInNativeReadableArrayAndroid();
    }

    public static final boolean useNativeTransformHelperAndroid() {
        return accessor.useNativeTransformHelperAndroid();
    }

    public static final boolean useNativeViewConfigsInBridgelessMode() {
        return accessor.useNativeViewConfigsInBridgelessMode();
    }

    public static final boolean useOptimizedEventBatchingOnAndroid() {
        return accessor.useOptimizedEventBatchingOnAndroid();
    }

    public static final boolean useTraitHiddenOnAndroid() {
        return accessor.useTraitHiddenOnAndroid();
    }

    public static final boolean useTurboModuleInterop() {
        return accessor.useTurboModuleInterop();
    }

    public static final boolean useTurboModules() {
        return accessor.useTurboModules();
    }

    public static final double virtualViewHysteresisRatio() {
        return accessor.virtualViewHysteresisRatio();
    }

    public static final double virtualViewPrerenderRatio() {
        return accessor.virtualViewPrerenderRatio();
    }

    public static final void override(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        accessor.override(provider);
    }
}
