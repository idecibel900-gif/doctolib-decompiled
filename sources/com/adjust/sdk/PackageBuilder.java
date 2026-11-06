package com.adjust.sdk;

import android.text.TextUtils;
import com.amazon.a.a.o.b;
import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private ActivityStateCopy activityStateCopy;
    private AdjustConfig adjustConfig;
    AdjustAttribution attribution;
    private long createdAt;
    String deeplink;
    private DeviceInfo deviceInfo;
    Map<String, String> extraParameters;
    private FirstSessionDelayManager firstSessionDelayManager;
    private GlobalParameters globalParameters;
    Boolean googlePlayInstant;
    String installVersion;
    ActivityHandler.InternalState internalState;
    Boolean isClick;
    LicenseData licenseData;
    String preinstallLocation;
    String preinstallPayload;
    String rawReferrer;
    String referrer;
    String referrerApi;
    String reftag;
    long clickTimeInSeconds = -1;
    long clickTimeInMilliseconds = -1;
    long installBeginTimeInSeconds = -1;
    long clickTimeServerInSeconds = -1;
    long installBeginTimeServerInSeconds = -1;

    public static class ActivityStateCopy {
        public final int a;
        public final int b;
        public final int c;
        public final long d;
        public final long e;
        public final String f;
        public final String g;

        public ActivityStateCopy(ActivityState activityState) {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1L;
            this.e = -1L;
            this.f = null;
            this.g = null;
            if (activityState == null) {
                return;
            }
            this.a = activityState.eventCount;
            this.b = activityState.sessionCount;
            this.c = activityState.subsessionCount;
            this.d = activityState.timeSpent;
            this.e = activityState.sessionLength;
            this.f = activityState.uuid;
            this.g = activityState.pushToken;
        }
    }

    public PackageBuilder(AdjustConfig adjustConfig, DeviceInfo deviceInfo, ActivityState activityState, GlobalParameters globalParameters, FirstSessionDelayManager firstSessionDelayManager, long j) {
        this.createdAt = j;
        this.deviceInfo = deviceInfo;
        this.adjustConfig = adjustConfig;
        this.activityStateCopy = new ActivityStateCopy(activityState);
        this.firstSessionDelayManager = firstSessionDelayManager;
        this.globalParameters = globalParameters;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (map == null || bool == null) {
            return;
        }
        addLong(map, str, bool.booleanValue() ? 1L : 0L);
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (map == null || date == null) {
            return;
        }
        addString(map, str, Util.dateFormatter.format(date));
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j) {
        if (map != null && j > 0) {
            addDate(map, str, new Date(j));
        }
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j) {
        if (map != null && j > 0) {
            addDate(map, str, new Date(j * 1000));
        }
    }

    public static void addDouble(Map<String, String> map, String str, double d) {
        if (map != null && d >= 0.0d) {
            addString(map, str, Double.toString(d));
        }
    }

    private static void addDoubleWithoutRounding(Map<String, String> map, String str, Double d) {
        if (map == null || d == null) {
            return;
        }
        addString(map, str, Double.toString(d.doubleValue()));
    }

    private static void addDuration(Map<String, String> map, String str, long j) {
        if (map != null && j >= 0) {
            addLong(map, str, (j + 500) / 1000);
        }
    }

    private static void addInteger(Map<String, String> map, String str, Integer num) {
        if (map == null || num == null) {
            return;
        }
        addString(map, str, Integer.toString(num.intValue()));
    }

    public static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (map == null || jSONObject == null) {
            return;
        }
        addString(map, str, jSONObject.toString());
    }

    public static void addLong(Map<String, String> map, String str, long j) {
        if (map != null && j >= 0) {
            addString(map, str, Long.toString(j));
        }
    }

    public static void addMapJson(Map<String, String> map, String str, Map map2) {
        if (map == null || map2 == null || map2.size() == 0) {
            return;
        }
        addString(map, str, new JSONObject(map2).toString());
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (map == null || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map == null || map.containsKey("android_id") || map.containsKey("gps_adid") || map.containsKey("fire_adid") || map.containsKey("oaid") || map.containsKey("imei") || map.containsKey("meid") || map.containsKey("device_id") || map.containsKey("imeis") || map.containsKey("meids") || map.containsKey("device_ids")) {
            return;
        }
        AdjustConfig adjustConfig = this.adjustConfig;
        if (adjustConfig.coppaComplianceEnabled) {
            logger.info("Missing Device IDs. COPPA enabled.", new Object[0]);
            return;
        }
        if (adjustConfig.playStoreKidsComplianceEnabled) {
            logger.info("Missing Device IDs. Play store kids compliance enabled.", new Object[0]);
            return;
        }
        if (!adjustConfig.isGoogleAdIdReadingEnabled) {
            logger.info("Missing Google Advertising ID, reading disabled.", new Object[0]);
            return;
        }
        if (!adjustConfig.isAndroidIdReadingEnabled) {
            logger.info("Missing Android ID, reading disabled.", new Object[0]);
        } else if (adjustConfig.isFireAdIdReadingEnabled) {
            logger.error("Missing Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
        } else {
            logger.info("Missing Fire Advertising ID, reading disabled.", new Object[0]);
        }
    }

    private boolean containsFireAdId(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("fire_adid");
    }

    private boolean containsGoogleAdId(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(AdjustAdRevenue adjustAdRevenue) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustAdRevenue.callbackParameters, "Callback"));
        addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustAdRevenue.partnerParameters, "Partner"));
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addString(map, com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE, adjustAdRevenue.source);
        addDoubleWithoutRounding(map, "revenue", adjustAdRevenue.revenue);
        addString(map, b.a, adjustAdRevenue.currency);
        addInteger(map, "ad_impressions_count", adjustAdRevenue.adImpressionsCount);
        addString(map, "ad_revenue_network", adjustAdRevenue.adRevenueNetwork);
        addString(map, "ad_revenue_unit", adjustAdRevenue.adRevenueUnit);
        addString(map, "ad_revenue_placement", adjustAdRevenue.adRevenuePlacement);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getAttributionParameters(String str) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "initiated_by", str);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getClickParameters(String str) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(map, "tracker", adjustAttribution.trackerName);
            addString(map, com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_CAMPAIGN, this.attribution.campaign);
            addString(map, "adgroup", this.attribution.adgroup);
            addString(map, "creative", this.attribution.creative);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addMapJson(map, Constants.CALLBACK_PARAMETERS, this.globalParameters.callbackParameters);
        addDateInMilliseconds(map, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(map, "click_time", this.clickTimeInSeconds);
        addDateInSeconds(map, "click_time_server", this.clickTimeServerInSeconds);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, Constants.DEEPLINK, this.deeplink);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addBoolean(map, "google_play_instant", this.googlePlayInstant);
        addBoolean(map, "is_click", this.isClick);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInSeconds(map, "install_begin_time", this.installBeginTimeInSeconds);
        addDateInSeconds(map, "install_begin_time_server", this.installBeginTimeServerInSeconds);
        addString(map, "install_version", this.installVersion);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addMapJson(map, "params", this.extraParameters);
        addMapJson(map, Constants.PARTNER_PARAMETERS, this.globalParameters.partnerParameters);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "raw_referrer", this.rawReferrer);
        addString(map, Constants.REFERRER, this.referrer);
        addString(map, "referrer_api", this.referrerApi);
        addString(map, Constants.REFTAG, this.reftag);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addString(map, com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE, str);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, "payload", this.preinstallPayload);
        addString(map, "found_location", this.preinstallLocation);
        LicenseData licenseData = this.licenseData;
        if (licenseData != null) {
            addInteger(map, "lvl_response_code", Integer.valueOf(licenseData.getResponseCode()));
            addString(map, "lvl_signed_data", this.licenseData.getSignedData());
            addString(map, "lvl_signature", this.licenseData.getSignature());
        }
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        Double d = adjustEvent.revenue;
        return d == null ? Util.formatString("'%s'", adjustEvent.eventToken) : Util.formatString("(%.5f %s, '%s')", d, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getInfoParameters(String str) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "app_token", this.adjustConfig.appToken);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_SOURCE, str);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getMeasurementConsentParameters(boolean z) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        addString(map, "measurement", z ? "enable" : "disable");
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSessionParameters() {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        addMapJson(map, Constants.CALLBACK_PARAMETERS, this.globalParameters.callbackParameters);
        addMapJson(map, Constants.PARTNER_PARAMETERS, this.globalParameters.partnerParameters);
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectStoreInfoToParameters(map);
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
        addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, b.a, adjustPlayStoreSubscription.getCurrency());
        addString(map, DiagnosticsTracker.PRODUCT_ID_KEY, adjustPlayStoreSubscription.getSku());
        addString(map, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(map, b.D, adjustPlayStoreSubscription.getSignature());
        addLong(map, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(map, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(map, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getThirdPartySharingParameters(AdjustThirdPartySharing adjustThirdPartySharing) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        Boolean bool = adjustThirdPartySharing.isEnabled;
        if (bool != null) {
            addString(map, "sharing", bool.booleanValue() ? "enable" : "disable");
        }
        addMapJson(map, "granular_third_party_sharing_options", adjustThirdPartySharing.granularOptions);
        addMapJson(map, "partner_sharing_settings", adjustThirdPartySharing.partnerSharingSettings);
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool2 = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool2);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(map, "needs_response_details", bool2);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool2 = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool2);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private Map<String, String> getVerificationParameters(AdjustPlayStorePurchase adjustPlayStorePurchase) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, DiagnosticsTracker.PRODUCT_ID_KEY, adjustPlayStorePurchase.getProductId());
        addString(map, "purchase_token", adjustPlayStorePurchase.getPurchaseToken());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private void injectFeatureFlagsWithParameters(Map<String, String> map) {
        if (this.adjustConfig.coppaComplianceEnabled) {
            addLong(map, "ff_coppa", 1L);
        }
        ActivityHandler.InternalState internalState = this.internalState;
        if (internalState != null) {
            addBoolean(map, "offline_mode_enabled", Boolean.valueOf(internalState.offline));
            if (this.internalState.isInForeground()) {
                addBoolean(map, "foreground", Boolean.TRUE);
            } else {
                addBoolean(map, AppStateModule.APP_STATE_BACKGROUND, Boolean.TRUE);
            }
        }
        if (this.adjustConfig.playStoreKidsComplianceEnabled) {
            addLong(map, "ff_play_store_kids_app", 1L);
        }
        int i = this.firstSessionDelayManager.c;
        if (i != 2 && i != 0) {
            addBoolean(map, "ff_first_session_delay", Boolean.TRUE);
        }
        if (!this.adjustConfig.isGoogleAdIdReadingEnabled) {
            addBoolean(map, "ff_gps_adid_disabled", Boolean.TRUE);
        }
        if (!this.adjustConfig.isAndroidIdReadingEnabled) {
            addBoolean(map, "ff_android_id_disabled", Boolean.TRUE);
        }
        if (!this.adjustConfig.isAppSetIdReadingEnabled) {
            addBoolean(map, "ff_app_set_id_disabled", Boolean.TRUE);
        }
        if (!this.adjustConfig.isFbIdReadingEnabled) {
            addBoolean(map, "ff_fb_id_disabled", Boolean.TRUE);
        }
        if (!this.adjustConfig.isFireAdIdReadingEnabled) {
            addBoolean(map, "ff_fire_adid_disabled", Boolean.TRUE);
        }
        if (!this.adjustConfig.isDeviceIdsFromPluginsReadingEnabled) {
            addBoolean(map, "ff_plugins_device_ids_disabled", Boolean.TRUE);
        }
        if (this.adjustConfig.onRemoteTriggerListener != null) {
            addBoolean(map, "ff_remote_triggers_callback", Boolean.TRUE);
        }
    }

    private void injectStoreInfoToParameters(Map<String, String> map) {
        AdjustStoreInfo adjustStoreInfo = this.deviceInfo.storeInfoFromClient;
        if (adjustStoreInfo != null) {
            addString(map, "store_name_from_client", adjustStoreInfo.storeName);
            addString(map, "store_app_id_from_client", this.deviceInfo.storeInfoFromClient.storeAppId);
        }
        addString(map, "store_name_from_system", this.deviceInfo.storeIdFromSystem);
        addString(map, "initiating_package_name", this.deviceInfo.initiatingPackageName);
        addString(map, "originating_package_name", this.deviceInfo.originatingPackageName);
        addBoolean(map, "is_system_app", this.deviceInfo.isSystemApp);
        addBoolean(map, "is_updated_system_app", this.deviceInfo.isUpdatedSystemApp);
    }

    public ActivityPackage buildAdRevenuePackage(AdjustAdRevenue adjustAdRevenue) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(adjustAdRevenue);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.AD_REVENUE);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(adRevenueParameters);
        defaultActivityPackage.setCallbackParameters(adjustAdRevenue.callbackParameters);
        defaultActivityPackage.setPartnerParameters(adjustAdRevenue.partnerParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.ATTRIBUTION);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.CLICK);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        defaultActivityPackage.setClickTimeServerInSeconds(this.clickTimeServerInSeconds);
        defaultActivityPackage.setInstallBeginTimeServerInSeconds(this.installBeginTimeServerInSeconds);
        defaultActivityPackage.setInstallVersion(this.installVersion);
        defaultActivityPackage.setGooglePlayInstant(this.googlePlayInstant);
        defaultActivityPackage.setIsClick(this.isClick);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildEventPackage(AdjustEvent adjustEvent, int i) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent, i);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.EVENT);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        defaultActivityPackage.setParameters(eventParameters);
        defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
        defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.GDPR);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.INFO);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildMeasurementConsentPackage(boolean z) {
        Map<String, String> measurementConsentParameters = getMeasurementConsentParameters(z);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.MEASUREMENT_CONSENT);
        defaultActivityPackage.setPath("/measurement_consent");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(measurementConsentParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSessionPackage() {
        Map<String, String> sessionParameters = getSessionParameters();
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SESSION);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(sessionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.SUBSCRIPTION);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildThirdPartySharingPackage(AdjustThirdPartySharing adjustThirdPartySharing) {
        Map<String, String> thirdPartySharingParameters = getThirdPartySharingParameters(adjustThirdPartySharing);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.THIRD_PARTY_SHARING);
        defaultActivityPackage.setPath("/third_party_sharing");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setParameters(thirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildVerificationPackage(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        Map<String, String> verificationParameters = getVerificationParameters(adjustPlayStorePurchase);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.PURCHASE_VERIFICATION);
        defaultActivityPackage.setPath("/verify");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setPurchaseVerificationCallback(onPurchaseVerificationFinishedListener);
        defaultActivityPackage.setParameters(verificationParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent, int i) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        addMapJson(map, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.globalParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
        addMapJson(map, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.globalParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        addString(map, "google_app_set_id", this.deviceInfo.appSetId);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, b.a, adjustEvent.currency);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "event_callback_id", adjustEvent.callbackId);
        addLong(map, "event_count", this.activityStateCopy.a);
        addString(map, "event_token", adjustEvent.eventToken);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, DiagnosticsTracker.PRODUCT_ID_KEY, adjustEvent.productId);
        addString(map, "purchase_token", adjustEvent.purchaseToken);
        addString(map, "push_token", this.activityStateCopy.g);
        addDouble(map, "revenue", adjustEvent.revenue);
        addString(map, "order_id", adjustEvent.orderId);
        addString(map, "deduplication_id", adjustEvent.deduplicationId);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addInteger(map, "seq", Integer.valueOf(i));
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        addJsonObject(map, "control_params", SharedPreferencesManager.getDefaultInstance(this.adjustConfig.context).getControlParamsJson());
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }

    private static void addDouble(Map<String, String> map, String str, Double d) {
        if (map == null || d == null) {
            return;
        }
        addString(map, str, Util.formatString("%.5f", d));
    }

    public ActivityPackage buildVerificationPackage(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener) {
        Map<String, String> verificationParameters = getVerificationParameters(adjustEvent);
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(ActivityKind.PURCHASE_VERIFICATION);
        defaultActivityPackage.setPath("/verify");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setPurchaseVerificationCallback(onPurchaseVerificationFinishedListener);
        defaultActivityPackage.setParameters(verificationParameters);
        return defaultActivityPackage;
    }

    private Map<String, String> getVerificationParameters(AdjustEvent adjustEvent) {
        HashMap map = new HashMap();
        this.deviceInfo.reloadOtherDeviceInfoParams(this.adjustConfig, logger);
        Map<String, String> map2 = this.deviceInfo.imeiParameters;
        if (map2 != null) {
            map.putAll(map2);
        }
        Map<String, String> map3 = this.deviceInfo.oaidParameters;
        if (map3 != null) {
            map.putAll(map3);
        }
        this.deviceInfo.reloadGoogleAdId(this.adjustConfig);
        addString(map, "android_uuid", this.activityStateCopy.f);
        addString(map, "gps_adid", this.deviceInfo.googleAdId);
        addLong(map, "gps_adid_attempt", this.deviceInfo.googleAdIdReadAttempt);
        addString(map, "gps_adid_src", this.deviceInfo.googleAdIdSource);
        addBoolean(map, "tracking_enabled", this.deviceInfo.isTrackingEnabled);
        addString(map, "fire_adid", this.deviceInfo.fireAdId);
        addBoolean(map, "fire_tracking_enabled", this.deviceInfo.fireTrackingEnabled);
        if (!containsGoogleAdId(map) && !containsFireAdId(map)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.readAndroidId(this.adjustConfig);
            addString(map, "android_id", this.deviceInfo.androidId);
        }
        addString(map, "api_level", this.deviceInfo.apiLevel);
        addString(map, "app_token", this.adjustConfig.appToken);
        addString(map, "app_version", this.deviceInfo.appVersion);
        Boolean bool = Boolean.TRUE;
        addBoolean(map, "attribution_deeplink", bool);
        addLong(map, "connectivity_type", this.deviceInfo.connectivityType);
        addString(map, "country", this.deviceInfo.country);
        addString(map, "cpu_type", this.deviceInfo.abi);
        addDateInMilliseconds(map, "created_at", this.createdAt);
        addString(map, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(map, "needs_cost", this.adjustConfig.isCostDataInAttributionEnabled);
        addString(map, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(map, "device_name", this.deviceInfo.deviceName);
        addString(map, "device_type", this.deviceInfo.deviceType);
        addLong(map, "ui_mode", this.deviceInfo.uiMode);
        addString(map, "display_height", this.deviceInfo.displayHeight);
        addString(map, "display_width", this.deviceInfo.displayWidth);
        addString(map, "environment", this.adjustConfig.environment);
        addString(map, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(map, "fb_id", this.deviceInfo.fbAttributionId);
        addString(map, "hardware_name", this.deviceInfo.hardwareName);
        addDateInMilliseconds(map, "installed_at", this.deviceInfo.appInstallTime);
        addString(map, "language", this.deviceInfo.language);
        addString(map, "mcc", this.deviceInfo.mcc);
        addString(map, "mnc", this.deviceInfo.mnc);
        addBoolean(map, "needs_response_details", bool);
        addString(map, "os_build", this.deviceInfo.buildName);
        addString(map, "os_name", this.deviceInfo.osName);
        addString(map, "os_version", this.deviceInfo.osVersion);
        addString(map, "package_name", this.deviceInfo.packageName);
        addString(map, "push_token", this.activityStateCopy.g);
        addString(map, "screen_density", this.deviceInfo.screenDensity);
        addString(map, "screen_format", this.deviceInfo.screenFormat);
        addString(map, "screen_size", this.deviceInfo.screenSize);
        addLong(map, "session_count", this.activityStateCopy.b);
        addDuration(map, "session_length", this.activityStateCopy.e);
        addLong(map, "subsession_count", this.activityStateCopy.c);
        addDuration(map, "time_spent", this.activityStateCopy.d);
        addString(map, "updated_at", this.deviceInfo.appUpdateTime);
        addString(map, DiagnosticsTracker.PRODUCT_ID_KEY, adjustEvent.getProductId());
        addString(map, "purchase_token", adjustEvent.getPurchaseToken());
        addString(map, "event_token", adjustEvent.getEventToken());
        addString(map, b.a, adjustEvent.getCurrency());
        addDouble(map, "revenue", adjustEvent.getRevenue());
        if (!this.deviceInfo.isGooglePlayGamesForPC) {
            bool = null;
        }
        addBoolean(map, "gpg_pc_enabled", bool);
        injectFeatureFlagsWithParameters(map);
        checkDeviceIds(map);
        return map;
    }
}
