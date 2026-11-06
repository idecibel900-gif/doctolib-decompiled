package com.facebook.react.util;

import app.notifee.core.event.LogEvent;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RNLog {
    public static final RNLog INSTANCE = new RNLog();

    private RNLog() {
    }

    public static final void w(ReactContext reactContext, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.logInternal(reactContext, message, 5);
        FLog.w("ReactNative", message);
    }

    public static final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        FLog.e("ReactNative", message);
    }

    private final void logInternal(ReactContext reactContext, String str, int i) {
        if (i < 5 || reactContext == null || !reactContext.hasActiveReactInstance() || str == null) {
            return;
        }
        ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(levelToString(i), str);
    }

    private final String levelToString(int i) {
        if (i == 2 || i == 3) {
            return "log";
        }
        if (i == 4 || i == 5) {
            return LogEvent.LEVEL_WARN;
        }
        if (i == 6) {
            return "error";
        }
        return "none";
    }
}
