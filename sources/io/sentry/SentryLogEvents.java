package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryLogEvents implements JsonSerializable {
    private List items;
    private Map unknown;

    public SentryLogEvents(List list) {
        this.items = list;
    }

    public List getItems() {
        return this.items;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("items").value(iLogger, this.items);
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
        public SentryLogEvents deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            List listNextListOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("items")) {
                    listNextListOrNull = objectReader.nextListOrNull(iLogger, new SentryLogEvent.Deserializer());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (listNextListOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"items\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"items\"", illegalStateException);
                throw illegalStateException;
            }
            SentryLogEvents sentryLogEvents = new SentryLogEvents(listNextListOrNull);
            sentryLogEvents.setUnknown(map);
            return sentryLogEvents;
        }
    }
}
