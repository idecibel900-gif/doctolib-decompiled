package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.TracingUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class PropagationContext {
    private final Baggage baggage;
    private SpanId parentSpanId;
    private Boolean sampled;
    private SpanId spanId;
    private SentryId traceId;

    public PropagationContext() {
        this(new SentryId(), new SpanId(), null, null, null);
    }

    public PropagationContext(PropagationContext propagationContext) {
        this(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), propagationContext.getBaggage(), propagationContext.isSampled());
    }

    public PropagationContext(SentryId sentryId, SpanId spanId, SpanId spanId2, Baggage baggage, Boolean bool) {
        this.traceId = sentryId;
        this.spanId = spanId;
        this.parentSpanId = spanId2;
        this.baggage = TracingUtils.ensureBaggage(baggage, bool, null, null);
        this.sampled = bool;
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

    public Baggage getBaggage() {
        return this.baggage;
    }

    public Boolean isSampled() {
        return this.sampled;
    }

    public TraceContext traceContext() {
        return this.baggage.toTraceContext();
    }

    public SpanContext toSpanContext() {
        SpanContext spanContext = new SpanContext(this.traceId, this.spanId, "default", null, null);
        spanContext.setOrigin("auto");
        return spanContext;
    }

    public Double getSampleRand() {
        Double sampleRand = this.baggage.getSampleRand();
        return Double.valueOf(sampleRand == null ? 0.0d : sampleRand.doubleValue());
    }
}
