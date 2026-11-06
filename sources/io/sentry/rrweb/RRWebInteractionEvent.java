package io.sentry.rrweb;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class RRWebInteractionEvent extends RRWebIncrementalSnapshotEvent implements JsonSerializable {
    private Map dataUnknown;
    private int id;
    private InteractionType interactionType;
    private int pointerId;
    private int pointerType;
    private Map unknown;
    private float x;
    private float y;

    public enum InteractionType implements JsonSerializable {
        MouseUp,
        MouseDown,
        Click,
        ContextMenu,
        DblClick,
        Focus,
        Blur,
        TouchStart,
        TouchMove_Departed,
        TouchEnd,
        TouchCancel;

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            objectWriter.value(ordinal());
        }

        public static final class Deserializer implements JsonDeserializer {
            @Override // io.sentry.JsonDeserializer
            public InteractionType deserialize(ObjectReader objectReader, ILogger iLogger) {
                return InteractionType.values()[objectReader.nextInt()];
            }
        }
    }

    public RRWebInteractionEvent() {
        super(RRWebIncrementalSnapshotEvent.IncrementalSource.MouseInteraction);
        this.pointerType = 2;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public void setPointerId(int i) {
        this.pointerId = i;
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
        new RRWebIncrementalSnapshotEvent.Serializer().serialize(this, objectWriter, iLogger);
        objectWriter.name("type").value(iLogger, this.interactionType);
        objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
        objectWriter.name("x").value(this.x);
        objectWriter.name("y").value(this.y);
        objectWriter.name("pointerType").value(this.pointerType);
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
        public RRWebInteractionEvent deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            RRWebInteractionEvent rRWebInteractionEvent = new RRWebInteractionEvent();
            RRWebEvent.Deserializer deserializer = new RRWebEvent.Deserializer();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                if (strNextName.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                    deserializeData(rRWebInteractionEvent, objectReader, iLogger);
                } else if (!deserializer.deserializeValue(rRWebInteractionEvent, strNextName, objectReader, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, map, strNextName);
                }
            }
            rRWebInteractionEvent.setUnknown(map);
            objectReader.endObject();
            return rRWebInteractionEvent;
        }

        private void deserializeData(RRWebInteractionEvent rRWebInteractionEvent, ObjectReader objectReader, ILogger iLogger) {
            RRWebIncrementalSnapshotEvent.Deserializer deserializer = new RRWebIncrementalSnapshotEvent.Deserializer();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "x":
                        rRWebInteractionEvent.x = objectReader.nextFloat();
                        break;
                    case "y":
                        rRWebInteractionEvent.y = objectReader.nextFloat();
                        break;
                    case "id":
                        rRWebInteractionEvent.id = objectReader.nextInt();
                        break;
                    case "type":
                        rRWebInteractionEvent.interactionType = (InteractionType) objectReader.nextOrNull(iLogger, new InteractionType.Deserializer());
                        break;
                    case "pointerType":
                        rRWebInteractionEvent.pointerType = objectReader.nextInt();
                        break;
                    case "pointerId":
                        rRWebInteractionEvent.pointerId = objectReader.nextInt();
                        break;
                    default:
                        if (!deserializer.deserializeValue(rRWebInteractionEvent, strNextName, objectReader, iLogger)) {
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
            rRWebInteractionEvent.setDataUnknown(map);
            objectReader.endObject();
        }
    }
}
