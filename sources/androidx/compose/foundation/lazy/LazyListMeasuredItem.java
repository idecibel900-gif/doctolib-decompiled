package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2, lazyLayoutItemAnimator, j2);
    }

    private LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j2) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyLayoutItemAnimator;
        this.constraints = j2;
        this.span = 1;
        this.mainAxisLayoutSize = LinearLayoutManager.INVALID_OFFSET;
        int size = list.size();
        int height = 0;
        int iMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Placeable placeable = (Placeable) list.get(i5);
            height += isVertical() ? placeable.getHeight() : placeable.getWidth();
            iMax = Math.max(iMax, !isVertical() ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = height;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public long mo371getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int i) {
        return ((Placeable) this.placeables.get(i)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int i, int i2, int i3, int i4) {
        position(i, i3, i4);
    }

    public final void position(int i, int i2, int i3) {
        int width;
        this.offset = i;
        this.mainAxisLayoutSize = isVertical() ? i3 : i2;
        List list = this.placeables;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = (Placeable) list.get(i4);
            int i5 = i4 * 2;
            if (isVertical()) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true");
                }
                iArr[i5] = horizontal.align(placeable.getWidth(), i2, this.layoutDirection);
                this.placeableOffsets[i5 + 1] = i;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i5] = i;
                int i6 = i5 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false");
                }
                iArr2[i6] = vertical.align(placeable.getHeight(), i3);
                width = placeable.getWidth();
            }
            i += width;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void updateMainAxisLayoutSize(int i) {
        this.mainAxisLayoutSize = i;
        this.maxMainAxisOffset = i + this.afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public long mo372getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final void applyScrollDelta(int i, boolean z) {
        if (getNonScrollableItem()) {
            return;
        }
        this.offset = getOffset() + i;
        int length = this.placeableOffsets.length;
        for (int i2 = 0; i2 < length; i2++) {
            if ((isVertical() && i2 % 2 == 1) || (!isVertical() && i2 % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i2] = iArr[i2] + i;
            }
        }
        if (z) {
            int placeablesCount = getPlaceablesCount();
            for (int i3 = 0; i3 < placeablesCount; i3++) {
                this.animator.getAnimation(getKey(), i3);
            }
        }
    }

    public final void place(Placeable.PlacementScope placementScope, boolean z) {
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
            long jMo372getOffsetBjo55l4 = mo372getOffsetBjo55l4(i);
            this.animator.getAnimation(getKey(), i);
            if (this.reverseLayout) {
                if (isVertical()) {
                    iM2591getXimpl = IntOffset.m2591getXimpl(jMo372getOffsetBjo55l4);
                } else {
                    iM2591getXimpl = (this.mainAxisLayoutSize - IntOffset.m2591getXimpl(jMo372getOffsetBjo55l4)) - getMainAxisSize(placeable);
                }
                if (isVertical()) {
                    iM2592getYimpl = (this.mainAxisLayoutSize - IntOffset.m2592getYimpl(jMo372getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    iM2592getYimpl = IntOffset.m2592getYimpl(jMo372getOffsetBjo55l4);
                }
                jMo372getOffsetBjo55l4 = IntOffsetKt.IntOffset(iM2591getXimpl, iM2592getYimpl);
            }
            long jM2595plusqkQi6aY = IntOffset.m2595plusqkQi6aY(jMo372getOffsetBjo55l4, this.visualOffset);
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
    private final int m370getMainAxisgyyYBs(long j) {
        return isVertical() ? IntOffset.m2592getYimpl(j) : IntOffset.m2591getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return isVertical() ? placeable.getHeight() : placeable.getWidth();
    }
}
