package io.opentracing.noop;

import io.opentracing.Span;

/* JADX INFO: loaded from: classes5.dex */
public interface NoopSpan extends Span {
    public static final NoopSpan INSTANCE = new NoopSpanImpl();
}
