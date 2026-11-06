package io.sentry.cache;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;

/* JADX INFO: loaded from: classes5.dex */
public interface IEnvelopeCache extends Iterable {
    void discard(SentryEnvelope sentryEnvelope);

    boolean storeEnvelope(SentryEnvelope sentryEnvelope, Hint hint);
}
