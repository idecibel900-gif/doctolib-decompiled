package io.sentry.protocol;

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
public final class ArtContext implements JsonSerializable {
    private Long freeMemory;
    private Long freeMemoryUntilGc;
    private Long freeMemoryUntilOome;
    private Long gcBlockingCount;
    private Double gcBlockingTime;
    private Long gcPreOomeCount;
    private Long gcTotalCount;
    private Double gcTotalTime;
    private Double gcWaitingTime;
    private Long maxMemory;
    private Long totalMemory;
    private Map unknown;

    public ArtContext() {
    }

    ArtContext(ArtContext artContext) {
        this.gcTotalCount = artContext.gcTotalCount;
        this.gcTotalTime = artContext.gcTotalTime;
        this.gcBlockingCount = artContext.gcBlockingCount;
        this.gcBlockingTime = artContext.gcBlockingTime;
        this.gcPreOomeCount = artContext.gcPreOomeCount;
        this.gcWaitingTime = artContext.gcWaitingTime;
        this.freeMemory = artContext.freeMemory;
        this.freeMemoryUntilGc = artContext.freeMemoryUntilGc;
        this.freeMemoryUntilOome = artContext.freeMemoryUntilOome;
        this.totalMemory = artContext.totalMemory;
        this.maxMemory = artContext.maxMemory;
        this.unknown = CollectionUtils.newConcurrentHashMap(artContext.unknown);
    }

    public void setGcTotalCount(Long l) {
        this.gcTotalCount = l;
    }

    public void setGcTotalTime(Double d) {
        this.gcTotalTime = d;
    }

    public void setGcBlockingCount(Long l) {
        this.gcBlockingCount = l;
    }

    public void setGcBlockingTime(Double d) {
        this.gcBlockingTime = d;
    }

    public void setGcPreOomeCount(Long l) {
        this.gcPreOomeCount = l;
    }

    public void setGcWaitingTime(Double d) {
        this.gcWaitingTime = d;
    }

    public void setFreeMemory(Long l) {
        this.freeMemory = l;
    }

    public void setFreeMemoryUntilGc(Long l) {
        this.freeMemoryUntilGc = l;
    }

    public void setFreeMemoryUntilOome(Long l) {
        this.freeMemoryUntilOome = l;
    }

    public void setTotalMemory(Long l) {
        this.totalMemory = l;
    }

    public void setMaxMemory(Long l) {
        this.maxMemory = l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ArtContext.class == obj.getClass()) {
            ArtContext artContext = (ArtContext) obj;
            if (Objects.equals(this.gcTotalCount, artContext.gcTotalCount) && Objects.equals(this.gcTotalTime, artContext.gcTotalTime) && Objects.equals(this.gcBlockingCount, artContext.gcBlockingCount) && Objects.equals(this.gcBlockingTime, artContext.gcBlockingTime) && Objects.equals(this.gcPreOomeCount, artContext.gcPreOomeCount) && Objects.equals(this.gcWaitingTime, artContext.gcWaitingTime) && Objects.equals(this.freeMemory, artContext.freeMemory) && Objects.equals(this.freeMemoryUntilGc, artContext.freeMemoryUntilGc) && Objects.equals(this.freeMemoryUntilOome, artContext.freeMemoryUntilOome) && Objects.equals(this.totalMemory, artContext.totalMemory) && Objects.equals(this.maxMemory, artContext.maxMemory)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.gcTotalCount, this.gcTotalTime, this.gcBlockingCount, this.gcBlockingTime, this.gcPreOomeCount, this.gcWaitingTime, this.freeMemory, this.freeMemoryUntilGc, this.freeMemoryUntilOome, this.totalMemory, this.maxMemory);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.gcTotalCount != null) {
            objectWriter.name("gc.total_count").value(this.gcTotalCount);
        }
        if (this.gcTotalTime != null) {
            objectWriter.name("gc.total_time").value(this.gcTotalTime);
        }
        if (this.gcBlockingCount != null) {
            objectWriter.name("gc.blocking_count").value(this.gcBlockingCount);
        }
        if (this.gcBlockingTime != null) {
            objectWriter.name("gc.blocking_time").value(this.gcBlockingTime);
        }
        if (this.gcPreOomeCount != null) {
            objectWriter.name("gc.pre_oome_count").value(this.gcPreOomeCount);
        }
        if (this.gcWaitingTime != null) {
            objectWriter.name("gc.waiting_time").value(this.gcWaitingTime);
        }
        if (this.freeMemory != null) {
            objectWriter.name("memory.free").value(this.freeMemory);
        }
        if (this.freeMemoryUntilGc != null) {
            objectWriter.name("memory.free_until_gc").value(this.freeMemoryUntilGc);
        }
        if (this.freeMemoryUntilOome != null) {
            objectWriter.name("memory.free_until_oome").value(this.freeMemoryUntilOome);
        }
        if (this.totalMemory != null) {
            objectWriter.name("memory.total").value(this.totalMemory);
        }
        if (this.maxMemory != null) {
            objectWriter.name("memory.max").value(this.maxMemory);
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
        public ArtContext deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ArtContext artContext = new ArtContext();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "gc.total_time":
                        artContext.gcTotalTime = objectReader.nextDoubleOrNull();
                        break;
                    case "memory.free_until_gc":
                        artContext.freeMemoryUntilGc = objectReader.nextLongOrNull();
                        break;
                    case "gc.blocking_time":
                        artContext.gcBlockingTime = objectReader.nextDoubleOrNull();
                        break;
                    case "gc.waiting_time":
                        artContext.gcWaitingTime = objectReader.nextDoubleOrNull();
                        break;
                    case "memory.free_until_oome":
                        artContext.freeMemoryUntilOome = objectReader.nextLongOrNull();
                        break;
                    case "memory.total":
                        artContext.totalMemory = objectReader.nextLongOrNull();
                        break;
                    case "gc.pre_oome_count":
                        artContext.gcPreOomeCount = objectReader.nextLongOrNull();
                        break;
                    case "memory.free":
                        artContext.freeMemory = objectReader.nextLongOrNull();
                        break;
                    case "gc.blocking_count":
                        artContext.gcBlockingCount = objectReader.nextLongOrNull();
                        break;
                    case "gc.total_count":
                        artContext.gcTotalCount = objectReader.nextLongOrNull();
                        break;
                    case "memory.max":
                        artContext.maxMemory = objectReader.nextLongOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            artContext.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return artContext;
        }
    }
}
