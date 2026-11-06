package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryException implements JsonSerializable {
    private Mechanism mechanism;
    private String module;
    private SentryStackTrace stacktrace;
    private Long threadId;
    private String type;
    private Map unknown;
    private String value;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Long l) {
        this.threadId = l;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public void setStacktrace(SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public Mechanism getMechanism() {
        return this.mechanism;
    }

    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
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
        if (this.value != null) {
            objectWriter.name("value").value(this.value);
        }
        if (this.module != null) {
            objectWriter.name("module").value(this.module);
        }
        if (this.threadId != null) {
            objectWriter.name("thread_id").value(this.threadId);
        }
        if (this.stacktrace != null) {
            objectWriter.name("stacktrace").value(iLogger, this.stacktrace);
        }
        if (this.mechanism != null) {
            objectWriter.name("mechanism").value(iLogger, this.mechanism);
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
        public SentryException deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryException sentryException = new SentryException();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "thread_id":
                        sentryException.threadId = objectReader.nextLongOrNull();
                        break;
                    case "module":
                        sentryException.module = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        sentryException.type = objectReader.nextStringOrNull();
                        break;
                    case "value":
                        sentryException.value = objectReader.nextStringOrNull();
                        break;
                    case "mechanism":
                        sentryException.mechanism = (Mechanism) objectReader.nextOrNull(iLogger, new Mechanism.Deserializer());
                        break;
                    case "stacktrace":
                        sentryException.stacktrace = (SentryStackTrace) objectReader.nextOrNull(iLogger, new SentryStackTrace.Deserializer());
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
            sentryException.setUnknown(map);
            return sentryException;
        }
    }
}
