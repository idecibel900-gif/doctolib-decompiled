package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import io.didomi.ssl.config.app.SyncConfiguration;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
class DeviceInfo {
    private static final String OFFICIAL_FACEBOOK_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    String abi;
    String androidId;
    String apiLevel;
    long appInstallTime;
    String appSetId;
    String appUpdateTime;
    String appVersion;
    String buildName;
    String clientSdk;
    int connectivityType;
    String country;
    String deviceManufacturer;
    String deviceName;
    String deviceType;
    String displayHeight;
    String displayWidth;
    String fbAttributionId;
    String fireAdId;
    Boolean fireTrackingEnabled;
    String googleAdId;
    String googleAdIdSource;
    String hardwareName;
    Map<String, String> imeiParameters;
    String initiatingPackageName;
    boolean isGooglePlayGamesForPC;
    Boolean isSystemApp;
    Boolean isTrackingEnabled;
    Boolean isUpdatedSystemApp;
    String language;
    String mcc;
    String mnc;
    Map<String, String> oaidParameters;
    String originatingPackageName;
    String osName;
    String osVersion;
    String packageName;
    String screenDensity;
    String screenFormat;
    String screenSize;
    String storeIdFromSystem;
    AdjustStoreInfo storeInfoFromClient;
    int uiMode;
    int googleAdIdReadAttempt = -1;
    private boolean androidIdReadOnce = false;
    private boolean googleAdIdReadOnce = false;
    private boolean otherDeviceIdsParamsReadOnce = false;

    public DeviceInfo(AdjustConfig adjustConfig) {
        Context context = adjustConfig.context;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale locale = Util.getLocale(configuration);
        PackageInfo packageInfo = getPackageInfo(context);
        int i = configuration.screenLayout;
        this.isGooglePlayGamesForPC = Util.isGooglePlayGamesForPC(context);
        this.packageName = getPackageName(context);
        this.appVersion = getAppVersion(packageInfo);
        this.deviceType = getDeviceType(configuration);
        this.deviceName = getDeviceName();
        this.deviceManufacturer = getDeviceManufacturer();
        this.osName = getOsName();
        this.osVersion = getOsVersion();
        this.apiLevel = getApiLevel();
        this.language = getLanguage(locale);
        this.country = getCountry(locale);
        this.screenSize = getScreenSize(i);
        this.screenFormat = getScreenFormat(i);
        this.screenDensity = getScreenDensity(displayMetrics);
        this.displayWidth = getDisplayWidth(displayMetrics);
        this.displayHeight = getDisplayHeight(displayMetrics);
        this.clientSdk = getClientSdk(adjustConfig.sdkPrefix);
        if (Util.isFbIdReadingEnabled(adjustConfig)) {
            this.fbAttributionId = getFacebookAttributionId(context);
        }
        this.hardwareName = getHardwareName();
        this.abi = getABI();
        this.buildName = getBuildName();
        this.appInstallTime = getAppInstallTime(packageInfo);
        this.appUpdateTime = getAppUpdateTime(packageInfo);
        this.uiMode = getDeviceUiMode(configuration);
        if (Util.isAppSetIdReadingEnabled(adjustConfig)) {
            this.appSetId = Reflection.getAppSetId(context);
        }
        this.storeInfoFromClient = StoreInfoUtil.getStoreInfoFromClient(adjustConfig, context);
        this.storeIdFromSystem = StoreInfoUtil.getStoreIdFromSystem(context);
        this.initiatingPackageName = StoreInfoUtil.getInitiatingPackageName(context);
        this.originatingPackageName = StoreInfoUtil.getOriginatingPackageName(context);
        this.isSystemApp = StoreInfoUtil.getIsSystemApp(context);
        this.isUpdatedSystemApp = StoreInfoUtil.getIsUpdatedSystemApp(context);
    }

    private String getABI() {
        String[] supportedAbis = Util.getSupportedAbis();
        return (supportedAbis == null || supportedAbis.length == 0) ? Util.getCpuAbi() : supportedAbis[0];
    }

