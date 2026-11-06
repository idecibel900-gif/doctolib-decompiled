package androidx.metrics.performance;

import android.os.Build;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class JankStats {
    public static final Companion Companion = new Companion(null);
    private final OnFrameListener frameListener;
    private final PerformanceMetricsState.Holder holder;
    private final JankStatsBaseImpl implementation;
    private boolean isTrackingEnabled;
    private float jankHeuristicMultiplier;

    public interface OnFrameListener {
        void onFrame(FrameData frameData);
    }

    public /* synthetic */ JankStats(Window window, OnFrameListener onFrameListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(window, onFrameListener);
    }

    private JankStats(Window window, OnFrameListener onFrameListener) {
        JankStatsBaseImpl jankStatsApi24Impl;
        this.frameListener = onFrameListener;
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            throw new IllegalStateException("window.peekDecorView() is null: JankStats can only be created with a Window that has a non-null DecorView");
        }
        this.holder = PerformanceMetricsState.Companion.create$metrics_performance_release(viewPeekDecorView);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            jankStatsApi24Impl = new JankStatsApi31Impl(this, viewPeekDecorView, window);
        } else if (i >= 26) {
            jankStatsApi24Impl = new JankStatsApi26Impl(this, viewPeekDecorView, window);
        } else {
            jankStatsApi24Impl = new JankStatsApi24Impl(this, viewPeekDecorView, window);
        }
        this.implementation = jankStatsApi24Impl;
        jankStatsApi24Impl.setupFrameTimer(true);
        this.isTrackingEnabled = true;
        this.jankHeuristicMultiplier = 2.0f;
    }

    public final boolean isTrackingEnabled() {
        return this.isTrackingEnabled;
    }

    public final void setTrackingEnabled(boolean z) {
        if (z != this.isTrackingEnabled) {
            this.implementation.setupFrameTimer(z);
            this.isTrackingEnabled = z;
        }
    }

    public final float getJankHeuristicMultiplier() {
        return this.jankHeuristicMultiplier;
    }

    public final void logFrameData$metrics_performance_release(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        this.frameListener.onFrame(volatileFrameData);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JankStats createAndTrack(Window window, OnFrameListener frameListener) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(frameListener, "frameListener");
            return new JankStats(window, frameListener, null);
        }
    }
}
