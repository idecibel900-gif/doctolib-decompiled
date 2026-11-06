package com.datadog.opentracing.scopemanager;

import com.datadog.legacy.trace.context.ScopeListener;
import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.jfr.DDScopeEvent;
import com.datadog.opentracing.jfr.DDScopeEventFactory;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class ContinuableScope implements DDScope, Closeable {
    private final int depth;
    private final DDScopeEvent event;
    private final DDScopeEventFactory eventFactory;
    private final boolean finishOnClose;
    private final AtomicBoolean isAsyncPropagating;
    private final AtomicInteger openCount;
    private final ContextualScopeManager scopeManager;
    private final DDSpan spanUnderScope;
    private final DDScope toRestore;

    public class Continuation implements Closeable {
    }

    ContinuableScope(ContextualScopeManager contextualScopeManager, DDSpan dDSpan, boolean z, DDScopeEventFactory dDScopeEventFactory) {
        this(contextualScopeManager, new AtomicInteger(1), null, dDSpan, z, dDScopeEventFactory);
    }

    private ContinuableScope(ContextualScopeManager contextualScopeManager, AtomicInteger atomicInteger, Continuation continuation, DDSpan dDSpan, boolean z, DDScopeEventFactory dDScopeEventFactory) {
        this.isAsyncPropagating = new AtomicBoolean(false);
        this.scopeManager = contextualScopeManager;
        this.openCount = atomicInteger;
        this.spanUnderScope = dDSpan;
        this.finishOnClose = z;
        this.eventFactory = dDScopeEventFactory;
        DDScopeEvent dDScopeEventCreate = dDScopeEventFactory.create(dDSpan.context());
        this.event = dDScopeEventCreate;
        dDScopeEventCreate.start();
        ThreadLocal threadLocal = ContextualScopeManager.tlsScope;
        DDScope dDScope = (DDScope) threadLocal.get();
        this.toRestore = dDScope;
        threadLocal.set(this);
        this.depth = dDScope != null ? dDScope.depth() + 1 : 0;
        Iterator it = contextualScopeManager.scopeListeners.iterator();
        while (it.hasNext()) {
            ((ScopeListener) it.next()).afterScopeActivated();
        }
    }

    @Override // io.opentracing.Scope, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.event.finish();
        if (this.openCount.decrementAndGet() == 0 && this.finishOnClose) {
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
    public DDSpan span() {
        return this.spanUnderScope;
    }

    @Override // com.datadog.opentracing.scopemanager.DDScope
    public int depth() {
        return this.depth;
    }

    public String toString() {
        return super.toString() + "->" + this.spanUnderScope;
    }
}
