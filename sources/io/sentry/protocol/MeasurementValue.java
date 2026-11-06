package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class MeasurementValue implements JsonSerializable {
    private final String unit;
    private Map unknown;
    private final Number value;

    public MeasurementValue(Number number, String str) {
        this.value = number;
        this.unit = str;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("value").value(this.value);
        if (this.unit != null) {
            objectWriter.name("unit").value(this.unit);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public MeasurementValue deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Number number = null;
            String strNextStringOrNull = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("unit")) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else if (strNextName.equals("value")) {
                    number = (Number) objectReader.nextObjectOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            objectReader.endObject();
            if (number == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException);
                throw illegalStateException;
            }
            MeasurementValue measurementValue = new MeasurementValue(number, strNextStringOrNull);
            measurementValue.setUnknown(concurrentHashMap);
            return measurementValue;
        }
    }
}
