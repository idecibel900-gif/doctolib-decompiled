package io.sentry.rrweb;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class RRWebSpanEvent extends RRWebEvent implements JsonSerializable {
    private Map data;
    private Map dataUnknown;
    private String description;
    private double endTimestamp;
    private String op;
    private Map payloadUnknown;
    private double startTimestamp;
    private String tag;
    private Map unknown;

    public RRWebSpanEvent() {
        super(RRWebEventType.Custom);
        this.tag = "performanceSpan";
    }

    public void setOp(String str) {
        this.op = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setStartTimestamp(double d) {
        this.startTimestamp = d;
    }

    public void setEndTimestamp(double d) {
        this.endTimestamp = d;
    }

    public void setData(Map map) {
        this.data = map == null ? null : new ConcurrentHashMap(map);
    }

    public void setPayloadUnknown(Map map) {
        this.payloadUnknown = map;
    }

    public void setDataUnknown(Map map) {
        this.dataUnknown = map;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        new RRWebEvent.Serializer().serialize(this, objectWriter, iLogger);
        objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        serializeData(objectWriter, iLogger);
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

    private void serializeData(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("tag").value(this.tag);
        objectWriter.name("payload");
        serializePayload(objectWriter, iLogger);
        Map map = this.dataUnknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.dataUnknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private void serializePayload(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.op != null) {
            objectWriter.name("op").value(this.op);
        }
        if (this.description != null) {
            objectWriter.name(b.c).value(this.description);
        }
        objectWriter.name("startTimestamp").value(iLogger, BigDecimal.valueOf(this.startTimestamp));
        objectWriter.name("endTimestamp").value(iLogger, BigDecimal.valueOf(this.endTimestamp));
        if (this.data != null) {
            objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        }
        Map map = this.payloadUnknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.payloadUnknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public RRWebSpanEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            RRWebSpanEvent rRWebSpanEvent = new RRWebSpanEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                    deserializeData(rRWebSpanEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebSpanEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebSpanEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebSpanEvent;
        }

        private void deserializeData(RRWebSpanEvent rRWebSpanEvent, ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("payload")) {
                    deserializePayload(rRWebSpanEvent, objectReader, iLogger);
                } else if (strNextName.equals("tag")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull == null) {
                        strNextStringOrNull = "";
                    }
                    rRWebSpanEvent.tag = strNextStringOrNull;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebSpanEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }

        private void deserializePayload(RRWebSpanEvent rRWebSpanEvent, ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "description":
                        rRWebSpanEvent.description = objectReader.nextStringOrNull();
                        break;
                    case "endTimestamp":
                        rRWebSpanEvent.endTimestamp = objectReader.nextDouble();
                        break;
                    case "startTimestamp":
                        rRWebSpanEvent.startTimestamp = objectReader.nextDouble();
                        break;
                    case "op":
                        rRWebSpanEvent.op = objectReader.nextStringOrNull();
                        break;
                    case "data":
                        Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        if (mapNewConcurrentHashMap == null) {
                            break;
                        } else {
                            rRWebSpanEvent.data = mapNewConcurrentHashMap;
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            rRWebSpanEvent.setPayloadUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
