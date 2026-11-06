package com.facebook.react.internal.featureflags;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bA\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0087 J\t\u0010\u0006\u001a\u00020\u0005H\u0087 J\t\u0010\u0007\u001a\u00020\u0005H\u0087 J\t\u0010\b\u001a\u00020\u0005H\u0087 J\t\u0010\t\u001a\u00020\u0005H\u0087 J\t\u0010\n\u001a\u00020\u0005H\u0087 J\t\u0010\u000b\u001a\u00020\u0005H\u0087 J\t\u0010\f\u001a\u00020\u0005H\u0087 J\t\u0010\r\u001a\u00020\u0005H\u0087 J\t\u0010\u000e\u001a\u00020\u0005H\u0087 J\t\u0010\u000f\u001a\u00020\u0005H\u0087 J\t\u0010\u0010\u001a\u00020\u0005H\u0087 J\t\u0010\u0011\u001a\u00020\u0005H\u0087 J\t\u0010\u0012\u001a\u00020\u0005H\u0087 J\t\u0010\u0013\u001a\u00020\u0005H\u0087 J\t\u0010\u0014\u001a\u00020\u0005H\u0087 J\t\u0010\u0015\u001a\u00020\u0005H\u0087 J\t\u0010\u0016\u001a\u00020\u0005H\u0087 J\t\u0010\u0017\u001a\u00020\u0005H\u0087 J\t\u0010\u0018\u001a\u00020\u0005H\u0087 J\t\u0010\u0019\u001a\u00020\u0005H\u0087 J\t\u0010\u001a\u001a\u00020\u0005H\u0087 J\t\u0010\u001b\u001a\u00020\u0005H\u0087 J\t\u0010\u001c\u001a\u00020\u0005H\u0087 J\t\u0010\u001d\u001a\u00020\u0005H\u0087 J\t\u0010\u001e\u001a\u00020\u0005H\u0087 J\t\u0010\u001f\u001a\u00020\u0005H\u0087 J\t\u0010 \u001a\u00020\u0005H\u0087 J\t\u0010!\u001a\u00020\u0005H\u0087 J\t\u0010\"\u001a\u00020\u0005H\u0087 J\t\u0010#\u001a\u00020\u0005H\u0087 J\t\u0010$\u001a\u00020\u0005H\u0087 J\t\u0010%\u001a\u00020\u0005H\u0087 J\t\u0010&\u001a\u00020\u0005H\u0087 J\t\u0010'\u001a\u00020\u0005H\u0087 J\t\u0010(\u001a\u00020\u0005H\u0087 J\t\u0010)\u001a\u00020\u0005H\u0087 J\t\u0010*\u001a\u00020\u0005H\u0087 J\t\u0010+\u001a\u00020\u0005H\u0087 J\t\u0010,\u001a\u00020\u0005H\u0087 J\t\u0010-\u001a\u00020\u0005H\u0087 J\t\u0010.\u001a\u00020\u0005H\u0087 J\t\u0010/\u001a\u00020\u0005H\u0087 J\t\u00100\u001a\u00020\u0005H\u0087 J\t\u00101\u001a\u00020\u0005H\u0087 J\t\u00102\u001a\u00020\u0005H\u0087 J\t\u00103\u001a\u00020\u0005H\u0087 J\t\u00104\u001a\u00020\u0005H\u0087 J\t\u00105\u001a\u00020\u0005H\u0087 J\t\u00106\u001a\u00020\u0005H\u0087 J\t\u00107\u001a\u00020\u0005H\u0087 J\t\u00108\u001a\u00020\u0005H\u0087 J\t\u00109\u001a\u00020\u0005H\u0087 J\t\u0010:\u001a\u00020\u0005H\u0087 J\t\u0010;\u001a\u00020\u0005H\u0087 J\t\u0010<\u001a\u00020\u0005H\u0087 J\t\u0010=\u001a\u00020\u0005H\u0087 J\t\u0010>\u001a\u00020\u0005H\u0087 J\t\u0010?\u001a\u00020\u0005H\u0087 J\t\u0010@\u001a\u00020\u0005H\u0087 J\t\u0010A\u001a\u00020\u0005H\u0087 J\t\u0010B\u001a\u00020\u0005H\u0087 J\t\u0010C\u001a\u00020\u0005H\u0087 J\t\u0010D\u001a\u00020\u0005H\u0087 J\t\u0010E\u001a\u00020\u0005H\u0087 J\t\u0010F\u001a\u00020GH\u0087 J\t\u0010H\u001a\u00020\u0005H\u0087 J\t\u0010I\u001a\u00020\u0005H\u0087 J\t\u0010J\u001a\u00020\u0005H\u0087 J\t\u0010K\u001a\u00020\u0005H\u0087 J\t\u0010L\u001a\u00020\u0005H\u0087 J\t\u0010M\u001a\u00020\u0005H\u0087 J\t\u0010N\u001a\u00020\u0005H\u0087 J\t\u0010O\u001a\u00020\u0005H\u0087 J\t\u0010P\u001a\u00020\u0005H\u0087 J\t\u0010Q\u001a\u00020\u0005H\u0087 J\t\u0010R\u001a\u00020\u0005H\u0087 J\t\u0010S\u001a\u00020\u0005H\u0087 J\t\u0010T\u001a\u00020\u0005H\u0087 J\t\u0010U\u001a\u00020\u0005H\u0087 J\t\u0010V\u001a\u00020\u0005H\u0087 J\t\u0010W\u001a\u00020\u0005H\u0087 J\t\u0010X\u001a\u00020\u0005H\u0087 J\t\u0010Y\u001a\u00020\u0005H\u0087 J\t\u0010Z\u001a\u00020\u0005H\u0087 J\t\u0010[\u001a\u00020\u0005H\u0087 J\t\u0010\\\u001a\u00020\u0005H\u0087 J\t\u0010]\u001a\u00020GH\u0087 J\t\u0010^\u001a\u00020GH\u0087 J\t\u0010_\u001a\u00020GH\u0087 J\u0011\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0001H\u0087 J\t\u0010c\u001a\u00020aH\u0087 J\u0013\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010b\u001a\u00020\u0001H\u0087 ¨\u0006f"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsCxxInterop;", "", "<init>", "()V", "commonTestFlag", "", "cdpInteractionMetricsEnabled", "cxxNativeAnimatedEnabled", "cxxNativeAnimatedRemoveJsSync", "disableEarlyViewCommandExecution", "disableFabricCommitInCXXAnimated", "disableMountItemReorderingAndroid", "disableOldAndroidAttachmentMetricsWorkarounds", "disableTextLayoutManagerCacheAndroid", "enableAccessibilityOrder", "enableAccumulatedUpdatesInRawPropsAndroid", "enableAndroidLinearText", "enableAndroidTextMeasurementOptimizations", "enableBridgelessArchitecture", "enableCppPropsIteratorSetter", "enableCustomFocusSearchOnClippedElementsAndroid", "enableDestroyShadowTreeRevisionAsync", "enableDoubleMeasurementFixAndroid", "enableEagerMainQueueModulesOnIOS", "enableEagerRootViewAttachment", "enableFabricLogs", "enableFabricRenderer", "enableFontScaleChangesUpdatingLayout", "enableIOSTextBaselineOffsetPerLine", "enableIOSViewClipToPaddingBox", "enableImagePrefetchingAndroid", "enableImagePrefetchingOnUiThreadAndroid", "enableImmediateUpdateModeForContentOffsetChanges", "enableImperativeFocus", "enableInteropViewManagerClassLookUpOptimizationIOS", "enableIntersectionObserverByDefault", "enableKeyEvents", "enableLayoutAnimationsOnAndroid", "enableLayoutAnimationsOnIOS", "enableMainQueueCoordinatorOnIOS", "enableModuleArgumentNSNullConversionIOS", "enableMutationObserverByDefault", "enableNativeCSSParsing", "enableNetworkEventReporting", "enablePreparedTextLayout", "enablePropsUpdateReconciliationAndroid", "enableResourceTimingAPI", "enableSwiftUIBasedFilters", "enableViewCulling", "enableViewRecycling", "enableViewRecyclingForImage", "enableViewRecyclingForScrollView", "enableViewRecyclingForText", "enableViewRecyclingForView", "enableVirtualViewClippingWithoutScrollViewClipping", "enableVirtualViewContainerStateExperimental", "enableVirtualViewDebugFeatures", "enableVirtualViewRenderState", "enableVirtualViewWindowFocusDetection", "enableWebPerformanceAPIsByDefault", "fixMappingOfEventPrioritiesBetweenFabricAndReact", "fuseboxAssertSingleHostState", "fuseboxEnabledRelease", "fuseboxFrameRecordingEnabled", "fuseboxNetworkInspectionEnabled", "fuseboxScreenshotCaptureEnabled", "hideOffscreenVirtualViewsOnIOS", "overrideBySynchronousMountPropsAtMountingAndroid", "perfIssuesEnabled", "perfMonitorV2Enabled", "preparedTextCacheSize", "", "preventShadowTreeCommitExhaustion", "redBoxV2Android", "redBoxV2IOS", "shouldPressibilityUseW3CPointerEventsForHover", "shouldTriggerResponderTransferOnScrollAndroid", "skipActivityIdentityAssertionOnHostPause", "sweepActiveTouchOnChildNativeGesturesAndroid", "traceTurboModulePromiseRejectionsOnAndroid", "updateRuntimeShadowNodeReferencesOnCommit", "useAlwaysAvailableJSErrorHandling", "useFabricInterop", "useNativeEqualsInNativeReadableArrayAndroid", "useNativeTransformHelperAndroid", "useNativeViewConfigsInBridgelessMode", "useOptimizedEventBatchingOnAndroid", "useRawPropsJsiValue", "useShadowNodeStateOnClone", "useSharedAnimatedBackend", "useTraitHiddenOnAndroid", "useTurboModuleInterop", "useTurboModules", "viewCullingOutsetRatio", "virtualViewHysteresisRatio", "virtualViewPrerenderRatio", "override", "", "provider", "dangerouslyReset", "dangerouslyForceOverride", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeFeatureFlagsCxxInterop {
    public static final ReactNativeFeatureFlagsCxxInterop INSTANCE = new ReactNativeFeatureFlagsCxxInterop();

    @DoNotStrip
    public static final native boolean cdpInteractionMetricsEnabled();

    @DoNotStrip
    public static final native boolean commonTestFlag();

    @DoNotStrip
    public static final native boolean cxxNativeAnimatedEnabled();

    @DoNotStrip
    public static final native boolean cxxNativeAnimatedRemoveJsSync();

    @DoNotStrip
    public static final native String dangerouslyForceOverride(Object provider);

    @DoNotStrip
    public static final native void dangerouslyReset();

    @DoNotStrip
    public static final native boolean disableEarlyViewCommandExecution();

    @DoNotStrip
    public static final native boolean disableFabricCommitInCXXAnimated();

    @DoNotStrip
    public static final native boolean disableMountItemReorderingAndroid();

    @DoNotStrip
    public static final native boolean disableOldAndroidAttachmentMetricsWorkarounds();

    @DoNotStrip
    public static final native boolean disableTextLayoutManagerCacheAndroid();

    @DoNotStrip
    public static final native boolean enableAccessibilityOrder();

    @DoNotStrip
    public static final native boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @DoNotStrip
    public static final native boolean enableAndroidLinearText();

    @DoNotStrip
    public static final native boolean enableAndroidTextMeasurementOptimizations();

    @DoNotStrip
    public static final native boolean enableBridgelessArchitecture();

    @DoNotStrip
    public static final native boolean enableCppPropsIteratorSetter();

    @DoNotStrip
    public static final native boolean enableCustomFocusSearchOnClippedElementsAndroid();

    @DoNotStrip
    public static final native boolean enableDestroyShadowTreeRevisionAsync();

    @DoNotStrip
    public static final native boolean enableDoubleMeasurementFixAndroid();

    @DoNotStrip
    public static final native boolean enableEagerMainQueueModulesOnIOS();

    @DoNotStrip
    public static final native boolean enableEagerRootViewAttachment();

    @DoNotStrip
    public static final native boolean enableFabricLogs();

    @DoNotStrip
    public static final native boolean enableFabricRenderer();

    @DoNotStrip
    public static final native boolean enableFontScaleChangesUpdatingLayout();

    @DoNotStrip
    public static final native boolean enableIOSTextBaselineOffsetPerLine();

    @DoNotStrip
    public static final native boolean enableIOSViewClipToPaddingBox();

    @DoNotStrip
    public static final native boolean enableImagePrefetchingAndroid();

    @DoNotStrip
    public static final native boolean enableImagePrefetchingOnUiThreadAndroid();

    @DoNotStrip
    public static final native boolean enableImmediateUpdateModeForContentOffsetChanges();

    @DoNotStrip
    public static final native boolean enableImperativeFocus();

    @DoNotStrip
    public static final native boolean enableInteropViewManagerClassLookUpOptimizationIOS();

    @DoNotStrip
    public static final native boolean enableIntersectionObserverByDefault();

    @DoNotStrip
    public static final native boolean enableKeyEvents();

    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnAndroid();

    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnIOS();

    @DoNotStrip
    public static final native boolean enableMainQueueCoordinatorOnIOS();

    @DoNotStrip
    public static final native boolean enableModuleArgumentNSNullConversionIOS();

    @DoNotStrip
    public static final native boolean enableMutationObserverByDefault();

    @DoNotStrip
    public static final native boolean enableNativeCSSParsing();

    @DoNotStrip
    public static final native boolean enableNetworkEventReporting();

    @DoNotStrip
    public static final native boolean enablePreparedTextLayout();

    @DoNotStrip
    public static final native boolean enablePropsUpdateReconciliationAndroid();

    @DoNotStrip
    public static final native boolean enableResourceTimingAPI();

    @DoNotStrip
    public static final native boolean enableSwiftUIBasedFilters();

    @DoNotStrip
    public static final native boolean enableViewCulling();

    @DoNotStrip
    public static final native boolean enableViewRecycling();

    @DoNotStrip
    public static final native boolean enableViewRecyclingForImage();

    @DoNotStrip
    public static final native boolean enableViewRecyclingForScrollView();

    @DoNotStrip
    public static final native boolean enableViewRecyclingForText();

    @DoNotStrip
    public static final native boolean enableViewRecyclingForView();

    @DoNotStrip
    public static final native boolean enableVirtualViewClippingWithoutScrollViewClipping();

    @DoNotStrip
    public static final native boolean enableVirtualViewContainerStateExperimental();

    @DoNotStrip
    public static final native boolean enableVirtualViewDebugFeatures();

    @DoNotStrip
    public static final native boolean enableVirtualViewRenderState();

    @DoNotStrip
    public static final native boolean enableVirtualViewWindowFocusDetection();

    @DoNotStrip
    public static final native boolean enableWebPerformanceAPIsByDefault();

    @DoNotStrip
    public static final native boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @DoNotStrip
    public static final native boolean fuseboxAssertSingleHostState();

    @DoNotStrip
    public static final native boolean fuseboxEnabledRelease();

    @DoNotStrip
    public static final native boolean fuseboxFrameRecordingEnabled();

    @DoNotStrip
    public static final native boolean fuseboxNetworkInspectionEnabled();

    @DoNotStrip
    public static final native boolean fuseboxScreenshotCaptureEnabled();

    @DoNotStrip
    public static final native boolean hideOffscreenVirtualViewsOnIOS();

    @DoNotStrip
    public static final native void override(Object provider);

    @DoNotStrip
    public static final native boolean overrideBySynchronousMountPropsAtMountingAndroid();

    @DoNotStrip
    public static final native boolean perfIssuesEnabled();

    @DoNotStrip
    public static final native boolean perfMonitorV2Enabled();

    @DoNotStrip
    public static final native double preparedTextCacheSize();

    @DoNotStrip
    public static final native boolean preventShadowTreeCommitExhaustion();

    @DoNotStrip
    public static final native boolean redBoxV2Android();

    @DoNotStrip
    public static final native boolean redBoxV2IOS();

    @DoNotStrip
    public static final native boolean shouldPressibilityUseW3CPointerEventsForHover();

    @DoNotStrip
    public static final native boolean shouldTriggerResponderTransferOnScrollAndroid();

    @DoNotStrip
    public static final native boolean skipActivityIdentityAssertionOnHostPause();

    @DoNotStrip
    public static final native boolean sweepActiveTouchOnChildNativeGesturesAndroid();

    @DoNotStrip
    public static final native boolean traceTurboModulePromiseRejectionsOnAndroid();

    @DoNotStrip
    public static final native boolean updateRuntimeShadowNodeReferencesOnCommit();

    @DoNotStrip
    public static final native boolean useAlwaysAvailableJSErrorHandling();

    @DoNotStrip
    public static final native boolean useFabricInterop();

    @DoNotStrip
    public static final native boolean useNativeEqualsInNativeReadableArrayAndroid();

    @DoNotStrip
    public static final native boolean useNativeTransformHelperAndroid();

    @DoNotStrip
    public static final native boolean useNativeViewConfigsInBridgelessMode();

    @DoNotStrip
    public static final native boolean useOptimizedEventBatchingOnAndroid();

    @DoNotStrip
    public static final native boolean useRawPropsJsiValue();

    @DoNotStrip
    public static final native boolean useShadowNodeStateOnClone();

    @DoNotStrip
    public static final native boolean useSharedAnimatedBackend();

    @DoNotStrip
    public static final native boolean useTraitHiddenOnAndroid();

    @DoNotStrip
    public static final native boolean useTurboModuleInterop();

    @DoNotStrip
    public static final native boolean useTurboModules();

    @DoNotStrip
    public static final native double viewCullingOutsetRatio();

    @DoNotStrip
    public static final native double virtualViewHysteresisRatio();

    @DoNotStrip
    public static final native double virtualViewPrerenderRatio();

    private ReactNativeFeatureFlagsCxxInterop() {
    }

    static {
        SoLoader.loadLibrary("react_featureflagsjni");
    }
}
