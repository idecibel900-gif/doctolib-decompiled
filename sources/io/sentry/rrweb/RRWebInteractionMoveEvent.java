package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class RRWebInteractionMoveEvent extends RRWebIncrementalSnapshotEvent implements JsonSerializable {
    private Map dataUnknown;
    private int pointerId;
    private List positions;
    private Map unknown;

    public static final class Position implements JsonSerializable {
        private int id;
        private long timeOffset;
        private Map unknown;
        private float x;
        private float y;

        public void setId(int i) {
            this.id = i;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }

        public long getTimeOffset() {
            return this.timeOffset;
        }

        public void setTimeOffset(long j) {
            this.timeOffset = j;
        }

        public void setUnknown(Map map) {
            this.unknown = map;
        }

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.beginObject();
            objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
            objectWriter.name("x").value(this.x);
            objectWriter.name("y").value(this.y);
            objectWriter.name("timeOffset").value(this.timeOffset);
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
            public Position deserialize(ObjectReader objectReader, ILogger iLogger) {
                objectReader.beginObject();
                Position position = new Position();
                HashMap map = null;
                while (objectReader.peek() == JsonToken.NAME) {
                    String strNextName = objectReader.nextName();
                    strNextName.getClass();
                    switch (strNextName) {
                        case "x":
                            position.x = objectReader.nextFloat();
                            break;
                        case "y":
                            position.y = objectReader.nextFloat();
                            break;
                        case "id":
                            position.id = objectReader.nextInt();
                            break;
                        case "timeOffset":
                            position.timeOffset = objectReader.nextLong();
                            break;
                        default:
                            if (map == null) {
                                map = new HashMap();
                            }
                            objectReader.nextUnknown(iLogger, map, strNextName);
                            break;
                    }
                }
                position.setUnknown(map);
                objectReader.endObject();
                return position;
            }
        }
    }

    public RRWebInteractionMoveEvent() {
        super(RRWebIncrementalSnapshotEvent.IncrementalSource.TouchMove);
    }

    public void setDataUnknown(Map map) {
        this.dataUnknown = map;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public void setPositions(List list) {
        this.positions = list;
    }

    public void setPointerId(int i) {
        this.pointerId = i;
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
        new RRWebIncrementalSnapshotEvent.Serializer().serialize(this, objectWriter, iLogger);
        List list = this.positions;
        if (list != null && !list.isEmpty()) {
            objectWriter.name("positions").value(iLogger, this.positions);
        }
        objectWriter.name("pointerId").value(this.pointerId);
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

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public RRWebInteractionMoveEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            RRWebInteractionMoveEvent rRWebInteractionMoveEvent = new RRWebInteractionMoveEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                    deserializeData(rRWebInteractionMoveEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebInteractionMoveEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebInteractionMoveEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebInteractionMoveEvent;
        }

        private void deserializeData(RRWebInteractionMoveEvent rRWebInteractionMoveEvent, ObjectReader objectReader, ILogger iLogger) {
            RRWebIncrementalSnapshotEvent.Deserializer deserializer = new RRWebIncrementalSnapshotEvent.Deserializer();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("pointerId")) {
                    rRWebInteractionMoveEvent.pointerId = objectReader.nextInt();
                } else if (strNextName.equals("positions")) {
                    rRWebInteractionMoveEvent.positions = objectReader.nextListOrNull(iLogger, new Position.Deserializer());
                } else if (!deserializer.deserializeValue(rRWebInteractionMoveEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebInteractionMoveEvent.setDataUnknown(map);
            objectReader.endObject();
        }
    }
}
