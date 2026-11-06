package com.adjust.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustConfig {
    public static final String ENVIRONMENT_PRODUCTION = "production";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    String appToken;
    String basePath;
    OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    Context context;
    boolean coppaComplianceEnabled;
    String defaultTracker;
    String environment;
    Integer eventDeduplicationIdsMaxSize;
    String externalDeviceId;
    String fbAppId;
    String gdprPath;
    boolean isAndroidIdReadingEnabled;
    boolean isAppSetIdReadingEnabled;
    Boolean isCostDataInAttributionEnabled;
    boolean isDataResidency;
    boolean isDeviceIdsFromPluginsReadingEnabled;
    boolean isDeviceIdsReadingOnceEnabled;
    boolean isFbIdReadingEnabled;
    boolean isFireAdIdReadingEnabled;
    boolean isFirstSessionDelayEnabled;
    boolean isGoogleAdIdReadingEnabled;
    boolean isPreinstallTrackingEnabled;
    boolean isSendingInBackgroundEnabled;
    ILogger logger;
    OnAttributionChangedListener onAttributionChangedListener;
    OnDeferredDeeplinkResponseListener onDeferredDeeplinkResponseListener;
    OnEventTrackingFailedListener onEventTrackingFailedListener;
    OnEventTrackingSucceededListener onEventTrackingSucceededListener;
    OnRemoteTriggerListener onRemoteTriggerListener;
    OnSessionTrackingFailedListener onSessionTrackingFailedListener;
    OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
    OnThirdPartySharingSettingsChangedListener onThirdPartySharingSettingsChangedListener;
    boolean playStoreKidsComplianceEnabled;
    AdjustInstance.PreLaunchActions preLaunchActions;
    String preinstallFilePath;
    String processName;
    String purchaseVerificationPath;
    String pushToken;
    String sdkPrefix;
    Boolean startEnabled;
    boolean startOffline;
    AdjustStoreInfo storeInfo;
    String subscriptionPath;
    List<String> urlStrategyDomains;
    boolean useSubdomains;
    ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    ArrayList<AdjustTimeoutCallback> cachedAdidReadTimeoutCallbacks = new ArrayList<>();
    ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    ArrayList<AdjustTimeoutCallback> cachedAttributionReadTimeoutCallbacks = new ArrayList<>();
    ArrayList<AdjustTimeoutCallback> cachedThirdPartySharingTimeoutCallbacks = new ArrayList<>();

    public AdjustConfig(Context context, String str, String str2) {
        init(context, str, str2, false);
    }

    private boolean checkAppToken(String str) {
        if (str == null) {
            this.logger.error("Missing App Token", new Object[0]);
            return false;
        }
        if (str.length() == 12) {
            return true;
        }
        this.logger.error("Malformed App Token '%s'", str);
        return false;
    }

    private boolean checkContext(Context context) {
        if (context == null) {
            this.logger.error("Missing context", new Object[0]);
            return false;
        }
        if (Util.checkPermission(context, "android.permission.INTERNET")) {
            return true;
        }
        this.logger.error("Missing permission: INTERNET", new Object[0]);
        return false;
    }

    private boolean checkEnvironment(String str) {
        if (str == null) {
            this.logger.error("Missing environment", new Object[0]);
            return false;
        }
        if (str.equals(ENVIRONMENT_SANDBOX)) {
            this.logger.warnInProduction("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        }
        boolean zEquals = str.equals(ENVIRONMENT_PRODUCTION);
        ILogger iLogger = this.logger;
        if (zEquals) {
            iLogger.warnInProduction("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        }
        iLogger.error("Unknown environment '%s'", str);
        return false;
    }

    private void init(Context context, String str, String str2, boolean z) {
        this.logger = AdjustFactory.getLogger();
        if (z && ENVIRONMENT_PRODUCTION.equals(str2)) {
            setLogLevel(LogLevel.SUPPRESS, str2);
        } else {
            setLogLevel(LogLevel.INFO, str2);
        }
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.context = context;
        this.appToken = str;
        this.environment = str2;
        this.isSendingInBackgroundEnabled = false;
        this.isPreinstallTrackingEnabled = false;
        this.isDeviceIdsReadingOnceEnabled = false;
        this.coppaComplianceEnabled = false;
        this.playStoreKidsComplianceEnabled = false;
        this.isFirstSessionDelayEnabled = false;
        this.isGoogleAdIdReadingEnabled = true;
        this.isAndroidIdReadingEnabled = true;
        this.isAppSetIdReadingEnabled = true;
        this.isFbIdReadingEnabled = true;
        this.isFireAdIdReadingEnabled = true;
        this.isDeviceIdsFromPluginsReadingEnabled = true;
    }

    public void disableAndroidIdReading() {
        this.isAndroidIdReadingEnabled = false;
    }

    public void disableAppSetIdReading() {
        this.isAppSetIdReadingEnabled = false;
    }

    public void disableDeviceIdsFromPluginsReading() {
        this.isDeviceIdsFromPluginsReadingEnabled = false;
    }

    public void disableDeviceIdsReading() {
        this.isGoogleAdIdReadingEnabled = false;
        this.isAndroidIdReadingEnabled = false;
        this.isAppSetIdReadingEnabled = false;
        this.isFbIdReadingEnabled = false;
        this.isFireAdIdReadingEnabled = false;
        this.isDeviceIdsFromPluginsReadingEnabled = false;
    }

    public void disableFbIdReading() {
        this.isFbIdReadingEnabled = false;
    }

    public void disableFireAdIdReading() {
        this.isFireAdIdReadingEnabled = false;
    }

    public void disableGoogleAdIdReading() {
        this.isGoogleAdIdReadingEnabled = false;
    }

    public void enableCoppaCompliance() {
        this.coppaComplianceEnabled = true;
    }

    public void enableCostDataInAttribution() {
        this.isCostDataInAttributionEnabled = Boolean.TRUE;
    }

    public void enableDeviceIdsReadingOnce() {
        this.isDeviceIdsReadingOnceEnabled = true;
    }

    public void enableFirstSessionDelay() {
        this.isFirstSessionDelayEnabled = true;
    }

    public void enablePlayStoreKidsCompliance() {
        this.playStoreKidsComplianceEnabled = true;
    }

    public void enablePreinstallTracking() {
        this.isPreinstallTrackingEnabled = true;
    }

    public void enableSendingInBackground() {
        this.isSendingInBackgroundEnabled = true;
    }

    public String getAppToken() {
        return this.appToken;
    }

    public Context getContext() {
        return this.context;
    }

    public Boolean getCostDataInAttributionEnabled() {
        return this.isCostDataInAttributionEnabled;
    }

    public String getDefaultTracker() {
        return this.defaultTracker;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public Integer getEventDeduplicationIdsMaxSize() {
        return this.eventDeduplicationIdsMaxSize;
    }

    public String getExternalDeviceId() {
        return this.externalDeviceId;
    }

    public String getFbAppId() {
        return this.fbAppId;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public OnAttributionChangedListener getOnAttributionChangedListener() {
        return this.onAttributionChangedListener;
    }

    public OnDeferredDeeplinkResponseListener getOnDeeplinkResponseListener() {
        return this.onDeferredDeeplinkResponseListener;
    }

    public OnEventTrackingFailedListener getOnEventTrackingFailedListener() {
        return this.onEventTrackingFailedListener;
    }

    public OnEventTrackingSucceededListener getOnEventTrackingSucceededListener() {
        return this.onEventTrackingSucceededListener;
    }

    public OnRemoteTriggerListener getOnRemoteTriggerListener() {
        return this.onRemoteTriggerListener;
    }

    public OnSessionTrackingFailedListener getOnSessionTrackingFailedListener() {
        return this.onSessionTrackingFailedListener;
    }

    public OnSessionTrackingSucceededListener getOnSessionTrackingSucceededListener() {
        return this.onSessionTrackingSucceededListener;
    }

    public OnThirdPartySharingSettingsChangedListener getOnThirdPartySharingSettingsChangedListener() {
        return this.onThirdPartySharingSettingsChangedListener;
    }

    public String getPreinstallFilePath() {
        return this.preinstallFilePath;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSdkPrefix() {
        return this.sdkPrefix;
    }

    public AdjustStoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    public List<String> getUrlStrategyDomains() {
        return this.urlStrategyDomains;
    }

    public boolean isAndroidIdReadingEnabled() {
        return this.isAndroidIdReadingEnabled;
    }

    public boolean isAppSetIdReadingEnabled() {
        return this.isAppSetIdReadingEnabled;
    }

    public boolean isCoppaComplianceEnabled() {
        return this.coppaComplianceEnabled;
    }

    public boolean isDeviceIdsFromPluginsReadingEnabled() {
        return this.isDeviceIdsFromPluginsReadingEnabled;
    }

    public boolean isDeviceIdsReadingOnceEnabled() {
        return this.isDeviceIdsReadingOnceEnabled;
    }

    public boolean isFbIdReadingEnabled() {
        return this.isFbIdReadingEnabled;
    }

    public boolean isFireAdIdReadingEnabled() {
        return this.isFireAdIdReadingEnabled;
    }

    public boolean isGoogleAdIdReadingEnabled() {
        return this.isGoogleAdIdReadingEnabled;
    }

    public boolean isPlayStoreKidsComplianceEnabled() {
        return this.playStoreKidsComplianceEnabled;
    }

    public boolean isPreinstallTrackingEnabled() {
        return this.isPreinstallTrackingEnabled;
    }

    public boolean isSendingInBackgroundEnabled() {
        return this.isSendingInBackgroundEnabled;
    }

    public boolean isValid() {
        return checkAppToken(this.appToken) && checkEnvironment(this.environment) && checkContext(this.context);
    }

    public void setDefaultTracker(String str) {
        this.defaultTracker = str;
    }

    public void setEventDeduplicationIdsMaxSize(Integer num) {
        this.eventDeduplicationIdsMaxSize = num;
    }

    public void setExternalDeviceId(String str) {
        this.externalDeviceId = str;
    }

    public void setFbAppId(String str) {
        this.fbAppId = str;
    }

    public void setLogLevel(LogLevel logLevel) {
        setLogLevel(logLevel, this.environment);
    }

    public void setOnAttributionChangedListener(OnAttributionChangedListener onAttributionChangedListener) {
        this.onAttributionChangedListener = onAttributionChangedListener;
    }

    public void setOnDeferredDeeplinkResponseListener(OnDeferredDeeplinkResponseListener onDeferredDeeplinkResponseListener) {
        this.onDeferredDeeplinkResponseListener = onDeferredDeeplinkResponseListener;
    }

    public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener onEventTrackingFailedListener) {
        this.onEventTrackingFailedListener = onEventTrackingFailedListener;
    }

    public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener onEventTrackingSucceededListener) {
        this.onEventTrackingSucceededListener = onEventTrackingSucceededListener;
    }

    public void setOnRemoteTriggerListener(OnRemoteTriggerListener onRemoteTriggerListener) {
        this.onRemoteTriggerListener = onRemoteTriggerListener;
    }

    public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener onSessionTrackingFailedListener) {
        this.onSessionTrackingFailedListener = onSessionTrackingFailedListener;
    }

    public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener onSessionTrackingSucceededListener) {
        this.onSessionTrackingSucceededListener = onSessionTrackingSucceededListener;
    }

    public void setOnThirdPartySharingSettingsChangedListener(OnThirdPartySharingSettingsChangedListener onThirdPartySharingSettingsChangedListener) {
        this.onThirdPartySharingSettingsChangedListener = onThirdPartySharingSettingsChangedListener;
    }

    public void setPreinstallFilePath(String str) {
        this.preinstallFilePath = str;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public void setSdkPrefix(String str) {
        this.sdkPrefix = str;
    }

    public void setStoreInfo(AdjustStoreInfo adjustStoreInfo) {
        this.storeInfo = adjustStoreInfo;
    }

    public void setUrlStrategy(List<String> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty()) {
            this.logger.error("Invalid URL strategy domains array", new Object[0]);
            return;
        }
        this.urlStrategyDomains = list;
        this.useSubdomains = z;
        this.isDataResidency = z2;
    }

    private void setLogLevel(LogLevel logLevel, String str) {
        this.logger.setLogLevel(logLevel, ENVIRONMENT_PRODUCTION.equals(str));
    }

    public AdjustConfig(Context context, String str, String str2, boolean z) {
        init(context, str, str2, z);
    }
}
