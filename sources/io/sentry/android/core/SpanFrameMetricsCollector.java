package io.sentry.android.core;

import io.sentry.DateUtils;
import io.sentry.IPerformanceContinuousCollector;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ISpan;
import io.sentry.ITransaction;
import io.sentry.NoOpSpan;
import io.sentry.NoOpTransaction;
import io.sentry.SentryDate;
import io.sentry.SentryNanotimeDate;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class SpanFrameMetricsCollector implements IPerformanceContinuousCollector, SentryFrameMetricsCollector.FrameMetricsCollectorListener {
    private final boolean enabled;
    private final SentryFrameMetricsCollector frameMetricsCollector;
    private volatile String listenerId;
    private static final long ONE_SECOND_NANOS = TimeUnit.SECONDS.toNanos(1);
    private static final SentryNanotimeDate EMPTY_NANO_TIME = new SentryNanotimeDate(new Date(0), 0);
    protected final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final SortedSet runningSpans = new TreeSet(new Comparator() { // from class: io.sentry.android.core.SpanFrameMetricsCollector$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SpanFrameMetricsCollector.$r8$lambda$gbgWoah_tBIXSUVRmaN30vrsEHM((ISpan) obj, (ISpan) obj2);
        }
    });
    private final ConcurrentSkipListSet frames = new ConcurrentSkipListSet();
    private long lastKnownFrameDurationNanos = 16666666;

    public static /* synthetic */ int $r8$lambda$gbgWoah_tBIXSUVRmaN30vrsEHM(ISpan iSpan, ISpan iSpan2) {
        if (iSpan == iSpan2) {
            return 0;
        }
        int iCompareTo = iSpan.getStartDate().compareTo(iSpan2.getStartDate());
        return iCompareTo != 0 ? iCompareTo : iSpan.getSpanContext().getSpanId().toString().compareTo(iSpan2.getSpanContext().getSpanId().toString());
    }

    public SpanFrameMetricsCollector(SentryAndroidOptions sentryAndroidOptions, SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this.frameMetricsCollector = sentryFrameMetricsCollector;
        this.enabled = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    @Override // io.sentry.IPerformanceContinuousCollector
    public void onSpanStarted(ISpan iSpan) {
        if (!this.enabled || (iSpan instanceof NoOpSpan) || (iSpan instanceof NoOpTransaction)) {
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.runningSpans.add(iSpan);
            if (this.listenerId == null) {
                this.listenerId = this.frameMetricsCollector.startCollection(this);
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

    @Override // io.sentry.IPerformanceContinuousCollector
    public void onSpanFinished(ISpan iSpan) {
        if (!this.enabled || (iSpan instanceof NoOpSpan) || (iSpan instanceof NoOpTransaction)) {
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.runningSpans.contains(iSpan)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            captureFrameMetrics(iSpan);
            ISentryLifecycleToken iSentryLifecycleTokenAcquire2 = this.lock.acquire();
            try {
                if (this.runningSpans.isEmpty()) {
                    clear();
                } else {
                    this.frames.headSet(new Frame(toNanoTime(((ISpan) this.runningSpans.first()).getStartDate()))).clear();
                }
                if (iSentryLifecycleTokenAcquire2 != null) {
                    iSentryLifecycleTokenAcquire2.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire2 != null) {
                    try {
                        iSentryLifecycleTokenAcquire2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    private void captureFrameMetrics(ISpan iSpan) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.runningSpans.remove(iSpan)) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            SentryDate finishDate = iSpan.getFinishDate();
            if (finishDate == null) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            long nanoTime = toNanoTime(iSpan.getStartDate());
            long nanoTime2 = toNanoTime(finishDate);
            long j = nanoTime2 - nanoTime;
            long j2 = 0;
            if (j <= 0) {
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                    return;
                }
                return;
            }
            SentryFrameMetrics sentryFrameMetrics = new SentryFrameMetrics();
            long j3 = this.lastKnownFrameDurationNanos;
            if (!this.frames.isEmpty()) {
                for (Frame frame : this.frames.tailSet(new Frame(nanoTime))) {
                    if (frame.startNanos > nanoTime2) {
                        break;
                    }
                    if (frame.startNanos >= nanoTime && frame.endNanos <= nanoTime2) {
                        sentryFrameMetrics.addFrame(frame.durationNanos, frame.delayNanos, frame.isSlow, frame.isFrozen);
                    } else if ((nanoTime > frame.startNanos && nanoTime < frame.endNanos) || (nanoTime2 > frame.startNanos && nanoTime2 < frame.endNanos)) {
                        long jMin = Math.min(frame.delayNanos - Math.max(j2, Math.max(j2, nanoTime - frame.startNanos) - frame.expectedDurationNanos), j);
                        long jMin2 = Math.min(nanoTime2, frame.endNanos) - Math.max(nanoTime, frame.startNanos);
                        sentryFrameMetrics.addFrame(jMin2, jMin, SentryFrameMetricsCollector.isSlow(jMin2, frame.expectedDurationNanos), SentryFrameMetricsCollector.isFrozen(jMin2));
                    }
                    j3 = frame.expectedDurationNanos;
                    j2 = 0;
                }
            }
            long j4 = j3;
            int slowFrozenFrameCount = sentryFrameMetrics.getSlowFrozenFrameCount();
            long lastKnownFrameStartTimeNanos = this.frameMetricsCollector.getLastKnownFrameStartTimeNanos();
            if (lastKnownFrameStartTimeNanos != -1) {
                slowFrozenFrameCount = slowFrozenFrameCount + addPendingFrameDelay(sentryFrameMetrics, j4, nanoTime2, lastKnownFrameStartTimeNanos) + interpolateFrameCount(sentryFrameMetrics, j4, j);
            }
            double slowFrameDelayNanos = (sentryFrameMetrics.getSlowFrameDelayNanos() + sentryFrameMetrics.getFrozenFrameDelayNanos()) / 1.0E9d;
            iSpan.setData("frames.total", Integer.valueOf(slowFrozenFrameCount));
            iSpan.setData("frames.slow", Integer.valueOf(sentryFrameMetrics.getSlowFrameCount()));
            iSpan.setData("frames.frozen", Integer.valueOf(sentryFrameMetrics.getFrozenFrameCount()));
            iSpan.setData("frames.delay", Double.valueOf(slowFrameDelayNanos));
            if (iSpan instanceof ITransaction) {
                iSpan.setMeasurement("frames_total", Integer.valueOf(slowFrozenFrameCount));
                iSpan.setMeasurement("frames_slow", Integer.valueOf(sentryFrameMetrics.getSlowFrameCount()));
                iSpan.setMeasurement("frames_frozen", Integer.valueOf(sentryFrameMetrics.getFrozenFrameCount()));
                iSpan.setMeasurement("frames_delay", Double.valueOf(slowFrameDelayNanos));
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire == null) {
                throw th;
            }
            try {
                iSentryLifecycleTokenAcquire.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // io.sentry.IPerformanceContinuousCollector
    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (this.listenerId != null) {
                this.frameMetricsCollector.stopCollection(this.listenerId);
                this.listenerId = null;
            }
            this.frames.clear();
            this.runningSpans.clear();
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

    @Override // io.sentry.android.core.internal.util.SentryFrameMetricsCollector.FrameMetricsCollectorListener
    public void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        if (this.frames.size() > 3600) {
            return;
        }
        long j5 = (long) (ONE_SECOND_NANOS / ((double) f));
        this.lastKnownFrameDurationNanos = j5;
        if (z || z2) {
            this.frames.add(new Frame(j, j2, j3, j4, z, z2, j5));
        }
    }

    private static int interpolateFrameCount(SentryFrameMetrics sentryFrameMetrics, long j, long j2) {
        long totalDurationNanos = j2 - sentryFrameMetrics.getTotalDurationNanos();
        if (totalDurationNanos > 0) {
            return (int) Math.ceil(totalDurationNanos / j);
        }
        return 0;
    }

    private static int addPendingFrameDelay(SentryFrameMetrics sentryFrameMetrics, long j, long j2, long j3) {
        long jMax = Math.max(0L, j2 - j3);
        if (!SentryFrameMetricsCollector.isSlow(jMax, j)) {
            return 0;
        }
        sentryFrameMetrics.addFrame(jMax, Math.max(0L, jMax - j), true, SentryFrameMetricsCollector.isFrozen(jMax));
        return 1;
    }

    private static long toNanoTime(SentryDate sentryDate) {
        if (sentryDate instanceof SentryNanotimeDate) {
            return sentryDate.diff(EMPTY_NANO_TIME);
        }
        return System.nanoTime() - (DateUtils.millisToNanos(System.currentTimeMillis()) - sentryDate.nanoTimestamp());
    }

    private static class Frame implements Comparable {
        private final long delayNanos;
        private final long durationNanos;
        private final long endNanos;
        private final long expectedDurationNanos;
        private final boolean isFrozen;
        private final boolean isSlow;
        private final long startNanos;

        Frame(long j) {
            this(j, j, 0L, 0L, false, false, 0L);
        }

        Frame(long j, long j2, long j3, long j4, boolean z, boolean z2, long j5) {
            this.startNanos = j;
            this.endNanos = j2;
            this.durationNanos = j3;
            this.delayNanos = j4;
            this.isSlow = z;
            this.isFrozen = z2;
            this.expectedDurationNanos = j5;
        }

        @Override // java.lang.Comparable
        public int compareTo(Frame frame) {
            return Long.compare(this.endNanos, frame.endNanos);
        }
    }
}
