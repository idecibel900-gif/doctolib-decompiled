package io.opentracing;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface Tracer extends Closeable {

    public interface SpanBuilder {
        Span start();

        SpanBuilder withStartTimestamp(long j);
    }

    SpanBuilder buildSpan(String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScopeManager scopeManager();
}
