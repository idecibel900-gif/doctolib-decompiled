package io.opentracing.util;

import io.opentracing.ScopeManager;
import io.opentracing.Tracer;
import io.opentracing.noop.NoopTracerFactory;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class GlobalTracer implements Tracer {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final GlobalTracer INSTANCE = new GlobalTracer();
    private static volatile Tracer tracer = NoopTracerFactory.create();
    private static volatile boolean isRegistered = false;

    private GlobalTracer() {
    }

    public static Tracer get() {
        return INSTANCE;
    }

    public static boolean isRegistered() {
        return isRegistered;
    }

    public static synchronized boolean registerIfAbsent(Callable callable) {
        requireNonNull(callable, "Cannot register GlobalTracer from provider <null>.");
        if (!isRegistered()) {
            try {
                try {
                    Tracer tracer2 = (Tracer) requireNonNull(callable.call(), "Cannot register GlobalTracer <null>.");
                    if (!(tracer2 instanceof GlobalTracer)) {
                        tracer = tracer2;
                        isRegistered = true;
                        return true;
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("Exception obtaining tracer from provider: " + e.getMessage(), e);
                }
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
        return false;
    }

    public static synchronized boolean registerIfAbsent(final Tracer tracer2) {
        requireNonNull(tracer2, "Cannot register GlobalTracer. Tracer is null");
        return registerIfAbsent(new Callable() { // from class: io.opentracing.util.GlobalTracer.1
            @Override // java.util.concurrent.Callable
            public Tracer call() {
                return tracer2;
            }
        });
    }

    @Override // io.opentracing.Tracer
    public ScopeManager scopeManager() {
        return tracer.scopeManager();
    }

    @Override // io.opentracing.Tracer
    public Tracer.SpanBuilder buildSpan(String str) {
        return tracer.buildSpan(str);
    }

    @Override // io.opentracing.Tracer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        tracer.close();
    }

    public String toString() {
        return GlobalTracer.class.getSimpleName() + '{' + tracer + '}';
    }

    private static Object requireNonNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
