package io.sentry.protocol;

import com.adjust.sdk.Constants;
import com.amazon.a.a.o.b;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Mechanism implements JsonSerializable {
    private Map data;
    private String description;
    private Boolean exceptionGroup;
    private Integer exceptionId;
    private Boolean handled;
    private String helpLink;
    private Map meta;
    private Integer parentId;
    private Boolean synthetic;
    private final transient Thread thread;
    private String type;
    private Map unknown;

    public Mechanism() {
        this(null);
    }

    public Mechanism(Thread thread) {
        this.thread = thread;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Boolean isHandled() {
        return this.handled;
    }

    public void setHandled(Boolean bool) {
        this.handled = bool;
    }

    public void setMeta(Map map) {
        this.meta = CollectionUtils.newHashMap(map);
    }

    public void setSynthetic(Boolean bool) {
        this.synthetic = bool;
    }

    public void setExceptionId(Integer num) {
        this.exceptionId = num;
    }

    public void setParentId(Integer num) {
        this.parentId = num;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.description != null) {
            objectWriter.name(b.c).value(this.description);
        }
        if (this.helpLink != null) {
            objectWriter.name("help_link").value(this.helpLink);
        }
        if (this.handled != null) {
            objectWriter.name("handled").value(this.handled);
        }
        if (this.meta != null) {
            objectWriter.name(Constants.REFERRER_API_META).value(iLogger, this.meta);
        }
        if (this.data != null) {
            objectWriter.name(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        }
        if (this.synthetic != null) {
            objectWriter.name("synthetic").value(this.synthetic);
        }
        if (this.exceptionId != null) {
            objectWriter.name("exception_id").value(iLogger, this.exceptionId);
        }
        if (this.parentId != null) {
            objectWriter.name("parent_id").value(iLogger, this.parentId);
        }
        if (this.exceptionGroup != null) {
            objectWriter.name("is_exception_group").value(this.exceptionGroup);
        }
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
        public Mechanism deserialize(ObjectReader objectReader, ILogger iLogger) {
            Mechanism mechanism = new Mechanism();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "description":
                        mechanism.description = objectReader.nextStringOrNull();
                        break;
                    case "exception_id":
                        mechanism.exceptionId = objectReader.nextIntegerOrNull();
                        break;
                    case "data":
                        mechanism.data = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "meta":
                        mechanism.meta = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "type":
                        mechanism.type = objectReader.nextStringOrNull();
                        break;
                    case "handled":
                        mechanism.handled = objectReader.nextBooleanOrNull();
                        break;
                    case "synthetic":
                        mechanism.synthetic = objectReader.nextBooleanOrNull();
                        break;
                    case "is_exception_group":
                        mechanism.exceptionGroup = objectReader.nextBooleanOrNull();
                        break;
                    case "help_link":
                        mechanism.helpLink = objectReader.nextStringOrNull();
                        break;
                    case "parent_id":
                        mechanism.parentId = objectReader.nextIntegerOrNull();
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
            mechanism.setUnknown(map);
            return mechanism;
        }
    }
}
