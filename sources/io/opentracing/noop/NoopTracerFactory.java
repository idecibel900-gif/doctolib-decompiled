package io.opentracing.noop;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NoopTracerFactory {
    public static NoopTracer create() {
        return NoopTracerImpl.INSTANCE;
    }
}
