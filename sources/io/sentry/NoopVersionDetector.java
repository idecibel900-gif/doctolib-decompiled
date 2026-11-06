package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class NoopVersionDetector implements IVersionDetector {
    private static final NoopVersionDetector instance = new NoopVersionDetector();

    @Override // io.sentry.IVersionDetector
    public boolean checkForMixedVersions() {
        return false;
    }

    private NoopVersionDetector() {
    }

    public static NoopVersionDetector getInstance() {
        return instance;
    }
}
