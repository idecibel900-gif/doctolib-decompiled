package androidx.metrics.performance;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class FrameData {
    private long frameDurationUiNanos;
    private long frameStartNanos;
    private boolean isJank;
    private final List states;

    public FrameData(long j, long j2, boolean z, List states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.states = states;
        this.frameStartNanos = j;
        this.frameDurationUiNanos = j2;
        this.isJank = z;
    }

    public final List getStates() {
        return this.states;
    }

    public final long getFrameStartNanos() {
        return this.frameStartNanos;
    }

    public final long getFrameDurationUiNanos() {
        return this.frameDurationUiNanos;
    }

    public final boolean isJank() {
        return this.isJank;
    }

    public final void update$metrics_performance_release(long j, long j2, boolean z) {
        this.frameStartNanos = j;
        this.frameDurationUiNanos = j2;
        this.isJank = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.metrics.performance.FrameData");
        FrameData frameData = (FrameData) obj;
        return this.frameStartNanos == frameData.frameStartNanos && this.frameDurationUiNanos == frameData.frameDurationUiNanos && this.isJank == frameData.isJank && Intrinsics.areEqual(this.states, frameData.states);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.frameStartNanos) * 31) + Long.hashCode(this.frameDurationUiNanos)) * 31) + Boolean.hashCode(this.isJank)) * 31) + this.states.hashCode();
    }

    public String toString() {
        return "FrameData(frameStartNanos=" + this.frameStartNanos + ", frameDurationUiNanos=" + this.frameDurationUiNanos + ", isJank=" + this.isJank + ", states=" + this.states + ')';
    }
}
