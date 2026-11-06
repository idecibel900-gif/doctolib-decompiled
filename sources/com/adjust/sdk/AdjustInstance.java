package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private OnDeeplinkResolvedListener cachedDeeplinkResolutionCallback;
    private String gdprPath;
    private String purchaseVerificationPath;
    private String pushToken;
    private String subscriptionPath;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private PreLaunchActions preLaunchActions = new PreLaunchActions();
    private final ArrayList<OnAdidReadListener> cachedAdidReadCallbacks = new ArrayList<>();
    private final ArrayList<AdjustTimeoutCallback> cachedAdidReadTimeoutCallbacks = new ArrayList<>();
    private final ArrayList<OnAttributionReadListener> cachedAttributionReadCallbacks = new ArrayList<>();
    private final ArrayList<AdjustTimeoutCallback> cachedAttributionReadTimeoutCallbacks = new ArrayList<>();
    private final ArrayList<AdjustTimeoutCallback> cachedThirdPartySharingTimeoutCallbacks = new ArrayList<>();

    public static class PreLaunchActions {
        public List<IRunActivityHandler> preLaunchActionsArray = new ArrayList();
    }

    private void cacheDeeplink(Uri uri, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).cacheDeeplink(uri);
    }

    private boolean checkActivityHandler(String str) {
        return checkActivityHandler(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCachedDeeplink(Context context) {
        return SharedPreferencesManager.getDefaultInstance(context).getCachedDeeplink();
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDeeplink(AdjustDeeplink adjustDeeplink, long j, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveDeeplink(adjustDeeplink, j);
    }

    private void saveGdprForgetMe(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setGdprForgetMe();
    }

    private void savePreinstallReferrer(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePreinstallReferrer(str);
    }

    private void savePushToken(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePushToken(str);
    }

    private void saveRawReferrer(String str, long j, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveRawReferrer(str, j);
    }

    private void setSendingReferrersAsNotSent(final Context context) {
        new SingleThreadCachedScheduler("AdjustInstance").submit(new Runnable() { // from class: com.adjust.sdk.AdjustInstance$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferencesManager.getDefaultInstance(context).setSendingReferrersAsNotSent();
            }
        });
    }

    public void addGlobalCallbackParameter(final String str, final String str2) {
        if (checkActivityHandler("adding global callback parameter", true)) {
            this.activityHandler.addGlobalCallbackParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.2
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.addGlobalCallbackParameterI(str, str2);
                }
            });
        }
    }

    public void addGlobalPartnerParameter(final String str, final String str2) {
        if (checkActivityHandler("adding global partner parameter", true)) {
            this.activityHandler.addGlobalPartnerParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.3
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.addGlobalPartnerParameterI(str, str2);
                }
            });
        }
    }

    public void disable() {
        this.startEnabled = Boolean.FALSE;
        if (checkActivityHandler(false, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(false);
        }
    }

    public void disableCoppaComplianceInDelay() {
        if (checkActivityHandler("disableCoppaComplianceInDelay")) {
            this.activityHandler.setCoppaComplianceInDelay(false);
        }
    }

    public void disablePlayStoreKidsComplianceInDelay() {
        if (checkActivityHandler("disablePlayStoreKidsComplianceInDelay")) {
            this.activityHandler.setPlayStoreKidsComplianceInDelay(false);
        }
    }

    public void enable() {
        this.startEnabled = Boolean.TRUE;
        if (checkActivityHandler(true, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(true);
        }
    }

    public void enableCoppaComplianceInDelay() {
        if (checkActivityHandler("enableCoppaComplianceInDelay")) {
            this.activityHandler.setCoppaComplianceInDelay(true);
        }
    }

    public void enablePlayStoreKidsComplianceInDelay() {
        if (checkActivityHandler("enablePlayStoreKidsComplianceInDelay")) {
            this.activityHandler.setPlayStoreKidsComplianceInDelay(true);
        }
    }

    public void endFirstSessionDelay() {
        if (checkActivityHandler("endFirstSessionDelay")) {
            this.activityHandler.endFirstSessionDelay();
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (checkActivityHandler("gdpr", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.gdprForgetMe();
        }
    }

    public void getAdid(OnAdidReadListener onAdidReadListener) {
        if (checkActivityHandler("getAdid")) {
            this.activityHandler.getAdid(onAdidReadListener);
        } else {
            this.cachedAdidReadCallbacks.add(onAdidReadListener);
        }
    }

    public void getAdidWithTimeout(final Context context, final long j, final OnAdidReadListener onAdidReadListener) {
        if (checkActivityHandler("getAdidWithTimeout")) {
            this.activityHandler.getAdidWithTimeout(j, onAdidReadListener);
        } else {
            new SingleThreadCachedScheduler("getAdidWithTimeout").submit(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.8
                @Override // java.lang.Runnable
                public final void run() {
                    final String adidFromActivityStateFile = Util.getAdidFromActivityStateFile(context);
                    if (adidFromActivityStateFile != null) {
                        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.8.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                onAdidReadListener.onAdidRead(adidFromActivityStateFile);
                            }
                        });
                    } else {
                        ActivityHandler.queueGetAdidWithTimeout(j, onAdidReadListener, AdjustInstance.this.cachedAdidReadTimeoutCallbacks, context);
                    }
                }
            });
        }
    }

    public void getAmazonAdId(Context context, OnAmazonAdIdReadListener onAmazonAdIdReadListener) {
        DeviceInfo.getFireAdvertisingIdBypassConditions(context.getContentResolver(), onAmazonAdIdReadListener);
    }

    public void getAttribution(OnAttributionReadListener onAttributionReadListener) {
        if (checkActivityHandler("getAttribution")) {
            this.activityHandler.getAttribution(onAttributionReadListener);
        } else {
            this.cachedAttributionReadCallbacks.add(onAttributionReadListener);
        }
    }

    public void getAttributionWithTimeout(final Context context, final long j, final OnAttributionReadListener onAttributionReadListener) {
        if (checkActivityHandler("getAttributionWithTimeout")) {
            this.activityHandler.getAttributionWithTimeout(j, onAttributionReadListener);
        } else {
            new SingleThreadCachedScheduler("getAttributionWithTimeout").submit(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.9
                @Override // java.lang.Runnable
                public final void run() {
                    final AdjustAttribution attributionFromAttributionFile = Util.getAttributionFromAttributionFile(context);
                    if (attributionFromAttributionFile != null) {
                        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.9.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                onAttributionReadListener.onAttributionRead(attributionFromAttributionFile);
                            }
                        });
                    } else {
                        ActivityHandler.queueGetAttributionWithTimeout(j, onAttributionReadListener, AdjustInstance.this.cachedAttributionReadTimeoutCallbacks, context);
                    }
                }
            });
        }
    }

    public void getGooglePlayInstallReferrer(Context context, final OnGooglePlayInstallReferrerReadListener onGooglePlayInstallReferrerReadListener) {
        new InstallReferrer(context, new InstallReferrerReadListener() { // from class: com.adjust.sdk.AdjustInstance.12
            @Override // com.adjust.sdk.InstallReferrerReadListener
            public final void onFail(String str) {
                onGooglePlayInstallReferrerReadListener.onFail(str);
            }

            @Override // com.adjust.sdk.InstallReferrerReadListener
            public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
                onGooglePlayInstallReferrerReadListener.onInstallReferrerRead(new GooglePlayInstallReferrerDetails(referrerDetails));
            }
        }).startConnection();
    }

    public void getLastDeeplink(final Context context, final OnLastDeeplinkReadListener onLastDeeplinkReadListener) {
        new AsyncTaskExecutor() { // from class: com.adjust.sdk.AdjustInstance.13
            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final Object doInBackground(Object[] objArr) {
                try {
                    return Uri.parse(AdjustInstance.this.getCachedDeeplink(context));
                } catch (Exception unused) {
                    return null;
                }
            }

            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final void onPostExecute(Object obj) {
                onLastDeeplinkReadListener.onLastDeeplinkRead((Uri) obj);
            }
        }.execute(new Void[0]);
    }

    public void getSdkVersion(final OnSdkVersionReadListener onSdkVersionReadListener) {
        new AsyncTaskExecutor() { // from class: com.adjust.sdk.AdjustInstance.11
            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final Object doInBackground(Object[] objArr) {
                return Util.getSdkVersion();
            }

            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final void onPostExecute(Object obj) {
                onSdkVersionReadListener.onSdkVersionRead((String) obj);
            }
        }.execute(new Void[0]);
    }

    public void getThirdPartySharingSettingsWithTimeout(final Context context, final long j, final OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener) {
        if (checkActivityHandler("getThirdPartySharingSettings")) {
            this.activityHandler.getThirdPartySharingSettingsWithTimeout(j, onThirdPartySharingSettingsReadListener);
        } else {
            new SingleThreadCachedScheduler("getThirdPartySharingSettings").submit(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.10
                @Override // java.lang.Runnable
                public final void run() {
                    final AdjustThirdPartySharingResult thirdPartySharingResult = SharedPreferencesManager.getDefaultInstance(context).getThirdPartySharingResult();
                    if (thirdPartySharingResult != null) {
                        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.adjust.sdk.AdjustInstance.10.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                onThirdPartySharingSettingsReadListener.onThirdPartySharingSettingsRead(thirdPartySharingResult);
                            }
                        });
                    } else {
                        ActivityHandler.queueGetThirdPartySharingSettingsWithTimeout(j, onThirdPartySharingSettingsReadListener, AdjustInstance.this.cachedThirdPartySharingTimeoutCallbacks, context);
                    }
                }
            });
        }
    }

    public void initSdk(AdjustConfig adjustConfig) {
        if (!AdjustSigner.isPresent()) {
            AdjustFactory.getLogger().error("Missing signature library, SDK can't be initialised", new Object[0]);
            return;
        }
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return;
        }
        if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
            return;
        }
        adjustConfig.preLaunchActions = this.preLaunchActions;
        adjustConfig.pushToken = this.pushToken;
        adjustConfig.startEnabled = this.startEnabled;
        adjustConfig.startOffline = this.startOffline;
        adjustConfig.basePath = this.basePath;
        adjustConfig.gdprPath = this.gdprPath;
        adjustConfig.subscriptionPath = this.subscriptionPath;
        adjustConfig.purchaseVerificationPath = this.purchaseVerificationPath;
        adjustConfig.cachedDeeplinkResolutionCallback = this.cachedDeeplinkResolutionCallback;
        adjustConfig.cachedAdidReadCallbacks = this.cachedAdidReadCallbacks;
        adjustConfig.cachedAdidReadTimeoutCallbacks = this.cachedAdidReadTimeoutCallbacks;
        adjustConfig.cachedAttributionReadCallbacks = this.cachedAttributionReadCallbacks;
        adjustConfig.cachedAttributionReadTimeoutCallbacks = this.cachedAttributionReadTimeoutCallbacks;
        adjustConfig.cachedThirdPartySharingTimeoutCallbacks = this.cachedThirdPartySharingTimeoutCallbacks;
        this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
        setSendingReferrersAsNotSent(adjustConfig.context);
    }

    public void isEnabled(Context context, final OnIsEnabledListener onIsEnabledListener) {
        if (checkActivityHandler("isEnabled")) {
            this.activityHandler.isEnabled(onIsEnabledListener);
        } else {
            new AsyncTaskExecutor() { // from class: com.adjust.sdk.AdjustInstance.1
                @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
                public final Object doInBackground(Object[] objArr) {
                    return Boolean.valueOf(Util.isEnabledFromActivityStateFile(((Context[]) objArr)[0]));
                }

                @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
                public final void onPostExecute(Object obj) {
                    onIsEnabledListener.onIsEnabledRead(((Boolean) obj).booleanValue());
                }
            }.execute(context);
        }
    }

    public void onPause() {
        if (checkActivityHandler("onPause")) {
            this.activityHandler.onPause();
        }
    }

    public void onResume() {
        if (checkActivityHandler("onResume")) {
            this.activityHandler.onResume();
        }
    }

    public void processAndResolveDeeplink(AdjustDeeplink adjustDeeplink, Context context, OnDeeplinkResolvedListener onDeeplinkResolvedListener) {
        if (adjustDeeplink == null || !adjustDeeplink.isValid()) {
            AdjustFactory.getLogger().warn("Skipping deeplink processing (null or empty)", new Object[0]);
            return;
        }
        if (onDeeplinkResolvedListener == null) {
            processDeeplink(adjustDeeplink, context);
            return;
        }
        cacheDeeplink(adjustDeeplink.url, context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (checkActivityHandler("processAndResolveDeeplink", true)) {
            this.activityHandler.processAndResolveDeeplink(adjustDeeplink, jCurrentTimeMillis, onDeeplinkResolvedListener);
        } else {
            saveDeeplink(adjustDeeplink, jCurrentTimeMillis, context);
            this.cachedDeeplinkResolutionCallback = onDeeplinkResolvedListener;
        }
    }

    public void processDeeplink(AdjustDeeplink adjustDeeplink, Context context) {
        if (adjustDeeplink == null || !adjustDeeplink.isValid()) {
            AdjustFactory.getLogger().warn("Skipping deeplink processing (null or empty)", new Object[0]);
            return;
        }
        cacheDeeplink(adjustDeeplink.url, context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (checkActivityHandler("processDeeplink", true)) {
            this.activityHandler.processDeeplink(adjustDeeplink, jCurrentTimeMillis);
        } else {
            saveDeeplink(adjustDeeplink, jCurrentTimeMillis, context);
        }
    }

    public void removeGlobalCallbackParameter(final String str) {
        if (checkActivityHandler("removing global callback parameter", true)) {
            this.activityHandler.removeGlobalCallbackParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.4
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.removeGlobalCallbackParameterI(str);
                }
            });
        }
    }

    public void removeGlobalCallbackParameters() {
        if (checkActivityHandler("resetting global callback parameters", true)) {
            this.activityHandler.removeGlobalCallbackParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.6
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.removeGlobalCallbackParametersI();
                }
            });
        }
    }

    public void removeGlobalPartnerParameter(final String str) {
        if (checkActivityHandler("removing global partner parameter", true)) {
            this.activityHandler.removeGlobalPartnerParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.5
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.removeGlobalPartnerParameterI(str);
                }
            });
        }
    }

    public void removeGlobalPartnerParameters() {
        if (checkActivityHandler("resetting global partner parameters", true)) {
            this.activityHandler.removeGlobalPartnerParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.7
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.removeGlobalPartnerParametersI();
                }
            });
        }
    }

    public void sendPreinstallReferrer(String str, Context context) {
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping SYSTEM_INSTALLER_REFERRER preinstall referrer processing (null or empty)", new Object[0]);
            return;
        }
        savePreinstallReferrer(str, context);
        if (checkActivityHandler("preinstall referrer", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendPreinstallReferrer();
        }
    }

    public void sendReferrer(String str, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping INSTALL_REFERRER intent referrer processing (null or empty)", new Object[0]);
            return;
        }
        saveRawReferrer(str, jCurrentTimeMillis, context);
        if (checkActivityHandler(Constants.REFERRER, true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendReftagReferrer();
        }
    }

    public void setExternalDeviceIdInDelay(String str) {
        if (checkActivityHandler("setExternalDeviceIdInDelay")) {
            this.activityHandler.setExternalDeviceIdInDelay(str);
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (checkActivityHandler("push token", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.setPushToken(str, true);
        }
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        String str = adjustTestOptions.basePath;
        if (str != null) {
            this.basePath = str;
        }
        String str2 = adjustTestOptions.gdprPath;
        if (str2 != null) {
            this.gdprPath = str2;
        }
        String str3 = adjustTestOptions.subscriptionPath;
        if (str3 != null) {
            this.subscriptionPath = str3;
        }
        String str4 = adjustTestOptions.purchaseVerificationPath;
        if (str4 != null) {
            this.purchaseVerificationPath = str4;
        }
        String str5 = adjustTestOptions.baseUrl;
        if (str5 != null) {
            AdjustFactory.setBaseUrl(str5);
        }
        String str6 = adjustTestOptions.gdprUrl;
        if (str6 != null) {
            AdjustFactory.setGdprUrl(str6);
        }
        String str7 = adjustTestOptions.subscriptionUrl;
        if (str7 != null) {
            AdjustFactory.setSubscriptionUrl(str7);
        }
        String str8 = adjustTestOptions.purchaseVerificationUrl;
        if (str8 != null) {
            AdjustFactory.setPurchaseVerificationUrl(str8);
        }
        Long l = adjustTestOptions.timerIntervalInMilliseconds;
        if (l != null) {
            AdjustFactory.setTimerInterval(l.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        Long l2 = adjustTestOptions.sessionIntervalInMilliseconds;
        if (l2 != null) {
            AdjustFactory.setSessionInterval(l2.longValue());
        }
        Long l3 = adjustTestOptions.subsessionIntervalInMilliseconds;
        if (l3 != null) {
            AdjustFactory.setSubsessionInterval(l3.longValue());
        }
        Boolean bool = adjustTestOptions.tryInstallReferrer;
        if (bool != null) {
            AdjustFactory.setTryInstallReferrer(bool.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            BackoffStrategy backoffStrategy = BackoffStrategy.NO_WAIT;
            AdjustFactory.setPackageHandlerBackoffStrategy(backoffStrategy);
            AdjustFactory.setSdkClickBackoffStrategy(backoffStrategy);
        }
        Boolean bool2 = adjustTestOptions.ignoreSystemLifecycleBootstrap;
        if (bool2 != null) {
            AdjustFactory.setIgnoreSystemLifecycleBootstrap(bool2.booleanValue());
        }
        Boolean bool3 = adjustTestOptions.allowUrlStrategyFallback;
        if (bool3 != null) {
            AdjustFactory.setAllowUrlStrategyFallback(bool3.booleanValue());
        }
    }

    public void switchBackToOnlineMode() {
        if (checkActivityHandler(false, "offline mode", "online mode")) {
            this.activityHandler.setOfflineMode(false);
        } else {
            this.startOffline = false;
        }
    }

    public void switchToOfflineMode() {
        if (checkActivityHandler(true, "offline mode", "online mode")) {
            this.activityHandler.setOfflineMode(true);
        } else {
            this.startOffline = true;
        }
    }

    public void teardown() {
        if (checkActivityHandler("teardown")) {
            this.activityHandler.teardown();
            this.activityHandler = null;
        }
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(adjustAdRevenue);
        }
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (checkActivityHandler("trackEvent")) {
            this.activityHandler.trackEvent(adjustEvent);
        }
    }

    public void trackMeasurementConsent(final boolean z) {
        if (checkActivityHandler("measurement consent", true)) {
            this.activityHandler.trackMeasurementConsent(z);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance$$ExternalSyntheticLambda2
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.tryTrackMeasurementConsentI(z);
                }
            });
        }
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityHandler("trackPlayStoreSubscription")) {
            this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
        }
    }

    public void trackThirdPartySharing(final AdjustThirdPartySharing adjustThirdPartySharing) {
        if (checkActivityHandler("third party sharing", true)) {
            this.activityHandler.trackThirdPartySharing(adjustThirdPartySharing);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance$$ExternalSyntheticLambda0
                @Override // com.adjust.sdk.IRunActivityHandler
                public final void run(ActivityHandler activityHandler) {
                    activityHandler.tryTrackThirdPartySharingI(adjustThirdPartySharing);
                }
            });
        }
    }

    public void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (checkActivityHandler("verifyAndTrack")) {
            this.activityHandler.verifyAndTrackPlayStorePurchase(adjustEvent, onPurchaseVerificationFinishedListener);
        } else if (onPurchaseVerificationFinishedListener != null) {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 100, "SDK needs to be initialized before making purchase verification request"));
        }
    }

    public void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (checkActivityHandler("verifyPurchase")) {
            this.activityHandler.verifyPlayStorePurchase(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener);
        } else {
            onPurchaseVerificationFinishedListener.onVerificationFinished(new AdjustPurchaseVerificationResult("not_verified", 100, "SDK needs to be initialized before making purchase verification request"));
        }
    }

    private boolean checkActivityHandler(boolean z, String str, String str2) {
        return z ? checkActivityHandler(str, true) : checkActivityHandler(str2, true);
    }

    private boolean checkActivityHandler(String str, boolean z) {
        if (this.activityHandler != null) {
            return true;
        }
        if (str == null) {
            AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
            return false;
        }
        if (z) {
            AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
        } else {
            AdjustFactory.getLogger().warn("Adjust not initialized, can't perform %s", str);
        }
        return false;
    }
}
