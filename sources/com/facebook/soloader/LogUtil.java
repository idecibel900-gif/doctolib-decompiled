package com.facebook.soloader;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LogUtil {
    public static void e(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void w(String str, String str2) {
    }

    public static void w(String str, String str2, Throwable th) {
    }

    public static void i(String str, String str2) {
        isLoggable(str, 4);
    }

    public static void d(String str, String str2) {
        isLoggable(str, 3);
    }

    public static void v(String str, String str2) {
        isLoggable(str, 2);
    }

    private static boolean isLoggable(String str, int i) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() > 23) {
            return Log.isLoggable(str.substring(0, 23), i);
        }
        return Log.isLoggable(str, i);
    }
}
