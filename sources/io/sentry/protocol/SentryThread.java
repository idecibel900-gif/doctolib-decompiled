package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryLockReason;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryThread implements JsonSerializable {
    private Boolean crashed;
    private Boolean current;
    private Boolean daemon;
    private Map heldLocks;
    private Long id;
    private Boolean main;
    private String name;
    private Integer priority;
    private SentryStackTrace stacktrace;
    private String state;
    private Map unknown;

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setCrashed(Boolean bool) {
        this.crashed = bool;
    }

    public Boolean isCurrent() {
        return this.current;
    }

    public void setCurrent(Boolean bool) {
        this.current = bool;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public void setStacktrace(SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public void setDaemon(Boolean bool) {
        this.daemon = bool;
    }

    public Boolean isMain() {
        return this.main;
    }

    public void setMain(Boolean bool) {
        this.main = bool;
    }

    public void setState(String str) {
        this.state = str;
    }

    public Map getHeldLocks() {
        return this.heldLocks;
    }

    public void setHeldLocks(Map map) {
        this.heldLocks = map;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.id != null) {
            objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
        }
        if (this.priority != null) {
            objectWriter.name("priority").value(this.priority);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.state != null) {
            objectWriter.name("state").value(this.state);
        }
        if (this.crashed != null) {
            objectWriter.name("crashed").value(this.crashed);
        }
        if (this.current != null) {
            objectWriter.name("current").value(this.current);
        }
        if (this.daemon != null) {
            objectWriter.name("daemon").value(this.daemon);
        }
        if (this.main != null) {
            objectWriter.name("main").value(this.main);
        }
        if (this.stacktrace != null) {
            objectWriter.name("stacktrace").value(iLogger, this.stacktrace);
        }
        if (this.heldLocks != null) {
            objectWriter.name("held_locks").value(iLogger, this.heldLocks);
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
        public SentryThread deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryThread sentryThread = new SentryThread();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "daemon":
                        sentryThread.daemon = objectReader.nextBooleanOrNull();
                        break;
                    case "priority":
                        sentryThread.priority = objectReader.nextIntegerOrNull();
                        break;
                    case "held_locks":
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new SentryLockReason.Deserializer());
                        if (mapNextMapOrNull == null) {
                            break;
                        } else {
                            sentryThread.heldLocks = new HashMap(mapNextMapOrNull);
                            break;
                        }
                        break;
                    case "id":
                        sentryThread.id = objectReader.nextLongOrNull();
                        break;
                    case "main":
                        sentryThread.main = objectReader.nextBooleanOrNull();
                        break;
                    case "name":
                        sentryThread.name = objectReader.nextStringOrNull();
                        break;
                    case "state":
                        sentryThread.state = objectReader.nextStringOrNull();
                        break;
                    case "crashed":
                        sentryThread.crashed = objectReader.nextBooleanOrNull();
                        break;
                    case "current":
                        sentryThread.current = objectReader.nextBooleanOrNull();
                        break;
                    case "stacktrace":
                        sentryThread.stacktrace = (SentryStackTrace) objectReader.nextOrNull(iLogger, new SentryStackTrace.Deserializer());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryThread.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryThread;
        }
    }
}
