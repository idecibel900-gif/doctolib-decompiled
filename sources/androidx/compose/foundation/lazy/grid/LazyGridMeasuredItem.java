package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection, i4, i5, list, j, obj2, lazyLayoutItemAnimator, j2, i6, i7);
    }

    private LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection, int i4, int i5, List list, long j, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, int i6, int i7) {
        long jIntSize;
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.reverseLayout = z2;
        this.layoutDirection = layoutDirection;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.visualOffset = j;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.lane = i6;
        this.span = i7;
        this.mainAxisLayoutSize = LinearLayoutManager.INVALID_OFFSET;
        int size = list.size();
        int iMax = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Placeable placeable = (Placeable) list.get(i8);
            iMax = Math.max(iMax, isVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = iMax;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i3 + iMax, 0);
        if (isVertical()) {
            jIntSize = IntSizeKt.IntSize(this.crossAxisSize, iMax);
        } else {
            jIntSize = IntSizeKt.IntSize(iMax, this.crossAxisSize);
        }
        this.size = jIntSize;
        this.offset = IntOffset.Companion.m2598getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo371getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int i) {
        return ((Placeable) this.placeables.get(i)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo390getSizeYbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo389getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getRow() {
        return this.row;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int getColumn() {
        return this.column;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo372getOffsetBjo55l4(int i) {
        return mo389getOffsetnOccac();
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int i, int i2, int i3, int i4) {
        position(i, i2, i3, i4, -1, -1);
    }

    public final void position(int i, int i2, int i3, int i4, int i5, int i6) {
        long jIntOffset;
        this.mainAxisLayoutSize = isVertical() ? i4 : i3;
        if (!isVertical()) {
            i3 = i4;
        }
        if (isVertical() && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (i3 - i2) - this.crossAxisSize;
        }
        if (isVertical()) {
            jIntOffset = IntOffsetKt.IntOffset(i2, i);
        } else {
            jIntOffset = IntOffsetKt.IntOffset(i, i2);
        }
        this.offset = jIntOffset;
        this.row = i5;
        this.column = i6;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    public final void applyScrollDelta(int i) {
        if (getNonScrollableItem()) {
            return;
        }
        long jMo389getOffsetnOccac = mo389getOffsetnOccac();
        int iM2591getXimpl = isVertical() ? IntOffset.m2591getXimpl(jMo389getOffsetnOccac) : IntOffset.m2591getXimpl(jMo389getOffsetnOccac) + i;
        boolean zIsVertical = isVertical();
        int iM2592getYimpl = IntOffset.m2592getYimpl(jMo389getOffsetnOccac);
        if (zIsVertical) {
            iM2592getYimpl += i;
        }
        this.offset = IntOffsetKt.IntOffset(iM2591getXimpl, iM2592getYimpl);
        int placeablesCount = getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            this.animator.getAnimation(getKey(), i2);
        }
    }

    public final void place(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        int iM2591getXimpl;
        int iM2592getYimpl;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int placeablesCount = getPlaceablesCount();
        int i = 0;
        while (i < placeablesCount) {
            Placeable placeable = (Placeable) this.placeables.get(i);
            getMainAxisSize(placeable);
            long jMo389getOffsetnOccac = mo389getOffsetnOccac();
            this.animator.getAnimation(getKey(), i);
            if (this.reverseLayout) {
                if (isVertical()) {
                    iM2591getXimpl = IntOffset.m2591getXimpl(jMo389getOffsetnOccac);
                } else {
                    iM2591getXimpl = (this.mainAxisLayoutSize - IntOffset.m2591getXimpl(jMo389getOffsetnOccac)) - getMainAxisSize(placeable);
                }
                if (isVertical()) {
                    iM2592getYimpl = (this.mainAxisLayoutSize - IntOffset.m2592getYimpl(jMo389getOffsetnOccac)) - getMainAxisSize(placeable);
                } else {
                    iM2592getYimpl = IntOffset.m2592getYimpl(jMo389getOffsetnOccac);
                }
                jMo389getOffsetnOccac = IntOffsetKt.IntOffset(iM2591getXimpl, iM2592getYimpl);
            }
            long jM2595plusqkQi6aY = IntOffset.m2595plusqkQi6aY(jMo389getOffsetnOccac, this.visualOffset);
            if (isVertical()) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.m1869placeWithLayeraW9wM$default(placementScope2, placeable, jM2595plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            } else {
                placementScope2 = placementScope;
                Placeable.PlacementScope.m1867placeRelativeWithLayeraW9wM$default(placementScope2, placeable, jM2595plusqkQi6aY, 0.0f, (Function1) null, 6, (Object) null);
            }
            i++;
            placementScope = placementScope2;
        }
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m395getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m2592getYimpl(j) : IntOffset.m2591getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }
}
