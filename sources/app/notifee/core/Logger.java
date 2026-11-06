package app.notifee.core;

import app.notifee.core.event.LogEvent;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    private static String tagAndMessage(String str, String str2) {
        return "(" + str + "): " + str2;
    }

    @KeepForSdk
    public static void v(String str, String str2) {
        tagAndMessage(str, str2);
    }

    @KeepForSdk
    public static void d(String str, String str2) {
        tagAndMessage(str, str2);
    }

    @KeepForSdk
    public static void i(String str, String str2) {
        tagAndMessage(str, str2);
    }

    @KeepForSdk
    public static void w(String str, String str2) {
        tagAndMessage(str, str2);
    }

    @KeepForSdk
    public static void w(String str, String str2, Throwable th) {
        tagAndMessage(str, str2);
    }

    @KeepForSdk
    public static void e(String str, String str2, Exception exc) {
        tagAndMessage(str, str2);
        EventBus.post(new LogEvent("error", str, str2, exc));
    }

    @KeepForSdk
    public static void e(String str, String str2) {
        tagAndMessage(str, str2);
        EventBus.post(new LogEvent("error", str, str2));
    }

    @KeepForSdk
    public static void e(String str, String str2, Throwable th) {
        tagAndMessage(str, str2);
        EventBus.post(new LogEvent("error", str, str2, th));
    }
}
