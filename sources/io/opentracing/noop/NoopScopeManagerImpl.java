package io.opentracing.noop;

import io.opentracing.Scope;
import io.opentracing.Span;

/* JADX INFO: loaded from: classes5.dex */
class NoopScopeManagerImpl implements NoopScopeManager {
    NoopScopeManagerImpl() {
    }

    @Override // io.opentracing.ScopeManager
    public Scope activate(Span span) {
        return NoopScopeManager.NoopScope.INSTANCE;
    }

    @Override // io.opentracing.ScopeManager
    public Span activeSpan() {
        return NoopSpan.INSTANCE;
    }

    static class NoopScopeImpl implements NoopScopeManager.NoopScope {
        @Override // io.opentracing.Scope, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        NoopScopeImpl() {
        }
    }
}
