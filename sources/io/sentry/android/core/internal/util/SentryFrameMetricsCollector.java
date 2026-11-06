package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryUUID;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.SentryFramesDelayResult;
import io.sentry.util.Objects;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryFrameMetricsCollector implements Application.ActivityLifecycleCallbacks {
    private final BuildInfoProvider buildInfoProvider;
    private Choreographer choreographer;
    private Field choreographerLastFrameTimeField;
    private WeakReference currentWindow;
    private final ConcurrentSkipListSet delayedFrames;
    private Window.OnFrameMetricsAvailableListener frameMetricsAvailableListener;
    private Handler handler;
    private boolean isAvailable;
    private long lastFrameEndNanos;
    private long lastFrameStartNanos;
    private final Map listenerMap;
    private final ILogger logger;
    private final Set trackedWindows;
    private final WindowFrameMetricsManager windowFrameMetricsManager;
    private static final long oneSecondInNanos = TimeUnit.SECONDS.toNanos(1);
    private static final long frozenFrameThresholdNanos = TimeUnit.MILLISECONDS.toNanos(700);

    public interface FrameMetricsCollectorListener {
        void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f);
    }

    public static boolean isSlow(long j, long j2) {
        return j > j2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public SentryFrameMetricsCollector(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        this(context, iLogger, buildInfoProvider, new WindowFrameMetricsManager() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector.2
        });
    }

    public SentryFrameMetricsCollector(Context context, final ILogger iLogger, final BuildInfoProvider buildInfoProvider, WindowFrameMetricsManager windowFrameMetricsManager) {
        this.trackedWindows = new CopyOnWriteArraySet();
        this.listenerMap = new ConcurrentHashMap();
        this.isAvailable = false;
        this.lastFrameStartNanos = 0L;
        this.lastFrameEndNanos = 0L;
        this.delayedFrames = new ConcurrentSkipListSet();
        Context context2 = (Context) Objects.requireNonNull(ContextUtils.getApplicationContext(context), "The context is required");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider, "BuildInfoProvider is required");
        this.windowFrameMetricsManager = (WindowFrameMetricsManager) Objects.requireNonNull(windowFrameMetricsManager, "WindowFrameMetricsManager is required");
        if ((context2 instanceof Application) && buildInfoProvider.getSdkInfoVersion() >= 24) {
            this.isAvailable = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$$ExternalSyntheticLambda2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    iLogger.log(SentryLevel.ERROR, "Error during frames measurements.", th);
                }
            });
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
            ((Application) context2).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SentryFrameMetricsCollector.m5189$r8$lambda$BWL7znkV40jiCXSZDlHSDa4mM(this.f$0, iLogger);
                }
            });
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.choreographerLastFrameTimeField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                iLogger.log(SentryLevel.ERROR, "Unable to get the frame timestamp from the choreographer: ", e);
            }
            this.frameMetricsAvailableListener = new Window.OnFrameMetricsAvailableListener() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$$ExternalSyntheticLambda4
                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                    SentryFrameMetricsCollector.m5191$r8$lambda$x7aqBYNpuiFNVBFXtznud7WNLU(this.f$0, buildInfoProvider, window, frameMetrics, i);
                }
            };
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$BWL7znkV40-jiCXSZDlH-SDa4mM, reason: not valid java name */
    public static /* synthetic */ void m5189$r8$lambda$BWL7znkV40jiCXSZDlHSDa4mM(SentryFrameMetricsCollector sentryFrameMetricsCollector, ILogger iLogger) {
        sentryFrameMetricsCollector.getClass();
        try {
            sentryFrameMetricsCollector.choreographer = Choreographer.getInstance();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x009d  */
    /* JADX INFO: renamed from: $r8$lambda$x7aqBYNpuiFNV-BFXtznud7WNLU, reason: not valid java name */
    public static /* synthetic */ void m5191$r8$lambda$x7aqBYNpuiFNVBFXtznud7WNLU(SentryFrameMetricsCollector sentryFrameMetricsCollector, BuildInfoProvider buildInfoProvider, Window window, FrameMetrics frameMetrics, int i) {
        float refreshRate;
        long j;
        sentryFrameMetricsCollector.getClass();
        long jNanoTime = System.nanoTime();
        if (buildInfoProvider.getSdkInfoVersion() >= 30) {
            refreshRate = window.getContext().getDisplay().getRefreshRate();
        } else {
            refreshRate = window.getWindowManager().getDefaultDisplay().getRefreshRate();
        }
        float f = refreshRate;
        float f2 = oneSecondInNanos;
        long frameCpuDuration = sentryFrameMetricsCollector.getFrameCpuDuration(frameMetrics);
        long jMax = Math.max(0L, frameCpuDuration - ((long) (f2 / f)));
        long frameStartTimestamp = sentryFrameMetricsCollector.getFrameStartTimestamp(frameMetrics);
        if (frameStartTimestamp < 0) {
            frameStartTimestamp = jNanoTime - frameCpuDuration;
        }
        long jMax2 = Math.max(frameStartTimestamp, sentryFrameMetricsCollector.lastFrameEndNanos);
        if (jMax2 == sentryFrameMetricsCollector.lastFrameStartNanos) {
            return;
        }
        sentryFrameMetricsCollector.lastFrameStartNanos = jMax2;
        sentryFrameMetricsCollector.lastFrameEndNanos = jMax2 + frameCpuDuration;
        boolean zIsSlow = isSlow(frameCpuDuration, (long) (f2 / (f - 1.0f)));
        boolean z = zIsSlow && isFrozen(frameCpuDuration);
        if (jMax > 0) {
            sentryFrameMetricsCollector.pruneOldFrames(sentryFrameMetricsCollector.lastFrameEndNanos);
            if (sentryFrameMetricsCollector.delayedFrames.size() < 3600) {
                j = jMax2;
                sentryFrameMetricsCollector.delayedFrames.add(new DelayedFrame(j, sentryFrameMetricsCollector.lastFrameEndNanos, jMax));
            } else {
                j = jMax2;
            }
        } else {
            j = jMax2;
        }
        Iterator it = sentryFrameMetricsCollector.listenerMap.values().iterator();
        while (it.hasNext()) {
            ((FrameMetricsCollectorListener) it.next()).onFrameMetricCollected(j, sentryFrameMetricsCollector.lastFrameEndNanos, frameCpuDuration, jMax, zIsSlow, z, f);
        }
    }

    public static boolean isFrozen(long j) {
        return j > frozenFrameThresholdNanos;
    }

    private long getFrameStartTimestamp(FrameMetrics frameMetrics) {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 26) {
            return frameMetrics.getMetric(10);
        }
        return getLastKnownFrameStartTimeNanos();
    }

    private long getFrameCpuDuration(FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        setCurrentWindow(activity.getWindow());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        stopTrackingWindow(activity.getWindow());
        WeakReference weakReference = this.currentWindow;
        if (weakReference == null || weakReference.get() != activity.getWindow()) {
            return;
        }
        this.currentWindow = null;
    }

    public String startCollection(FrameMetricsCollectorListener frameMetricsCollectorListener) {
        if (!this.isAvailable) {
            return null;
        }
        String strGenerateSentryId = SentryUUID.generateSentryId();
        this.listenerMap.put(strGenerateSentryId, frameMetricsCollectorListener);
        trackCurrentWindow();
        return strGenerateSentryId;
    }

    public void stopCollection(String str) {
        if (this.isAvailable) {
            if (str != null) {
                this.listenerMap.remove(str);
            }
            WeakReference weakReference = this.currentWindow;
            Window window = weakReference != null ? (Window) weakReference.get() : null;
            if (window == null || !this.listenerMap.isEmpty()) {
                return;
            }
            stopTrackingWindow(window);
        }
    }

    private void stopTrackingWindow(final Window window) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SentryFrameMetricsCollector.$r8$lambda$h9iPqdPeXOBztaT2WBOuVqsBhD0(this.f$0, window);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$h9iPqdPeXOBztaT2WBOuVqsBhD0(SentryFrameMetricsCollector sentryFrameMetricsCollector, Window window) {
        sentryFrameMetricsCollector.getClass();
        try {
            if (sentryFrameMetricsCollector.trackedWindows.remove(window)) {
                sentryFrameMetricsCollector.windowFrameMetricsManager.removeOnFrameMetricsAvailableListener(window, sentryFrameMetricsCollector.frameMetricsAvailableListener);
            }
        } catch (Throwable th) {
            sentryFrameMetricsCollector.logger.log(SentryLevel.ERROR, "Failed to remove frameMetricsAvailableListener", th);
        }
    }

    private void setCurrentWindow(Window window) {
        WeakReference weakReference = this.currentWindow;
        if (weakReference == null || weakReference.get() != window) {
            this.currentWindow = new WeakReference(window);
            trackCurrentWindow();
        }
    }

    private void trackCurrentWindow() {
        WeakReference weakReference = this.currentWindow;
        final Window window = weakReference != null ? (Window) weakReference.get() : null;
        if (window == null || !this.isAvailable || this.listenerMap.isEmpty() || this.handler == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.SentryFrameMetricsCollector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SentryFrameMetricsCollector.$r8$lambda$DhU76oBAN14gNLSMgUvf3lzaZcg(this.f$0, window);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$DhU76oBAN14gNLSMgUvf3lzaZcg(SentryFrameMetricsCollector sentryFrameMetricsCollector, Window window) {
        if (sentryFrameMetricsCollector.trackedWindows.add(window)) {
            try {
                sentryFrameMetricsCollector.windowFrameMetricsManager.addOnFrameMetricsAvailableListener(window, sentryFrameMetricsCollector.frameMetricsAvailableListener, sentryFrameMetricsCollector.handler);
            } catch (Throwable th) {
                sentryFrameMetricsCollector.logger.log(SentryLevel.ERROR, "Failed to add frameMetricsAvailableListener", th);
            }
        }
    }

    public long getLastKnownFrameStartTimeNanos() {
        Field field;
        Choreographer choreographer = this.choreographer;
        if (choreographer == null || (field = this.choreographerLastFrameTimeField) == null) {
            return -1L;
        }
        try {
            Long l = (Long) field.get(choreographer);
            if (l != null) {
                return l.longValue();
            }
            return -1L;
        } catch (IllegalAccessException unused) {
            return -1L;
        }
    }

    public SentryFramesDelayResult getFramesDelay(long j, long j2) {
        int i = 0;
        if (!this.isAvailable) {
            return new SentryFramesDelayResult(-1.0d, 0);
        }
        if (j2 <= j) {
            return new SentryFramesDelayResult(-1.0d, 0);
        }
        long j3 = 0;
        if (!this.delayedFrames.isEmpty()) {
            for (DelayedFrame delayedFrame : this.delayedFrames.tailSet(new DelayedFrame(j))) {
                if (delayedFrame.startNanos >= j2) {
                    break;
                }
                long j4 = delayedFrame.endNanos;
                long jMax = Math.max(j4 - delayedFrame.delayNanos, j);
                long jMin = Math.min(j4, j2);
                if (jMin > jMax) {
                    j3 += jMin - jMax;
                    i++;
                }
            }
        }
        return new SentryFramesDelayResult(j3 / 1.0E9d, i);
    }

    private void pruneOldFrames(long j) {
        this.delayedFrames.headSet(new DelayedFrame(j - 300000000000L)).clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DelayedFrame implements Comparable {
        final long delayNanos;
        final long endNanos;
        final long startNanos;

        DelayedFrame(long j) {
            this(j, j, 0L);
        }

        DelayedFrame(long j, long j2, long j3) {
            this.startNanos = j;
            this.endNanos = j2;
            this.delayNanos = j3;
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedFrame delayedFrame) {
            int iCompare = Long.compare(this.endNanos, delayedFrame.endNanos);
            return iCompare != 0 ? iCompare : Long.compare(this.startNanos, delayedFrame.startNanos);
        }
    }

    public interface WindowFrameMetricsManager {
        default void addOnFrameMetricsAvailableListener(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
            if (onFrameMetricsAvailableListener == null) {
                return;
            }
            window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
        }

        default void removeOnFrameMetricsAvailableListener(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
            if (onFrameMetricsAvailableListener == null) {
                return;
            }
            window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }
}
