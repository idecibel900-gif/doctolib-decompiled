package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryInstantDateProvider implements SentryDateProvider {
    @Override // io.sentry.SentryDateProvider
    public SentryDate now() {
        return new SentryInstantDate();
    }
}
