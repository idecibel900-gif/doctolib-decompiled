package io.sentry;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpEnvelopeReader implements IEnvelopeReader {
    private static final NoOpEnvelopeReader instance = new NoOpEnvelopeReader();

    @Override // io.sentry.IEnvelopeReader
    public SentryEnvelope read(InputStream inputStream) {
        return null;
    }

    private NoOpEnvelopeReader() {
    }

    public static NoOpEnvelopeReader getInstance() {
        return instance;
    }
}
