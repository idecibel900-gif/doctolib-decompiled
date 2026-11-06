package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MotionEventAdapter {
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List pointers = new ArrayList();
    private int previousToolType = -1;
    private int previousSource = -1;

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionIndex;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, (z || i == actionIndex || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int i) {
        this.activeHoverIds.delete(i);
        this.motionEventToComposePointerIdMap.delete(i);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m1746getComposePointerId_I2yYro(int i) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.nextId;
            this.nextId = 1 + jValueAt;
            this.motionEventToComposePointerIdMap.put(i, jValueAt);
        }
        return PointerId.m1767constructorimpl(jValueAt);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int i, boolean z) {
        long jMo1810localToScreenMKHz9U;
        int iM1808getUnknownT8wyACA;
        long jM1235getZeroF1C5BW0;
        long jM1746getComposePointerId_I2yYro = m1746getComposePointerId_I2yYro(motionEvent.getPointerId(i));
        float pressure = motionEvent.getPressure(i);
        long jOffset = OffsetKt.Offset(motionEvent.getX(i), motionEvent.getY(i));
        long jM1217copydBAh8RU$default = Offset.m1217copydBAh8RU$default(jOffset, 0.0f, 0.0f, 3, null);
        if (i == 0) {
            jMo1810localToScreenMKHz9U = OffsetKt.Offset(motionEvent.getRawX(), motionEvent.getRawY());
            jOffset = positionCalculator.mo1811screenToLocalMKHz9U(jMo1810localToScreenMKHz9U);
        } else if (Build.VERSION.SDK_INT >= 29) {
            jMo1810localToScreenMKHz9U = MotionEventHelper.INSTANCE.m1747toRawOffsetdBAh8RU(motionEvent, i);
            jOffset = positionCalculator.mo1811screenToLocalMKHz9U(jMo1810localToScreenMKHz9U);
        } else {
            jMo1810localToScreenMKHz9U = positionCalculator.mo1810localToScreenMKHz9U(jOffset);
        }
        long j = jMo1810localToScreenMKHz9U;
        long j2 = jOffset;
        int toolType = motionEvent.getToolType(i);
        if (toolType == 0) {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1808getUnknownT8wyACA();
        } else if (toolType == 1) {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1807getTouchT8wyACA();
        } else if (toolType == 2) {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1806getStylusT8wyACA();
        } else if (toolType == 3) {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1805getMouseT8wyACA();
        } else if (toolType == 4) {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1804getEraserT8wyACA();
        } else {
            iM1808getUnknownT8wyACA = PointerType.Companion.m1808getUnknownT8wyACA();
        }
        int i2 = iM1808getUnknownT8wyACA;
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        int historySize = motionEvent.getHistorySize();
        for (int i3 = 0; i3 < historySize; i3++) {
            float historicalX = motionEvent.getHistoricalX(i, i3);
            float historicalY = motionEvent.getHistoricalY(i, i3);
            if (!Float.isInfinite(historicalX) && !Float.isNaN(historicalX) && !Float.isInfinite(historicalY) && !Float.isNaN(historicalY)) {
                long jOffset2 = OffsetKt.Offset(historicalX, historicalY);
                arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i3), jOffset2, jOffset2, null));
            }
        }
        if (motionEvent.getActionMasked() == 8) {
            jM1235getZeroF1C5BW0 = OffsetKt.Offset(motionEvent.getAxisValue(10), (-motionEvent.getAxisValue(9)) + 0.0f);
        } else {
            jM1235getZeroF1C5BW0 = Offset.Companion.m1235getZeroF1C5BW0();
        }
        return new PointerInputEventData(jM1746getComposePointerId_I2yYro, motionEvent.getEventTime(), j, j2, z, pressure, i2, this.activeHoverIds.get(motionEvent.getPointerId(i), false), arrayList, jM1235getZeroF1C5BW0, jM1217copydBAh8RU$default, null);
    }
}
