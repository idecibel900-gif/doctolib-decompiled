package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.vonage.webrtc.MediaStreamTrack;
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
public final class RRWebVideoEvent extends RRWebEvent implements JsonSerializable {
    private String container;
    private Map dataUnknown;
    private long durationMs;
    private String encoding;
    private int frameCount;
    private int frameRate;
    private String frameRateType;
    private int height;
    private int left;
    private Map payloadUnknown;
    private int segmentId;
    private long size;
    private String tag;
    private int top;
    private Map unknown;
    private int width;

    public RRWebVideoEvent() {
        super(RRWebEventType.Custom);
        this.encoding = "h264";
        this.container = "mp4";
        this.frameRateType = "constant";
        this.tag = MediaStreamTrack.VIDEO_TRACK_KIND;
    }

    public void setSegmentId(int i) {
        this.segmentId = i;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setDurationMs(long j) {
        this.durationMs = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public void setFrameRate(int i) {
        this.frameRate = i;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public void setTop(int i) {
        this.top = i;
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

    @Override // io.sentry.rrweb.RRWebEvent
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RRWebVideoEvent.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        RRWebVideoEvent rRWebVideoEvent = (RRWebVideoEvent) obj;
        return this.segmentId == rRWebVideoEvent.segmentId && this.size == rRWebVideoEvent.size && this.durationMs == rRWebVideoEvent.durationMs && this.height == rRWebVideoEvent.height && this.width == rRWebVideoEvent.width && this.frameCount == rRWebVideoEvent.frameCount && this.frameRate == rRWebVideoEvent.frameRate && this.left == rRWebVideoEvent.left && this.top == rRWebVideoEvent.top && Objects.equals(this.tag, rRWebVideoEvent.tag) && Objects.equals(this.encoding, rRWebVideoEvent.encoding) && Objects.equals(this.container, rRWebVideoEvent.container) && Objects.equals(this.frameRateType, rRWebVideoEvent.frameRateType);
    }

    @Override // io.sentry.rrweb.RRWebEvent
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.tag, Integer.valueOf(this.segmentId), Long.valueOf(this.size), Long.valueOf(this.durationMs), this.encoding, this.container, Integer.valueOf(this.height), Integer.valueOf(this.width), Integer.valueOf(this.frameCount), this.frameRateType, Integer.valueOf(this.frameRate), Integer.valueOf(this.left), Integer.valueOf(this.top));
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
        objectWriter.name("segmentId").value(this.segmentId);
        objectWriter.name("size").value(this.size);
        objectWriter.name("duration").value(this.durationMs);
        objectWriter.name("encoding").value(this.encoding);
        objectWriter.name("container").value(this.container);
        objectWriter.name("height").value(this.height);
        objectWriter.name("width").value(this.width);
        objectWriter.name("frameCount").value(this.frameCount);
        objectWriter.name("frameRate").value(this.frameRate);
        objectWriter.name("frameRateType").value(this.frameRateType);
        objectWriter.name("left").value(this.left);
        objectWriter.name("top").value(this.top);
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
        public RRWebVideoEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            RRWebVideoEvent rRWebVideoEvent = new RRWebVideoEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                    deserializeData(rRWebVideoEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebVideoEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebVideoEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebVideoEvent;
        }

        private void deserializeData(RRWebVideoEvent rRWebVideoEvent, ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("payload")) {
                    deserializePayload(rRWebVideoEvent, objectReader, iLogger);
                } else if (strNextName.equals("tag")) {
                    String strNextStringOrNull = objectReader.nextStringOrNull();
                    if (strNextStringOrNull == null) {
                        strNextStringOrNull = "";
                    }
                    rRWebVideoEvent.tag = strNextStringOrNull;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                }
            }
            rRWebVideoEvent.setDataUnknown(concurrentHashMap);
            objectReader.endObject();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private void deserializePayload(RRWebVideoEvent rRWebVideoEvent, ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                byte b = -1;
                switch (strNextName.hashCode()) {
                    case -1992012396:
                        if (strNextName.equals("duration")) {
                            b = 0;
                        }
                        break;
                    case -1627805778:
                        if (strNextName.equals("segmentId")) {
                            b = 1;
                        }
                        break;
                    case -1221029593:
                        if (strNextName.equals("height")) {
                            b = 2;
                        }
                        break;
                    case -410956671:
                        if (strNextName.equals("container")) {
                            b = 3;
                        }
                        break;
                    case -296512606:
                        if (strNextName.equals("frameCount")) {
                            b = 4;
                        }
                        break;
                    case 115029:
                        if (strNextName.equals("top")) {
                            b = 5;
                        }
                        break;
                    case 3317767:
                        if (strNextName.equals("left")) {
                            b = 6;
                        }
                        break;
                    case 3530753:
                        if (strNextName.equals("size")) {
                            b = 7;
                        }
                        break;
                    case 113126854:
                        if (strNextName.equals("width")) {
                            b = 8;
                        }
                        break;
                    case 545057773:
                        if (strNextName.equals("frameRate")) {
                            b = 9;
                        }
                        break;
                    case 1711222099:
                        if (strNextName.equals("encoding")) {
                            b = 10;
                        }
                        break;
                    case 2135109831:
                        if (strNextName.equals("frameRateType")) {
                            b = 11;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        rRWebVideoEvent.durationMs = objectReader.nextLong();
                        break;
                    case 1:
                        rRWebVideoEvent.segmentId = objectReader.nextInt();
                        break;
                    case 2:
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.height = numNextIntegerOrNull != null ? numNextIntegerOrNull.intValue() : 0;
                        break;
                    case 3:
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        rRWebVideoEvent.container = strNextStringOrNull != null ? strNextStringOrNull : "";
                        break;
                    case 4:
                        Integer numNextIntegerOrNull2 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.frameCount = numNextIntegerOrNull2 != null ? numNextIntegerOrNull2.intValue() : 0;
                        break;
                    case 5:
                        Integer numNextIntegerOrNull3 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.top = numNextIntegerOrNull3 != null ? numNextIntegerOrNull3.intValue() : 0;
                        break;
                    case 6:
                        Integer numNextIntegerOrNull4 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.left = numNextIntegerOrNull4 != null ? numNextIntegerOrNull4.intValue() : 0;
                        break;
                    case 7:
                        Long lNextLongOrNull = objectReader.nextLongOrNull();
                        rRWebVideoEvent.size = lNextLongOrNull == null ? 0L : lNextLongOrNull.longValue();
                        break;
                    case 8:
                        Integer numNextIntegerOrNull5 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.width = numNextIntegerOrNull5 != null ? numNextIntegerOrNull5.intValue() : 0;
                        break;
                    case 9:
                        Integer numNextIntegerOrNull6 = objectReader.nextIntegerOrNull();
                        rRWebVideoEvent.frameRate = numNextIntegerOrNull6 != null ? numNextIntegerOrNull6.intValue() : 0;
                        break;
                    case 10:
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        rRWebVideoEvent.encoding = strNextStringOrNull2 != null ? strNextStringOrNull2 : "";
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        String strNextStringOrNull3 = objectReader.nextStringOrNull();
                        rRWebVideoEvent.frameRateType = strNextStringOrNull3 != null ? strNextStringOrNull3 : "";
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            rRWebVideoEvent.setPayloadUnknown(concurrentHashMap);
            objectReader.endObject();
        }
    }
}
