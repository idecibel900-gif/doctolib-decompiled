package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SentryBaseEvent {
    private List breadcrumbs;
    private final Contexts contexts;
    private DebugMeta debugMeta;
    private String dist;
    private String environment;
    private SentryId eventId;
    private Map extra;
    private String platform;
    private String release;
    private Request request;
    private SdkVersion sdk;
    private String serverName;
    private Map tags;
    protected transient Throwable throwable;
    private User user;

    protected SentryBaseEvent(SentryId sentryId) {
        this.contexts = new Contexts();
        this.eventId = sentryId;
    }

    protected SentryBaseEvent() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public void setEventId(SentryId sentryId) {
        this.eventId = sentryId;
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public SdkVersion getSdk() {
        return this.sdk;
    }

    public void setSdk(SdkVersion sdkVersion) {
        this.sdk = sdkVersion;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Throwable getThrowable() {
        Throwable th = this.throwable;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).getThrowable() : th;
    }

    public Throwable getThrowableMechanism() {
        return this.throwable;
    }

    public Map getTags() {
        return this.tags;
    }

    public void setTags(Map map) {
        this.tags = CollectionUtils.newHashMap(map);
    }

    public void removeTag(String str) {
        Map map = this.tags;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public void setTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeTag(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public void setBreadcrumbs(List list) {
        this.breadcrumbs = CollectionUtils.newArrayList(list);
    }

    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public void setDebugMeta(DebugMeta debugMeta) {
        this.debugMeta = debugMeta;
    }

    public Map getExtras() {
        return this.extra;
    }

    public void setExtras(Map map) {
        this.extra = CollectionUtils.newHashMap(map);
    }

    public static final class Serializer {
        public void serialize(SentryBaseEvent sentryBaseEvent, ObjectWriter objectWriter, ILogger iLogger) {
            if (sentryBaseEvent.eventId != null) {
                objectWriter.name("event_id").value(iLogger, sentryBaseEvent.eventId);
            }
            objectWriter.name("contexts").value(iLogger, sentryBaseEvent.contexts);
            if (sentryBaseEvent.sdk != null) {
                objectWriter.name("sdk").value(iLogger, sentryBaseEvent.sdk);
            }
            if (sentryBaseEvent.request != null) {
                objectWriter.name("request").value(iLogger, sentryBaseEvent.request);
            }
            if (sentryBaseEvent.tags != null && !sentryBaseEvent.tags.isEmpty()) {
                objectWriter.name("tags").value(iLogger, sentryBaseEvent.tags);
            }
            if (sentryBaseEvent.release != null) {
                objectWriter.name("release").value(sentryBaseEvent.release);
            }
            if (sentryBaseEvent.environment != null) {
                objectWriter.name("environment").value(sentryBaseEvent.environment);
            }
            if (sentryBaseEvent.platform != null) {
                objectWriter.name("platform").value(sentryBaseEvent.platform);
            }
            if (sentryBaseEvent.user != null) {
                objectWriter.name("user").value(iLogger, sentryBaseEvent.user);
            }
            if (sentryBaseEvent.serverName != null) {
                objectWriter.name("server_name").value(sentryBaseEvent.serverName);
            }
            if (sentryBaseEvent.dist != null) {
                objectWriter.name("dist").value(sentryBaseEvent.dist);
            }
            if (sentryBaseEvent.breadcrumbs != null && !sentryBaseEvent.breadcrumbs.isEmpty()) {
                objectWriter.name("breadcrumbs").value(iLogger, sentryBaseEvent.breadcrumbs);
            }
            if (sentryBaseEvent.debugMeta != null) {
                objectWriter.name("debug_meta").value(iLogger, sentryBaseEvent.debugMeta);
            }
            if (sentryBaseEvent.extra == null || sentryBaseEvent.extra.isEmpty()) {
                return;
            }
            objectWriter.name("extra").value(iLogger, sentryBaseEvent.extra);
        }
    }

    public static final class Deserializer {
        public boolean deserializeValue(SentryBaseEvent sentryBaseEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            str.getClass();
            switch (str) {
                case "debug_meta":
                    sentryBaseEvent.debugMeta = (DebugMeta) objectReader.nextOrNull(iLogger, new DebugMeta.Deserializer());
                    return true;
                case "server_name":
                    sentryBaseEvent.serverName = objectReader.nextStringOrNull();
                    return true;
                case "contexts":
                    sentryBaseEvent.contexts.putAll(new Contexts.Deserializer().deserialize(objectReader, iLogger));
                    return true;
                case "environment":
                    sentryBaseEvent.environment = objectReader.nextStringOrNull();
                    return true;
                case "breadcrumbs":
                    sentryBaseEvent.breadcrumbs = objectReader.nextListOrNull(iLogger, new Breadcrumb.Deserializer());
                    return true;
                case "sdk":
                    sentryBaseEvent.sdk = (SdkVersion) objectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                    return true;
                case "dist":
                    sentryBaseEvent.dist = objectReader.nextStringOrNull();
                    return true;
                case "tags":
                    sentryBaseEvent.tags = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    return true;
                case "user":
                    sentryBaseEvent.user = (User) objectReader.nextOrNull(iLogger, new User.Deserializer());
                    return true;
                case "extra":
                    sentryBaseEvent.extra = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                    return true;
                case "event_id":
                    sentryBaseEvent.eventId = (SentryId) objectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                    return true;
                case "release":
                    sentryBaseEvent.release = objectReader.nextStringOrNull();
                    return true;
                case "request":
                    sentryBaseEvent.request = (Request) objectReader.nextOrNull(iLogger, new Request.Deserializer());
                    return true;
                case "platform":
                    sentryBaseEvent.platform = objectReader.nextStringOrNull();
                    return true;
                default:
                    return false;
            }
        }
    }
}
