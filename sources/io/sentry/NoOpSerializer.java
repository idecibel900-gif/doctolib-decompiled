package io.sentry;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class NoOpSerializer implements ISerializer {
    private static final NoOpSerializer instance = new NoOpSerializer();

    @Override // io.sentry.ISerializer
    public Object deserialize(Reader reader, Class cls) {
        return null;
    }

    @Override // io.sentry.ISerializer
    public Object deserializeCollection(Reader reader, Class cls, JsonDeserializer jsonDeserializer) {
        return null;
    }

    @Override // io.sentry.ISerializer
    public SentryEnvelope deserializeEnvelope(InputStream inputStream) {
        return null;
    }

    @Override // io.sentry.ISerializer
    public void serialize(SentryEnvelope sentryEnvelope, OutputStream outputStream) {
    }

    @Override // io.sentry.ISerializer
    public void serialize(Object obj, Writer writer) {
    }

    public static NoOpSerializer getInstance() {
        return instance;
    }

    private NoOpSerializer() {
    }

    @Override // io.sentry.ISerializer
    public String serialize(Map map) {
        return "";
    }
}
