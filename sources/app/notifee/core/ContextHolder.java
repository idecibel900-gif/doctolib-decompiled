package app.notifee.core;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ContextHolder {
    private static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context context) {
        Logger.d("context", "received application context");
        applicationContext = context;
    }
}