    private String getApiLevel() {
        return "" + Build.VERSION.SDK_INT;
    }

    private long getAppInstallTime(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return 0L;
        }
        return packageInfo.firstInstallTime;
    }

    private String getAppUpdateTime(PackageInfo packageInfo) {
        try {
            return Util.dateFormatter.format(new Date(packageInfo.lastUpdateTime));
        } catch (Exception unused) {
            return null;
        }
    }

    private String getAppVersion(PackageInfo packageInfo) {
        try {
            return packageInfo.versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    private String getBuildName() {
        return Build.ID;
    }

    private String getCountry(Locale locale) {
        return locale.getCountry();
    }

    private String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    private String getDeviceName() {
        if (this.isGooglePlayGamesForPC) {
            return null;
        }
        return Build.MODEL;
    }

    private String getDeviceType(Configuration configuration) {
        if (this.isGooglePlayGamesForPC) {
            return "pc";
        }
        if ((configuration.uiMode & 15) == 4) {
            return "tv";
        }
        int i = configuration.screenLayout & 15;
        if (i == 1 || i == 2) {
            return AuthorizationRequest.Scope.PHONE;
        }
        if (i == 3 || i == 4) {
            return "tablet";
        }
        return null;
    }

    private int getDeviceUiMode(Configuration configuration) {
        return configuration.uiMode & 15;
    }

    private String getDisplayHeight(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.heightPixels);
    }

    private String getDisplayWidth(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.widthPixels);
    }

    private String getFacebookAttributionId(Context context) {
        Signature[] apkContentsSigners;
        Cursor cursorQuery;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo("com.facebook.katana", 134217728).signingInfo;
                apkContentsSigners = signingInfo != null ? signingInfo.getApkContentsSigners() : null;
            } else {
                apkContentsSigners = context.getPackageManager().getPackageInfo("com.facebook.katana", 64).signatures;
            }
            if (apkContentsSigners == null || apkContentsSigners.length != 1 || !OFFICIAL_FACEBOOK_SIGNATURE.equals(apkContentsSigners[0].toCharsString()) || (cursorQuery = context.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[]{"aid"}, null, null, null)) == null) {
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("aid"));
            cursorQuery.close();
            return string;
        } catch (Exception unused) {
        }
        return null;
    }

    public static void getFireAdvertisingIdBypassConditions(ContentResolver contentResolver, OnAmazonAdIdReadListener onAmazonAdIdReadListener) {
        UtilDeviceIds.getFireAdvertisingIdAsync(contentResolver, onAmazonAdIdReadListener);
    }

    private String getHardwareName() {
        return Build.DISPLAY;
    }

    private String getLanguage(Locale locale) {
        return locale.getLanguage();
    }

    private String getOsName() {
        return this.isGooglePlayGamesForPC ? "windows" : "android";
    }

    private String getOsVersion() {
        if (this.isGooglePlayGamesForPC) {
            return null;
        }
        return Build.VERSION.RELEASE;
    }

    private PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getPackageName(Context context) {
        return context.getPackageName();
    }

    private String getScreenDensity(DisplayMetrics displayMetrics) {
        int i = displayMetrics.densityDpi;
        if (i == 0) {
            return null;
        }
        if (i < 140) {
            return Constants.LOW;
        }
        return i > 200 ? Constants.HIGH : "medium";
    }

    private String getScreenFormat(int i) {
        int i2 = i & 48;
        if (i2 == 16) {
            return Constants.NORMAL;
        }
        if (i2 != 32) {
            return null;
        }
        return Constants.LONG;
    }

    private String getScreenSize(int i) {
        int i2 = i & 15;
        if (i2 == 1) {
            return Constants.SMALL;
        }
        if (i2 == 2) {
            return Constants.NORMAL;
        }
        if (i2 == 3) {
            return Constants.LARGE;
        }
        if (i2 != 4) {
            return null;
        }
        return Constants.XLARGE;
    }

    public void readAndroidId(AdjustConfig adjustConfig) {
        if (Util.isAndroidIdReadingEnabled(adjustConfig) && !this.androidIdReadOnce) {
            this.androidId = Util.getAndroidId(adjustConfig.context);
            this.androidIdReadOnce = true;
        }
    }

    public void reloadGoogleAdId(AdjustConfig adjustConfig) {
        if (this.googleAdIdReadOnce && adjustConfig.isDeviceIdsReadingOnceEnabled) {
            if (Util.isGoogleAdIdReadingEnabled(adjustConfig)) {
                return;
            }
            this.googleAdId = null;
            this.isTrackingEnabled = null;
            this.googleAdIdSource = null;
            this.googleAdIdReadAttempt = -1;
            return;
        }
        this.googleAdId = null;
        this.isTrackingEnabled = null;
        this.googleAdIdSource = null;
        this.googleAdIdReadAttempt = -1;
        if (Util.isGoogleAdIdReadingEnabled(adjustConfig)) {
            Context context = adjustConfig.context;
            if (Reflection.isAppRunningInSamsungCloudEnvironment(context, adjustConfig.logger)) {
                this.googleAdId = Reflection.getSamsungCloudDevGoogleAdId(context, adjustConfig.logger);
                this.googleAdIdSource = "samsung_cloud_sdk";
                this.googleAdIdReadOnce = true;
            }
            String str = this.googleAdId;
            Boolean bool = this.isTrackingEnabled;
            for (int i = 1; i <= 3; i++) {
                try {
                    GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, i * SyncConfiguration.DEFAULT_TIMEOUT);
                    if (this.googleAdId == null) {
                        this.googleAdId = googlePlayServicesInfo.getGpsAdid();
                        this.googleAdIdReadOnce = true;
                    }
                    if (this.isTrackingEnabled == null) {
                        this.isTrackingEnabled = googlePlayServicesInfo.isTrackingEnabled();
                    }
                    if (this.googleAdId != null && this.isTrackingEnabled != null) {
                        this.googleAdIdSource = "service";
                        this.googleAdIdReadAttempt = i;
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            for (int i2 = 1; i2 <= 3; i2++) {
                Object advertisingInfoObject = Util.getAdvertisingInfoObject(context, 11000L);
                if (advertisingInfoObject != null) {
                    if (this.googleAdId == null) {
                        this.googleAdId = Util.getGoogleAdId(context, advertisingInfoObject, 1000L);
                        this.googleAdIdReadOnce = true;
                    }
                    if (this.isTrackingEnabled == null) {
                        this.isTrackingEnabled = Util.isGoogleAdIdTrackingEnabled(context, advertisingInfoObject, 1000L);
                    }
                    if (this.googleAdId != null && this.isTrackingEnabled != null) {
                        this.googleAdIdSource = "library";
                        this.googleAdIdReadAttempt = i2;
                        return;
                    }
                }
            }
            if (this.googleAdId == null) {
                this.googleAdId = str;
                this.googleAdIdReadOnce = true;
            }
            if (this.isTrackingEnabled == null) {
                this.isTrackingEnabled = bool;
            }
        }
    }

    public void reloadOtherDeviceInfoParams(AdjustConfig adjustConfig, ILogger iLogger) {
        if (adjustConfig.isDeviceIdsReadingOnceEnabled && this.otherDeviceIdsParamsReadOnce) {
            return;
        }
        this.imeiParameters = UtilDeviceIds.getImeiParameters(adjustConfig, iLogger);
        this.oaidParameters = UtilDeviceIds.getOaidParameters(adjustConfig, iLogger);
        this.fireAdId = UtilDeviceIds.getFireAdvertisingId(adjustConfig);
        this.fireTrackingEnabled = UtilDeviceIds.getFireTrackingEnabled(adjustConfig);
        this.connectivityType = UtilDeviceIds.getConnectivityType(adjustConfig.context, iLogger);
        this.mcc = UtilDeviceIds.getMcc(adjustConfig.context, iLogger);
        this.mnc = UtilDeviceIds.getMnc(adjustConfig.context, iLogger);
        this.otherDeviceIdsParamsReadOnce = true;
    }

    private String getClientSdk(String str) {
        return str == null ? Constants.CLIENT_SDK : Util.formatString("%s@%s", str, Constants.CLIENT_SDK);
    }

    public static class UtilDeviceIds {
        private UtilDeviceIds() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getConnectivityType(Context context, ILogger iLogger) {
            NetworkCapabilities networkCapabilities;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return -1;
                }
                int i = Build.VERSION.SDK_INT;
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                    return -1;
                }
                if (networkCapabilities.hasTransport(1)) {
                    return 1;
                }
                if (networkCapabilities.hasTransport(0)) {
                    return 0;
                }
                if (networkCapabilities.hasTransport(3)) {
                    return 3;
                }
                if (networkCapabilities.hasTransport(4)) {
                    return 4;
                }
                if (networkCapabilities.hasTransport(2)) {
                    return 2;
                }
                if (i < 26) {
                    return -1;
                }
                if (networkCapabilities.hasTransport(5)) {
                    return 5;
                }
                if (i >= 27 && networkCapabilities.hasTransport(6)) {
                    return 6;
                }
            } catch (Exception e) {
                iLogger.warn("Couldn't read connectivity type (%s)", e.getMessage());
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getFireAdvertisingId(AdjustConfig adjustConfig) {
            if (Util.isFireAdIdReadingEnabled(adjustConfig)) {
                return getFireAdvertisingId(adjustConfig.context.getContentResolver());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void getFireAdvertisingIdAsync(ContentResolver contentResolver, OnAmazonAdIdReadListener onAmazonAdIdReadListener) {
            if (contentResolver == null) {
                AdjustFactory.getLogger().error("contentResolver could not be retrieved", new Object[0]);
                return;
            }
            try {
                onAmazonAdIdReadListener.onAmazonAdIdRead(Settings.Secure.getString(contentResolver, "advertising_id"));
            } catch (Exception e) {
                AdjustFactory.getLogger().error(e.getMessage(), new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Boolean getFireTrackingEnabled(AdjustConfig adjustConfig) {
            if (Util.isFireAdIdReadingEnabled(adjustConfig)) {
                return getFireTrackingEnabled(adjustConfig.context.getContentResolver());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, String> getImeiParameters(AdjustConfig adjustConfig, ILogger iLogger) {
            if (Util.isDeviceIdsFromPluginsReadingEnabled(adjustConfig)) {
                return Reflection.getImeiParameters(adjustConfig.context, iLogger);
            }
            return null;
        }

        public static String getMcc(Context context, ILogger iLogger) {
            try {
                String networkOperator = ((TelephonyManager) context.getSystemService(AuthorizationRequest.Scope.PHONE)).getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    return networkOperator.substring(0, 3);
                }
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
                return null;
            } catch (Exception unused) {
                AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getMnc(Context context, ILogger iLogger) {
            try {
                String networkOperator = ((TelephonyManager) context.getSystemService(AuthorizationRequest.Scope.PHONE)).getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    return networkOperator.substring(3);
                }
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
                return null;
            } catch (Exception unused) {
                iLogger.warn("Couldn't return mnc", new Object[0]);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Map<String, String> getOaidParameters(AdjustConfig adjustConfig, ILogger iLogger) {
            if (Util.isDeviceIdsFromPluginsReadingEnabled(adjustConfig)) {
                return Reflection.getOaidParameters(adjustConfig.context, iLogger);
            }
            return null;
        }

        private static String getFireAdvertisingId(ContentResolver contentResolver) {
            if (contentResolver == null) {
                return null;
            }
            try {
                return Settings.Secure.getString(contentResolver, "advertising_id");
            } catch (Exception unused) {
                return null;
            }
        }

        private static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
            try {
                return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
