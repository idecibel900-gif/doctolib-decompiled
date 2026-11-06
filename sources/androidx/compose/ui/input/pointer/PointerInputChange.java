package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputChange {
    private List _historical;
    private ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, list, j6, j7);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.type = i;
        this.scrollDelta = j6;
        this.originalEventPosition = Offset.Companion.m1235getZeroF1C5BW0();
        this.consumed = new ConsumedData(z3, z3);
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m1776getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m1778getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* JADX INFO: renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name */
    public final long m1779getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? PointerType.Companion.m1807getTouchT8wyACA() : i, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? Offset.Companion.m1235getZeroF1C5BW0() : j6, null);
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m1781getTypeT8wyACA() {
        return this.type;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m1780getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6, null);
        this._historical = list;
        this.originalEventPosition = j7;
    }

    public final List getHistorical() {
        List list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name */
    public final long m1777getOriginalEventPositionF1C5BW0$ui_release() {
        return this.originalEventPosition;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    /* JADX INFO: renamed from: copy-OHpmEuE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m1773copyOHpmEuE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        long j8 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j9 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j10 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j11 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j12 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 128) != 0 ? pointerInputChange.type : i;
        if ((i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            j7 = pointerInputChange.scrollDelta;
            j8 = j8;
        } else {
            j7 = j6;
        }
        return pointerInputChange.m1774copyOHpmEuE(j8, j9, j10, z3, j11, j12, z4, i3, list, j7);
    }

    /* JADX INFO: renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m1774copyOHpmEuE(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6) {
        return m1775copywbzehF4(j, j2, j3, z, this.pressure, j4, j5, z2, i, list, j6);
    }

    /* JADX INFO: renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m1775copywbzehF4(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List list, long j6) {
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, f, j4, j5, z2, false, i, list, j6, this.originalEventPosition, null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m1771toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m1230toStringimpl(this.position)) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m1230toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.m1803toStringimpl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m1230toStringimpl(this.scrollDelta)) + ')';
    }
}
