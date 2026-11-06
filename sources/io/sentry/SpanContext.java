package io.sentry;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import io.sentry.featureflags.IFeatureFlagBuffer;
import io.sentry.featureflags.SpanFeatureFlagBuffer;
import io.sentry.protocol.SentryId;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.util.thread.IThreadChecker;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class SpanContext implements JsonSerializable {
    protected Baggage baggage;
    protected Map data;
    protected String description;
    protected IFeatureFlagBuffer featureFlags;
    private Instrumenter instrumenter;
    protected String op;
    protected String origin;
    private SpanId parentSpanId;
    private SentryId profilerId;
    private transient TracesSamplingDecision samplingDecision;
    private final SpanId spanId;
    protected SpanStatus status;
    protected Map tags;
    private final SentryId traceId;
    private Map unknown;

    public SpanContext(String str) {
        this(new SentryId(), new SpanId(), str, null, null);
    }

    public SpanContext(SentryId sentryId, SpanId spanId, String str, SpanId spanId2, TracesSamplingDecision tracesSamplingDecision) {
        this(sentryId, spanId, spanId2, str, null, tracesSamplingDecision, null, "manual");
    }

    public SpanContext(SentryId sentryId, SpanId spanId, SpanId spanId2, String str, String str2, TracesSamplingDecision tracesSamplingDecision, SpanStatus spanStatus, String str3) {
        this.tags = new ConcurrentHashMap();
        this.origin = "manual";
        this.data = new ConcurrentHashMap();
        this.instrumenter = Instrumenter.SENTRY;
        this.featureFlags = SpanFeatureFlagBuffer.create();
        this.profilerId = SentryId.EMPTY_ID;
        this.traceId = (SentryId) Objects.requireNonNull(sentryId, "traceId is required");
        this.spanId = (SpanId) Objects.requireNonNull(spanId, "spanId is required");
        this.op = (String) Objects.requireNonNull(str, "operation is required");
        this.parentSpanId = spanId2;
        this.description = str2;
        this.status = spanStatus;
        this.origin = str3;
        setSamplingDecision(tracesSamplingDecision);
        IThreadChecker threadChecker = ScopesAdapter.getInstance().getOptions().getThreadChecker();
        this.data.put("thread.id", String.valueOf(threadChecker.currentThreadSystemId()));
        this.data.put("thread.name", threadChecker.getCurrentThreadName());
    }

    public SpanContext(SpanContext spanContext) {
        this.tags = new ConcurrentHashMap();
        this.origin = "manual";
        this.data = new ConcurrentHashMap();
        this.instrumenter = Instrumenter.SENTRY;
        this.featureFlags = SpanFeatureFlagBuffer.create();
        this.profilerId = SentryId.EMPTY_ID;
        this.traceId = spanContext.traceId;
        this.spanId = spanContext.spanId;
        this.parentSpanId = spanContext.parentSpanId;
        setSamplingDecision(spanContext.samplingDecision);
        this.op = spanContext.op;
        this.description = spanContext.description;
        this.status = spanContext.status;
        Map mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap(spanContext.tags);
        if (mapNewConcurrentHashMap != null) {
            this.tags = mapNewConcurrentHashMap;
        }
        Map mapNewConcurrentHashMap2 = CollectionUtils.newConcurrentHashMap(spanContext.unknown);
        if (mapNewConcurrentHashMap2 != null) {
            this.unknown = mapNewConcurrentHashMap2;
        }
        this.baggage = spanContext.baggage;
        Map mapNewConcurrentHashMap3 = CollectionUtils.newConcurrentHashMap(spanContext.data);
        if (mapNewConcurrentHashMap3 != null) {
            this.data = mapNewConcurrentHashMap3;
        }
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setStatus(SpanStatus spanStatus) {
        this.status = spanStatus;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public String getOperation() {
        return this.op;
    }

    public String getDescription() {
        return this.description;
    }

    public SpanStatus getStatus() {
        return this.status;
    }

    public Map getTags() {
        return this.tags;
    }

    public TracesSamplingDecision getSamplingDecision() {
        return this.samplingDecision;
    }

    public Boolean getSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.samplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    public Boolean getProfileSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.samplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getProfileSampled();
    }

    public void setSamplingDecision(TracesSamplingDecision tracesSamplingDecision) {
        this.samplingDecision = tracesSamplingDecision;
        Baggage baggage = this.baggage;
        if (baggage != null) {
            baggage.setValuesFromSamplingDecision(tracesSamplingDecision);
        }
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public void setInstrumenter(Instrumenter instrumenter) {
        this.instrumenter = instrumenter;
    }

    public Baggage getBaggage() {
        return this.baggage;
    }

    public void setData(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            this.data.remove(str);
        } else {
            this.data.put(str, obj);
        }
    }

    public SpanContext copyForChild(String str, SpanId spanId, SpanId spanId2) {
        SentryId sentryId = this.traceId;
        if (spanId2 == null) {
            spanId2 = new SpanId();
        }
        return new SpanContext(sentryId, spanId2, spanId, str, null, this.samplingDecision, null, "manual");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanContext)) {
            return false;
        }
        SpanContext spanContext = (SpanContext) obj;
        return this.traceId.equals(spanContext.traceId) && this.spanId.equals(spanContext.spanId) && Objects.equals(this.parentSpanId, spanContext.parentSpanId) && this.op.equals(spanContext.op) && Objects.equals(this.description, spanContext.description) && getStatus() == spanContext.getStatus();
    }

    public int hashCode() {
        return Objects.hash(this.traceId, this.spanId, this.parentSpanId, this.op, this.description, getStatus());
    }

    public SentryId getProfilerId() {
        return this.profilerId;
    }

    public IFeatureFlagBuffer getFeatureFlagBuffer() {
        return this.featureFlags;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("trace_id");
        this.traceId.serialize(objectWriter, iLogger);
        objectWriter.name("span_id");
        this.spanId.serialize(objectWriter, iLogger);
        if (this.parentSpanId != null) {
            objectWriter.name("parent_span_id");
            this.parentSpanId.serialize(objectWriter, iLogger);
        }
        objectWriter.name("op").value(this.op);
        if (this.description != null) {
            objectWriter.name(b.c).value(this.description);
        }
        if (getStatus() != null) {
            objectWriter.name("status").value(iLogger, getStatus());
        }
        if (this.origin != null) {
            objectWriter.name("origin").value(iLogger, this.origin);
        }
        if (!this.tags.isEmpty()) {
            objectWriter.name("tags").value(iLogger, this.tags);
        }
        if (!this.data.isEmpty()) {
            objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SpanContext deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            String strNextString = null;
            SentryId sentryIdDeserialize = null;
            SpanId spanIdDeserialize = null;
            SpanId spanId = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strNextString2 = null;
            SpanStatus spanStatus = null;
            String strNextString3 = null;
            Map mapNewConcurrentHashMap = null;
            Map map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "span_id":
                        spanIdDeserialize = new SpanId.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "parent_span_id":
                        spanId = (SpanId) objectReader.nextOrNull(iLogger, new SpanId.Deserializer());
                        break;
                    case "description":
                        strNextString2 = objectReader.nextString();
                        break;
                    case "origin":
                        strNextString3 = objectReader.nextString();
                        break;
                    case "status":
                        spanStatus = (SpanStatus) objectReader.nextOrNull(iLogger, new SpanStatus.Deserializer());
                        break;
                    case "op":
                        strNextString = objectReader.nextString();
                        break;
                    case "data":
                        map = (Map) objectReader.nextObjectOrNull();
                        break;
                    case "tags":
                        mapNewConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "trace_id":
                        sentryIdDeserialize = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            if (sentryIdDeserialize == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (spanIdDeserialize == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strNextString == null) {
                strNextString = "";
            }
            SpanContext spanContext = new SpanContext(sentryIdDeserialize, spanIdDeserialize, strNextString, spanId, null);
            spanContext.setDescription(strNextString2);
            spanContext.setStatus(spanStatus);
            spanContext.setOrigin(strNextString3);
            if (mapNewConcurrentHashMap != null) {
                spanContext.tags = mapNewConcurrentHashMap;
            }
            if (map != null) {
                spanContext.data = map;
            }
            spanContext.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return spanContext;
        }
    }
}
