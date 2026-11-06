package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridMeasuredLineProvider {
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public abstract LazyGridMeasuredLine createLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List list, int i2);

    public LazyGridMeasuredLineProvider(boolean z, LazyGridSlots lazyGridSlots, int i, int i2, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        this.isVertical = z;
        this.slots = lazyGridSlots;
        this.gridItemsCount = i;
        this.spaceBetweenLines = i2;
        this.measuredItemProvider = lazyGridMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m397childConstraintsJhjzzOo$foundation_release(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = this.slots.getSizes()[i];
        } else {
            int i4 = (i2 + i) - 1;
            i3 = (this.slots.getPositions()[i4] + this.slots.getSizes()[i4]) - this.slots.getPositions()[i];
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i3, 0);
        if (this.isVertical) {
            return Constraints.Companion.m2541fixedWidthOenEA2s(iCoerceAtLeast);
        }
        return Constraints.Companion.m2540fixedHeightOenEA2s(iCoerceAtLeast);
    }

    public final int spanOf(int i) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return lazyGridSpanLayoutProvider.spanOf(i, lazyGridSpanLayoutProvider.getSlotsPerLine());
    }

    public final LazyGridMeasuredLine getAndMeasure(int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i);
        int size = lineConfiguration.getSpans().size();
        int i2 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int iM382getCurrentLineSpanimpl = GridItemSpan.m382getCurrentLineSpanimpl(((GridItemSpan) lineConfiguration.getSpans().get(i4)).m385unboximpl());
            LazyGridMeasuredItem lazyGridMeasuredItemM396getAndMeasurem8Kt_7k = this.measuredItemProvider.m396getAndMeasurem8Kt_7k(lineConfiguration.getFirstItemIndex() + i4, m397childConstraintsJhjzzOo$foundation_release(i3, iM382getCurrentLineSpanimpl), i3, iM382getCurrentLineSpanimpl, i2);
            i3 += iM382getCurrentLineSpanimpl;
            Unit unit = Unit.INSTANCE;
            lazyGridMeasuredItemArr[i4] = lazyGridMeasuredItemM396getAndMeasurem8Kt_7k;
        }
        return createLine(i, lazyGridMeasuredItemArr, lineConfiguration.getSpans(), i2);
    }
}
