package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class RRWebMetaEvent extends RRWebEvent implements JsonSerializable {
    private Map dataUnknown;
    private int height;
    private String href;
    private Map unknown;
    private int width;

    public RRWebMetaEvent() {
        super(RRWebEventType.Meta);
        this.href = "";
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setDataUnknown(Map map) {
        this.dataUnknown = map;
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RRWebMetaEvent.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        RRWebMetaEvent rRWebMetaEvent = (RRWebMetaEvent) obj;
        return this.height == rRWebMetaEvent.height && this.width == rRWebMetaEvent.width && Objects.equals(this.href, rRWebMetaEvent.href);
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.href, Integer.valueOf(this.height), Integer.valueOf(this.width));
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        new RRWebEvent.Serializer().serialize(this, objectWriter, iLogger);
        objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        serializeData(objectWriter, iLogger);
        objectWriter.endObject();
    }

    private void serializeData(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("href").value(this.href);
        objectWriter.name("height").value(this.height);
        objectWriter.name("width").value(this.width);
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
        public RRWebMetaEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            RRWebMetaEvent rRWebMetaEvent = new RRWebMetaEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                    deserializeData(rRWebMetaEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebMetaEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebMetaEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebMetaEvent;
        }

        private void deserializeData(RRWebMetaEvent rRWebMetaEvent, ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "height":
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        rRWebMetaEvent.height = numNextIntegerOrNull != null ? numNextIntegerOrNull.intValue() : 0;
                        break;
                    case "href":
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull == null) {
                            strNextStringOrNull = "";
                        }
                        rRWebMetaEvent.href = strNextStringOrNull;
                        break;
                    case "width":
                        Integer numNextIntegerOrNull2 = objectReader.nextIntegerOrNull();
                        rRWebMetaEvent.width = numNextIntegerOrNull2 != null ? numNextIntegerOrNull2.intValue() : 0;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            rRWebMetaEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
