package com.datadog.reactnative;

import com.datadog.android.trace.AndroidTracer;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DdTraceImplementation {
    public static final Companion Companion = new Companion(null);
    private final Map scopeMap;
    private final Map spanMap;
    private final Lazy tracer$delegate;
    private final Function0 tracerProvider;

    public DdTraceImplementation(Function0 tracerProvider) {
        Intrinsics.checkNotNullParameter(tracerProvider, "tracerProvider");
        this.tracerProvider = tracerProvider;
        this.spanMap = new LinkedHashMap();
        this.scopeMap = new LinkedHashMap();
        this.tracer$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.reactnative.DdTraceImplementation$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdTraceImplementation.tracer_delegate$lambda$1(this.f$0);
            }
        });
    }

    public /* synthetic */ DdTraceImplementation(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.datadog.reactnative.DdTraceImplementation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DdTraceImplementation._init_$lambda$0();
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Tracer _init_$lambda$0() {
        GlobalTracer.registerIfAbsent(new AndroidTracer.Builder(null, 1, 0 == true ? 1 : 0).build());
        return GlobalTracer.get();
    }

    private final Tracer getTracer() {
        return (Tracer) this.tracer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tracer tracer_delegate$lambda$1(DdTraceImplementation ddTraceImplementation) {
        return (Tracer) ddTraceImplementation.tracerProvider.invoke();
    }

    public final void startSpan(String operation, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Span spanStart = getTracer().buildSpan(operation).withStartTimestamp(TimeUnit.MILLISECONDS.toMicros((long) d)).start();
        Scope scopeActivate = getTracer().scopeManager().activate(spanStart);
        SpanContext spanContextContext = spanStart.context();
        Intrinsics.checkNotNull(spanStart);
        setTags(spanStart, context.toHashMap());
        setTags(spanStart, GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release());
        String spanId = spanContextContext.toSpanId();
        this.spanMap.put(spanId, spanStart);
        this.scopeMap.put(spanId, scopeActivate);
        promise.resolve(spanId);
    }

    public final void finishSpan(String spanId, ReadableMap context, double d, Promise promise) {
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Scope scope = (Scope) this.scopeMap.remove(spanId);
        if (scope != null) {
            scope.close();
        }
        Span span = (Span) this.spanMap.remove(spanId);
        if (span == null) {
            promise.resolve(null);
            return;
        }
        setTags(span, context.toHashMap());
        setTags(span, GlobalState.INSTANCE.getGlobalAttributes$datadog_mobile_react_native_release());
        span.finish(TimeUnit.MILLISECONDS.toMicros((long) d));
        promise.resolve(null);
    }

    private final void setTags(Span span, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Boolean) {
                span.setTag(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Number) {
                span.setTag(str, (Number) value);
            } else if (value instanceof String) {
                span.setTag(str, (String) value);
            } else {
                span.setTag(str, value != null ? value.toString() : null);
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
