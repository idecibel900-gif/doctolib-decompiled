package io.sentry.react.utils;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.CurrentActivityHolder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RNSentryActivityUtils {
    public static Activity getCurrentActivity(ReactApplicationContext reactApplicationContext, ILogger iLogger) {
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        iLogger.log(SentryLevel.DEBUG, "[RNSentryActivityUtils] Given ReactApplicationContext has no activity attached, using CurrentActivityHolder as a fallback.", new Object[0]);
        return CurrentActivityHolder.getInstance().getActivity();
    }
}
