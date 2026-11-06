package androidx.metrics.performance;

import android.view.Choreographer;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class JankStatsApi16Impl extends JankStatsBaseImpl {
    private final Choreographer choreographer;
    private final WeakReference decorViewRef;
    private final FrameData frameData;
    private final PerformanceMetricsState.Holder metricsStateHolder;
    private final JankStatsApi16Impl$onFrameListenerDelegate$1 onFrameListenerDelegate;
    private final List stateInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.metrics.performance.JankStatsApi16Impl$onFrameListenerDelegate$1] */
    public JankStatsApi16Impl(final JankStats jankStats, View view) {
        super(jankStats);
        Intrinsics.checkNotNullParameter(jankStats, "jankStats");
        Intrinsics.checkNotNullParameter(view, "view");
        this.decorViewRef = new WeakReference(view);
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        this.choreographer = choreographer;
        this.metricsStateHolder = PerformanceMetricsState.Companion.getHolderForHierarchy(view);
        ArrayList arrayList = new ArrayList();
        this.stateInfo = arrayList;
        this.frameData = new FrameData(0L, 0L, false, arrayList);
        this.onFrameListenerDelegate = new OnFrameListenerDelegate() { // from class: androidx.metrics.performance.JankStatsApi16Impl$onFrameListenerDelegate$1
        };
    }

    public final WeakReference getDecorViewRef$metrics_performance_release() {
        return this.decorViewRef;
    }

    public final PerformanceMetricsState.Holder getMetricsStateHolder() {
        return this.metricsStateHolder;
    }

    public final List getStateInfo() {
        return this.stateInfo;
    }

    public final long getFrameStartTime$metrics_performance_release() throws IllegalAccessException {
        Object obj = DelegatingOnPreDrawListener.Companion.getChoreographerLastFrameTimeField().get(this.choreographer);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    public final long getExpectedFrameDuration(View view) {
        return DelegatingOnPreDrawListener.Companion.getExpectedFrameDuration(view);
    }
}
