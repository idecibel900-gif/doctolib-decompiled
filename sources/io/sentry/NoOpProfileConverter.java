package io.sentry;

import io.sentry.protocol.profiling.SentryProfile;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpProfileConverter implements IProfileConverter {
    private static final NoOpProfileConverter instance = new NoOpProfileConverter();

    private NoOpProfileConverter() {
    }

    public static NoOpProfileConverter getInstance() {
        return instance;
    }

    @Override // io.sentry.IProfileConverter
    public SentryProfile convertFromFile(String str) {
        return new SentryProfile();
    }
}
