package com.facebook.react.internal.featureflags;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactNativeFeatureFlagsDefaults implements ReactNativeFeatureFlagsProvider {
    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cdpInteractionMetricsEnabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean commonTestFlag() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedEnabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedRemoveJsSync() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableEarlyViewCommandExecution() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableFabricCommitInCXXAnimated() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableMountItemReorderingAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableOldAndroidAttachmentMetricsWorkarounds() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableTextLayoutManagerCacheAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccessibilityOrder() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAndroidLinearText() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAndroidTextMeasurementOptimizations() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCppPropsIteratorSetter() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCustomFocusSearchOnClippedElementsAndroid() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDestroyShadowTreeRevisionAsync() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDoubleMeasurementFixAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEagerMainQueueModulesOnIOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEagerRootViewAttachment() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricLogs() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFontScaleChangesUpdatingLayout() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSTextBaselineOffsetPerLine() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSViewClipToPaddingBox() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImagePrefetchingAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImagePrefetchingOnUiThreadAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImmediateUpdateModeForContentOffsetChanges() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImperativeFocus() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableInteropViewManagerClassLookUpOptimizationIOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIntersectionObserverByDefault() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableKeyEvents() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnIOS() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMainQueueCoordinatorOnIOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableModuleArgumentNSNullConversionIOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMutationObserverByDefault() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNativeCSSParsing() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNetworkEventReporting() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePreparedTextLayout() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePropsUpdateReconciliationAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableResourceTimingAPI() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableSwiftUIBasedFilters() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewCulling() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecycling() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForImage() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForScrollView() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForText() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForView() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewClippingWithoutScrollViewClipping() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewContainerStateExperimental() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewDebugFeatures() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewRenderState() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewWindowFocusDetection() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableWebPerformanceAPIsByDefault() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxAssertSingleHostState() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxEnabledRelease() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxFrameRecordingEnabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxNetworkInspectionEnabled() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxScreenshotCaptureEnabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean hideOffscreenVirtualViewsOnIOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean overrideBySynchronousMountPropsAtMountingAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean perfIssuesEnabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean perfMonitorV2Enabled() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double preparedTextCacheSize() {
        return 200.0d;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean preventShadowTreeCommitExhaustion() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean redBoxV2Android() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean redBoxV2IOS() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean shouldPressibilityUseW3CPointerEventsForHover() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean shouldTriggerResponderTransferOnScrollAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean skipActivityIdentityAssertionOnHostPause() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean sweepActiveTouchOnChildNativeGesturesAndroid() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean traceTurboModulePromiseRejectionsOnAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean updateRuntimeShadowNodeReferencesOnCommit() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useAlwaysAvailableJSErrorHandling() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeEqualsInNativeReadableArrayAndroid() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeTransformHelperAndroid() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useOptimizedEventBatchingOnAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useRawPropsJsiValue() {
        return true;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useShadowNodeStateOnClone() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useSharedAnimatedBackend() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTraitHiddenOnAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double viewCullingOutsetRatio() {
        return 0.0d;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double virtualViewHysteresisRatio() {
        return 0.0d;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double virtualViewPrerenderRatio() {
        return 5.0d;
    }
}
