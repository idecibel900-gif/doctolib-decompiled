package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryEnvelopeHeader implements JsonSerializable {
    private final SentryId eventId;
    private final SdkVersion sdkVersion;
    private Date sentAt;
    private final TraceContext traceContext;
    private Map unknown;

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion) {
        this(sentryId, sdkVersion, null);
    }

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion, TraceContext traceContext) {
        this.eventId = sentryId;
        this.sdkVersion = sdkVersion;
        this.traceContext = traceContext;
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public void setSentAt(Date date) {
        this.sentAt = date;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.eventId != null) {
            objectWriter.name("event_id").value(iLogger, this.eventId);
        }
        if (this.sdkVersion != null) {
            objectWriter.name("sdk").value(iLogger, this.sdkVersion);
        }
        if (this.traceContext != null) {
            objectWriter.name("trace").value(iLogger, this.traceContext);
        }
        if (this.sentAt != null) {
            objectWriter.name("sent_at").value(iLogger, DateUtils.getTimestamp(this.sentAt));
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
        public SentryEnvelopeHeader deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryId sentryId = null;
            SdkVersion sdkVersion = null;
            TraceContext traceContext = null;
            Date dateNextDateOrNull = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "sdk":
                        sdkVersion = (SdkVersion) objectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                        break;
                    case "trace":
                        traceContext = (TraceContext) objectReader.nextOrNull(iLogger, new TraceContext.Deserializer());
                        break;
                    case "event_id":
                        sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                        break;
                    case "sent_at":
                        dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            SentryEnvelopeHeader sentryEnvelopeHeader = new SentryEnvelopeHeader(sentryId, sdkVersion, traceContext);
            sentryEnvelopeHeader.setSentAt(dateNextDateOrNull);
            sentryEnvelopeHeader.setUnknown(map);
            objectReader.endObject();
            return sentryEnvelopeHeader;
        }
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }
}
