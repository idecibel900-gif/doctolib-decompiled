package io.sentry.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class RNSentryLogger implements ILogger {
    private final AndroidLogger androidLogger = new AndroidLogger(NativeRNSentrySpec.NAME);
    private WeakReference reactContextRef;

    public void setReactContext(ReactApplicationContext reactApplicationContext) {
        this.reactContextRef = reactApplicationContext != null ? new WeakReference(reactApplicationContext) : null;
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        this.androidLogger.log(sentryLevel, str, objArr);
        if (objArr != null && objArr.length != 0) {
            str = String.format(str, objArr);
        }
        forwardToJS(sentryLevel, str);
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        this.androidLogger.log(sentryLevel, str, th);
        if (th != null) {
            str = str + ": " + th.getMessage();
        }
        forwardToJS(sentryLevel, str);
    }

    @Override // io.sentry.ILogger
    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        this.androidLogger.log(sentryLevel, th, str, objArr);
        if (objArr != null && objArr.length != 0) {
            str = String.format(str, objArr);
        }
        if (th != null) {
            str = str + ": " + th.getMessage();
        }
        forwardToJS(sentryLevel, str);
    }

    @Override // io.sentry.ILogger
    public boolean isEnabled(SentryLevel sentryLevel) {
        return this.androidLogger.isEnabled(sentryLevel);
    }

    private void forwardToJS(SentryLevel sentryLevel, String str) {
        WeakReference weakReference = this.reactContextRef;
        ReactApplicationContext reactApplicationContext = weakReference != null ? (ReactApplicationContext) weakReference.get() : null;
        if (reactApplicationContext == null || !reactApplicationContext.hasActiveReactInstance()) {
            return;
        }
        try {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("level", sentryLevel.name().toLowerCase());
            writableMapCreateMap.putString("component", "Sentry");
            writableMapCreateMap.putString("message", str);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("SentryNativeLog", writableMapCreateMap);
        } catch (Exception e) {
            this.androidLogger.log(SentryLevel.DEBUG, "Failed to forward log to JS: " + e.getMessage(), new Object[0]);
        }
    }
}
