package com.datadog.opentracing;

import com.datadog.android.api.InternalLogger;
import com.datadog.legacy.trace.api.interceptor.MutableSpan;
import com.datadog.legacy.trace.common.util.Clock;
import io.opentracing.Span;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class DDSpan implements Span, MutableSpan {
    private final DDSpanContext context;
    private final AtomicLong durationNano = new AtomicLong();
    private final InternalLogger internalLogger;
    private final LogHandler logHandler;
    volatile WeakReference ref;
    private final long startTimeMicro;
    private final long startTimeNano;

    DDSpan(long j, DDSpanContext dDSpanContext, LogHandler logHandler, InternalLogger internalLogger) {
        this.context = dDSpanContext;
        this.logHandler = logHandler;
        this.internalLogger = internalLogger;
        if (j <= 0) {
            this.startTimeMicro = Clock.currentMicroTime();
            this.startTimeNano = dDSpanContext.getTrace().getCurrentTimeNano();
        } else {
            this.startTimeMicro = j;
            this.startTimeNano = 0L;
        }
        dDSpanContext.getTrace().registerSpan(this);
    }

    private void finishAndAddToTrace(long j) {
        if (this.durationNano.compareAndSet(0L, Math.max(1L, j))) {
            this.context.getTrace().addSpan(this);
        } else {
            this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.DDSpan$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DDSpan.$r8$lambda$0OELF72xcjKIZxsAMo9c305Gs7w(this.f$0);
                }
            }, (Throwable) null, false, (Map) new HashMap());
        }
    }

    public static /* synthetic */ String $r8$lambda$0OELF72xcjKIZxsAMo9c305Gs7w(DDSpan dDSpan) {
        dDSpan.getClass();
        return "Span " + dDSpan.getOperationName() + " finished but duration already set; dropped spanId:" + dDSpan.getSpanId() + " traceid:" + dDSpan.getTraceId();
    }

    @Override // io.opentracing.Span
    public final void finish() {
        if (this.startTimeNano > 0) {
            finishAndAddToTrace(this.context.getTrace().getCurrentTimeNano() - this.startTimeNano);
        } else {
            finish(Clock.currentMicroTime());
        }
    }

    @Override // io.opentracing.Span
    public final void finish(long j) {
        finishAndAddToTrace(TimeUnit.MICROSECONDS.toNanos(j - this.startTimeMicro));
    }

    public MutableSpan getLocalRootSpan() {
        return context().getTrace().getRootSpan();
    }

    @Override // io.opentracing.Span
    public final DDSpan setTag(String str, String str2) {
        context().setTag(str, str2);
        return this;
    }

    @Override // io.opentracing.Span
    public final DDSpan setTag(String str, boolean z) {
        context().setTag(str, Boolean.valueOf(z));
        return this;
    }

    @Override // io.opentracing.Span
    public final DDSpan setTag(String str, Number number) {
        context().setTag(str, number);
        return this;
    }

    @Override // io.opentracing.Span
    public final DDSpanContext context() {
        return this.context;
    }

    public Map getMeta() {
        HashMap map = new HashMap();
        for (Map.Entry entry : context().getBaggageItems().entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry entry2 : getTags().entrySet()) {
            map.put((String) entry2.getKey(), String.valueOf(entry2.getValue()));
        }
        return map;
    }

    public Map getMetrics() {
        return this.context.getMetrics();
    }

    public long getStartTime() {
        long j = this.startTimeNano;
        return j > 0 ? j : TimeUnit.MICROSECONDS.toNanos(this.startTimeMicro);
    }

    public long getDurationNano() {
        return this.durationNano.get();
    }

    public String getServiceName() {
        return this.context.getServiceName();
    }

    public BigInteger getTraceId() {
        return this.context.getTraceId();
    }

    public BigInteger getSpanId() {
        return this.context.getSpanId();
    }

    public BigInteger getParentId() {
        return this.context.getParentId();
    }

    public String getResourceName() {
        return this.context.getResourceName();
    }

    public String getOperationName() {
        return this.context.getOperationName();
    }

    public Integer getSamplingPriority() {
        int samplingPriority = this.context.getSamplingPriority();
        if (samplingPriority == Integer.MIN_VALUE) {
            return null;
        }
        return Integer.valueOf(samplingPriority);
    }

    public Map getTags() {
        return context().getTags();
    }

    public Boolean isError() {
        return Boolean.valueOf(this.context.getErrorFlag());
    }

    public String toString() {
        return this.context.toString() + ", duration_ns=" + this.durationNano;
    }
}
