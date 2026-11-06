package io.sentry.android.core;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import io.sentry.SentryFeedbackOptions;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.protocol.SdkVersion;
import io.sentry.util.SampleRateUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAndroidOptions extends SentryOptions {
    private Double anrProfilingSampleRate;
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;
    private BeforeCaptureCallback beforeScreenshotCaptureCallback;
    private BeforeCaptureCallback beforeViewHierarchyCaptureCallback;
    private SentryFrameMetricsCollector frameMetricsCollector;
    private boolean anrEnabled = true;
    private long anrTimeoutIntervalMillis = HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS;
    private boolean anrReportInDebug = false;
    private boolean enableActivityLifecycleBreadcrumbs = true;
    private boolean enableAppLifecycleBreadcrumbs = true;
    private boolean enableSystemEventBreadcrumbs = true;
    private boolean enableAppComponentBreadcrumbs = true;
    private boolean enableNetworkEventBreadcrumbs = true;
    private boolean enableAutoActivityLifecycleTracing = true;
    private boolean enableActivityLifecycleTracingAutoFinish = true;
    private IDebugImagesLoader debugImagesLoader = NoOpDebugImagesLoader.getInstance();
    private boolean collectAdditionalContext = true;
    private boolean collectExternalStorageContext = false;
    private long startupCrashFlushTimeoutMillis = HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS;
    private final long startupCrashDurationThresholdMillis = 2000;
    private boolean enableFramesTracking = true;
    private String nativeSdkName = null;
    private boolean enableRootCheck = true;
    private boolean enableNdk = true;
    private NdkHandlerStrategy ndkHandlerStrategy = NdkHandlerStrategy.SENTRY_HANDLER_STRATEGY_DEFAULT;
    private boolean enableScopeSync = true;
    private boolean enableAutoTraceIdGeneration = true;
    private boolean enableSystemEventBreadcrumbsExtras = false;
    private boolean reportHistoricalAnrs = false;
    private boolean reportHistoricalTombstones = false;
    private boolean attachAnrThreadDump = false;
    private boolean attachRawTombstone = false;
    private boolean enablePerformanceV2 = true;
    private boolean enableTombstone = false;
    private final SentryScreenshotOptions screenshot = new SentryScreenshotOptions();
    private boolean enableAnrFingerprinting = true;

    public interface BeforeCaptureCallback {
    }

    public BeforeCaptureCallback getBeforeScreenshotCaptureCallback() {
        return null;
    }

    public BeforeCaptureCallback getBeforeViewHierarchyCaptureCallback() {
        return null;
    }

    public long getStartupCrashDurationThresholdMillis() {
        return 2000L;
    }

    public void setBeforeScreenshotCaptureCallback(BeforeCaptureCallback beforeCaptureCallback) {
    }

    public void setBeforeViewHierarchyCaptureCallback(BeforeCaptureCallback beforeCaptureCallback) {
    }

    public SentryAndroidOptions() {
        setSentryClientName("sentry.java.android/8.43.0");
        setSdkVersion(createSdkVersion());
        setAttachServerName(false);
    }

    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersionUpdateSdkVersion = SdkVersion.updateSdkVersion(getSdkVersion(), "sentry.java.android", "8.43.0");
        sdkVersionUpdateSdkVersion.addPackage("maven:io.sentry:sentry-android-core", "8.43.0");
        return sdkVersionUpdateSdkVersion;
    }

    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }

    public void setAnrEnabled(boolean z) {
        this.anrEnabled = z;
    }

    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }

    public void setAnrTimeoutIntervalMillis(long j) {
        this.anrTimeoutIntervalMillis = j;
    }

    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }

    public void setAnrReportInDebug(boolean z) {
        this.anrReportInDebug = z;
    }

    public void setTombstoneEnabled(boolean z) {
        this.enableTombstone = z;
    }

    public boolean isTombstoneEnabled() {
        return this.enableTombstone;
    }

    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }

    public void setEnableActivityLifecycleBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
    }

    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public void setEnableAppLifecycleBreadcrumbs(boolean z) {
        this.enableAppLifecycleBreadcrumbs = z;
    }

    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public void setEnableSystemEventBreadcrumbs(boolean z) {
        this.enableSystemEventBreadcrumbs = z;
    }

    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }

    public void setEnableAppComponentBreadcrumbs(boolean z) {
        this.enableAppComponentBreadcrumbs = z;
    }

    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }

    public void setEnableNetworkEventBreadcrumbs(boolean z) {
        this.enableNetworkEventBreadcrumbs = z;
    }

    public void enableAllAutoBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
        this.enableAppComponentBreadcrumbs = z;
        this.enableSystemEventBreadcrumbs = z;
        this.enableAppLifecycleBreadcrumbs = z;
        this.enableNetworkEventBreadcrumbs = z;
        setEnableUserInteractionBreadcrumbs(z);
    }

    public IDebugImagesLoader getDebugImagesLoader() {
        return this.debugImagesLoader;
    }

    public void setDebugImagesLoader(IDebugImagesLoader iDebugImagesLoader) {
        if (iDebugImagesLoader == null) {
            iDebugImagesLoader = NoOpDebugImagesLoader.getInstance();
        }
        this.debugImagesLoader = iDebugImagesLoader;
    }

    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }

    public void setEnableAutoActivityLifecycleTracing(boolean z) {
        this.enableAutoActivityLifecycleTracing = z;
    }

    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }

    public void setEnableActivityLifecycleTracingAutoFinish(boolean z) {
        this.enableActivityLifecycleTracingAutoFinish = z;
    }

    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }

    public void setAttachScreenshot(boolean z) {
        this.attachScreenshot = z;
    }

    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }

    public void setAttachViewHierarchy(boolean z) {
        this.attachViewHierarchy = z;
    }

    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }

    public void setCollectAdditionalContext(boolean z) {
        this.collectAdditionalContext = z;
    }

    public boolean isCollectExternalStorageContext() {
        return this.collectExternalStorageContext;
    }

    public void setCollectExternalStorageContext(boolean z) {
        this.collectExternalStorageContext = z;
    }

    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public void setEnableFramesTracking(boolean z) {
        this.enableFramesTracking = z;
    }

    long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }

    void setStartupCrashFlushTimeoutMillis(long j) {
        this.startupCrashFlushTimeoutMillis = j;
    }

    public void setNativeSdkName(String str) {
        this.nativeSdkName = str;
    }

    public void setNativeHandlerStrategy(NdkHandlerStrategy ndkHandlerStrategy) {
        this.ndkHandlerStrategy = ndkHandlerStrategy;
    }

    public int getNdkHandlerStrategy() {
        return this.ndkHandlerStrategy.getValue();
    }

    public String getNativeSdkName() {
        return this.nativeSdkName;
    }

    public boolean isEnableRootCheck() {
        return this.enableRootCheck;
    }

    public void setEnableRootCheck(boolean z) {
        this.enableRootCheck = z;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public void setEnableNdk(boolean z) {
        this.enableNdk = z;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public void setEnableScopeSync(boolean z) {
        this.enableScopeSync = z;
    }

    public boolean isReportHistoricalAnrs() {
        return this.reportHistoricalAnrs;
    }

    public void setReportHistoricalAnrs(boolean z) {
        this.reportHistoricalAnrs = z;
    }

    public boolean isReportHistoricalTombstones() {
        return this.reportHistoricalTombstones;
    }

    public void setReportHistoricalTombstones(boolean z) {
        this.reportHistoricalTombstones = z;
    }

    public boolean isAttachAnrThreadDump() {
        return this.attachAnrThreadDump;
    }

    public void setAttachAnrThreadDump(boolean z) {
        this.attachAnrThreadDump = z;
    }

    public boolean isAttachRawTombstone() {
        return this.attachRawTombstone;
    }

    public void setAttachRawTombstone(boolean z) {
        this.attachRawTombstone = z;
    }

    public boolean isEnablePerformanceV2() {
        return this.enablePerformanceV2;
    }

    public void setEnablePerformanceV2(boolean z) {
        this.enablePerformanceV2 = z;
    }

    public SentryFrameMetricsCollector getFrameMetricsCollector() {
        return this.frameMetricsCollector;
    }

    public void setFrameMetricsCollector(SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this.frameMetricsCollector = sentryFrameMetricsCollector;
    }

    public boolean isEnableAutoTraceIdGeneration() {
        return this.enableAutoTraceIdGeneration;
    }

    public void setEnableAutoTraceIdGeneration(boolean z) {
        this.enableAutoTraceIdGeneration = z;
    }

    public boolean isEnableSystemEventBreadcrumbsExtras() {
        return this.enableSystemEventBreadcrumbsExtras;
    }

    public void setEnableSystemEventBreadcrumbsExtras(boolean z) {
        this.enableSystemEventBreadcrumbsExtras = z;
    }

    public SentryScreenshotOptions getScreenshot() {
        return this.screenshot;
    }

    public Double getAnrProfilingSampleRate() {
        return this.anrProfilingSampleRate;
    }

    public void setAnrProfilingSampleRate(Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.anrProfilingSampleRate = d;
    }

    public boolean isAnrProfilingEnabled() {
        Double d = this.anrProfilingSampleRate;
        return d != null && d.doubleValue() > 0.0d;
    }

    public boolean isEnableAnrFingerprinting() {
        return this.enableAnrFingerprinting;
    }

    public void setEnableAnrFingerprinting(boolean z) {
        this.enableAnrFingerprinting = z;
    }

    static class AndroidUserFeedbackFormHandler implements SentryFeedbackOptions.IFormHandler {
        AndroidUserFeedbackFormHandler() {
        }
    }
}
