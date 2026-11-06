package com.facebook.react.internal.featureflags;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNativeFeatureFlagsCxxAccessor implements ReactNativeFeatureFlagsAccessor {
    private Boolean cdpInteractionMetricsEnabledCache;
    private Boolean commonTestFlagCache;
    private Boolean cxxNativeAnimatedEnabledCache;
    private Boolean cxxNativeAnimatedRemoveJsSyncCache;
    private Boolean disableEarlyViewCommandExecutionCache;
    private Boolean disableFabricCommitInCXXAnimatedCache;
    private Boolean disableMountItemReorderingAndroidCache;
    private Boolean disableOldAndroidAttachmentMetricsWorkaroundsCache;
    private Boolean disableTextLayoutManagerCacheAndroidCache;
    private Boolean enableAccessibilityOrderCache;
    private Boolean enableAccumulatedUpdatesInRawPropsAndroidCache;
    private Boolean enableAndroidLinearTextCache;
    private Boolean enableAndroidTextMeasurementOptimizationsCache;
    private Boolean enableBridgelessArchitectureCache;
    private Boolean enableCppPropsIteratorSetterCache;
    private Boolean enableCustomFocusSearchOnClippedElementsAndroidCache;
    private Boolean enableDestroyShadowTreeRevisionAsyncCache;
    private Boolean enableDoubleMeasurementFixAndroidCache;
    private Boolean enableEagerMainQueueModulesOnIOSCache;
    private Boolean enableEagerRootViewAttachmentCache;
    private Boolean enableFabricLogsCache;
    private Boolean enableFabricRendererCache;
    private Boolean enableFontScaleChangesUpdatingLayoutCache;
    private Boolean enableIOSTextBaselineOffsetPerLineCache;
    private Boolean enableIOSViewClipToPaddingBoxCache;
    private Boolean enableImagePrefetchingAndroidCache;
    private Boolean enableImagePrefetchingOnUiThreadAndroidCache;
    private Boolean enableImmediateUpdateModeForContentOffsetChangesCache;
    private Boolean enableImperativeFocusCache;
    private Boolean enableInteropViewManagerClassLookUpOptimizationIOSCache;
    private Boolean enableIntersectionObserverByDefaultCache;
    private Boolean enableKeyEventsCache;
    private Boolean enableLayoutAnimationsOnAndroidCache;
    private Boolean enableLayoutAnimationsOnIOSCache;
    private Boolean enableMainQueueCoordinatorOnIOSCache;
    private Boolean enableModuleArgumentNSNullConversionIOSCache;
    private Boolean enableMutationObserverByDefaultCache;
    private Boolean enableNativeCSSParsingCache;
    private Boolean enableNetworkEventReportingCache;
    private Boolean enablePreparedTextLayoutCache;
    private Boolean enablePropsUpdateReconciliationAndroidCache;
    private Boolean enableResourceTimingAPICache;
    private Boolean enableSwiftUIBasedFiltersCache;
    private Boolean enableViewCullingCache;
    private Boolean enableViewRecyclingCache;
    private Boolean enableViewRecyclingForImageCache;
    private Boolean enableViewRecyclingForScrollViewCache;
    private Boolean enableViewRecyclingForTextCache;
    private Boolean enableViewRecyclingForViewCache;
    private Boolean enableVirtualViewClippingWithoutScrollViewClippingCache;
    private Boolean enableVirtualViewContainerStateExperimentalCache;
    private Boolean enableVirtualViewDebugFeaturesCache;
    private Boolean enableVirtualViewRenderStateCache;
    private Boolean enableVirtualViewWindowFocusDetectionCache;
    private Boolean enableWebPerformanceAPIsByDefaultCache;
    private Boolean fixMappingOfEventPrioritiesBetweenFabricAndReactCache;
    private Boolean fuseboxAssertSingleHostStateCache;
    private Boolean fuseboxEnabledReleaseCache;
    private Boolean fuseboxFrameRecordingEnabledCache;
    private Boolean fuseboxNetworkInspectionEnabledCache;
    private Boolean fuseboxScreenshotCaptureEnabledCache;
    private Boolean hideOffscreenVirtualViewsOnIOSCache;
    private Boolean overrideBySynchronousMountPropsAtMountingAndroidCache;
    private Boolean perfIssuesEnabledCache;
    private Boolean perfMonitorV2EnabledCache;
    private Double preparedTextCacheSizeCache;
    private Boolean preventShadowTreeCommitExhaustionCache;
    private Boolean redBoxV2AndroidCache;
    private Boolean redBoxV2IOSCache;
    private Boolean shouldPressibilityUseW3CPointerEventsForHoverCache;
    private Boolean shouldTriggerResponderTransferOnScrollAndroidCache;
    private Boolean skipActivityIdentityAssertionOnHostPauseCache;
    private Boolean sweepActiveTouchOnChildNativeGesturesAndroidCache;
    private Boolean traceTurboModulePromiseRejectionsOnAndroidCache;
    private Boolean updateRuntimeShadowNodeReferencesOnCommitCache;
    private Boolean useAlwaysAvailableJSErrorHandlingCache;
    private Boolean useFabricInteropCache;
    private Boolean useNativeEqualsInNativeReadableArrayAndroidCache;
    private Boolean useNativeTransformHelperAndroidCache;
    private Boolean useNativeViewConfigsInBridgelessModeCache;
    private Boolean useOptimizedEventBatchingOnAndroidCache;
    private Boolean useRawPropsJsiValueCache;
    private Boolean useShadowNodeStateOnCloneCache;
    private Boolean useSharedAnimatedBackendCache;
    private Boolean useTraitHiddenOnAndroidCache;
    private Boolean useTurboModuleInteropCache;
    private Boolean useTurboModulesCache;
    private Double viewCullingOutsetRatioCache;
    private Double virtualViewHysteresisRatioCache;
    private Double virtualViewPrerenderRatioCache;

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean commonTestFlag() {
        Boolean boolValueOf = this.commonTestFlagCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.commonTestFlag());
            this.commonTestFlagCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cdpInteractionMetricsEnabled() {
        Boolean boolValueOf = this.cdpInteractionMetricsEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.cdpInteractionMetricsEnabled());
            this.cdpInteractionMetricsEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedEnabled() {
        Boolean boolValueOf = this.cxxNativeAnimatedEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.cxxNativeAnimatedEnabled());
            this.cxxNativeAnimatedEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedRemoveJsSync() {
        Boolean boolValueOf = this.cxxNativeAnimatedRemoveJsSyncCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.cxxNativeAnimatedRemoveJsSync());
            this.cxxNativeAnimatedRemoveJsSyncCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableEarlyViewCommandExecution() {
        Boolean boolValueOf = this.disableEarlyViewCommandExecutionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableEarlyViewCommandExecution());
            this.disableEarlyViewCommandExecutionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableFabricCommitInCXXAnimated() {
        Boolean boolValueOf = this.disableFabricCommitInCXXAnimatedCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableFabricCommitInCXXAnimated());
            this.disableFabricCommitInCXXAnimatedCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableMountItemReorderingAndroid() {
        Boolean boolValueOf = this.disableMountItemReorderingAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableMountItemReorderingAndroid());
            this.disableMountItemReorderingAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableOldAndroidAttachmentMetricsWorkarounds() {
        Boolean boolValueOf = this.disableOldAndroidAttachmentMetricsWorkaroundsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableOldAndroidAttachmentMetricsWorkarounds());
            this.disableOldAndroidAttachmentMetricsWorkaroundsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableTextLayoutManagerCacheAndroid() {
        Boolean boolValueOf = this.disableTextLayoutManagerCacheAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableTextLayoutManagerCacheAndroid());
            this.disableTextLayoutManagerCacheAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccessibilityOrder() {
        Boolean boolValueOf = this.enableAccessibilityOrderCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableAccessibilityOrder());
            this.enableAccessibilityOrderCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        Boolean boolValueOf = this.enableAccumulatedUpdatesInRawPropsAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableAccumulatedUpdatesInRawPropsAndroid());
            this.enableAccumulatedUpdatesInRawPropsAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAndroidLinearText() {
        Boolean boolValueOf = this.enableAndroidLinearTextCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableAndroidLinearText());
            this.enableAndroidLinearTextCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAndroidTextMeasurementOptimizations() {
        Boolean boolValueOf = this.enableAndroidTextMeasurementOptimizationsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableAndroidTextMeasurementOptimizations());
            this.enableAndroidTextMeasurementOptimizationsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableBridgelessArchitecture() {
        Boolean boolValueOf = this.enableBridgelessArchitectureCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableBridgelessArchitecture());
            this.enableBridgelessArchitectureCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCppPropsIteratorSetter() {
        Boolean boolValueOf = this.enableCppPropsIteratorSetterCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableCppPropsIteratorSetter());
            this.enableCppPropsIteratorSetterCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCustomFocusSearchOnClippedElementsAndroid() {
        Boolean boolValueOf = this.enableCustomFocusSearchOnClippedElementsAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableCustomFocusSearchOnClippedElementsAndroid());
            this.enableCustomFocusSearchOnClippedElementsAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDestroyShadowTreeRevisionAsync() {
        Boolean boolValueOf = this.enableDestroyShadowTreeRevisionAsyncCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableDestroyShadowTreeRevisionAsync());
            this.enableDestroyShadowTreeRevisionAsyncCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDoubleMeasurementFixAndroid() {
        Boolean boolValueOf = this.enableDoubleMeasurementFixAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableDoubleMeasurementFixAndroid());
            this.enableDoubleMeasurementFixAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEagerMainQueueModulesOnIOS() {
        Boolean boolValueOf = this.enableEagerMainQueueModulesOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableEagerMainQueueModulesOnIOS());
            this.enableEagerMainQueueModulesOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEagerRootViewAttachment() {
        Boolean boolValueOf = this.enableEagerRootViewAttachmentCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableEagerRootViewAttachment());
            this.enableEagerRootViewAttachmentCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricLogs() {
        Boolean boolValueOf = this.enableFabricLogsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFabricLogs());
            this.enableFabricLogsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        Boolean boolValueOf = this.enableFabricRendererCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFabricRenderer());
            this.enableFabricRendererCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFontScaleChangesUpdatingLayout() {
        Boolean boolValueOf = this.enableFontScaleChangesUpdatingLayoutCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFontScaleChangesUpdatingLayout());
            this.enableFontScaleChangesUpdatingLayoutCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSTextBaselineOffsetPerLine() {
        Boolean boolValueOf = this.enableIOSTextBaselineOffsetPerLineCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableIOSTextBaselineOffsetPerLine());
            this.enableIOSTextBaselineOffsetPerLineCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSViewClipToPaddingBox() {
        Boolean boolValueOf = this.enableIOSViewClipToPaddingBoxCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableIOSViewClipToPaddingBox());
            this.enableIOSViewClipToPaddingBoxCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImagePrefetchingAndroid() {
        Boolean boolValueOf = this.enableImagePrefetchingAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableImagePrefetchingAndroid());
            this.enableImagePrefetchingAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImagePrefetchingOnUiThreadAndroid() {
        Boolean boolValueOf = this.enableImagePrefetchingOnUiThreadAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableImagePrefetchingOnUiThreadAndroid());
            this.enableImagePrefetchingOnUiThreadAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImmediateUpdateModeForContentOffsetChanges() {
        Boolean boolValueOf = this.enableImmediateUpdateModeForContentOffsetChangesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableImmediateUpdateModeForContentOffsetChanges());
            this.enableImmediateUpdateModeForContentOffsetChangesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableImperativeFocus() {
        Boolean boolValueOf = this.enableImperativeFocusCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableImperativeFocus());
            this.enableImperativeFocusCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableInteropViewManagerClassLookUpOptimizationIOS() {
        Boolean boolValueOf = this.enableInteropViewManagerClassLookUpOptimizationIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableInteropViewManagerClassLookUpOptimizationIOS());
            this.enableInteropViewManagerClassLookUpOptimizationIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIntersectionObserverByDefault() {
        Boolean boolValueOf = this.enableIntersectionObserverByDefaultCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableIntersectionObserverByDefault());
            this.enableIntersectionObserverByDefaultCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableKeyEvents() {
        Boolean boolValueOf = this.enableKeyEventsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableKeyEvents());
            this.enableKeyEventsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnAndroid() {
        Boolean boolValueOf = this.enableLayoutAnimationsOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableLayoutAnimationsOnAndroid());
            this.enableLayoutAnimationsOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnIOS() {
        Boolean boolValueOf = this.enableLayoutAnimationsOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableLayoutAnimationsOnIOS());
            this.enableLayoutAnimationsOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMainQueueCoordinatorOnIOS() {
        Boolean boolValueOf = this.enableMainQueueCoordinatorOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableMainQueueCoordinatorOnIOS());
            this.enableMainQueueCoordinatorOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableModuleArgumentNSNullConversionIOS() {
        Boolean boolValueOf = this.enableModuleArgumentNSNullConversionIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableModuleArgumentNSNullConversionIOS());
            this.enableModuleArgumentNSNullConversionIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMutationObserverByDefault() {
        Boolean boolValueOf = this.enableMutationObserverByDefaultCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableMutationObserverByDefault());
            this.enableMutationObserverByDefaultCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNativeCSSParsing() {
        Boolean boolValueOf = this.enableNativeCSSParsingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableNativeCSSParsing());
            this.enableNativeCSSParsingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNetworkEventReporting() {
        Boolean boolValueOf = this.enableNetworkEventReportingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableNetworkEventReporting());
            this.enableNetworkEventReportingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePreparedTextLayout() {
        Boolean boolValueOf = this.enablePreparedTextLayoutCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enablePreparedTextLayout());
            this.enablePreparedTextLayoutCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePropsUpdateReconciliationAndroid() {
        Boolean boolValueOf = this.enablePropsUpdateReconciliationAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enablePropsUpdateReconciliationAndroid());
            this.enablePropsUpdateReconciliationAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableResourceTimingAPI() {
        Boolean boolValueOf = this.enableResourceTimingAPICache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableResourceTimingAPI());
            this.enableResourceTimingAPICache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableSwiftUIBasedFilters() {
        Boolean boolValueOf = this.enableSwiftUIBasedFiltersCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableSwiftUIBasedFilters());
            this.enableSwiftUIBasedFiltersCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewCulling() {
        Boolean boolValueOf = this.enableViewCullingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewCulling());
            this.enableViewCullingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecycling() {
        Boolean boolValueOf = this.enableViewRecyclingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecycling());
            this.enableViewRecyclingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForImage() {
        Boolean boolValueOf = this.enableViewRecyclingForImageCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecyclingForImage());
            this.enableViewRecyclingForImageCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForScrollView() {
        Boolean boolValueOf = this.enableViewRecyclingForScrollViewCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecyclingForScrollView());
            this.enableViewRecyclingForScrollViewCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForText() {
        Boolean boolValueOf = this.enableViewRecyclingForTextCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecyclingForText());
            this.enableViewRecyclingForTextCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForView() {
        Boolean boolValueOf = this.enableViewRecyclingForViewCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecyclingForView());
            this.enableViewRecyclingForViewCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewClippingWithoutScrollViewClipping() {
        Boolean boolValueOf = this.enableVirtualViewClippingWithoutScrollViewClippingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableVirtualViewClippingWithoutScrollViewClipping());
            this.enableVirtualViewClippingWithoutScrollViewClippingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewContainerStateExperimental() {
        Boolean boolValueOf = this.enableVirtualViewContainerStateExperimentalCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableVirtualViewContainerStateExperimental());
            this.enableVirtualViewContainerStateExperimentalCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewDebugFeatures() {
        Boolean boolValueOf = this.enableVirtualViewDebugFeaturesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableVirtualViewDebugFeatures());
            this.enableVirtualViewDebugFeaturesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewRenderState() {
        Boolean boolValueOf = this.enableVirtualViewRenderStateCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableVirtualViewRenderState());
            this.enableVirtualViewRenderStateCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewWindowFocusDetection() {
        Boolean boolValueOf = this.enableVirtualViewWindowFocusDetectionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableVirtualViewWindowFocusDetection());
            this.enableVirtualViewWindowFocusDetectionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableWebPerformanceAPIsByDefault() {
        Boolean boolValueOf = this.enableWebPerformanceAPIsByDefaultCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableWebPerformanceAPIsByDefault());
            this.enableWebPerformanceAPIsByDefaultCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        Boolean boolValueOf = this.fixMappingOfEventPrioritiesBetweenFabricAndReactCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fixMappingOfEventPrioritiesBetweenFabricAndReact());
            this.fixMappingOfEventPrioritiesBetweenFabricAndReactCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxAssertSingleHostState() {
        Boolean boolValueOf = this.fuseboxAssertSingleHostStateCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxAssertSingleHostState());
            this.fuseboxAssertSingleHostStateCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxEnabledRelease() {
        Boolean boolValueOf = this.fuseboxEnabledReleaseCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxEnabledRelease());
            this.fuseboxEnabledReleaseCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxFrameRecordingEnabled() {
        Boolean boolValueOf = this.fuseboxFrameRecordingEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxFrameRecordingEnabled());
            this.fuseboxFrameRecordingEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxNetworkInspectionEnabled() {
        Boolean boolValueOf = this.fuseboxNetworkInspectionEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxNetworkInspectionEnabled());
            this.fuseboxNetworkInspectionEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxScreenshotCaptureEnabled() {
        Boolean boolValueOf = this.fuseboxScreenshotCaptureEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxScreenshotCaptureEnabled());
            this.fuseboxScreenshotCaptureEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean hideOffscreenVirtualViewsOnIOS() {
        Boolean boolValueOf = this.hideOffscreenVirtualViewsOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.hideOffscreenVirtualViewsOnIOS());
            this.hideOffscreenVirtualViewsOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean overrideBySynchronousMountPropsAtMountingAndroid() {
        Boolean boolValueOf = this.overrideBySynchronousMountPropsAtMountingAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.overrideBySynchronousMountPropsAtMountingAndroid());
            this.overrideBySynchronousMountPropsAtMountingAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean perfIssuesEnabled() {
        Boolean boolValueOf = this.perfIssuesEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.perfIssuesEnabled());
            this.perfIssuesEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean perfMonitorV2Enabled() {
        Boolean boolValueOf = this.perfMonitorV2EnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.perfMonitorV2Enabled());
            this.perfMonitorV2EnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double preparedTextCacheSize() {
        Double dValueOf = this.preparedTextCacheSizeCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(ReactNativeFeatureFlagsCxxInterop.preparedTextCacheSize());
            this.preparedTextCacheSizeCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean preventShadowTreeCommitExhaustion() {
        Boolean boolValueOf = this.preventShadowTreeCommitExhaustionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.preventShadowTreeCommitExhaustion());
            this.preventShadowTreeCommitExhaustionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean redBoxV2Android() {
        Boolean boolValueOf = this.redBoxV2AndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.redBoxV2Android());
            this.redBoxV2AndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean redBoxV2IOS() {
        Boolean boolValueOf = this.redBoxV2IOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.redBoxV2IOS());
            this.redBoxV2IOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean shouldPressibilityUseW3CPointerEventsForHover() {
        Boolean boolValueOf = this.shouldPressibilityUseW3CPointerEventsForHoverCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.shouldPressibilityUseW3CPointerEventsForHover());
            this.shouldPressibilityUseW3CPointerEventsForHoverCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean shouldTriggerResponderTransferOnScrollAndroid() {
        Boolean boolValueOf = this.shouldTriggerResponderTransferOnScrollAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.shouldTriggerResponderTransferOnScrollAndroid());
            this.shouldTriggerResponderTransferOnScrollAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean skipActivityIdentityAssertionOnHostPause() {
        Boolean boolValueOf = this.skipActivityIdentityAssertionOnHostPauseCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.skipActivityIdentityAssertionOnHostPause());
            this.skipActivityIdentityAssertionOnHostPauseCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean sweepActiveTouchOnChildNativeGesturesAndroid() {
        Boolean boolValueOf = this.sweepActiveTouchOnChildNativeGesturesAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.sweepActiveTouchOnChildNativeGesturesAndroid());
            this.sweepActiveTouchOnChildNativeGesturesAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean traceTurboModulePromiseRejectionsOnAndroid() {
        Boolean boolValueOf = this.traceTurboModulePromiseRejectionsOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.traceTurboModulePromiseRejectionsOnAndroid());
            this.traceTurboModulePromiseRejectionsOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean updateRuntimeShadowNodeReferencesOnCommit() {
        Boolean boolValueOf = this.updateRuntimeShadowNodeReferencesOnCommitCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.updateRuntimeShadowNodeReferencesOnCommit());
            this.updateRuntimeShadowNodeReferencesOnCommitCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useAlwaysAvailableJSErrorHandling() {
        Boolean boolValueOf = this.useAlwaysAvailableJSErrorHandlingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useAlwaysAvailableJSErrorHandling());
            this.useAlwaysAvailableJSErrorHandlingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        Boolean boolValueOf = this.useFabricInteropCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useFabricInterop());
            this.useFabricInteropCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeEqualsInNativeReadableArrayAndroid() {
        Boolean boolValueOf = this.useNativeEqualsInNativeReadableArrayAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useNativeEqualsInNativeReadableArrayAndroid());
            this.useNativeEqualsInNativeReadableArrayAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeTransformHelperAndroid() {
        Boolean boolValueOf = this.useNativeTransformHelperAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useNativeTransformHelperAndroid());
            this.useNativeTransformHelperAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        Boolean boolValueOf = this.useNativeViewConfigsInBridgelessModeCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useNativeViewConfigsInBridgelessMode());
            this.useNativeViewConfigsInBridgelessModeCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useOptimizedEventBatchingOnAndroid() {
        Boolean boolValueOf = this.useOptimizedEventBatchingOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useOptimizedEventBatchingOnAndroid());
            this.useOptimizedEventBatchingOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useRawPropsJsiValue() {
        Boolean boolValueOf = this.useRawPropsJsiValueCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useRawPropsJsiValue());
            this.useRawPropsJsiValueCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useShadowNodeStateOnClone() {
        Boolean boolValueOf = this.useShadowNodeStateOnCloneCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useShadowNodeStateOnClone());
            this.useShadowNodeStateOnCloneCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useSharedAnimatedBackend() {
        Boolean boolValueOf = this.useSharedAnimatedBackendCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useSharedAnimatedBackend());
            this.useSharedAnimatedBackendCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTraitHiddenOnAndroid() {
        Boolean boolValueOf = this.useTraitHiddenOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useTraitHiddenOnAndroid());
            this.useTraitHiddenOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        Boolean boolValueOf = this.useTurboModuleInteropCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useTurboModuleInterop());
            this.useTurboModuleInteropCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        Boolean boolValueOf = this.useTurboModulesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useTurboModules());
            this.useTurboModulesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double viewCullingOutsetRatio() {
        Double dValueOf = this.viewCullingOutsetRatioCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(ReactNativeFeatureFlagsCxxInterop.viewCullingOutsetRatio());
            this.viewCullingOutsetRatioCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double virtualViewHysteresisRatio() {
        Double dValueOf = this.virtualViewHysteresisRatioCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(ReactNativeFeatureFlagsCxxInterop.virtualViewHysteresisRatio());
            this.virtualViewHysteresisRatioCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double virtualViewPrerenderRatio() {
        Double dValueOf = this.virtualViewPrerenderRatioCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(ReactNativeFeatureFlagsCxxInterop.virtualViewPrerenderRatio());
            this.virtualViewPrerenderRatioCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public void override(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        ReactNativeFeatureFlagsCxxInterop.override(provider);
    }
}
