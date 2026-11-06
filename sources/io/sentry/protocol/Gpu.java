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
public final class Gpu implements JsonSerializable {
    private String apiType;
    private Integer id;
    private Integer memorySize;
    private Boolean multiThreadedRendering;
    private String name;
    private String npotSupport;
    private Map unknown;
    private String vendorId;
    private String vendorName;
    private String version;

    public Gpu() {
    }

    Gpu(Gpu gpu) {
        this.name = gpu.name;
        this.id = gpu.id;
        this.vendorId = gpu.vendorId;
        this.vendorName = gpu.vendorName;
        this.memorySize = gpu.memorySize;
        this.apiType = gpu.apiType;
        this.multiThreadedRendering = gpu.multiThreadedRendering;
        this.version = gpu.version;
        this.npotSupport = gpu.npotSupport;
        this.unknown = CollectionUtils.newConcurrentHashMap(gpu.unknown);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Gpu.class == obj.getClass()) {
            Gpu gpu = (Gpu) obj;
            if (Objects.equals(this.name, gpu.name) && Objects.equals(this.id, gpu.id) && Objects.equals(this.vendorId, gpu.vendorId) && Objects.equals(this.vendorName, gpu.vendorName) && Objects.equals(this.memorySize, gpu.memorySize) && Objects.equals(this.apiType, gpu.apiType) && Objects.equals(this.multiThreadedRendering, gpu.multiThreadedRendering) && Objects.equals(this.version, gpu.version) && Objects.equals(this.npotSupport, gpu.npotSupport)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.id, this.vendorId, this.vendorName, this.memorySize, this.apiType, this.multiThreadedRendering, this.version, this.npotSupport);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.id != null) {
            objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
        }
        if (this.vendorId != null) {
            objectWriter.name("vendor_id").value(this.vendorId);
        }
        if (this.vendorName != null) {
            objectWriter.name("vendor_name").value(this.vendorName);
        }
        if (this.memorySize != null) {
            objectWriter.name("memory_size").value(this.memorySize);
        }
        if (this.apiType != null) {
            objectWriter.name("api_type").value(this.apiType);
        }
        if (this.multiThreadedRendering != null) {
            objectWriter.name("multi_threaded_rendering").value(this.multiThreadedRendering);
        }
        if (this.version != null) {
            objectWriter.name(DiagnosticsEntry.VERSION_KEY).value(this.version);
        }
        if (this.npotSupport != null) {
            objectWriter.name("npot_support").value(this.npotSupport);
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
        public Gpu deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Gpu gpu = new Gpu();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "npot_support":
                        gpu.npotSupport = objectReader.nextStringOrNull();
                        break;
                    case "vendor_id":
                        gpu.vendorId = objectReader.nextStringOrNull();
                        break;
                    case "multi_threaded_rendering":
                        gpu.multiThreadedRendering = objectReader.nextBooleanOrNull();
                        break;
                    case "id":
                        gpu.id = objectReader.nextIntegerOrNull();
                        break;
                    case "name":
                        gpu.name = objectReader.nextStringOrNull();
                        break;
                    case "vendor_name":
                        gpu.vendorName = objectReader.nextStringOrNull();
                        break;
                    case "version":
                        gpu.version = objectReader.nextStringOrNull();
                        break;
                    case "api_type":
                        gpu.apiType = objectReader.nextStringOrNull();
                        break;
                    case "memory_size":
                        gpu.memorySize = objectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            gpu.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return gpu;
        }
    }
}
