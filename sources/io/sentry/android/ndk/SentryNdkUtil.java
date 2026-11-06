package io.sentry.android.ndk;

import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.protocol.SdkVersion;

/* JADX INFO: loaded from: classes5.dex */
abstract class SentryNdkUtil {
    static {
        SentryIntegrationPackageStorage.getInstance().addPackage("maven:io.sentry:sentry-android-ndk", "8.43.0");
    }

    static void addPackage(SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            return;
        }
        sdkVersion.addPackage("maven:io.sentry:sentry-android-ndk", "8.43.0");
    }
}
