package io.sentry;

import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpTransaction implements ITransaction {
    private static final NoOpTransaction instance = new NoOpTransaction();

    @Override // io.sentry.ISpan
    public void finish() {
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus) {
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
    }

    @Override // io.sentry.ITransaction
    public void forceFinish(SpanStatus spanStatus, boolean z, Hint hint) {
    }

    @Override // io.sentry.ISpan
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.ITransaction
    public ISpan getLatestActiveSpan() {
        return null;
    }

    @Override // io.sentry.ISpan
    public SpanStatus getStatus() {
        return null;
    }

    @Override // io.sentry.ISpan
    public boolean isFinished() {
        return true;
    }

    @Override // io.sentry.ISpan
    public Boolean isSampled() {
        return null;
    }

    @Override // io.sentry.ITransaction
    public void scheduleFinish() {
    }

    @Override // io.sentry.ISpan
    public void setData(String str, Object obj) {
    }

    @Override // io.sentry.ISpan
    public void setDescription(String str) {
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(String str, Number number) {
    }

    @Override // io.sentry.ISpan
    public void setMeasurement(String str, Number number, MeasurementUnit measurementUnit) {
    }

    private NoOpTransaction() {
    }

    public static NoOpTransaction getInstance() {
        return instance;
    }

    @Override // io.sentry.ITransaction
    public String getName() {
        return "";
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter, SpanOptions spanOptions) {
        return NoOpSpan.getInstance();
    }

    @Override // io.sentry.ITransaction
    public SentryId getEventId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.ISpan
    public ISentryLifecycleToken makeCurrent() {
        return NoOpScopesLifecycleToken.getInstance();
    }

    @Override // io.sentry.ISpan
    public TraceContext traceContext() {
        return new TraceContext(SentryId.EMPTY_ID, "");
    }

    @Override // io.sentry.ISpan
    public SpanContext getSpanContext() {
        return new SpanContext(SentryId.EMPTY_ID, SpanId.EMPTY_ID, "op", null, null);
    }

    @Override // io.sentry.ISpan
    public SentryDate getStartDate() {
        return new SentryNanotimeDate();
    }

    @Override // io.sentry.ISpan
    public SentryDate getFinishDate() {
        return new SentryNanotimeDate();
    }
}
