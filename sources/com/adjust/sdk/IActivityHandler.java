package com.adjust.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IActivityHandler {
    void addGlobalCallbackParameter(String str, String str2);

    void addGlobalPartnerParameter(String str, String str2);

    void endFirstSessionDelay();

    void finishedTrackingActivity(ResponseData responseData);

    void gdprForgetMe();

    ActivityState getActivityState();

    void getAdid(OnAdidReadListener onAdidReadListener);

    void getAdidWithTimeout(long j, OnAdidReadListener onAdidReadListener);

    AdjustConfig getAdjustConfig();

    void getAttribution(OnAttributionReadListener onAttributionReadListener);

    void getAttributionWithTimeout(long j, OnAttributionReadListener onAttributionReadListener);

    Context getContext();

    DeviceInfo getDeviceInfo();

    FirstSessionDelayManager getFirstSessionDelayManager();

    GlobalParameters getGlobalParameters();

    ActivityHandler.InternalState getInternalState();

    void getThirdPartySharingSettingsWithTimeout(long j, OnThirdPartySharingSettingsReadListener onThirdPartySharingSettingsReadListener);

    void gotOptOutResponse();

    void init(AdjustConfig adjustConfig);

    void isEnabled(OnIsEnabledListener onIsEnabledListener);

    boolean isEnabled();

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchPurchaseVerificationResponseTasks(PurchaseVerificationResponseData purchaseVerificationResponseData);

    void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void onPause();

    void onResume();

    void processAndResolveDeeplink(AdjustDeeplink adjustDeeplink, long j, OnDeeplinkResolvedListener onDeeplinkResolvedListener);

    void processDeeplink(AdjustDeeplink adjustDeeplink, long j);

    void processRemoteTriggers(ResponseData responseData);

    void removeGlobalCallbackParameter(String str);

    void removeGlobalCallbackParameters();

    void removeGlobalPartnerParameter(String str);

    void removeGlobalPartnerParameters();

    void sendInstallReferrer(ReferrerDetails referrerDetails, String str);

    void sendLicenseVerificationData(LicenseData licenseData);

    void sendPreinstallReferrer();

    void sendReftagReferrer();

    void setAskingAttribution(boolean z);

    void setCoppaComplianceInDelay(boolean z);

    void setEnabled(boolean z);

    void setExternalDeviceIdInDelay(String str);

    void setOfflineMode(boolean z);

    void setPlayStoreKidsComplianceInDelay(boolean z);

    void setPushToken(String str, boolean z);

    void teardown();

    void trackAdRevenue(AdjustAdRevenue adjustAdRevenue);

    void trackEvent(AdjustEvent adjustEvent);

    void trackMeasurementConsent(boolean z);

    void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription);

    void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing);

    boolean updateAttributionI(AdjustAttribution adjustAttribution);

    void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener);

    void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener);
}
