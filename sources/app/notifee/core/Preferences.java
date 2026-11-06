package app.notifee.core;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
class Preferences {
    private static Preferences sharedInstance = new Preferences();
    private SharedPreferences preferences;

    Preferences() {
    }

    static Preferences getSharedInstance() {
        return sharedInstance;
    }

    void setBooleanValue(String str, boolean z) {
        getPreferences().edit().putBoolean(str, z).apply();
    }

    boolean getBooleanValue(String str, boolean z) {
        return getPreferences().getBoolean(str, z);
    }

    void setIntValue(String str, int i) {
        getPreferences().edit().putInt(str, i).apply();
    }

    int getIntValue(String str, int i) {
        return getPreferences().getInt(str, i);
    }

    private SharedPreferences getPreferences() {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = ContextHolder.getApplicationContext().getSharedPreferences("app.notifee.core", 0);
        this.preferences = sharedPreferences2;
        return sharedPreferences2;
    }
}
