package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryMetricsEvent implements JsonSerializable {
    private Map attributes;
    private String name;
    private SpanId spanId;
    private Double timestamp;
    private SentryId traceId;
    private String type;
    private String unit;
    private Map unknown;
    private Double value;

    public SentryMetricsEvent(SentryId sentryId, Double d, String str, String str2, Double d2) {
        this.traceId = sentryId;
        this.timestamp = d;
        this.name = str;
        this.type = str2;
        this.value = d2;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public void setSpanId(SpanId spanId) {
        this.spanId = spanId;
    }

    public void setAttributes(Map map) {
        this.attributes = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, DateUtils.doubleToBigDecimal(this.timestamp));
        objectWriter.name("type").value(this.type);
        objectWriter.name("name").value(this.name);
        objectWriter.name("value").value(this.value);
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        if (this.spanId != null) {
            objectWriter.name("span_id").value(iLogger, this.spanId);
        }
        if (this.unit != null) {
            objectWriter.name("unit").value(iLogger, this.unit);
        }
        if (this.attributes != null) {
            objectWriter.name("attributes").value(iLogger, this.attributes);
        }
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
        public SentryMetricsEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            HashMap map = null;
            SentryId sentryId = null;
            Double dNextDoubleOrNull = null;
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            Double dNextDoubleOrNull2 = null;
            Map mapNextMapOrNull = null;
            SpanId spanId = null;
            String strNextStringOrNull3 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "span_id":
                        spanId = (SpanId) objectReader.nextOrNull(iLogger, new SpanId.Deserializer());
                        break;
                    case "name":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    case "unit":
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        break;
                    case "timestamp":
                        dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        break;
                    case "value":
                        dNextDoubleOrNull2 = objectReader.nextDoubleOrNull();
                        break;
                    case "attributes":
                        mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new SentryLogEventAttributeValue.Deserializer());
                        break;
                    case "trace_id":
                        sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
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
            if (sentryId == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (dNextDoubleOrNull == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"timestamp\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"timestamp\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strNextStringOrNull2 == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"type\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"type\"", illegalStateException3);
                throw illegalStateException3;
            }
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"name\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException4);
                throw illegalStateException4;
            }
            if (dNextDoubleOrNull2 == null) {
                IllegalStateException illegalStateException5 = new IllegalStateException("Missing required field \"value\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"value\"", illegalStateException5);
                throw illegalStateException5;
            }
            SentryMetricsEvent sentryMetricsEvent = new SentryMetricsEvent(sentryId, dNextDoubleOrNull, strNextStringOrNull, strNextStringOrNull2, dNextDoubleOrNull2);
            sentryMetricsEvent.setAttributes(mapNextMapOrNull);
            sentryMetricsEvent.setSpanId(spanId);
            sentryMetricsEvent.setUnit(strNextStringOrNull3);
            sentryMetricsEvent.setUnknown(map);
            return sentryMetricsEvent;
        }
    }
}
