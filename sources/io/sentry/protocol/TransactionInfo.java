package io.sentry.protocol;

import com.google.firebase.messaging.Constants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class TransactionInfo implements JsonSerializable {
    private final String source;
    private Map unknown;

    public TransactionInfo(String str) {
        this.source = str;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.source != null) {
            objectWriter.name(Constants.ScionAnalytics.PARAM_SOURCE).value(iLogger, this.source);
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

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public TransactionInfo deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextStringOrNull = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.PARAM_SOURCE)) {
                    strNextStringOrNull = objectReader.nextStringOrNull();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            TransactionInfo transactionInfo = new TransactionInfo(strNextStringOrNull);
            transactionInfo.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return transactionInfo;
        }
    }
}
