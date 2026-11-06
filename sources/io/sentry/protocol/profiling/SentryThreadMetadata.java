package io.sentry.protocol.profiling;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryThreadMetadata implements JsonSerializable {
    private String name;
    private int priority;
    private Map unknown;

    public void setName(String str) {
        this.name = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(iLogger, this.name);
        }
        objectWriter.name("priority").value(iLogger, Integer.valueOf(this.priority));
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SentryThreadMetadata deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryThreadMetadata sentryThreadMetadata = new SentryThreadMetadata();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("priority")) {
                    sentryThreadMetadata.priority = objectReader.nextInt();
                } else if (strNextName.equals("name")) {
                    sentryThreadMetadata.name = objectReader.nextStringOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            sentryThreadMetadata.setUnknown(map);
            objectReader.endObject();
            return sentryThreadMetadata;
        }
    }
}
