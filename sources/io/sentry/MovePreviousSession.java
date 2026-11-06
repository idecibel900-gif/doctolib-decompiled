package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.cache.IEnvelopeCache;

/* JADX INFO: loaded from: classes5.dex */
final class MovePreviousSession implements Runnable {
    private final SentryOptions options;

    MovePreviousSession(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.options.getCacheDirPath();
        if (cacheDirPath == null) {
            this.options.getLogger().log(SentryLevel.INFO, "Cache dir is not set, not moving the previous session.", new Object[0]);
            return;
        }
        IEnvelopeCache envelopeDiskCache = this.options.getEnvelopeDiskCache();
        if (envelopeDiskCache instanceof EnvelopeCache) {
            EnvelopeCache envelopeCache = (EnvelopeCache) envelopeDiskCache;
            envelopeCache.movePreviousSession(EnvelopeCache.getCurrentSessionFile(cacheDirPath), EnvelopeCache.getPreviousSessionFile(cacheDirPath));
            envelopeCache.flushPreviousSession();
        }
    }
}
