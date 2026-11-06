package io.sentry;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum SentryLevel implements JsonSerializable {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(name().toLowerCase(Locale.ROOT));
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryLevel deserialize(ObjectReader objectReader, ILogger iLogger) {
            return SentryLevel.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
        }
    }
}
