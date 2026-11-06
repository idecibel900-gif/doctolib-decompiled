package com.datadog.android.rum.internal.vitals;

import androidx.metrics.performance.FrameData;
import com.datadog.android.core.internal.system.BuildSdkVersionProvider;
import com.datadog.android.rum.internal.domain.FrameMetricsData;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FPSVitalListener implements FrameStateListener {
    public static final Companion Companion = new Companion(null);
    private static final double ONE_SECOND_NS = TimeUnit.SECONDS.toNanos(1);
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private double displayRefreshRate;
    private long frameDeadline;
    private double screenRefreshRate;
    private final VitalObserver vitalObserver;

    public FPSVitalListener(VitalObserver vitalObserver, BuildSdkVersionProvider buildSdkVersionProvider, double d) {
        Intrinsics.checkNotNullParameter(vitalObserver, "vitalObserver");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        this.vitalObserver = vitalObserver;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.screenRefreshRate = d;
        this.frameDeadline = 16666666L;
        this.displayRefreshRate = 60.0d;
    }

    public /* synthetic */ FPSVitalListener(VitalObserver vitalObserver, BuildSdkVersionProvider buildSdkVersionProvider, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vitalObserver, (i & 2) != 0 ? BuildSdkVersionProvider.Companion.getDEFAULT() : buildSdkVersionProvider, (i & 4) != 0 ? 60.0d : d);
    }

    @Override // androidx.metrics.performance.JankStats.OnFrameListener
    public void onFrame(FrameData volatileFrameData) {
        Intrinsics.checkNotNullParameter(volatileFrameData, "volatileFrameData");
        double frameDurationUiNanos = volatileFrameData.getFrameDurationUiNanos();
        if (frameDurationUiNanos > 0.0d) {
            double d = ONE_SECOND_NS;
            double d2 = d / frameDurationUiNanos;
            if (this.buildSdkVersionProvider.getVersion() >= 31) {
                this.screenRefreshRate = d / this.frameDeadline;
            } else if (this.buildSdkVersionProvider.getVersion() == 30) {
                this.screenRefreshRate = this.displayRefreshRate;
            }
            double dCoerceAtMost = RangesKt.coerceAtMost(d2 * (60.0d / this.screenRefreshRate), 60.0d);
            if (dCoerceAtMost > 1.0d) {
                this.vitalObserver.onNewSample(dCoerceAtMost);
            }
        }
    }

    @Override // com.datadog.android.rum.internal.vitals.FrameMetricsDataListener
    public void onFrameMetricsData(FrameMetricsData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.displayRefreshRate = data.getDisplayRefreshRate();
        if (this.buildSdkVersionProvider.getVersion() >= 31) {
            this.frameDeadline = data.getDeadline();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
