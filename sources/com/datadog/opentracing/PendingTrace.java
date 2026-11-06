package com.datadog.opentracing;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.datadog.android.api.InternalLogger;
import com.datadog.exec.CommonTaskExecutor;
import com.datadog.legacy.trace.common.util.Clock;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class PendingTrace extends LinkedList {
    private static final AtomicReference SPAN_CLEANER = new AtomicReference();
    private final InternalLogger internalLogger;
    private final BigInteger traceId;
    private final DDTracer tracer;
    private final ReferenceQueue referenceQueue = new ReferenceQueue();
    private final Set weakReferences = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicInteger pendingReferenceCount = new AtomicInteger(0);
    private final AtomicInteger completedSpanCount = new AtomicInteger(0);
    private final AtomicReference rootSpan = new AtomicReference();
    private final AtomicBoolean isWritten = new AtomicBoolean(false);
    private final long startTimeNano = Clock.currentNanoTime();
    private final long startNanoTicks = Clock.currentNanoTicks();

    PendingTrace(DDTracer dDTracer, BigInteger bigInteger, InternalLogger internalLogger) {
        this.tracer = dDTracer;
        this.traceId = bigInteger;
        this.internalLogger = internalLogger;
        addPendingTrace();
    }

    public long getCurrentTimeNano() {
        return this.startTimeNano + Math.max(0L, Clock.currentNanoTicks() - this.startNanoTicks);
    }

    public void registerSpan(final DDSpan dDSpan) {
        if (this.traceId == null || dDSpan.context() == null) {
            this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingTrace.m3170$r8$lambda$MnGCEZHnPTBJyAMcCnQeZiEHqc(this.f$0, dDSpan);
                }
            }, (Throwable) null, false, (Map) new HashMap());
            return;
        }
        final BigInteger traceId = dDSpan.context().getTraceId();
        if (!this.traceId.equals(traceId)) {
            this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingTrace.$r8$lambda$09U6XRJi84IEPgetCqZ3bW9UOxg(this.f$0, dDSpan, traceId);
                }
            }, (Throwable) null, false, (Map) new HashMap());
            return;
        }
        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.rootSpan, null, new WeakReference(dDSpan));
        synchronized (dDSpan) {
            try {
                if (dDSpan.ref == null) {
                    dDSpan.ref = new WeakReference(dDSpan, this.referenceQueue);
                    this.weakReferences.add(dDSpan.ref);
                    this.pendingReferenceCount.incrementAndGet();
                } else {
                    this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PendingTrace.m3171$r8$lambda$U8i_woXoMcDjL5g9z1Wb3VNUzY(this.f$0, dDSpan);
                        }
                    }, (Throwable) null, false, (Map) new HashMap());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$MnGCEZH-nPTBJyAMcCnQeZiEHqc, reason: not valid java name */
    public static /* synthetic */ String m3170$r8$lambda$MnGCEZHnPTBJyAMcCnQeZiEHqc(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not registered because of null traceId or context; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public static /* synthetic */ String $r8$lambda$09U6XRJi84IEPgetCqZ3bW9UOxg(PendingTrace pendingTrace, DDSpan dDSpan, BigInteger bigInteger) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not registered because of traceId mismatch; spanId:" + dDSpan.getSpanId() + " span.traceid:" + bigInteger + " traceid:" + pendingTrace.traceId;
    }

    /* JADX INFO: renamed from: $r8$lambda$U8i_woXoMcDjL5-g9z1Wb3VNUzY, reason: not valid java name */
    public static /* synthetic */ String m3171$r8$lambda$U8i_woXoMcDjL5g9z1Wb3VNUzY(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not registered because it is already registered; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    private void expireSpan(final DDSpan dDSpan, boolean z) {
        if (this.traceId == null || dDSpan.context() == null) {
            this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingTrace.$r8$lambda$fuClFLHc0vaHZG9e70oHnk7Dwgs(this.f$0, dDSpan);
                }
            }, (Throwable) null, false, (Map) new HashMap());
            return;
        }
        final BigInteger traceId = dDSpan.context().getTraceId();
        if (!this.traceId.equals(traceId)) {
            this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingTrace.$r8$lambda$YL3imA9UqsTUT85mGdPH3LZlr5M(this.f$0, dDSpan, traceId);
                }
            }, (Throwable) null, false, (Map) new HashMap());
            return;
        }
        synchronized (dDSpan) {
            try {
                if (dDSpan.ref == null) {
                    this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PendingTrace.m3169$r8$lambda$9NPR6kJaGYM06a_ex3jkfdhsAU(this.f$0, dDSpan);
                        }
                    }, (Throwable) null, false, (Map) new HashMap());
                    return;
                }
                this.weakReferences.remove(dDSpan.ref);
                dDSpan.ref.clear();
                dDSpan.ref = null;
                if (z) {
                    expireReference();
                } else {
                    this.pendingReferenceCount.decrementAndGet();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ String $r8$lambda$fuClFLHc0vaHZG9e70oHnk7Dwgs(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not expired because of null traceId or context; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public static /* synthetic */ String $r8$lambda$YL3imA9UqsTUT85mGdPH3LZlr5M(PendingTrace pendingTrace, DDSpan dDSpan, BigInteger bigInteger) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not expired because of traceId mismatch; spanId:" + dDSpan.getSpanId() + " span.traceid:" + bigInteger + " traceid:" + pendingTrace.traceId;
    }

    /* JADX INFO: renamed from: $r8$lambda$9NPR6kJaGYM06a_ex3-jkfdhsAU, reason: not valid java name */
    public static /* synthetic */ String m3169$r8$lambda$9NPR6kJaGYM06a_ex3jkfdhsAU(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not expired because it's not registered; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public void addSpan(final DDSpan dDSpan) {
        synchronized (this) {
            try {
                if (dDSpan.getDurationNano() == 0) {
                    this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PendingTrace.m3172$r8$lambda$nSh5YtZducbZNJpIVjSe4bpVBg(this.f$0, dDSpan);
                        }
                    }, (Throwable) null, false, (Map) new HashMap());
                    return;
                }
                if (this.traceId != null && dDSpan.context() != null) {
                    if (!this.traceId.equals(dDSpan.getTraceId())) {
                        this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PendingTrace.$r8$lambda$jeT4Vk4CL07M0SbWa2e1fh88HKA(this.f$0, dDSpan);
                            }
                        }, (Throwable) null, false, (Map) new HashMap());
                        return;
                    }
                    if (!this.isWritten.get()) {
                        addFirst(dDSpan);
                    } else {
                        this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PendingTrace.$r8$lambda$fE_HwpiZyBP3ZiPs6Jk299MFV8M(this.f$0, dDSpan);
                            }
                        }, (Throwable) null, false, (Map) new HashMap());
                    }
                    expireSpan(dDSpan, true);
                    return;
                }
                this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PendingTrace.$r8$lambda$QfdL_DhfoDrcUdtpE2c7mArSgLo(this.f$0, dDSpan);
                    }
                }, (Throwable) null, false, (Map) new HashMap());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$nSh5YtZducbZNJp-IVjSe4bpVBg, reason: not valid java name */
    public static /* synthetic */ String m3172$r8$lambda$nSh5YtZducbZNJpIVjSe4bpVBg(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not added because duration is zero; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public static /* synthetic */ String $r8$lambda$QfdL_DhfoDrcUdtpE2c7mArSgLo(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not added because of null traceId or context; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public static /* synthetic */ String $r8$lambda$jeT4Vk4CL07M0SbWa2e1fh88HKA(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not added because of traceId mismatch; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public static /* synthetic */ String $r8$lambda$fE_HwpiZyBP3ZiPs6Jk299MFV8M(PendingTrace pendingTrace, DDSpan dDSpan) {
        pendingTrace.getClass();
        return "Span " + dDSpan.getOperationName() + " not added because trace already written; spanId:" + dDSpan.getSpanId() + " traceid:" + pendingTrace.traceId;
    }

    public DDSpan getRootSpan() {
        WeakReference weakReference = (WeakReference) this.rootSpan.get();
        if (weakReference == null) {
            return null;
        }
        return (DDSpan) weakReference.get();
    }

    private void expireReference() {
        if (this.pendingReferenceCount.decrementAndGet() == 0) {
            write();
            return;
        }
        if (this.tracer.getPartialFlushMinSpans() <= 0 || size() <= this.tracer.getPartialFlushMinSpans()) {
            return;
        }
        synchronized (this) {
            try {
                if (size() > this.tracer.getPartialFlushMinSpans()) {
                    DDSpan rootSpan = getRootSpan();
                    ArrayList arrayList = new ArrayList(size());
                    Iterator<E> it = iterator();
                    while (it.hasNext()) {
                        DDSpan dDSpan = (DDSpan) it.next();
                        if (dDSpan != rootSpan) {
                            arrayList.add(dDSpan);
                            this.completedSpanCount.decrementAndGet();
                            it.remove();
                        }
                    }
                    this.tracer.write(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void write() {
        try {
            if (this.isWritten.compareAndSet(false, true)) {
                removePendingTrace();
                if (!isEmpty()) {
                    this.tracer.write(this);
                }
            } else {
                this.internalLogger.log(InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.opentracing.PendingTrace$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PendingTrace.$r8$lambda$XAbGFQD2Dm0k6muPQfFUoezDUfg(this.f$0);
                    }
                }, (Throwable) null, false, (Map) new HashMap());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ String $r8$lambda$XAbGFQD2Dm0k6muPQfFUoezDUfg(PendingTrace pendingTrace) {
        pendingTrace.getClass();
        return "Trace " + pendingTrace.traceId + " write ignored: isWritten already true";
    }

    public synchronized boolean clean() {
        int i;
        i = 0;
        while (true) {
            try {
                Reference referencePoll = this.referenceQueue.poll();
                if (referencePoll == null) {
                    break;
                }
                this.weakReferences.remove(referencePoll);
                if (this.isWritten.compareAndSet(false, true)) {
                    removePendingTrace();
                    this.tracer.incrementTraceCount();
                }
                i++;
                expireReference();
            } catch (Throwable th) {
                throw th;
            }
        }
        return i > 0;
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addFirst(DDSpan dDSpan) {
        synchronized (this) {
            super.add(0, dDSpan);
        }
        this.completedSpanCount.incrementAndGet();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public int size() {
        return this.completedSpanCount.get();
    }

    private void addPendingTrace() {
        SpanCleaner spanCleaner = (SpanCleaner) SPAN_CLEANER.get();
        if (spanCleaner != null) {
            spanCleaner.addPendingTrace(this);
        }
    }

    private void removePendingTrace() {
        SpanCleaner spanCleaner = (SpanCleaner) SPAN_CLEANER.get();
        if (spanCleaner != null) {
            spanCleaner.removePendingTrace(this);
        }
    }

    static void initialize() {
        SpanCleaner spanCleaner = (SpanCleaner) SPAN_CLEANER.getAndSet(new SpanCleaner());
        if (spanCleaner != null) {
            spanCleaner.close();
        }
    }

    static void close() {
        SpanCleaner spanCleaner = (SpanCleaner) SPAN_CLEANER.getAndSet(null);
        if (spanCleaner != null) {
            spanCleaner.close();
        }
    }

    static class SpanCleaner implements Runnable, Closeable {
        private final Map pendingTraces = new ConcurrentHashMap();

        public SpanCleaner() {
            CommonTaskExecutor.INSTANCE.scheduleAtFixedRate(SpanCleanerTask.INSTANCE, this, 0L, 1L, TimeUnit.SECONDS, "Pending trace cleaner");
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.pendingTraces.values().iterator();
            while (it.hasNext()) {
                ((PendingTrace) it.next()).clean();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            run();
        }

        public void addPendingTrace(PendingTrace pendingTrace) {
            this.pendingTraces.put(new IdentityKey(pendingTrace), pendingTrace);
        }

        public void removePendingTrace(PendingTrace pendingTrace) {
            this.pendingTraces.remove(new IdentityKey(pendingTrace));
        }
    }

    static class IdentityKey {
        private final PendingTrace key;

        IdentityKey(PendingTrace pendingTrace) {
            this.key = pendingTrace;
        }

        public boolean equals(Object obj) {
            return (obj instanceof IdentityKey) && ((IdentityKey) obj).key == this.key;
        }

        public int hashCode() {
            return System.identityHashCode(this.key);
        }
    }

    private static class SpanCleanerTask implements CommonTaskExecutor.Task {
        static final SpanCleanerTask INSTANCE = new SpanCleanerTask();

        private SpanCleanerTask() {
        }

        @Override // com.datadog.exec.CommonTaskExecutor.Task
        public void run(SpanCleaner spanCleaner) {
            spanCleaner.run();
        }
    }
}
