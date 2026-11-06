package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryLogEvent implements JsonSerializable {
    private Map attributes;
    private String body;
    private SentryLogLevel level;
    private Integer severityNumber;
    private SpanId spanId;
    private Double timestamp;
    private SentryId traceId;
    private Map unknown;

    public SentryLogEvent(SentryId sentryId, Double d, String str, SentryLogLevel sentryLogLevel) {
        this.traceId = sentryId;
        this.timestamp = d;
        this.body = str;
        this.level = sentryLogLevel;
    }

    public void setAttributes(Map map) {
        this.attributes = map;
    }

    public void setSeverityNumber(Integer num) {
        this.severityNumber = num;
    }

    public void setSpanId(SpanId spanId) {
        this.spanId = spanId;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, DateUtils.doubleToBigDecimal(this.timestamp));
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        if (this.spanId != null) {
            objectWriter.name("span_id").value(iLogger, this.spanId);
        }
        objectWriter.name("body").value(this.body);
        objectWriter.name("level").value(iLogger, this.level);
        if (this.severityNumber != null) {
            objectWriter.name("severity_number").value(iLogger, this.severityNumber);
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
        public SentryLogEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryId sentryId = null;
            Double dNextDoubleOrNull = null;
            String strNextStringOrNull = null;
            HashMap map = null;
            SentryLogLevel sentryLogLevel = null;
            Map mapNextMapOrNull = null;
            Integer numNextIntegerOrNull = null;
            SpanId spanId = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "span_id":
                        spanId = (SpanId) objectReader.nextOrNull(iLogger, new SpanId.Deserializer());
                        break;
                    case "severity_number":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        break;
                    case "body":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "timestamp":
                        dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                        break;
                    case "level":
                        sentryLogLevel = (SentryLogLevel) objectReader.nextOrNull(iLogger, new SentryLogLevel.Deserializer());
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
            if (strNextStringOrNull == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"body\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"body\"", illegalStateException3);
                throw illegalStateException3;
            }
            if (sentryLogLevel == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"level\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"level\"", illegalStateException4);
                throw illegalStateException4;
            }
            SentryLogEvent sentryLogEvent = new SentryLogEvent(sentryId, dNextDoubleOrNull, strNextStringOrNull, sentryLogLevel);
            sentryLogEvent.setAttributes(mapNextMapOrNull);
            sentryLogEvent.setSeverityNumber(numNextIntegerOrNull);
            sentryLogEvent.setSpanId(spanId);
            sentryLogEvent.setUnknown(map);
            return sentryLogEvent;
        }
    }
}
