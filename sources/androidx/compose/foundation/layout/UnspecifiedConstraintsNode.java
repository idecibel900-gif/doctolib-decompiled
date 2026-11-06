package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m346setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m345setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM2532getMinWidthimpl;
        int iM2531getMinHeightimpl;
        float f = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        if (!Dp.m2553equalsimpl0(f, companion.m2560getUnspecifiedD9Ej5fM()) && Constraints.m2532getMinWidthimpl(j) == 0) {
            iM2532getMinWidthimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo225roundToPx0680j_4(this.minWidth), Constraints.m2530getMaxWidthimpl(j)), 0);
        } else {
            iM2532getMinWidthimpl = Constraints.m2532getMinWidthimpl(j);
        }
        int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
        if (!Dp.m2553equalsimpl0(this.minHeight, companion.m2560getUnspecifiedD9Ej5fM()) && Constraints.m2531getMinHeightimpl(j) == 0) {
            iM2531getMinHeightimpl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo225roundToPx0680j_4(this.minHeight), Constraints.m2529getMaxHeightimpl(j)), 0);
        } else {
            iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
        }
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.Constraints(iM2532getMinWidthimpl, iM2530getMaxWidthimpl, iM2531getMinHeightimpl, Constraints.m2529getMaxHeightimpl(j)));
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !Dp.m2553equalsimpl0(this.minWidth, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo225roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !Dp.m2553equalsimpl0(this.minWidth, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo225roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !Dp.m2553equalsimpl0(this.minHeight, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo225roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !Dp.m2553equalsimpl0(this.minHeight, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo225roundToPx0680j_4(this.minHeight) : 0);
    }
}
