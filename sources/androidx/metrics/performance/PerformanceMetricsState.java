package androidx.metrics.performance;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PerformanceMetricsState {
    public static final Companion Companion = new Companion(null);
    private List singleFrameStates;
    private final List stateDataPool;
    private List states;
    private final List statesHolder;
    private final List statesToBeCleared;

    public /* synthetic */ PerformanceMetricsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PerformanceMetricsState() {
        this.states = new ArrayList();
        this.singleFrameStates = new ArrayList();
        this.statesHolder = new ArrayList();
        this.statesToBeCleared = new ArrayList();
        this.stateDataPool = new ArrayList();
    }

    private final void addFrameState(long j, long j2, List list, List list2) {
        int size = list2.size() - 1;
        if (size >= 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list2.get(size));
            throw null;
        }
        if (this.statesHolder.size() > 0) {
            int size2 = this.statesHolder.size();
            for (int i = 0; i < size2; i++) {
                if (!this.statesToBeCleared.contains(Integer.valueOf(i))) {
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.statesHolder.get(i));
                    int i2 = i + 1;
                    if (i2 < this.statesHolder.size()) {
                        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.statesHolder.get(i2));
                        throw null;
                    }
                }
            }
            for (int size3 = this.statesToBeCleared.size() - 1; -1 < size3; size3--) {
                this.statesHolder.remove(((Number) this.statesToBeCleared.get(size3)).intValue());
            }
            if (this.statesHolder.size() > 0) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.statesHolder.get(0));
                throw null;
            }
            this.statesHolder.clear();
            this.statesToBeCleared.clear();
        }
    }

    public final void getIntervalStates$metrics_performance_release(long j, long j2, List frameStates) {
        Intrinsics.checkNotNullParameter(frameStates, "frameStates");
        synchronized (this.singleFrameStates) {
            frameStates.clear();
            addFrameState(j, j2, frameStates, this.states);
            addFrameState(j, j2, frameStates, this.singleFrameStates);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Holder getHolderForHierarchy(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View rootView = view.getRootView();
            Object tag = rootView.getTag(R$id.metricsStateHolder);
            if (tag == null) {
                tag = new Holder();
                rootView.setTag(R$id.metricsStateHolder, tag);
            }
            return (Holder) tag;
        }

        public final Holder create$metrics_performance_release(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Holder holderForHierarchy = getHolderForHierarchy(view);
            if (holderForHierarchy.getState() == null) {
                holderForHierarchy.setState$metrics_performance_release(new PerformanceMetricsState(null));
            }
            return holderForHierarchy;
        }
    }

    public static final class Holder {
        private PerformanceMetricsState state;

        public final PerformanceMetricsState getState() {
            return this.state;
        }

        public final void setState$metrics_performance_release(PerformanceMetricsState performanceMetricsState) {
            this.state = performanceMetricsState;
        }
    }
}
