package io.opentracing.noop;

import io.opentracing.SpanContext;

/* JADX INFO: loaded from: classes5.dex */
final class NoopSpanImpl implements NoopSpan {
    @Override // io.opentracing.Span
    public void finish() {
    }

    @Override // io.opentracing.Span
    public void finish(long j) {
    }

    @Override // io.opentracing.Span
    public NoopSpan setTag(String str, Number number) {
        return this;
    }

    @Override // io.opentracing.Span
    public NoopSpan setTag(String str, String str2) {
        return this;
    }

    @Override // io.opentracing.Span
    public NoopSpan setTag(String str, boolean z) {
        return this;
    }

    NoopSpanImpl() {
    }

    @Override // io.opentracing.Span
    public SpanContext context() {
        return NoopSpanContextImpl.INSTANCE;
    }

    public String toString() {
        return NoopSpan.class.getSimpleName();
    }
}
