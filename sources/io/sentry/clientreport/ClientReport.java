package io.sentry.clientreport;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ClientReport implements JsonSerializable {
    private final List discardedEvents;
    private final Date timestamp;
    private Map unknown;

    public ClientReport(Date date, List list) {
        this.timestamp = date;
        this.discardedEvents = list;
    }

    public List getDiscardedEvents() {
        return this.discardedEvents;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(DateUtils.getTimestamp(this.timestamp));
        objectWriter.name("discarded_events").value(iLogger, this.discardedEvents);
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
        public ClientReport deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            ArrayList arrayList = new ArrayList();
            objectReader.beginObject();
            Date dateNextDateOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("discarded_events")) {
                    arrayList.addAll(objectReader.nextListOrNull(iLogger, new DiscardedEvent.Deserializer()));
                } else if (strNextName.equals(DiagnosticsEntry.TIMESTAMP_KEY)) {
                    dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            objectReader.endObject();
            if (dateNextDateOrNull == null) {
                throw missingRequiredFieldException(DiagnosticsEntry.TIMESTAMP_KEY, iLogger);
            }
            if (arrayList.isEmpty()) {
                throw missingRequiredFieldException("discarded_events", iLogger);
            }
            ClientReport clientReport = new ClientReport(dateNextDateOrNull, arrayList);
            clientReport.setUnknown(map);
            return clientReport;
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
