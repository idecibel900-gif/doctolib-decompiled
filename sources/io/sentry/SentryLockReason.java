package io.sentry;

import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryLockReason implements JsonSerializable {
    private String address;
    private String className;
    private String packageName;
    private Long threadId;
    private int type;
    private Map unknown;

    public SentryLockReason() {
    }

    public SentryLockReason(SentryLockReason sentryLockReason) {
        this.type = sentryLockReason.type;
        this.address = sentryLockReason.address;
        this.packageName = sentryLockReason.packageName;
        this.className = sentryLockReason.className;
        this.threadId = sentryLockReason.threadId;
        this.unknown = CollectionUtils.newConcurrentHashMap(sentryLockReason.unknown);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setThreadId(Long l) {
        this.threadId = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SentryLockReason.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.address, ((SentryLockReason) obj).address);
    }

    public int hashCode() {
        return Objects.hash(this.address);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("type").value(this.type);
        if (this.address != null) {
            objectWriter.name(AuthorizationRequest.Scope.ADDRESS).value(this.address);
        }
        if (this.packageName != null) {
            objectWriter.name("package_name").value(this.packageName);
        }
        if (this.className != null) {
            objectWriter.name("class_name").value(this.className);
        }
        if (this.threadId != null) {
            objectWriter.name("thread_id").value(this.threadId);
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
        public SentryLockReason deserialize(ObjectReader objectReader, ILogger iLogger) {
            SentryLockReason sentryLockReason = new SentryLockReason();
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "package_name":
                        sentryLockReason.packageName = objectReader.nextStringOrNull();
                        break;
                    case "thread_id":
                        sentryLockReason.threadId = objectReader.nextLongOrNull();
                        break;
                    case "address":
                        sentryLockReason.address = objectReader.nextStringOrNull();
                        break;
                    case "class_name":
                        sentryLockReason.className = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        sentryLockReason.type = objectReader.nextInt();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            sentryLockReason.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryLockReason;
        }
    }
}
