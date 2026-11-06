package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceManager {
    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode());
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }
}
