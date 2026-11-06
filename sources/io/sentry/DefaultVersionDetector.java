package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultVersionDetector implements IVersionDetector {
    private final SentryOptions options;

    public DefaultVersionDetector(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // io.sentry.IVersionDetector
    public boolean checkForMixedVersions() {
        return SentryIntegrationPackageStorage.getInstance().checkForMixedVersions(this.options.getFatalLogger());
    }
}
