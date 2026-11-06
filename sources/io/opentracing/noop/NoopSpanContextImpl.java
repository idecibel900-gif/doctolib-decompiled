package io.opentracing.noop;

/* JADX INFO: loaded from: classes5.dex */
final class NoopSpanContextImpl implements NoopSpanContext {
    static final NoopSpanContextImpl INSTANCE = new NoopSpanContextImpl();

    NoopSpanContextImpl() {
    }

    @Override // io.opentracing.SpanContext
    public String toSpanId() {
        return "";
    }

    public String toString() {
        return NoopSpanContext.class.getSimpleName();
    }
}
