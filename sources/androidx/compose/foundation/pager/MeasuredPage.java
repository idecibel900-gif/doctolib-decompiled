package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class MeasuredPage implements PageInfo {
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, list, j, obj, orientation, horizontal, vertical, layoutDirection, z);
    }

    private MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z) {
        this.index = i;
        this.size = i2;
        this.placeables = list;
        this.visualOffset = j;
        this.key = obj;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z;
        this.isVertical = orientation == Orientation.Vertical;
        int size = list.size();
        int iMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            iMax = Math.max(iMax, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.crossAxisSize = iMax;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = LinearLayoutManager.INVALID_OFFSET;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    public Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final void position(int i, int i2, int i3) {
        int width;
        this.offset = i;
        this.mainAxisLayoutSize = this.isVertical ? i3 : i2;
        List list = this.placeables;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = (Placeable) list.get(i4);
            int i5 = i4 * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalAlignment");
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
                    throw new IllegalArgumentException("null verticalAlignment");
                }
                iArr2[i6] = vertical.align(placeable.getHeight(), i3);
                width = placeable.getWidth();
            }
            i += width;
        }
    }

    public final void place(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        int iM2591getXimpl;
        int iM2592getYimpl;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first");
        }
        int size = this.placeables.size();
        int i = 0;
        while (i < size) {
            Placeable placeable = (Placeable) this.placeables.get(i);
            long jM435getOffsetBjo55l4 = m435getOffsetBjo55l4(i);
            if (this.reverseLayout) {
                if (this.isVertical) {
                    iM2591getXimpl = IntOffset.m2591getXimpl(jM435getOffsetBjo55l4);
                } else {
                    iM2591getXimpl = (this.mainAxisLayoutSize - IntOffset.m2591getXimpl(jM435getOffsetBjo55l4)) - getMainAxisSize(placeable);
                }
                if (this.isVertical) {
                    iM2592getYimpl = (this.mainAxisLayoutSize - IntOffset.m2592getYimpl(jM435getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    iM2592getYimpl = IntOffset.m2592getYimpl(jM435getOffsetBjo55l4);
                }
                jM435getOffsetBjo55l4 = IntOffsetKt.IntOffset(iM2591getXimpl, iM2592getYimpl);
            }
            long jM2595plusqkQi6aY = IntOffset.m2595plusqkQi6aY(jM435getOffsetBjo55l4, this.visualOffset);
            if (this.isVertical) {
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

    public final void applyScrollDelta(int i) {
        this.offset = getOffset() + i;
        int length = this.placeableOffsets.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolean z = this.isVertical;
            if ((z && i2 % 2 == 1) || (!z && i2 % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i2] = iArr[i2] + i;
            }
        }
    }

    /* JADX INFO: renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m435getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
