package com.datadog.opentracing;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.opentracing.decorators.AbstractDecorator;
import io.opentracing.SpanContext;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class DDSpanContext implements SpanContext {
    private static final Map EMPTY_METRICS = Collections.EMPTY_MAP;
    private final Map baggageItems;
    private volatile boolean errorFlag;
    private final InternalLogger internalLogger;
    private final AtomicReference metrics;
    private volatile String operationName;
    private final String origin;
    private final BigInteger parentId;
    private volatile String resourceName;
    private boolean samplingPriorityLocked;
    private volatile String serviceName;
    private final Map serviceNameMappings;
    private final BigInteger spanId;
    private volatile String spanType;
    private final Map tags;
    private final long threadId;
    private final String threadName;
    private final PendingTrace trace;
    private final BigInteger traceId;
    private final DDTracer tracer;

    public DDSpanContext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str, String str2, String str3, int i, String str4, Map map, boolean z, String str5, Map map2, PendingTrace pendingTrace, DDTracer dDTracer, Map map3, InternalLogger internalLogger) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.tags = concurrentHashMap;
        this.samplingPriorityLocked = false;
        this.metrics = new AtomicReference();
        String name = Thread.currentThread().getName();
        this.threadName = name;
        long id = Thread.currentThread().getId();
        this.threadId = id;
        this.tracer = dDTracer;
        this.trace = pendingTrace;
        this.traceId = bigInteger;
        this.spanId = bigInteger2;
        this.parentId = bigInteger3;
        if (map == null) {
            this.baggageItems = new ConcurrentHashMap(0);
        } else {
            this.baggageItems = new ConcurrentHashMap(map);
        }
        if (map2 != null) {
            concurrentHashMap.putAll(map2);
        }
        this.serviceNameMappings = map3;
        setServiceName(str);
        this.operationName = str2;
        this.resourceName = str3;
        this.errorFlag = z;
        this.spanType = str5;
        this.origin = str4;
        if (i != Integer.MIN_VALUE) {
            setSamplingPriority(i);
        }
        if (str4 != null) {
            concurrentHashMap.put("_dd.origin", str4);
        }
        concurrentHashMap.put("thread.name", name);
        concurrentHashMap.put("thread.id", Long.valueOf(id));
        this.internalLogger = internalLogger;
    }

    public BigInteger getTraceId() {
        return this.traceId;
    }

    public BigInteger getParentId() {
        return this.parentId;
    }

    public BigInteger getSpanId() {
        return this.spanId;
    }

    @Override // io.opentracing.SpanContext
    public String toSpanId() {
        return this.spanId.toString();
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        if (this.serviceNameMappings.containsKey(str)) {
            this.serviceName = (String) this.serviceNameMappings.get(str);
        } else {
            this.serviceName = str;
        }
    }

    public String getResourceName() {
        return isResourceNameSet() ? this.resourceName : this.operationName;
    }

    public boolean isResourceNameSet() {
        return (this.resourceName == null || this.resourceName.isEmpty()) ? false : true;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public boolean getErrorFlag() {
        return this.errorFlag;
    }

    public boolean setSamplingPriority(int i) {
        DDSpan rootSpan;
        if (i == Integer.MIN_VALUE) {
            this.internalLogger.log(InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.DDSpanContext$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DDSpanContext.$r8$lambda$IYHO8RicRNJjNnUWn4D25eTNu6k();
                }
            }, (Throwable) null, false, (Map) new HashMap());
            return false;
        }
        PendingTrace pendingTrace = this.trace;
        if (pendingTrace != null && (rootSpan = pendingTrace.getRootSpan()) != null && rootSpan.context() != this) {
            return rootSpan.context().setSamplingPriority(i);
        }
        synchronized (this) {
            try {
                if (this.samplingPriorityLocked) {
                    return false;
                }
                setMetric("_sampling_priority_v1", Integer.valueOf(i));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ String $r8$lambda$IYHO8RicRNJjNnUWn4D25eTNu6k() {
        return "Can't set sampling priority to unset";
    }

    public int getSamplingPriority() {
        DDSpan rootSpan = this.trace.getRootSpan();
        if (rootSpan != null && rootSpan.context() != this) {
            return rootSpan.context().getSamplingPriority();
        }
        Number number = (Number) getMetrics().get("_sampling_priority_v1");
        return number == null ? LinearLayoutManager.INVALID_OFFSET : number.intValue();
    }

    public Map getBaggageItems() {
        return this.baggageItems;
    }

    public PendingTrace getTrace() {
        return this.trace;
    }

    public Map getMetrics() {
        Map map = (Map) this.metrics.get();
        return map == null ? EMPTY_METRICS : map;
    }

    public void setMetric(String str, Number number) {
        if (this.metrics.get() == null) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.metrics, null, new ConcurrentHashMap());
        }
        if (number instanceof Float) {
            ((Map) this.metrics.get()).put(str, Double.valueOf(number.doubleValue()));
        } else {
            ((Map) this.metrics.get()).put(str, number);
        }
    }

    public synchronized void setTag(String str, Object obj) {
        if (obj != null) {
            try {
                if (!(obj instanceof String) || !((String) obj).isEmpty()) {
                    List spanContextDecorators = this.tracer.getSpanContextDecorators(str);
                    boolean zShouldSetTag = true;
                    if (spanContextDecorators != null) {
                        Iterator it = spanContextDecorators.iterator();
                        while (it.hasNext()) {
                            zShouldSetTag &= ((AbstractDecorator) it.next()).shouldSetTag(this, str, obj);
                        }
                    }
                    if (zShouldSetTag) {
                        this.tags.put(str, obj);
                    }
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.tags.remove(str);
    }

    public synchronized Map getTags() {
        return Collections.unmodifiableMap(this.tags);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DDSpan [ t_id=");
        sb.append(this.traceId);
        sb.append(", s_id=");
        sb.append(this.spanId);
        sb.append(", p_id=");
        sb.append(this.parentId);
        sb.append("] trace=");
        sb.append(getServiceName());
        sb.append("/");
        sb.append(getOperationName());
        sb.append("/");
        sb.append(getResourceName());
        sb.append(" metrics=");
        sb.append(new TreeMap(getMetrics()));
        if (this.errorFlag) {
            sb.append(" *errored*");
        }
        sb.append(" tags=");
        sb.append(new TreeMap(this.tags));
        return sb.toString();
    }
}
