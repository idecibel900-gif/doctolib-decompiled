package com.adjust.nativemodule;

import android.net.Uri;
import com.adjust.sdk.AdjustAdRevenue;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustDeeplink;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustEventFailure;
import com.adjust.sdk.AdjustEventSuccess;
import com.adjust.sdk.AdjustLinkResolution;
import com.adjust.sdk.AdjustPlayStorePurchase;
import com.adjust.sdk.AdjustPlayStoreSubscription;
import com.adjust.sdk.AdjustPurchaseVerificationResult;
import com.adjust.sdk.AdjustRemoteTrigger;
import com.adjust.sdk.AdjustSessionFailure;
import com.adjust.sdk.AdjustSessionSuccess;
import com.adjust.sdk.AdjustStoreInfo;
import com.adjust.sdk.AdjustTestOptions;
import com.adjust.sdk.AdjustThirdPartySharing;
import com.adjust.sdk.AdjustThirdPartySharingResult;
import com.adjust.sdk.Constants;
import com.adjust.sdk.LogLevel;
import com.adjust.sdk.OnAdidReadListener;
import com.adjust.sdk.OnAmazonAdIdReadListener;
import com.adjust.sdk.OnAttributionChangedListener;
import com.adjust.sdk.OnAttributionReadListener;
import com.adjust.sdk.OnDeeplinkResolvedListener;
import com.adjust.sdk.OnDeferredDeeplinkResponseListener;
import com.adjust.sdk.OnEventTrackingFailedListener;
import com.adjust.sdk.OnEventTrackingSucceededListener;
import com.adjust.sdk.OnGoogleAdIdReadListener;
import com.adjust.sdk.OnIsEnabledListener;
import com.adjust.sdk.OnLastDeeplinkReadListener;
import com.adjust.sdk.OnPurchaseVerificationFinishedListener;
import com.adjust.sdk.OnRemoteTriggerListener;
import com.adjust.sdk.OnSdkVersionReadListener;
import com.adjust.sdk.OnSessionTrackingFailedListener;
import com.adjust.sdk.OnSessionTrackingSucceededListener;
import com.adjust.sdk.OnThirdPartySharingSettingsChangedListener;
import com.adjust.sdk.OnThirdPartySharingSettingsReadListener;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge;
import java.util.ArrayList;
import java.util.List;
import net.openid.appauth.ResponseTypeValues;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Adjust extends ReactContextBaseJavaModule implements OnAttributionChangedListener, OnEventTrackingSucceededListener, OnEventTrackingFailedListener, OnSessionTrackingSucceededListener, OnSessionTrackingFailedListener, OnDeferredDeeplinkResponseListener, OnRemoteTriggerListener, OnThirdPartySharingSettingsChangedListener {
    private static String TAG = "AdjustBridge";
    private boolean isAttributionCallbackImplemented;
    private boolean isDeferredDeeplinkCallbackImplemented;
    private boolean isDeferredDeeplinkOpeningEnabled;
    private boolean isEventTrackingFailedCallbackImplemented;
    private boolean isEventTrackingSucceededCallbackImplemented;
    private boolean isRemoteTriggerCallbackImplemented;
    private boolean isSessionTrackingFailedCallbackImplemented;
    private boolean isSessionTrackingSucceededCallbackImplemented;
    private boolean isThirdPartySharingSettingsChangedCallbackImplemented;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(double d) {
    }

    public Adjust(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.isDeferredDeeplinkOpeningEnabled = true;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return Constants.LOGTAG;
    }

    @Override // com.adjust.sdk.OnAttributionChangedListener
    public void onAttributionChanged(AdjustAttribution adjustAttribution) {
        sendEvent(getReactApplicationContext(), "adjust_attributionChanged", AdjustUtil.attributionToMap(adjustAttribution));
    }

    @Override // com.adjust.sdk.OnEventTrackingSucceededListener
    public void onEventTrackingSucceeded(AdjustEventSuccess adjustEventSuccess) {
        sendEvent(getReactApplicationContext(), "adjust_eventTrackingSucceeded", AdjustUtil.eventSuccessToMap(adjustEventSuccess));
    }

    @Override // com.adjust.sdk.OnEventTrackingFailedListener
    public void onEventTrackingFailed(AdjustEventFailure adjustEventFailure) {
        sendEvent(getReactApplicationContext(), "adjust_eventTrackingFailed", AdjustUtil.eventFailureToMap(adjustEventFailure));
    }

    @Override // com.adjust.sdk.OnSessionTrackingSucceededListener
    public void onSessionTrackingSucceeded(AdjustSessionSuccess adjustSessionSuccess) {
        sendEvent(getReactApplicationContext(), "adjust_sessionTrackingSucceeded", AdjustUtil.sessionSuccessToMap(adjustSessionSuccess));
    }

    @Override // com.adjust.sdk.OnSessionTrackingFailedListener
    public void onSessionTrackingFailed(AdjustSessionFailure adjustSessionFailure) {
        sendEvent(getReactApplicationContext(), "adjust_sessionTrackingFailed", AdjustUtil.sessionFailureToMap(adjustSessionFailure));
    }

    @Override // com.adjust.sdk.OnDeferredDeeplinkResponseListener
    public boolean launchReceivedDeeplink(Uri uri) {
        sendEvent(getReactApplicationContext(), "adjust_deferredDeeplinkReceived", AdjustUtil.deferredDeeplinkToMap(uri));
        return this.isDeferredDeeplinkOpeningEnabled;
    }

    @Override // com.adjust.sdk.OnRemoteTriggerListener
    public void onRemoteTrigger(AdjustRemoteTrigger adjustRemoteTrigger) {
        sendEvent(getReactApplicationContext(), "adjust_remoteTriggerReceived", AdjustUtil.remoteTriggerToMap(adjustRemoteTrigger));
    }

    @Override // com.adjust.sdk.OnThirdPartySharingSettingsChangedListener
    public void onThirdPartySharingSettingsChanged(AdjustThirdPartySharingResult adjustThirdPartySharingResult) {
        sendEvent(getReactApplicationContext(), "adjust_thirdPartySharingSettingsChanged", AdjustUtil.thirdPartySharingResultToMap(adjustThirdPartySharingResult));
    }

    @ReactMethod
    public void initSdk(ReadableMap readableMap) {
        List list;
        if (readableMap == null) {
            return;
        }
        AdjustConfig adjustConfig = new AdjustConfig(getReactApplicationContext(), checkKey(readableMap, "appToken") ? readableMap.getString("appToken") : null, checkKey(readableMap, "environment") ? readableMap.getString("environment") : null, checkKey(readableMap, "logLevel") && readableMap.getString("logLevel").equals("SUPPRESS"));
        if (checkKey(readableMap, "logLevel")) {
            String string = readableMap.getString("logLevel");
            if (string.equals("VERBOSE")) {
                adjustConfig.setLogLevel(LogLevel.VERBOSE);
            } else if (string.equals("DEBUG")) {
                adjustConfig.setLogLevel(LogLevel.DEBUG);
            } else if (string.equals("INFO")) {
                adjustConfig.setLogLevel(LogLevel.INFO);
            } else if (string.equals("WARN")) {
                adjustConfig.setLogLevel(LogLevel.WARN);
            } else if (string.equals(HybridPurchaseLogicBridge.RESULT_ERROR)) {
                adjustConfig.setLogLevel(LogLevel.ERROR);
            } else if (string.equals("ASSERT")) {
                adjustConfig.setLogLevel(LogLevel.ASSERT);
            } else if (string.equals("SUPPRESS")) {
                adjustConfig.setLogLevel(LogLevel.SUPPRESS);
            } else {
                adjustConfig.setLogLevel(LogLevel.INFO);
            }
        }
        if (checkKey(readableMap, "sdkPrefix")) {
            adjustConfig.setSdkPrefix(readableMap.getString("sdkPrefix"));
        }
        if (checkKey(readableMap, "processName")) {
            adjustConfig.setProcessName(readableMap.getString("processName"));
        }
        if (checkKey(readableMap, "defaultTracker")) {
            adjustConfig.setDefaultTracker(readableMap.getString("defaultTracker"));
        }
        if (checkKey(readableMap, "externalDeviceId")) {
            adjustConfig.setExternalDeviceId(readableMap.getString("externalDeviceId"));
        }
        if (checkKey(readableMap, "urlStrategyDomains") && checkKey(readableMap, "useSubdomains") && checkKey(readableMap, "isDataResidency") && (list = AdjustUtil.toList(readableMap.getArray("urlStrategyDomains"))) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).toString());
            }
            adjustConfig.setUrlStrategy(arrayList, readableMap.getBoolean("useSubdomains"), readableMap.getBoolean("isDataResidency"));
        }
        if (checkKey(readableMap, "preinstallFilePath")) {
            adjustConfig.setPreinstallFilePath(readableMap.getString("preinstallFilePath"));
        }
        if (checkKey(readableMap, "fbAppId")) {
            adjustConfig.setFbAppId(readableMap.getString("fbAppId"));
        }
        if (checkKey(readableMap, "isSendingInBackgroundEnabled") && readableMap.getBoolean("isSendingInBackgroundEnabled")) {
            adjustConfig.enableSendingInBackground();
        }
        if (checkKey(readableMap, "isPreinstallTrackingEnabled") && readableMap.getBoolean("isPreinstallTrackingEnabled")) {
            adjustConfig.enablePreinstallTracking();
        }
        if (checkKey(readableMap, "isCostDataInAttributionEnabled") && readableMap.getBoolean("isCostDataInAttributionEnabled")) {
            adjustConfig.enableCostDataInAttribution();
        }
        if (checkKey(readableMap, "isPlayStoreKidsComplianceEnabled") && readableMap.getBoolean("isPlayStoreKidsComplianceEnabled")) {
            adjustConfig.enablePlayStoreKidsCompliance();
        }
        if (checkKey(readableMap, "isDeferredDeeplinkOpeningEnabled")) {
            this.isDeferredDeeplinkOpeningEnabled = readableMap.getBoolean("isDeferredDeeplinkOpeningEnabled");
        }
        if (checkKey(readableMap, "isCoppaComplianceEnabled") && readableMap.getBoolean("isCoppaComplianceEnabled")) {
            adjustConfig.enableCoppaCompliance();
        }
        if (checkKey(readableMap, "isDeviceIdsReadingOnceEnabled") && readableMap.getBoolean("isDeviceIdsReadingOnceEnabled")) {
            adjustConfig.enableDeviceIdsReadingOnce();
        }
        if (checkKey(readableMap, "isDeviceIdsReadingEnabled") && !readableMap.getBoolean("isDeviceIdsReadingEnabled")) {
            adjustConfig.disableDeviceIdsReading();
        }
        if (checkKey(readableMap, "isFbIdReadingEnabled") && !readableMap.getBoolean("isFbIdReadingEnabled")) {
            adjustConfig.disableFbIdReading();
        }
        if (checkKey(readableMap, "isFirstSessionDelayEnabled") && readableMap.getBoolean("isFirstSessionDelayEnabled")) {
            adjustConfig.enableFirstSessionDelay();
        }
        if (checkKey(readableMap, "isAppSetIdReadingEnabled") && !readableMap.getBoolean("isAppSetIdReadingEnabled")) {
            adjustConfig.disableAppSetIdReading();
        }
        if (checkKey(readableMap, "isGoogleAdIdReadingEnabled") && !readableMap.getBoolean("isGoogleAdIdReadingEnabled")) {
            adjustConfig.disableGoogleAdIdReading();
        }
        if (checkKey(readableMap, "isAndroidIdReadingEnabled") && !readableMap.getBoolean("isAndroidIdReadingEnabled")) {
            adjustConfig.disableAndroidIdReading();
        }
        if (checkKey(readableMap, "isFireAdIdReadingEnabled") && !readableMap.getBoolean("isFireAdIdReadingEnabled")) {
            adjustConfig.disableFireAdIdReading();
        }
        if (checkKey(readableMap, "isDeviceIdsFromPluginsReadingEnabled") && !readableMap.getBoolean("isDeviceIdsFromPluginsReadingEnabled")) {
            adjustConfig.disableDeviceIdsFromPluginsReading();
        }
        if (checkKey(readableMap, "storeInfo")) {
            try {
                JSONObject jSONObject = new JSONObject(readableMap.getMap("storeInfo").toString());
                String strOptString = jSONObject.optString("storeName", null);
                if (AdjustUtil.isFieldValid(strOptString)) {
                    AdjustStoreInfo adjustStoreInfo = new AdjustStoreInfo(strOptString);
                    String strOptString2 = jSONObject.optString("storeAppId", null);
                    if (AdjustUtil.isFieldValid(strOptString2)) {
                        adjustStoreInfo.setStoreAppId(strOptString2);
                    }
                    adjustConfig.setStoreInfo(adjustStoreInfo);
                }
            } catch (JSONException unused) {
            }
        }
        if (checkKey(readableMap, "eventDeduplicationIdsMaxSize")) {
            adjustConfig.setEventDeduplicationIdsMaxSize(Integer.valueOf(readableMap.getInt("eventDeduplicationIdsMaxSize")));
        }
        if (this.isAttributionCallbackImplemented) {
            adjustConfig.setOnAttributionChangedListener(this);
        }
        if (this.isThirdPartySharingSettingsChangedCallbackImplemented) {
            adjustConfig.setOnThirdPartySharingSettingsChangedListener(this);
        }
        if (this.isEventTrackingSucceededCallbackImplemented) {
            adjustConfig.setOnEventTrackingSucceededListener(this);
        }
        if (this.isEventTrackingFailedCallbackImplemented) {
            adjustConfig.setOnEventTrackingFailedListener(this);
        }
        if (this.isSessionTrackingSucceededCallbackImplemented) {
            adjustConfig.setOnSessionTrackingSucceededListener(this);
        }
        if (this.isSessionTrackingFailedCallbackImplemented) {
            adjustConfig.setOnSessionTrackingFailedListener(this);
        }
        if (this.isDeferredDeeplinkCallbackImplemented) {
            adjustConfig.setOnDeferredDeeplinkResponseListener(this);
        }
        if (this.isRemoteTriggerCallbackImplemented) {
            adjustConfig.setOnRemoteTriggerListener(this);
        }
        com.adjust.sdk.Adjust.initSdk(adjustConfig);
    }

    @ReactMethod
    public void trackEvent(ReadableMap readableMap) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        List list;
        List list2;
        if (readableMap == null) {
            return;
        }
        AdjustEvent adjustEvent = new AdjustEvent(checkKey(readableMap, "eventToken") ? readableMap.getString("eventToken") : null);
        if (checkKey(readableMap, "revenue") || checkKey(readableMap, b.a)) {
            adjustEvent.setRevenue(readableMap.getDouble("revenue"), readableMap.getString(b.a));
        }
        if (checkKey(readableMap, "callbackParameters") && (list2 = AdjustUtil.toList(readableMap.getArray("callbackParameters"))) != null) {
            for (int i = 0; i < list2.size(); i += 2) {
                adjustEvent.addCallbackParameter(list2.get(i).toString(), list2.get(i + 1).toString());
            }
        }
        if (checkKey(readableMap, "partnerParameters") && (list = AdjustUtil.toList(readableMap.getArray("partnerParameters"))) != null) {
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                adjustEvent.addPartnerParameter(list.get(i2).toString(), list.get(i2 + 1).toString());
            }
        }
        if (checkKey(readableMap, "transactionId") && (string5 = readableMap.getString("transactionId")) != null) {
            adjustEvent.setOrderId(string5);
        }
        if (checkKey(readableMap, "callbackId") && (string4 = readableMap.getString("callbackId")) != null) {
            adjustEvent.setCallbackId(string4);
        }
        if (checkKey(readableMap, "productId") && (string3 = readableMap.getString("productId")) != null) {
            adjustEvent.setProductId(string3);
        }
        if (checkKey(readableMap, "purchaseToken") && (string2 = readableMap.getString("purchaseToken")) != null) {
            adjustEvent.setPurchaseToken(string2);
        }
        if (checkKey(readableMap, "deduplicationId") && (string = readableMap.getString("deduplicationId")) != null) {
            adjustEvent.setDeduplicationId(string);
        }
        com.adjust.sdk.Adjust.trackEvent(adjustEvent);
    }

    @ReactMethod
    public void trackAdRevenue(ReadableMap readableMap) {
        List list;
        List list2;
        String string;
        String string2;
        String string3;
        if (readableMap == null) {
            return;
        }
        AdjustAdRevenue adjustAdRevenue = new AdjustAdRevenue(checkKey(readableMap, com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE) ? readableMap.getString(com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE) : null);
        if (checkKey(readableMap, "revenue") || checkKey(readableMap, b.a)) {
            adjustAdRevenue.setRevenue(Double.valueOf(readableMap.getDouble("revenue")), readableMap.getString(b.a));
        }
        if (checkKey(readableMap, "adImpressionsCount")) {
            adjustAdRevenue.setAdImpressionsCount(Integer.valueOf(readableMap.getInt("adImpressionsCount")));
        }
        if (checkKey(readableMap, "adRevenueNetwork") && (string3 = readableMap.getString("adRevenueNetwork")) != null) {
            adjustAdRevenue.setAdRevenueNetwork(string3);
        }
        if (checkKey(readableMap, "adRevenueUnit") && (string2 = readableMap.getString("adRevenueUnit")) != null) {
            adjustAdRevenue.setAdRevenueUnit(string2);
        }
        if (checkKey(readableMap, "adRevenuePlacement") && (string = readableMap.getString("adRevenuePlacement")) != null) {
            adjustAdRevenue.setAdRevenuePlacement(string);
        }
        if (checkKey(readableMap, "callbackParameters") && (list2 = AdjustUtil.toList(readableMap.getArray("callbackParameters"))) != null) {
            for (int i = 0; i < list2.size(); i += 2) {
                adjustAdRevenue.addCallbackParameter(list2.get(i).toString(), list2.get(i + 1).toString());
            }
        }
        if (checkKey(readableMap, "partnerParameters") && (list = AdjustUtil.toList(readableMap.getArray("partnerParameters"))) != null) {
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                adjustAdRevenue.addPartnerParameter(list.get(i2).toString(), list.get(i2 + 1).toString());
            }
        }
        com.adjust.sdk.Adjust.trackAdRevenue(adjustAdRevenue);
    }

    @ReactMethod
    public void trackThirdPartySharing(ReadableMap readableMap) {
        List list;
        List list2;
        if (readableMap == null) {
            return;
        }
        AdjustThirdPartySharing adjustThirdPartySharing = new AdjustThirdPartySharing(checkKey(readableMap, "isEnabled") ? Boolean.valueOf(readableMap.getBoolean("isEnabled")) : null);
        if (checkKey(readableMap, "granularOptions") && (list2 = AdjustUtil.toList(readableMap.getArray("granularOptions"))) != null) {
            for (int i = 0; i < list2.size(); i += 3) {
                adjustThirdPartySharing.addGranularOption(list2.get(i).toString(), list2.get(i + 1).toString(), list2.get(i + 2).toString());
            }
        }
        if (checkKey(readableMap, "partnerSharingSettings") && (list = AdjustUtil.toList(readableMap.getArray("partnerSharingSettings"))) != null) {
            for (int i2 = 0; i2 < list.size(); i2 += 3) {
                adjustThirdPartySharing.addPartnerSharingSetting(list.get(i2).toString(), list.get(i2 + 1).toString(), Boolean.parseBoolean(list.get(i2 + 2).toString()));
            }
        }
        com.adjust.sdk.Adjust.trackThirdPartySharing(adjustThirdPartySharing);
    }

    @ReactMethod
    public void trackMeasurementConsent(boolean z) {
        com.adjust.sdk.Adjust.trackMeasurementConsent(z);
    }

    @ReactMethod
    public void processDeeplink(ReadableMap readableMap) {
        if (readableMap != null && checkKey(readableMap, Constants.DEEPLINK)) {
            AdjustDeeplink adjustDeeplink = new AdjustDeeplink(Uri.parse(readableMap.getString(Constants.DEEPLINK)));
            if (checkKey(readableMap, Constants.REFERRER)) {
                adjustDeeplink.setReferrer(Uri.parse(readableMap.getString(Constants.REFERRER)));
            }
            com.adjust.sdk.Adjust.processDeeplink(adjustDeeplink, getReactApplicationContext());
        }
    }

    @ReactMethod
    public void processAndResolveDeeplink(ReadableMap readableMap, final Callback callback) {
        if (readableMap == null) {
            if (callback != null) {
                callback.invoke(null);
            }
        } else if (!checkKey(readableMap, Constants.DEEPLINK)) {
            if (callback != null) {
                callback.invoke(null);
            }
        } else {
            AdjustDeeplink adjustDeeplink = new AdjustDeeplink(Uri.parse(readableMap.getString(Constants.DEEPLINK)));
            if (checkKey(readableMap, Constants.REFERRER)) {
                adjustDeeplink.setReferrer(Uri.parse(readableMap.getString(Constants.REFERRER)));
            }
            com.adjust.sdk.Adjust.processAndResolveDeeplink(adjustDeeplink, getReactApplicationContext(), new OnDeeplinkResolvedListener() { // from class: com.adjust.nativemodule.Adjust.1
                @Override // com.adjust.sdk.OnDeeplinkResolvedListener
                public void onDeeplinkResolved(String str) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.invoke(str);
                    }
                }
            });
        }
    }

    @ReactMethod
    public void resolveLinkWithUrl(String str, ReadableArray readableArray, final Callback callback) {
        String[] strArr = null;
        if (str == null) {
            if (callback != null) {
                callback.invoke(null);
                return;
            }
            return;
        }
        if (readableArray != null && readableArray.size() > 0) {
            int size = readableArray.size();
            String[] strArr2 = new String[size];
            for (int i = 0; i < size; i++) {
                strArr2[i] = readableArray.getString(i);
            }
            strArr = strArr2;
        }
        AdjustLinkResolution.resolveLink(str, strArr, new AdjustLinkResolution.AdjustLinkResolutionCallback() { // from class: com.adjust.nativemodule.Adjust.2
            @Override // com.adjust.sdk.AdjustLinkResolution.AdjustLinkResolutionCallback
            public void resolvedLinkCallback(Uri uri) {
                if (callback != null) {
                    callback.invoke(uri != null ? uri.toString() : null);
                }
            }
        });
    }

    @ReactMethod
    public void setPushToken(String str) {
        com.adjust.sdk.Adjust.setPushToken(str, getReactApplicationContext());
    }

    @ReactMethod
    public void gdprForgetMe() {
        com.adjust.sdk.Adjust.gdprForgetMe(getReactApplicationContext());
    }

    @ReactMethod
    public void enable() {
        com.adjust.sdk.Adjust.enable();
    }

    @ReactMethod
    public void disable() {
        com.adjust.sdk.Adjust.disable();
    }

    @ReactMethod
    public void switchToOfflineMode() {
        com.adjust.sdk.Adjust.switchToOfflineMode();
    }

    @ReactMethod
    public void switchBackToOnlineMode() {
        com.adjust.sdk.Adjust.switchBackToOnlineMode();
    }

    @ReactMethod
    public void addGlobalCallbackParameter(String str, String str2) {
        com.adjust.sdk.Adjust.addGlobalCallbackParameter(str, str2);
    }

    @ReactMethod
    public void addGlobalPartnerParameter(String str, String str2) {
        com.adjust.sdk.Adjust.addGlobalPartnerParameter(str, str2);
    }

    @ReactMethod
    public void removeGlobalCallbackParameter(String str) {
        com.adjust.sdk.Adjust.removeGlobalCallbackParameter(str);
    }

    @ReactMethod
    public void removeGlobalPartnerParameter(String str) {
        com.adjust.sdk.Adjust.removeGlobalPartnerParameter(str);
    }

    @ReactMethod
    public void removeGlobalCallbackParameters() {
        com.adjust.sdk.Adjust.removeGlobalCallbackParameters();
    }

    @ReactMethod
    public void removeGlobalPartnerParameters() {
        com.adjust.sdk.Adjust.removeGlobalPartnerParameters();
    }

    @ReactMethod
    public void endFirstSessionDelay() {
        com.adjust.sdk.Adjust.endFirstSessionDelay();
    }

    @ReactMethod
    public void enableCoppaComplianceInDelay() {
        com.adjust.sdk.Adjust.enableCoppaComplianceInDelay();
    }

    @ReactMethod
    public void disableCoppaComplianceInDelay() {
        com.adjust.sdk.Adjust.disableCoppaComplianceInDelay();
    }

    @ReactMethod
    public void setExternalDeviceIdInDelay(String str) {
        com.adjust.sdk.Adjust.setExternalDeviceIdInDelay(str);
    }

    @ReactMethod
    public void isEnabled(final Callback callback) {
        com.adjust.sdk.Adjust.isEnabled(getReactApplicationContext(), new OnIsEnabledListener() { // from class: com.adjust.nativemodule.Adjust.3
            @Override // com.adjust.sdk.OnIsEnabledListener
            public void onIsEnabledRead(boolean z) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.invoke(Boolean.valueOf(z));
                }
            }
        });
    }

    @ReactMethod
    public void getAttribution(final Callback callback) {
        com.adjust.sdk.Adjust.getAttribution(new OnAttributionReadListener() { // from class: com.adjust.nativemodule.Adjust.4
            @Override // com.adjust.sdk.OnAttributionReadListener
            public void onAttributionRead(AdjustAttribution adjustAttribution) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.invoke(AdjustUtil.attributionToMap(adjustAttribution));
                }
            }
        });
    }

    @ReactMethod
    public void getAttributionWithTimeout(ReadableMap readableMap, final Callback callback) {
        if (readableMap == null || !checkKey(readableMap, "timeoutInMilliseconds")) {
            if (callback != null) {
                callback.invoke(null);
            }
        } else {
            try {
                com.adjust.sdk.Adjust.getAttributionWithTimeout(getReactApplicationContext(), (long) readableMap.getDouble("timeoutInMilliseconds"), new OnAttributionReadListener() { // from class: com.adjust.nativemodule.Adjust.5
                    @Override // com.adjust.sdk.OnAttributionReadListener
                    public void onAttributionRead(AdjustAttribution adjustAttribution) {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            if (adjustAttribution == null) {
                                callback2.invoke(null);
                            } else {
                                callback2.invoke(AdjustUtil.attributionToMap(adjustAttribution));
                            }
                        }
                    }
                });
            } catch (Exception unused) {
                if (callback != null) {
                    callback.invoke(null);
                }
            }
        }
    }

    @ReactMethod
    public void getAdid(final Callback callback) {
        com.adjust.sdk.Adjust.getAdid(new OnAdidReadListener() { // from class: com.adjust.nativemodule.Adjust.6
            @Override // com.adjust.sdk.OnAdidReadListener
            public void onAdidRead(String str) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    if (str == null) {
                        str = null;
                    }
                    callback2.invoke(str);
                }
            }
        });
    }

    @ReactMethod
    public void getAdidWithTimeout(ReadableMap readableMap, final Callback callback) {
        if (readableMap == null || !checkKey(readableMap, "timeoutInMilliseconds")) {
            if (callback != null) {
                callback.invoke(null);
            }
        } else {
            try {
                com.adjust.sdk.Adjust.getAdidWithTimeout(getReactApplicationContext(), (long) readableMap.getDouble("timeoutInMilliseconds"), new OnAdidReadListener() { // from class: com.adjust.nativemodule.Adjust.7
                    @Override // com.adjust.sdk.OnAdidReadListener
                    public void onAdidRead(String str) {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            if (str == null) {
                                str = null;
                            }
                            callback2.invoke(str);
                        }
                    }
                });
            } catch (Exception unused) {
                if (callback != null) {
                    callback.invoke(null);
                }
            }
        }
    }

    @ReactMethod
    public void getThirdPartySharingSettingsWithTimeout(ReadableMap readableMap, final Callback callback) {
        if (readableMap == null || !checkKey(readableMap, "timeoutInMilliseconds")) {
            if (callback != null) {
                callback.invoke(null);
            }
        } else {
            try {
                com.adjust.sdk.Adjust.getThirdPartySharingSettingsWithTimeout(getReactApplicationContext(), (long) readableMap.getDouble("timeoutInMilliseconds"), new OnThirdPartySharingSettingsReadListener() { // from class: com.adjust.nativemodule.Adjust.8
                    @Override // com.adjust.sdk.OnThirdPartySharingSettingsReadListener
                    public void onThirdPartySharingSettingsRead(AdjustThirdPartySharingResult adjustThirdPartySharingResult) {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.invoke(adjustThirdPartySharingResult != null ? adjustThirdPartySharingResult.getThirdPartySharingSettingsJson() : null);
                        }
                    }
                });
            } catch (Exception unused) {
                if (callback != null) {
                    callback.invoke(null);
                }
            }
        }
    }

    @ReactMethod
    public void getLastDeeplink(final Callback callback) {
        com.adjust.sdk.Adjust.getLastDeeplink(getReactApplicationContext(), new OnLastDeeplinkReadListener() { // from class: com.adjust.nativemodule.Adjust.9
            @Override // com.adjust.sdk.OnLastDeeplinkReadListener
            public void onLastDeeplinkRead(Uri uri) {
                if (callback != null) {
                    callback.invoke(uri != null ? uri.toString() : null);
                }
            }
        });
    }

    @ReactMethod
    public void getSdkVersion(final String str, final Callback callback) {
        com.adjust.sdk.Adjust.getSdkVersion(new OnSdkVersionReadListener() { // from class: com.adjust.nativemodule.Adjust.10
            @Override // com.adjust.sdk.OnSdkVersionReadListener
            public void onSdkVersionRead(String str2) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    if (str2 == null) {
                        callback2.invoke(null);
                        return;
                    }
                    callback2.invoke(str + "@" + str2);
                }
            }
        });
    }

    @ReactMethod
    public void setAttributionCallbackImplemented() {
        this.isAttributionCallbackImplemented = true;
    }

    @ReactMethod
    public void setEventTrackingSucceededCallbackImplemented() {
        this.isEventTrackingSucceededCallbackImplemented = true;
    }

    @ReactMethod
    public void setEventTrackingFailedCallbackImplemented() {
        this.isEventTrackingFailedCallbackImplemented = true;
    }

    @ReactMethod
    public void setSessionTrackingSucceededCallbackImplemented() {
        this.isSessionTrackingSucceededCallbackImplemented = true;
    }

    @ReactMethod
    public void setSessionTrackingFailedCallbackImplemented() {
        this.isSessionTrackingFailedCallbackImplemented = true;
    }

    @ReactMethod
    public void setDeferredDeeplinkCallbackImplemented() {
        this.isDeferredDeeplinkCallbackImplemented = true;
    }

    @ReactMethod
    public void setRemoteTriggerCallbackImplemented() {
        this.isRemoteTriggerCallbackImplemented = true;
    }

    @ReactMethod
    public void setThirdPartySharingSettingsChangedCallbackImplemented() {
        this.isThirdPartySharingSettingsChangedCallbackImplemented = true;
    }

    @ReactMethod
    public void trackPlayStoreSubscription(ReadableMap readableMap) {
        List list;
        List list2;
        if (readableMap == null) {
            return;
        }
        AdjustPlayStoreSubscription adjustPlayStoreSubscription = new AdjustPlayStoreSubscription(checkKey(readableMap, b.x) ? readableMap.getInt(b.x) : -1, checkKey(readableMap, b.a) ? readableMap.getString(b.a) : null, checkKey(readableMap, "sku") ? readableMap.getString("sku") : null, checkKey(readableMap, "orderId") ? readableMap.getString("orderId") : null, checkKey(readableMap, "signature") ? readableMap.getString("signature") : null, checkKey(readableMap, "purchaseToken") ? readableMap.getString("purchaseToken") : null);
        if (checkKey(readableMap, "purchaseTime")) {
            adjustPlayStoreSubscription.setPurchaseTime(readableMap.getInt("purchaseTime"));
        }
        if (checkKey(readableMap, "callbackParameters") && (list2 = AdjustUtil.toList(readableMap.getArray("callbackParameters"))) != null) {
            for (int i = 0; i < list2.size(); i += 2) {
                adjustPlayStoreSubscription.addCallbackParameter(list2.get(i).toString(), list2.get(i + 1).toString());
            }
        }
        if (checkKey(readableMap, "partnerParameters") && (list = AdjustUtil.toList(readableMap.getArray("partnerParameters"))) != null) {
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                adjustPlayStoreSubscription.addPartnerParameter(list.get(i2).toString(), list.get(i2 + 1).toString());
            }
        }
        com.adjust.sdk.Adjust.trackPlayStoreSubscription(adjustPlayStoreSubscription);
    }

    @ReactMethod
    public void verifyPlayStorePurchase(ReadableMap readableMap, final Callback callback) {
        if (readableMap != null) {
            com.adjust.sdk.Adjust.verifyPlayStorePurchase(new AdjustPlayStorePurchase(checkKey(readableMap, "productId") ? readableMap.getString("productId") : null, checkKey(readableMap, "purchaseToken") ? readableMap.getString("purchaseToken") : null), new OnPurchaseVerificationFinishedListener() { // from class: com.adjust.nativemodule.Adjust.11
                @Override // com.adjust.sdk.OnPurchaseVerificationFinishedListener
                public void onVerificationFinished(AdjustPurchaseVerificationResult adjustPurchaseVerificationResult) {
                    if (callback != null) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        if (adjustPurchaseVerificationResult == null) {
                            callback.invoke(writableMapCreateMap);
                            return;
                        }
                        writableMapCreateMap.putString("verificationStatus", adjustPurchaseVerificationResult.getVerificationStatus() != null ? adjustPurchaseVerificationResult.getVerificationStatus() : "");
                        writableMapCreateMap.putString(ResponseTypeValues.CODE, String.valueOf(adjustPurchaseVerificationResult.getCode()));
                        writableMapCreateMap.putString("message", adjustPurchaseVerificationResult.getMessage() != null ? adjustPurchaseVerificationResult.getMessage() : "");
                        callback.invoke(writableMapCreateMap);
                    }
                }
            });
        } else if (callback != null) {
            callback.invoke(Arguments.createMap());
        }
    }

    @ReactMethod
    public void verifyAndTrackPlayStorePurchase(ReadableMap readableMap, final Callback callback) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        List list;
        List list2;
        if (readableMap == null) {
            if (callback != null) {
                callback.invoke(Arguments.createMap());
                return;
            }
            return;
        }
        AdjustEvent adjustEvent = new AdjustEvent(checkKey(readableMap, "eventToken") ? readableMap.getString("eventToken") : null);
        if (checkKey(readableMap, "revenue") || checkKey(readableMap, b.a)) {
            adjustEvent.setRevenue(readableMap.getDouble("revenue"), readableMap.getString(b.a));
        }
        if (checkKey(readableMap, "callbackParameters") && (list2 = AdjustUtil.toList(readableMap.getArray("callbackParameters"))) != null) {
            for (int i = 0; i < list2.size(); i += 2) {
                adjustEvent.addCallbackParameter(list2.get(i).toString(), list2.get(i + 1).toString());
            }
        }
        if (checkKey(readableMap, "partnerParameters") && (list = AdjustUtil.toList(readableMap.getArray("partnerParameters"))) != null) {
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                adjustEvent.addPartnerParameter(list.get(i2).toString(), list.get(i2 + 1).toString());
            }
        }
        if (checkKey(readableMap, "transactionId") && (string5 = readableMap.getString("transactionId")) != null) {
            adjustEvent.setOrderId(string5);
        }
        if (checkKey(readableMap, "callbackId") && (string4 = readableMap.getString("callbackId")) != null) {
            adjustEvent.setCallbackId(string4);
        }
        if (checkKey(readableMap, "productId") && (string3 = readableMap.getString("productId")) != null) {
            adjustEvent.setProductId(string3);
        }
        if (checkKey(readableMap, "purchaseToken") && (string2 = readableMap.getString("purchaseToken")) != null) {
            adjustEvent.setPurchaseToken(string2);
        }
        if (checkKey(readableMap, "deduplicationId") && (string = readableMap.getString("deduplicationId")) != null) {
            adjustEvent.setDeduplicationId(string);
        }
        com.adjust.sdk.Adjust.verifyAndTrackPlayStorePurchase(adjustEvent, new OnPurchaseVerificationFinishedListener() { // from class: com.adjust.nativemodule.Adjust.12
            @Override // com.adjust.sdk.OnPurchaseVerificationFinishedListener
            public void onVerificationFinished(AdjustPurchaseVerificationResult adjustPurchaseVerificationResult) {
                if (callback != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    if (adjustPurchaseVerificationResult == null) {
                        callback.invoke(writableMapCreateMap);
                        return;
                    }
                    writableMapCreateMap.putString("verificationStatus", adjustPurchaseVerificationResult.getVerificationStatus() != null ? adjustPurchaseVerificationResult.getVerificationStatus() : "");
                    writableMapCreateMap.putString(ResponseTypeValues.CODE, String.valueOf(adjustPurchaseVerificationResult.getCode()));
                    writableMapCreateMap.putString("message", adjustPurchaseVerificationResult.getMessage() != null ? adjustPurchaseVerificationResult.getMessage() : "");
                    callback.invoke(writableMapCreateMap);
                }
            }
        });
    }

    @ReactMethod
    public void enablePlayStoreKidsComplianceInDelay() {
        com.adjust.sdk.Adjust.enablePlayStoreKidsComplianceInDelay();
    }

    @ReactMethod
    public void disablePlayStoreKidsComplianceInDelay() {
        com.adjust.sdk.Adjust.disablePlayStoreKidsComplianceInDelay();
    }

    @ReactMethod
    public void getGoogleAdId(final Callback callback) {
        com.adjust.sdk.Adjust.getGoogleAdId(getReactApplicationContext(), new OnGoogleAdIdReadListener() { // from class: com.adjust.nativemodule.Adjust.13
            @Override // com.adjust.sdk.OnGoogleAdIdReadListener
            public void onGoogleAdIdRead(String str) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.invoke(str);
                }
            }
        });
    }

    @ReactMethod
    public void getAmazonAdId(final Callback callback) {
        com.adjust.sdk.Adjust.getAmazonAdId(getReactApplicationContext(), new OnAmazonAdIdReadListener() { // from class: com.adjust.nativemodule.Adjust.14
            @Override // com.adjust.sdk.OnAmazonAdIdReadListener
            public void onAmazonAdIdRead(String str) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.invoke(str);
                }
            }
        });
    }

    @ReactMethod
    public void onResume() {
        com.adjust.sdk.Adjust.onResume();
    }

    @ReactMethod
    public void onPause() {
        com.adjust.sdk.Adjust.onPause();
    }

    @ReactMethod
    public void setTestOptions(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        AdjustTestOptions adjustTestOptions = new AdjustTestOptions();
        if (checkKey(readableMap, "baseUrl")) {
            adjustTestOptions.baseUrl = readableMap.getString("baseUrl");
        }
        if (checkKey(readableMap, "gdprUrl")) {
            adjustTestOptions.gdprUrl = readableMap.getString("gdprUrl");
        }
        if (checkKey(readableMap, "subscriptionUrl")) {
            adjustTestOptions.subscriptionUrl = readableMap.getString("subscriptionUrl");
        }
        if (checkKey(readableMap, "purchaseVerificationUrl")) {
            adjustTestOptions.purchaseVerificationUrl = readableMap.getString("purchaseVerificationUrl");
        }
        if (checkKey(readableMap, "basePath")) {
            adjustTestOptions.basePath = readableMap.getString("basePath");
        }
        if (checkKey(readableMap, "gdprPath")) {
            adjustTestOptions.gdprPath = readableMap.getString("gdprPath");
        }
        if (checkKey(readableMap, "subscriptionPath")) {
            adjustTestOptions.subscriptionPath = readableMap.getString("subscriptionPath");
        }
        if (checkKey(readableMap, "purchaseVerificationPath")) {
            adjustTestOptions.purchaseVerificationPath = readableMap.getString("purchaseVerificationPath");
        }
        if (checkKey(readableMap, "timerIntervalInMilliseconds")) {
            try {
                adjustTestOptions.timerIntervalInMilliseconds = Long.valueOf(Long.parseLong(readableMap.getString("timerIntervalInMilliseconds")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if (checkKey(readableMap, "timerStartInMilliseconds")) {
            try {
                adjustTestOptions.timerStartInMilliseconds = Long.valueOf(Long.parseLong(readableMap.getString("timerStartInMilliseconds")));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        if (checkKey(readableMap, "sessionIntervalInMilliseconds")) {
            try {
                adjustTestOptions.sessionIntervalInMilliseconds = Long.valueOf(Long.parseLong(readableMap.getString("sessionIntervalInMilliseconds")));
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            }
        }
        if (checkKey(readableMap, "subsessionIntervalInMilliseconds")) {
            try {
                adjustTestOptions.subsessionIntervalInMilliseconds = Long.valueOf(Long.parseLong(readableMap.getString("subsessionIntervalInMilliseconds")));
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
        }
        if (checkKey(readableMap, "noBackoffWait")) {
            adjustTestOptions.noBackoffWait = Boolean.valueOf(readableMap.getBoolean("noBackoffWait"));
        }
        if (checkKey(readableMap, "teardown")) {
            adjustTestOptions.teardown = Boolean.valueOf(readableMap.getBoolean("teardown"));
        }
        if (checkKey(readableMap, "deleteState") && readableMap.getBoolean("deleteState")) {
            adjustTestOptions.context = getReactApplicationContext();
        }
        if (checkKey(readableMap, "ignoreSystemLifecycleBootstrap")) {
            adjustTestOptions.ignoreSystemLifecycleBootstrap = Boolean.valueOf(readableMap.getBoolean("ignoreSystemLifecycleBootstrap"));
        }
        com.adjust.sdk.Adjust.setTestOptions(adjustTestOptions);
    }

    @ReactMethod
    public void teardown() {
        this.isAttributionCallbackImplemented = false;
        this.isEventTrackingSucceededCallbackImplemented = false;
        this.isEventTrackingFailedCallbackImplemented = false;
        this.isSessionTrackingSucceededCallbackImplemented = false;
        this.isSessionTrackingFailedCallbackImplemented = false;
        this.isDeferredDeeplinkCallbackImplemented = false;
        this.isRemoteTriggerCallbackImplemented = false;
        this.isThirdPartySharingSettingsChangedCallbackImplemented = false;
    }

    private void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private boolean checkKey(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) && !readableMap.isNull(str);
    }
}
