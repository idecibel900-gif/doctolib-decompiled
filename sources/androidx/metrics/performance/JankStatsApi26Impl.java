package androidx.metrics.performance;

import android.view.FrameMetrics;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class JankStatsApi26Impl extends JankStatsApi24Impl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JankStatsApi26Impl(JankStats jankStats, View view, Window window) {
        super(jankStats, view, window);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(window, "window");
    }

    @Override // androidx.metrics.performance.JankStatsApi24Impl
    public long getFrameStartTime$metrics_performance_release(FrameMetrics frameMetrics) {
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        return frameMetrics.getMetric(10);
    }
}
