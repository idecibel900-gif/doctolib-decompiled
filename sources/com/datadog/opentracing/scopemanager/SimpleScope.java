package com.datadog.opentracing.scopemanager;

import com.datadog.legacy.trace.context.ScopeListener;
import io.opentracing.Span;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleScope implements DDScope {
    private final int depth;
    private final boolean finishOnClose;
    private final ContextualScopeManager scopeManager;
    private final Span spanUnderScope;
    private final DDScope toRestore;

    public SimpleScope(ContextualScopeManager contextualScopeManager, Span span, boolean z) {
        this.scopeManager = contextualScopeManager;
        this.spanUnderScope = span;
        this.finishOnClose = z;
        ThreadLocal threadLocal = ContextualScopeManager.tlsScope;
        DDScope dDScope = (DDScope) threadLocal.get();
        this.toRestore = dDScope;
        threadLocal.set(this);
        this.depth = dDScope == null ? 0 : dDScope.depth() + 1;
        Iterator it = contextualScopeManager.scopeListeners.iterator();
        while (it.hasNext()) {
            ((ScopeListener) it.next()).afterScopeActivated();
        }
    }

    @Override // io.opentracing.Scope, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.finishOnClose) {
            this.spanUnderScope.finish();
        }
        Iterator it = this.scopeManager.scopeListeners.iterator();
        while (it.hasNext()) {
            ((ScopeListener) it.next()).afterScopeClosed();
        }
        ThreadLocal threadLocal = ContextualScopeManager.tlsScope;
        if (threadLocal.get() == this) {
            threadLocal.set(this.toRestore);
            if (this.toRestore != null) {
                Iterator it2 = this.scopeManager.scopeListeners.iterator();
                while (it2.hasNext()) {
                    ((ScopeListener) it2.next()).afterScopeActivated();
                }
            }
        }
    }

    @Override // com.datadog.opentracing.scopemanager.DDScope
    public Span span() {
        return this.spanUnderScope;
    }

    @Override // com.datadog.opentracing.scopemanager.DDScope
    public int depth() {
        return this.depth;
    }
}
