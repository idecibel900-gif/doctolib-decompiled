package io.sentry.react.expo;

import expo.modules.core.interfaces.ReactNativeHostHandler;
import io.sentry.Sentry;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;

/* JADX INFO: loaded from: classes5.dex */
public class SentryReactNativeHostHandler implements ReactNativeHostHandler {
    @Override // expo.modules.core.interfaces.ReactNativeHostHandler
    public void onReactInstanceException(boolean z, Exception exc) throws Throwable {
        if (z) {
            return;
        }
        if (Sentry.isEnabled()) {
            try {
                Mechanism mechanism = new Mechanism();
                mechanism.setType("expoReactHost");
                mechanism.setHandled(Boolean.FALSE);
                Sentry.captureException(new ExceptionMechanismException(mechanism, exc, Thread.currentThread()));
            } catch (Throwable unused) {
            }
        }
        if (isExpoUpdatesPresent()) {
            return;
        }
        sneakyThrow(exc);
    }

    boolean isExpoUpdatesPresent() {
        try {
            Class.forName("expo.modules.updates.UpdatesPackage", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void sneakyThrow(Throwable th) throws Throwable {
        throw th;
    }
}
