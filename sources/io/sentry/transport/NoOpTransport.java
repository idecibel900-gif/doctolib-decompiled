package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpTransport implements ITransport {
    private static final NoOpTransport instance = new NoOpTransport();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.sentry.transport.ITransport
    public void close(boolean z) {
    }

    @Override // io.sentry.transport.ITransport
    public void flush(long j) {
    }

    @Override // io.sentry.transport.ITransport
    public RateLimiter getRateLimiter() {
        return null;
    }

    @Override // io.sentry.transport.ITransport
    public void send(SentryEnvelope sentryEnvelope, Hint hint) {
    }

    public static NoOpTransport getInstance() {
        return instance;
    }

    private NoOpTransport() {
    }
}
