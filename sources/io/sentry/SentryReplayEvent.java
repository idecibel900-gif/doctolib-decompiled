package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryReplayEvent extends SentryBaseEvent implements JsonSerializable {
    private Date replayStartTimestamp;
    private int segmentId;
    private Map unknown;
    private File videoFile;
    private SentryId replayId = new SentryId();
    private String type = "replay_event";
    private ReplayType replayType = ReplayType.SESSION;
    private List errorIds = new ArrayList();
    private List traceIds = new ArrayList();
    private List urls = new ArrayList();
    private Date timestamp = DateUtils.getCurrentDateTime();

    public enum ReplayType implements JsonSerializable {
        SESSION,
        BUFFER;

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            objectWriter.value(name().toLowerCase(Locale.ROOT));
        }

        public static final class Deserializer implements JsonDeserializer {
            @Override // io.sentry.JsonDeserializer
            public ReplayType deserialize(ObjectReader objectReader, ILogger iLogger) {
                return ReplayType.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
            }
        }
    }

    public File getVideoFile() {
        return this.videoFile;
    }

    public void setVideoFile(File file) {
        this.videoFile = file;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setReplayId(SentryId sentryId) {
        this.replayId = sentryId;
    }

    public void setSegmentId(int i) {
        this.segmentId = i;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public void setReplayStartTimestamp(Date date) {
        this.replayStartTimestamp = date;
    }

    public void setUrls(List list) {
        this.urls = list;
    }

    public void setErrorIds(List list) {
        this.errorIds = list;
    }

    public void setTraceIds(List list) {
        this.traceIds = list;
    }

    public void setReplayType(ReplayType replayType) {
        this.replayType = replayType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SentryReplayEvent.class == obj.getClass()) {
            SentryReplayEvent sentryReplayEvent = (SentryReplayEvent) obj;
            if (this.segmentId == sentryReplayEvent.segmentId && Objects.equals(this.type, sentryReplayEvent.type) && this.replayType == sentryReplayEvent.replayType && Objects.equals(this.replayId, sentryReplayEvent.replayId) && Objects.equals(this.urls, sentryReplayEvent.urls) && Objects.equals(this.errorIds, sentryReplayEvent.errorIds) && Objects.equals(this.traceIds, sentryReplayEvent.traceIds)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.replayType, this.replayId, Integer.valueOf(this.segmentId), this.urls, this.errorIds, this.traceIds);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("type").value(this.type);
        objectWriter.name("replay_type").value(iLogger, this.replayType);
        objectWriter.name("segment_id").value(this.segmentId);
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, this.timestamp);
        if (this.replayId != null) {
            objectWriter.name("replay_id").value(iLogger, this.replayId);
        }
        if (this.replayStartTimestamp != null) {
            objectWriter.name("replay_start_timestamp").value(iLogger, this.replayStartTimestamp);
        }
        if (this.urls != null) {
            objectWriter.name("urls").value(iLogger, this.urls);
        }
        if (this.errorIds != null) {
            objectWriter.name("error_ids").value(iLogger, this.errorIds);
        }
        if (this.traceIds != null) {
            objectWriter.name("trace_ids").value(iLogger, this.traceIds);
        }
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
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
        public SentryReplayEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            SentryReplayEvent sentryReplayEvent = new SentryReplayEvent();
            objectReader.beginObject();
            String strNextStringOrNull = null;
            ReplayType replayType = null;
            Integer numNextIntegerOrNull = null;
            Date dateNextDateOrNull = null;
            HashMap map = null;
            SentryId sentryId = null;
            Date dateNextDateOrNull2 = null;
            List list = null;
            List list2 = null;
            List list3 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "replay_id":
                        sentryId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                        break;
                    case "replay_start_timestamp":
                        dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                        break;
                    case "type":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    case "urls":
                        list = (List) objectReader.nextObjectOrNull();
                        break;
                    case "timestamp":
                        dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        break;
                    case "error_ids":
                        list2 = (List) objectReader.nextObjectOrNull();
                        break;
                    case "trace_ids":
                        list3 = (List) objectReader.nextObjectOrNull();
                        break;
                    case "replay_type":
                        replayType = (ReplayType) objectReader.nextOrNull(iLogger, new ReplayType.Deserializer());
                        break;
                    case "segment_id":
                        numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (!deserializer.deserializeValue(sentryReplayEvent, strNextName, objectReader, iLogger)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            objectReader.nextUnknown(iLogger, map, strNextName);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            objectReader.endObject();
            if (strNextStringOrNull != null) {
                sentryReplayEvent.setType(strNextStringOrNull);
            }
            if (replayType != null) {
                sentryReplayEvent.setReplayType(replayType);
            }
            if (numNextIntegerOrNull != null) {
                sentryReplayEvent.setSegmentId(numNextIntegerOrNull.intValue());
            }
            if (dateNextDateOrNull != null) {
                sentryReplayEvent.setTimestamp(dateNextDateOrNull);
            }
            sentryReplayEvent.setReplayId(sentryId);
            sentryReplayEvent.setReplayStartTimestamp(dateNextDateOrNull2);
            sentryReplayEvent.setUrls(list);
            sentryReplayEvent.setErrorIds(list2);
            sentryReplayEvent.setTraceIds(list3);
            sentryReplayEvent.setUnknown(map);
            return sentryReplayEvent;
        }
    }
}
