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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m344setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m343setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m342setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m341setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m340getTargetConstraintsOenEA2s(Density density) {
        int iCoerceAtLeast;
        int iCoerceAtLeast2;
        float f = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i = 0;
        int iCoerceAtLeast3 = !Dp.m2553equalsimpl0(f, companion.m2560getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo225roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int iCoerceAtLeast4 = !Dp.m2553equalsimpl0(this.maxHeight, companion.m2560getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo225roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m2553equalsimpl0(this.minWidth, companion.m2560getUnspecifiedD9Ej5fM()) || (iCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo225roundToPx0680j_4(this.minWidth), iCoerceAtLeast3), 0)) == Integer.MAX_VALUE) {
            iCoerceAtLeast = 0;
        }
        if (!Dp.m2553equalsimpl0(this.minHeight, companion.m2560getUnspecifiedD9Ej5fM()) && (iCoerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo225roundToPx0680j_4(this.minHeight), iCoerceAtLeast4), 0)) != Integer.MAX_VALUE) {
            i = iCoerceAtLeast2;
        }
        return ConstraintsKt.Constraints(iCoerceAtLeast, iCoerceAtLeast3, i, iCoerceAtLeast4);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iCoerceAtMost;
        int iCoerceAtLeast;
        int iCoerceAtMost2;
        int iCoerceAtLeast2;
        long jConstraints;
        long jM340getTargetConstraintsOenEA2s = m340getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m2543constrainN9IONVI(j, jM340getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            if (!Dp.m2553equalsimpl0(f, companion.m2560getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost = Constraints.m2532getMinWidthimpl(jM340getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost = RangesKt.coerceAtMost(Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(jM340getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2553equalsimpl0(this.maxWidth, companion.m2560getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast = Constraints.m2530getMaxWidthimpl(jM340getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast = RangesKt.coerceAtLeast(Constraints.m2530getMaxWidthimpl(j), Constraints.m2532getMinWidthimpl(jM340getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2553equalsimpl0(this.minHeight, companion.m2560getUnspecifiedD9Ej5fM())) {
                iCoerceAtMost2 = Constraints.m2531getMinHeightimpl(jM340getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtMost2 = RangesKt.coerceAtMost(Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(jM340getTargetConstraintsOenEA2s));
            }
            if (!Dp.m2553equalsimpl0(this.maxHeight, companion.m2560getUnspecifiedD9Ej5fM())) {
                iCoerceAtLeast2 = Constraints.m2529getMaxHeightimpl(jM340getTargetConstraintsOenEA2s);
            } else {
                iCoerceAtLeast2 = RangesKt.coerceAtLeast(Constraints.m2529getMaxHeightimpl(j), Constraints.m2531getMinHeightimpl(jM340getTargetConstraintsOenEA2s));
            }
            jConstraints = ConstraintsKt.Constraints(iCoerceAtMost, iCoerceAtLeast, iCoerceAtMost2, iCoerceAtLeast2);
        }
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        long jM340getTargetConstraintsOenEA2s = m340getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2528getHasFixedWidthimpl(jM340getTargetConstraintsOenEA2s)) {
            return Constraints.m2530getMaxWidthimpl(jM340getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2545constrainWidthK40F9xA(jM340getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM340getTargetConstraintsOenEA2s = m340getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2527getHasFixedHeightimpl(jM340getTargetConstraintsOenEA2s)) {
            return Constraints.m2529getMaxHeightimpl(jM340getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2544constrainHeightK40F9xA(jM340getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM340getTargetConstraintsOenEA2s = m340getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2528getHasFixedWidthimpl(jM340getTargetConstraintsOenEA2s)) {
            return Constraints.m2530getMaxWidthimpl(jM340getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2545constrainWidthK40F9xA(jM340getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM340getTargetConstraintsOenEA2s = m340getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m2527getHasFixedHeightimpl(jM340getTargetConstraintsOenEA2s)) {
            return Constraints.m2529getMaxHeightimpl(jM340getTargetConstraintsOenEA2s);
        }
        return ConstraintsKt.m2544constrainHeightK40F9xA(jM340getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
