package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;

/* JADX INFO: loaded from: classes.dex */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange = Offset.Companion.m1235getZeroF1C5BW0();

    public TouchSlopDetector(Orientation orientation) {
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m262mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1223getXimpl(j) : Offset.m1224getYimpl(j);
    }

    /* JADX INFO: renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m261crossAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1224getYimpl(j) : Offset.m1223getXimpl(j);
    }

    /* JADX INFO: renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m260addPointerInputChangeGcwITfU(PointerInputChange pointerInputChange, float f) {
        float fAbs;
        long jM1228plusMKHz9U = Offset.m1228plusMKHz9U(this.totalPositionChange, Offset.m1227minusMKHz9U(pointerInputChange.m1778getPositionF1C5BW0(), pointerInputChange.m1779getPreviousPositionF1C5BW0()));
        this.totalPositionChange = jM1228plusMKHz9U;
        if (this.orientation == null) {
            fAbs = Offset.m1221getDistanceimpl(jM1228plusMKHz9U);
        } else {
            fAbs = Math.abs(m262mainAxisk4lQ0M(jM1228plusMKHz9U));
        }
        if (fAbs >= f) {
            return Offset.m1214boximpl(m259calculatePostSlopOffsettuRUvjQ(f));
        }
        return null;
    }

    public final void reset() {
        this.totalPositionChange = Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m259calculatePostSlopOffsettuRUvjQ(float f) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m1227minusMKHz9U(this.totalPositionChange, Offset.m1229timestuRUvjQ(Offset.m1218divtuRUvjQ(j, Offset.m1221getDistanceimpl(j)), f));
        }
        float fM262mainAxisk4lQ0M = m262mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m262mainAxisk4lQ0M(this.totalPositionChange)) * f);
        float fM261crossAxisk4lQ0M = m261crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(fM262mainAxisk4lQ0M, fM261crossAxisk4lQ0M);
        }
        return OffsetKt.Offset(fM261crossAxisk4lQ0M, fM262mainAxisk4lQ0M);
    }
}
