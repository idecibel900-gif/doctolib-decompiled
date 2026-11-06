package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListMeasuredItemProvider implements LazyLayoutMeasuredItemProvider {
    private final long childConstraints;
    private final LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    public /* synthetic */ LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, lazyListItemProvider, lazyLayoutMeasureScope);
    }

    /* JADX INFO: renamed from: createItem-X9ElhV4 */
    public abstract LazyListMeasuredItem mo366createItemX9ElhV4(int i, Object obj, Object obj2, List list, long j);

    private LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope) {
        this.itemProvider = lazyListItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m2530getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, z ? Integer.MAX_VALUE : Constraints.m2529getMaxHeightimpl(j), 5, null);
    }

    /* JADX INFO: renamed from: getChildConstraints-msEJaDk, reason: not valid java name */
    public final long m376getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc, reason: not valid java name */
    public LazyListMeasuredItem mo374getAndMeasurehBUhpc(int i, int i2, int i3, long j) {
        return m375getAndMeasure0kLqBqw(i, j);
    }

    /* JADX INFO: renamed from: getAndMeasure-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ LazyListMeasuredItem m373getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
        }
        if ((i2 & 2) != 0) {
            j = lazyListMeasuredItemProvider.childConstraints;
        }
        return lazyListMeasuredItemProvider.m375getAndMeasure0kLqBqw(i, j);
    }

    /* JADX INFO: renamed from: getAndMeasure-0kLqBqw, reason: not valid java name */
    public final LazyListMeasuredItem m375getAndMeasure0kLqBqw(int i, long j) {
        return mo366createItemX9ElhV4(i, this.itemProvider.getKey(i), this.itemProvider.getContentType(i), this.measureScope.mo420measure0kLqBqw(i, j), j);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
