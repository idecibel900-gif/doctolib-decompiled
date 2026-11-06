package com.datadog.opentracing;

import android.os.StrictMode;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.legacy.trace.api.Config;
import com.datadog.legacy.trace.api.interceptor.MutableSpan;
import com.datadog.legacy.trace.api.interceptor.TraceInterceptor;
import com.datadog.legacy.trace.common.sampling.PrioritySampler;
import com.datadog.legacy.trace.common.sampling.Sampler;
import com.datadog.legacy.trace.common.writer.LoggingWriter;
import com.datadog.legacy.trace.common.writer.Writer;
import com.datadog.legacy.trace.context.ScopeListener;
import com.datadog.opentracing.decorators.AbstractDecorator;
import com.datadog.opentracing.decorators.DDDecoratorsFactory;
import com.datadog.opentracing.jfr.DDNoopScopeEventFactory;
import com.datadog.opentracing.jfr.DDScopeEventFactory;
import com.datadog.opentracing.propagation.HttpCodec;
import com.datadog.opentracing.scopemanager.ContextualScopeManager;
import com.datadog.trace.api.IdGenerationStrategy;
import io.opentracing.ScopeManager;
import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DDTracer implements Tracer, Closeable {
    public static final BigInteger TRACE_ID_128_BITS_MAX;
    public static final BigInteger TRACE_ID_64_BITS_MAX;
    public static final BigInteger TRACE_ID_MIN;
    private final Map defaultSpanTags;
    private final HttpCodec.Extractor extractor;
    private final IdGenerationStrategy idGenerationStrategy;
    private final HttpCodec.Injector injector;
    private final SortedSet interceptors;
    private final Map localRootSpanTags;
    private final int partialFlushMinSpans;
    private final Random random;
    final Sampler sampler;
    final ScopeManager scopeManager;
    final String serviceName;
    private final Map serviceNameMappings;
    private final Thread shutdownCallback;
    private final Map spanContextDecorators;
    final Writer writer;

    static {
        BigInteger bigIntegerPow = BigInteger.valueOf(2L).pow(128);
        BigInteger bigInteger = BigInteger.ONE;
        TRACE_ID_128_BITS_MAX = bigIntegerPow.subtract(bigInteger);
        TRACE_ID_64_BITS_MAX = BigInteger.valueOf(2L).pow(64).subtract(bigInteger);
        TRACE_ID_MIN = BigInteger.ZERO;
    }

    protected DDTracer(Config config, Writer writer, Random random) {
        this(config.getServiceName(), writer, Sampler.Builder.forConfig(config), HttpCodec.createInjector(config), HttpCodec.createExtractor(config, config.getHeaderTags()), new ContextualScopeManager(Config.get().getScopeDepthLimit().intValue(), createScopeEventFactory()), random, config.getLocalRootSpanTags(), config.getMergedSpanTags(), config.getServiceMapping(), config.getHeaderTags(), config.getPartialFlushMinSpans().intValue());
    }

    private DDTracer(String str, Writer writer, Sampler sampler, HttpCodec.Injector injector, HttpCodec.Extractor extractor, ScopeManager scopeManager, Random random, Map map, Map map2, Map map3, Map map4, int i) {
        this.spanContextDecorators = new ConcurrentHashMap();
        this.interceptors = new ConcurrentSkipListSet(new Comparator() { // from class: com.datadog.opentracing.DDTracer.1
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj2);
                return compare((TraceInterceptor) null, (TraceInterceptor) null);
            }

            public int compare(TraceInterceptor traceInterceptor, TraceInterceptor traceInterceptor2) {
                return Integer.compare(traceInterceptor.priority(), traceInterceptor2.priority());
            }
        });
        this.idGenerationStrategy = IdGenerationStrategy.fromName("SECURE_RANDOM", true);
        this.random = random;
        this.serviceName = str;
        if (writer == null) {
            this.writer = new LoggingWriter();
        } else {
            this.writer = writer;
        }
        this.sampler = sampler;
        this.injector = injector;
        this.extractor = extractor;
        this.scopeManager = scopeManager;
        this.localRootSpanTags = map;
        this.defaultSpanTags = map2;
        this.serviceNameMappings = map3;
        this.partialFlushMinSpans = i;
        this.writer.start();
        ShutdownHook shutdownHook = new ShutdownHook();
        this.shutdownCallback = shutdownHook;
        try {
            Runtime.getRuntime().addShutdownHook(shutdownHook);
        } catch (IllegalStateException unused) {
        }
        Iterator it = DDDecoratorsFactory.createBuiltinDecorators().iterator();
        while (it.hasNext()) {
            addDecorator((AbstractDecorator) it.next());
        }
        registerClassLoader(ClassLoader.getSystemClassLoader());
        PendingTrace.initialize();
    }

    public void finalize() {
        try {
            Runtime.getRuntime().removeShutdownHook(this.shutdownCallback);
            this.shutdownCallback.run();
        } catch (Exception unused) {
        }
    }

    public List getSpanContextDecorators(String str) {
        return (List) this.spanContextDecorators.get(str);
    }

    public void addDecorator(AbstractDecorator abstractDecorator) {
        List arrayList = (List) this.spanContextDecorators.get(abstractDecorator.getMatchingTag());
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(abstractDecorator);
        this.spanContextDecorators.put(abstractDecorator.getMatchingTag(), arrayList);
    }

    public void registerClassLoader(ClassLoader classLoader) {
        try {
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            Iterator it = ServiceLoader.load(TraceInterceptor.class, classLoader).iterator();
            while (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                addTraceInterceptor(null);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        } catch (ServiceConfigurationError unused) {
        }
    }

    @Override // io.opentracing.Tracer
    public ScopeManager scopeManager() {
        return this.scopeManager;
    }

    public Span activeSpan() {
        return this.scopeManager.activeSpan();
    }

    void write(Collection collection) {
        ArrayList arrayList;
        if (collection.isEmpty()) {
            return;
        }
        if (this.interceptors.isEmpty()) {
            arrayList = new ArrayList(collection);
        } else {
            ArrayList<MutableSpan> arrayList2 = new ArrayList(collection);
            Iterator it = this.interceptors.iterator();
            if (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                throw null;
            }
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (MutableSpan mutableSpan : arrayList2) {
                if (mutableSpan instanceof DDSpan) {
                    arrayList3.add((DDSpan) mutableSpan);
                }
            }
            arrayList = arrayList3;
        }
        incrementTraceCount();
        if (arrayList.isEmpty()) {
            return;
        }
        DDSpan dDSpan = (DDSpan) ((DDSpan) arrayList.get(0)).getLocalRootSpan();
        setSamplingPriorityIfNecessary(dDSpan);
        if (dDSpan == null) {
            dDSpan = (DDSpan) arrayList.get(0);
        }
        if (this.sampler.sample(dDSpan)) {
            this.writer.write(arrayList);
        }
    }

    void setSamplingPriorityIfNecessary(DDSpan dDSpan) {
        if ((this.sampler instanceof PrioritySampler) && dDSpan != null && dDSpan.context().getSamplingPriority() == Integer.MIN_VALUE) {
            ((PrioritySampler) this.sampler).setSamplingPriority(dDSpan);
        }
    }

    void incrementTraceCount() {
        this.writer.incrementTraceCount();
    }

    public boolean addTraceInterceptor(TraceInterceptor traceInterceptor) {
        return this.interceptors.add(traceInterceptor);
    }

    public void addScopeListener(ScopeListener scopeListener) {
        ScopeManager scopeManager = this.scopeManager;
        if (scopeManager instanceof ContextualScopeManager) {
            ((ContextualScopeManager) scopeManager).addScopeListener(scopeListener);
        }
    }

    @Override // io.opentracing.Tracer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PendingTrace.close();
        this.writer.close();
    }

    public String toString() {
        return "DDTracer-" + Integer.toHexString(hashCode()) + "{ serviceName=" + this.serviceName + ", writer=" + this.writer + ", sampler=" + this.sampler + ", defaultSpanTags=" + this.defaultSpanTags + '}';
    }

    private static DDScopeEventFactory createScopeEventFactory() {
        try {
            return (DDScopeEventFactory) Class.forName("com.datadog.opentracing.jfr.openjdk.ScopeEventFactory").newInstance();
        } catch (ClassFormatError | NoClassDefFoundError | ReflectiveOperationException unused) {
            return new DDNoopScopeEventFactory();
        }
    }

    public class DDSpanBuilder implements Tracer.SpanBuilder {
        private boolean errorFlag;
        private final String operationName;
        private String origin;
        private SpanContext parent;
        private String resourceName;
        private final ScopeManager scopeManager;
        private String serviceName;
        private String spanType;
        private final Map tags;
        private long timestampMicro;
        private boolean ignoreScope = false;
        private LogHandler logHandler = new DefaultLogHandler();
        private InternalLogger internalLogger = InternalLogger.Companion.getUNBOUND();

        public DDSpanBuilder(String str, ScopeManager scopeManager) {
            this.tags = new LinkedHashMap(DDTracer.this.defaultSpanTags);
            this.operationName = str;
            this.scopeManager = scopeManager;
        }

        private Span startSpan() {
            return new DDSpan(this.timestampMicro, buildSpanContext(), this.logHandler, this.internalLogger);
        }

        @Override // io.opentracing.Tracer.SpanBuilder
        public Span start() {
            return startSpan();
        }

        public DDSpanBuilder withTag(String str, String str2) {
            return withTag(str, (Object) str2);
        }

        @Override // io.opentracing.Tracer.SpanBuilder
        public DDSpanBuilder withStartTimestamp(long j) {
            this.timestampMicro = j;
            return this;
        }

        public DDSpanBuilder withLogHandler(LogHandler logHandler) {
            if (logHandler != null) {
                this.logHandler = logHandler;
            }
            return this;
        }

        public DDSpanBuilder withInternalLogger(InternalLogger internalLogger) {
            if (internalLogger != null) {
                this.internalLogger = internalLogger;
            }
            return this;
        }

        private DDSpanBuilder withTag(String str, Object obj) {
            if (obj == null || ((obj instanceof String) && ((String) obj).isEmpty())) {
                this.tags.remove(str);
                return this;
            }
            this.tags.put(str, obj);
            return this;
        }

        private BigInteger generateNewSpanId() {
            StringCachingBigInteger stringCachingBigInteger;
            do {
                synchronized (DDTracer.this.random) {
                    stringCachingBigInteger = new StringCachingBigInteger(63, DDTracer.this.random);
                }
            } while (stringCachingBigInteger.signum() == 0);
            return stringCachingBigInteger;
        }

        private BigInteger generateNewTraceId() {
            BigInteger bigInteger;
            do {
                synchronized (DDTracer.this.idGenerationStrategy) {
                    bigInteger = new BigInteger(DDTracer.this.idGenerationStrategy.generateTraceId().toHexString(), 16);
                }
            } while (bigInteger.signum() == 0);
            return bigInteger;
        }

        private DDSpanContext buildSpanContext() {
            BigInteger bigIntegerGenerateNewTraceId;
            BigInteger spanId;
            PendingTrace pendingTrace;
            String str;
            Map map;
            Span spanActiveSpan;
            BigInteger bigIntegerGenerateNewSpanId = generateNewSpanId();
            SpanContext spanContextContext = this.parent;
            if (spanContextContext == null && !this.ignoreScope && (spanActiveSpan = this.scopeManager.activeSpan()) != null) {
                spanContextContext = spanActiveSpan.context();
            }
            if (spanContextContext instanceof DDSpanContext) {
                DDSpanContext dDSpanContext = (DDSpanContext) spanContextContext;
                bigIntegerGenerateNewTraceId = dDSpanContext.getTraceId();
                spanId = dDSpanContext.getSpanId();
                Map baggageItems = dDSpanContext.getBaggageItems();
                pendingTrace = dDSpanContext.getTrace();
                if (this.serviceName == null) {
                    this.serviceName = dDSpanContext.getServiceName();
                }
                str = null;
                map = baggageItems;
            } else {
                bigIntegerGenerateNewTraceId = generateNewTraceId();
                spanId = BigInteger.ZERO;
                String str2 = this.origin;
                this.tags.putAll(DDTracer.this.localRootSpanTags);
                pendingTrace = new PendingTrace(DDTracer.this, bigIntegerGenerateNewTraceId, this.internalLogger);
                str = str2;
                map = null;
            }
            PendingTrace pendingTrace2 = pendingTrace;
            if (this.serviceName == null) {
                this.serviceName = DDTracer.this.serviceName;
            }
            String str3 = this.operationName;
            if (str3 == null) {
                str3 = this.resourceName;
            }
            String str4 = str3;
            BigInteger bigInteger = spanId;
            String str5 = this.serviceName;
            String str6 = this.resourceName;
            boolean z = this.errorFlag;
            String str7 = this.spanType;
            Map map2 = this.tags;
            DDTracer dDTracer = DDTracer.this;
            DDSpanContext dDSpanContext2 = new DDSpanContext(bigIntegerGenerateNewTraceId, bigIntegerGenerateNewSpanId, bigInteger, str5, str4, str6, LinearLayoutManager.INVALID_OFFSET, str, map, z, str7, map2, pendingTrace2, dDTracer, dDTracer.serviceNameMappings, this.internalLogger);
            for (Map.Entry entry : this.tags.entrySet()) {
                if (entry.getValue() == null) {
                    dDSpanContext2.setTag((String) entry.getKey(), null);
                } else {
                    List spanContextDecorators = DDTracer.this.getSpanContextDecorators((String) entry.getKey());
                    boolean zShouldSetTag = true;
                    if (spanContextDecorators != null) {
                        Iterator it = spanContextDecorators.iterator();
                        while (it.hasNext()) {
                            try {
                                zShouldSetTag &= ((AbstractDecorator) it.next()).shouldSetTag(dDSpanContext2, (String) entry.getKey(), entry.getValue());
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if (!zShouldSetTag) {
                        dDSpanContext2.setTag((String) entry.getKey(), null);
                    }
                }
            }
            return dDSpanContext2;
        }
    }

    private static class ShutdownHook extends Thread {
        private final WeakReference reference;

        private ShutdownHook(DDTracer dDTracer) {
            super("dd-tracer-shutdown-hook");
            this.reference = new WeakReference(dDTracer);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            DDTracer dDTracer = (DDTracer) this.reference.get();
            if (dDTracer != null) {
                dDTracer.close();
            }
        }
    }

    public int getPartialFlushMinSpans() {
        return this.partialFlushMinSpans;
    }
}
