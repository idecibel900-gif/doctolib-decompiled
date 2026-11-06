package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryTracer;
import io.sentry.Span;
import io.sentry.SpanContext;
import io.sentry.TracesSamplingDecision;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryTransaction extends SentryBaseEvent implements JsonSerializable {
    private final Map measurements;
    private final List spans;
    private Double startTimestamp;
    private Double timestamp;
    private String transaction;
    private TransactionInfo transactionInfo;
    private final String type;
    private Map unknown;

    public SentryTransaction(SentryTracer sentryTracer) {
        super(sentryTracer.getEventId());
        this.spans = new ArrayList();
        this.type = "transaction";
        this.measurements = new HashMap();
        Objects.requireNonNull(sentryTracer, "sentryTracer is required");
        this.startTimestamp = Double.valueOf(DateUtils.nanosToSeconds(sentryTracer.getStartDate().nanoTimestamp()));
        this.timestamp = Double.valueOf(DateUtils.nanosToSeconds(sentryTracer.getStartDate().laterDateNanosTimestampByDiff(sentryTracer.getFinishDate())));
        this.transaction = sentryTracer.getName();
        for (Span span : sentryTracer.getChildren()) {
            if (Boolean.TRUE.equals(span.isSampled())) {
                this.spans.add(new SentrySpan(span));
            }
        }
        Contexts contexts = getContexts();
        contexts.putAll(sentryTracer.getContexts());
        SpanContext spanContext = sentryTracer.getSpanContext();
        Map data = sentryTracer.getData();
        SpanContext spanContext2 = new SpanContext(spanContext.getTraceId(), spanContext.getSpanId(), spanContext.getParentSpanId(), spanContext.getOperation(), spanContext.getDescription(), spanContext.getSamplingDecision(), spanContext.getStatus(), spanContext.getOrigin());
        for (Map.Entry entry : spanContext.getTags().entrySet()) {
            setTag((String) entry.getKey(), (String) entry.getValue());
        }
        if (data != null) {
            for (Map.Entry entry2 : data.entrySet()) {
                spanContext2.setData((String) entry2.getKey(), entry2.getValue());
            }
        }
        FeatureFlags featureFlags = spanContext.getFeatureFlagBuffer().getFeatureFlags();
        if (featureFlags != null) {
            for (FeatureFlag featureFlag : featureFlags.getValues()) {
                spanContext2.setData("flag.evaluation." + featureFlag.getFlag(), featureFlag.getResult());
            }
        }
        contexts.setTrace(spanContext2);
        this.transactionInfo = new TransactionInfo(sentryTracer.getTransactionNameSource().apiName());
    }

    public SentryTransaction(String str, Double d, Double d2, List list, Map map, TransactionInfo transactionInfo) {
        ArrayList arrayList = new ArrayList();
        this.spans = arrayList;
        this.type = "transaction";
        HashMap map2 = new HashMap();
        this.measurements = map2;
        this.transaction = str;
        this.startTimestamp = d;
        this.timestamp = d2;
        arrayList.addAll(list);
        map2.putAll(map);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.measurements.putAll(((SentrySpan) it.next()).getMeasurements());
        }
        this.transactionInfo = transactionInfo;
    }

    public List getSpans() {
        return this.spans;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public boolean isSampled() {
        TracesSamplingDecision samplingDecision = getSamplingDecision();
        if (samplingDecision == null) {
            return false;
        }
        return samplingDecision.getSampled().booleanValue();
    }

    public TracesSamplingDecision getSamplingDecision() {
        SpanContext trace = getContexts().getTrace();
        if (trace == null) {
            return null;
        }
        return trace.getSamplingDecision();
    }

    public Map getMeasurements() {
        return this.measurements;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.transaction != null) {
            objectWriter.name("transaction").value(this.transaction);
        }
        objectWriter.name("start_timestamp").value(iLogger, DateUtils.doubleToBigDecimal(this.startTimestamp));
        if (this.timestamp != null) {
            objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, DateUtils.doubleToBigDecimal(this.timestamp));
        }
        if (!this.spans.isEmpty()) {
            objectWriter.name("spans").value(iLogger, this.spans);
        }
        objectWriter.name("type").value("transaction");
        if (!this.measurements.isEmpty()) {
            objectWriter.name("measurements").value(iLogger, this.measurements);
        }
        objectWriter.name("transaction_info").value(iLogger, this.transactionInfo);
        new SentryBaseEvent.Serializer().serialize(this, objectWriter, iLogger);
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
        public SentryTransaction deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            SentryTransaction sentryTransaction = new SentryTransaction("", Double.valueOf(0.0d), null, new ArrayList(), new HashMap(), new TransactionInfo(TransactionNameSource.CUSTOM.apiName()));
            SentryBaseEvent.Deserializer deserializer = new SentryBaseEvent.Deserializer();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "start_timestamp":
                        try {
                            Double dNextDoubleOrNull = objectReader.nextDoubleOrNull();
                            if (dNextDoubleOrNull != null) {
                                sentryTransaction.startTimestamp = dNextDoubleOrNull;
                            }
                            break;
                        } catch (NumberFormatException unused) {
                            Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull != null) {
                                sentryTransaction.startTimestamp = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull));
                            }
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new MeasurementValue.Deserializer());
                        if (mapNextMapOrNull != null) {
                            sentryTransaction.measurements.putAll(mapNextMapOrNull);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "type":
                        objectReader.nextString();
                        break;
                    case "timestamp":
                        try {
                            Double dNextDoubleOrNull2 = objectReader.nextDoubleOrNull();
                            if (dNextDoubleOrNull2 != null) {
                                sentryTransaction.timestamp = dNextDoubleOrNull2;
                            }
                            break;
                        } catch (NumberFormatException unused2) {
                            Date dateNextDateOrNull2 = objectReader.nextDateOrNull(iLogger);
                            if (dateNextDateOrNull2 != null) {
                                sentryTransaction.timestamp = Double.valueOf(DateUtils.dateToSeconds(dateNextDateOrNull2));
                            }
                            break;
                        }
                        break;
                    case "spans":
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new SentrySpan.Deserializer());
                        if (listNextListOrNull != null) {
                            sentryTransaction.spans.addAll(listNextListOrNull);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "transaction_info":
                        sentryTransaction.transactionInfo = new TransactionInfo.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "transaction":
                        sentryTransaction.transaction = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (deserializer.deserializeValue(sentryTransaction, strNextName, objectReader, iLogger)) {
                            break;
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                            break;
                        }
                        break;
                }
            }
            sentryTransaction.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return sentryTransaction;
        }
    }
}
