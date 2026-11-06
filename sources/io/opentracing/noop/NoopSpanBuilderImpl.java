package io.opentracing.noop;

import io.opentracing.Span;
import io.opentracing.Tracer;

/* JADX INFO: loaded from: classes5.dex */
final class NoopSpanBuilderImpl implements NoopSpanBuilder {
    @Override // io.opentracing.Tracer.SpanBuilder
    public Tracer.SpanBuilder withStartTimestamp(long j) {
        return this;
    }

    NoopSpanBuilderImpl() {
    }

    @Override // io.opentracing.Tracer.SpanBuilder
    public Span start() {
        return startManual();
    }

    public Span startManual() {
        return NoopSpan.INSTANCE;
    }

    public String toString() {
        return NoopSpanBuilder.class.getSimpleName();
    }
}
