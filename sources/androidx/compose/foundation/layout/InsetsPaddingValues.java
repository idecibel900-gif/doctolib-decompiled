package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class InsetsPaddingValues implements PaddingValues {
    private final Density density;
    private final WindowInsets insets;

    public InsetsPaddingValues(WindowInsets windowInsets, Density density) {
        this.insets = windowInsets;
        this.density = density;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float mo295calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Density density = this.density;
        return density.mo228toDpu2uoSUM(this.insets.getLeft(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float mo297calculateTopPaddingD9Ej5fM() {
        Density density = this.density;
        return density.mo228toDpu2uoSUM(this.insets.getTop(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float mo296calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Density density = this.density;
        return density.mo228toDpu2uoSUM(this.insets.getRight(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float mo294calculateBottomPaddingD9Ej5fM() {
        Density density = this.density;
        return density.mo228toDpu2uoSUM(this.insets.getBottom(density));
    }

    public String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingValues)) {
            return false;
        }
        InsetsPaddingValues insetsPaddingValues = (InsetsPaddingValues) obj;
        return Intrinsics.areEqual(this.insets, insetsPaddingValues.insets) && Intrinsics.areEqual(this.density, insetsPaddingValues.density);
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + this.density.hashCode();
    }
}
