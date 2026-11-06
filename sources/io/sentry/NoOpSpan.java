package io.sentry;

import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpSpan implements ISpan {
    private static final NoOpSpan instance = new NoOpSpan();

    @Override // io.sentry.ISpan
    public void finish() {
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus) {
    }

    @Override // io.sentry.ISpan
    public void finish(SpanStatus spanStatus, SentryDate sentryDate) {
    }

    @Override // io.sentry.ISpan
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.ISpan
    public SpanStatus getStatus() {
        return null;
    }

    @Override // io.sentry.ISpan
    public boolean isFinished() {
        return false;
    }

    @Override // io.sentry.ISpan
    public Boolean isSampled() {
        return null;
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

    private NoOpSpan() {
    }

    public static NoOpSpan getInstance() {
        return instance;
    }

    @Override // io.sentry.ISpan
    public ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter) {
        return getInstance();
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
