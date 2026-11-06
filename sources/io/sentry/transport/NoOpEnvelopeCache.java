package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import io.sentry.cache.IEnvelopeCache;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpEnvelopeCache implements IEnvelopeCache {
    private static final NoOpEnvelopeCache instance = new NoOpEnvelopeCache();

    @Override // io.sentry.cache.IEnvelopeCache
    public void discard(SentryEnvelope sentryEnvelope) {
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public boolean storeEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        return false;
    }

    public static NoOpEnvelopeCache getInstance() {
        return instance;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Collections.emptyIterator();
    }
}
