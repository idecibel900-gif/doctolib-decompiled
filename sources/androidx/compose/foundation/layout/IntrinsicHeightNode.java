package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;

/* JADX INFO: loaded from: classes.dex */
final class IntrinsicHeightNode extends IntrinsicSizeModifier {
    private boolean enforceIncoming;
    private IntrinsicSize height;

    public final void setHeight(IntrinsicSize intrinsicSize) {
        this.height = intrinsicSize;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    public boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    public IntrinsicHeightNode(IntrinsicSize intrinsicSize, boolean z) {
        this.height = intrinsicSize;
        this.enforceIncoming = z;
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    public long mo298calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j) {
        int iMaxIntrinsicHeight;
        if (this.height == IntrinsicSize.Min) {
            iMaxIntrinsicHeight = measurable.minIntrinsicHeight(Constraints.m2530getMaxWidthimpl(j));
        } else {
            iMaxIntrinsicHeight = measurable.maxIntrinsicHeight(Constraints.m2530getMaxWidthimpl(j));
        }
        if (iMaxIntrinsicHeight < 0) {
            iMaxIntrinsicHeight = 0;
        }
        return Constraints.Companion.m2540fixedHeightOenEA2s(iMaxIntrinsicHeight);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.height == IntrinsicSize.Min ? intrinsicMeasurable.minIntrinsicHeight(i) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return this.height == IntrinsicSize.Min ? intrinsicMeasurable.minIntrinsicHeight(i) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }
}
