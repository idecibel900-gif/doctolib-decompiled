package io.sentry.android.core;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.ISentryExecutorService;
import io.sentry.ISentryLifecycleToken;
import io.sentry.PerformanceCollectionData;
import io.sentry.SentryLevel;
import io.sentry.SentryNanotimeDate;
import io.sentry.SentryUUID;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class AndroidProfiler {
    private final SentryFrameMetricsCollector frameMetricsCollector;
    private String frameMetricsCollectorId;
    private final int intervalUs;
    private final ILogger logger;
    private final LazyEvaluator.Evaluator timeoutExecutorServiceSupplier;
    private final File traceFilesDir;
    private long profileStartNanos = 0;
    private Future scheduledFinish = null;
    private File traceFile = null;
    private final ArrayDeque screenFrameRateMeasurements = new ArrayDeque();
    private final ArrayDeque slowFrameRenderMeasurements = new ArrayDeque();
    private final ArrayDeque frozenFrameRenderMeasurements = new ArrayDeque();
    private final Map measurementsMap = new HashMap();
    private volatile boolean isRunning = false;
    protected final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();

    public static class ProfileStartData {
        public final long startCpuMillis;
        public final long startNanos;
        public final Date startTimestamp;

        public ProfileStartData(long j, long j2, Date date) {
            this.startNanos = j;
            this.startCpuMillis = j2;
            this.startTimestamp = date;
        }
    }

    public static class ProfileEndData {
        public final boolean didTimeout;
        public final long endCpuMillis;
        public final long endNanos;
        public final Map measurementsMap;
        public final File traceFile;

        public ProfileEndData(long j, long j2, boolean z, File file, Map map) {
            this.endNanos = j;
            this.traceFile = file;
            this.endCpuMillis = j2;
            this.measurementsMap = map;
            this.didTimeout = z;
        }
    }

    public AndroidProfiler(String str, int i, SentryFrameMetricsCollector sentryFrameMetricsCollector, LazyEvaluator.Evaluator evaluator, ILogger iLogger) {
        this.traceFilesDir = new File((String) Objects.requireNonNull(str, "TracesFilesDirPath is required"));
        this.intervalUs = i;
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required");
        this.timeoutExecutorServiceSupplier = evaluator;
        this.frameMetricsCollector = (SentryFrameMetricsCollector) Objects.requireNonNull(sentryFrameMetricsCollector, "SentryFrameMetricsCollector is required");
    }

    public ProfileStartData start() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            int i = this.intervalUs;
            if (i == 0) {
                this.logger.log(SentryLevel.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i));
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return null;
            }
            if (this.isRunning) {
                this.logger.log(SentryLevel.WARNING, "Profiling has already started...", new Object[0]);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return null;
            }
            this.traceFile = new File(this.traceFilesDir, SentryUUID.generateSentryId() + ".trace");
            this.measurementsMap.clear();
            this.screenFrameRateMeasurements.clear();
            this.slowFrameRenderMeasurements.clear();
            this.frozenFrameRenderMeasurements.clear();
            this.frameMetricsCollectorId = this.frameMetricsCollector.startCollection(new SentryFrameMetricsCollector.FrameMetricsCollectorListener() { // from class: io.sentry.android.core.AndroidProfiler.1
                float lastRefreshRate = 0.0f;

                @Override // io.sentry.android.core.internal.util.SentryFrameMetricsCollector.FrameMetricsCollectorListener
                public void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
                    long jNanoTimestamp = new SentryNanotimeDate().nanoTimestamp();
                    long jNanoTime = ((j2 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - AndroidProfiler.this.profileStartNanos;
                    if (jNanoTime < 0) {
                        return;
                    }
                    if (z2) {
                        AndroidProfiler.this.frozenFrameRenderMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(jNanoTime), Long.valueOf(j3), jNanoTimestamp));
                    } else if (z) {
                        AndroidProfiler.this.slowFrameRenderMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(jNanoTime), Long.valueOf(j3), jNanoTimestamp));
                    }
                    if (f != this.lastRefreshRate) {
                        this.lastRefreshRate = f;
                        AndroidProfiler.this.screenFrameRateMeasurements.addLast(new ProfileMeasurementValue(Long.valueOf(jNanoTime), Float.valueOf(f), jNanoTimestamp));
                    }
                }
            });
            try {
                LazyEvaluator.Evaluator evaluator = this.timeoutExecutorServiceSupplier;
                if (evaluator != null) {
                    this.scheduledFinish = ((ISentryExecutorService) evaluator.evaluate()).schedule(new Runnable() { // from class: io.sentry.android.core.AndroidProfiler$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.endAndCollect(true, null);
                        }
                    }, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS);
                }
            } catch (RejectedExecutionException e) {
                this.logger.log(SentryLevel.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e);
            }
            this.profileStartNanos = SystemClock.elapsedRealtimeNanos();
            Date currentDateTime = DateUtils.getCurrentDateTime();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            try {
                Debug.startMethodTracingSampling(this.traceFile.getPath(), 3000000, this.intervalUs);
                this.isRunning = true;
                ProfileStartData profileStartData = new ProfileStartData(this.profileStartNanos, elapsedCpuTime, currentDateTime);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return profileStartData;
            } catch (Throwable th) {
                endAndCollect(false, null);
                this.logger.log(SentryLevel.ERROR, "Unable to start a profile: ", th);
                this.isRunning = false;
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return null;
            }
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire == null) {
                throw th2;
            }
            try {
                iSentryLifecycleTokenAcquire.close();
                throw th2;
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
                throw th2;
            }
        }
    }

    public ProfileEndData endAndCollect(boolean z, List list) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.isRunning) {
                this.logger.log(SentryLevel.WARNING, "Profiler not running", new Object[0]);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return null;
            }
            try {
                Debug.stopMethodTracing();
            } catch (Throwable th) {
                try {
                    this.logger.log(SentryLevel.ERROR, "Error while stopping profiling: ", th);
                } catch (Throwable th2) {
                    this.isRunning = false;
                    throw th2;
                }
            }
            this.isRunning = false;
            this.frameMetricsCollector.stopCollection(this.frameMetricsCollectorId);
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            if (this.traceFile == null) {
                this.logger.log(SentryLevel.ERROR, "Trace file does not exists", new Object[0]);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return null;
            }
            if (!this.slowFrameRenderMeasurements.isEmpty()) {
                this.measurementsMap.put("slow_frame_renders", new ProfileMeasurement("nanosecond", this.slowFrameRenderMeasurements));
            }
            if (!this.frozenFrameRenderMeasurements.isEmpty()) {
                this.measurementsMap.put("frozen_frame_renders", new ProfileMeasurement("nanosecond", this.frozenFrameRenderMeasurements));
            }
            if (!this.screenFrameRateMeasurements.isEmpty()) {
                this.measurementsMap.put("screen_frame_rates", new ProfileMeasurement("hz", this.screenFrameRateMeasurements));
            }
            putPerformanceCollectionDataInMeasurements(list);
            Future future = this.scheduledFinish;
            if (future != null) {
                future.cancel(true);
                this.scheduledFinish = null;
            }
            ProfileEndData profileEndData = new ProfileEndData(jElapsedRealtimeNanos, elapsedCpuTime, z, this.traceFile, this.measurementsMap);
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return profileEndData;
        } catch (Throwable th3) {
            if (iSentryLifecycleTokenAcquire == null) {
                throw th3;
            }
            try {
                iSentryLifecycleTokenAcquire.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public void close() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Future future = this.scheduledFinish;
            if (future != null) {
                future.cancel(true);
                this.scheduledFinish = null;
            }
            if (this.isRunning) {
                endAndCollect(true, null);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void putPerformanceCollectionDataInMeasurements(List list) {
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.profileStartNanos) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            synchronized (list) {
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        PerformanceCollectionData performanceCollectionData = (PerformanceCollectionData) it.next();
                        long nanoTimestamp = performanceCollectionData.getNanoTimestamp();
                        long j = nanoTimestamp + jElapsedRealtimeNanos;
                        Double cpuUsagePercentage = performanceCollectionData.getCpuUsagePercentage();
                        Long usedHeapMemory = performanceCollectionData.getUsedHeapMemory();
                        Long usedNativeMemory = performanceCollectionData.getUsedNativeMemory();
                        if (cpuUsagePercentage != null) {
                            arrayDeque3.add(new ProfileMeasurementValue(Long.valueOf(j), cpuUsagePercentage, nanoTimestamp));
                        }
                        if (usedHeapMemory != null) {
                            arrayDeque.add(new ProfileMeasurementValue(Long.valueOf(j), usedHeapMemory, nanoTimestamp));
                        }
                        if (usedNativeMemory != null) {
                            arrayDeque2.add(new ProfileMeasurementValue(Long.valueOf(j), usedNativeMemory, nanoTimestamp));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.measurementsMap.put("cpu_usage", new ProfileMeasurement("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.measurementsMap.put("memory_footprint", new ProfileMeasurement("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.measurementsMap.put("memory_native_footprint", new ProfileMeasurement("byte", arrayDeque2));
        }
    }

    boolean isRunning() {
        return this.isRunning;
    }
}
