package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public interface ISpan {
    void finish();

    void finish(SpanStatus spanStatus);

    void finish(SpanStatus spanStatus, SentryDate sentryDate);

    String getDescription();

    SentryDate getFinishDate();

    SpanContext getSpanContext();

    SentryDate getStartDate();

    SpanStatus getStatus();

    boolean isFinished();

    Boolean isSampled();

    ISentryLifecycleToken makeCurrent();

    void setData(String str, Object obj);

    void setDescription(String str);

    void setMeasurement(String str, Number number);

    void setMeasurement(String str, Number number, MeasurementUnit measurementUnit);

    ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter);

    ISpan startChild(String str, String str2, SentryDate sentryDate, Instrumenter instrumenter, SpanOptions spanOptions);

    TraceContext traceContext();
}
