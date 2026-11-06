package io.opentracing;

/* JADX INFO: loaded from: classes5.dex */
public interface ScopeManager {
    Scope activate(Span span);

    Span activeSpan();
}
