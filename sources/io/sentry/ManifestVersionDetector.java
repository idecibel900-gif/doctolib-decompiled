package io.sentry;

import io.sentry.internal.ManifestVersionReader;

/* JADX INFO: loaded from: classes5.dex */
public final class ManifestVersionDetector implements IVersionDetector {
    private final SentryOptions options;

    public ManifestVersionDetector(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // io.sentry.IVersionDetector
    public boolean checkForMixedVersions() {
        ManifestVersionReader.getInstance().readManifestFiles();
        return SentryIntegrationPackageStorage.getInstance().checkForMixedVersions(this.options.getFatalLogger());
    }
}
