package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridMeasuredItemProvider implements LazyLayoutMeasuredItemProvider {
    private final int defaultMainAxisSpacing;
    private final LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    /* JADX INFO: renamed from: createItem-O3s9Psw */
    public abstract LazyGridMeasuredItem mo392createItemO3s9Psw(int i, Object obj, Object obj2, int i2, int i3, List list, long j, int i4, int i5);

    public LazyGridMeasuredItemProvider(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        this.itemProvider = lazyGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.defaultMainAxisSpacing = i;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public LazyGridMeasuredItem mo374getAndMeasurehBUhpc(int i, int i2, int i3, long j) {
        return m396getAndMeasurem8Kt_7k(i, j, i2, i3, this.defaultMainAxisSpacing);
    }

    /* JADX INFO: renamed from: getAndMeasure-m8Kt_7k, reason: not valid java name */
    public final LazyGridMeasuredItem m396getAndMeasurem8Kt_7k(int i, long j, int i2, int i3, int i4) {
        int iM2531getMinHeightimpl;
        Object key = this.itemProvider.getKey(i);
        Object contentType = this.itemProvider.getContentType(i);
        List listMo420measure0kLqBqw = this.measureScope.mo420measure0kLqBqw(i, j);
        if (Constraints.m2528getHasFixedWidthimpl(j)) {
            iM2531getMinHeightimpl = Constraints.m2532getMinWidthimpl(j);
        } else {
            if (!Constraints.m2527getHasFixedHeightimpl(j)) {
                throw new IllegalArgumentException("does not have fixed height");
            }
            iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
        }
        return mo392createItemO3s9Psw(i, key, contentType, iM2531getMinHeightimpl, i4, listMo420measure0kLqBqw, j, i2, i3);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
