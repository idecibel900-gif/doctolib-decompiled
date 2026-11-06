package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class OperatingSystem implements JsonSerializable {
    private String build;
    private String kernelVersion;
    private String name;
    private String rawDescription;
    private Boolean rooted;
    private Map unknown;
    private String version;

    public OperatingSystem() {
    }

    OperatingSystem(OperatingSystem operatingSystem) {
        this.name = operatingSystem.name;
        this.version = operatingSystem.version;
        this.rawDescription = operatingSystem.rawDescription;
        this.build = operatingSystem.build;
        this.kernelVersion = operatingSystem.kernelVersion;
        this.rooted = operatingSystem.rooted;
        this.unknown = CollectionUtils.newConcurrentHashMap(operatingSystem.unknown);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setBuild(String str) {
        this.build = str;
    }

    public void setKernelVersion(String str) {
        this.kernelVersion = str;
    }

    public void setRooted(Boolean bool) {
        this.rooted = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && OperatingSystem.class == obj.getClass()) {
            OperatingSystem operatingSystem = (OperatingSystem) obj;
            if (Objects.equals(this.name, operatingSystem.name) && Objects.equals(this.version, operatingSystem.version) && Objects.equals(this.rawDescription, operatingSystem.rawDescription) && Objects.equals(this.build, operatingSystem.build) && Objects.equals(this.kernelVersion, operatingSystem.kernelVersion) && Objects.equals(this.rooted, operatingSystem.rooted)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version, this.rawDescription, this.build, this.kernelVersion, this.rooted);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.version != null) {
            objectWriter.name(DiagnosticsEntry.VERSION_KEY).value(this.version);
        }
        if (this.rawDescription != null) {
            objectWriter.name("raw_description").value(this.rawDescription);
        }
        if (this.build != null) {
            objectWriter.name("build").value(this.build);
        }
        if (this.kernelVersion != null) {
            objectWriter.name("kernel_version").value(this.kernelVersion);
        }
        if (this.rooted != null) {
            objectWriter.name("rooted").value(this.rooted);
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

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public OperatingSystem deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            OperatingSystem operatingSystem = new OperatingSystem();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "rooted":
                        operatingSystem.rooted = objectReader.nextBooleanOrNull();
                        break;
                    case "raw_description":
                        operatingSystem.rawDescription = objectReader.nextStringOrNull();
                        break;
                    case "name":
                        operatingSystem.name = objectReader.nextStringOrNull();
                        break;
                    case "build":
                        operatingSystem.build = objectReader.nextStringOrNull();
                        break;
                    case "version":
                        operatingSystem.version = objectReader.nextStringOrNull();
                        break;
                    case "kernel_version":
                        operatingSystem.kernelVersion = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            operatingSystem.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return operatingSystem;
        }
    }
}
