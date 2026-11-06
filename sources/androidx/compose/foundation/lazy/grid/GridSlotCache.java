package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class GridSlotCache implements LazyGridSlotsProvider {
    private long cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private float cachedDensity;
    private LazyGridSlots cachedSizes;
    private final Function2 calculation;

    public GridSlotCache(Function2 function2) {
        this.calculation = function2;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public LazyGridSlots mo386invoke0kLqBqw(Density density, long j) {
        if (this.cachedSizes != null && Constraints.m2524equalsimpl0(this.cachedConstraints, j) && this.cachedDensity == density.getDensity()) {
            LazyGridSlots lazyGridSlots = this.cachedSizes;
            Intrinsics.checkNotNull(lazyGridSlots);
            return lazyGridSlots;
        }
        this.cachedConstraints = j;
        this.cachedDensity = density.getDensity();
        LazyGridSlots lazyGridSlots2 = (LazyGridSlots) this.calculation.invoke(density, Constraints.m2519boximpl(j));
        this.cachedSizes = lazyGridSlots2;
        return lazyGridSlots2;
    }
}
