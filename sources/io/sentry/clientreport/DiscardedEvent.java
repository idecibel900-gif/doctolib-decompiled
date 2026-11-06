package io.sentry.clientreport;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class DiscardedEvent implements JsonSerializable {
    private final String category;
    private final Long quantity;
    private final String reason;
    private Map unknown;

    public DiscardedEvent(String str, String str2, Long l) {
        this.reason = str;
        this.category = str2;
        this.quantity = l;
    }

    public String getReason() {
        return this.reason;
    }

    public String getCategory() {
        return this.category;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.reason + "', category='" + this.category + "', quantity=" + this.quantity + '}';
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("reason").value(this.reason);
        objectWriter.name("category").value(this.category);
        objectWriter.name("quantity").value(this.quantity);
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public DiscardedEvent deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            Long lNextLongOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "quantity":
                        lNextLongOrNull = objectReader.nextLongOrNull();
                        break;
                    case "reason":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "category":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull == null) {
                throw missingRequiredFieldException("reason", iLogger);
            }
            if (strNextStringOrNull2 == null) {
                throw missingRequiredFieldException("category", iLogger);
            }
            if (lNextLongOrNull == null) {
                throw missingRequiredFieldException("quantity", iLogger);
            }
            DiscardedEvent discardedEvent = new DiscardedEvent(strNextStringOrNull, strNextStringOrNull2, lNextLongOrNull);
            discardedEvent.setUnknown(map);
            return discardedEvent;
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
