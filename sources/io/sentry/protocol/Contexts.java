package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.ISentryLifecycleToken;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.ProfileContext;
import io.sentry.SpanContext;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
public class Contexts implements JsonSerializable {
    private final ConcurrentHashMap internalStorage = new ConcurrentHashMap();
    protected final AutoClosableReentrantLock responseLock = new AutoClosableReentrantLock();

    public Contexts() {
    }

    public Contexts(Contexts contexts) {
        for (Map.Entry entry : contexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof App)) {
                    setApp(new App((App) value));
                } else if ("browser".equals(entry.getKey()) && (value instanceof Browser)) {
                    setBrowser(new Browser((Browser) value));
                } else if ("device".equals(entry.getKey()) && (value instanceof Device)) {
                    setDevice(new Device((Device) value));
                } else if ("os".equals(entry.getKey()) && (value instanceof OperatingSystem)) {
                    setOperatingSystem(new OperatingSystem((OperatingSystem) value));
                } else if ("runtime".equals(entry.getKey()) && (value instanceof SentryRuntime)) {
                    setRuntime(new SentryRuntime((SentryRuntime) value));
                } else if ("feedback".equals(entry.getKey()) && (value instanceof Feedback)) {
                    setFeedback(new Feedback((Feedback) value));
                } else if ("gpu".equals(entry.getKey()) && (value instanceof Gpu)) {
                    setGpu(new Gpu((Gpu) value));
                } else if ("trace".equals(entry.getKey()) && (value instanceof SpanContext)) {
                    setTrace(new SpanContext((SpanContext) value));
                } else if (AuthorizationRequest.Scope.PROFILE.equals(entry.getKey()) && (value instanceof ProfileContext)) {
                    setProfile(new ProfileContext((ProfileContext) value));
                } else if ("response".equals(entry.getKey()) && (value instanceof Response)) {
                    setResponse(new Response((Response) value));
                } else if ("spring".equals(entry.getKey()) && (value instanceof Spring)) {
                    setSpring(new Spring((Spring) value));
                } else if ("art".equals(entry.getKey()) && (value instanceof ArtContext)) {
                    setArt(new ArtContext((ArtContext) value));
                } else {
                    put((String) entry.getKey(), value);
                }
            }
        }
    }

    private Object toContextType(String str, Class cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public SpanContext getTrace() {
        return (SpanContext) toContextType("trace", SpanContext.class);
    }

    public void setTrace(SpanContext spanContext) {
        Objects.requireNonNull(spanContext, "traceContext is required");
        put("trace", spanContext);
    }

    public void setProfile(ProfileContext profileContext) {
        Objects.requireNonNull(profileContext, "profileContext is required");
        put(AuthorizationRequest.Scope.PROFILE, profileContext);
    }

    public App getApp() {
        return (App) toContextType("app", App.class);
    }

    public void setApp(App app2) {
        put("app", app2);
    }

    public void setBrowser(Browser browser) {
        put("browser", browser);
    }

    public Device getDevice() {
        return (Device) toContextType("device", Device.class);
    }

    public void setDevice(Device device) {
        put("device", device);
    }

    public OperatingSystem getOperatingSystem() {
        return (OperatingSystem) toContextType("os", OperatingSystem.class);
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        put("os", operatingSystem);
    }

    public SentryRuntime getRuntime() {
        return (SentryRuntime) toContextType("runtime", SentryRuntime.class);
    }

    public void setRuntime(SentryRuntime sentryRuntime) {
        put("runtime", sentryRuntime);
    }

    public Feedback getFeedback() {
        return (Feedback) toContextType("feedback", Feedback.class);
    }

    public void setFeedback(Feedback feedback) {
        put("feedback", feedback);
    }

    public void setGpu(Gpu gpu) {
        put("gpu", gpu);
    }

    public void setResponse(Response response) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.responseLock.acquire();
        try {
            put("response", response);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setSpring(Spring spring) {
        put("spring", spring);
    }

    public void setArt(ArtContext artContext) {
        put("art", artContext);
    }

    public FeatureFlags getFeatureFlags() {
        return (FeatureFlags) toContextType("flags", FeatureFlags.class);
    }

    public void setFeatureFlags(FeatureFlags featureFlags) {
        put("flags", featureFlags);
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.internalStorage.containsKey(obj);
    }

    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.internalStorage.get(obj);
    }

    public Object put(String str, Object obj) {
        if (str == null) {
            return null;
        }
        if (obj == null) {
            return this.internalStorage.remove(str);
        }
        return this.internalStorage.put(str, obj);
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.internalStorage.remove(obj);
    }

    public Enumeration keys() {
        return this.internalStorage.keys();
    }

    public Set entrySet() {
        return this.internalStorage.entrySet();
    }

    public void putAll(Contexts contexts) {
        if (contexts == null) {
            return;
        }
        this.internalStorage.putAll(contexts.internalStorage);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Contexts)) {
            return false;
        }
        return this.internalStorage.equals(((Contexts) obj).internalStorage);
    }

    public int hashCode() {
        return this.internalStorage.hashCode();
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                objectWriter.name(str).value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public Contexts deserialize(ObjectReader objectReader, ILogger iLogger) {
            Contexts contexts = new Contexts();
            objectReader.beginObject();
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "device":
                        contexts.setDevice(new Device.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "spring":
                        contexts.setSpring(new Spring.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "response":
                        contexts.setResponse(new Response.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "profile":
                        contexts.setProfile(new ProfileContext.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "feedback":
                        contexts.setFeedback(new Feedback.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "os":
                        contexts.setOperatingSystem(new OperatingSystem.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "app":
                        contexts.setApp(new App.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "art":
                        contexts.setArt(new ArtContext.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "gpu":
                        contexts.setGpu(new Gpu.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "flags":
                        contexts.setFeatureFlags(new FeatureFlags.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "trace":
                        contexts.setTrace(new SpanContext.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "browser":
                        contexts.setBrowser(new Browser.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    case "runtime":
                        contexts.setRuntime(new SentryRuntime.Deserializer().deserialize(objectReader, iLogger));
                        break;
                    default:
                        Object objNextObjectOrNull = objectReader.nextObjectOrNull();
                        if (objNextObjectOrNull == null) {
                            break;
                        } else {
                            contexts.put(strNextName, objNextObjectOrNull);
                            break;
                        }
                        break;
                }
            }
            objectReader.endObject();
            return contexts;
        }
    }
}
