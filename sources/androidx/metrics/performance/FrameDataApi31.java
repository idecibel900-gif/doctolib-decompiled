package androidx.metrics.performance;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FrameDataApi31 extends FrameDataApi24 {
    private long frameDurationTotalNanos;
    private long frameOverrunNanos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameDataApi31(long j, long j2, long j3, long j4, long j5, boolean z, List states) {
        super(j, j2, j3, z, states);
        Intrinsics.checkNotNullParameter(states, "states");
        this.frameDurationTotalNanos = j4;
        this.frameOverrunNanos = j5;
    }

    public final void update$metrics_performance_release(long j, long j2, long j3, long j4, long j5, boolean z) {
        super.update$metrics_performance_release(j, j2, j3, z);
        this.frameDurationTotalNanos = j4;
        this.frameOverrunNanos = j5;
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public boolean equals(Object obj) {
        if (!(obj instanceof FrameDataApi31) || !super.equals(obj)) {
            return false;
        }
        FrameDataApi31 frameDataApi31 = (FrameDataApi31) obj;
        return this.frameDurationTotalNanos == frameDataApi31.frameDurationTotalNanos && this.frameOverrunNanos == frameDataApi31.frameOverrunNanos;
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public int hashCode() {
        return (super.hashCode() * 31) + (Long.hashCode(this.frameDurationTotalNanos) * 31) + Long.hashCode(this.frameOverrunNanos);
    }

    @Override // androidx.metrics.performance.FrameDataApi24, androidx.metrics.performance.FrameData
    public String toString() {
        return "FrameData(frameStartNanos=" + getFrameStartNanos() + ", frameDurationUiNanos=" + getFrameDurationUiNanos() + ", frameDurationCpuNanos=" + getFrameDurationCpuNanos() + ", frameDurationTotalNanos=" + this.frameDurationTotalNanos + ", frameOverrunNanos=" + this.frameOverrunNanos + ", isJank=" + isJank() + ", states=" + getStates() + ')';
    }
}
