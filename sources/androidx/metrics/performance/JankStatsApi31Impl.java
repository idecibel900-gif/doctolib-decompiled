package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class JankStatsApi31Impl extends JankStatsApi26Impl {
    private final FrameDataApi31 frameData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi31Impl(JankStats jankStats, View view, Window window) {
        super(jankStats, view, window);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
        this.frameData = new FrameDataApi31(0L, 0L, 0L, 0L, 0L, false, getStateInfo());
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public FrameDataApi31 getFrameData$metrics_performance_release(long j, long j2, FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        long metric = frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
        setPrevEnd(j + metric);
        PerformanceMetricsState state = getMetricsStateHolder().getState();
        if (state != null) {
            state.getIntervalStates$metrics_performance_release(j, getPrevEnd(), getStateInfo());
        }
        boolean z = metric > j2;
        long metric2 = frameMetrics.getMetric(8);
        this.frameData.update$metrics_performance_release(j, metric, (metric2 - frameMetrics.getMetric(12)) + frameMetrics.getMetric(7), metric2, metric2 - frameMetrics.getMetric(13), z);
        return this.frameData;
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public long getExpectedFrameDuration(FrameMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return metrics.getMetric(13);
    }
}
