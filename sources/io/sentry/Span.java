package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class Span implements ISpan {
    private final SpanContext context;
    private final SpanOptions options;
    private final IScopes scopes;
    private SpanFinishedCallback spanFinishedCallback;
    private SentryDate startTimestamp;
    private Throwable throwable;
    private SentryDate timestamp;
    private final SentryTracer transaction;
    private boolean finished = false;
    private final AtomicBoolean isFinishing = new AtomicBoolean(false);
    private final Map data = new ConcurrentHashMap();
    private final Map measurements = new ConcurrentHashMap();
    private final Contexts contexts = new Contexts();

    Span(SentryTracer sentryTracer, IScopes iScopes, SpanContext spanContext, SpanOptions spanOptions, SpanFinishedCallback spanFinishedCallback) {
        this.context = spanContext;
        spanContext.setOrigin(spanOptions.getOrigin());
        this.transaction = (SentryTracer) Objects.requireNonNull(sentryTracer, "transaction is required");
        this.scopes = (IScopes) Objects.requireNonNull(iScopes, "Scopes are required");
        this.options = spanOptions;
        this.spanFinishedCallback = spanFinishedCallback;
        SentryDate startTimestamp = spanOptions.getStartTimestamp();
        if (startTimestamp != null) {
            this.startTimestamp = startTimestamp;
        } else {
            this.startTimestamp = iScopes.getOptions().getDateProvider().now();
        }
    }

    public Span(TransactionContext transactionContext, SentryTracer sentryTracer, IScopes iScopes, SpanOptions spanOptions) {
        SpanContext spanContext = (SpanContext) Objects.requireNonNull(transactionContext, "context is required");
        this.context = spanContext;
        spanContext.setOrigin(spanOptions.getOrigin());
        this.transaction = (SentryTracer) Objects.requireNonNull(sentryTracer, "sentryTracer is required");
        this.scopes = (IScopes) Objects.requireNonNull(iScopes, "scopes are required");
        this.spanFinishedCallback = null;
        SentryDate startTimestamp = spanOptions.getStartTimestamp();
        if (startTimestamp != null) {
            this.startTimestamp = startTimestamp;
        } else {
            this.startTimestamp = iScopes.getOptions().getDateProvider().now();
        }
        this.options = spanOptions;
    }

    @Override // io.sentry.ISpan
    public SentryDate getStartDate() {
        return this.startTimestamp;
    }

    @Override // io.sentry.ISpan
    public SentryDate getFinishDate() {
        return this.timestamp;
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter, SpanOptions spanOptions) {
        if (this.finished) {
            return NoOpSpan.getInstance();
        }
        return this.transaction.startChild(this.context.getSpanId(), str, str2, sentryDate, instrumenter, spanOptions);
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        return startChild(str, str2, sentryDate, instrumenter, new SpanOptions());
    }

    @Override // io.sentry.ISpan
    public void finish() {
        finish(this.context.getStatus());
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus) {
        finish(spanStatus, this.scopes.getOptions().getDateProvider().now());
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
        List<Span> directChildren;
        SentryDate sentryDate2;
        if (this.finished || !this.isFinishing.compareAndSet(false, true)) {
            return;
        }
        this.context.setStatus(spanStatus);
        if (sentryDate == null) {
            sentryDate = this.scopes.getOptions().getDateProvider().now();
        }
        this.timestamp = sentryDate;
        if (this.options.isTrimStart() || this.options.isTrimEnd()) {
            if (this.transaction.getRoot().getSpanId().equals(getSpanId())) {
                directChildren = this.transaction.getChildren();
            } else {
                directChildren = getDirectChildren();
            }
            SentryDate startDate = null;
            SentryDate finishDate = null;
            for (Span span : directChildren) {
                if (startDate == null || span.getStartDate().isBefore(startDate)) {
                    startDate = span.getStartDate();
                }
                if (finishDate == null || (span.getFinishDate() != null && span.getFinishDate().isAfter(finishDate))) {
                    finishDate = span.getFinishDate();
                }
            }
            if (this.options.isTrimStart() && startDate != null && this.startTimestamp.isBefore(startDate)) {
                updateStartDate(startDate);
            }
            if (this.options.isTrimEnd() && finishDate != null && ((sentryDate2 = this.timestamp) == null || sentryDate2.isAfter(finishDate))) {
                updateEndDate(finishDate);
            }
        }
        Throwable th = this.throwable;
        if (th != null) {
            this.scopes.setSpanContext(th, this, this.transaction.getName());
        }
        SpanFinishedCallback spanFinishedCallback = this.spanFinishedCallback;
        if (spanFinishedCallback != null) {
            spanFinishedCallback.execute(this);
        }
        this.finished = true;
    }

    public String getOperation() {
        return this.context.getOperation();
    }

    @Override // io.sentry.ISpan
    public void setDescription(String str) {
        this.context.setDescription(str);
    }

    @Override // io.sentry.ISpan
    public String getDescription() {
        return this.context.getDescription();
    }

    @Override // io.sentry.ISpan
    public SpanStatus getStatus() {
        return this.context.getStatus();
    }

    @Override // io.sentry.ISpan
    public SpanContext getSpanContext() {
        return this.context;
    }

    @Override // io.sentry.ISpan
    public boolean isFinished() {
        return this.finished;
    }

    public Map getData() {
        return this.data;
    }

    @Override // io.sentry.ISpan
    public Boolean isSampled() {
        return this.context.getSampled();
    }

    public Boolean isProfileSampled() {
        return this.context.getProfileSampled();
    }

    public TracesSamplingDecision getSamplingDecision() {
        return this.context.getSamplingDecision();
    }

    public SentryId getTraceId() {
        return this.context.getTraceId();
    }

    public SpanId getSpanId() {
        return this.context.getSpanId();
    }

    public SpanId getParentSpanId() {
        return this.context.getParentSpanId();
    }

    public Map getTags() {
        return this.context.getTags();
    }

    @Override // io.sentry.ISpan
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

    @Override // io.sentry.ISpan
    public void setMeasurement(String str, Number number) {
        if (isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.measurements.put(str, new MeasurementValue(number, null));
        if (this.transaction.getRoot() != this) {
            this.transaction.setMeasurementFromChild(str, number);
        }
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(String str, Number number, MeasurementUnit measurementUnit) {
        if (isFinished()) {
            this.scopes.getOptions().getLogger().log(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.measurements.put(str, new MeasurementValue(number, measurementUnit.apiName()));
        if (this.transaction.getRoot() != this) {
            this.transaction.setMeasurementFromChild(str, number, measurementUnit);
        }
    }

    public Map getMeasurements() {
        return this.measurements;
    }

    public boolean updateEndDate(SentryDate sentryDate) {
        if (this.timestamp == null) {
            return false;
        }
        this.timestamp = sentryDate;
        return true;
    }

    void setSpanFinishedCallback(SpanFinishedCallback spanFinishedCallback) {
        this.spanFinishedCallback = spanFinishedCallback;
    }

    SpanFinishedCallback getSpanFinishedCallback() {
        return this.spanFinishedCallback;
    }

    private void updateStartDate(SentryDate sentryDate) {
        this.startTimestamp = sentryDate;
    }

    SpanOptions getOptions() {
        return this.options;
    }

    private List getDirectChildren() {
        ArrayList arrayList = new ArrayList();
        for (Span span : this.transaction.getSpans()) {
            if (span.getParentSpanId() != null && span.getParentSpanId().equals(getSpanId())) {
                arrayList.add(span);
            }
        }
        return arrayList;
    }
}
