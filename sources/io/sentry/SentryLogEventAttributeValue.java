package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryLogEventAttributeValue implements JsonSerializable {
    private String type;
    private Map unknown;
    private Object value;

    public SentryLogEventAttributeValue(String str, Object obj) {
        this.type = str;
        if (obj != null && str.equals("string")) {
            this.value = obj.toString();
        } else {
            this.value = obj;
        }
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("type").value(iLogger, this.type);
        objectWriter.name("value").value(iLogger, this.value);
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
        public SentryLogEventAttributeValue deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            Object objNextObjectOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("type")) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (strNextName.equals("value")) {
                    objNextObjectOrNull = objectReader.nextObjectOrNull();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException);
                throw illegalStateException;
            }
            SentryLogEventAttributeValue sentryLogEventAttributeValue = new SentryLogEventAttributeValue(strNextStringOrNull, objNextObjectOrNull);
            sentryLogEventAttributeValue.setUnknown(map);
            return sentryLogEventAttributeValue;
        }
    }
}
