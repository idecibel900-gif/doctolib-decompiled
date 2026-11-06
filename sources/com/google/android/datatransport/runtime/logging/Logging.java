package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Logging {
    private static String getTag(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return concatTag("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    private static String concatTag(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    public static void d(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 3)) {
            String.format(str2, obj);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (Log.isLoggable(getTag(str), 3)) {
            String.format(str2, objArr);
        }
    }

    public static void i(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 4)) {
            String.format(str2, obj);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        getTag(str);
    }

    public static void w(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 5)) {
            String.format(str2, obj);
        }
    }
}
