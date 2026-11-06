package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasuredLine {
    private final int index;
    private final boolean isVertical;
    private final LazyGridMeasuredItem[] items;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final LazyGridSlots slots;
    private final List spans;

    public LazyGridMeasuredLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, LazyGridSlots lazyGridSlots, List list, boolean z, int i2) {
        this.index = i;
        this.items = lazyGridMeasuredItemArr;
        this.slots = lazyGridSlots;
        this.spans = list;
        this.isVertical = z;
        this.mainAxisSpacing = i2;
        int iMax = 0;
        for (LazyGridMeasuredItem lazyGridMeasuredItem : lazyGridMeasuredItemArr) {
            iMax = Math.max(iMax, lazyGridMeasuredItem.getMainAxisSize());
        }
        this.mainAxisSize = iMax;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(iMax + this.mainAxisSpacing, 0);
    }

    public final int getIndex() {
        return this.index;
    }

    public final LazyGridMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        return this.items.length == 0;
    }

    public final LazyGridMeasuredItem[] position(int i, int i2, int i3) {
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = this.items;
        int length = lazyGridMeasuredItemArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            LazyGridMeasuredItem lazyGridMeasuredItem = lazyGridMeasuredItemArr[i4];
            int i7 = i5 + 1;
            int iM382getCurrentLineSpanimpl = GridItemSpan.m382getCurrentLineSpanimpl(((GridItemSpan) this.spans.get(i5)).m385unboximpl());
            int i8 = this.slots.getPositions()[i6];
            boolean z = this.isVertical;
            lazyGridMeasuredItem.position(i, i8, i2, i3, z ? this.index : i6, z ? i6 : this.index);
            Unit unit = Unit.INSTANCE;
            i6 += iM382getCurrentLineSpanimpl;
            i4++;
            i5 = i7;
        }
        return this.items;
    }
}
