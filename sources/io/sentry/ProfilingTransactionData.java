package io.sentry;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ProfilingTransactionData implements JsonSerializable {
    private String id;
    private String name;
    private Long relativeEndCpuMs;
    private Long relativeEndNs;
    private Long relativeStartCpuMs;
    private Long relativeStartNs;
    private String traceId;
    private Map unknown;

    public ProfilingTransactionData() {
        this(NoOpTransaction.getInstance(), 0L, 0L);
    }

    public ProfilingTransactionData(ITransaction iTransaction, Long l, Long l2) {
        this.id = iTransaction.getEventId().toString();
        this.traceId = iTransaction.getSpanContext().getTraceId().toString();
        this.name = iTransaction.getName().isEmpty() ? "unknown" : iTransaction.getName();
        this.relativeStartNs = l;
        this.relativeStartCpuMs = l2;
    }

    public void notifyFinish(Long l, Long l2, Long l3, Long l4) {
        if (this.relativeEndNs == null) {
            this.relativeEndNs = Long.valueOf(l.longValue() - l2.longValue());
            this.relativeStartNs = Long.valueOf(this.relativeStartNs.longValue() - l2.longValue());
            this.relativeEndCpuMs = Long.valueOf(l3.longValue() - l4.longValue());
            this.relativeStartCpuMs = Long.valueOf(this.relativeStartCpuMs.longValue() - l4.longValue());
        }
    }

    public String getId() {
        return this.id;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ProfilingTransactionData.class == obj.getClass()) {
            ProfilingTransactionData profilingTransactionData = (ProfilingTransactionData) obj;
            if (this.id.equals(profilingTransactionData.id) && this.traceId.equals(profilingTransactionData.traceId) && this.name.equals(profilingTransactionData.name) && this.relativeStartNs.equals(profilingTransactionData.relativeStartNs) && this.relativeStartCpuMs.equals(profilingTransactionData.relativeStartCpuMs) && Objects.equals(this.relativeEndCpuMs, profilingTransactionData.relativeEndCpuMs) && Objects.equals(this.relativeEndNs, profilingTransactionData.relativeEndNs) && Objects.equals(this.unknown, profilingTransactionData.unknown)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.traceId, this.name, this.relativeStartNs, this.relativeEndNs, this.relativeStartCpuMs, this.relativeEndCpuMs, this.unknown);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name(DiagnosticsEntry.ID_KEY).value(iLogger, this.id);
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        objectWriter.name("name").value(iLogger, this.name);
        objectWriter.name("relative_start_ns").value(iLogger, this.relativeStartNs);
        objectWriter.name("relative_end_ns").value(iLogger, this.relativeEndNs);
        objectWriter.name("relative_cpu_start_ms").value(iLogger, this.relativeStartCpuMs);
        objectWriter.name("relative_cpu_end_ms").value(iLogger, this.relativeEndCpuMs);
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
        public ProfilingTransactionData deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ProfilingTransactionData profilingTransactionData = new ProfilingTransactionData();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "relative_start_ns":
                        Long lNextLongOrNull = objectReader.nextLongOrNull();
                        if (lNextLongOrNull == null) {
                            break;
                        } else {
                            profilingTransactionData.relativeStartNs = lNextLongOrNull;
                            break;
                        }
                        break;
                    case "relative_end_ns":
                        Long lNextLongOrNull2 = objectReader.nextLongOrNull();
                        if (lNextLongOrNull2 == null) {
                            break;
                        } else {
                            profilingTransactionData.relativeEndNs = lNextLongOrNull2;
                            break;
                        }
                        break;
                    case "id":
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull == null) {
                            break;
                        } else {
                            profilingTransactionData.id = strNextStringOrNull;
                            break;
                        }
                        break;
                    case "name":
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull2 == null) {
                            break;
                        } else {
                            profilingTransactionData.name = strNextStringOrNull2;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strNextStringOrNull3 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull3 == null) {
                            break;
                        } else {
                            profilingTransactionData.traceId = strNextStringOrNull3;
                            break;
                        }
                        break;
                    case "relative_cpu_end_ms":
                        Long lNextLongOrNull3 = objectReader.nextLongOrNull();
                        if (lNextLongOrNull3 == null) {
                            break;
                        } else {
                            profilingTransactionData.relativeEndCpuMs = lNextLongOrNull3;
                            break;
                        }
                        break;
                    case "relative_cpu_start_ms":
                        Long lNextLongOrNull4 = objectReader.nextLongOrNull();
                        if (lNextLongOrNull4 == null) {
                            break;
                        } else {
                            profilingTransactionData.relativeStartCpuMs = lNextLongOrNull4;
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            profilingTransactionData.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profilingTransactionData;
        }
    }
}
