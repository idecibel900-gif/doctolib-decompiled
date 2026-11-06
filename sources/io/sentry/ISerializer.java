package io.sentry;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface ISerializer {
    Object deserialize(Reader reader, Class cls);

    Object deserializeCollection(Reader reader, Class cls, JsonDeserializer jsonDeserializer);

    SentryEnvelope deserializeEnvelope(InputStream inputStream);

    String serialize(Map map);

    void serialize(SentryEnvelope sentryEnvelope, OutputStream outputStream);

    void serialize(Object obj, Writer writer);
}
