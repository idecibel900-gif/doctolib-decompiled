package io.sentry.util;

import io.sentry.SentryIntegrationPackageStorage;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IntegrationUtils {
    public static void addIntegrationToSdkVersion(String str) {
        SentryIntegrationPackageStorage.getInstance().addIntegration(str);
    }
}
