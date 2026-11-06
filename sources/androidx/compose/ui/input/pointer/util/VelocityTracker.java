package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class VelocityTracker {
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final VelocityTracker1D.Strategy strategy;
    private final VelocityTracker1D xVelocityTracker;
    private final VelocityTracker1D yVelocityTracker;

    public VelocityTracker() {
        VelocityTracker1D.Strategy strategy;
        if (VelocityTrackerKt.getVelocityTrackerStrategyUseImpulse()) {
            strategy = VelocityTracker1D.Strategy.Impulse;
        } else {
            strategy = VelocityTracker1D.Strategy.Lsq2;
        }
        this.strategy = strategy;
        boolean z = false;
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.xVelocityTracker = new VelocityTracker1D(z, strategy, i, defaultConstructorMarker);
        this.yVelocityTracker = new VelocityTracker1D(z, strategy, i, defaultConstructorMarker);
        this.currentPointerPositionAccumulator = Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name */
    public final long m1822getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    /* JADX INFO: renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m1823setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }

    public final long getLastMoveEventTimeStamp$ui_release() {
        return this.lastMoveEventTimeStamp;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long j) {
        this.lastMoveEventTimeStamp = j;
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m1820addPositionUv8p0NA(long j, long j2) {
        this.xVelocityTracker.addDataPoint(j, Offset.m1223getXimpl(j2));
        this.yVelocityTracker.addDataPoint(j, Offset.m1224getYimpl(j2));
    }

    /* JADX INFO: renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
    public final long m1821calculateVelocityAH228Gc(long j) {
        if (!(Velocity.m2648getXimpl(j) > 0.0f && Velocity.m2649getYimpl(j) > 0.0f)) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.m2654toStringimpl(j)));
        }
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.m2648getXimpl(j)), this.yVelocityTracker.calculateVelocity(Velocity.m2649getYimpl(j)));
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0L;
    }
}
