package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        int iM356getAllowLeftInRtlJoeWqyM$foundation_layout_release;
        if (layoutDirection == LayoutDirection.Ltr) {
            iM356getAllowLeftInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m355getAllowLeftInLtrJoeWqyM$foundation_layout_release();
        } else {
            iM356getAllowLeftInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m356getAllowLeftInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m350hasAnybkgdKaI$foundation_layout_release(this.sides, iM356getAllowLeftInRtlJoeWqyM$foundation_layout_release)) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        if (WindowInsetsSides.m350hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m361getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        int iM358getAllowRightInRtlJoeWqyM$foundation_layout_release;
        if (layoutDirection == LayoutDirection.Ltr) {
            iM358getAllowRightInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m357getAllowRightInLtrJoeWqyM$foundation_layout_release();
        } else {
            iM358getAllowRightInRtlJoeWqyM$foundation_layout_release = WindowInsetsSides.Companion.m358getAllowRightInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m350hasAnybkgdKaI$foundation_layout_release(this.sides, iM358getAllowRightInRtlJoeWqyM$foundation_layout_release)) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        if (WindowInsetsSides.m350hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m359getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && WindowInsetsSides.m349equalsimpl0(this.sides, limitInsets.sides);
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m351hashCodeimpl(this.sides);
    }

    public String toString() {
        return '(' + this.insets + " only " + ((Object) WindowInsetsSides.m353toStringimpl(this.sides)) + ')';
    }
}
