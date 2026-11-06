package com.adjust.sdk;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Adjust {
    private static AdjustInstance defaultInstance;

    private Adjust() {
    }

    public static void addGlobalCallbackParameter(String str, String str2) {
        getDefaultInstance().addGlobalCallbackParameter(str, str2);
    }

    public static void addGlobalPartnerParameter(String str, String str2) {
        getDefaultInstance().addGlobalPartnerParameter(str, str2);
    }

    public static void disable() {
        getDefaultInstance().disable();
    }

    public static void disableCoppaComplianceInDelay() {
        getDefaultInstance().disableCoppaComplianceInDelay();
    }

    public static void disablePlayStoreKidsComplianceInDelay() {
        getDefaultInstance().disablePlayStoreKidsComplianceInDelay();
    }

    public static void enable() {
        getDefaultInstance().enable();
    }

    public static void enableCoppaComplianceInDelay() {
        getDefaultInstance().enableCoppaComplianceInDelay();
    }

    public static void enablePlayStoreKidsComplianceInDelay() {
        getDefaultInstance().enablePlayStoreKidsComplianceInDelay();
    }

    public static void endFirstSessionDelay() {
        getDefaultInstance().endFirstSessionDelay();
    }

    private static Context extractApplicationContext(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static void gdprForgetMe(Context context) {
        getDefaultInstance().gdprForgetMe(extractApplicationContext(context));
    }

    public static void getAdid(OnAdidReadListener onAdidReadListener) {
        if (onAdidReadListener == null) {
            AdjustFactory.getLogger().error("Callback for getting adid can't be null", new Object[0]);
        } else {
            getDefaultInstance().getAdid(onAdidReadListener);
        }
    }

    public static void getAdidWithTimeout(Context context, long j, OnAdidReadListener onAdidReadListener) {
        if (context == null) {
            AdjustFactory.getLogger().error("Context for getting adid can't be null", new Object[0]);
            return;
        }
        if (j < 0) {
            AdjustFactory.getLogger().error("Timeout value for getting adid can't be negative", new Object[0]);
        } else if (onAdidReadListener == null) {
            AdjustFactory.getLogger().error("Callback for getting adid can't be null", new Object[0]);
        } else {
            getDefaultInstance().getAdidWithTimeout(extractApplicationContext(context), j, onAdidReadListener);
        }
    }

    public static void getAmazonAdId(Context context, OnAmazonAdIdReadListener onAmazonAdIdReadListener) {
        if (onAmazonAdIdReadListener == null) {
            AdjustFactory.getLogger().error("onAmazonAdIdReadListener cannot be null", new Object[0]);
            return;
        }
        Context contextExtractApplicationContext = extractApplicationContext(context);
        if (contextExtractApplicationContext == null) {
            AdjustFactory.getLogger().error("getAmazonAdId: null context", new Object[0]);
        } else {
            getDefaultInstance().getAmazonAdId(contextExtractApplicationContext, onAmazonAdIdReadListener);
        }
    }

    public static void getAttribution(OnAttributionReadListener onAttributionReadListener) {
        if (onAttributionReadListener == null) {
            AdjustFactory.getLogger().error("Callback for getting attribution can't be null", new Object[0]);
        } else {
            getDefaultInstance().getAttribution(onAttributionReadListener);
        }
    }

    public static void getAttributionWithTimeout(Context context, long j, OnAttributionReadListener onAttributionReadListener) {
        if (context == null) {
            AdjustFactory.getLogger().error("Context for getting attribution can't be null", new Object[0]);
            return;
        }
        if (j < 0) {
            AdjustFactory.getLogger().error("Timeout value for getting attribution can't be negative", new Object[0]);
        } else if (onAttributionReadListener == null) {
            AdjustFactory.getLogger().error("Callback for getting attribution can't be null", new Object[0]);
        } else {
            getDefaultInstance().getAttributionWithTimeout(extractApplicationContext(context), j, onAttributionReadListener);
        }
    }

    public static synchronized AdjustInstance getDefaultInstance() {
        try {
            if (defaultInstance == null) {
                defaultInstance = new AdjustInstance();
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultInstance;
    }

    public static void getGoogleAdId(Context context, OnGoogleAdIdReadListener onGoogleAdIdReadListener) {
        if (onGoogleAdIdReadListener == null) {
            AdjustFactory.getLogger().error("onGoogleAdIdReadListener cannot be null", new Object[0]);
        } else if (context == null) {
            AdjustFactory.getLogger().error("getGoogleAdId: null context", new Object[0]);
        } else {
            Util.getGoogleAdId(context.getApplicationContext(), onGoogleAdIdReadListener);
        }
    }

    public static void getGooglePlayInstallReferrer(Context context, OnGooglePlayInstallReferrerReadListener onGooglePlayInstallReferrerReadListener) {
        if (onGooglePlayInstallReferrerReadListener == null) {
            AdjustFactory.getLogger().error("onGooglePlayInstallReferrerReadListener cannot be null", new Object[0]);
        } else if (context == null) {
            AdjustFactory.getLogger().error("null context", new Object[0]);
        } else {
            getDefaultInstance().getGooglePlayInstallReferrer(context, onGooglePlayInstallReferrerReadListener);
        }
    }

    public static void getLastDeeplink(Context context, OnLastDeeplinkReadListener onLastDeeplinkReadListener) {
        if (onLastDeeplinkReadListener == null) {
            AdjustFactory.getLogger().error("onLastDeeplinkReadListener cannot be null", new Object[0]);
        } else if (context == null) {
            AdjustFactory.getLogger().error("null context", new Object[0]);
        } else {
            getDefaultInstance().getLastDeeplink(context, onLastDeeplinkReadListener);
        }
    }

    public static void getSdkVersion(OnSdkVersionReadListener onSdkVersionReadListener) {
        if (onSdkVersionReadListener == null) {
            AdjustFactory.getLogger().error("onSdkVersionReadListener cannot be null", new Object[0]);
        } else {
            getDefaultInstance().getSdkVersion(onSdkVersionReadListener);
        }
    }

    public static void getThirdPartySharingSettingsWithTimeout(Context context, long j, OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener) {
        if (onThirdPartySharingSettingsReadListener == null) {
            AdjustFactory.getLogger().error("Callback for getting third party sharing settings can't be null", new Object[0]);
            return;
        }
        if (context == null) {
            AdjustFactory.getLogger().error("Context for getting third party sharing settings can't be null", new Object[0]);
            onThirdPartySharingSettingsReadListener.onThirdPartySharingSettingsRead(null);
        } else if (j >= 0) {
            getDefaultInstance().getThirdPartySharingSettingsWithTimeout(extractApplicationContext(context), j, onThirdPartySharingSettingsReadListener);
        } else {
            AdjustFactory.getLogger().error("Timeout value for getting third party sharing settings can't be negative", new Object[0]);
            onThirdPartySharingSettingsReadListener.onThirdPartySharingSettingsRead(null);
        }
    }

    public static void initSdk(AdjustConfig adjustConfig) {
        getDefaultInstance().initSdk(adjustConfig);
    }

    public static boolean isAdjustUninstallDetectionPayload(Map<String, String> map) {
        return Util.isAdjustUninstallDetectionPayload(map);
    }

    public static void isEnabled(Context context, OnIsEnabledListener onIsEnabledListener) {
        if (context == null) {
            AdjustFactory.getLogger().error("null context", new Object[0]);
        } else if (onIsEnabledListener == null) {
            AdjustFactory.getLogger().error("Callback for getting isEnabled can't be null", new Object[0]);
        } else {
            getDefaultInstance().isEnabled(extractApplicationContext(context), onIsEnabledListener);
        }
    }

    public static void onPause() {
        getDefaultInstance().onPause();
    }

    public static void onResume() {
        getDefaultInstance().onResume();
    }

    public static void processAndResolveDeeplink(AdjustDeeplink adjustDeeplink, Context context, OnDeeplinkResolvedListener onDeeplinkResolvedListener) {
        getDefaultInstance().processAndResolveDeeplink(adjustDeeplink, extractApplicationContext(context), onDeeplinkResolvedListener);
    }

    public static void processDeeplink(AdjustDeeplink adjustDeeplink, Context context) {
        getDefaultInstance().processDeeplink(adjustDeeplink, extractApplicationContext(context));
    }

    public static void removeGlobalCallbackParameter(String str) {
        getDefaultInstance().removeGlobalCallbackParameter(str);
    }

    public static void removeGlobalCallbackParameters() {
        getDefaultInstance().removeGlobalCallbackParameters();
    }

    public static void removeGlobalPartnerParameter(String str) {
        getDefaultInstance().removeGlobalPartnerParameter(str);
    }

    public static void removeGlobalPartnerParameters() {
        getDefaultInstance().removeGlobalPartnerParameters();
    }

    public static void setExternalDeviceIdInDelay(String str) {
        getDefaultInstance().setExternalDeviceIdInDelay(str);
    }

    public static void setPushToken(String str, Context context) {
        getDefaultInstance().setPushToken(str, extractApplicationContext(context));
    }

    public static void setReferrer(String str, Context context) {
        getDefaultInstance().sendReferrer(str, extractApplicationContext(context));
    }

    public static void setTestOptions(AdjustTestOptions adjustTestOptions) {
        Boolean bool = adjustTestOptions.teardown;
        if (bool != null && bool.booleanValue()) {
            AdjustInstance adjustInstance = defaultInstance;
            if (adjustInstance != null) {
                adjustInstance.teardown();
            }
            defaultInstance = null;
            AdjustFactory.teardown(adjustTestOptions.context);
        }
        getDefaultInstance().setTestOptions(adjustTestOptions);
    }

    public static void switchBackToOnlineMode() {
        getDefaultInstance().switchBackToOnlineMode();
    }

    public static void switchToOfflineMode() {
        getDefaultInstance().switchToOfflineMode();
    }

    public static void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        getDefaultInstance().trackAdRevenue(adjustAdRevenue);
    }

    public static void trackEvent(AdjustEvent adjustEvent) {
        getDefaultInstance().trackEvent(adjustEvent);
    }

    public static void trackMeasurementConsent(boolean z) {
        getDefaultInstance().trackMeasurementConsent(z);
    }

    public static void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        getDefaultInstance().trackPlayStoreSubscription(adjustPlayStoreSubscription);
    }

    public static void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        getDefaultInstance().trackThirdPartySharing(adjustThirdPartySharing);
    }

    public static void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        getDefaultInstance().verifyAndTrackPlayStorePurchase(adjustEvent, onPurchaseVerificationFinishedListener);
    }

    public static void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        if (onPurchaseVerificationFinishedListener == null) {
            AdjustFactory.getLogger().error("Purchase verification aborted because verification callback is null", new Object[0]);
        } else {
            getDefaultInstance().verifyPlayStorePurchase(adjustPlayStorePurchase, onPurchaseVerificationFinishedListener);
        }
    }
}
