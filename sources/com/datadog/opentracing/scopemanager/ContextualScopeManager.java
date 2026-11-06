package com.datadog.opentracing.scopemanager;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import com.datadog.legacy.trace.context.ScopeListener;
import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.jfr.DDScopeEventFactory;
import io.opentracing.Scope;
import io.opentracing.ScopeManager;
import io.opentracing.Span;
import io.opentracing.noop.NoopScopeManager;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ContextualScopeManager implements ScopeManager {
    static final ThreadLocal tlsScope = new ThreadLocal();
    private final int depthLimit;
    private final DDScopeEventFactory scopeEventFactory;
    final Deque scopeContexts = new LinkedList();
    final List scopeListeners = new CopyOnWriteArrayList();

    public ContextualScopeManager(int i, DDScopeEventFactory dDScopeEventFactory) {
        this.depthLimit = i;
        this.scopeEventFactory = dDScopeEventFactory;
    }

    public Scope activate(Span span, boolean z) {
        Scope scopeActive = active();
        if (scopeActive instanceof DDScope) {
            if (this.depthLimit <= ((DDScope) scopeActive).depth()) {
                return NoopScopeManager.NoopScope.INSTANCE;
            }
        }
        synchronized (this.scopeContexts) {
            Iterator it = this.scopeContexts.iterator();
            if (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                throw null;
            }
        }
        if (span instanceof DDSpan) {
            return new ContinuableScope(this, (DDSpan) span, z, this.scopeEventFactory);
        }
        return new SimpleScope(this, span, z);
    }

    @Override // io.opentracing.ScopeManager
    public Scope activate(Span span) {
        return activate(span, false);
    }

    public Scope active() {
        synchronized (this.scopeContexts) {
            Iterator it = this.scopeContexts.iterator();
            if (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                throw null;
            }
        }
        return (Scope) tlsScope.get();
    }

    @Override // io.opentracing.ScopeManager
    public Span activeSpan() {
        synchronized (this.scopeContexts) {
            Iterator it = this.scopeContexts.iterator();
            if (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                throw null;
            }
        }
        DDScope dDScope = (DDScope) tlsScope.get();
        if (dDScope == null) {
            return null;
        }
        return dDScope.span();
    }

    public void addScopeListener(ScopeListener scopeListener) {
        this.scopeListeners.add(scopeListener);
    }
}
