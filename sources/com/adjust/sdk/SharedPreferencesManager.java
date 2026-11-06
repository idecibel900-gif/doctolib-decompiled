package com.adjust.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SharedPreferencesManager {
    private static final int INDEX_CLICK_TIME = 1;
    private static final int INDEX_IS_SENDING = 2;
    private static final int INDEX_RAW_REFERRER = 0;
    private static final String PREFS_KEY_CONTROL_PARAMS = "control_params";
    private static final String PREFS_KEY_DEEPLINK_CLICK_TIME = "deeplink_click_time";
    private static final String PREFS_KEY_DEEPLINK_REFERRER = "deeplink_referrer";
    private static final String PREFS_KEY_DEEPLINK_URL = "deeplink_url";
    private static final String PREFS_KEY_DEEPLINK_URL_CACHED = "deeplink_url_cached";
    private static final String PREFS_KEY_GDPR_FORGET_ME = "gdpr_forget_me";
    private static final String PREFS_KEY_INSTALL_TRACKED = "install_tracked";
    private static final String PREFS_KEY_LVL_TRACKED = "lvl_tracked";
    private static final String PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS = "preinstall_payload_read_status";
    private static final String PREFS_KEY_PREINSTALL_SYSTEM_INSTALLER_REFERRER = "preinstall_system_installer_referrer";
    private static final String PREFS_KEY_PUSH_TOKEN = "push_token";
    private static final String PREFS_KEY_RAW_REFERRERS = "raw_referrers";
    private static final String PREFS_KEY_TPS_RESULT_SETTINGS = "tps_result_settings";
    private static final String PREFS_NAME = "adjust_preferences";
    private static final int REFERRERS_COUNT = 10;
    private static SharedPreferencesManager defaultInstance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;

    private SharedPreferencesManager(Context context) {
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(PREFS_NAME, 0);
            sharedPreferences = sharedPreferences2;
            sharedPreferencesEditor = sharedPreferences2.edit();
        } catch (Exception e) {
            AdjustFactory.getLogger().error("Cannot access to SharedPreferences", e.getMessage());
            sharedPreferences = null;
            sharedPreferencesEditor = null;
        }
    }

    private synchronized boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            try {
                return sharedPreferences2.getBoolean(str, z);
            } catch (ClassCastException unused) {
            }
        }
        return z;
    }

    public static synchronized SharedPreferencesManager getDefaultInstance(Context context) {
        try {
            if (defaultInstance == null) {
                defaultInstance = new SharedPreferencesManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultInstance;
    }

    private synchronized long getLong(String str, long j) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            try {
                return sharedPreferences2.getLong(str, j);
            } catch (ClassCastException unused) {
            }
        }
        return j;
    }

    private synchronized int getRawReferrerIndex(String str, long j) {
        try {
            JSONArray rawReferrerArray = getRawReferrerArray();
            for (int i = 0; i < rawReferrerArray.length(); i++) {
                JSONArray jSONArray = rawReferrerArray.getJSONArray(i);
                String strOptString = jSONArray.optString(0, null);
                if (strOptString != null && strOptString.equals(str) && jSONArray.optLong(1, -1L) == j) {
                    return i;
                }
            }
        } catch (JSONException unused) {
        }
        return -1;
    }

    private synchronized String getString(String str) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            return null;
        }
        try {
            return sharedPreferences2.getString(str, null);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable unused2) {
            if (str.equals(PREFS_KEY_RAW_REFERRERS)) {
                remove(PREFS_KEY_RAW_REFERRERS);
            }
            return null;
        }
    }

    private synchronized void remove(String str) {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.remove(str).apply();
        }
    }

    private synchronized void saveBoolean(String str, boolean z) {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.putBoolean(str, z).apply();
        }
    }

    private synchronized void saveInteger(String str, int i) {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.putInt(str, i).apply();
        }
    }

    private synchronized void saveLong(String str, long j) {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.putLong(str, j).apply();
        }
    }

    private synchronized void saveString(String str, String str2) {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.putString(str, str2).apply();
        }
    }

    public synchronized void cacheDeeplink(Uri uri) {
        if (uri == null) {
            return;
        }
        saveString(PREFS_KEY_DEEPLINK_URL_CACHED, uri.toString());
    }

    public synchronized void clear() {
        SharedPreferences.Editor editor = sharedPreferencesEditor;
        if (editor != null) {
            editor.clear().apply();
        }
    }

    public synchronized String getCachedDeeplink() {
        return getString(PREFS_KEY_DEEPLINK_URL_CACHED);
    }

    public synchronized JSONObject getControlParamsJson() {
        String string = getString(PREFS_KEY_CONTROL_PARAMS);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public synchronized long getDeeplinkClickTime() {
        return getLong(PREFS_KEY_DEEPLINK_CLICK_TIME, -1L);
    }

    public synchronized String getDeeplinkReferrer() {
        return getString(PREFS_KEY_DEEPLINK_REFERRER);
    }

    public synchronized String getDeeplinkUrl() {
        return getString(PREFS_KEY_DEEPLINK_URL);
    }

    public synchronized boolean getGdprForgetMe() {
        return getBoolean(PREFS_KEY_GDPR_FORGET_ME, false);
    }

    public synchronized boolean getInstallTracked() {
        return getBoolean(PREFS_KEY_INSTALL_TRACKED, false);
    }

    public synchronized boolean getLicenseVerificationTracked() {
        return getBoolean(PREFS_KEY_LVL_TRACKED, false);
    }

    public synchronized long getPreinstallPayloadReadStatus() {
        return getLong(PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS, 0L);
    }

    public synchronized String getPreinstallReferrer() {
        return getString(PREFS_KEY_PREINSTALL_SYSTEM_INSTALLER_REFERRER);
    }

    public synchronized String getPushToken() {
        return getString(PREFS_KEY_PUSH_TOKEN);
    }

    public synchronized JSONArray getRawReferrer(String str, long j) {
        int rawReferrerIndex = getRawReferrerIndex(str, j);
        if (rawReferrerIndex >= 0) {
            try {
                return getRawReferrerArray().getJSONArray(rawReferrerIndex);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public synchronized JSONArray getRawReferrerArray() {
        String string = getString(PREFS_KEY_RAW_REFERRERS);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() <= 10) {
                    return new JSONArray(string);
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < 10; i++) {
                    jSONArray2.put(jSONArray.get(i));
                }
                saveRawReferrerArray(jSONArray2);
                return jSONArray2;
            } catch (Throwable unused) {
            }
        }
        return new JSONArray();
    }

    public synchronized AdjustThirdPartySharingResult getThirdPartySharingResult() {
        String string = getString(PREFS_KEY_TPS_RESULT_SETTINGS);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new AdjustThirdPartySharingResult(string);
    }

    public synchronized void removeDeeplink() {
        remove(PREFS_KEY_DEEPLINK_URL);
        remove(PREFS_KEY_DEEPLINK_REFERRER);
        remove(PREFS_KEY_DEEPLINK_CLICK_TIME);
    }

    public synchronized void removeGdprForgetMe() {
        remove(PREFS_KEY_GDPR_FORGET_ME);
    }

    public synchronized void removePreinstallReferrer() {
        remove(PREFS_KEY_PREINSTALL_SYSTEM_INSTALLER_REFERRER);
    }

    public synchronized void removePushToken() {
        remove(PREFS_KEY_PUSH_TOKEN);
    }

    public synchronized void removeRawReferrer(String str, long j) {
        int rawReferrerIndex;
        if (str != null) {
            if (str.length() != 0 && (rawReferrerIndex = getRawReferrerIndex(str, j)) >= 0) {
                JSONArray rawReferrerArray = getRawReferrerArray();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < rawReferrerArray.length(); i++) {
                    if (i != rawReferrerIndex) {
                        try {
                            jSONArray.put(rawReferrerArray.getJSONArray(i));
                        } catch (JSONException unused) {
                        }
                    }
                }
                saveString(PREFS_KEY_RAW_REFERRERS, jSONArray.toString());
            }
        }
    }

    public synchronized void saveControlParams(JSONObject jSONObject) {
        try {
            saveString(PREFS_KEY_CONTROL_PARAMS, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public synchronized void saveDeeplink(AdjustDeeplink adjustDeeplink, long j) {
        if (adjustDeeplink != null) {
            Uri uri = adjustDeeplink.url;
            if (uri != null) {
                saveString(PREFS_KEY_DEEPLINK_URL, uri.toString());
                saveLong(PREFS_KEY_DEEPLINK_CLICK_TIME, j);
                Uri uri2 = adjustDeeplink.referrer;
                if (uri2 != null) {
                    saveString(PREFS_KEY_DEEPLINK_REFERRER, uri2.toString());
                }
            }
        }
    }

    public synchronized void savePreinstallReferrer(String str) {
        saveString(PREFS_KEY_PREINSTALL_SYSTEM_INSTALLER_REFERRER, str);
    }

    public synchronized void savePushToken(String str) {
        saveString(PREFS_KEY_PUSH_TOKEN, str);
    }

    public synchronized void saveRawReferrer(String str, long j) {
        try {
            if (getRawReferrer(str, j) == null) {
                JSONArray rawReferrerArray = getRawReferrerArray();
                if (rawReferrerArray.length() != 10) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(0, str);
                    jSONArray.put(1, j);
                    jSONArray.put(2, 0);
                    rawReferrerArray.put(jSONArray);
                    saveRawReferrerArray(rawReferrerArray);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public synchronized void saveRawReferrerArray(JSONArray jSONArray) {
        try {
            saveString(PREFS_KEY_RAW_REFERRERS, jSONArray.toString());
        } catch (Throwable unused) {
            remove(PREFS_KEY_RAW_REFERRERS);
        }
    }

    public synchronized void saveThirdPartySharingResult(AdjustThirdPartySharingResult adjustThirdPartySharingResult) {
        try {
            saveString(PREFS_KEY_TPS_RESULT_SETTINGS, adjustThirdPartySharingResult.getThirdPartySharingSettingsJson());
        } catch (Throwable unused) {
        }
    }

    public synchronized void setGdprForgetMe() {
        saveBoolean(PREFS_KEY_GDPR_FORGET_ME, true);
    }

    public synchronized void setInstallTracked() {
        saveBoolean(PREFS_KEY_INSTALL_TRACKED, true);
    }

    public synchronized void setLicenseVerificationTracked() {
        saveBoolean(PREFS_KEY_LVL_TRACKED, true);
    }

    public synchronized void setPreinstallPayloadReadStatus(long j) {
        saveLong(PREFS_KEY_PREINSTALL_PAYLOAD_READ_STATUS, j);
    }

    public synchronized void setSendingReferrersAsNotSent() {
        try {
            JSONArray rawReferrerArray = getRawReferrerArray();
            boolean z = false;
            for (int i = 0; i < rawReferrerArray.length(); i++) {
                JSONArray jSONArray = rawReferrerArray.getJSONArray(i);
                if (jSONArray.optInt(2, -1) == 1) {
                    jSONArray.put(2, 0);
                    z = true;
                }
            }
            if (z) {
                saveRawReferrerArray(rawReferrerArray);
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            throw th;
        }
    }
}
