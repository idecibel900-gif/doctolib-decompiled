package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;

/* JADX INFO: loaded from: classes.dex */
public abstract class PointerEventKt {
    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !Offset.m1220equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m1235getZeroF1C5BW0());
    }

    public static final long positionChange(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        return (z || !pointerInputChange.isConsumed()) ? Offset.m1227minusMKHz9U(pointerInputChange.m1778getPositionF1C5BW0(), pointerInputChange.m1779getPreviousPositionF1C5BW0()) : Offset.Companion.m1235getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m1753isOutOfBoundsO0kMr_c(PointerInputChange pointerInputChange, long j) {
        long jM1778getPositionF1C5BW0 = pointerInputChange.m1778getPositionF1C5BW0();
        float fM1223getXimpl = Offset.m1223getXimpl(jM1778getPositionF1C5BW0);
        float fM1224getYimpl = Offset.m1224getYimpl(jM1778getPositionF1C5BW0);
        return fM1223getXimpl < 0.0f || fM1223getXimpl > ((float) IntSize.m2609getWidthimpl(j)) || fM1224getYimpl < 0.0f || fM1224getYimpl > ((float) IntSize.m2608getHeightimpl(j));
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m1754isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        if (!PointerType.m1801equalsimpl0(pointerInputChange.m1781getTypeT8wyACA(), PointerType.Companion.m1807getTouchT8wyACA())) {
            return m1753isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long jM1778getPositionF1C5BW0 = pointerInputChange.m1778getPositionF1C5BW0();
        float fM1223getXimpl = Offset.m1223getXimpl(jM1778getPositionF1C5BW0);
        float fM1224getYimpl = Offset.m1224getYimpl(jM1778getPositionF1C5BW0);
        return fM1223getXimpl < (-Size.m1261getWidthimpl(j2)) || fM1223getXimpl > ((float) IntSize.m2609getWidthimpl(j)) + Size.m1261getWidthimpl(j2) || fM1224getYimpl < (-Size.m1259getHeightimpl(j2)) || fM1224getYimpl > ((float) IntSize.m2608getHeightimpl(j)) + Size.m1259getHeightimpl(j2);
    }
}
