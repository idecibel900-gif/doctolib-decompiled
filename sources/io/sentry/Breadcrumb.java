package io.sentry;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Breadcrumb implements JsonSerializable, Comparable {
    private String category;
    private Map data;
    private SentryLevel level;
    private String message;
    private final Long nanos;
    private String origin;
    private Date timestamp;
    private final Long timestampMs;
    private String type;
    private Map unknown;

    public Breadcrumb(Date date) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestamp = date;
        this.timestampMs = null;
    }

    public Breadcrumb(long j) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestampMs = Long.valueOf(j);
        this.timestamp = null;
    }

    Breadcrumb(Breadcrumb breadcrumb) {
        this.data = new ConcurrentHashMap();
        this.nanos = Long.valueOf(System.nanoTime());
        this.timestamp = breadcrumb.timestamp;
        this.timestampMs = breadcrumb.timestampMs;
        this.message = breadcrumb.message;
        this.type = breadcrumb.type;
        this.category = breadcrumb.category;
        this.origin = breadcrumb.origin;
        Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap(breadcrumb.data);
        if (mapNewConcurrentHashMap != null) {
            this.data = mapNewConcurrentHashMap;
        }
        this.unknown = CollectionUtils.newConcurrentHashMap(breadcrumb.unknown);
        this.level = breadcrumb.level;
    }

    public static Breadcrumb userInteraction(String str, String str2, String str3, String str4, Map map) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("user");
        breadcrumb.setCategory("ui." + str);
        if (str2 != null) {
            breadcrumb.setData("view.id", str2);
        }
        if (str3 != null) {
            breadcrumb.setData("view.class", str3);
        }
        if (str4 != null) {
            breadcrumb.setData("view.tag", str4);
        }
        for (Map.Entry entry : map.entrySet()) {
            breadcrumb.getData().put((String) entry.getKey(), entry.getValue());
        }
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }

    public Breadcrumb() {
        this(System.currentTimeMillis());
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        Long l = this.timestampMs;
        if (l != null) {
            Date dateTime = DateUtils.getDateTime(l.longValue());
            this.timestamp = dateTime;
            return dateTime;
        }
        throw new IllegalStateException("No timestamp set for breadcrumb");
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map getData() {
        return this.data;
    }

    public Object getData(String str) {
        if (str == null) {
            return null;
        }
        return this.data.get(str);
    }

    public void setData(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            removeData(str);
        } else {
            this.data.put(str, obj);
        }
    }

    public void removeData(String str) {
        if (str == null) {
            return;
        }
        this.data.remove(str);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Breadcrumb.class != obj.getClass()) {
            return false;
        }
        Breadcrumb breadcrumb = (Breadcrumb) obj;
        if ("http".equals(this.type)) {
            return httpBreadcrumbEquals(this, breadcrumb);
        }
        return breadcrumbEquals(this, breadcrumb);
    }

    public int hashCode() {
        if ("http".equals(this.type)) {
            return httpBreadcrumbHashCode(this);
        }
        return breadcrumbHashCode(this);
    }

    private static boolean breadcrumbEquals(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
        return breadcrumb.getTimestamp().getTime() == breadcrumb2.getTimestamp().getTime() && Objects.equals(breadcrumb.message, breadcrumb2.message) && Objects.equals(breadcrumb.type, breadcrumb2.type) && Objects.equals(breadcrumb.category, breadcrumb2.category) && Objects.equals(breadcrumb.origin, breadcrumb2.origin) && breadcrumb.level == breadcrumb2.level;
    }

    private static boolean httpBreadcrumbEquals(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
        return breadcrumbEquals(breadcrumb, breadcrumb2) && Objects.equals(breadcrumb.getData("status_code"), breadcrumb2.getData("status_code")) && Objects.equals(breadcrumb.getData("url"), breadcrumb2.getData("url")) && Objects.equals(breadcrumb.getData("method"), breadcrumb2.getData("method")) && Objects.equals(breadcrumb.getData("http.fragment"), breadcrumb2.getData("http.fragment")) && Objects.equals(breadcrumb.getData("http.query"), breadcrumb2.getData("http.query"));
    }

    private static int breadcrumbHashCode(Breadcrumb breadcrumb) {
        return Objects.hash(Long.valueOf(breadcrumb.getTimestamp().getTime()), breadcrumb.message, breadcrumb.type, breadcrumb.category, breadcrumb.origin, breadcrumb.level);
    }

    private static int httpBreadcrumbHashCode(Breadcrumb breadcrumb) {
        return Objects.hash(Long.valueOf(breadcrumb.getTimestamp().getTime()), breadcrumb.message, breadcrumb.type, breadcrumb.category, breadcrumb.origin, breadcrumb.level, breadcrumb.getData("status_code"), breadcrumb.getData("url"), breadcrumb.getData("method"), breadcrumb.getData("http.fragment"), breadcrumb.getData("http.query"));
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // java.lang.Comparable
    public int compareTo(Breadcrumb breadcrumb) {
        return this.nanos.compareTo(breadcrumb.nanos);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, getTimestamp());
        if (this.message != null) {
            objectWriter.name("message").value(this.message);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        if (this.category != null) {
            objectWriter.name("category").value(this.category);
        }
        if (this.origin != null) {
            objectWriter.name("origin").value(this.origin);
        }
        if (this.level != null) {
            objectWriter.name("level").value(iLogger, this.level);
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
        public Breadcrumb deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Date currentDateTime = DateUtils.getCurrentDateTime();
            Map concurrentHashMap = new ConcurrentHashMap();
            String strNextStringOrNull = null;
            String strNextStringOrNull2 = null;
            String strNextStringOrNull3 = null;
            String strNextStringOrNull4 = null;
            SentryLevel sentryLevelDeserialize = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "origin":
                        strNextStringOrNull4 = objectReader.nextStringOrNull();
                        break;
                    case "data":
                        Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        if (mapNewConcurrentHashMap == null) {
                            break;
                        } else {
                            concurrentHashMap = mapNewConcurrentHashMap;
                            break;
                        }
                        break;
                    case "type":
                        strNextStringOrNull2 = objectReader.nextStringOrNull();
                        break;
                    case "category":
                        strNextStringOrNull3 = objectReader.nextStringOrNull();
                        break;
                    case "timestamp":
                        Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        if (dateNextDateOrNull == null) {
                            break;
                        } else {
                            currentDateTime = dateNextDateOrNull;
                            break;
                        }
                        break;
                    case "level":
                        try {
                            sentryLevelDeserialize = new SentryLevel.Deserializer().deserialize(objectReader, iLogger);
                            break;
                        } catch (Exception e) {
                            iLogger.log(SentryLevel.ERROR, e, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                        break;
                    case "message":
                        strNextStringOrNull = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap2, strNextName);
                        break;
                }
            }
            Breadcrumb breadcrumb = new Breadcrumb(currentDateTime);
            breadcrumb.message = strNextStringOrNull;
            breadcrumb.type = strNextStringOrNull2;
            breadcrumb.data = concurrentHashMap;
            breadcrumb.category = strNextStringOrNull3;
            breadcrumb.origin = strNextStringOrNull4;
            breadcrumb.level = sentryLevelDeserialize;
            breadcrumb.setUnknown(concurrentHashMap2);
            objectReader.endObject();
            return breadcrumb;
        }
    }
}
