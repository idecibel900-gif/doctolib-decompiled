package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface ITransport extends Closeable {
    void close(boolean z);

    void flush(long j);

    RateLimiter getRateLimiter();

    default boolean isHealthy() {
        return true;
    }

    void send(SentryEnvelope sentryEnvelope, Hint hint);

    default void send(SentryEnvelope sentryEnvelope) {
        send(sentryEnvelope, new Hint());
    }
}
