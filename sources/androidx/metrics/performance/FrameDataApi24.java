package androidx.metrics.performance;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class FrameDataApi24 extends FrameData {
    private long frameDurationCpuNanos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameDataApi24(long j, long j2, long j3, boolean z, List states) {
        super(j, j2, z, states);
        Intrinsics.checkNotNullParameter(states, "states");
        this.frameDurationCpuNanos = j3;
    }

    public final long getFrameDurationCpuNanos() {
        return this.frameDurationCpuNanos;
    }

    public final void update$metrics_performance_release(long j, long j2, long j3, boolean z) {
        super.update$metrics_performance_release(j, j2, z);
        this.frameDurationCpuNanos = j3;
    }

    @Override // androidx.metrics.performance.FrameData
    public boolean equals(Object obj) {
        return (obj instanceof FrameDataApi24) && super.equals(obj) && this.frameDurationCpuNanos == ((FrameDataApi24) obj).frameDurationCpuNanos;
    }

    @Override // androidx.metrics.performance.FrameData
    public int hashCode() {
        return (super.hashCode() * 31) + Long.hashCode(this.frameDurationCpuNanos);
    }

    @Override // androidx.metrics.performance.FrameData
    public String toString() {
        return "FrameData(frameStartNanos=" + getFrameStartNanos() + ", frameDurationUiNanos=" + getFrameDurationUiNanos() + ", frameDurationCpuNanos=" + this.frameDurationCpuNanos + ", isJank=" + isJank() + ", states=" + getStates() + ')';
    }
}
