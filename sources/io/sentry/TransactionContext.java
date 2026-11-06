package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.Objects;
import io.sentry.util.TracingUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class TransactionContext extends SpanContext {
    private static final TransactionNameSource DEFAULT_NAME_SOURCE = TransactionNameSource.CUSTOM;
    private boolean isForNextAppStart;
    private String name;
    private TracesSamplingDecision parentSamplingDecision;
    private TransactionNameSource transactionNameSource;

    public static TransactionContext fromPropagationContext(PropagationContext propagationContext) {
        Boolean boolIsSampled = propagationContext.isSampled();
        Baggage baggage = propagationContext.getBaggage();
        return new TransactionContext(propagationContext.getTraceId(), propagationContext.getSpanId(), propagationContext.getParentSpanId(), boolIsSampled == null ? null : new TracesSamplingDecision(boolIsSampled, baggage.getSampleRate(), propagationContext.getSampleRand()), baggage);
    }

    public TransactionContext(String str, String str2) {
        this(str, str2, (TracesSamplingDecision) null);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2) {
        this(str, transactionNameSource, str2, null);
    }

    public TransactionContext(String str, String str2, TracesSamplingDecision tracesSamplingDecision) {
        this(str, TransactionNameSource.CUSTOM, str2, tracesSamplingDecision);
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2, TracesSamplingDecision tracesSamplingDecision) {
        super(str2);
        this.isForNextAppStart = false;
        this.name = (String) Objects.requireNonNull(str, "name is required");
        this.transactionNameSource = transactionNameSource;
        setSamplingDecision(tracesSamplingDecision);
        this.baggage = TracingUtils.ensureBaggage(null, tracesSamplingDecision);
    }

    public TransactionContext(SentryId sentryId, SpanId spanId, SpanId spanId2, TracesSamplingDecision tracesSamplingDecision, Baggage baggage) {
        super(sentryId, spanId, "default", spanId2, null);
        this.isForNextAppStart = false;
        this.name = "<unlabeled transaction>";
        this.parentSamplingDecision = tracesSamplingDecision;
        this.transactionNameSource = DEFAULT_NAME_SOURCE;
        this.baggage = TracingUtils.ensureBaggage(baggage, tracesSamplingDecision);
    }

    public String getName() {
        return this.name;
    }

    public TracesSamplingDecision getParentSamplingDecision() {
        return this.parentSamplingDecision;
    }

    public TransactionNameSource getTransactionNameSource() {
        return this.transactionNameSource;
    }

    public void setForNextAppStart(boolean z) {
        this.isForNextAppStart = z;
    }
}
