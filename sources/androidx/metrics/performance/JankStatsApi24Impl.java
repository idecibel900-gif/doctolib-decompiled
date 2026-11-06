package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class JankStatsApi24Impl extends JankStatsApi16Impl {
    private final FrameDataApi24 frameData;
    private final Window.OnFrameMetricsAvailableListener frameMetricsAvailableListenerDelegate;
    private long listenerAddedTime;
    private long prevEnd;
    private long prevStart;
    private final Window window;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi24Impl(final JankStats jankStats, View view, Window window) {
        super(jankStats, view);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
        this.window = window;
        this.frameData = new FrameDataApi24(0L, 0L, 0L, false, getStateInfo());
        this.frameMetricsAvailableListenerDelegate = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.metrics.performance.JankStatsApi24Impl$$ExternalSyntheticLambda1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window2, FrameMetrics frameMetrics, int i) {
                JankStatsApi24Impl.frameMetricsAvailableListenerDelegate$lambda$0(this.f$0, jankStats, window2, frameMetrics, i);
            }
        };
    }

    public final long getPrevEnd() {
        return this.prevEnd;
    }

    public final void setPrevEnd(long j) {
        this.prevEnd = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void frameMetricsAvailableListenerDelegate$lambda$0(JankStatsApi24Impl jankStatsApi24Impl, JankStats jankStats, Window window, FrameMetrics frameMetrics, int i) {
        Intrinsics.checkNotNullExpressionValue(frameMetrics, "frameMetrics");
        long jMax = Math.max(jankStatsApi24Impl.getFrameStartTime$metrics_performance_release(frameMetrics), jankStatsApi24Impl.prevEnd);
        if (jMax < jankStatsApi24Impl.listenerAddedTime || jMax == jankStatsApi24Impl.prevStart) {
            return;
        }
        jankStats.logFrameData$metrics_performance_release(jankStatsApi24Impl.getFrameData$metrics_performance_release(jMax, (long) (jankStatsApi24Impl.getExpectedFrameDuration(frameMetrics) * jankStats.getJankHeuristicMultiplier()), frameMetrics));
        jankStatsApi24Impl.prevStart = jMax;
    }

    public FrameDataApi24 getFrameData$metrics_performance_release(long j, long j2, FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        long metric = frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
        this.prevEnd = j + metric;
        PerformanceMetricsState state = getMetricsStateHolder().getState();
        if (state != null) {
            state.getIntervalStates$metrics_performance_release(j, this.prevEnd, getStateInfo());
        }
        this.frameData.update$metrics_performance_release(j, metric, frameMetrics.getMetric(8), metric > j2);
        return this.frameData;
    }

    public long getFrameStartTime$metrics_performance_release(FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        return getFrameStartTime$metrics_performance_release();
    }

    public long getExpectedFrameDuration(FrameMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return getExpectedFrameDuration((View) getDecorViewRef$metrics_performance_release().get());
    }

    @Override // androidx.metrics.performance.JankStatsBaseImpl
    public void setupFrameTimer(final boolean z) {
        this.window.getDecorView().post(new Runnable() { // from class: androidx.metrics.performance.JankStatsApi24Impl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                JankStatsApi24Impl.setupFrameTimer$lambda$1(z, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFrameTimer$lambda$1(boolean z, JankStatsApi24Impl jankStatsApi24Impl) {
        if (!z) {
            DelegatingFrameMetricsListener.Companion.removeDelegateFromWindow(jankStatsApi24Impl.window, jankStatsApi24Impl.frameMetricsAvailableListenerDelegate);
            jankStatsApi24Impl.listenerAddedTime = 0L;
        } else if (jankStatsApi24Impl.listenerAddedTime == 0) {
            DelegatingFrameMetricsListener.Companion.addDelegateToWindow(jankStatsApi24Impl.window, jankStatsApi24Impl.frameMetricsAvailableListenerDelegate);
            jankStatsApi24Impl.listenerAddedTime = System.nanoTime();
        }
    }
}
