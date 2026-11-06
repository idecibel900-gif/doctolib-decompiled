package io.opentracing.noop;

import io.opentracing.ScopeManager;
import io.opentracing.Tracer;

/* JADX INFO: loaded from: classes5.dex */
final class NoopTracerImpl implements NoopTracer {
    static final NoopTracer INSTANCE = new NoopTracerImpl();

    @Override // io.opentracing.Tracer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    NoopTracerImpl() {
    }

    @Override // io.opentracing.Tracer
    public ScopeManager scopeManager() {
        return NoopScopeManager.INSTANCE;
    }

    @Override // io.opentracing.Tracer
    public Tracer.SpanBuilder buildSpan(String str) {
        return NoopSpanBuilder.INSTANCE;
    }

    public String toString() {
        return NoopTracer.class.getSimpleName();
    }
}
