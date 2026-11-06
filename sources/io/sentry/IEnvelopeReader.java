package io.sentry;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface IEnvelopeReader {
    SentryEnvelope read(InputStream inputStream);
}
