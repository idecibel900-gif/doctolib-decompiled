package io.sentry.android.core;

import android.util.Log;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFatalLogger implements ILogger {
    private final String tag;

    private int toLogcatLevel(SentryLevel sentryLevel) {
        return 7;
    }

    @Override // io.sentry.ILogger
    public boolean isEnabled(SentryLevel sentryLevel) {
        return true;
    }

    public AndroidFatalLogger() {
        this("Sentry");
    }

    public AndroidFatalLogger(String str) {
        this.tag = str;
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            Log.println(toLogcatLevel(sentryLevel), this.tag, str);
        } else {
            Log.println(toLogcatLevel(sentryLevel), this.tag, String.format(str, objArr));
        }
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            log(sentryLevel, str, th);
        } else {
            log(sentryLevel, String.format(str, objArr), th);
        }
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        Log.wtf(this.tag, str, th);
    }
}
